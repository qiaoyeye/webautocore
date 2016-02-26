package com.core.base;

/** 
* @ClassName: BasePage 
* @Description: TODO(所有PageObject类都实现该接口，对外提供了validation的方法和action方法) 
* @author qiaojiafei 
* @date 2015年12月23日 下午3:05:10 
*  
*/
public interface BasePage {
	
	public static final String XMLPATH = "D:/git/webautocore/excel/storeelement.xml";
	/** 
	* @Title: validation 
	* @Description: 每个页面的操作元素方法,将在该方法获取测试数据
	* @param baseLocator
	* @return void
	* @throws 
	*/
	public abstract BasePage validation();
	/** 
	* @Title: action 
	* @Description: 入口方法，设置测试数据，覆盖方法中需要调用validation方法，
	* @param sheet
	* @param CaseNum
	* @return void
	* @throws 
	*/
	public abstract void action(int sheet, int CaseNum);
}
