package org.selenium.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverManager {

    public WebDriver initializeDriver(){
        WebDriverManager.chromedriver().cachePath("Drivers").setup();
        WebDriver driver = new ChromeDriver();
        //WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
        //WebDriver driverFirefox = new FirefoxDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
}
