package com.qk.common.function;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Executor1 {

	public static String filepath;
	static XSSFCellStyle cellstyle;

	public static void writeReport(ExecutionReport exe) throws Exception {
		PreConditions cond = new PreConditions();
		cond.getProperties();
		filepath = cond.reportPath();
		System.out.println("filepath " +filepath);
		File file = new File(filepath);
		System.out.println("filepath................................. " + filepath);
		FileInputStream fIP = new FileInputStream(file);

		XSSFWorkbook workbook = new XSSFWorkbook(fIP);
		XSSFSheet sheet = workbook.getSheetAt(0);

		ExecutionReport report =  exe;
		
		int x = sheet.getLastRowNum() + 1;
		int col = 0;
		
		XSSFRow ex_row = sheet.createRow(x++);
		

		String testcaseid = report.getTestcaseid();
		String module = report.getModule();
		String act_result = report.getActualResult();
		int statusCode = report.getStatusCode();		
		String executionStatus = report.getExecutionStatus();		
		long exe_time = report.getExecutionTime();

		
		

		Font cellfont = workbook.createFont();
        cellfont.setFontHeightInPoints((short) 10);
        cellfont.setFontName("Calibri");
        
        XSSFCellStyle cellstyle = workbook.createCellStyle();
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
		
		sheet.setColumnWidth(col, 500 * 10);
		Cell cell1 = ex_row.createCell(col++);
		cell1.setCellStyle(cellstyle);
		cell1.setCellValue(module);

		sheet.setColumnWidth(col, 500 * 10);
		Cell cell2 = ex_row.createCell(col++);
		cell2.setCellStyle(cellstyle);


		sheet.setColumnWidth(col, 500 * 10);
		Cell cell7 = ex_row.createCell(col++);
		cell7.setCellStyle(cellstyle);
		cell7.setCellValue(testcaseid);
		

		sheet.setColumnWidth(col, 500 * 10);
		Cell cell10 = ex_row.createCell(col++);
		cell10.setCellStyle(cellstyle);
		cell10.setCellValue(act_result);
		
		sheet.setColumnWidth(col, 500 * 10);
		Cell cell11 = ex_row.createCell(col++);
		cell11.setCellStyle(cellstyle);
		cell11.setCellValue(statusCode);

		sheet.setColumnWidth(col, 500 * 10);
		Cell cell13 = ex_row.createCell(col++);
		cell13.setCellStyle(cellstyle);
		cell13.setCellValue(executionStatus);

		sheet.setColumnWidth(col, 500 * 10);
		Cell cell14 = ex_row.createCell(col++);
		cell14.setCellStyle(cellstyle);
		cell14.setCellValue(exe_time);

		
		FileOutputStream outputstream = new FileOutputStream(file);
		workbook.write(outputstream);
		outputstream.close();
		workbook.close();	
		
	}
	
}