package pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;

public class BookHotelPage extends BasePage {

	// constructor
	public BookHotelPage(WebDriver driver) throws IOException {
		super(driver);
	}

	// Web element for hotel search results
	public By firstName = By.id("first_name");
	public By lastName = By.id("last_name");
	public By billingAddress = By.id("address");
	public By ccNo = By.id("cc_num");
	public By ccTypeDropdown = By.id("cc_type");
	public By eDDropDown = By.id("cc_exp_month");
	public By eYDropDown = By.id("cc_exp_year");
	public By cvvNumber = By.id("cc_cvv");
	public By bookNowButton = By.id("book_now");

	public void bookHotel(String strfirstName, String strlastName, String strbillingAddress, String cCNumber,
			String cCType, String expiryDateMonth, String expiryDateYear, String strcVVNumber) {
		driver.findElement(firstName).sendKeys(strfirstName);
		driver.findElement(lastName).sendKeys(strlastName);
		driver.findElement(billingAddress).sendKeys(strbillingAddress);
		driver.findElement(ccNo).sendKeys(cCNumber);
		new Select(driver.findElement(ccTypeDropdown)).selectByVisibleText(cCType);
		new Select(driver.findElement(eDDropDown)).selectByVisibleText(expiryDateMonth);
		new Select(driver.findElement(eYDropDown)).selectByVisibleText(expiryDateYear);
		driver.findElement(cvvNumber).sendKeys(strcVVNumber);
		driver.findElement(bookNowButton).click();
	}
}
