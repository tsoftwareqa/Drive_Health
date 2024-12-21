package com.drivehealth.test.tasks.ui.drivehealth;

import java.util.Map;

import com.drivehealth.test.page_objects.PromptPage;
import com.drivehealth.test.page_objects.SurveyPage;
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

public class Survey extends UIInteractions implements Task {

	private static String action;

	public Survey(String action) {
		this.action = action;
	}

	public static Survey fromUnderlineDetails(DataTable surveydata) {
		Map<String, String> survey_data = ConvertCucumberDataTable.toMap(surveydata);
		action = survey_data.get("Action");

		return new Survey(action);
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		actor.attemptsTo(Click.on(SurveyPage.SURVEY_TAB));

		String surveytitle="";
		switch (action) {
		case "AddSurvey":
			waitABit(4000);
			actor.attemptsTo(Click.on(SurveyPage.ADD_SURVEY_BTN));

			surveytitle = "A Health Survey";
			waitABit(2000);
			actor.attemptsTo(Enter.keyValues(surveytitle).into(SurveyPage.SURVEY_TITLE));

			DataHelper.writeStaffInfo("survey", surveytitle, 0, 0);

			waitABit(2000);
			actor.attemptsTo(Click.on(SurveyPage.SELECT_ORG));

			waitABit(2000);
			actor.attemptsTo(Click.on(SurveyPage.ORG_SELECTION));

			waitABit(2000);
			actor.attemptsTo(Scroll.to(SurveyPage.QUESTION_TITLE).andAlignToTop());

			waitABit(2000);
			actor.attemptsTo(
					Enter.keyValues("How would you rate your overall health?").into(SurveyPage.QUESTION_TITLE));

			waitABit(2000);
			actor.attemptsTo(Enter.keyValues("Excellent").into(SurveyPage.OPTION_ONE));

			waitABit(2000);
			actor.attemptsTo(Enter.keyValues("Good").into(SurveyPage.OPTION_TWO));

			waitABit(2000);
			actor.attemptsTo(Enter.keyValues("Average").into(SurveyPage.OPTION_THREE));

			waitABit(2000);
			actor.attemptsTo(Enter.keyValues("Fair").into(SurveyPage.OPTION_FOUR));

			waitABit(2000);
			actor.attemptsTo(Click.on(SurveyPage.SAVE_BTN));

			waitABit(3000);
			break;

		case "EditSurvey":
			waitABit(2000);
			actor.attemptsTo(Click.on(SurveyPage.EDIT_SURVEY_ICON));
			
			actor.attemptsTo(Click.on(SurveyPage.EDIT));
			
			actor.attemptsTo(Click.on(SurveyPage.EDIT_POPUP));
			
			surveytitle = "A Updated Health Survey";

			waitABit(2000);
			actor.attemptsTo(Clear.field(SurveyPage.SURVEY_TITLE));

			waitABit(1000);
			actor.attemptsTo(Enter.keyValues(surveytitle).into(SurveyPage.SURVEY_TITLE));

			DataHelper.writeStaffInfo("survey", surveytitle, 0, 0);

			waitABit(1000);
			actor.attemptsTo(Scroll.to(SurveyPage.SAVE_BTN).andAlignToTop());

			waitABit(2000);
			actor.attemptsTo(Click.on(SurveyPage.SAVE_BTN));

			waitABit(2000);
			actor.attemptsTo(Click.on(PromptPage.PROMPT_TAB));
			
			waitABit(2000);
			actor.attemptsTo(Click.on(SurveyPage.SURVEY_TAB));
			
			waitABit(3000);
			break;

		case "DeleteSurvey":
			
			waitABit(2000);
			actor.attemptsTo(Click.on(SurveyPage.EDIT_SURVEY_ICON));

			waitABit(2000);
			actor.attemptsTo(Click.on(SurveyPage.DELETE));

			waitABit(2000);
			actor.attemptsTo(Click.on(SurveyPage.DELETE_CONFIRM));

			waitABit(3000);
			break;

		default:
			System.out.println("No action");
			break;
		}
	}

}
