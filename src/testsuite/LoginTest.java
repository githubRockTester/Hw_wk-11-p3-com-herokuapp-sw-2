package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";      //URL of the website

    @Before
    public void setUp() {
        //calling Method to open the browser with URL
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldLoginSuccessfullyWithValidCredentials() {
        driver.findElement(By.name("username")).sendKeys("tomsmith");    //Find the login link and enter user ID
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");   //Find the password link and enter password
        driver.findElement(By.xpath("//i[text()=' Login']")).click(); //Find the X-path & Click on login button
        String expectedMessage = "Secure Area";                                      //Expected message
        WebElement actualTextElement = driver.findElement(By.xpath("//h2[contains(text(),' Secure Area')]")); //find x-path for the dashboard
        String actualMessage = actualTextElement.getText();                         //matching actual with the expected
        Assert.assertEquals("Not redirected to login page", expectedMessage, actualMessage); //
    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        //Verifying the user incorrect username
        driver.findElement(By.name("username")).sendKeys("tomsmith1");    //Find the login link and enter user ID
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");   //Find the password link and enter password
        driver.findElement(By.xpath("//i[text()=' Login']")).click(); //Find the X-path & Click on login button
    }

    @Test
    public void verifyThePasswordErrorMessage() {
        //Verifying the user incorrect password
        driver.findElement(By.name("username")).sendKeys("tomsmith");    //Find the login link and enter user ID
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");   //Find the password link and enter password
        driver.findElement(By.xpath("//i[text()=' Login']")).click(); //Find the X-path & Click on login button
    }

    @After
    public void tearDown() {
        // closeBrowser();
    }
}