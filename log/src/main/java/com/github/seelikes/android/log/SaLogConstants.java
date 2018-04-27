package com.github.seelikes.android.log;

public class SaLogConstants {
    public static final int VERBOSE = 2;
    public static final int DEBUG = 3;
    public static final int INFO = 4;
    public static final int WARN = 5;
    public static final int ERROR = 6;

    /**
     * 打印日志级别
     * 默认全部打印
     */
    protected static int LEVEL = VERBOSE;

    /**
     * 设定日志打印级别
     * @param level 设定被打印的最低级别，低于此级别的日志将不再输出
     */
    public static void setLogLevel(int level) {
        SaLogConstants.LEVEL = level;
    }
}
