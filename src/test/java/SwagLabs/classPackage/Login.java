package SwagLabs.classPackage;


import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.util.concurrent.TimeUnit;

import static SwagLabs.classPackage.BaseClass.driver;
import static io.restassured.RestAssured.given;


public class Login {

//        public static WebDriver driver;
private static final String client_id = "E65911815E364EB2BD53C755B54B0F5D";
    private static final String client_secret = "a316a6cf2482bf606f043ef19b3fbb4512084d236edf18acc1e5093108caf4a8";
    //    private static final String base_url  = "https://xray.cloud.getxray.app/api/v1";
    private static final String token_value = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZW5hbnQiOiIyNmMwYTdjNy0wMWExLTM1YmMtYjk5OS03MjgxMTYxYmM4MjYiLCJhY2NvdW50SWQiOiI2MTFjMDQ3Njc4ZmIzMzAwNzcxNjBjOGIiLCJpc1hlYSI6ZmFsc2UsImlhdCI6MTY3NDYzODc2OCwiZXhwIjoxNjc0NzI1MTY4LCJhdWQiOiJFNjU5MTE4MTVFMzY0RUIyQkQ1M0M3NTVCNTRCMEY1RCIsImlzcyI6ImNvbS54cGFuZGl0LnBsdWdpbnMueHJheSIsInN1YiI6IkU2NTkxMTgxNUUzNjRFQjJCRDUzQzc1NUI1NEIwRjVEIn0.eYJTKC6QOzndpyqdE7NoAfLHqyoVsWA_Csme8lDMuEE";
    private static Response response;
    private static JsonPath token ;
    private static String jsonString;
    BaseClass obj = new BaseClass();
//        String url = "https://www.saucedemo.com/";

    public void openBrowser(){

            obj.setUp();
    }
//        @Before
        public void openUrl(String url) {
//            System.setProperty("webdriver.chrome.driver", "C:\\chrome\\chromedriver_win32\\chromedriver.exe");
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();

            driver.get(url);

        }


        public void loginpage(String username, String pswd) {
            System.out.println(driver.getTitle());

             driver.findElement(By.id("user-name")).sendKeys(username);
             driver.findElement(By.id("password")).sendKeys(pswd);

        }

        public void clickLogin() {

             driver.findElement(By.id("login-button")).click();
        }

        public void addToCart() {
             driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
             driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        public void icon(){
             driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();

        }

        public void continueShop(){
             driver.findElement(By.xpath("(//button[@id='continue-shopping'])")).click();

        }
        public void addNewItem() {
             driver.findElement(By.xpath("(//button[@id='add-to-cart-sauce-labs-bolt-t-shirt'])")).click();
             driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
             driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();

        }
        public void removeItem(){
             driver.findElement(By.xpath("(//button[@id='cancel'])")).click();
             driver.findElement(By.xpath("(//button[@id='remove-sauce-labs-backpack'])")).click();

        }
        public void checkOut() {
             driver.findElement(By.id("checkout")).click();
        }

        public void addressInfo() {
             driver.findElement(By.id("first-name")).sendKeys("Aaron");
             driver.findElement(By.id("last-name")).sendKeys("Tim C");
             driver.findElement(By.id("postal-code")).sendKeys("632101");
//            boolean cont = driver.findElement(By.id("continue")).isSelected();
//           Assert.assertEquals(cont,"continu");
            driver.findElement(By.id("continue")).click();
        }

        public void finishbutton() {
             driver.findElement(By.id("finish")).click();
//            boolean cont = driver.findElement(By.id("finish")).isSelected();
//            Assert.assertEquals(cont,"fish");
             driver.findElement(By.id("back-to-products")).click();
        }

        public void logOut() {
             driver.findElement(By.xpath("(//button[contains(text(),'Open Menu')])")).click();
             driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }

        public void clickLogout() {

            if( driver.findElement(By.id("logout_sidebar_link")).isEnabled()){
                 driver.findElement(By.xpath("(//a[@id='logout_sidebar_link'])")).click();

            }else {
                System.out.println("You need to logout now!!!");
            }
        }
    public void close(){
            driver.quit();
        }
    public void postRes(){

        RequestSpecification request = given();
        request.header("Content-Type", "application/json");
        response = request.body("{ \"client_id\":\"" + client_id + "\", \"client_secret\":\"" + client_secret + "\"}")
                .post("https://xray.cloud.getxray.app/api/v1/authenticate");
        System.out.println(response.asString());

//        jsonString = response.asString();
//
//        String jsonString = response.asString();
//        token = JsonPath.from(jsonString);


    }


    public void sendReq(){
        RequestSpecification request = given();
        request.
                header("Authorization","Bearer " + token_value).
                header("Content-Type","application/json");
        response = request.body("[{\"line\":7,\"elements\":[{\"start_timestamp\":\"2023-01-25T09:33:17.369Z\",\"line\":19,\"name\":\"login page\",\"description\":\"\",\"id\":\"creating-webpage;login-page;;2\",\"after\":[{\"result\":{\"duration\":12000800,\"status\":\"passed\"},\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.tearDown(io.cucumber.java.Scenario)\"}}],\"type\":\"scenario\",\"keyword\":\"Scenario Outline\",\"steps\":[{\"result\":{\"duration\":6520213900,\"status\":\"passed\"},\"line\":12,\"name\":\"i am an existing user\",\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.iAmAnExistingUser()\"},\"keyword\":\"Given \"},{\"result\":{\"duration\":878310900,\"status\":\"passed\"},\"line\":13,\"name\":\"i open browser to \\\"https://www.saucedemo.com/\\\": www.saucedemo.com\",\"match\":{\"arguments\":[{\"val\":\"\\\"https://www.saucedemo.com/\\\"\",\"offset\":18}],\"location\":\"SwagLabs.stepDefinitions.Stepdef.iOpenBrowserToWwwSaucedemoCom(java.lang.String)\"},\"keyword\":\"When \"},{\"result\":{\"duration\":331239700,\"status\":\"passed\"},\"line\":14,\"name\":\"fill correct username as \\\"standard_user\\\" and password as \\\"secret_sauce\\\"\",\"match\":{\"arguments\":[{\"val\":\"\\\"standard_user\\\"\",\"offset\":25},{\"val\":\"\\\"secret_sauce\\\"\",\"offset\":57}],\"location\":\"SwagLabs.stepDefinitions.Stepdef.fillCorrectUsernameAsAndPasswordAs(java.lang.String,java.lang.String)\"},\"keyword\":\"And \"},{\"result\":{\"duration\":179668300,\"status\":\"passed\"},\"line\":15,\"name\":\"press login button\",\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.pressLoginButton()\"},\"keyword\":\"And \"},{\"result\":{\"duration\":1383600,\"status\":\"passed\"},\"line\":16,\"name\":\"i see my application dashboard\",\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.iSeeMyApplicationDashboard()\"},\"keyword\":\"Then \"}],\"tags\":[{\"name\":\"@Shopping\"},{\"name\":\"@Severity=critical\"},{\"name\":\"@Owner=Reshma\"},{\"name\":\"@Epic=Shopping-website\"},{\"name\":\"@JX-32\"},{\"name\":\"@TEST_JX-24\"},{\"name\":\"@TESTSET_JX-29\"},{\"name\":\"@Regression\"}]},{\"start_timestamp\":\"2023-01-25T09:33:25.931Z\",\"line\":21,\"name\":\"Verify Shopping cart\",\"description\":\"\",\"id\":\"creating-webpage;verify-shopping-cart\",\"after\":[{\"result\":{\"duration\":498900,\"status\":\"passed\"},\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.tearDown(io.cucumber.java.Scenario)\"}}],\"type\":\"scenario\",\"keyword\":\"Scenario\",\"steps\":[{\"result\":{\"duration\":1030600,\"status\":\"passed\"},\"line\":22,\"name\":\"Check all the products\",\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.checkAllTheProducts()\"},\"keyword\":\"Given \"},{\"result\":{\"duration\":1000300,\"status\":\"passed\"},\"line\":23,\"name\":\"Select the product that you want to order\",\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.selectTheProductThatYouWantToOrder()\"},\"keyword\":\"And \"},{\"result\":{\"duration\":170326000,\"status\":\"passed\"},\"line\":24,\"name\":\"Click on Add to cart\",\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.clickOnAddToCart()\"},\"keyword\":\"When \"},{\"result\":{\"status\":\"passed\"},\"line\":25,\"name\":\"it will add all your products in shopping cart\",\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.itWillAddAllYourProductsInShoppingCart()\"},\"keyword\":\"And \"},{\"result\":{\"duration\":269877900,\"status\":\"passed\"},\"line\":26,\"name\":\"Click on shopping cart icon\",\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.clickOnShoppingCartIcon()\"},\"keyword\":\"Then \"}],\"tags\":[{\"name\":\"@Shopping\"},{\"name\":\"@Severity=critical\"},{\"name\":\"@Owner=Reshma\"},{\"name\":\"@Epic=Shopping-website\"},{\"name\":\"@JX-32\"},{\"name\":\"@TEST_JX-25\"},{\"name\":\"@TESTSET_JX-29\"},{\"name\":\"@Smoke\"}]},{\"start_timestamp\":\"2023-01-25T09:33:26.419Z\",\"line\":28,\"name\":\"Continue Shopping\",\"description\":\"\",\"id\":\"creating-webpage;continue-shopping\",\"after\":[{\"result\":{\"duration\":2014600,\"status\":\"passed\"},\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.tearDown(io.cucumber.java.Scenario)\"}}],\"type\":\"scenario\",\"keyword\":\"Scenario\",\"steps\":[{\"result\":{\"duration\":169620900,\"status\":\"passed\"},\"line\":29,\"name\":\"Add another item\",\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.addAnotherItem()\"},\"keyword\":\"Given \"},{\"result\":{\"duration\":64702700,\"status\":\"passed\"},\"line\":30,\"name\":\"Checkout the product\",\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.checkout_the_product()\"},\"keyword\":\"Then \"},{\"result\":{\"duration\":202276600,\"status\":\"passed\"},\"line\":31,\"name\":\"remove Item from cart\",\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.removeItemFromCart()\"},\"keyword\":\"And \"}],\"tags\":[{\"name\":\"@Shopping\"},{\"name\":\"@Severity=critical\"},{\"name\":\"@Owner=Reshma\"},{\"name\":\"@Epic=Shopping-website\"},{\"name\":\"@JX-32\"},{\"name\":\"@TEST_JX-26\"},{\"name\":\"@TESTSET_JX-29\"},{\"name\":\"@Regression\"}]},{\"start_timestamp\":\"2023-01-25T09:33:26.883Z\",\"line\":33,\"name\":\"Finishing order process\",\"description\":\"\",\"id\":\"creating-webpage;finishing-order-process\",\"after\":[{\"result\":{\"status\":\"passed\"},\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.tearDown(io.cucumber.java.Scenario)\"}}],\"type\":\"scenario\",\"keyword\":\"Scenario\",\"steps\":[{\"result\":{\"duration\":358381700,\"status\":\"passed\"},\"line\":34,\"name\":\"Enter address information\",\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.enter_address_information()\"},\"keyword\":\"Given \"},{\"result\":{\"duration\":125286700,\"status\":\"passed\"},\"line\":35,\"name\":\"Click Finish\",\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.click_finish()\"},\"keyword\":\"Then \"}],\"tags\":[{\"name\":\"@Shopping\"},{\"name\":\"@Severity=critical\"},{\"name\":\"@Owner=Reshma\"},{\"name\":\"@Epic=Shopping-website\"},{\"name\":\"@JX-32\"},{\"name\":\"@TEST_JX-27\"},{\"name\":\"@TESTSET_JX-29\"},{\"name\":\"@Smoke\"}]},{\"start_timestamp\":\"2023-01-25T09:33:27.386Z\",\"line\":37,\"name\":\"Logout from page\",\"description\":\"\",\"id\":\"creating-webpage;logout-from-page\",\"after\":[{\"result\":{\"status\":\"passed\"},\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.tearDown(io.cucumber.java.Scenario)\"}}],\"type\":\"scenario\",\"keyword\":\"Scenario\",\"steps\":[{\"result\":{\"duration\":48092100,\"status\":\"passed\"},\"line\":38,\"name\":\"goto react button\",\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.goto_react_button()\"},\"keyword\":\"Given \"},{\"result\":{\"duration\":129330400,\"status\":\"passed\"},\"line\":39,\"name\":\"click logout\",\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.click_logout()\"},\"keyword\":\"Then \"},{\"result\":{\"duration\":290691500,\"status\":\"passed\"},\"line\":40,\"name\":\"Close Browser\",\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.closeBrowser()\"},\"keyword\":\"And \"}],\"tags\":[{\"name\":\"@Shopping\"},{\"name\":\"@Severity=critical\"},{\"name\":\"@Owner=Reshma\"},{\"name\":\"@Epic=Shopping-website\"},{\"name\":\"@JX-32\"},{\"name\":\"@TEST_JX-28\"},{\"name\":\"@TESTSET_JX-29\"},{\"name\":\"@Regression\"}]},{\"start_timestamp\":\"2023-01-25T09:33:27.875Z\",\"line\":42,\"name\":\"Creating Rest API\",\"description\":\"\",\"id\":\"creating-webpage;creating-rest-api\",\"after\":[{\"result\":{\"status\":\"passed\"},\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.tearDown(io.cucumber.java.Scenario)\"}}],\"type\":\"scenario\",\"keyword\":\"Scenario\",\"steps\":[{\"result\":{\"status\":\"passed\"},\"line\":43,\"name\":\"Authenticate the token\",\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.authenticateTheToken()\"},\"keyword\":\"Given \"},{\"result\":{\"duration\":26605516800,\"status\":\"passed\"},\"line\":44,\"name\":\"Update Status in jira\",\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.updateStatusInJira()\"},\"keyword\":\"Then \"}],\"tags\":[{\"name\":\"@Shopping\"},{\"name\":\"@Severity=critical\"},{\"name\":\"@Owner=Reshma\"},{\"name\":\"@Epic=Shopping-website\"},{\"name\":\"@JX-32\"},{\"name\":\"@TEST_JX-31\"},{\"name\":\"@TESTSET_JX-29\"},{\"name\":\"@Smoke\"}]}],\"name\":\"Creating webpage\",\"description\":\"\",\"id\":\"creating-webpage\",\"keyword\":\"Feature\",\"uri\":\"file:src/test/resources/feature/Demo.feature\",\"tags\":[{\"name\":\"@Shopping\",\"type\":\"Tag\",\"location\":{\"line\":1,\"column\":1}},{\"name\":\"@Severity=critical\",\"type\":\"Tag\",\"location\":{\"line\":2,\"column\":1}},{\"name\":\"@Owner=Reshma\",\"type\":\"Tag\",\"location\":{\"line\":3,\"column\":1}},{\"name\":\"@Epic=Shopping-website\",\"type\":\"Tag\",\"location\":{\"line\":4,\"column\":1}},{\"name\":\"@JX-32\",\"type\":\"Tag\",\"location\":{\"line\":6,\"column\":1}}]}]")
                .post("https://xray.cloud.getxray.app/api/v1/import/execution/cucumber?projectKey=JX");
        System.out.println(response.getStatusCode());
        System.out.println(response.body().asString());
    }




}
