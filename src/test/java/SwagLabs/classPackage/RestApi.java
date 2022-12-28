package SwagLabs.classPackage;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.*;


public class RestApi {

    private static final String client_id = "E65911815E364EB2BD53C755B54B0F5D";
    private static final String client_secret = "a316a6cf2482bf606f043ef19b3fbb4512084d236edf18acc1e5093108caf4a8";
//    private static final String base_url  = "https://xray.cloud.getxray.app/api/v1";
    private static final String token_value = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZW5hbnQiOiIyNmMwYTdjNy0wMWExLTM1YmMtYjk5OS03MjgxMTYxYmM4MjYiLCJhY2NvdW50SWQiOiI2MTFjMDQ3Njc4ZmIzMzAwNzcxNjBjOGIiLCJpc1hlYSI6ZmFsc2UsImlhdCI6MTY3MjIwNzgyNywiZXhwIjoxNjcyMjk0MjI3LCJhdWQiOiJFNjU5MTE4MTVFMzY0RUIyQkQ1M0M3NTVCNTRCMEY1RCIsImlzcyI6ImNvbS54cGFuZGl0LnBsdWdpbnMueHJheSIsInN1YiI6IkU2NTkxMTgxNUUzNjRFQjJCRDUzQzc1NUI1NEIwRjVEIn0.L1A6M-11lgP2LrWtjitEF8bvhzDcD5sTxx6V82HNXyk";
    private static Response response;
    private static JsonPath token ;
    private static String jsonString;

//    Generating 24hr token
    @Test
    public void postRes(){

        RequestSpecification request = given();
        request.header("Content-Type", "application/json");
        response = request.body("{ \"client_id\":\"" + client_id + "\", \"client_secret\":\"" + client_secret + "\"}")
                .post("https://xray.cloud.getxray.app/api/v1/authenticate");
        System.out.println(response.asString());

         jsonString = response.asString();

        String jsonString = response.asString();
        token = JsonPath.from(jsonString);


    }


    @Test
    public void sendReq(){
        RequestSpecification request = given();
        request.
                header("Authorization","Bearer " + token_value).
                header("Content-Type","application/json");
        response = request.body("[{\"line\":2,\"elements\":[{\"start_timestamp\":\"2022-12-28T06:51:27.994Z\",\"line\":14,\"name\":\"login page\",\"description\":\"\",\"id\":\"swaglabs-website;login-page;;2\",\"after\":[{\"result\":{\"duration\":6908000,\"status\":\"passed\"},\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.tearDown(io.cucumber.java.Scenario)\"}}],\"type\":\"scenario\",\"keyword\":\"Scenario Outline\",\"steps\":[{\"result\":{\"duration\":3606595800,\"status\":\"passed\"},\"line\":7,\"name\":\"i am an existing user\",\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.iAmAnExistingUser()\"},\"keyword\":\"Given \"},{\"result\":{\"duration\":320602600,\"status\":\"passed\"},\"line\":8,\"name\":\"i open browser to \\\"https://www.saucedemo.com/\\\": www.saucedemo.com\",\"match\":{\"arguments\":[{\"val\":\"\\\"https://www.saucedemo.com/\\\"\",\"offset\":18}],\"location\":\"SwagLabs.stepDefinitions.Stepdef.iOpenBrowserToWwwSaucedemoCom(java.lang.String)\"},\"keyword\":\"When \"},{\"result\":{\"duration\":163525900,\"status\":\"passed\"},\"line\":9,\"name\":\"fill correct username as \\\"standard_user\\\" and password as \\\"secret_sauce\\\"\",\"match\":{\"arguments\":[{\"val\":\"\\\"standard_user\\\"\",\"offset\":25},{\"val\":\"\\\"secret_sauce\\\"\",\"offset\":57}],\"location\":\"SwagLabs.stepDefinitions.Stepdef.fillCorrectUsernameAsAndPasswordAs(java.lang.String,java.lang.String)\"},\"keyword\":\"And \"},{\"result\":{\"duration\":81300700,\"status\":\"passed\"},\"line\":10,\"name\":\"press login button\",\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.pressLoginButton()\"},\"keyword\":\"And \"},{\"result\":{\"duration\":998600,\"status\":\"passed\"},\"line\":11,\"name\":\"i see my application dashboard\",\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.iSeeMyApplicationDashboard()\"},\"keyword\":\"Then \"}],\"tags\":[{\"name\":\"@JX-30\"},{\"name\":\"@TEST_JX-24\"},{\"name\":\"@TESTSET_JX-29\"}]},{\"start_timestamp\":\"2022-12-28T06:51:32.410Z\",\"line\":16,\"name\":\"Verify Shopping cart\",\"description\":\"\",\"id\":\"swaglabs-website;verify-shopping-cart\",\"after\":[{\"result\":{\"duration\":493500,\"status\":\"passed\"},\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.tearDown(io.cucumber.java.Scenario)\"}}],\"type\":\"scenario\",\"keyword\":\"Scenario\",\"steps\":[{\"result\":{\"duration\":997100,\"status\":\"passed\"},\"line\":17,\"name\":\"Check all the products\",\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.checkAllTheProducts()\"},\"keyword\":\"Given \"},{\"result\":{\"duration\":1165600,\"status\":\"passed\"},\"line\":18,\"name\":\"Select the product that you want to order\",\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.selectTheProductThatYouWantToOrder()\"},\"keyword\":\"And \"},{\"result\":{\"duration\":43917600,\"status\":\"passed\"},\"line\":19,\"name\":\"Click on Add to cart\",\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.clickOnAddToCart()\"},\"keyword\":\"When \"},{\"result\":{\"duration\":995900,\"status\":\"passed\"},\"line\":20,\"name\":\"it will add all your products in shopping cart\",\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.itWillAddAllYourProductsInShoppingCart()\"},\"keyword\":\"And \"},{\"result\":{\"duration\":126390100,\"status\":\"passed\"},\"line\":21,\"name\":\"Click on shopping cart icon\",\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.clickOnShoppingCartIcon()\"},\"keyword\":\"Then \"}],\"tags\":[{\"name\":\"@JX-30\"},{\"name\":\"@TEST_JX-25\"},{\"name\":\"@TESTSET_JX-29\"}]},{\"start_timestamp\":\"2022-12-28T06:51:32.608Z\",\"line\":23,\"name\":\"Continue Shopping\",\"description\":\"\",\"id\":\"swaglabs-website;continue-shopping\",\"after\":[{\"result\":{\"duration\":1006500,\"status\":\"passed\"},\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.tearDown(io.cucumber.java.Scenario)\"}}],\"type\":\"scenario\",\"keyword\":\"Scenario\",\"steps\":[{\"result\":{\"duration\":96237900,\"status\":\"passed\"},\"line\":24,\"name\":\"Add another item\",\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.addAnotherItem()\"},\"keyword\":\"Given \"},{\"result\":{\"duration\":79533300,\"status\":\"passed\"},\"line\":25,\"name\":\"Checkout the product\",\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.checkout_the_product()\"},\"keyword\":\"Then \"},{\"result\":{\"duration\":179056000,\"status\":\"passed\"},\"line\":26,\"name\":\"remove Item from cart\",\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.removeItemFromCart()\"},\"keyword\":\"And \"}],\"tags\":[{\"name\":\"@JX-30\"},{\"name\":\"@TEST_JX-26\"},{\"name\":\"@TESTSET_JX-29\"}]},{\"start_timestamp\":\"2022-12-28T06:51:32.978Z\",\"line\":28,\"name\":\"Finishing order process\",\"description\":\"\",\"id\":\"swaglabs-website;finishing-order-process\",\"after\":[{\"result\":{\"status\":\"passed\"},\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.tearDown(io.cucumber.java.Scenario)\"}}],\"type\":\"scenario\",\"keyword\":\"Scenario\",\"steps\":[{\"result\":{\"duration\":307584200,\"status\":\"passed\"},\"line\":29,\"name\":\"Enter address information\",\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.enter_address_information()\"},\"keyword\":\"Given \"},{\"result\":{\"duration\":162755200,\"status\":\"passed\"},\"line\":30,\"name\":\"Click Finish\",\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.click_finish()\"},\"keyword\":\"Then \"}],\"tags\":[{\"name\":\"@JX-30\"},{\"name\":\"@TEST_JX-27\"},{\"name\":\"@TESTSET_JX-29\"}]},{\"start_timestamp\":\"2022-12-28T06:51:33.465Z\",\"line\":32,\"name\":\"Logout from page\",\"description\":\"\",\"id\":\"swaglabs-website;logout-from-page\",\"after\":[{\"result\":{\"status\":\"passed\"},\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.tearDown(io.cucumber.java.Scenario)\"}}],\"type\":\"scenario\",\"keyword\":\"Scenario\",\"steps\":[{\"result\":{\"duration\":53497600,\"status\":\"passed\"},\"line\":33,\"name\":\"goto react button\",\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.goto_react_button()\"},\"keyword\":\"Given \"},{\"result\":{\"duration\":179215700,\"status\":\"passed\"},\"line\":34,\"name\":\"click logout\",\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.click_logout()\"},\"keyword\":\"Then \"},{\"result\":{\"duration\":234243600,\"status\":\"passed\"},\"line\":35,\"name\":\"Close Browser\",\"match\":{\"location\":\"SwagLabs.stepDefinitions.Stepdef.closeBrowser()\"},\"keyword\":\"And \"}],\"tags\":[{\"name\":\"@JX-30\"},{\"name\":\"@TEST_JX-28\"},{\"name\":\"@TESTSET_JX-29\"}]}],\"name\":\"Swaglabs Website\",\"description\":\"\",\"id\":\"swaglabs-website\",\"keyword\":\"Feature\",\"uri\":\"file:src/test/resources/feature/Saucedemo.feature\",\"tags\":[{\"name\":\"@JX-30\",\"type\":\"Tag\",\"location\":{\"line\":1,\"column\":1}}]}]")
                .post("https://xray.cloud.getxray.app/api/v1/import/execution/cucumber?projectKey=JX");
        System.out.println(response.getStatusCode());
        System.out.println(response.body().asString());
    }


}
