package swaglabs.step_definitions;

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

public class view_detail_step {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user login and direct to homepage")
    public void user_success_login() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @When("user click one of product")
    public void view_detail_product(){
        driver.findElement(By.className("inventory_item_name")).click();
    }

    @Then("system direct to detail product")
    public void success_detail_product(){
        String title_product =driver.findElement(By.className("inventory_details_name")).getText();
        Assert.assertEquals(title_product, "Sauce Labs Bolt T-Shirt");
        String price_product =driver.findElement(By.className("inventory_details_price")).getText();
        Assert.assertEquals(price_product, "$15.99");
        driver.close();
    }
}
