package com.core.util;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.core.dao.Locator;

/** 
 * @author QiaoJiafei 
 * @version 创建时间：2015年10月26日 上午10:51:41 
 * 类说明 
 */
public class GetIMGYzm {
	static String s = "";

    public static String getYZM(final WebDriver dr, final Locator lc) {
    	Log log = new Log(GetIMGYzm.class);
    	final Common cm = new Common(dr);
    	
    	//dr.get("http://172.16.30.227:8075/gm_product_site/sub_login/image");
    	log.info("获取图片验证码开始");
        WebDriverWait wait = new WebDriverWait(dr,10);
        WebElement element = wait.until(new ExpectedCondition<WebElement>() {

            @Override
            public WebElement apply(WebDriver arg0) {
                // TODO Auto-generated method stub
                return cm.findElement(lc);
            }
            
        });
        File scrFile = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);

        try {
            Point p = element.getLocation();
            int width = element.getSize().getWidth();
            int higth = element.getSize().getHeight();
            Rectangle rect = new Rectangle(width, higth);
            BufferedImage img = ImageIO.read(scrFile);
            BufferedImage dest = img.getSubimage(p.getX(), p.getY(), width, higth);
            ImageIO.write(dest, "png", scrFile);
            Thread.sleep(1000);
            File fng = new File("C:/yzm.png");
            if(fng.exists()){
                fng.delete();
            }
            FileUtils.copyFile(scrFile, fng);
            
            Runtime rt = Runtime.getRuntime();
            rt.exec("cmd.exe /C  tesseract.exe C:\\yzm.png  C:\\result -1 -psm 7");
            Thread.sleep(1000);
            File file = new File("C:\\result.txt");
            if(file.exists()) {
                FileHandler fh = new FileHandler();
                s = fh.readAsString(file).trim();
                
                log.debug("获取到的验证码为"+s);
            } else {
               
                log.warn("C:\\result.txt不存在");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        log.info("获取验证码结束");
        return s;
    }
/*    public static void main(String args[]) {
    	
		String key = "webdriver.chrome.driver";
		String value = "D:/BaiduYunDownload/selenium/chromedriver.exe";
		System.setProperty(key, value);
		WebDriver dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get("http://172.16.30.227:8075/gm_product_site/admin/sub_login.jsp?no=code");
		System.out.println(dr.findElement(By.xpath("//ul[@class='admin_items']/li[3]/center[1]/span")).getText());
		//getYZM(dr);
		
		dr.quit();
    }*/
}
