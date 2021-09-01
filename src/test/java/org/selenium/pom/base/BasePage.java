package org.selenium.pom.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
    protected WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver=driver;
    }

}
