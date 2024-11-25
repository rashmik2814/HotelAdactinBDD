package base;

import org.openqa.selenium.WebDriver;

import context.TestContext;

public class BaseTest {
    private WebDriver driver;
    private TestContext testContext;

    public BaseTest(TestContext testContext) {
        this.testContext = testContext;
        this.driver = testContext.getDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setup() {
        // Initialize WebDriver, if not already done
        if (driver == null) {
            driver = testContext.initializeDriver();
        }
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Quit the WebDriver instance
            driver = null; // Nullify the reference to release resources
            System.out.println("WebDriver instance has been closed.");
        } else {
            System.out.println("No WebDriver instance to close.");
        }
    }
}
