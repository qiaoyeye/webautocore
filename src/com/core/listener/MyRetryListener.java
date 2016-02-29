package com.core.listener;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

/** 
* 失败重试类，除了使用MyRetryAnalyzer外，还可以使用该方式，需要在xml加监听：<listener class-name="com.core.base.MyRetryListener" />
* 考虑影响测试用例的执行效率，可根据实际情况使用
* 该类与MyRetryAnalyzer配合使用，和TestRetryAnalyzer是两种写法，用的话可以使用TestRetryAnalyzer
* @ClassName: MyRetryListener 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author qiaojiafei 
* @date 2016年2月29日 上午11:34:16 
*  
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
