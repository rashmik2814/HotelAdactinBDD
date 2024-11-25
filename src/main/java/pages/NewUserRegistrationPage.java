package pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;

public class NewUserRegistrationPage extends BasePage {

//constructor
	public NewUserRegistrationPage(WebDriver driver) throws IOException {
		super(driver);
	}

	// Web elements
	public By usernameField = By.id("username");
	public By passwordField = By.id("password");
	public By rePasswordField = By.id("re_password");
	public By fullName = By.cssSelector("input[id=full_name]");
	public By emailAddress = By.cssSelector("input[id=email_add]");
	public By tncCheckBox = By.id("tnc_box");
	public By registerButton = By.id("Submit");
	public By resetButton = By.id("Reset");
	public By backToLoginPage = By.cssSelector("td[align=right]a");

	// Method
	public void nurForm(String username, String password, String repassword, String fullname, String emailaddress) {
		driver.findElement(usernameField).sendKeys(username);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(rePasswordField).sendKeys(repassword);
		driver.findElement(fullName).sendKeys(fullname);
		driver.findElement(emailAddress).sendKeys(emailaddress);
		driver.findElement(tncCheckBox).click();
		driver.findElement(registerButton).click();
	}
}
