package com.drivehealth.test.tasks.ui.drivehealth;
import java.util.Map;

import com.drivehealth.test.page_objects.OrganizationPage;
import com.drivehealth.test.utils.ConvertCucumberDataTable;
import com.drivehealth.test.utils.DataHelper;
import com.drivehealth.test.utils.Key;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class Organization extends UIInteractions implements Task {

	private static String action;
	OrganizationPage orgpage;
	
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
	
		String orgname="";
		
		switch(action){
			case "Add":
				waitABit(1000);
				
				actor.attemptsTo(Click.on(OrganizationPage.ORG_BTN));
				waitABit(2000);
				
				orgname = "AUTO_ORG_"+OrganizationPage.generateRandomString();
				actor.attemptsTo(Enter.keyValues(orgname).into(OrganizationPage.ORG_NAME));
				
				actor.remember(Key.ORG_NAME, orgname);
				DataHelper.writeOrgInfo(orgname,0);
				waitABit(1000);

				actor.attemptsTo(Enter.keyValues("35201").into(OrganizationPage.ZIP_CODE));
				waitABit(2000);
						
				actor.attemptsTo(Click.on(OrganizationPage.SAVE_BTN));
				waitABit(2000);
				break;
				
			case "Edit":
				waitABit(1000);
				actor.attemptsTo(Enter.keyValues(DataHelper.getRecord("OrgData", 1, 0)).into(OrganizationPage.ORG_SEARCH_INPUT));
				waitABit(3000);
				
				actor.attemptsTo(Click.on(OrganizationPage.THREE_DOT_ICON));
				waitABit(2000);
				
				actor.attemptsTo(Click.on(OrganizationPage.EDIT));
				waitABit(2000);
				
				actor.attemptsTo(Clear.field(OrganizationPage.ORG_NAME));
				waitABit(2000);
				
				orgname = "AUTO_ORG_"+OrganizationPage.generateRandomString();
				actor.attemptsTo(Enter.keyValues(orgname).into(OrganizationPage.ORG_NAME));
				
				actor.remember(Key.ORG_NAME, orgname);
				DataHelper.writeOrgInfo(orgname,0);
				waitABit(2000);
				
				actor.attemptsTo(Click.on(OrganizationPage.SAVE_BTN));
				waitABit(2000);
				break;	
				
			case "Delete":
				
				waitABit(1000);
				actor.attemptsTo(Enter.keyValues(DataHelper.getRecord("OrgData", 1, 0)).into(OrganizationPage.ORG_SEARCH_INPUT));
				waitABit(3000);
				
				actor.attemptsTo(Click.on(OrganizationPage.THREE_DOT_ICON));
				waitABit(2000);
				
				actor.attemptsTo(Click.on(OrganizationPage.DELETE));
				waitABit(3000);
				
				actor.attemptsTo(Click.on(OrganizationPage.DELETE_BTN));
				waitABit(3000);
				
				break;
				
			case "AddSub":
				waitABit(6000);
			    orgpage.getElement();
			    
			    waitABit(2000);
			    actor.attemptsTo(Click.on(OrganizationPage.SUB_ORG_BTN));
			    
				waitABit(2000);
				String org_name = "AUTO_SUB_ORG_"+OrganizationPage.generateRandomString();
				actor.attemptsTo(Enter.keyValues(org_name).into(OrganizationPage.ORG_NAME));
				
				actor.remember(Key.SUB_ORG_NAME, org_name);
				DataHelper.writeSubOrgInfo(org_name,0);
				waitABit(1000);

				actor.attemptsTo(Enter.keyValues("34997").into(OrganizationPage.ZIP_CODE));
				waitABit(2000);
						
				actor.attemptsTo(Click.on(OrganizationPage.SAVE_BTN));
				waitABit(2000);
				break;
				
			case "EditSub":
				waitABit(1000);
				actor.attemptsTo(Click.on(OrganizationPage.SHOW_SUB_ORG_CHKBOX));
				waitABit(2000);
				
				actor.attemptsTo(Enter.keyValues(DataHelper.getRecord("SubOrgData", 1, 0)).into(OrganizationPage.ORG_SEARCH_INPUT));
				waitABit(3000);
				
				actor.attemptsTo(Click.on(OrganizationPage.THREE_DOT_ICON));
				waitABit(2000);
				
				actor.attemptsTo(Click.on(OrganizationPage.EDIT));
				waitABit(2000);
				
				actor.attemptsTo(Clear.field(OrganizationPage.ORG_NAME));
				waitABit(2000);
				
				orgname = "AUTO_ORG_"+OrganizationPage.generateRandomString();
				actor.attemptsTo(Enter.keyValues(orgname).into(OrganizationPage.ORG_NAME));
				
				actor.remember(Key.ORG_NAME, orgname);
				DataHelper.writeSubOrgInfo(orgname,0);
				waitABit(2000);
				
				actor.attemptsTo(Click.on(OrganizationPage.SAVE_BTN));
				waitABit(2000);
				break;
				
            case "DeleteSub":

				waitABit(1000);
				actor.attemptsTo(Click.on(OrganizationPage.SHOW_SUB_ORG_CHKBOX));
				waitABit(2000);
				
				actor.attemptsTo(Enter.keyValues(DataHelper.getRecord("SubOrgData", 1, 0)).into(OrganizationPage.ORG_SEARCH_INPUT));
				waitABit(3000);
				
				actor.attemptsTo(Click.on(OrganizationPage.THREE_DOT_ICON));
				waitABit(2000);
				
				actor.attemptsTo(Click.on(OrganizationPage.DELETE));
				waitABit(3000);
				
				actor.attemptsTo(Click.on(OrganizationPage.DELETE_BTN));
				waitABit(3000);
				
				break;
			default:
				System.out.println("No action");
				break;
		}				
	}	
}
