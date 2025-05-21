import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FirstTest extends BaseTest {

@Test
    public void zipCode4DigitsCheck() {
    browser.get("https://sharelane.com/cgi-bin/register.py");
    browser.findElement(By.xpath("//*[@name='zip_code']")).sendKeys("1234");
    browser.findElement(By.xpath("//input[@value='Continue']")).click();
    assertEquals(browser.findElement(By.cssSelector(".error_message")).getText(),
            "Oops, error on page. ZIP code should have 5 digits");
}

@Test
    public void zipCode5DigitsCheck() {
    browser.get("https://sharelane.com/cgi-bin/register.py");
    browser.findElement(By.xpath("//*[@name='zip_code']")).sendKeys("12345");
    browser.findElement(By.xpath("//input[@value='Continue']")).click();
    boolean regBtnIsPresent = browser.findElement(By.xpath("//*[@value='Register']")).isDisplayed();
   assertTrue(regBtnIsPresent);
}
}
