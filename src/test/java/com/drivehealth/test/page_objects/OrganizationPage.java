package com.drivehealth.test.page_objects;

import java.util.Random;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class OrganizationPage extends PageObject{

	public static Target ORG_BTN = Target.the("org btn").locatedBy("//button[contains(text(),'Organization')]");
	public static Target ORG_NAME = Target.the("org name").locatedBy("//input[@id='name']");
	public static Target ZIP_CODE = Target.the("zip code").locatedBy("//input[@id='zip_code']");
	public static Target SAVE_BTN = Target.the("save btn").locatedBy("//button[contains(text(),'Save')]");
	public static Target ORG_SEARCH_INPUT = Target.the("search input").locatedBy("//input[@placeholder='Search']");
	public static Target SEARCH_RESULT_HIGHLIGHTED = Target.the("search result").locatedBy("//span[@class='_Highlighted_18z0f_1']/child::mark");
	
	public static char rndChar () {
	    int rnd = (int) (Math.random() * 52); // or use Random or whatever
	    char base = (rnd < 26) ? 'A' : 'a';
	    return (char) (base + rnd % 26);

	}
	
    public static String generateRandomString(){

        final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        // Initializing the random variable
        Random random = new Random();

        StringBuilder sb = new StringBuilder();
        
        // Generating Random String using loop
        for (int i = 0; i < 5; i++) {
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }
	
	/*
	 * public static void main(String args[]) {
	 * System.out.println(OrganizationPage.generateRandomString()); }
	 */
}
