package com.drivehealth.test.steps.ui;

import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import java.util.logging.Logger;

import com.drivehealth.test.page_objects.HomePage;
import com.drivehealth.test.questions.ui.ApplicationEnquiryResult;
import com.drivehealth.test.tasks.ui.common.Login;
import com.drivehealth.test.tasks.ui.drivehealth.UserRegister;
import com.drivehealth.test.utils.CommonUtil;
import com.drivehealth.test.utils.Key;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.core.di.SerenityInfrastructure;
import net.serenitybdd.core.pages.ClearContents;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.RememberThat;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.ClearBy;
import net.serenitybdd.screenplay.actions.ClearElement;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.model.util.EnvironmentVariables;

public class DriveHealthSteps extends UIInteractionSteps{

	private static Logger logger = Logger.getLogger(DriveHealthSteps.class.getName());
	static EnvironmentVariables environmentVariables = SerenityInfrastructure.getEnvironmentVariables();

	private Actor user;
	private HomePage homepage;
		
	@Before(order = 2)
	public void setup() {
		user = OnStage.theActor("user");
	}
	
	@Given("{word} is on Home page of application and login")
	public void user_is_on_home_page_of_application_and_login(String role) {
		user.assignName(role);
		givenThat(user).attemptsTo(Login.withValidAdminCredentials());
	}
	
	@When("{word} verify dashboard label")
	public void verify_validation_message(String role) {
		givenThat(user).attemptsTo(Ensure.thatTheCurrentPage().currentUrl().contains("dashboard"));
		waitABit(5000);
	}
	
	@Given("{word} is on Home page of application and login with invalid credentials")
	public void is_on_Home_page_of_application_and_login_with_invalid_credentials(String role) {
		user.assignName(role);
		givenThat(user).attemptsTo(Login.withInvalidAdminCredentials());
	}

	@When("{word} verify error validation message")
	public void verify_error_validation_message(String role) {
		givenThat(user).attemptsTo(Ensure.that(homepage.INVALID_LOGIN_ERROR_MESSAGE.resolveFor(user).getText())
				.isEqualTo("Please enter the correct credentials"));
	}
	
	@When("{word} clicks on logout option")
	public void clicks_on_logout_option(String role) {
		givenThat(user).attemptsTo(Click.on(homepage.DOWN_ARROW));
		givenThat(user).attemptsTo(Click.on(homepage.LOGOUT));
		waitABit(3000);
	}
	
	//verify label when logout from application
	@Given("{word} should logout from application and navigate to login screen")
	public void should_logout_from_application_and_navigate_to_login_screen(String role) {
		givenThat(user).attemptsTo(Ensure.that(homepage.VERIFY_LOGIN_LABEL).isDisplayed());
	}
	
	@Given("{word} is on Home page of application and signup")
	public void user_is_on_home_page_of_application_and_signup(String role) {
		user.assignName(role);
		givenThat(user).attemptsTo(UserRegister.fromUnderlineDetails());
	}
	
	@When("verify user logged in successfully")
	public void verify_user_logged_in_successfully() {
		//givenThat(user).attemptsTo(Ensure.that(homepage.APP_LOGO).isDisplayed());
	}
}
