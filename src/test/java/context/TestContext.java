package context;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
//import io.cucumber.messages.types.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestContext {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriver initializeDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            System.out.println("WebDriver initialized.");
        }
        return driver;
    }

    public void cleanup() {
        if (driver != null) {
            driver.quit();
            driver = null;
            System.out.println("WebDriver instance cleaned up.");
        }
    }
}
