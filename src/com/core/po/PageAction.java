package com.core.po;

/** 
* ����PageObject�඼ʵ�ָýӿڣ������ṩ��validation�ķ�����action����
* action������װҳ��Ԫ�س�ʼ���Ͳ������ݳ�ʼ��
* validation������װҵ���߼�
* ���LoginPage���ʹ��
* @ClassName: BasePage 
* @Description: TODO(����PageObject�඼ʵ�ָýӿڣ������ṩ��validation�ķ�����action����) 
* @author qiaojiafei 
* @date 2015��12��23�� ����3:05:10 
*  
*/
public interface PageAction {
	
	public static final String XMLPATH = "D:/git/webautocore/excel/storeelement.xml";
	/** 
	* @Title: validation 
	* @Description: ÿ��ҳ��Ĳ���Ԫ�ط���,���ڸ÷�����ȡ��������
	* @param baseLocator
	* @return void
	* @throws 
	*/
	public abstract PageAction validation();
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
