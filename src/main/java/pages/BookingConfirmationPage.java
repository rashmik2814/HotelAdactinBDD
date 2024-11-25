package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

	public class BookingConfirmationPage extends BasePage {

	public BookingConfirmationPage(WebDriver driver) throws IOException {
		super(driver);
	}

	public By pageTitle = By.className ("login_title");
	public By myItinerary = By.id ("my_itinerary");
	public By searchHotelButton = By.id ("search_hotel");
	public By orderNo = By.id("order_no");
	public By logoutButton = By.id ("logout");

}
