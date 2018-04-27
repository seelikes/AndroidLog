package com.github.seelikes.android.log;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import java.io.PrintWriter;
import java.io.StringWriter;

public class SaLog {
    /**
     * 初始化日志打印模块
     * @param threshold 设定被打印的最低级别，低于此级别的日志将不再输出
     * @param tags 日志界别低于阈值级别时放行的标签，也即即使日志级别不应该被打印，只要当前标签在tags列表中，依然会打印
     */
    public static void init(int threshold, String... tags) {
        Logger.addLogAdapter(new AndroidLogAdapter() {
            @Override
            public boolean isLoggable(int priority, String tag) {
                if (priority >= threshold) {
                    return true;
                }
                for (String t : tags) {
                    if (t != null && t.equals(tag)) {
                        return true;
                    }
                }
                return true;
            }
        });
    }


    /**
     * 打印 {@link Logger#VERBOSE} 级别日志
     * @param whereClass 打印日志的类
     * @param whereMethod 打印日志的方法
     * @param msg 日志内容
     */
    public static void v(Class<?> whereClass, String whereMethod, String msg) {
        Logger.v("%s, %s, %s", whereClass.getSimpleName(), whereMethod, msg);
    }

    /**
     * 打印 {@link Logger#DEBUG} 级别日志
     * @param whereClass 打印日志的类
     * @param whereMethod 打印日志的方法
     * @param msg 日志内容
     */
    public static void d(Class<?> whereClass, String whereMethod, String msg) {
        Logger.d("%s, %s, %s", whereClass.getSimpleName(), whereMethod, msg);
    }

    /**
     * 打印 {@link Logger#INFO} 级别日志
     * @param whereClass 打印日志的类
     * @param whereMethod 打印日志的方法
     * @param msg 日志内容
     */
    public static void i(Class<?> whereClass, String whereMethod, String msg) {
        Logger.i("%s, %s, %s", whereClass.getSimpleName(), whereMethod, msg);
    }

    /**
     * 打印 {@link Logger#WARN} 级别日志
     * @param whereClass 打印日志的类
     * @param whereMethod 打印日志的方法
     * @param msg 日志内容
     */
    public static void w(Class<?> whereClass, String whereMethod, String msg) {
        Logger.w("%s, %s, %s", whereClass.getSimpleName(), whereMethod, msg);
    }

    /**
     * 打印 {@link Logger#ERROR} 级别日志
     * @param whereClass 打印日志的类
     * @param whereMethod 打印日志的方法
     * @param msg 日志内容
     */
    public static void e(Class<?> whereClass, String whereMethod, String msg) {
        Logger.e("%s, %s, %s", whereClass.getSimpleName(), whereMethod, msg);
    }

    /**
     * 打印 {@link Logger#ERROR} 级别日志
     * @param whereClass 打印日志的类
     * @param whereMethod 打印日志的方法
     * @param throwable 异常对象
     */
    public static void e(Class<?> whereClass, String whereMethod, Throwable throwable) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        throwable.printStackTrace(pw);
        pw.flush();
        Logger.e("%s, %s, %s", whereClass.getSimpleName(), whereMethod, sw.toString());
        pw.close();
    }
}
