package swaglabs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginFeature {
    @Test
    public void loginsuccess(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";
        WebDriverManager.chromedriver().setup();

        //loginpage
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        //inputemail
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //inputpassword
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //login
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.className("app_logo"));
        driver.close();
    }
}
