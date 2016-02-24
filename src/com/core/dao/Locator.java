package com.core.dao;

/** 
 * @author QiaoJiafei 
 * @version ����ʱ�䣺2015��10��19�� ����6:48:16 
 * ��˵�� 
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
    
    //By by�ڵ�ֵ
    private String element;
    //By by
    ByType bt;
    //��������ֵ
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
    		System.out.println("��ȡ��By����="+s);
    	}
    }
       
    public ByType  getBy() {
    	return bt;
    }
}
