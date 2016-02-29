package com.core.factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;

/** 
* ҳ�湤���࣬�Զ����������ҳ����Ķ���
* @ClassName: PageFactory 
* @Description: TODO(������һ�仰��������������) 
* @author qiaojiafei 
* @date 2016��2��29�� ����11:32:44 
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
