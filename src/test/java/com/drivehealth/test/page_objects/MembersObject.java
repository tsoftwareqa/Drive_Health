package com.drivehealth.test.page_objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class MembersObject extends PageObject {

	public static Target MEMBERS_TAB = Target.the("members tab").locatedBy("(//button[contains(text(),'Members')])[2]");
	
	public static Target MEMBERS_BTN = Target.the("members btn").locatedBy("(//button[contains(text(),'Members')])[1]");
	
	public static Target ADD_NEW_MEMBER = Target.the("add new members").locatedBy("//button[contains(text(),'Add New Member')]");
	
	public static Target BULK_UPLOAD = Target.the("bulk upload").locatedBy("//button[contains(text(),'Bulk Upload')]");
	
	public static Target TEAM_TAB = Target.the("team tab").locatedBy("(//button[contains(text(),'Team')])[2]");
	
	public static Target TEAM_BTN = Target.the("team btn").locatedBy("(//button[contains(text(),'Team')])[1]");
	
	public static Target FIRST_NAME = Target.the("first name").locatedBy("//input[@id='first_name']");

	public static Target LAST_NAME = Target.the("last name").locatedBy("//input[@id='last_name']");

	public static Target EMAIL = Target.the("email").locatedBy("//input[@id='email']");

	public static Target DOB = Target.the("dob").locatedBy("//input[@placeholder='Date of Birth']");
	
	public static Target MALE = Target.the("male").locatedBy("//span[@id='radix-:rgv:']");

	public static Target GENDER = Target.the("gender").locatedBy("//select[@name='gender']");

	public static Target PHONE = Target.the("phone").locatedBy("//input[@id='phone']");

	public static Target ADDRESS = Target.the("address").locatedBy("//input[@id='line1']");

	public static Target ZIP = Target.the("zip").locatedBy("//input[@id='zip']");

	public static Target SAVE_SEND_INVITE = Target.the("save send invite").locatedBy("//button[contains(text(),'Save & Send Invite')]");

	public static Target EDIT = Target.the("edit").locatedBy("//div[contains(text(),'Edit')]");

	public static Target DELETE = Target.the("delete").locatedBy("(//div[contains(text(),'Delete')])[2]");

	public static Target CLICK_TO_UPLOAD = Target.the("click to upload").locatedBy("//div[@class='flex items-center justify-center flex-col pt-3 pb-4 w-full ']/descendant::span");

	public static Target BULK_ORG = Target.the("bulk org").locatedBy("//span[contains(text(),'TEst1')]");
	
	public static Target UPLOAD_BTN = Target.the("upload btn").locatedBy("(//button[contains(text(),'Upload')])[2]");
	
	public static Target SEARCH_RESULT_HIGHLIGHTED = Target.the("search result").locatedBy(
			"(//span[@class='_Highlighted_18z0f_1'])[1]");
	
	public static Target SELECT_ALL = Target.the("select all").locatedBy(
			"//button[@aria-label='Select all']");
	
	public static Target DELETE_BULK = Target.the("delete").locatedBy(
			"//div[contains(text(),'Delete')]");
	
	public static Target NO_RESULT = Target.the("no result").locatedBy(
			"//td[@class='p-1 align-middle [&:has([role=checkbox])]:pr-0 h-10 text-center']");
	
	public void getElement() {
		List<WebElement> element =  getDriver().findElements(By.xpath("//ul[@class='w-full']/descendant::span"));
		element.get(1).click();
   }
	
}
