package com.drivehealth.test.utils;

import com.ibm.icu.text.SimpleDateFormat;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class CommonUtil {

	private static Logger logger = Logger.getLogger(CommonUtil.class.getName());

	public static String setParameterValue(String defaultValue, String passedValue) {
		String parameterValue = StringUtils.isNotBlank(passedValue) ? passedValue : defaultValue;
		return parameterValue;
	}

	public static void staticWaitFor(Long milliSec) {
		try {
			Thread.sleep(milliSec);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * This method will convert date string from one format to another format
	 * 
	 * @param inputDateString
	 * @param formatIn
	 * @param formatOut
	 * @return formated date
	 */
	public static String dateFormatConvertor(String inputDateString, String formatIn, String formatOut) {

		SimpleDateFormat inputFormat = new SimpleDateFormat(formatIn);
		SimpleDateFormat outputFormat = new SimpleDateFormat(formatOut);
		Date inputDate = null;

		try {
			inputDate = inputFormat.parse(inputDateString);
		} catch (ParseException e) {
			logger.severe("Parse Exception occurred while parsing the date : " + inputDateString + "to the format:"
					+ formatIn);
			return inputDateString;
		}

		String outputDateString = outputFormat.format(inputDate);

		return outputDateString;
	}

	public static String generateNineDigitNumber() {
		String nowString = new java.text.SimpleDateFormat("yyMMdd").format(DateTime.now().toDate());
		String id = nowString.concat(String.valueOf(100 + (int) (Math.random() * ((999 - 100) + 1))));

		return id;
	}

	public static String generatetwelveDigitNumber() {
		String nowString = new java.text.SimpleDateFormat("yyyyMMdd").format(DateTime.now().toDate());
		String id = nowString.concat(String.valueOf(10000 + (int) (Math.random() * ((999 - 100) + 1))));

		return id;
	}

	public static Integer generateRandomNumber() {
		Random rand = new Random();
		int id = rand.nextInt(10000);
		return id;
	}

	public static String getCurrentDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
		Date date = new Date();
		return formatter.format(date);
	}

	public static boolean compareDates(String d1, String d2) {
		try {

			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			Date date1 = sdf.parse(d1);
			Date date2 = sdf.parse(d2);

			if (date1.after(date2)) {
				return true;
			} else if (date1.before(date2)) {
				return true;
			} else {
				return true;
			}

		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		return true;
	}

	public static String getCurrentDateTime() {
		SimpleDateFormat customformat = new SimpleDateFormat("dd_MM_yy_HH_mm_ss");
		Date currentDate = new Date();
		return customformat.format(currentDate);
	}

	public static String captureScreenshot(WebDriver driver) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotpath = System.getProperty("user.dir") + "/src/test/resources/screenshots/"
				+ getCurrentDateTime() + ".png";
		try {
			FileHandler.copy(src, new File(screenshotpath));
			System.out.println("Screenshot captured successfully");
		} catch (IOException e) {
			System.out.println("Unable to capture screenshot" + e.getMessage());
		}
		return screenshotpath;
	}

	public static String generateRandomString() {

		final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		// Initializing the random variable
		Random random = new Random();

		StringBuilder sb = new StringBuilder();

		// Generating Random String using loop
		for (int i = 0; i < 5; i++) {
			sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
		}
		return sb.toString();
	}

	public static void writeAtPosition(String filePath, int rowNum, int colNum, String newData) throws IOException {
		// Step 1: Read the existing CSV into memory
		List<String[]> rows = new ArrayList<>();

		try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
			String[] row;
			try {
				while ((row = reader.readNext()) != null) {
					rows.add(row);
				}
			} catch (CsvValidationException | IOException e) {
				e.printStackTrace();
			}
		}

		// Step 2: Check if the row and column positions are valid
		if (rowNum >= rows.size() || rowNum < 0) {
			throw new IllegalArgumentException("Row number is out of range.");
		}
		String[] targetRow = rows.get(rowNum);
		if (colNum >= targetRow.length || colNum < 0) {
			throw new IllegalArgumentException("Column number is out of range.");
		}

		// Step 3: Modify the specific cell with the new data
		targetRow[colNum] = newData;

		// Step 4: Write the updated data back to the CSV file
		try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
			writer.writeAll(rows);
		}
	}

	// Method to update all rows in a specific column
	public static void updateColumn(String filePath, int colNum, String newData) throws IOException {
		// Step 1: Read the existing CSV into memory
		List<List<String>> rows = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] columns = line.split(",");
				rows.add(new ArrayList<>(Arrays.asList(columns)));
			}
		}

		// Step 2: Check if the column number is valid
		if (colNum < 0 || colNum >= rows.get(0).size()) {
			throw new IllegalArgumentException("Column number is out of range.");
		}

		// Step 3: Update the specified column in all rows except the first (header)
		for (int i = 1; i < rows.size(); i++) { // Start from row 1 to skip the header (row 0)
			List<String> row = rows.get(i);
			row.set(colNum, newData.concat(",")); // Update the column with new data
		}

		// Step 4: Write the updated data back to the CSV file
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
			for (int i = 0; i < rows.size(); i++) {
				String rowString = String.join(",", rows.get(i));
				bw.write(rowString);
				// Avoid adding an extra line at the end
				if (i < rows.size() - 1) {
					bw.newLine(); // Add a new line after every row except the last one
				}
			}
		}
	}

	public static boolean isFileAvailable() {
		File folder = new File("C:\\workspace\\Drive_Health\\src\\test\\resources\\downloads");
		File[] listOfFiles = folder.listFiles();
		String memberfilename = "Organisation_Members_List_" + CommonUtil.getCurrentDate() + ".csv";
		boolean isFileAvailable = false;
		for (File listOfFile : listOfFiles) {
			if (listOfFile.isFile()) {
				String fileName = listOfFile.getName();
				if (fileName.equalsIgnoreCase("interaction_report.pdf")) {
					isFileAvailable = true;
				} else if (fileName.equalsIgnoreCase(memberfilename)) {
					isFileAvailable = true;
				} else if (fileName.equalsIgnoreCase("organization_report.xlsx")) {
					isFileAvailable = true;
				}
			}
		}
		return isFileAvailable;
	}

	public static void deleteFile() {
		File folder = new File("C:\\workspace\\Drive_Health\\src\\test\\resources\\downloads");
		File[] listOfFiles = folder.listFiles();
		String memberfilename = "Organisation_Members_List_" + CommonUtil.getCurrentDate();
		for (File listOfFile : listOfFiles) {
			if (listOfFile.isFile()) {
				String fileName = listOfFile.getName();
				if (fileName.equalsIgnoreCase("interaction_report.pdf") || fileName.startsWith(memberfilename)
						|| fileName.equalsIgnoreCase("organization_report.xlsx")) {
					listOfFile.delete();
				} else {
					System.out.println("No file present!");
				}
			}
		}

	}
}
