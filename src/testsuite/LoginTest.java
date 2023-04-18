package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LoginTest extends BaseTest { //extends the base class for getting Properties

    String baseUrl = "https://www.saucedemo.com/"; //passing URL


    @Before
    public void setUp()
    {
        openBrowser(baseUrl); //opening the Url
    }

    @Test
    public void userShouldLoginSuccessfullyWithValid() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");// finding the username field and enter the username
        driver.findElement(By.id("password")).sendKeys("secret_sauce");// finding the password field and enter the password
        driver.findElement(By.id("login-button")).click();// finding the login button and click on login button
        String expectedMessage = "Products"; //expected message
        WebElement actualMessage = driver.findElement(By.xpath("//span[@class='title']")); //finding Actual message
        String actualMessage1 = actualMessage.getText(); //Storing the actual message in the string
        Assert.assertEquals("Error Message is not Displayed ", actualMessage1, expectedMessage); //compare actual and expected message
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
//        driver.findElement(By.id("user-name")).sendKeys("standard_user");
//        driver.findElement(By.id("password")).sendKeys("secret_sauce");
//        driver.findElement(By.id("login-button")).click();
//        //int actualNumber = driver.sixProducts();
//        int expectedNumber = 6;
//        WebElement actualMessage = driver.findElement(By.xpath("//span[@class='title']"));
//        String actualMessage1 = actualMessage.getText();
//        Assert.assertEquals("Error Message is not Displayed ", actualMessage1, expectedNumber);
        driver.findElement(By.id("user-name")).sendKeys("standard_user"); // finding the username field and enter the username
        driver.findElement(By.id("password")).sendKeys(("secret_sauce")); // finding the password field and enter the password
        driver.findElement(By.id("login-button")).click(); // finding the login button and click on login button

        WebElement product1 = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]")); // finding the product 1
        boolean product1Visible = product1.isDisplayed(); // verifying that the product1 is displayed on the screen

        WebElement product2 = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Bike Light')]"));//finding the product 2
        boolean product2Visible = product2.isDisplayed(); // verifying that the product2 is displayed on the screen

        WebElement product3 = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Bolt T-Shirt')]"));// finding the product 3
        boolean product3Visible = product3.isDisplayed(); // verifying that the product3 is displayed on the screen

        WebElement product4 = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Fleece Jacket')]"));// finding the product 4
        boolean product4Visible = product4.isDisplayed(); //verifying that the product4 is displayed on the screen

        WebElement product5 = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Onesie')]"));// finding the product 5
        boolean product5Visible = product5.isDisplayed(); //verifying that the product5 is displayed on the screen

        WebElement product6 = driver.findElement(By.xpath("//div[contains(text(),'Test.allTheThings() T-Shirt (Red)')]"));// finding the product 6
        boolean product6Visible = product6.isDisplayed(); //verifying that the product6 is displayed on the screen


    }

    @After
    public void tearDown() {
        //closing the browser
        closeBrowser();
    }
}
