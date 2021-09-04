package org.selenium.pom.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
    protected WebDriver driver;
    protected BasePage(WebDriver driver){
        this.driver=driver;
    }

    protected void load(String endpoint){
        driver.get("http://automationpractice.com/"+endpoint);
    }

}
