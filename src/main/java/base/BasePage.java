package base;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

	protected WebDriver driver;

	// constructor
	public BasePage(WebDriver driver) throws IOException {
		this.driver = driver;
	}
//Method for selecting date
	public void setDate(WebDriver driver, String fieldId, String date) {
		WebElement dateField = driver.findElement(By.id(fieldId));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = arguments[1];", dateField, date);
	}
}
