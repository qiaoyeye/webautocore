package com.core.base;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import sun.util.logging.resources.logging;

import com.core.util.Log;
import com.core.util.OptionFile;
import com.core.util.Priority;


/** 
 * @author QiaoJiafei 
 * @version 创建时间：2016年1月14日 下午2:13:10 
 * 类说明 
 */
public class BaseProvider {
	static Log log = new Log(BaseProvider.class);	
	@DataProvider(name="testdp")
	public static Iterator<Object[]> createData(Method method, ITestContext context) throws Exception{
		
		//使用java反射机制，自动获取运行的测试类，并获得该类的成员变量的值
		String testclass = method.getDeclaringClass().getName();
		System.out.println("数据驱动得到的class："+testclass);
		Class clzz = Class.forName(testclass);
		Object object = clzz.newInstance();
		Field field = clzz.getDeclaredField("sheet");
		String testsheet = field.get(object).toString();
		System.out.println("数据驱动得到的sheet："+testsheet);
		
		int case_count = 0;
		int case_start = 4;
		int sheet = Integer.parseInt(testsheet);
		Priority p = null;
		final String P_FROM_PROPERTY = OptionFile.readProperties("./conf/Myconfig.properties", "priority");
		System.out.println("获取到的优先级为："+P_FROM_PROPERTY);
		
		//---------------读取excel并获取执行的用例开始--------------
		
		List<Integer> listtemp = OptionFile.getExcelPriority("./excel/testdata.xls", sheet, P_FROM_PROPERTY);
		//System.out.println("OptionFile的list大小"+listtemp.size());
		if (listtemp.size()<1) {
			log.debug("获取到的用例优先级的个数为0，注意测试用例将不执行");
		}
		
		log.debug("驱动得到的测试数据数量为："+listtemp.size());
		
		List<Object[]> list = new ArrayList<Object[]>();
		for(Integer itg:listtemp) {
			list.add(new Object[]{itg});
		}
		
		return list.iterator();
		
		//---------------读取excel并获取执行的用例结束--------------
	}
}
