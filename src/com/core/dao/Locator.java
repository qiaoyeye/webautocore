package com.core.dao;

/** 
* 页面元素封装类，将页面元素的By by和by的值封装成Locator对象，为common类的操作提供对象
* ByType bt：相应的By by
* String element：相应的by值
* String value：如sendkeys时，要传入的数据
* 可以将以上三个封装为Locator对象；如果不需要value，则将bt和element封装为对象
* @ClassName: Locator 
* @Description: TODO(页面元素封装类，将页面元素的By by和by的值封装成Locator对象，为common类的操作提供对象) 
* @author qiaojiafei 
* @date 2016年2月29日 上午11:28:16 
*  
*/
public class Locator {
    public enum ByType {
        id("id"), name("name"), xpath("xpath"), className("className"),cssSelector("cssSelector"),
        tagName("tagName"),linkText("linkText"),partialLinkText("partialLinkText");
        String value;
        ByType(String value) {
        	this.value = value;
        }
     }
    
    //By by内的值
    private String element;
    //By by
    ByType bt;
    //测试数据值
    private String value;
    
    public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Locator() {}
    
    public Locator(String bt, String element) {
    	this.element = element;
    	this.SetBy(bt);
    	this.bt = this.getBy();
    }
    
    public Locator(String bt, String element, String value) {
    	this.element = element;
    	this.SetBy(bt);
    	this.bt = this.getBy();
    	this.value = value;
    }
    
    public Locator(String element) {
    	this.element = element;
    }
    
    public void setElement(String element) {
    	this.element = element;
    }
    
    public String getElement() {
    	return element;
    }
    
    
    public void SetBy(String s) {
    	if(s.equals("id")) {
    		bt = ByType.id;
    	}else if(s.equals("name")) {
    		bt = ByType.name;
    	}else if(s.equals("xpath")) {
    		bt = ByType.xpath;
    	}else if(s.equals("className")) {
    		bt = ByType.className;
    	}else if(s.equals("cssSelector")){
    		bt = ByType.cssSelector;
    	}else if(s.equals("tagName")){
    		bt = ByType.tagName;
    	}else if(s.equals("linkText")){
    		bt = ByType.linkText;
    	}else if(s.equals("partialLinkText")){
    		bt = ByType.partialLinkText;
    	}else{
    		System.out.println("获取的By有误="+s);
    	}
    }
       
    public ByType  getBy() {
    	return bt;
    }
}
