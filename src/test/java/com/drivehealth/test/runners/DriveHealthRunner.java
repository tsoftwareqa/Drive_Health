package com.drivehealth.test.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features/survey.feature"},
        plugin = {"pretty"},
        glue = {"com.drivehealth.test"},
        tags = "@SmokeTest",
        dryRun = false)

public class DriveHealthRunner {

}