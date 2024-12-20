package com.drivehealth.test.tasks.ui.drivehealth;

import java.util.Map;

import com.drivehealth.test.page_objects.PromptPage;
import com.drivehealth.test.utils.ConvertCucumberDataTable;
import com.drivehealth.test.utils.DataHelper;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

public class Prompt extends UIInteractions implements Task {

	private static String action;
	PromptPage prpage;
	
	public Prompt(String action) {
		this.action = action;
	}

	public static Prompt fromUnderlineDetails(DataTable promptdata) {
		Map<String, String> prompt_data = ConvertCucumberDataTable.toMap(promptdata);
		action = prompt_data.get("Action");

		return new Prompt(action);
	}
	
	@Override
	public <T extends Actor> void performAs(T actor) {
	
		actor.attemptsTo(Click.on(PromptPage.PROMPT_TAB));
		
		switch (action) {
		case "AddPrompt":
			waitABit(4000);		
			actor.attemptsTo(Click.on(PromptPage.ADD_PROMPT_BTN));
			
			String promptdata = "This is english prompt";
			waitABit(2000);
			actor.attemptsTo(Enter.keyValues(promptdata).into(PromptPage.PROMPT_EN_INPUT));
			
			DataHelper.writeStaffInfo("prompt", promptdata, 0, 0);
			
			waitABit(2000);
			actor.attemptsTo(Enter.keyValues("This is spanish prompt").into(PromptPage.PROMPT_ES_INPUT));
			
			waitABit(2000);
		    actor.attemptsTo(Click.on(PromptPage.SAVE_BTN));
		    			
			break;

		case "EditPrompt":
			waitABit(2000);		
			actor.attemptsTo(Enter.keyValues(DataHelper.getRecord("prompt", 0, 0)).into(PromptPage.INPUT_SEARCH));
			
			String updatedprompt = "This is updated english prompt";
			
			waitABit(2000);
		    actor.attemptsTo(Click.on(PromptPage.EDIT_PROMPT_ICON));
		    
		    waitABit(2000);
		    actor.attemptsTo(Click.on(PromptPage.EDIT));
		    
			waitABit(3000);
			prpage.clearEnPrompt();
			
			waitABit(1000);
			actor.attemptsTo(Enter.keyValues(updatedprompt).into(PromptPage.PROMPT_EN_INPUT));
			
			DataHelper.writeStaffInfo("prompt", updatedprompt, 0, 0);
			
			waitABit(2000);
			prpage.clearSnPrompt();
			
			waitABit(1000);
			actor.attemptsTo(Enter.keyValues("This is updated spanish prompt").into(PromptPage.PROMPT_ES_INPUT));
			
			waitABit(2000);
		    actor.attemptsTo(Click.on(PromptPage.SAVE_BTN));
		    			
			break;
			
		case "DeletePrompt":
			waitABit(2000);		
			actor.attemptsTo(Enter.keyValues(DataHelper.getRecord("prompt", 0, 0)).into(PromptPage.INPUT_SEARCH));
			
			waitABit(2000);
		    actor.attemptsTo(Click.on(PromptPage.EDIT_PROMPT_ICON));
		    
		    waitABit(2000);
		    actor.attemptsTo(Click.on(PromptPage.DELETE));
		    
			waitABit(2000);
		    actor.attemptsTo(Click.on(PromptPage.DELETE_CONFIRM));
		    			
			break;
			
		default:
			System.out.println("No action");
			break;
	}
	}

}
