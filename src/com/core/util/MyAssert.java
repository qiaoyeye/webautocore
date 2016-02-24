package com.core.util;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

/** 
 * @author QiaoJiafei 
 * @version ����ʱ�䣺2015��11��10�� ����2:08:46 
 * ��˵�� 
 */
public class MyAssert {
	public static boolean flag = false;
	public static List<Error> errors = new ArrayList<Error>();
	
	public static void verifyEquals(Object actual, Object expected) {
        try{
            Assert.assertEquals(actual, expected);
        }catch(Error e){
            errors.add(e);
            flag = false;
        }
	}
	
	public static void verifyEquals(Object actual, Object expected, String message) {
        try{
            Assert.assertEquals(actual, expected, message);
        }catch(Error e){
            errors.add(e);
            flag = false;
        }
	}

}
