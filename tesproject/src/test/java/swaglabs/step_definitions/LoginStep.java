package swaglabs.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginStep {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user is on login page")
        public void halaman_login(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(baseUrl);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }

    @When("user input username")
        public void input_username(){

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("user input password")
        public void input_password(){

        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("user click button login")
        public void submitLogin(){

        driver.findElement(By.id("login-button")).click();
    }

    @Then("user success to login")
        public void success_login(){
            String homepageAssert = driver.findElement(By.className("title")).getText();
            Assert.assertEquals(homepageAssert, "Products");
            driver.close();
        }

    @And("user input wrong password")
        public void inputwrongpassword(){

        driver.findElement(By.id("password")).sendKeys("123456");
    }

    @Then("user will get error message")
        public void failedlogin(){
            String errorlogin = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
            Assert.assertEquals(errorlogin, "Epic sadface: Username and password do not match any user in this service");
            driver.close();
        }
}
