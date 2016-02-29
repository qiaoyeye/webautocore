package com.core.util;

import java.util.Map;

/** 
 * 根据测试驱动类提供的测试数据行数，来得到excel中相应的测试数据，返回Map。key=列标题，value=列标题下的值
 * @author QiaoJiafei 
 * @version 创建时间：2016年2月25日 上午10:52:46 
 * 类说明  通过excel获取测试数据
 */
public class TestData {
	static String filepaString = "D:/git/webautocore/excel/testdata.xls";
	public static Map<String, String> getTestData(int sheet, int caseNum) {
		Map<String, String> map = OptionFile.getExcelDataByCaseNum(filepaString, sheet, caseNum);
		return map;
	}
}
