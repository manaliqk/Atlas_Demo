package com.qk.common.function;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileWriter_Text {

	public void writeResponse(String Response) throws IOException {

		DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss_");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); // 2016/11/16 12:08:43

		File responseDir = new File("src/test/resources/api/TataDigitalApiResponses/" + dateFormat.format(date)
				+ getClass().getSimpleName());

		responseDir.mkdirs();

		File responseFile = new File(responseDir + "/Response.txt");
		FileWriter wrResponse = new FileWriter(responseFile);
		BufferedWriter BW = new BufferedWriter(wrResponse);

		wrResponse.write(Response);
		wrResponse.close();
	}

}
