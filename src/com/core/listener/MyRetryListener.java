package com.core.listener;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

/** 
* ʧ�������࣬����ʹ��MyRetryAnalyzer�⣬������ʹ�ø÷�ʽ����Ҫ��xml�Ӽ�����<listener class-name="com.core.base.MyRetryListener" />
* ����Ӱ�����������ִ��Ч�ʣ��ɸ���ʵ�����ʹ��
* ������MyRetryAnalyzer���ʹ�ã���TestRetryAnalyzer������д�����õĻ�����ʹ��TestRetryAnalyzer
* @ClassName: MyRetryListener 
* @Description: TODO(������һ�仰��������������) 
* @author qiaojiafei 
* @date 2016��2��29�� ����11:34:16 
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
