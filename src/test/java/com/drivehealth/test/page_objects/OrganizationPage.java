package com.drivehealth.test.page_objects;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import com.drivehealth.test.utils.DataHelper;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;

public class OrganizationPage extends PageObject {

	public static Target ORG_BTN = Target.the("org btn").locatedBy("//button[contains(text(),'Organization')]");
	public static Target ORG_NAME = Target.the("org name").locatedBy("//input[@id='name']");
	public static Target ZIP_CODE = Target.the("zip code").locatedBy("//input[@id='zip_code']");
	public static Target SAVE_BTN = Target.the("save btn").locatedBy("//button[contains(text(),'Save')]");
	public static Target ORG_SEARCH_INPUT = Target.the("search input").locatedBy("//input[@placeholder='Search']");
	public static Target SEARCH_RESULT_HIGHLIGHTED = Target.the("search result").locatedBy(
			"(//tr[@class='border-b transition-colors hover:bg-muted/50 data-[state=selected]:bg-muted'])[2]/child::td");
	public static Target THREE_DOT_ICON = Target.the("Three dot icon").locatedBy(
			"//button[@class='items-center justify-center whitespace-nowrap rounded-md text-sm font-medium ring-offset-background transition-none focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 hover:bg-accent hover:text-accent-foreground flex h-8 w-8 p-0 data-[state=open]:bg-muted']");
	public static Target EDIT = Target.the("EDIT").locatedBy("//Div[contains(text(),'Edit')]");
	public static Target DELETE = Target.the("DELETE").locatedBy("//Div[contains(text(),'Delete')]");
	public static Target DELETE_BTN = Target.the(" BTN").locatedBy("//button[contains(text(),'Delete')]");
	public static Target ALL_ORG = Target.the(" all org").locatedBy("//div[@data-state='closed']/child::button");
	public static Target SUB_ORG_BTN = Target.the("sub org btn").locatedBy("//button[contains(text(),'Sub-Organization')]");
	public static Target SHOW_SUB_ORG_CHKBOX = Target.the("checkbox").locatedBy("//button[@id='include-option']");
	public static Target UPLOAD_HISTORY_TAB = Target.the("upload history tab").locatedBy("//button[contains(text(),'Upload History')]");
	public static Target FILE_NAME = Target.the("file name").locatedBy("(//tr[@class='border-b transition-colors hover:bg-muted/50 data-[state=selected]:bg-muted'])[2]/descendant::span[2]");
	public static Target SUCCESS = Target.the("success").locatedBy("(//tr[@class='border-b transition-colors hover:bg-muted/50 data-[state=selected]:bg-muted'])[2]/td[3]/descendant::div[@class='text-green-500 whitespace-nowrap']");
	public static Target ORG_NAME_LINK = Target.the("org name link").locatedBy("(//span[@class='_Highlighted_18z0f_1'])[1]");
		
	public static char rndChar() {
		int rnd = (int) (Math.random() * 52); // or use Random or whatever
		char base = (rnd < 26) ? 'A' : 'a';
		return (char) (base + rnd % 26);

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

	public List<String> getOrgNames() {
		return findAll(ALL_ORG).stream().map(WebElementFacade::getText).collect(Collectors.toList());
	}

	
	public void getElement() {
		List<WebElement> element =  getDriver().findElements(By.xpath("//div[@data-state='closed']/child::button"));
		((JavascriptExecutor) getDriver()).executeScript(
	            "document.querySelector(\"div[class='h-full w-full rounded-[inherit]']\").scrollTop=20000");
		 element.get(element.size()-1).click();
   }
	
	  public static void main(String args[]) {
		  
		  String file = System.getProperty("user.dir");
	    	file.replaceAll("\\\\","\\\\");
		         
		   
	  }
	 
}
