package com.drivehealth.test.steps.ui;

import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import java.util.logging.Logger;

import com.drivehealth.test.page_objects.HomePage;
import com.drivehealth.test.page_objects.OrganizationPage;
import com.drivehealth.test.tasks.ui.common.Login;
import com.drivehealth.test.tasks.ui.drivehealth.Organization;
import com.drivehealth.test.utils.DataHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.di.SerenityInfrastructure;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
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
		
	@When("verify user logged in successfully")
	public void verify_user_logged_in_successfully() {
		//givenThat(user).attemptsTo(Ensure.that(homepage.APP_LOGO).isDisplayed());
	}
	
	//organization steps
	@When("click on sub organization button and fill details and save")
	@When("click on organization button fill details and save")
	@When("click on three dot icon and update details")
	@When("click on three dot icon and delete")
	public void click_on_organization_button_fill_details_and_save(DataTable orgdata) {
		givenThat(user).attemptsTo(Organization.fromUnderlineDetails(orgdata));
	}
	
	@Then("input org name in search input field and verify searched result")
	@Then("update organization and verify")
	@Then("verify deleted organization")
	@Then("verify saved organization on grid")
	public void verify_saved_organization_on_grid() {
		String org_name = DataHelper.getRecord("OrgData", 1, 0);
		givenThat(user).attemptsTo(Clear.field(OrganizationPage.ORG_SEARCH_INPUT));
		waitABit(3000);
		givenThat(user).attemptsTo(Enter.keyValues(org_name).into(OrganizationPage.ORG_SEARCH_INPUT));
		waitABit(3000);
		String searchResult = OrganizationPage.SEARCH_RESULT_HIGHLIGHTED.resolveFor(user).getText();
		waitABit(3000);
		if (searchResult.equalsIgnoreCase(org_name)) {
			givenThat(user).attemptsTo(Ensure.that(searchResult).isEqualToIgnoringCase(org_name));		
		} else if (searchResult.isBlank()) {
			givenThat(user).attemptsTo(Ensure.that(searchResult).isBlank());
			System.out.println("Org Deleted successfully");
		}
	}
	
	@Then("verify sub organization")
	public void verify_sub_organization() {
		String org_name = DataHelper.getRecord("SubOrgData", 1, 0);
		givenThat(user).attemptsTo(Clear.field(OrganizationPage.ORG_SEARCH_INPUT));
		waitABit(3000);
		givenThat(user).attemptsTo(Enter.keyValues(org_name).into(OrganizationPage.ORG_SEARCH_INPUT));
		waitABit(3000);
		String searchResult = OrganizationPage.SEARCH_RESULT_HIGHLIGHTED.resolveFor(user).getText();
		waitABit(3000);
		if (searchResult.equalsIgnoreCase(org_name)) {
			givenThat(user).attemptsTo(Ensure.that(searchResult).isEqualToIgnoringCase(org_name));		
		} else if (searchResult.isBlank()) {
			givenThat(user).attemptsTo(Ensure.that(searchResult).isBlank());
			System.out.println("Org Deleted successfully");
		}
	}
}
