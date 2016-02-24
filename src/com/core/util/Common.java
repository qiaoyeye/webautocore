package com.core.util;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.core.base.BaseClass;
import com.core.dao.Locator;


/** 
* @ClassName: CommBase 
* @Description: 封装selenium常用的方法，把所有方法放入该类的目的是初始化Common一次，就可以调用所有方法
* @author qiaojiafei 
* @date 2015年10月21日 下午6:41:25 
*  
*/
public class Common{

	public WebDriver dr;
	Log log = new Log(this.getClass());
	String [][]locatorArray;

	
	public Common(){
		//log.info("Common()");
	} 
	
	public Common(WebDriver dr){
		//log.info("Common(WebDriver dr)");
		this.dr = dr;
	}
	
	public void setDriver(WebDriver dr) {
		this.dr = dr;
	}
	
	public void setLocatorArray(String path, int index){
		//log.info("setlocatorArray(String path, int index)");
		this.locatorArray = OptionFile.getLocatorArray(path, index);
	}

    /** 
    * @Title: findElement 
    * @Description: 获取查找的元素
    * @param driver
    * @param locator
    * @return
    * @return WebElement
    * @throws 
    */
    public WebElement findElement(final Locator locator) {
    	log.info("调用findElement方法");
        WebElement element = (new WebDriverWait(dr, 10))
                .until(new ExpectedCondition<WebElement>() {

                    @Override
                    public WebElement apply(WebDriver driver) {
                        try {
                            return getElement(locator);
                        } catch (Exception e) {
                        	log.error("通过"+locator.getBy()+"找不到"+locator.getElement());
                            // TODO Auto-generated catch block
                            return null;
                        }

                    }

                });
        return element;

    }
    
    /** 
    * @Title: getElement 
    * @Description: 通过各种方式获取查找的元素
    * @param driver
    * @param locator
    * @param s_by
    * @param s_el
    * @return
    * @throws IOException
    * @return WebElement
    * @throws 
    */
    private WebElement getElement(Locator locator) {

        WebElement e;
        switch (locator.getBy()) {
        case xpath:
        	log.debug("find element By xpath:"+locator.getElement());
            e = dr.findElement(By.xpath(locator.getElement()));
            break;
        case id:
        	log.debug("find element By id:"+locator.getElement());
            e = dr.findElement(By.id(locator.getElement()));
            break;
        case name:
        	log.debug("find element By name:"+locator.getElement());
            e = dr.findElement(By.name(locator.getElement()));
            break;
        case cssSelector:
        	log.debug("find element By cssSelector:"+locator.getElement());
            e = dr.findElement(By.cssSelector(locator.getElement()));
            break;
        case className:
        	log.debug("find element By partialLinkText:"+locator.getElement());
            e = dr.findElement(By.className(locator.getElement()));
            break;
        case tagName:
        	log.debug("find element By tagName:"+locator.getElement());
            e = dr.findElement(By.tagName(locator.getElement()));
            break;
        case linkText:
        	log.debug("find element By linkText:"+locator.getElement());
            e = dr.findElement(By.linkText(locator.getElement()));
            break;
        case partialLinkText:
        	log.debug("find element By partialLinkText:"+locator.getElement());
            e = dr.findElement(By.partialLinkText(locator.getElement()));
            break;
        default:
        	log.debug("default find element By id:"+locator.getElement());
            e = dr.findElement(By.id(locator.getElement()));
        }
        return e;
    }
    
    /** 
    * @Title: findElements 
    * @Description: 获取查找元素的集合
    * @param locator
    * @return
    * @return List<WebElement>
    * @throws 
    */
    public List<WebElement> findElements(Locator locator) {
    	WebDriverWait wait = new WebDriverWait(dr,10);
        List<WebElement> list = null  ;
        ExpectedCondition <List<WebElement>> elements = ExpectedConditions.visibilityOfAllElements(getElements(locator));
        list = wait.until(elements);
        return list;
    }
    
    /** 
    * @Title: getElements 
    * @Description:  通过各种方式获取查找的元素集合
    * @param locator
    * @return
    * @return WebElement
    * @throws 
    */
	private List<WebElement> getElements(final Locator locator) {

        List<WebElement> list;
        switch (locator.getBy()) {
        case xpath:
        	log.debug("find elements By xpath:"+locator.getElement());
        	list = dr.findElements(By.xpath(locator.getElement()));
            break;
        case id:
        	log.debug("find elements By id:"+locator.getElement());
        	list = dr.findElements(By.id(locator.getElement()));
            break;
        case name:
        	log.debug("find elements By name:"+locator.getElement());
        	list = dr.findElements(By.name(locator.getElement()));
            break;
        case cssSelector:
        	log.debug("find elements By cssSelector:"+locator.getElement());
        	list = dr.findElements(By.cssSelector(locator.getElement()));
            break;
        case className:
        	log.debug("find elements By partialLinkText:"+locator.getElement());
        	list = dr.findElements(By.className(locator.getElement()));
            break;
        case tagName:
        	log.debug("find elements By tagName:"+locator.getElement());
        	list = dr.findElements(By.tagName(locator.getElement()));
            break;
        case linkText:
        	log.debug("find elements By linkText:"+locator.getElement());
        	list = dr.findElements(By.linkText(locator.getElement()));
            break;
        case partialLinkText:
        	log.debug("find elements By partialLinkText:"+locator.getElement());
        	list = dr.findElements(By.partialLinkText(locator.getElement()));
            break;
        default:
        	log.debug("default find elements By id:"+locator.getElement());
        	list = dr.findElements(By.id(locator.getElement()));
        }
        return list;
    }
	
	public Locator getLocator1(String unqueindex) {
		Map map = OptionFile.readxml("D:/git/webautocore/excel/loginpage.xml");
		return (Locator) map.get(unqueindex);	
	}
	
    
    /** 
    * @Title: getLocator 
    * @Description: 通过传入的name获取某行整个locator对象,Common(String path, int index)
    * @param name
    * @return
    * @return Locator
    * @throws 
    */
    public Locator getLocator(String name) {

		Locator locator = null;
		if(locatorArray!=null) {
			for (int i = 0; i < locatorArray.length; i++) {
				if (locatorArray[i][1].equals(name)) {
					if(locatorArray[i].length>=5){
						locator = new Locator(locatorArray[i][2], locatorArray[i][3], locatorArray[i][4]);
						log.debug("初始化locator对象成功，包含By，element和value分别是："+locatorArray[i][2]+", "+locatorArray[i][3]+", "+locatorArray[i][4]);
					}else if(locatorArray[i].length==4){
						locator = new Locator(locatorArray[i][2], locatorArray[i][3]);
						log.debug("初始化locator对象成功，包含By，element和value分别是："+locatorArray[i][2]+", "+locatorArray[i][3]);
					}else{
						log.warn("locatorArray的长度不正确，该行的name："+name);
					}
				}
			}
		}else {
			log.warn("locatorArray为null");
		}
		//return locator = new Locator(locatorName);
		return locator;
    }

    /** 
    * @Title: getLocator 
    * @Description: 通过传入的name获取某行整个locator对象,Common(String path, int index)
    * @param name
    * @param col:excel中测试数据在第几列
    * @return
    * @return Locator
    * @throws 
    */
    public Locator getLocator(String name, int col) {

		Locator locator = null;
		if(locatorArray!=null) {
			for (int i = 0; i < locatorArray.length; i++) {
				if (locatorArray[i][1].equals(name)) {
					if(locatorArray[i].length>=5){
						locator = new Locator(locatorArray[i][2], locatorArray[i][3], locatorArray[i][col]);
						log.debug("通过指定的测试数据初始化locator对象成功，包含By，element和value分别是："+locatorArray[i][2]+", "+locatorArray[i][3]+", "+locatorArray[i][col]);
					}else if(locatorArray[i].length==4){
						locator = new Locator(locatorArray[i][2], locatorArray[i][3]);
						log.debug("初始化locator对象成功，包含By，element和value分别是："+locatorArray[i][2]+", "+locatorArray[i][3]);
					}else{
						log.warn("locatorArray的长度不正确，该行的name："+name);
					}
				}
			}
		}else {
			log.warn("locatorArray为null");
		}
		//return locator = new Locator(locatorName);
		return locator;
    }
    
    /** 
    * @Title: getLocator 
    * @Description: 获取Locator对象
    * @param s_by
    * @param s_element
    * @return
    * @return Locator
    * @throws 
    */
    public Locator getLocator(String s_by, String s_element) {

    	log.debug("初始化Locator对象，2个值分别为"+s_by+"，"+s_element);
    	Locator locator = new Locator(s_by, s_element);
		return locator;
    }
    
    /** 
    * @Title: getLocator 
    * @Description: 获取Locator对象,传入3个对象
    * @param s_by
    * @param s_element
    * @param value
    * @return
    * @return Locator
    * @throws 
    */
    public Locator getLocator(String s_by, String s_element, String value) {
    	log.info("getLocator(String s_by, String s_element, String value)");
    	log.debug("初始化Locator对象，3个值分别为"+s_by+"，"+s_element+"， "+value);
    	Locator locator = new Locator(s_by, s_element, value);
		return locator;
    }
    
    /** 
    * @Title: isElementPresent 
    * @Description: 判断当前元素是否可见
    * @param driver
    * @param locator
    * @return
    * @throws IOException
    * @return boolean
    * @throws 
    */
    public boolean isElementPresent(final Locator locator) {
        log.info("判断元素是否可见");
        boolean isPresent = false;
        WebDriverWait wait = new WebDriverWait(dr, 10);
        isPresent = wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver d) {
                return findElement(locator);
            }
        }).isDisplayed();
        return isPresent;
    }

	/** 
	* @Title: sendkeys 
	* @Description: new Common() 调用
	* @param locator
	* @param values
	* @throws Exception
	* @return void
	* @throws 
	*/
	public void sendkeys(Locator locator, String value) {
		log.info("type(Locator locator, String values)");
		WebElement e = findElement(locator);	
		e.sendKeys(value);
		log.debug("type value is:  " + value);
	}

	/** 
	* @Title: sendkeys 
	* @Description: new Common(String path, int index) 调用
	* @param locator
	* @throws Exception
	* @return void
	* @throws 
	*/
	public void sendkeys(Locator locator) {
		log.info("type(Locator locator)");
		WebElement e = findElement(locator);
		e.sendKeys(locator.getValue());
		log.debug("type value is:  " + locator.getValue());
	}

	/** 
	* @Title: typeQuick 
	* @Description: 用JS向输入框输入值
	* @param locator
	* @param values
	* @return void
	* @throws 
	*/
	public void typeQuick(Locator locator, String values) {
		log.info("typeQuick(Locator locator, String values)");
		WebElement e = findElement(locator);
		log.debug("type value is:  " + values);
		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript("arguments[0].value=\"" + values + "\"", e);

	}
	
	/** 
	* @Title: executorJS 
	* @Description: 执行js
	* @param s
	* @return void
	* @throws 
	*/
	public void executorJS(String s) {
		log.info("executorJS(String s)");
		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript(s);

	}
	
	
	/** 
	* @Title: toDefaultContent 
	* @Description: TODO跳转至默认的窗体
	* @return void
	* @throws 
	*/
	public void toDefaultContent() {
		dr.switchTo().defaultContent();
	}
	
	/** 
	* @Title: toParentFrame 
	* @Description: TODO跳转至上一级的窗体
	* @return void
	* @throws 
	*/
	public void toParentFrame() {
		dr.switchTo().parentFrame();
	}
	
	
	/** 
	* @Title: toFrame 
	* @Description: 跳转到Frame
	* @param ob
	* @return void
	* @throws 
	*/
	public void toFrame(Object ob) {
		log.info("toFrame(Object ob)");
		if(ob instanceof  String) {
			String s = (String)ob;
			dr.switchTo().frame(s);
		}else if (ob instanceof  WebElement) {
			WebElement we = (WebElement)ob;
			dr.switchTo().frame(we);
		}else if(ob instanceof  Integer){
			Integer it = (Integer)ob;
			dr.switchTo().frame(it.intValue());
		}else{
			log.warn("toFrame(Object ob)传入参数类型有误");
		}
	}

	/** 
	* @Title: setRichTextBox 
	* @Description: 设置富文本框内容
	* @param locator
	* @param text
	* @return void
	* @throws 
	*/
	public void setRichTextBox(Locator locator, String text) {
		log.info("setRichTextBox(Locator locator, String text)");
		WebElement e = findElement(locator);
		log.debug("type value is:  " + text);
		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript("arguments[0].innerHTML = \"" + text + "\"", e);
	}

	/** 
	* @Title: getRichTextBox 
	* @Description: 得到富文本框内容
	* @param locator
	* @param text
	* @return
	* @return String
	* @throws 
	*/
	public String getRichTextBox(Locator locator, String text) {
		log.info("getRichTextBox(Locator locator, String text)");
		WebElement e = findElement(locator);
		
		JavascriptExecutor js = (JavascriptExecutor) dr;
		String result = (String) js.executeScript(
				"arguments[0].getInnerHTML()", e);
		log.debug("get TextBox is:  " + result);
		return result;
	}

	/** 
	* @Title: scrollToElement 
	* @Description: 将滚动条滑动至某个元素
	* @param locator
	* @return void
	* @throws 
	*/
	public void scrollToElement(Locator locator) {
		log.info("scrollToElement(Locator locator)");
		WebElement e = findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) dr;
		// roll down and keep the element to the center of browser
		js.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", e);
	}

	/** 
	* @Title: click 
	* @Description: 点击操作
	* @param locator
	* @throws Exception
	* @return void
	* @throws 
	*/
	public void click(Locator locator){
		log.info("click(Locator locator)");
		WebElement e = findElement(locator);
		e.click();
	}

	/** 
	* @Title: selectByIndex通过下拉框的索引选择Select 
	* @Description: TODO
	* @param locator
	* @param index
	* @return void
	* @throws 
	*/
	public void selectByIndex(Locator locator, int index) {
		log.info("select(Locator locator, String value)");
		WebElement e = findElement(locator);
		Select select = new Select(e);

		log.debug("select by index " + index);
		select.selectByIndex(index);;
	}
	
	/** 
	* @Title: selectByValue 
	* @Description: new Common() 调用,通过select的value选择下拉框的值
	* @param locator
	* @param value
	* @throws Exception
	* @return void
	* @throws 
	*/
	
	public void selectByValue(Locator locator, String value) {
		log.info("selectByValue(Locator locator, String value)");
		WebElement e = findElement(locator);
		Select select = new Select(e);

		log.debug("select by Value " + value);
		select.selectByValue(value);

	}
	
	/** 
	* @Title: selectByVisibleText 
	* @Description:  new Common() 调用,通过select的可见文本选择下拉框的值
	* @param locator
	* @param text
	* @return void
	* @throws 
	*/
	public void selectByVisibleText(Locator locator, String text) {
		log.info("selectByVisibleText(Locator locator, String text)");
		WebElement e = findElement(locator);
		Select select = new Select(e);

		log.debug("select by VisibleText " + text);
		select.selectByVisibleText(text);

	}

	/** 
	* @Title: select 
	* @Description: new Common() 调用,自动判断Locator的Value值，并根据alue值去做响应的选择
	* @param locator
	* @throws Exception
	* @return void
	* @throws 
	*/
	public void select(Locator locator) {
		log.info("select(Locator locator)");
		WebElement e = findElement(locator);
		Select select = new Select(e);

		try {
			log.debug("select by Value " + locator.getValue());
			select.selectByValue(locator.getValue());
		} catch (NoSuchElementException notByValue) {
			log.debug("select by VisibleText " + locator.getValue());
			select.selectByVisibleText(locator.getValue());
		} catch(Exception exc) {
			log.debug("select by Index " + locator.getValue());
			select.selectByIndex(Integer.parseInt(locator.getValue()));
		}
	}
	
	/** 
	* @Title: getSelect 
	* @Description: TODO得到Select
	* @param locator
	* @return
	* @return Select
	* @throws 
	*/
	public Select getSelect(Locator locator) {
		
		WebElement e = findElement(locator);
		Select select = new Select(e);
		
		return select;
	}
	
	/** 
	* @Title: alertConfirm 
	* @Description:  Alert弹框的文本，点击确定
	* @return void
	* @throws 
	*/
	public void alertConfirm() {
		Alert alert = dr.switchTo().alert();
		try {
			alert.accept();
		} catch (Exception notFindAlert) {
			throw notFindAlert;
		}
	}

	/** 
	* @Title: alertDismiss 
	* @Description: Alert弹框的文本，点击关闭
	* @return void
	* @throws 
	*/
	public void alertDismiss() {
		Alert alert = dr.switchTo().alert();
		try {
			alert.dismiss();
		} catch (Exception notFindAlert) {
			throw notFindAlert;
		}
	}

	/** 
	* @Title: getAlertText 
	* @Description: 得到Alert弹框的文本
	* @return
	* @return String
	* @throws 
	*/
	public String getAlertText() {
		Alert alert = dr.switchTo().alert();
		try {
			return alert.getText();
		} catch (Exception notFindAlert) {
			throw notFindAlert;
		}
	}
	
	/** 
	* @Title: refreshPage 
	* @Description: 页面刷新
	* @return void
	* @throws 
	*/
	public void refreshPage() {
		dr.navigate().refresh();
	}
	
	/** 
	* @Title: forwardPage 
	* @Description: 页面前进
	* @return void
	* @throws 
	*/
	public void forwardPage() {
		dr.navigate().forward();
	}
	
	/** 
	* @Title: backPage 
	* @Description: 页面后退
	* @return void
	* @throws 
	*/
	public void backPage() {
		dr.navigate().back();
	}

}
