package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;

public class BookedItineraryPage extends BasePage {
	public BookedItineraryPage(WebDriver driver) throws IOException {
		super(driver);
	}

	public By checkAllRadioButton = By.id("check_all");
	public By cancleSelectedButton = By.className("reg_button");
	public By searchOrderId = By.id("order_id_text");
	public By logOutButton = By.id("logout");
	public By goButton = By.id("search_hotel_id");
	public By firstBIRButton = By.cssSelector("td [value=\"1278441\"]");
	public By firstOrderId = By.id("order_id_1278441");
	
	
	public void checkBookedItinerary( String orderNumber) {
		driver.findElement(searchOrderId).sendKeys(orderNumber);;
		driver.findElement(goButton).click();
	}

}
