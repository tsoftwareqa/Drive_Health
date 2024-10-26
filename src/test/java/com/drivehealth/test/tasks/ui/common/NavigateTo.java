package com.drivehealth.test.tasks.ui.common;

import com.drivehealth.test.page_objects.HomePage;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
	
    public static Performable theLoginPage() {
        return Task.where("{0} opens the login page",
                Open.browserOn().the(HomePage.class));
    }
        
}
