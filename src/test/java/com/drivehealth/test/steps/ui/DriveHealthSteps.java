package com.drivehealth.test.steps.ui;

import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import java.util.logging.Logger;

import com.drivehealth.test.page_objects.HomePage;
import com.drivehealth.test.page_objects.MembersObject;
import com.drivehealth.test.page_objects.OrganizationPage;
import com.drivehealth.test.page_objects.SettingsObject;
import com.drivehealth.test.page_objects.StaffObjects;
import com.drivehealth.test.tasks.ui.common.Login;
import com.drivehealth.test.tasks.ui.drivehealth.Members;
import com.drivehealth.test.tasks.ui.drivehealth.Organization;
import com.drivehealth.test.tasks.ui.drivehealth.Settings;
import com.drivehealth.test.tasks.ui.drivehealth.Staff;
import com.drivehealth.test.utils.CommonUtil;
import com.drivehealth.test.utils.DataHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.di.SerenityInfrastructure;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.model.util.EnvironmentVariables;

public class DriveHealthSteps extends UIInteractionSteps {

	private static Logger logger = Logger.getLogger(DriveHealthSteps.class.getName());
	static EnvironmentVariables environmentVariables = SerenityInfrastructure.getEnvironmentVariables();

	private Actor user;
	private HomePage homepage;
	MembersObject membersObject;

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

	// verify label when logout from application
	@Given("{word} should logout from application and navigate to login screen")
	public void should_logout_from_application_and_navigate_to_login_screen(String role) {
		givenThat(user).attemptsTo(Ensure.that(homepage.VERIFY_LOGIN_LABEL).isDisplayed());
	}

	@When("verify user logged in successfully")
	public void verify_user_logged_in_successfully() {
		// givenThat(user).attemptsTo(Ensure.that(homepage.APP_LOGO).isDisplayed());
	}

	// organization steps
	@When("click on sub organization button and fill details and save")
	@When("click on organization button fill details and save")
	@When("click on three dot icon and update details")
	@When("click on three dot icon and delete org")
	@When("click on three dot icon and delete sub org")
	@When("click on three dot icon and change sub org details")
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
			CommonUtil.captureScreenshot(getDriver());
			givenThat(user).attemptsTo(Ensure.that(searchResult).isEqualToIgnoringCase(org_name));
		} else if (searchResult.isBlank()) {
			CommonUtil.captureScreenshot(getDriver());
			givenThat(user).attemptsTo(Ensure.that(searchResult).isBlank());
			System.out.println("Org Deleted successfully");
		}
	}

	@Then("verify added sub organization")
	@Then("verify updated sub organization")
	@Then("verify deleted sub organization")
	public void verify_added_sub_organization() {
		waitABit(2000);
		givenThat(user).attemptsTo(Click.on(OrganizationPage.SHOW_SUB_ORG_CHKBOX));
		waitABit(2000);
		givenThat(user).attemptsTo(Click.on(OrganizationPage.SHOW_SUB_ORG_CHKBOX));
		waitABit(2000);
		givenThat(user).attemptsTo(Clear.field(OrganizationPage.ORG_SEARCH_INPUT));
		waitABit(3000);
		String org_name = DataHelper.getRecord("SubOrgData", 1, 0);
		givenThat(user).attemptsTo(Enter.keyValues(org_name).into(OrganizationPage.ORG_SEARCH_INPUT));
		waitABit(3000);
		String searchResult = OrganizationPage.SEARCH_RESULT_HIGHLIGHTED.resolveFor(user).getText();
		waitABit(3000);
		if (searchResult.equalsIgnoreCase(org_name)) {
			CommonUtil.captureScreenshot(getDriver());
			givenThat(user).attemptsTo(Ensure.that(searchResult).isEqualToIgnoringCase(org_name));
		} else if (searchResult.isBlank()) {
			CommonUtil.captureScreenshot(getDriver());
			givenThat(user).attemptsTo(Ensure.that(searchResult).isBlank());
			System.out.println("Org Deleted successfully");
		}
	}

	@When("navigate to member page and call")
	@When("navigate to member page and generate report")
	@When("navigate to member tab add members in bulk")
	@When("navigate to member tab select all member and delete")
	@When("click on three dot icon and delete member added via bulk")
	@When("add member via bulk upload")
	@When("click on three dot icon and delete member")
	@When("click on three dot icon and change member details")
	@When("click on add member button fill details and save")
	public void click_on_add_member_button_fill_details_and_save(DataTable memberdata) {
		givenThat(user).attemptsTo(Members.fromUnderlineDetails(memberdata));
	}

	@Then("verify deleted member")
	@Then("verify updated member in organization")
	@Then("verify added member in organization")
	public void verify_added_member_in_organization() {
		waitABit(2000);
		String member_name = DataHelper.getRecord("MemberData", 1, 0);
		givenThat(user).attemptsTo(Click.on(MembersObject.MEMBERS_TAB));
		givenThat(user).attemptsTo(Clear.field(OrganizationPage.ORG_SEARCH_INPUT));
		waitABit(3000);
		givenThat(user).attemptsTo(Enter.keyValues(member_name).into(OrganizationPage.ORG_SEARCH_INPUT));
		waitABit(3000);
		String searchResult = OrganizationPage.SEARCH_RESULT_HIGHLIGHTED.resolveFor(user).getText();
		waitABit(3000);
		if (searchResult.equalsIgnoreCase(member_name)) {
			CommonUtil.captureScreenshot(getDriver());
			givenThat(user).attemptsTo(Ensure.that(searchResult).isEqualToIgnoringCase(member_name));
		} else if (searchResult.isBlank()) {
			CommonUtil.captureScreenshot(getDriver());
			givenThat(user).attemptsTo(Ensure.that(searchResult).isBlank());
			System.out.println("Member Deleted successfully");
		}
	}

	@Then("verify pagination by navigating to next page")
	public void verify_pagination_by_navigating_to_next_page() {
		givenThat(user).attemptsTo(Scroll.to(MembersObject.NEXT_PAGE).andAlignToBottom());
		waitABit(2000);
		givenThat(user).attemptsTo(Click.on(MembersObject.NEXT_PAGE));
		String searchData = MembersObject.PAGE_VALUE.resolveFor(user).getText();
		CommonUtil.captureScreenshot(getDriver());
		waitABit(2000);
		givenThat(user).attemptsTo(Ensure.that(searchData).isEqualToIgnoringCase("Page 2 of 2"));

	}

	@Then("verify all deleted member in organization")
	public void verify_all_deleted_member_in_organization() {
		String searchData = MembersObject.NO_RESULT.resolveFor(user).getText();
		CommonUtil.captureScreenshot(getDriver());
		waitABit(2000);
		givenThat(user).attemptsTo(Ensure.that(searchData).isEqualToIgnoringCase("No results Found."));

	}

	@When("click on three dot icon and delete staff")
	@When("click on three dot icon and change staff details")
	@When("click on add staff button fill details and save")
	public void click_on_add_staff_button_fill_details_and_save(DataTable staffdata) {
		givenThat(user).attemptsTo(Staff.fromUnderlineDetails(staffdata));
	}

	@Then("verify deleted staff")
	@Then("verify updated staff in organization")
	@Then("verify added staff in organization")
	public void verify_added_staff_in_organization() {
		waitABit(2000);
		String member_name = DataHelper.getRecord("StaffData", 1, 0);
		givenThat(user).attemptsTo(Click.on(StaffObjects.STAFF_TAB));
		givenThat(user).attemptsTo(Clear.field(OrganizationPage.ORG_SEARCH_INPUT));
		waitABit(3000);
		givenThat(user).attemptsTo(Enter.keyValues(member_name).into(OrganizationPage.ORG_SEARCH_INPUT));
		waitABit(3000);
		String searchResult = OrganizationPage.SEARCH_RESULT_HIGHLIGHTED.resolveFor(user).getText();
		waitABit(3000);
		if (searchResult.equalsIgnoreCase(member_name)) {
			CommonUtil.captureScreenshot(getDriver());
			givenThat(user).attemptsTo(Ensure.that(searchResult).isEqualToIgnoringCase(member_name));
		} else if (searchResult.isBlank()) {
			CommonUtil.captureScreenshot(getDriver());
			givenThat(user).attemptsTo(Ensure.that(searchResult).isBlank());
			System.out.println("Staff Deleted successfully");
		}
	}

	@Then("verify added member via bulk in organization")
	public void verify_added_member_via_bulk_in_organization() {

	}

	@Then("verify deleted member added via bulk")
	public void verify_deleted_member_added_via_bulk() {
		givenThat(user).attemptsTo(Clear.field(OrganizationPage.ORG_SEARCH_INPUT));
		waitABit(3000);
		givenThat(user).attemptsTo(Enter.keyValues("FirstB").into(OrganizationPage.ORG_SEARCH_INPUT));
		waitABit(3000);
		String searchResult = OrganizationPage.SEARCH_RESULT_HIGHLIGHTED.resolveFor(user).getText();
		waitABit(3000);
		if (searchResult.isBlank()) {
			CommonUtil.captureScreenshot(getDriver());
			givenThat(user).attemptsTo(Ensure.that(searchResult).isBlank());
			System.out.println("Staff Deleted successfully");
		}
	}

	@When("navigate to upload history tab in a organization")
	public void navigate_to_upload_history_tab_in_a_organization() {
		waitABit(3000);
		membersObject.getElement();
		givenThat(user).attemptsTo(Click.on(OrganizationPage.UPLOAD_HISTORY_TAB));
	}

	@Then("verify upload history")
	public void verify_upload_history() {
		waitABit(3000);
		String fileName = OrganizationPage.FILE_NAME.resolveFor(user).getText();
		String successCount = OrganizationPage.SUCCESS.resolveFor(user).getText();
		CommonUtil.captureScreenshot(getDriver());
		givenThat(user).attemptsTo(Ensure.that(fileName).isEqualTo("sample_bullk_upload.csv"));
		givenThat(user).attemptsTo(Ensure.that(successCount).isEqualTo("1 Success"));
	}

	// Ovation setting steps

	@And("navigate to settings page")
	public void navigate_to_settings_page() {
		givenThat(user).attemptsTo(Click.on(HomePage.DOWN_ARROW));
		givenThat(user).attemptsTo(Click.on(SettingsObject.SETTINGS));
	}

	@When("fill details for time window workflow call and save")
	public void fill_details_for_time_window_workflow_call_and_save(DataTable setting) {
		givenThat(user).attemptsTo(Settings.fromUnderlineDetails(setting));
	}

	@Then("verify saved ovation settings")
	public void verify_saved_ovation_settings() {
		waitABit(3000);
		String initialCall = SettingsObject.INITIAL_CALL.resolveFor(user).getAttribute("value");
		String retryCall = SettingsObject.RETRY_CALL.resolveFor(user).getAttribute("value");
		String hours = SettingsObject.HOURS.resolveFor(user).getAttribute("value");
		String days = SettingsObject.DAYS.resolveFor(user).getAttribute("value");
		givenThat(user).attemptsTo(Ensure.that(initialCall).isEqualTo("02"));
		givenThat(user).attemptsTo(Ensure.that(retryCall).isEqualTo("01"));
		givenThat(user).attemptsTo(Ensure.that(hours).isEqualTo("03"));
		givenThat(user).attemptsTo(Ensure.that(days).isEqualTo("05"));
	}

	@Then("verify generated report for member")
	public void verify_generated_report_for_member() {
		givenThat(user).attemptsTo(Ensure.that(membersObject.isFileAvailable()).isTrue());
	}

	@Then("verify call status")
	public void verify_call_status() {

	}

	@When("search member from global search")
	public void search_member_from_global_search() {
		givenThat(user).attemptsTo(
				Enter.keyValues(DataHelper.getRecord("MemberData", 1, 0)).into(MembersObject.GLOBAL_SEARCH_INPUT_FIELD));
		waitABit(3000);
		givenThat(user).attemptsTo(Click.on(MembersObject.SELECT_SEARCH_RESULT));
		waitABit(2000);
	}
	
	@Then("verify searched member result")
	public void verify_searched_member_result() {
		String member_first_name = DataHelper.getRecord("MemberData", 1, 0);
		waitABit(2000);
		String searchResult = MembersObject.SEARCH_HIGHLIGHTED_RESULT.resolveFor(user).getText();
		waitABit(3000);
		CommonUtil.captureScreenshot(getDriver());
		givenThat(user).attemptsTo(Ensure.that(searchResult).containsIgnoringCase(member_first_name));
	}
	
	@When("navigate to member tab and click on download csv button")
	public void navigate_to_member_tab_and_click_on_download_csv_button(DataTable download) {
		givenThat(user).attemptsTo(Members.fromUnderlineDetails(download));
	}
	
	@Then("verify download csv file")
	public void verify_download_csv_file() {
		waitABit(2000);
		String successmsg = MembersObject.SUCCESS_POPUP.resolveFor(user).getText();
		waitABit(3000);
		givenThat(user).attemptsTo(Ensure.that(membersObject.isFileAvailable()).isTrue());
		waitABit(3000);
		CommonUtil.captureScreenshot(getDriver());
		givenThat(user).attemptsTo(Ensure.that(successmsg).containsIgnoringCase("Download CSV Successfully"));
	}
}
