import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.junit.Test;

public class TheInternetLoginPage extends Base {

	private static final String LOGIN_URL = "http://the-internet.herokuapp.com/login";
	private static final By CONFIRMATION_TEXT = By.cssSelector(".success");

	@FindBy(className = "class 1")
	private WebElement searchBox;

	@FindBy(how = How.CLASS_NAME, using = "invalid class name")
	private WebElement searchSubmitButton;

	@FindBy(id = "cancel")
	private WebElement cancelButton;

	@FindBy(xpath = "//*[@id=\"element_id\"]")
	private WebElement cancelText;

	public TheInternetLoginPage(RemoteWebDriver driver) {
		super(driver);
	}

	public void openLoginScreen() throws InterruptedException {
		visit(LOGIN_URL);
	}

	public void dropdown() {
		dropdown.selectByVisibleText("CINGULAR WIRELESS (4410139)"); // Noncompliant {{Avoid hard coding for dropdown, either read data from cucumber or data.xml}}
	}

	public void dropdown1() {
		dropdown.selectByValue("typeMe"); // Noncompliant {{Avoid hard coding for dropdown, either read data from cucumber or data.xml}}
	}

	public void dropdown3() {
		dropdown.selectByIndex(1); // Noncompliant {{Avoid hard coding for dropdown, either read data from cucumber or data.xml}}
	}

	public String getConfirmationText() {
		return getText(CONFIRMATION_TEXT);
	}
}
