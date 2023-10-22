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

public class checkout_step {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user success to login and go to cart page")
    public void cartpage(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("shopping_cart_link")).click();
    }

    @When("user click checkout")
    public void checkoutpage(){
        driver.findElement(By.id("checkout")).click();
        String titlecheckout = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(titlecheckout, "Checkout: Your Information");
    }

    @And("user fill all form")
    public void fillform(){
        driver.findElement(By.id("first-name")).sendKeys("firna");
        driver.findElement(By.id("last-name")).sendKeys("helfira");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
    }

    @And("user click continue")
    public void successcheckout(){
        driver.findElement(By.id("continue")).click();
    }

    @And("user view detail checkout overview")
    public void detailcheckout(){
        String title = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(title, "Checkout: Overview");
        String info = driver.findElement(By.className("summary_value_label")).getText();
        Assert.assertEquals(info, "SauceCard #31337");
        String total = driver.findElement(By.className("summary_total_label")).getText();
        Assert.assertEquals(total, "$17.27");
    }

    @And("user click finish")
    public void finish(){
        driver.findElement(By.id("finish")).click();
    }

    @Then("user success to checkout product")
    public void success(){
        String complete = driver.findElement(By.className("complete-header")).getText();
        Assert.assertEquals(complete, "Thank you for your order!");
    }




}
