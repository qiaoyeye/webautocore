package com.core.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.openqa.selenium.io.FileHandler;

/** 
* @ClassName: OptionFile 
* @Description: 操作文件类
* @author qiaojiafei 
* @date 2015年10月22日 下午2:02:12 
*  
*/
public class OptionFile {
	public static void main(String args[]) {
		System.out.println(getExcel("D:/03excel.xls",1,2,2));
		System.out.println(getExcel("D:/07excel.xlsx",1,2,2));
		//System.out.println(getLocatorArray("D:/03excel.xls",1).length);
		
		System.out.println(readWord("D:/work/项目/交易C/创意阳光/创意阳关ui和模版/创意阳光/彩虹计划协议_V1.0.doc"));
	}
	static Log log = new Log(OptionFile.class);
	/** 
	* @Title: getPropertiesValue 
	* @Description: 获取properties文件内容值，路径是死的
	* @param filename
	* @param key
	* @return
	* @return String
	* @throws 
	*/
	public static String getPropertiesValue(String filename, String key) {
		String s = null;
		InputStream in = null;
		Properties props = new Properties();
		String s1 = null;
		log.debug("Get the properties file: "+filename+",key="+key);
		try {
			in = OptionFile.class.getClassLoader().getResourceAsStream(filename);
			props.load(in);
			s = props.getProperty(key);
			if(s!=null){
				s1 = new String(s.getBytes("ISO-8859-1"),"UTF-8");
			}else{
				log.error("传入的值在propertis文件中不存在，值="+key);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
			return s1;
	}
	
	/** 
	* @Title: readProperties 
	* @Description: TODO读取readProperties文件，通过路径
	* @param filePath
	* @param key
	* @return
	* @return String
	* @throws 
	*/
	public static String readProperties(String filePath, String key) {
	    Properties props = new Properties();
	    String s = null;
	    String s1 = null;
	       try {
	        InputStream in = new BufferedInputStream (new FileInputStream(filePath));
	        props.load(in);
	        s = props.getProperty(key);
			if(s!=null){
				s1 = new String(s.getBytes("ISO-8859-1"),"UTF-8");
			}else{

			}
	       } catch (Exception e) {
	        e.printStackTrace();
	       }
	       return s1;
	   }
	
	/** 
	* @Title: setExcel 
	* @Description: 设置excel，包括excel03和07
	* @param path
	* @param sheet
	* @param row
	* @param col
	* @param value
	* @return void
	* @throws 
	*/
	public static void setExcel(String path, int index, int rowNum, int colNum,String value) {
		File file = new File(path);
		String cellValue = "";
		Workbook wb = null;
		Sheet sheet = null;
		Row row = null;
		Cell cell = null;
		try {
			FileInputStream in = new FileInputStream(file);
			if(path.endsWith(".xls")) {
				wb = new HSSFWorkbook(in);
				sheet = wb.getSheetAt(index-1);
				
				row = sheet.getRow(rowNum-1);
				cell = row.createCell(colNum-1);//目标列的索引
				HSSFRichTextString val = new HSSFRichTextString(value);
				cell.setCellValue(val);
			}else if (path.endsWith(".xlsx")) {
				wb = new XSSFWorkbook(in);
				sheet = wb.getSheetAt(index-1);
				
				row = sheet.getRow(rowNum-1);
				cell = row.createCell(colNum-1);//目标列的索引
				XSSFRichTextString val = new XSSFRichTextString(value);
				cell.setCellValue(val);
			}
			
			//cell = row.getCell(colNum-1);
			
			OutputStream out = new FileOutputStream(file);//获取文件输出流
			wb.write(out);//将内容写到excel
			out.close();
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/** 
	* @Title: getExcel 
	* @Description: 读取excel，包括excel03和07
	* @param path
	* @param index
	* @param rowNum
	* @param colNum
	* @return
	* @return String
	* @throws 
	*/
	public static String getExcel(String path,int index,int rowNum,int colNum) {
		File file = new File(path);
		String cellValue = "";
		Workbook wb = null;
		Sheet sheet = null;
		Row row = null;
		Cell cell = null;
		try {
			FileInputStream in = new FileInputStream(file);
			if(path.endsWith(".xls")) {
				wb = new HSSFWorkbook(in);
				sheet = wb.getSheetAt(index-1);
			}else if (path.endsWith(".xlsx")) {
				wb = new XSSFWorkbook(in);
				sheet = wb.getSheetAt(index-1);
			}
			row = sheet.getRow(rowNum-1);
			cell = row.getCell(colNum-1);
			if(cell!=null){
			   switch(cell.getCellType()) {
				   case Cell.CELL_TYPE_STRING:
					   cellValue = cell.getStringCellValue().trim();
					   break;
				   case Cell.CELL_TYPE_NUMERIC:
					   if(HSSFDateUtil.isCellDateFormatted(cell)) {
						   Date date = cell.getDateCellValue();
                           if (date != null) {
                        	   cellValue = new SimpleDateFormat("yyyy-MM-dd").format(date);
                           } else {
                        	   cellValue = "";
                           }
					   }else {
						   cellValue = new DecimalFormat("###.###").format(cell.getNumericCellValue());
                        }
                        break;
				   case Cell.CELL_TYPE_FORMULA:


                       if (!cell.getStringCellValue().equals("")) {
                    	   cellValue = cell.getStringCellValue();
                       } else {
                    	   cellValue = cell.getNumericCellValue() + "";
                       }
                       break;

                   case Cell.CELL_TYPE_BLANK:
                       break;

                   case Cell.CELL_TYPE_ERROR:
                	   cellValue = "";
                       break;

                   case HSSFCell.CELL_TYPE_BOOLEAN:

                	   cellValue = (cell.getBooleanCellValue() == true ? "Y": "N");
                       break;
                       
                   default:
                	   cellValue = "";
			   }
		   }
			   in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return cellValue;
	
	}
	
	/** 
	* @Title: getExcel 
	* @Description: 获取excel的值
	* @param path
	* @param index
	* @param rowNum
	* @param colNum
	* @return
	* @return String
	* @throws 
	*/
	/*
	public static String getExcel(String path,int index,int rowNum,int colNum) {
		log.debug("读取excel："+path+"，SHEET:"+index+"，行："+rowNum+"，列："+colNum);
		File file = new File(path);
		String cellValue = "";
		int rowN = rowNum-1;//将excel的行数-1
		
		Row row = null;
		Cell cell= null;
		HSSFCell hf = null;
	
		try {
		   FileInputStream in = new FileInputStream(file);
		   HSSFWorkbook wb = new HSSFWorkbook(in);   //EXCEL03
		   HSSFSheet sheet = wb.getSheetAt(index-1);//sheet页，index从0开始	   
		   row = sheet.getRow(rowN-1);       //取得第几行,从0开始
		   cell = row.getCell(colNum-1);        //取得行的第3列,从0开始
		   if(cell!=null){
			   switch(cell.getCellType()) {
				   case Cell.CELL_TYPE_STRING:
					   cellValue = cell.getStringCellValue().trim();
					   break;
				   case Cell.CELL_TYPE_NUMERIC:
					   if(HSSFDateUtil.isCellDateFormatted(cell)) {
						   Date date = cell.getDateCellValue();
                           if (date != null) {
                        	   cellValue = new SimpleDateFormat("yyyy-MM-dd").format(date);
                           } else {
                        	   cellValue = "";
                           }
					   }else {
						   cellValue = new DecimalFormat("###.###").format(cell.getNumericCellValue());
                        }
                        break;
				   case HSSFCell.CELL_TYPE_FORMULA:


                       if (!cell.getStringCellValue().equals("")) {
                    	   cellValue = cell.getStringCellValue();
                       } else {
                    	   cellValue = cell.getNumericCellValue() + "";
                       }
                       break;

                   case HSSFCell.CELL_TYPE_BLANK:
                       break;

                   case HSSFCell.CELL_TYPE_ERROR:
                	   cellValue = "";
                       break;

                   case HSSFCell.CELL_TYPE_BOOLEAN:

                	   cellValue = (cell.getBooleanCellValue() == true ? "Y": "N");
                       break;
                       
                   default:
                	   cellValue = "";
			   }
		   }
		   in.close();
	   }catch (Exception e) {
			  e.printStackTrace();
	   }  
	   	return cellValue;
	}
	*/
	public static String[][] getLocatorArray(String path, int index) {
		log.debug("读取整个excel内容："+path+"，SHEET:"+index);
		File file = new File(path);
		Workbook wb = null;
		Sheet sheet = null;
		//Row row = null;
		//Cell cell = null;
		FileInputStream in;
		String[][] locatorMap = null;
		try {
			in = new FileInputStream(file);
			if(path.endsWith(".xls")) {
				wb = new HSSFWorkbook(in);
				sheet = wb.getSheetAt(index-1);
			}else if (path.endsWith(".xlsx")) {
				wb = new XSSFWorkbook(in);
				sheet = wb.getSheetAt(index-1);
			}
			//HSSFWorkbook wb = new HSSFWorkbook(new POIFSFileSystem(in));
			//Sheet sheet = wb.getSheetAt(index);
			Row header = sheet.getRow(0);
			String cellValue = "";
			locatorMap = new String[sheet.getLastRowNum() + 1][header
					.getLastCellNum()];
			for (int rownum = 0; rownum <= sheet.getLastRowNum(); rownum++) {
				// for (Cell cell : row)
				Row row = sheet.getRow(rownum);

				if (row == null) {
					continue;
				}
				
				for (int cellnum = 0; cellnum <= row.getLastCellNum(); cellnum++) {
					Cell cell = row.getCell(cellnum);
					if (cell != null) {
						switch(cell.getCellType()) {
						   case Cell.CELL_TYPE_STRING:
							   cellValue = cell.getStringCellValue().trim();
							   break;
						   case Cell.CELL_TYPE_NUMERIC:
							   if(HSSFDateUtil.isCellDateFormatted(cell)) {
								   Date date = cell.getDateCellValue();
		                        if (date != null) {
		                     	   cellValue = new SimpleDateFormat("yyyy-MM-dd").format(date);
		                        } else {
		                     	   cellValue = "";
		                        }
							   }else {
								   cellValue = new DecimalFormat("###.###").format(cell.getNumericCellValue());
		                     }
		                     break;
						   case HSSFCell.CELL_TYPE_FORMULA:


		                    if (!cell.getStringCellValue().equals("")) {
		                 	   cellValue = cell.getStringCellValue();
		                    } else {
		                 	   cellValue = cell.getNumericCellValue() + "";
		                    }
		                    break;

		                case HSSFCell.CELL_TYPE_BLANK:
		                    break;

		                case HSSFCell.CELL_TYPE_ERROR:
		             	   cellValue = "";
		                    break;

		                case HSSFCell.CELL_TYPE_BOOLEAN:

		             	   cellValue = (cell.getBooleanCellValue() == true ? "Y": "N");
		                    break;
		                    
		                default:
		             	   cellValue = "";
					   }
						locatorMap[rownum][cellnum] = cellValue;
				   } else {
						cellValue = "";
					}
					
				}
			}
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return locatorMap;
	}
	
	/** 
	* @Title: readTxt 
	* @Description: JAVA读取txt文件
	* @param path
	* @return
	* @return String
	* @throws 
	*/
	public static String readTxt(String path) {
		log.debug("读取Txt："+path);
		File file = new File(path);
		StringBuffer txt= new StringBuffer();
		if(file.isFile() && file.exists()) {
			//InputStreamReader in = null;
			try {
				InputStreamReader in = new InputStreamReader(new FileInputStream(file),"GBK");
				BufferedReader bfd = new BufferedReader(in);
				String s;
				while((s=bfd.readLine())!=null) {
					txt.append(s);
				}
				in.close();
				bfd.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return txt.toString();
	}
	
	/** 
	* @Title: readTxtByS 
	* @Description: selenium读取txt文件
	* @param path
	* @return
	* @return String
	* @throws 
	*/
	public static String readTxtByS(String path) {
		log.debug("读取Txt："+path);
		File file = new File(path);
		String s = null;
		try {
			s = FileHandler.readAsString(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	public static StringBuffer readWord(String path) {
		log.debug("读取word文件："+path);
        String s = "";
		try {
			if(path.endsWith(".doc")) {
	            InputStream is = new FileInputStream(new File(path));
	            WordExtractor ex = new WordExtractor(is);
	            s = ex.getText();
			}else if (path.endsWith("docx")) {
				OPCPackage opcPackage = POIXMLDocument.openPackage(path);
	            POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
	            s = extractor.getText();
			}else {
				log.warn("传入的word文件不正确:"+path);
			}

        } catch (Exception e) {
            e.printStackTrace();
        }
		StringBuffer bf = new StringBuffer(s);
		return bf;
	}

}
