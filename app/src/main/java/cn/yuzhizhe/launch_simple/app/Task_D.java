package cn.yuzhizhe.launch_simple.app;

import java.util.ArrayList;
import java.util.List;

import cn.yuzhizhe.launch_simple.launchstarter.task.Task;

/**
 * @ProjectName: Launch_Simple
 * @Package: cn.yuzhizhe.launch_simple.app
 * @ClassName: Task_D
 * @Description: 类作用描述:
 * @Author: yuzhizhe
 * @CreateDate: 2021/4/3 11:58
 * @Version: 1.0
 * *******************************
 * @UpdateUser: 无
 * @UpdateDate: 无
 * @UpdateRemark: 无
 */
public class Task_D extends Task {

    @Override
    public List<Class<? extends Task>> dependsOn() {
        List<Class<? extends Task>> list = new ArrayList<>();
        list.add(Task_C.class);
        return list;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
