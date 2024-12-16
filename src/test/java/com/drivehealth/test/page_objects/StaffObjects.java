package com.drivehealth.test.page_objects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class StaffObjects extends PageObject {

	public static Target STAFF_TAB = Target.the("staff tab").locatedBy("(//button[contains(text(),'Staff')])[2]");
	
	public static Target STAFF_BTN = Target.the("staff btn").locatedBy("(//button[contains(text(),'Staff')])[1]");
	
	public static Target FIRST_NAME = Target.the("first name").locatedBy("//input[@id='first_name']");

	public static Target LAST_NAME = Target.the("last name").locatedBy("//input[@id='last_name']");

	public static Target EMAIL = Target.the("email").locatedBy("//input[@id='email']");

	public static Target PHONE = Target.the("phone").locatedBy("//input[@id='phone']");

	public static Target ROLE = Target.the("role").locatedBy("//select[@name='role_id']");

	public static Target STAFF_CONFIRMATION_MSG = Target.the("confirm msg").locatedBy("//p[@class='text-lg pb-3 text-gray-900']");

}
