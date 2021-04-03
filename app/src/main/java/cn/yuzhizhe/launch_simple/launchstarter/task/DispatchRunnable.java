package cn.yuzhizhe.launch_simple.launchstarter.task;

import android.os.Looper;
import android.os.Process;

import androidx.core.os.TraceCompat;

import cn.yuzhizhe.launch_simple.launchstarter.TaskDispatcher;
import cn.yuzhizhe.launch_simple.launchstarter.stat.TaskStat;
import cn.yuzhizhe.launch_simple.launchstarter.utils.DispatcherLog;

/**
 * @ProjectName: Launch_Simple
 * @Package: cn.yuzhizhe.launch_simple.launchstarter.task
 * @ClassName: DispatchRunnable
 * @Description: 类作用描述:
 * @Author: yuzhizhe
 * @CreateDate: 2021/4/3 11:03
 * @Version: 1.0
 * *******************************
 * @UpdateUser: 无
 * @UpdateDate: 无
 * @UpdateRemark: 无
 */
public class DispatchRunnable implements Runnable{
    private Task mTask;
    private TaskDispatcher mTaskDispatcher;

    public DispatchRunnable(Task task) {
        this.mTask = task;
    }
    public DispatchRunnable(Task task,TaskDispatcher dispatcher) {
        this.mTask = task;
        this.mTaskDispatcher = dispatcher;
    }

    @Override
    public void run() {
        TraceCompat.beginSection(mTask.getClass().getSimpleName());
        DispatcherLog.i(mTask.getClass().getSimpleName()
                + " begin run" + "  Situation  " + TaskStat.getCurrentSituation());

        Process.setThreadPriority(mTask.priority());

        long startTime = System.currentTimeMillis();

        mTask.setWaiting(true);//当前任务等待
        mTask.waitToSatisfy();//执行当前任务所依赖的任务先执行完

        long waitTime = System.currentTimeMillis() - startTime;//记录等待所依赖任务的执行时间
        startTime = System.currentTimeMillis();//重新开始计时

        // 执行Task
        mTask.setRunning(true);//设置当前任务为执行中
        mTask.run();//执行任务

        // 执行Task的尾部任务
        Runnable tailRunnable = mTask.getTailRunnable();
        if (tailRunnable != null) {
            tailRunnable.run();
        }

        if (!mTask.needCall() || !mTask.runOnMainThread()) {
            printTaskLog(startTime, waitTime);

            TaskStat.markTaskDone();
            mTask.setFinished(true);
            if(mTaskDispatcher != null){
                mTaskDispatcher.satisfyChildren(mTask);
                mTaskDispatcher.markTaskDone(mTask);
            }
            DispatcherLog.i(mTask.getClass().getSimpleName() + " finish");
        }
        TraceCompat.endSection();
    }

    /**
     * 打印出来Task执行的日志
     *
     * @param startTime
     * @param waitTime
     */
    private void printTaskLog(long startTime, long waitTime) {
        long runTime = System.currentTimeMillis() - startTime;
        if (DispatcherLog.isDebug()) {
            DispatcherLog.i(mTask.getClass().getSimpleName() + "  wait " + waitTime + "    run "
                    + runTime + "   isMain " + (Looper.getMainLooper() == Looper.myLooper())
                    + "  needWait " + (mTask.needWait() || (Looper.getMainLooper() == Looper.myLooper()))
                    + "  ThreadId " + Thread.currentThread().getId()
                    + "  ThreadName " + Thread.currentThread().getName()
                    + "  Situation  " + TaskStat.getCurrentSituation()
            );
        }
    }
}
