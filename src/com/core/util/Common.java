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
* @Description: ��װselenium���õķ����������з�����������Ŀ���ǳ�ʼ��Commonһ�Σ��Ϳ��Ե������з���
* @author qiaojiafei 
* @date 2015��10��21�� ����6:41:25 
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
    * @Description: ��ȡ���ҵ�Ԫ��
    * @param driver
    * @param locator
    * @return
    * @return WebElement
    * @throws 
    */
    public WebElement findElement(final Locator locator) {
    	log.info("����findElement����");
        WebElement element = (new WebDriverWait(dr, 10))
                .until(new ExpectedCondition<WebElement>() {

                    @Override
                    public WebElement apply(WebDriver driver) {
                        try {
                            return getElement(locator);
                        } catch (Exception e) {
                        	log.error("ͨ��"+locator.getBy()+"�Ҳ���"+locator.getElement());
                            // TODO Auto-generated catch block
                            return null;
                        }

                    }

                });
        return element;

    }
    
    /** 
    * @Title: getElement 
    * @Description: ͨ�����ַ�ʽ��ȡ���ҵ�Ԫ��
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
    * @Description: ��ȡ����Ԫ�صļ���
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
    * @Description:  ͨ�����ַ�ʽ��ȡ���ҵ�Ԫ�ؼ���
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
    * @Description: ͨ�������name��ȡĳ������locator����,Common(String path, int index)
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
						log.debug("��ʼ��locator����ɹ�������By��element��value�ֱ��ǣ�"+locatorArray[i][2]+", "+locatorArray[i][3]+", "+locatorArray[i][4]);
					}else if(locatorArray[i].length==4){
						locator = new Locator(locatorArray[i][2], locatorArray[i][3]);
						log.debug("��ʼ��locator����ɹ�������By��element��value�ֱ��ǣ�"+locatorArray[i][2]+", "+locatorArray[i][3]);
					}else{
						log.warn("locatorArray�ĳ��Ȳ���ȷ�����е�name��"+name);
					}
				}
			}
		}else {
			log.warn("locatorArrayΪnull");
		}
		//return locator = new Locator(locatorName);
		return locator;
    }

    /** 
    * @Title: getLocator 
    * @Description: ͨ�������name��ȡĳ������locator����,Common(String path, int index)
    * @param name
    * @param col:excel�в��������ڵڼ���
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
						log.debug("ͨ��ָ���Ĳ������ݳ�ʼ��locator����ɹ�������By��element��value�ֱ��ǣ�"+locatorArray[i][2]+", "+locatorArray[i][3]+", "+locatorArray[i][col]);
					}else if(locatorArray[i].length==4){
						locator = new Locator(locatorArray[i][2], locatorArray[i][3]);
						log.debug("��ʼ��locator����ɹ�������By��element��value�ֱ��ǣ�"+locatorArray[i][2]+", "+locatorArray[i][3]);
					}else{
						log.warn("locatorArray�ĳ��Ȳ���ȷ�����е�name��"+name);
					}
				}
			}
		}else {
			log.warn("locatorArrayΪnull");
		}
		//return locator = new Locator(locatorName);
		return locator;
    }
    
    /** 
    * @Title: getLocator 
    * @Description: ��ȡLocator����
    * @param s_by
    * @param s_element
    * @return
    * @return Locator
    * @throws 
    */
    public Locator getLocator(String s_by, String s_element) {

    	log.debug("��ʼ��Locator����2��ֵ�ֱ�Ϊ"+s_by+"��"+s_element);
    	Locator locator = new Locator(s_by, s_element);
		return locator;
    }
    
    /** 
    * @Title: getLocator 
    * @Description: ��ȡLocator����,����3������
    * @param s_by
    * @param s_element
    * @param value
    * @return
    * @return Locator
    * @throws 
    */
    public Locator getLocator(String s_by, String s_element, String value) {
    	log.info("getLocator(String s_by, String s_element, String value)");
    	log.debug("��ʼ��Locator����3��ֵ�ֱ�Ϊ"+s_by+"��"+s_element+"�� "+value);
    	Locator locator = new Locator(s_by, s_element, value);
		return locator;
    }
    
    /** 
    * @Title: isElementPresent 
    * @Description: �жϵ�ǰԪ���Ƿ�ɼ�
    * @param driver
    * @param locator
    * @return
    * @throws IOException
    * @return boolean
    * @throws 
    */
    public boolean isElementPresent(final Locator locator) {
        log.info("�ж�Ԫ���Ƿ�ɼ�");
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
	* @Description: new Common() ����
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
	* @Description: new Common(String path, int index) ����
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
	* @Description: ��JS�����������ֵ
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
	* @Description: ִ��js
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
	* @Description: TODO��ת��Ĭ�ϵĴ���
	* @return void
	* @throws 
	*/
	public void toDefaultContent() {
		dr.switchTo().defaultContent();
	}
	
	/** 
	* @Title: toParentFrame 
	* @Description: TODO��ת����һ���Ĵ���
	* @return void
	* @throws 
	*/
	public void toParentFrame() {
		dr.switchTo().parentFrame();
	}
	
	
	/** 
	* @Title: toFrame 
	* @Description: ��ת��Frame
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
			log.warn("toFrame(Object ob)���������������");
		}
	}

	/** 
	* @Title: setRichTextBox 
	* @Description: ���ø��ı�������
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
	* @Description: �õ����ı�������
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
	* @Description: ��������������ĳ��Ԫ��
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
	* @Description: �������
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
	* @Title: selectByIndexͨ�������������ѡ��Select 
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
	* @Description: new Common() ����,ͨ��select��valueѡ���������ֵ
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
	* @Description:  new Common() ����,ͨ��select�Ŀɼ��ı�ѡ���������ֵ
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
	* @Description: new Common() ����,�Զ��ж�Locator��Valueֵ��������alueֵȥ����Ӧ��ѡ��
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
	* @Description: TODO�õ�Select
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
	* @Description:  Alert������ı������ȷ��
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
	* @Description: Alert������ı�������ر�
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
	* @Description: �õ�Alert������ı�
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
	* @Description: ҳ��ˢ��
	* @return void
	* @throws 
	*/
	public void refreshPage() {
		dr.navigate().refresh();
	}
	
	/** 
	* @Title: forwardPage 
	* @Description: ҳ��ǰ��
	* @return void
	* @throws 
	*/
	public void forwardPage() {
		dr.navigate().forward();
	}
	
	/** 
	* @Title: backPage 
	* @Description: ҳ�����
	* @return void
	* @throws 
	*/
	public void backPage() {
		dr.navigate().back();
	}

}
