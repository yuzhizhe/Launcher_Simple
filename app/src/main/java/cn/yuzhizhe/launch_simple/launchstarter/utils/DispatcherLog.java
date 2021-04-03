package cn.yuzhizhe.launch_simple.launchstarter.utils;

import android.util.Log;

/**
 * @ProjectName: Launch_Simple
 * @Package: cn.yuzhizhe.launch_simple.launchstarter.task
 * @ClassName: DispatcherLog
 * @Description: 类作用描述:
 * @Author: yuzhizhe
 * @CreateDate: 2021/4/3 11:25
 * @Version: 1.0
 * *******************************
 * @UpdateUser: 无
 * @UpdateDate: 无
 * @UpdateRemark: 无
 */
public class DispatcherLog {

    private static boolean sDebug = true;

    public static void i(String msg) {
        if (!sDebug) {
            return;
        }
        Log.i("task",msg);
    }

    public static boolean isDebug() {
        return sDebug;
    }

    public static void setDebug(boolean debug) {
        sDebug = debug;
    }
}
