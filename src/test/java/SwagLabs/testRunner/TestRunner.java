package SwagLabs.testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.After;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = ("src/test/resources/feature"),
    glue = {"SwagLabs.stepDefinitions"},
    tags = "@Regression or @Smoke",
    plugin = {"pretty",
    "html:target/cucumber-report/report.html",
    "json:target/cucumber-report/report.json",
    "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})
public class TestRunner {
@After
    public void tearDown(){

    }

}
