package com.drivehealth.test.page_objects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class SurveyPage extends PageObject {

    public static Target SURVEY_TAB = Target.the("survey tab").locatedBy("//button[contains(text(),'Surveys')]");
	
	public static Target ADD_SURVEY_BTN = Target.the("add survey btn").locatedBy("(//button[contains(text(),'Survey')])[2]");
	
	public static Target SURVEY_TITLE = Target.the("survey title").locatedBy("//input[@placeholder='Enter title']");
	
	public static Target SELECT_ORG = Target.the("select org").locatedBy("//button[contains(text(),'Select Organizations')]");
	
	public static Target SAVE_BTN = Target.the("save btn").locatedBy("//button[contains(text(),'Save')]");
	
	public static Target ORG_SELECTION = Target.the("org selection").locatedBy("(//label[@class='flex items-center gap-2 cursor-pointer'])[1]");
	
	public static Target QUESTION_TITLE = Target.the("question title").locatedBy("//input[@placeholder='Enter text']");
	
	public static Target OPTION_ONE = Target.the("option one").locatedBy("//input[@placeholder='Option 1']");
	
	public static Target OPTION_TWO = Target.the("option two").locatedBy("//input[@placeholder='Option 2']");
	
	public static Target OPTION_THREE = Target.the("option three").locatedBy("//input[@placeholder='Option 3']");
	
	public static Target OPTION_FOUR = Target.the("option four").locatedBy("//input[@placeholder='Option 4']");
	
	public static Target SURVEY_LIST = Target.the("survey list").locatedBy("(//h4[@class='text-[14px]'])[1]");
	
	public static Target EDIT_SURVEY_ICON = Target.the("edit survey icon").locatedBy("(//button[contains(@id,'radix-:r')])[4]");
	
	public static Target EDIT = Target.the("edit").locatedBy("//div[contains(text(),'Edit')]");
	
	public static Target EDIT_POPUP = Target.the("edit").locatedBy("//button[contains(text(),'Edit')]");
	
	public static Target DELETE = Target.the("delete").locatedBy("//div[contains(text(),'Delete')]");
	
	public static Target DELETE_CONFIRM = Target.the("delete").locatedBy("//button[contains(text(),'Delete')]");

}
