package com.drivehealth.test.tasks.ui.drivehealth;

import org.openqa.selenium.Keys;

import com.drivehealth.test.page_objects.HomePage;
import com.drivehealth.test.page_objects.OrganizationPage;
import com.drivehealth.test.tasks.ui.common.NavigateTo;
import com.drivehealth.test.utils.CommonUtil;
import com.drivehealth.test.utils.Key;

import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

public class Organization extends UIInteractions implements Task {

	public static Organization fromUnderlineDetails() {
		return new Organization();
	}
	
	@Override
	public <T extends Actor> void performAs(T actor) {
	
		waitABit(1000);
				
		actor.attemptsTo(Click.on(OrganizationPage.ORG_BTN));
		waitABit(2000);
		
		String orgname = "ORG_"+OrganizationPage.rndChar();
		actor.attemptsTo(Enter.keyValues(orgname).into(OrganizationPage.ORG_NAME));
		actor.remember(Key.ORG_NAME, orgname);
		waitABit(1000);
		
		actor.attemptsTo(Enter.keyValues("35201").into(OrganizationPage.ZIP_CODE));
		waitABit(2000);
				
		actor.attemptsTo(Click.on(OrganizationPage.SAVE_BTN));
		waitABit(1000);
		
		actor.attemptsTo(Enter.keyValues("35201").into(OrganizationPage.ZIP_CODE));
		waitABit(2000);
		
	}

}
