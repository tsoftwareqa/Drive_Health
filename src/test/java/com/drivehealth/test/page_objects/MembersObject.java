package com.drivehealth.test.page_objects;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import com.drivehealth.test.utils.CommonUtil;

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
	
	public static Target NEXT_PAGE = Target.the("next page").locatedBy(
			"(//button[@class='inline-flex items-center justify-center whitespace-nowrap rounded-md text-sm font-medium ring-offset-background transition-none focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 border border-input text-primary bg-background hover:bg-accent hover:text-accent-foreground h-8 w-8 p-0'])[2]");
	
	public static Target PAGE_VALUE = Target.the("page value").locatedBy(
			"//div[@class='flex w-[100px] items-center justify-center text-sm font-medium']");
	
	public static Target MEMBER_LINK = Target.the("member link").locatedBy(
			"(//span[@class='_Highlighted_18z0f_1'])[1]");
	
	public static Target GEN_REPORT_BTN = Target.the("gen report btn").locatedBy(
			"//button[contains(text(),'Generate Report')]");
	
	public static Target GENERATE_REPORT_BTN = Target.the("generate report btn").locatedBy(
			"(//button[contains(text(),'Generate Report')])[2]");
	
	public static Target CALL = Target.the("generate report btn").locatedBy(
			"(//div[contains(text(),'Call')])[1]");
	
	public static Target CONFIRM_CALL = Target.the("confirm call").locatedBy(
			"//button[contains(text(),'Confirm Call')]");
	
	public static Target GLOBAL_SEARCH_INPUT_FIELD = Target.the("global search input field").locatedBy(
			"//input[@placeholder='Search for users']");
	
	public static Target SELECT_SEARCH_RESULT = Target.the("select search result").locatedBy(
			"//span[@class='text-black-600']");
	
	public static Target SEARCH_HIGHLIGHTED_RESULT = Target.the("search result").locatedBy(
			"(//span[@class='_Highlighted_18z0f_1'])[1]");
	
	public static Target DOWNLOAD_CSV = Target.the("download csv").locatedBy(
			"//button[contains(text(),' Download CSV')]");
	
	public static Target SUCCESS_POPUP = Target.the("success popup").locatedBy(
			"//p[@class='text-[19px] text[#000000] font-bold mb-3 capitalize']");
	
	public void getElement() {
		List<WebElement> element =  getDriver().findElements(By.xpath("//ul[@class='w-full']/descendant::span"));
		element.get(1).click();
   }
		
}
