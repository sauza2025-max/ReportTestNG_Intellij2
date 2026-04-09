package org.example;
import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.OptionsWithArguments;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
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
        boolean isNotLocal = System.getenv("CI") != null ||
                System.getProperty("isRemote") != null;

        if (browser.equalsIgnoreCase("firefox")) {
            if  (isNotLocal) {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless=new"); // Required for Jenkins
                options.addArguments("--no-sandbox"); // Bypasses OS security model
                options.addArguments("--disable-dev-shm-usage"); // Prevents memory crashes in containers
                options.addArguments("--disable-gpu"); // Recommended for CI environments
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(options);
            }
                else {
                driver = new FirefoxDriver();
            }
        } else if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            if  (isNotLocal) {
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--headless=new"); // Required for Jenkins
                options.addArguments("--no-sandbox"); // Bypasses OS security model
                options.addArguments("--disable-dev-shm-usage"); // Prevents memory crashes in containers
                options.addArguments("--disable-gpu"); // Recommended for CI environments
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver(options);
            }
            else {
                driver = new EdgeDriver();
            }
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