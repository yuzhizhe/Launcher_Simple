package cn.yuzhizhe.launch_simple.app;

import cn.yuzhizhe.launch_simple.launchstarter.task.MainTask;

/**
 * @ProjectName: Launch_Simple
 * @Package: cn.yuzhizhe.launch_simple.app
 * @ClassName: Task_A
 * @Description: 类作用描述:
 * @Author: yuzhizhe
 * @CreateDate: 2021/4/3 11:48
 * @Version: 1.0
 * *******************************
 * @UpdateUser: 无
 * @UpdateDate: 无
 * @UpdateRemark: 无
 */
public class Task_A extends MainTask {
    @Override
    public void run() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
