package com.springapp.util;

/**
 * Created by thanks_bin on 2014/10/27.
 */
public class CallBackContentHolder {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public static void setCallBackFuncName(String dataSourceType){
        contextHolder.set(dataSourceType);
    }

    public static String getCallBackFuncName(){
        return (String) contextHolder.get();
    }

    public static void clearCallBackFuncName(){
        contextHolder.remove();
    }
}
