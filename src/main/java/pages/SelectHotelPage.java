package pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;

public class SelectHotelPage extends BasePage {

	// constructor
	public SelectHotelPage(WebDriver driver) throws IOException {
		super(driver);
	}

	// Web element for hotel search results
	public By hotelTable = By.cssSelector("td[class=\"login_title\"]");
	public By continueButton = By.cssSelector(".reg_button[value=\"Continue\"]");
	public By radioButton1 = By.id("radiobutton_0");
	public By hotelNameLocator = By.id("hotel_name_0");

	public void selectHotel() {
		driver.findElement(radioButton1).click();
		driver.findElement(continueButton).click();
	}
}
