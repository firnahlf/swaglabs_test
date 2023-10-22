import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class login {
    @Test //tag untuk run automation
    public void open_browser(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        String title = driver.getTitle();
        System.out.println(title);
        driver.close();

    }
}
