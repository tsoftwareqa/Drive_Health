package com.drivehealth.test.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class PromptPage extends PageObject {

    public static Target PROMPT_TAB = Target.the("prompt tab").locatedBy("//button[contains(text(),'Prompts')]");
	
	public static Target ADD_PROMPT_BTN = Target.the("add prompt btn").locatedBy("(//button[contains(text(),'Prompt')])[2]");
	
	public static Target PROMPT_EN_INPUT = Target.the("prompt en").locatedBy("//textarea[@id='en']");
	
	public static Target PROMPT_ES_INPUT = Target.the("prompt es").locatedBy("//textarea[@id='es']");
	
	public static Target SAVE_BTN = Target.the("save btn").locatedBy("//button[contains(text(),'Save')]");
	
	public static Target INPUT_SEARCH = Target.the("input search").locatedBy("//input[@placeholder='Search for Organizations']");
	
	public static Target SEARCHED_PROMPT = Target.the("searched input").locatedBy("//h4[@class='text-[14px]']/strong");
	
	public static Target NO_PROMT_FOUND = Target.the("no prompt found").locatedBy("//div[@class='font-bold p-3 text-center']");
	
	public static Target EDIT_PROMPT_ICON = Target.the("edit prompt icon").locatedBy("(//button[contains(@id,'radix-:r')])[4]");
	
	public static Target EDIT = Target.the("edit").locatedBy("//div[contains(text(),'Edit')]");
	
	public static Target DELETE = Target.the("delete").locatedBy("//div[contains(text(),'Delete')]");
	
	public static Target DELETE_CONFIRM = Target.the("delete").locatedBy("//button[contains(text(),'Delete')]");
	
	public void clearEnPrompt() {
		WebElement ele2 = getDriver().findElement(By.xpath("//textarea[@id='en']"));
		String s = Keys.chord(Keys.CONTROL, "a");
		ele2.sendKeys(s);
		ele2.sendKeys(Keys.DELETE);
	}
	
	public void clearSnPrompt() {
		WebElement ele2 = getDriver().findElement(By.xpath("//textarea[@id='es']"));
		String s = Keys.chord(Keys.CONTROL, "a");
		ele2.sendKeys(s);
		ele2.sendKeys(Keys.DELETE);
	}
}
