package SwagLabs.stepDefinitions;

import SwagLabs.classPackage.Login;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.ByteArrayInputStream;

import static SwagLabs.classPackage.BaseClass.driver;
//import static SwagLabs.classPackage.Login.driver;

public class Stepdef {
    Login obj = new Login();

//    @Given("Username and Password")
//    public void username_and_password() {
//    }
@Given("i am an existing user")
public void iAmAnExistingUser() {
    obj.openBrowser();

}

    @When("i open browser to {string}: www.saucedemo.com")
    public void iOpenBrowserToWwwSaucedemoCom(String url) {
        obj.openUrl(url);    }

    @And("fill correct username as {string} and password as {string}")
    public void fillCorrectUsernameAsAndPasswordAs(String username, String pswd) {
        obj.loginpage(username, pswd);
    }

    @And("press login button")
    public void pressLoginButton() {
        obj.clickLogin();
    }

    @Then("i see my application dashboard")
    public void iSeeMyApplicationDashboard() {
    }


    @Given("Check all the products")
    public void checkAllTheProducts() {

    }

    @And("Select the product that you want to order")
    public void selectTheProductThatYouWantToOrder() {
    }

    @When("Click on Add to cart")
    public void clickOnAddToCart() {
        obj.addToCart();

    }

    @And("it will add all your products in shopping cart")
    public void itWillAddAllYourProductsInShoppingCart() {

    }

    @Then("Click on shopping cart icon")
    public void clickOnShoppingCartIcon() {
    obj.icon();
        obj.continueShop();
    }

//    @Given("Open website")
//    public void openWebsite() {
//        obj.openUrl();
//    }
//    @Then("user enters {string} and password {string}")
//    public void userEntersAndPassword(String username, String pswd) {
//        obj.loginpage(username, pswd);
//    }
//
//    @When("login to the website")
//    public void login_to_the_website() {
//        obj.clickLogin();
//    }

//    @Given("Add product to the cart")
//    public void add_product_to_the_cart() {
//        obj.addToCart();
//    }
//
//    @Then("Click on continue")
//    public void clickOnContinue() {
//        obj.continueShop();
//    }

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


  }
