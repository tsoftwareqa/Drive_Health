package com.drivehealth.test.tasks.ui.drivehealth;

import java.util.Map;

import org.openqa.selenium.Keys;

import com.drivehealth.test.page_objects.HomePage;
import com.drivehealth.test.page_objects.OrganizationPage;
import com.drivehealth.test.tasks.ui.common.NavigateTo;
import com.drivehealth.test.utils.CommonUtil;
import com.drivehealth.test.utils.ConvertCucumberDataTable;
import com.drivehealth.test.utils.DataHelper;
import com.drivehealth.test.utils.Key;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.Switch;

public class Organization extends UIInteractions implements Task {

	private static String action;
	
	public Organization(String action) {
		this.action = action;
	}
	
	public static Organization fromUnderlineDetails(DataTable orgdata) {
		Map<String, String> org_data = ConvertCucumberDataTable.toMap(orgdata);
		action = org_data.get("Action");
		
		return new Organization(action);
	}
	
	@Override
	public <T extends Actor> void performAs(T actor) {
	
		switch(action){
			case "Add":
				waitABit(1000);
				
				actor.attemptsTo(Click.on(OrganizationPage.ORG_BTN));
				waitABit(2000);
				
				String orgname = "AUTO_ORG_"+OrganizationPage.generateRandomString();
				actor.attemptsTo(Enter.keyValues(orgname).into(OrganizationPage.ORG_NAME));
				actor.remember(Key.ORG_NAME, orgname);
				DataHelper.writeOrgInfo(orgname);
				waitABit(1000);

				actor.attemptsTo(Enter.keyValues("35201").into(OrganizationPage.ZIP_CODE));
				waitABit(2000);
						
				actor.attemptsTo(Click.on(OrganizationPage.SAVE_BTN));
				waitABit(2000);
				break;
				
			case "Edit":
				break;	
				
			case "Delete":
				break;
			default:
				System.out.println("No action");
				break;
		}
		
				
	}
	
}
