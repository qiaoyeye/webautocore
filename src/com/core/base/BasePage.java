package com.core.base;

/** 
* @ClassName: BasePage 
* @Description: TODO(所有PageObject类都实现该接口，对外提供了validation的方法和action方法) 
* @author qiaojiafei 
* @date 2015年12月23日 下午3:05:10 
*  
*/
public interface BasePage {
	public abstract void validation(BaseLocator baseLocator);
	public abstract void action();
}
