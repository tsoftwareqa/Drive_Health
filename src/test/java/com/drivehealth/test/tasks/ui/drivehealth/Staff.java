package com.drivehealth.test.tasks.ui.drivehealth;

import java.util.Map;

import com.drivehealth.test.page_objects.MembersObject;
import com.drivehealth.test.page_objects.OrganizationPage;
import com.drivehealth.test.page_objects.StaffObjects;
import com.drivehealth.test.utils.CommonUtil;
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

public class Staff extends UIInteractions implements Task{

	private static String action;
	OrganizationPage orgpage;

	public Staff(String action) {
		this.action = action;
	}

	public static Staff fromUnderlineDetails(DataTable staffdata) {
		Map<String, String> staff_data = ConvertCucumberDataTable.toMap(staffdata);
		action = staff_data.get("Action");

		return new Staff(action);
	}
	
	@Override
	public <T extends Actor> void performAs(T actor) {
		

		String staffname = "";

		switch (action) {
		case "Add":
			waitABit(6000);
			actor.attemptsTo(Enter.keyValues(DataHelper.getRecord("OrgData", 1, 0)).into(OrganizationPage.ORG_SEARCH_INPUT));
			
			waitABit(2000);
		    actor.attemptsTo(Click.on(OrganizationPage.ORG_NAME_LINK));
		    
		    waitABit(2000);
		    actor.attemptsTo(Click.on(StaffObjects.STAFF_BTN));
		    
			waitABit(2000);
			String firstname = "SFirst"+CommonUtil.generateRandomString();
			actor.attemptsTo(Enter.keyValues(firstname).into(StaffObjects.FIRST_NAME));
			
			waitABit(2000);
			String lastname = "SLast"+CommonUtil.generateRandomString();
			actor.attemptsTo(Enter.keyValues(lastname).into(StaffObjects.LAST_NAME));
			
			waitABit(2000);
			String email = "tests"+CommonUtil.generateRandomNumber()+"@gmail.com";
			actor.attemptsTo(Enter.keyValues(email).into(StaffObjects.EMAIL));
			
			waitABit(2000);
			String phone = "0"+CommonUtil.generateNineDigitNumber();
			actor.attemptsTo(Enter.keyValues(phone).into(StaffObjects.PHONE));
			
			waitABit(2000);
			actor.attemptsTo(SelectFromOptions.byIndex(1).from(StaffObjects.ROLE));
			
			waitABit(2000);
			DataHelper.writeMemberInfo("StaffData",firstname,0);
			waitABit(1000);
						
			actor.attemptsTo(Click.on(OrganizationPage.SAVE_BTN));
			waitABit(2000);
			break;

		case "Edit":
			waitABit(6000);
			actor.attemptsTo(Enter.keyValues(DataHelper.getRecord("OrgData", 1, 0)).into(OrganizationPage.ORG_SEARCH_INPUT));
			
			waitABit(2000);
		    actor.attemptsTo(Click.on(OrganizationPage.ORG_NAME_LINK));
		    
		    actor.attemptsTo(Click.on(StaffObjects.STAFF_TAB));
			waitABit(2000);
			
			actor.attemptsTo(Click.on(OrganizationPage.THREE_DOT_ICON));
			waitABit(2000);
			
			actor.attemptsTo(Click.on(MembersObject.EDIT));
			waitABit(2000);
			
			actor.attemptsTo(Clear.field(StaffObjects.FIRST_NAME));
			waitABit(2000);
		    
			String first_name = "SFirst"+CommonUtil.generateRandomString();
			actor.attemptsTo(Enter.keyValues(first_name).into(MembersObject.FIRST_NAME));
			DataHelper.writeMemberInfo("StaffData",first_name,0);
			waitABit(2000);
			
			actor.attemptsTo(Click.on(OrganizationPage.SAVE_BTN));
			waitABit(2000);
			break;

		case "Delete":
			waitABit(6000);
			actor.attemptsTo(Enter.keyValues(DataHelper.getRecord("OrgData", 1, 0)).into(OrganizationPage.ORG_SEARCH_INPUT));
			
			waitABit(2000);
		    actor.attemptsTo(Click.on(OrganizationPage.ORG_NAME_LINK));
		    
		    actor.attemptsTo(Click.on(StaffObjects.STAFF_TAB));
			waitABit(2000);
			
			actor.attemptsTo(Click.on(OrganizationPage.THREE_DOT_ICON));
			waitABit(2000);
			
			actor.attemptsTo(Click.on(OrganizationPage.DELETE));
			waitABit(2000);
			
			actor.attemptsTo(Click.on(OrganizationPage.DELETE_BTN));
			waitABit(3000);

			break;
		default:
			System.out.println("No action");
			break;
		}
	
	}

}
