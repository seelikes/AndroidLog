package com.github.seelikes.android.log;

import android.util.Log;

import java.io.PrintWriter;
import java.io.StringWriter;

public class SaLog {
    /**
     * 打印 {@link SaLogConstants#VERBOSE} 级别日志
     * 警告：有些真机即使在USB调试打开的时候也不会打印v和d级别日志
     * @param whereClass 打印日志的类
     * @param whereMethod 打印日志的方法
     * @param msg 日志内容
     */
    public static void v(Class<?> whereClass, String whereMethod, String msg) {
        if (SaLogConstants.LEVEL <= SaLogConstants.VERBOSE) {
            Log.v(whereClass.getSimpleName(), String.format("%s, %s", whereMethod, msg));
        }
    }

    /**
     * 打印 {@link SaLogConstants#DEBUG} 级别日志
     * 警告：有些真机即使在USB调试打开的时候也不会打印v和d级别日志
     * @param whereClass 打印日志的类
     * @param whereMethod 打印日志的方法
     * @param msg 日志内容
     */
    public static void d(Class<?> whereClass, String whereMethod, String msg) {
        if (SaLogConstants.LEVEL <= SaLogConstants.DEBUG) {
            Log.d(whereClass.getSimpleName(), String.format("%s, %s", whereMethod, msg));
        }
    }

    /**
     * 打印 {@link SaLogConstants#INFO} 级别日志
     * @param whereClass 打印日志的类
     * @param whereMethod 打印日志的方法
     * @param msg 日志内容
     */
    public static void i(Class<?> whereClass, String whereMethod, String msg) {
        if (SaLogConstants.LEVEL <= SaLogConstants.INFO) {
            Log.i(whereClass.getSimpleName(), String.format("%s, %s", whereMethod, msg));
        }
    }

    /**
     * 打印 {@link SaLogConstants#WARN} 级别日志
     * @param whereClass 打印日志的类
     * @param whereMethod 打印日志的方法
     * @param msg 日志内容
     */
    public static void w(Class<?> whereClass, String whereMethod, String msg) {
        if (SaLogConstants.LEVEL <= SaLogConstants.WARN) {
            Log.w(whereClass.getSimpleName(), String.format("%s, %s", whereMethod, msg));
        }
    }

    /**
     * 打印 {@link SaLogConstants#ERROR} 级别日志
     * @param whereClass 打印日志的类
     * @param whereMethod 打印日志的方法
     * @param msg 日志内容
     */
    public static void e(Class<?> whereClass, String whereMethod, String msg) {
        if (SaLogConstants.LEVEL <= SaLogConstants.ERROR) {
            Log.e(whereClass.getSimpleName(), String.format("%s, %s", whereMethod, msg));
        }
    }

    /**
     * 打印 {@link SaLogConstants#ERROR} 级别日志
     * @param whereClass 打印日志的类
     * @param whereMethod 打印日志的方法
     * @param throwable 异常对象
     */
    public static void e(Class<?> whereClass, String whereMethod, Throwable throwable) {
        if (SaLogConstants.LEVEL <= SaLogConstants.ERROR) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            throwable.printStackTrace(pw);
            pw.flush();
            Log.e(whereClass.getSimpleName(), String.format("%s, %s", whereMethod, sw.toString()));
            pw.close();
        }
    }
}
