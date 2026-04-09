package org.example;
import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.*;

public class CrossBrowserTest {
    WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setup(String browser) throws Exception {
        if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            throw new Exception("Incorrect Browser");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void verifyTitle() {
        driver.get("https://www.browserstack.com/");
        System.out.println("Title is: " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Most Reliable App & Cross Browser Testing Platform | BrowserStack");
        driver.quit();
    }

}