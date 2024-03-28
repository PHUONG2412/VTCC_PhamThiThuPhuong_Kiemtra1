package org.example;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public WebDriver driver = new ChromeDriver();

    @BeforeMethod
    public void beforeMethod() {
        //Vao trinh duyet
        driver.get("https://cms.anhtester.com/login");
//        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
        System.out.println("After Method");
    }
}
