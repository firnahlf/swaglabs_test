package swaglabs.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class add_to_cart_step {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user success to login")
    public void successlogin(){
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @When("user click add to cart in product")
    public void addtocart(){
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
    }

    @Then("system success add to cart")
    public void successtocart(){
        String badgecart =driver.findElement(By.id("shopping_cart_badge")).getText();
        Assert.assertEquals(badgecart, "1");
        driver.findElement(By.id("shopping_cart_link")).click();
        String productcart =driver.findElement(By.className("inventory_item_name")).getText();
        Assert.assertEquals(productcart, "Sauce Labs Bolt T-Shirt");
    }

}
