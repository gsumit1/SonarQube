import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.junit.Test;

public class ABC{
	private static final String WEB_HUB_URL = "http://localhost:4444/wd/hub";

    private static final By USERNAME = By.name("#username");

    private RemoteWebDriver driver;

    private DesiredCapabilities capabilities = new DesiredCapabilities();

    private Example example = new Example();
   
    @Test
    public void test() {    	
        capabilities.setBrowserName("chrome");
        driver = new RemoteWebDriver(new URL(WEB_HUB_URL), capabilities);
        waitABit(1000); // Noncompliant {{Avoid using hard coded waitABit, use explicit wait instead}}
        capabilities.example();
        
        waitABit(5000); // Noncompliant {{Avoid using hard coded waitABit, use explicit wait instead}}
        
        
        
    }
}
