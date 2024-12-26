package com.drivehealth.test.page_objects;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class SettingsObject extends PageObject {

	public static Target SETTINGS = Target.the("settings").locatedBy("//div[contains(text(),'Settings')]");

	public static Target ORG_NAME = Target.the("orgname").locatedBy(
			"(//li[@class='p-3 cursor-pointer rounded-md hover:bg-gradient-to-r from-[#1a7ec534] to-[#4fe7ad34]'])[2]");

	public static Target TIME_WIN_RESET_BTN = Target.the("reset btn")
			.locatedBy("(//button[contains(text(),'Reset to last settings')])[1]");

	public static Target WORKFLOW_CALL_RESET_BTN = Target.the("reset btn")
			.locatedBy("(//button[contains(text(),'Reset to last settings')])[2]");

	public static Target FROM_TIME = Target.the("from time").locatedBy("(//input[@name='hour12'])[1]");

	public static Target TO_TIME = Target.the("to time").locatedBy("(//input[@name='hour12'])[2]");

	public static Target TIME_WIN_SAVE_BTN = Target.the("save button")
			.locatedBy("(//button[contains(text(),'Save')])[1]");

	public static Target WORKFLOW_CALL_SAVE_BTN = Target.the("save button")
			.locatedBy("(//button[contains(text(),'Save')])[2]");

	public static Target INITIAL_CALL = Target.the("initial call").locatedBy("(//input[@id='before_start'])[1]");
	
	public static Target RECURRING_CALL = Target.the("recurring call").locatedBy("//input[@id='recurring_day']");

	public static Target RETRY_CALL = Target.the("retry call").locatedBy("(//input[@id='frequency'])[1]");

	public static Target HOURS = Target.the("hours").locatedBy("(//input[@id='hours'])[1]");

	public static Target DAYS = Target.the("days").locatedBy("(//input[@id='days'])[1]");

	public static Target FROM_CROSS_ICON = Target.the("cross icon")
			.locatedBy("(//button[@class='react-time-picker__clear-button react-time-picker__button'])[1]");

	public static Target TO_CROSS_ICON = Target.the("cross icon")
			.locatedBy("(//button[@class='react-time-picker__clear-button react-time-picker__button'])[2]");

	public static Target FROM_MINUTE = Target.the("from minute").locatedBy("(//input[@name='minute'])[1]");

	public static Target TO_MINUTE = Target.the("to minute").locatedBy("(//input[@name='minute'])[2]");

	public static Target FROM_AM_PM = Target.the("am pm").locatedBy("(//select[@name='amPm'])[1]");

	public static Target TO_AM_PM = Target.the("am pm").locatedBy("(//select[@name='amPm'])[2]");

	public static Target SESSION_TIMEOUT = Target.the("session timeout").locatedBy("//input[@id='timeout_duration']");

	public void clearInitialCallField() {
		WebElement ele1 = getDriver().findElement(By.xpath("(//input[@id='before_start'])[1]"));
		String s = Keys.chord(Keys.CONTROL, "a");
		ele1.sendKeys(s);
		ele1.sendKeys(Keys.DELETE);
	}
		
	public void clearRetryTimesField() {
		WebElement ele2 = getDriver().findElement(By.xpath("(//input[@id='frequency'])[1]"));
		String s = Keys.chord(Keys.CONTROL, "a");
		ele2.sendKeys(s);
		ele2.sendKeys(Keys.DELETE);
	}
	
	public void clearRetryHourField() {
		WebElement ele3 = getDriver().findElement(By.xpath("(//input[@id='hours'])[1]"));
		String s = Keys.chord(Keys.CONTROL, "a");
		ele3.sendKeys(s);
		ele3.sendKeys(Keys.DELETE);
	}
	
	public void clearRetryDaysField() {
		WebElement ele4 = getDriver().findElement(By.xpath("(//input[@id='days'])[1]"));
		String s = Keys.chord(Keys.CONTROL, "a");
		ele4.sendKeys(s);
		ele4.sendKeys(Keys.DELETE);
	}
	
	public void clearSessionField() {
		WebElement ele4 = getDriver().findElement(By.xpath("//input[@id='timeout_duration']"));
		String s = Keys.chord(Keys.CONTROL, "a");
		ele4.sendKeys(s);
		ele4.sendKeys(Keys.DELETE);
	}
	
	public static String generateSessionValue() {
        Random random = new Random();
        int randomNumber = random.nextInt(12) + 1;
        String result = Integer.toString(randomNumber * 5);    
        return result;
	}

}
