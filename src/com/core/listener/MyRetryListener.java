package com.core.listener;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;



/** 
 * @author QiaoJiafei 
 * @version ����ʱ�䣺2015��11��10�� ����3:09:31 
 * ��˵�� ʧ�������࣬����ʹ��MyRetryAnalyzer�⣬������ʹ�ø÷�ʽ����Ҫ��xml�Ӽ�����<listener class-name="com.core.base.MyRetryListener" />��������MyRetryAnalyzer���ʹ��
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
