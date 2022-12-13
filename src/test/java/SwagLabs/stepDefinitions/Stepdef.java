package SwagLabs.stepDefinitions;

import SwagLabs.classPackage.Login;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

import static SwagLabs.classPackage.Login.driver;

public class Stepdef {
    Login obj = new Login();

//    @Given("Username and Password")
//    public void username_and_password() {
//    }

    @Given("Open website")
    public void openWebsite() {
        obj.openUrl();
    }
    @Then("user enters {string} and password {string}")
    public void userEntersAndPassword(String username, String pswd) {
        obj.loginpage(username, pswd);
    }

    @When("login to the website")
    public void login_to_the_website() {
        obj.clickLogin();
    }

    @Given("Add product to the cart")
    public void add_product_to_the_cart() {
        obj.addToCart();
    }

    @Then("Click on continue")
    public void clickOnContinue() {
        obj.continueShop();
    }

    @Given("Add another item")
    public void addAnotherItem()  {
        obj.addNewItem();
    }
    @Then("Checkout the product")
    public void checkout_the_product() {
        obj.checkOut();
    }

    @Given("Enter address information")
    public void enter_address_information() {
        obj.addressInfo();
    }

    @Then("Click Finish")
    public void click_finish() {
        obj.finishbutton();
    }

    @Given("goto react button")
    public void goto_react_button()  {
        obj.logOut();
    }

    @Then("click logout")
    public void click_logout() {
        obj.clickLogout();
    }


    @And("Close Browser")
    public void closeBrowser() {
        obj.close();
    }

    @And("remove Item from cart")
    public void removeItemFromCart() {
        obj.removeItem();
        obj.checkOut();
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Failed screenshot",new ByteArrayInputStream(screenshot));
        }
    }

    @Given("user enters invalid {string} and password {string}")
    public void userEntersInvalidAndPassword(String arg0, String arg1) {

    }

    @Then("Error message displayed with wrong password")
    public void errorMessageDisplayedWithWrongPassword() {
    }
}
