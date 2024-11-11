package com.drivehealth.test.tasks.ui.drivehealth;

import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Map;

import org.openqa.selenium.Keys;

import com.drivehealth.test.page_objects.MembersObject;
import com.drivehealth.test.page_objects.OrganizationPage;
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
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.ui.Dropdown;
import net.serenitybdd.screenplay.ui.Select;

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
			waitABit(6000);
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
			actor.attemptsTo(Enter.keyValues(email).into(MembersObject.EMAIL));
			
			waitABit(2000);
			actor.attemptsTo(Enter.keyValues("11/11/1998").into(MembersObject.DOB));
			
			waitABit(2000);
			String phone = "0"+CommonUtil.generateNineDigitNumber();
			actor.attemptsTo(Enter.keyValues(phone).into(MembersObject.PHONE));
			
			waitABit(2000);
			actor.attemptsTo(SelectFromOptions.byIndex(1).from(MembersObject.GENDER));
			
			waitABit(2000);
			actor.attemptsTo(Enter.keyValues("351 24TH ST UNIT 20224").into(MembersObject.ADDRESS));
			
			waitABit(2000);
			actor.attemptsTo(Enter.keyValues("35201").into(MembersObject.ZIP));

			waitABit(2000);
			DataHelper.writeMemberInfo("MemberData",firstname,0);
			waitABit(1000);
				
			actor.attemptsTo(Scroll.to(OrganizationPage.SAVE_BTN).andAlignToTop());
			waitABit(1000);
			
			actor.attemptsTo(Click.on(OrganizationPage.SAVE_BTN));
			waitABit(2000);
			break;

		case "Edit":
			waitABit(6000);
		    orgpage.getElement();
		    
		    actor.attemptsTo(Click.on(MembersObject.MEMBERS_TAB));
			waitABit(2000);
			
			actor.attemptsTo(Click.on(OrganizationPage.THREE_DOT_ICON));
			waitABit(2000);
			
			actor.attemptsTo(Click.on(MembersObject.EDIT));
			waitABit(2000);
			
			actor.attemptsTo(Clear.field(MembersObject.FIRST_NAME));
			waitABit(2000);
		    
			String first_name = "First"+CommonUtil.generateRandomNumber();
			actor.attemptsTo(Enter.keyValues(first_name).into(MembersObject.FIRST_NAME));
			DataHelper.writeMemberInfo("MemberData",first_name,0);
			
			actor.attemptsTo(Scroll.to(OrganizationPage.SAVE_BTN).andAlignToTop());
			waitABit(1000);

			actor.attemptsTo(Click.on(OrganizationPage.SAVE_BTN));
			waitABit(2000);
			break;

		case "Delete":
			waitABit(6000);
		    orgpage.getElement();
		    
		    actor.attemptsTo(Click.on(MembersObject.MEMBERS_TAB));
			waitABit(2000);
			
			actor.attemptsTo(Click.on(OrganizationPage.THREE_DOT_ICON));
			waitABit(2000);
			
			actor.attemptsTo(Click.on(MembersObject.DELETE));
			waitABit(2000);
			
			actor.attemptsTo(Click.on(OrganizationPage.DELETE_BTN));
			waitABit(3000);

			break;
			
		case "AddBulk":
			waitABit(3000);
			actor.attemptsTo(Click.on(MembersObject.BULK_ORG));
		    
		    waitABit(2000);
		    actor.attemptsTo(Click.on(MembersObject.MEMBERS_BTN));
		    
		    waitABit(2000);
		    actor.attemptsTo(Click.on(MembersObject.BULK_UPLOAD));
		    
		    waitABit(2000);
		    actor.attemptsTo(Click.on(MembersObject.CLICK_TO_UPLOAD));
		    
		    waitABit(2000);
		    
		    try {
				Robot rwRobot = new Robot();
				StringSelection stringSelection = new StringSelection(
						"C:\\workspace\\Drive_Health\\src\\test\\resources\\sources\\sample_bullk_upload.csv");
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
				rwRobot.keyPress(KeyEvent.VK_CONTROL);
				rwRobot.keyPress(KeyEvent.VK_V);

				rwRobot.keyRelease(KeyEvent.VK_CONTROL);
				rwRobot.keyRelease(KeyEvent.VK_V);

				rwRobot.keyPress(KeyEvent.VK_ENTER);
				rwRobot.keyRelease(KeyEvent.VK_ENTER);
			} catch (AWTException e) {

				e.printStackTrace();
			}
		    
		    waitABit(3000);
		    actor.attemptsTo(Click.on(MembersObject.UPLOAD_BTN));
		    			
			  waitABit(3000);
			  actor.attemptsTo(Click.on(MembersObject.MEMBERS_TAB));
			  
			  actor.attemptsTo(Enter.keyValues("FirstB").into(OrganizationPage.
			  ORG_SEARCH_INPUT)); waitABit(3000);
			  
			  String searchResult =
					  MembersObject.SEARCH_RESULT_HIGHLIGHTED.resolveFor(actor).getText();
			  waitABit(3000);
			  
			  CommonUtil.captureScreenshot(getDriver());
			  
			  actor.attemptsTo(Ensure.that(searchResult).isEqualToIgnoringCase("FirstB LastB"));
			 
			break;
		default:
			System.out.println("No action");
			break;
		}
	}
}
