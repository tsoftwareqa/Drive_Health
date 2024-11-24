package com.drivehealth.test.page_objects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class SettingsObject extends PageObject{

    public static Target SETTINGS = Target.the("settings").locatedBy("//div[contains(text(),'Settings')]");
	
	public static Target TIME_WIN_RESET_BTN = Target.the("reset btn").locatedBy("(//button[contains(text(),'Reset to last settings')])[1]");
	
	public static Target WORKFLOW_CALL_RESET_BTN = Target.the("reset btn").locatedBy("(//button[contains(text(),'Reset to last settings')])[2]");
	
	public static Target FROM_TIME = Target.the("from time").locatedBy("(//input[@name='hour12'])[1]");
	
	public static Target TO_TIME = Target.the("to time").locatedBy("(//input[@name='hour12'])[2]");
	
	public static Target TIME_WIN_SAVE_BTN = Target.the("save button").locatedBy("(//button[contains(text(),'Save')])[1]");
		
	public static Target WORKFLOW_CALL_SAVE_BTN = Target.the("save button").locatedBy("(//button[contains(text(),'Save')])[2]");
	
	public static Target INITIAL_CALL = Target.the("initial call").locatedBy("//input[@id='before_start']");
	
	public static Target RETRY_CALL = Target.the("retry call").locatedBy("//input[@id='frequency']");
	
	public static Target HOURS = Target.the("hours").locatedBy("//input[@id='hours']");
	
	public static Target DAYS = Target.the("days").locatedBy("//input[@id='days']");
	
	public static Target FROM_CROSS_ICON = Target.the("cross icon").locatedBy("(//button[@class='react-time-picker__clear-button react-time-picker__button'])[1]");
	
	public static Target TO_CROSS_ICON = Target.the("cross icon").locatedBy("(//button[@class='react-time-picker__clear-button react-time-picker__button'])[2]");

	public static Target FROM_MINUTE = Target.the("from minute").locatedBy("(//input[@name='minute'])[1]");

	public static Target TO_MINUTE = Target.the("to minute").locatedBy("(//input[@name='minute'])[2]");

	public static Target FROM_AM_PM = Target.the("am pm").locatedBy("(//select[@name='amPm'])[1]");

	public static Target TO_AM_PM = Target.the("am pm").locatedBy("(//select[@name='amPm'])[2]");

}
