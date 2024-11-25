package stepDefinitions;

import base.BaseTest;
import context.TestContext;
import io.cucumber.java.en.*;
import pages.BookHotelPage;
import pages.BookedItineraryPage;
import pages.BookingConfirmationPage;
import pages.LoginPage;
import pages.SearchHotelPage;
import pages.SelectHotelPage;
import utils.ConfigReader;
import java.io.IOException;

public class HotelBookingSteps {

    private LoginPage loginPage;
    private SearchHotelPage searchPage;
    private SelectHotelPage selectPage;
    private BookHotelPage bookPage;
    private BookingConfirmationPage confirmationPage;
    private BookedItineraryPage bookedPage;
    private BaseTest baseTest;

    // Constructor for HotelBookingSteps to initialize BaseTest with TestContext
    public HotelBookingSteps(TestContext testContext) {
        // Create an instance of BaseTest by passing TestContext to the constructor
        baseTest = new BaseTest(testContext);
    }

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() throws IOException {
        // Get the application URL from the config file
        String appUrl = ConfigReader.getProperty("app.url");
        // Navigate to login page
        baseTest.setup();
        baseTest.getDriver().get(appUrl);
        loginPage = new LoginPage(baseTest.getDriver()); // Initialize the LoginPage with the driver
    }

    @When("the user logs in with valid credentials")
    public void theUserLogsInWithValidCredentials() {
        // Get credentials from the config file
        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");
        loginPage.doLogin(username, password); // Use values from config
    }
    @When("the user searches for a hotel with specific details")
    public void theUserSearchesForAHotelWithSpecificDetails() throws IOException {
        searchPage = new SearchHotelPage(baseTest.getDriver()); // Initialize SearchHotelPage with the driver

        // Get hotel search parameters from the config file
        String location = ConfigReader.getProperty("location");
        String hotelName = ConfigReader.getProperty("hotelName");
        String roomType = ConfigReader.getProperty("roomType");
        String numberOfRooms = ConfigReader.getProperty("numberOfRooms");
        String checkInDate = ConfigReader.getProperty("checkInDate");
        String checkOutDate = ConfigReader.getProperty("checkOutDate");
        String adults = ConfigReader.getProperty("adults");
        String children = ConfigReader.getProperty("children");

        // Search hotel with parameters from the config file
        searchPage.searchHotel(location, hotelName, roomType, numberOfRooms, checkInDate, checkOutDate, adults, children);
    }

    @When("the user selects a hotel")
    public void theUserSelectsAHotel() throws IOException {
        selectPage = new SelectHotelPage(baseTest.getDriver()); // Initialize SelectHotelPage with the driver
        selectPage.selectHotel();
    }

    @When("the user enters booking details")
    public void theUserEntersBookingDetails() throws IOException {
        bookPage = new BookHotelPage(baseTest.getDriver()); // Initialize BookHotelPage with the driver

        // Get booking details from the config file
        String firstName = ConfigReader.getProperty("firstName");
        String lastName = ConfigReader.getProperty("lastName");
        String billingAddress = ConfigReader.getProperty("billingAddress");
        String creditCardNumber = ConfigReader.getProperty("creditCardNumber");
        String creditCardType = ConfigReader.getProperty("creditCardType");
        String expiryMonth = ConfigReader.getProperty("expiryMonth");
        String expiryYear = ConfigReader.getProperty("expiryYear");
        String cvv = ConfigReader.getProperty("cvv");

        // Book hotel with parameters from the config file
        bookPage.bookHotel(firstName, lastName, billingAddress, creditCardNumber, creditCardType, expiryMonth, expiryYear, cvv);
    }

    @Then("the user should see the booking confirmation")
    public void theUserShouldSeeTheBookingConfirmation() throws IOException {
        // Validate booking confirmation presence
        confirmationPage = new BookingConfirmationPage(baseTest.getDriver()); // Initialize BookHotelPage with the driver
       
    }

    @Then("the user logs out successfully")
    public void theUserLogsOutSuccessfully() throws IOException {
        bookedPage = new BookedItineraryPage(baseTest.getDriver()); // Initialize BookedItineraryPage with the driver
        baseTest.getDriver().findElement(bookedPage.logOutButton).click(); // Click the logout button
    }
}
