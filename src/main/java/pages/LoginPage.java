package pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;

public class LoginPage extends BasePage {

	// constructor
	public LoginPage(WebDriver driver) throws IOException {
		super(driver);
	}

	// Web elements
	public By usernameField = By.id("username");
	public By passwordField = By.id("password");
	public By loginButton = By.id("login");
	public By clickHereLink = By.cssSelector("div[class=\"auth_error\"] a");
	public By ForgetPasswordLink = By.cssSelector("div[class=\"login_forgot\"] a");
	public By NewUserRegistrationLink = By.cssSelector("td[class=\"login_register\"] a");
	public By ForgotPasswordLoginPage = By.className("reg_success");
	public By InvaliUrlPage = By.id("reload-button");

	// Methods
	public void doLogin(String username, String password) {
		driver.findElement(usernameField).sendKeys(username);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(loginButton).click();
	}
}
