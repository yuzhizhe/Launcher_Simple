package cn.yuzhizhe.launch_simple.app;

import android.app.Application;
import android.util.Log;

import cn.yuzhizhe.launch_simple.launchstarter.TaskDispatcher;

/**
 * @ProjectName: Launch_Simple
 * @Package: cn.yuzhizhe.launch_simple
 * @ClassName: MyApplication
 * @Description: 类作用描述:
 * @Author: yuzhizhe
 * @CreateDate: 2021/4/3 11:44
 * @Version: 1.0
 * *******************************
 * @UpdateUser: 无
 * @UpdateDate: 无
 * @UpdateRemark: 无
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        TaskDispatcher.init(MyApplication.this);//初始化启动器

        TaskDispatcher dispatcher = TaskDispatcher.createInstance();

        dispatcher.addTask(new Task_A())
                .addTask(new Task_B())
                .addTask(new Task_C())
                .addTask(new Task_D())
                .addTask(new Task_E())
                .start();
        Log.i("task" , "Application finish");
    }
}
