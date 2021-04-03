package cn.yuzhizhe.launch_simple.app;

import java.util.ArrayList;
import java.util.List;

import cn.yuzhizhe.launch_simple.launchstarter.task.Task;

/**
 * @ProjectName: Launch_Simple
 * @Package: cn.yuzhizhe.launch_simple.app
 * @ClassName: Task_C
 * @Description: 类作用描述:
 * @Author: yuzhizhe
 * @CreateDate: 2021/4/3 11:57
 * @Version: 1.0
 * *******************************
 * @UpdateUser: 无
 * @UpdateDate: 无
 * @UpdateRemark: 无
 */
public class Task_C extends Task {
    @Override
    public List<Class<? extends Task>> dependsOn() {
        List<Class<? extends Task>> list = new ArrayList<>();
        list.add(Task_B.class);
        return list;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
