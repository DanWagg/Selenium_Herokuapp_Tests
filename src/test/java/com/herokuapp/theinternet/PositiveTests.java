package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTests {

    @Test
    //All tests: cmd-> project directory-> mvn clean test
    //If I want to execute some test: cmd-> project directory-> mvn -Dtest=TypeSomeTestClass clean test
    public void loginTest() {
        System.out.println("Starting login test");

//      create a driver
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //      maximize browser window
        driver.manage().window().maximize();

//      open test page
        String urlLogIn = "http://the-internet.herokuapp.com/login";
        driver.get(urlLogIn);
        System.out.println("Page is opened");

//      enter username
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");

//      enter password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword!");

//      click login button
        WebElement logInButton = driver.findElement(By.tagName("button"));
        logInButton.click();

//      verifications:

//      new url
        String expectedUrl = "http://the-internet.herokuapp.com/secure";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl,"actual url is not the same as expected");

//      logout button is visible
        WebElement logOutButton = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
        Assert.assertTrue(logOutButton.isDisplayed(),"Log out button is not visible");

        logOutButton.click();
        System.out.println("Log out");


//      succesful login message - green popup
        WebElement successMessage = driver.findElement(By.cssSelector("div#flash"));
        String expectedMessage =  "You logged out of the secure area!";
        String actualMessage = successMessage.getText();
        //assertEquals or assertTrue
        //Assert.assertEquals(expectedMessage,actualMessage,"actual message is not the same as expected");

//      close browser
        driver.quit();
        System.out.println("Page is closed");
    }
}
