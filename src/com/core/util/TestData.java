package com.core.util;

import java.util.Map;

/** 
 * @author QiaoJiafei 
 * @version ����ʱ�䣺2016��2��25�� ����10:52:46 
 * ��˵��  ͨ��excel��ȡ��������
 */
public class TestData {
	static String filepaString = "D:/git/webautocore/excel/testdata.xls";
	public static Map<String, String> getTestData(int sheet, int caseNum) {
		Map<String, String> map = OptionFile.getExcelDataByCaseNum(filepaString, sheet, caseNum);
		return map;
	}
}
