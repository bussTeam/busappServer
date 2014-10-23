package com.springapp.initMethod;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * <p>7road question system</p>
 * <p>SpringContextUtil.java</p>
 * <p/>
 * <p>7road Technologies</p>
 * <p>Copyright (c) 2015</p>
 * <p/>
 * <p>Description:</p>
 *
 * 当Jersey的Resource需要通过接口实现，在在Application的注册中，需要通过此文件的getBean()来获得一个Object用来注册
 *
 * @version 1.0
 * @author: joey.lv
 * <p/>
 * Revision History:
 * 2014/5/16, joey.lv ,Initial Version.
 */

public class SpringContextUtils implements ApplicationContextAware {
    private static ApplicationContext ctx;     //Spring应用上下文环境

    /**
     * 实现ApplicationContextAware接口的回调方法，设置上下文环境
     *
     * @param ctx
     * @throws org.springframework.beans.BeansException
     */
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        SpringContextUtils.ctx = ctx;
    }

    /**
     * 获取对象
     *
     * @param name
     * @return Object 一个以所给名字注册的bean的实例
     * @throws org.springframework.beans.BeansException
     */
    public static Object getBean(String name) throws BeansException {

        return ctx.getBean(name);
    }

}
