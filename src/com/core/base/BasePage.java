package com.core.base;

/** 
* @ClassName: BasePage 
* @Description: TODO(����PageObject�඼ʵ�ָýӿڣ������ṩ��validation�ķ�����action����) 
* @author qiaojiafei 
* @date 2015��12��23�� ����3:05:10 
*  
*/
public interface BasePage {
	public abstract void validation(BaseLocator baseLocator);
	public abstract void action();
}
