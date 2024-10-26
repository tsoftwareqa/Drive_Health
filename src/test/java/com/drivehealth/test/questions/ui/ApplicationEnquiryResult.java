package com.drivehealth.test.questions.ui;
import com.drivehealth.test.page_objects.HomePage;

import net.serenitybdd.screenplay.Question;


public class ApplicationEnquiryResult {
 
	HomePage homepage;
	private static final String statusval = "Verified";
	
    public static Question<String> hasDashBoardLabel() {
        return (actor) -> HomePage.DASHBOARD_LABEL.resolveFor(actor).getText();
    }
    
    public static Question<String> hasVerificationStatus() {
        return (actor) -> statusval;
    }
}
