package com.hqt.automationtestwithselenium.login;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HostelManagementTest {
    
    @Test
    public void testLoginWithValidatedAccountReturnWell() {
        // The Selenium client library communicates with the ChromeDriver via 
        // the JSON Wire Protocol. The Chrome browser driver acts like a link 
        // between the Selenium implementation code and the Chrome browser.
        // The System.setProperty is the beginning line that requires to be added 
        // to our test prior creation of webdriver initialization.
        String driverPath = "chromedriver.exe";
        System.getProperty("webdriver.chrome.driver", driverPath);
        WebDriver myBrowser = new ChromeDriver(); // This is basically used to create an instance of the chrome driver.
        
        myBrowser.get("http://localhost:8080/HappyHostel/loginPage");
        
        WebElement emailInputElement = myBrowser.findElement(By.name("txtemail"));
        WebElement passwordInputElement = myBrowser.findElement(By.name("txtpassword"));
        
        emailInputElement.sendKeys("owner");
        passwordInputElement.sendKeys("123456");
        
        WebElement submitBtnElement = myBrowser.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/form/button"));
        submitBtnElement.click();
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(HostelManagementTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        WebElement welcomeElement = myBrowser.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div[1]/div/div"));
        String text = welcomeElement.getText();
        
        assertEquals("Chào mừng, Nguyễn Tuấn Kiệt", text);
    }
    
}
