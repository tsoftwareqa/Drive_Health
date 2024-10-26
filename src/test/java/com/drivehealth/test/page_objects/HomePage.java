package com.drivehealth.test.page_objects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.annotations.DefaultUrl;

@DefaultUrl("page:home.page")
public class HomePage extends PageObject {
	public static Target LOGIN_LINK = Target.the("login link").locatedBy("//a[contains(text(),'Log in')]");
	public static Target SIGNUP_LINK = Target.the("signup link").locatedBy("//a[@class='nav__account-signup']");
	public static Target USERNAME = Target.the("username").locatedBy("//input[@id='email']");
    public static Target PASSWORD = Target.the("password").locatedBy("//input[@id='password']");
    public static Target LOGIN_BTN = Target.the("submit").locatedBy("//button[contains(text(),'Login')]");
    public static Target DASHBOARD_LABEL = Target.the("Dashboard Label").locatedBy("//h2[@class='text-3xl font-bold']");
    public static Target DOWN_ARROW = Target.the("Down Arrow Link").locatedBy("//div[@class='flex flex-col items-start']");
    public static Target LOGOUT = Target.the("Logout Link").locatedBy("//button[contains(text(),'Logout')]");
    public static Target VERIFY_LOGIN_LABEL = Target.the("Verify Login Label").locatedBy("//h1[@class='text-2xl font-bold']");
    public static Target INVALID_LOGIN_ERROR_MESSAGE = Target.the("Error message").locatedBy("//div[@class='text-sm font-semibold flex gap-3']");
    public static Target APP_LOGO = Target.the("App logo").locatedBy("(//img[@src='/img/logo.a6ddeee1.svg'])[1]");
    public static Target APP_LOGOUT = Target.the("App logout").locatedBy("(//button[contains(text(),'Logout')])[1]");
    public static Target NAME = Target.the("name").locatedBy("//input[@placeholder='Name']");
    public static Target EMAIL = Target.the("email").locatedBy("//input[@placeholder='Email']");
    public static Target INPUT_PASSWORD = Target.the("password").locatedBy("//input[@placeholder='Password']");
    public static Target CONFIRM_PASSWORD = Target.the("confirm password").locatedBy("//input[@placeholder='Confirm password']");
    public static Target TNC = Target.the("tnc").locatedBy("//input[@id='termsCheck']");
    public static Target SIGNUP_BTN = Target.the("sign up btn").locatedBy("//button[@type='submit']");
    
    public boolean isLandingComplete(Actor actor) {

        double startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() < startTime + getWaitForTimeout().getSeconds() * 1000) {
            String previousState = BrowseTheWeb.as(actor).getDriver().getPageSource();
            waitABit(1500);
            if (previousState.equals(BrowseTheWeb.as(actor).getDriver().getPageSource())) {
                break;
            }
        }

        BrowseTheWeb.as(actor).waitFor(DASHBOARD_LABEL.getCssOrXPathSelector());
        return DASHBOARD_LABEL.isVisibleFor(actor);
    }
    
	/*
	 * 
	 * public List<String> getAscaMenu() { return findAll(ASCA_MENU).stream()
	 * .map(WebElementFacade::getText) .collect(Collectors.toList()); }
	 */
}
