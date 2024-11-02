package com.drivehealth.test.tasks.ui.drivehealth;

import java.util.Map;
import com.drivehealth.test.page_objects.MembersObject;
import com.drivehealth.test.page_objects.OrganizationPage;
import com.drivehealth.test.utils.CommonUtil;
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

public class Members extends UIInteractions implements Task {

	private static String action;
	OrganizationPage orgpage;

	public Members(String action) {
		this.action = action;
	}

	public static Members fromUnderlineDetails(DataTable memberdata) {
		Map<String, String> member_data = ConvertCucumberDataTable.toMap(memberdata);
		action = member_data.get("Action");

		return new Members(action);
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		String membername = "";

		switch (action) {
		case "Add":
			waitABit(1000);
		    orgpage.getElement();
		    
		    waitABit(2000);
		    actor.attemptsTo(Click.on(MembersObject.MEMBERS_BTN));
		    
		    waitABit(2000);
		    actor.attemptsTo(Click.on(MembersObject.ADD_NEW_MEMBER));
		    
			waitABit(2000);
			String firstname = "First"+CommonUtil.generateRandomNumber();
			actor.attemptsTo(Enter.keyValues(firstname).into(MembersObject.FIRST_NAME));
			
			waitABit(2000);
			String lastname = "Last"+CommonUtil.generateRandomNumber();
			actor.attemptsTo(Enter.keyValues(lastname).into(MembersObject.LAST_NAME));
			
			waitABit(2000);
			String email = "tests"+CommonUtil.generateRandomNumber()+"@gmail.com";
			actor.attemptsTo(Enter.keyValues(email).into(MembersObject.FIRST_NAME));
			
			waitABit(2000);
			actor.attemptsTo(Enter.keyValues("11/11/1998").into(MembersObject.DOB));
			
			waitABit(2000);
			actor.attemptsTo(Click.on(MembersObject.GENDER));
			
			waitABit(2000);
			actor.attemptsTo(Click.on(MembersObject.MALE));
			
			waitABit(2000);
			String phone = "0"+CommonUtil.generateNineDigitNumber();
			actor.attemptsTo(Enter.keyValues(phone).into(MembersObject.PHONE));
			
			waitABit(2000);
			actor.attemptsTo(Enter.keyValues("351 24TH ST UNIT 20224").into(MembersObject.ADDRESS));
			
			waitABit(2000);
			actor.attemptsTo(Enter.keyValues("35201").into(MembersObject.ZIP));

			waitABit(2000);
			DataHelper.writeSubOrgInfo(firstname,0);
			waitABit(1000);
				
			actor.attemptsTo(Click.on(MembersObject.SAVE_SEND_INVITE));
			waitABit(2000);
			break;

		case "Edit":
			waitABit(1000);
			actor.attemptsTo(
					Enter.keyValues(DataHelper.getRecord("OrgData", 1, 0)).into(OrganizationPage.ORG_SEARCH_INPUT));
			waitABit(3000);

			actor.attemptsTo(Click.on(OrganizationPage.THREE_DOT_ICON));
			waitABit(2000);

			actor.attemptsTo(Click.on(OrganizationPage.EDIT));
			waitABit(2000);

			actor.attemptsTo(Clear.field(OrganizationPage.ORG_NAME));
			waitABit(2000);

			membername = "AUTO_ORG_" + OrganizationPage.generateRandomString();
			actor.attemptsTo(Enter.keyValues(membername).into(OrganizationPage.ORG_NAME));

			
			DataHelper.writeOrgInfo(membername, 0);
			waitABit(2000);

			actor.attemptsTo(Click.on(OrganizationPage.SAVE_BTN));
			waitABit(2000);
			break;

		case "Delete":

			waitABit(1000);
			actor.attemptsTo(
					Enter.keyValues(DataHelper.getRecord("OrgData", 1, 0)).into(OrganizationPage.ORG_SEARCH_INPUT));
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
