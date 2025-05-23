import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RegisterTest extends BaseTest {


    @Test
    public void zipCode4DigitsCheck() {

        browser.get("https://sharelane.com/cgi-bin/register.py");
        browser.findElement(By.xpath("//*[@name='zip_code']")).sendKeys("1234");
        browser.findElement(By.xpath("//input[@value='Continue']")).click();
        assertEquals(browser.findElement(By.cssSelector(".error_message")).getText(),
                "Oops, error on page. ZIP code should have 5 digits");
    }
}
