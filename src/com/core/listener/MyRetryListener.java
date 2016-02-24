package com.core.listener;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;



/** 
 * @author QiaoJiafei 
 * @version 创建时间：2015年11月10日 下午3:09:31 
 * 类说明 失败重试类，除了使用MyRetryAnalyzer外，还可以使用该方式，需要在xml加监听：<listener class-name="com.core.base.MyRetryListener" />，该类与MyRetryAnalyzer配合使用
 */
public class MyRetryListener implements IAnnotationTransformer {

	@SuppressWarnings("rawtypes")
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor,
			Method testMethod) {
		
		IRetryAnalyzer retry = annotation.getRetryAnalyzer();
		if (retry == null) { 
			annotation.setRetryAnalyzer(MyRetryAnalyzer.class);
		}
	}

}
