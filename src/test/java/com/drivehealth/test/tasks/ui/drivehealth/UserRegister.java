package com.drivehealth.test.tasks.ui.drivehealth;
import com.drivehealth.test.page_objects.HomePage;
import com.drivehealth.test.tasks.ui.common.NavigateTo;
import com.drivehealth.test.utils.CommonUtil;

import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

public class UserRegister extends UIInteractions implements Task{

	 public UserRegister() {
	    
	    }
	 
	public static UserRegister fromUnderlineDetails() {
		return new UserRegister();
	}
	
	@Override
	public <T extends Actor> void performAs(T actor) {
		waitABit(1000);
		actor.wasAbleTo(NavigateTo.theLoginPage());
		waitABit(1000);
		
		actor.attemptsTo(Click.on(HomePage.SIGNUP_LINK));
		waitABit(2000);
		
		actor.attemptsTo(Enter.keyValues("TestUser"+CommonUtil.generateRandomNumber()).into(HomePage.NAME));
		waitABit(1000);
		
		actor.attemptsTo(Enter.keyValues("testuser"+CommonUtil.generateRandomNumber()+"@yopmail.com").into(HomePage.EMAIL));
		waitABit(1000);
		
		actor.attemptsTo(Enter.keyValues("Asdf!2345").into(HomePage.PASSWORD));
		waitABit(1000);
		
		actor.attemptsTo(Enter.keyValues("Asdf!2345").into(HomePage.CONFIRM_PASSWORD));
		waitABit(1000);
		
		actor.attemptsTo(Click.on(HomePage.TNC));
		waitABit(1000);
		
		actor.attemptsTo(Scroll.to(HomePage.SIGNUP_BTN).andAlignToBottom());
		
		actor.attemptsTo(Click.on(HomePage.SIGNUP_BTN));
		waitABit(3000);	
	}
}
