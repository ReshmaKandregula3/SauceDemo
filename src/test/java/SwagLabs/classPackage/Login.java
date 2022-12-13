package SwagLabs.classPackage;

//import org.junit.Before;
//import org.junit.Test;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.*;
//import org.openqa.selenium.By;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.annotations.Listeners;

import java.io.ByteArrayInputStream;
import java.util.concurrent.TimeUnit;


public class Login {

        public static WebDriver driver;
        String url = "https://www.saucedemo.com/";
//        @Before
        public void openUrl() {

            System.setProperty("webdriver.chrome.driver", "C:\\chrome\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(url);

        }


        public void loginpage(String username, String pswd) {
            System.out.println(driver.getTitle());

//            Assert.assertEquals(driver.getTitle(),"Swag Lab");
//            if (driver.findElement(By.id("user-name")).isDisplayed()){
             driver.findElement(By.id("user-name")).sendKeys(username);
             driver.findElement(By.id("password")).sendKeys(pswd);

//            }else {
//                System.out.println(driver.findElement(By.xpath("(//h3[@data-test='error'])")).getText());
//            }
        }

        public void clickLogin() {

             driver.findElement(By.id("login-button")).click();
        }

        public void addToCart() {
             driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
             driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
//             driver.findElement(By.id("finish")).click();
            boolean cont = driver.findElement(By.id("finish")).isSelected();
            Assert.assertEquals(cont,"fish");
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

}
