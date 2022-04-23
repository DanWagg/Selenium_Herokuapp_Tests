package com.herokuapp.theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
//      enter password
//      click login button

//      verifications:
//      new url
//      logout button is visible
//      succesful login message
//      close browser
        driver.quit();
    }
}
