package com.salesforce.utility;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CommonUtilities {
	
	public static Date date;
	
	public static String getApplicationProperty(String Key) {

		Properties properties = new Properties();
		String filePath = Constants.APPLICATION_PROPERTIES_PATH;

		FileInputStream inputfile = null;
		try {
			inputfile = new FileInputStream(filePath);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		String value = null;

		try {
			try {
				properties.load(inputfile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			value = properties.getProperty(Key);
		} finally {
			try {
				inputfile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return value;
	}

	public static String takeScreenShot(WebDriver driver) {
		//GenerateReports report=GenerateReports.getInstance();
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//report.logTestInfo("Screeen Shot Captured");
		String filePath=Constants.SCREENSHOT_PATH+"Salesforce_"+getDateDDAndSeconds()+".jpg";
		File DestFile=new File(filePath);
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filePath;

	}
	
	public static long getTime() {
		date = new Date();
		return date.getTime();
	}

	public static String getTodaysDateMMDDYYYY() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
		Date date = new Date();
		String todaysDate = dateFormat.format(date);
		return todaysDate;
	}

	public static String getDateDDAndSeconds() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd ss");
		Date date = new Date();
		String dateDD = dateFormat.format(date);
		return dateDD;
	}

	public static String getDateAndTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		String dateDD = dateFormat.format(date);
		return dateDD;
	}

	public static String getCurrentDay() {
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println("Today Int: " + todayInt + "\n");
		String todayStr = Integer.toString(todayInt);
		System.out.println("Today Str: " + todayStr + "\n");
		return todayStr;
	}

	public static String getCurrentDayPlus(int days) {
		LocalDate currentDate = LocalDate.now();
		System.out.println("Current Date :" + currentDate);
		int dayOfWeekPlus = currentDate.getDayOfWeek().plus(days).getValue();
		System.out.println("Days : " + dayOfWeekPlus);
		return Integer.toString(dayOfWeekPlus);
	}

	public static void setClipboardData(String path) {
		// StringSelection is a class that can be used for copy and paste operations.
		StringSelection stringSelection = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}


}
