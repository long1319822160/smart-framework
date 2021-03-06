package org.smart4j.framework.helper;

import org.smart4j.framework.util.ClassUtil;
import  org.smart4j.framework.annotation.Service;
import  org.smart4j.framework.annotation.Controller;
import java.util.HashSet;
import java.util.Set;

public final class ClassHelper {
    /*
    定义类集合(用于存放所加载的类)
     */
    private static final Set<Class<?>> CLASS_SET;
    static {
        String basePackage=ConfigHelper.getAppBasePackage();
        CLASS_SET= ClassUtil.getClassSet(basePackage);
    }

    /**
     * 获取应用包名下所有类
     * @return
     */
    public static Set<Class<?>> getClassSet(){
        return  CLASS_SET;
    }

    /**
     *获取应用包所有Service类
     */
    public static Set<Class<?>> getServiceClassSet(){
        Set<Class<?>> classSet=new HashSet<Class<?>>();
        for (Class<?> cls: CLASS_SET){
            if(cls.isAnnotationPresent(Service.class)){
                classSet.add(cls);
            }
        }
        return  classSet;
    }
    /**
     *获取应用包所有Controller类
     */
    public static Set<Class<?>> getControllerClassSet(){
        Set<Class<?>> classSet=new HashSet<Class<?>>();
        for (Class<?> cls: CLASS_SET){
            if(cls.isAnnotationPresent(Controller.class)){
                classSet.add(cls);
            }
        }
        return  classSet;
    }
    /**
     * 获取应用包下所有Bean类(包括Service、Controller等);
     */
    public static Set<Class<?>> getBeanClassSet(){
        Set<Class<?>> beanClassSet=new HashSet<Class<?>>();
        beanClassSet.addAll(getServiceClassSet());
        beanClassSet.addAll(getControllerClassSet());
        return  beanClassSet;
    }
}
