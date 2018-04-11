package com.study;

/**
 * Created by 14978 on 2017/8/15.
 */
public class Logger {
    public static void logger(Level level,String message)
    {
        if(level.equals(Level.EORR))
            System.err.println(message);

        if(level.equals(Level.INFO))
            System.out.println(message);
    }
}
