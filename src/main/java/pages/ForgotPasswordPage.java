package pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;

public class ForgotPasswordPage extends BasePage {
	// constructor
	public ForgotPasswordPage(WebDriver driver) throws IOException {
		super(driver);
	}
	//Web Elements
	public By enterEmail = By.cssSelector(".reg_input#emailadd_recovery");
	public By emailPassword = By.cssSelector("#Submit.reg_button");
	public By resetButton = By.id("Reset");
	public By backToLoginPage = By.cssSelector("td[align=\"right\"] a");
	public By errorText = By.id("emailadd_span");
	
	//Methods

	public void fillForgotPasswordForm (String emailid) {
		driver.findElement(enterEmail).sendKeys(emailid);
		driver.findElement(emailPassword).click();
	}
}