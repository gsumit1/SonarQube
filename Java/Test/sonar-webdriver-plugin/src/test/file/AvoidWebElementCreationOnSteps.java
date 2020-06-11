import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class myTestSteps  {

	
	WebDriver driver=new FirefoxDriver();


	public void dropdown() {
		driver.findElement(By.xpath("//div[1]")); // Noncompliant {{Avoid xpath creation in step class, either use webElement from page class or create in page class}}
	}
	
    @Test
    public void login(String username, String password) {
        type(USERNAME, username);
        type(PASSWORD, password);
        click(SUBMIT);
        assertThat(driver.findElement(CONFIRMATION_TEXT).getText(), is("Text"));
    }
}
