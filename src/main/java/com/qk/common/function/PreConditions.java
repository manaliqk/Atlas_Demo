package com.qk.common.function;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Properties;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class PreConditions {
	
	public static String report_path = null;
	Date StartTime = Calendar.getInstance().getTime();
	private static Properties prop = new Properties();
	private static String propertiesPath = ".";
	static XSSFCellStyle cellstyle;
	static XSSFCellStyle cellFormat;
	
	public void initReport(String TestSuiteName) throws Exception {
		getProperties();
		SimpleDateFormat year = new SimpleDateFormat("yyyy");
		SimpleDateFormat month = new SimpleDateFormat("MMM");
		SimpleDateFormat day = new SimpleDateFormat("dd");
		Calendar c = Calendar.getInstance();	
		report_path = prop.getProperty("report_path") + "\\" + year.format(c.getTime()) + "_"	+ month.format(c.getTime()) 
		+ "_" + day.format(c.getTime()) +"\\";	
		CreateReportFile(TestSuiteName);
		reportPath();
	} 
	
	@SuppressWarnings("resource")
	public static String CreateReportFile(String TestSuiteName) throws Exception {
//		TestSuiteName="API Test";
		File theDir = new File(report_path);
		if (!theDir.exists()) {
			boolean result = false;
			try {
				theDir.mkdirs();
				result = true;
			} catch (SecurityException localSecurityException) {
			}
			if (result) {
				System.out.println("Report Directory Created");
			}
			else{
				System.out.println("Report Directory Already Exist");
			}
		}
		
		File fl = new File(report_path);
		Date sys_date = new Date();
		String strDateFormat = "HH_mm_ss";
		DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		String formattedDate= dateFormat.format(sys_date);
		String FileName = TestSuiteName;
		report_path = report_path + FileName+ "_" + formattedDate + ".xlsx";   
		
		System.out.println("Report File Name: "+report_path);
		fl = new File(report_path);
		fl.createNewFile();	
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Execution Report");
		sheet.setColumnWidth(0, 500*10);

		XSSFRow row = sheet.createRow(0);
		row.setHeight((short) 600);

		Font font = workbook.createFont();
		font.setColor(IndexedColors.WHITE.getIndex());
		((XSSFFont) font).setBold(true);
		font.setFontHeightInPoints((short) 11);

		Font cellfont = workbook.createFont();
		cellfont.setFontHeightInPoints((short) 10);
		cellfont.setFontName("Calibri");

		cellFormat = workbook.createCellStyle();
		cellFormat.setAlignment(HorizontalAlignment.CENTER);
		cellFormat.setVerticalAlignment(org.apache.poi.ss.usermodel.VerticalAlignment.CENTER);
		cellFormat.setBorderBottom(BorderStyle.THIN);
		cellFormat.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		cellFormat.setBorderLeft(BorderStyle.THIN);
		cellFormat.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		cellFormat.setBorderRight(BorderStyle.THIN);
		cellFormat.setRightBorderColor(IndexedColors.BLACK.getIndex());
		cellFormat.setBorderTop(BorderStyle.THIN);
		cellFormat.setTopBorderColor(IndexedColors.BLACK.getIndex());
		cellFormat.setFont(font);
		cellFormat.setWrapText(true);
		cellFormat.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
		cellFormat.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cellstyle = workbook.createCellStyle();
		cellstyle.setBorderBottom(BorderStyle.THIN);
		cellstyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		cellstyle.setBorderLeft(BorderStyle.THIN);
		cellstyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		cellstyle.setBorderRight(BorderStyle.THIN);
		cellstyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
		cellstyle.setBorderTop(BorderStyle.THIN);
		cellstyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
		cellstyle.setWrapText(true);
		cellstyle.setFont(cellfont);

		LinkedList<String> headers = new LinkedList<>();
		headers.add("Module");
		headers.add("Test Case ID");
		headers.add("Actual Result");
		headers.add("Http Status");
		headers.add("Execution Status");
		headers.add("Execution Duration(Miliseconds)");
		//headers.add("Screenshot Path");

		int colNum = 0;

		for (String header : headers) {
			Cell cell = row.createCell(colNum++);
			cell.setCellStyle(cellFormat);
			cell.setCellValue(header);
		}

		XSSFSheet sheet1 = workbook.createSheet("Verification_Point");

		sheet1.setColumnWidth(0, 500*10);

		XSSFRow row1 = sheet1.createRow(0);
		row1.setHeight((short) 600);

		colNum = 0;

		headers.clear();
		headers.add("TestCase ID");
		headers.add("Module");
		headers.add("TestCase Description");
		headers.add("Field");
		headers.add("Expected Result");
		headers.add("Actual Result");
		headers.add("Status");

		colNum = 0;

		for (String header : headers) {
			Cell cell = row1.createCell(colNum++);
			cell.setCellStyle(cellFormat);
			cell.setCellValue(header);
		}

		FileOutputStream outputstream = new FileOutputStream(fl);
		workbook.write(outputstream);
		outputstream.close();

		return fl.toString();

	}
	
	public ExecutionReport initExecReport(HashMap<String, String>testDetail) {
		ExecutionReport exe = new ExecutionReport();

		exe.setModule(testDetail.get("Module"));
		exe.setTestcaseid(testDetail.get("TestCaseID"));
		return exe;
	}
	
	public String reportPath() throws Exception{
		System.out.println(report_path);
		return report_path;

	}
	
	public Properties getProperties() throws Exception {
			prop.load(new FileInputStream(propertiesPath +"\\src\\main\\resources"+"\\_config.properties"));
		return prop; 		
	}
	
	public void writeReport(ExecutionReport exe,HashMap<String,String> testDetail, String ActualResult, int StatusCode, String ExecutionStatus, long ExecutionTime) throws Exception{	
		exe.setExecutionStatus(ExecutionStatus);
		exe.setActualResult(ActualResult);
		exe.setStatusCode(StatusCode);
		exe.setExecutionTime(ExecutionTime);
//		ElasticSearchConnector.elkSearchConnect(exe);
		Executor1.writeReport(exe);
	}

	public void handleException(ExecutionReport exe, HashMap<String, String> testDetail, Exception ex, long ExecutionTime) throws Exception {	
		exe.setExecutionStatus("Fail");
		exe.setActualResult(ex.getMessage());
		exe.setExecutionTime(ExecutionTime);
//		ElasticSearchConnector.elkSearchConnect(exe);	
		Executor1.writeReport(exe);
	}
}
