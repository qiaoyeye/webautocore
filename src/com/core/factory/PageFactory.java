package com.core.factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;

/** 
* 页面工厂类，自动构建传入的页面类的对象
* @ClassName: PageFactory 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author qiaojiafei 
* @date 2016年2月29日 上午11:32:44 
*  
*/
public class PageFactory {
	
    public synchronized static Object getPage(Class<?> key,WebDriver d) {
        String test = key.getCanonicalName();
        System.out.println(test);
        Class<?> clazz;
        Object obj = null;
		try {
			clazz = Class.forName(test);
			Constructor<?> constructor = clazz.getConstructor(WebDriver.class);
            obj = constructor.newInstance(d);
            System.out.println(obj.getClass().toString()+"-------------------"+obj.toString());
		} catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return obj;

    }

}
