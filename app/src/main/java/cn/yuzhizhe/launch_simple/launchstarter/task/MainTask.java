package cn.yuzhizhe.launch_simple.launchstarter.task;


/**
 * @ProjectName: Launch_Simple
 * @Package: cn.yuzhizhe.launch_simple.launchstarter.task
 * @ClassName: MainTask
 * @Description: 类作用描述:必须执行在主线程的任务
 * @Author: yuzhizhe
 * @CreateDate: 2021/4/3 10:32
 * @Version: 1.0
 * *******************************
 * @UpdateUser: 无
 * @UpdateDate: 无
 * @UpdateRemark: 无
 */
public abstract class MainTask extends Task {

    @Override
    public boolean runOnMainThread() {
        return true;
    }
}
