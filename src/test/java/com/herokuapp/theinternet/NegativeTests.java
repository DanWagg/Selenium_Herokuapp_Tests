package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTests {

    @Test
    public void  incorrectUserNameTest(){
        System.out.println("Starting incorrect Username test");

//      create a driver
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //maximize browser window
        driver.manage().window().maximize();

//      open test page
        String urlLogIn = "http://the-internet.herokuapp.com/login";
        driver.get(urlLogIn);
        System.out.println("Page is opened");

//      enter username
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("incorrectUsername");

//      enter password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword!");

//      click login button
        WebElement logInButton = driver.findElement(By.tagName("button"));
        logInButton.click();

        //verifications

        WebElement errorMessage = driver.findElement(By.id("flash"));
        String expectedErrorMessage = "Your username is invalid!\n" + "×";
        String actualErrorMessage = errorMessage.getText();

        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage), "Actual error message does not contain expected message." +
                "\nActual: " + actualErrorMessage + "\nExpected: " + expectedErrorMessage);


//      close browser
        driver.quit();
    }
}
