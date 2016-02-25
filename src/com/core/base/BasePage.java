package com.core.base;

/** 
* @ClassName: BasePage 
* @Description: TODO(����PageObject�඼ʵ�ָýӿڣ������ṩ��validation�ķ�����action����) 
* @author qiaojiafei 
* @date 2015��12��23�� ����3:05:10 
*  
*/
public interface BasePage {
	/** 
	* @Title: validation 
	* @Description: ÿ��ҳ��Ĳ���Ԫ�ط���,���ڸ÷�����ȡ��������
	* @param baseLocator
	* @return void
	* @throws 
	*/
	public abstract void validation(BaseLocator baseLocator);
	/** 
	* @Title: action 
	* @Description: ��ڷ��������ò������ݣ����Ƿ�������Ҫ����validation������
	* @param sheet
	* @param CaseNum
	* @return void
	* @throws 
	*/
	public abstract void action(int sheet, int CaseNum);
}
