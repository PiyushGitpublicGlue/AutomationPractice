package org.selenium.pom.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected BasePage(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(15));
    }

    protected void load(String endpoint){
        driver.get("http://automationpractice.com/"+endpoint);
    }

    protected void waitForCartPopupDisplay(By element){
        List<WebElement> popUpList = driver.findElements(element);
        System.out.println("SIZE OF CART POPUP : "+popUpList.size());
        if(popUpList.size()>0){
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        }else {
            System.out.println("POPUP NOT SHOWN : ");
        }
    }

}
