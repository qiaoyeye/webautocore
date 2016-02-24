package com.core.util;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

/** 
 * @author QiaoJiafei 
 * @version 创建时间：2015年11月10日 下午2:08:46 
 * 类说明 
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
