package com.hqt.automationtestwithselenium.login;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PhpTravelsTest {
    
    // Test login function
    // Steps/Procedure:
    // 1. Open a certain browser, e.g. Chrome, Edge, Firefox, ...
    // 2. Navigate to login page - "https://phptravels.net/login"
    // 3. Fill pre-defined email and password in the email and password textboxes - "hqt@gmail.com/123456"
    // 4. Click Login button
    // 5. Wait for redirect to dashboard page
    // 6. In dashboard page, have a label displays wellcome message such as: "Hi, [Lastname] Welcome Back"
    
    // Expected result: Actual output "Hi, [Lastname] Welcome Back" must be "Hi, HQT Welcomeback"
    @Test
    public void testLoginWithValidatedAccountReturnWell() {
        // Step 1:
        // This function will help you check the current version of browser that
        // you are using and download the corresponding webdriver
        WebDriverManager.chromedriver().setup();
        WebDriver myBrowser = new ChromeDriver(); // This is basically used to create an instance of the chrome driver.
        
        // Step 2:
        myBrowser.get("https://phptravels.net/login");
        
        // Step 3:
        // Find and get email input element by name attribute
        WebElement emailInputElement = myBrowser.findElement(By.name("email"));
        // Find and get password input element by name attribute
        WebElement passwordInputElement = myBrowser.findElement(By.name("password")); 
        
        // Enter email address
        emailInputElement.sendKeys("hqt@gmail.com");
        // Enter password
        passwordInputElement.sendKeys("123456");
        
        // Step 4: 
        // Find and get login button element by xpath
        WebElement loginButtonBtn = myBrowser.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[3]/button")); 
        // Click login button
        loginButtonBtn.click();
        
        // Step 5:
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(PhpTravelsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Step 6:
        // Find welcome label by xpath
        WebElement welcomeElement = myBrowser.findElement(By.xpath("//*[@id=\"fadein\"]/section[1]/div/div[1]/div/div[1]/div[1]/div/div/h2")); 
        // Get content
        String welcomeContent = welcomeElement.getText();
        
        assertEquals("Hi, HQT Welcome Back", welcomeContent);
    }
    
}
