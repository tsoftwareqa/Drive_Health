/**
 * 
 */
package com.drivehealth.test.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class DataHelper {

	private static Logger logger = Logger.getLogger(DataHelper.class.getName());

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static FileInputStream fileInputStream;
	static FileOutputStream fileOutputStream;
	static File srcFile;
	static File destFile;

	static {
		srcFile = new File(System.getProperty("user.dir") + "/src/test/resources/sources/DriveHealthTestData.xlsx");
		try {
			fileInputStream = new FileInputStream(srcFile);
			try {
				workbook = new XSSFWorkbook(fileInputStream);
			} catch (IOException e) {
				System.out.println(e.getMessage());
				logger.info("Issue with file");
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void writeOrgInfo(String orgname,int cell) {
		sheet = workbook.getSheet("OrgData");
			XSSFRow row = sheet.createRow((short) 1);
			row.createCell(cell).setCellValue(orgname);		
		try {
			fileOutputStream = new FileOutputStream(srcFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook.write(fileOutputStream);
			fileOutputStream.flush();
			fileOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info("Excel file has been generated successfully");
	}
	
	public static void writeSubOrgInfo(String orgname,int cell) {
		sheet = workbook.getSheet("SubOrgData");
			XSSFRow row = sheet.createRow((short) 1);
			row.createCell(cell).setCellValue(orgname);		
		try {
			fileOutputStream = new FileOutputStream(srcFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook.write(fileOutputStream);
			fileOutputStream.flush();
			fileOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info("Excel file has been generated successfully");
	}
	
	public static void writeMemberInfo(String sheetname, String membername,int cell) {
		sheet = workbook.getSheet(sheetname);
			XSSFRow row = sheet.createRow((short) 1);
			row.createCell(cell).setCellValue(membername);		
		try {
			fileOutputStream = new FileOutputStream(srcFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook.write(fileOutputStream);
			fileOutputStream.flush();
			fileOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info("Excel file has been generated successfully");
	}
		
	public static void writeStaffInfo(String sheetname, String membername,int rows, int cell) {
		sheet = workbook.getSheet(sheetname);
			XSSFRow row = sheet.createRow((short) rows);
			row.createCell(cell).setCellValue(membername);		
		try {
			fileOutputStream = new FileOutputStream(srcFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook.write(fileOutputStream);
			fileOutputStream.flush();
			fileOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info("Excel file has been generated successfully");
	}
	public static String getRecord(String sheetname, int row, int col) {
		DataFormatter formatter = new DataFormatter();
		sheet = workbook.getSheet(sheetname);
		XSSFCell cell = sheet.getRow(row).getCell(col);
		String SheetData = formatter.formatCellValue(cell);
		return SheetData;
	}
}
