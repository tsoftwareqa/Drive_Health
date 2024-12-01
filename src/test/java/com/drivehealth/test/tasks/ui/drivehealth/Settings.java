package com.drivehealth.test.tasks.ui.drivehealth;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;

import com.drivehealth.test.page_objects.MembersObject;
import com.drivehealth.test.page_objects.OrganizationPage;
import com.drivehealth.test.page_objects.SettingsObject;
import com.drivehealth.test.utils.ConvertCucumberDataTable;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

public class Settings extends UIInteractions implements Task {

	private static String action;
	SettingsObject setobj;

	public Settings(String action) {
		this.action = action;
	}

	public static Settings fromUnderlineDetails(DataTable settingdata) {
		Map<String, String> setting_data = ConvertCucumberDataTable.toMap(settingdata);
		action = setting_data.get("Action");

		return new Settings(action);
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		switch (action) {
		case "Save":
			waitABit(3000);
			actor.attemptsTo(Click.on(SettingsObject.ORG_NAME));
			waitABit(2000);
			
			actor.attemptsTo(Enter.keyValues("40").into(SettingsObject.FROM_MINUTE));
			waitABit(2000);
						
			actor.attemptsTo(Click.on(SettingsObject.TIME_WIN_SAVE_BTN));
			waitABit(2000);
			
			actor.attemptsTo(Scroll.to(SettingsObject.WORKFLOW_CALL_RESET_BTN).andAlignToTop());
			waitABit(2000);
			
			actor.attemptsTo(Click.on(SettingsObject.WORKFLOW_CALL_RESET_BTN));
			waitABit(5000);
			
			setobj.clearInitialCallField();
			waitABit(2000);
			
			actor.attemptsTo(Enter.keyValues("02").into(SettingsObject.INITIAL_CALL));
			waitABit(2000);
			
			setobj.clearRetryTimesField();
			waitABit(2000);
			
			actor.attemptsTo(Enter.keyValues("01").into(SettingsObject.RETRY_CALL));
			waitABit(2000);
			
			setobj.clearRetryHourField();
			waitABit(2000);
			
			actor.attemptsTo(Enter.keyValues("03").into(SettingsObject.HOURS));
			waitABit(2000);
			
			setobj.clearRetryDaysField();
			waitABit(2000);
			
			actor.attemptsTo(Enter.keyValues("05").into(SettingsObject.DAYS));
			waitABit(2000);
			
			actor.attemptsTo(Click.on(SettingsObject.WORKFLOW_CALL_SAVE_BTN));
			waitABit(2000);
			
			break;
		case "Reset":

			break;
		default:
			System.out.println("No action");
			break;
		}
	}
}
