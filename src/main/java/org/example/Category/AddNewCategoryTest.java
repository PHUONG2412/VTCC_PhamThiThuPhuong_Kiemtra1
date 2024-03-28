package org.example.Category;

import org.example.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddNewCategoryTest extends BaseTest {

    @Test(priority = 10)
    public void test() throws InterruptedException {
        long sleep = 1000;

//        WebElement element = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        //Dien thong tin email
        driver.findElement(By.id("email")).sendKeys("admin@example.com");
        Thread.sleep(sleep);

        //Dien thong tin password
        driver.findElement(By.id("password")).sendKeys("123456");
        Thread.sleep(sleep);

        //Click vao login
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div/form/button")).click();
        Thread.sleep(sleep);


        //Add new category
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div/button")).click();
        Thread.sleep(sleep);
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/li[2]/a/span[1]")).click();
        Thread.sleep(sleep);

        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/li[2]/ul/li[8]/a/span")).click();

        Thread.sleep(sleep);

        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[1]/div/div[2]/a")).click();

        Thread.sleep(sleep);
        //Dien thong tin cua new category
        String name = "Automotive";
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys(name);

        Thread.sleep(sleep);

        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div/div/div/div[2]/form/div[2]/div/div/button/div/div/div")).click();

        Thread.sleep(sleep);

        driver.findElement(By.xpath("//*[@id=\"bs-select-1-0\"]")).click();

        Thread.sleep(sleep);

        driver.findElement(By.xpath("//*[@id=\"order_level\"]")).sendKeys("10");
        Thread.sleep(sleep);

        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div/div/div/div[2]/form/div[4]/div/div/button")).click();

        Thread.sleep(sleep);

        driver.findElement(By.xpath("//*[@id=\"bs-select-2-0\"]")).click();

        Thread.sleep(sleep);

        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div/div/div/div[2]/form/div[5]/div/div[1]/div[2]")).click();
        Thread.sleep(sleep);

        WebElement bannerSearchField = driver.findElement(By.xpath("//*[@id=\"aiz-select-file\"]/div[1]/div/div[3]/div/input"));
        Thread.sleep(500);
        new Actions(driver).sendKeys(bannerSearchField, "Car ").perform();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"aiz-select-file\"]/div[2]/div[1]/div/div/div[1]/img")).click();
        Thread.sleep(sleep);
        driver.findElement(By.xpath("//*[@id=\"aizUploaderModal\"]/div/div/div[3]/button")).click();

        Thread.sleep(5000);

        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div/div/div/div[2]/form/div[10]/button")).click();
        Thread.sleep(5000);
        //Check avalible of Category
        WebElement searchCategory = driver.findElement(By.xpath("//*[@id=\"search\"]"));
        new Actions(driver).sendKeys(searchCategory, name).sendKeys(Keys.ENTER).perform();
        Thread.sleep(5000);
        String[] searchResults = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/table"))
                .getText().split("\n");
        String searchResult = searchResults[1];
        Assert.assertEquals(searchResult, name);


    }
}
