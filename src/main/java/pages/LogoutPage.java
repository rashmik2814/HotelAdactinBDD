package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;

public class LogoutPage extends BasePage {
	public LogoutPage(WebDriver driver) throws IOException {
		super(driver);
	}
	public By logoutLastScreen = By.className("reg_success");

}