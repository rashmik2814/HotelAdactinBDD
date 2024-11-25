package hooks;

import base.BaseTest;
import context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Hooks {

    private BaseTest baseTest;

    public Hooks(TestContext testContext) {
        baseTest = new BaseTest(testContext);
    }

    @Before
    public void beforeScenario() {
        System.out.println("Executing before scenario hook...");
        baseTest.setup(); // Initialize WebDriver before each scenario
    }

    @After
    public void afterScenario(Scenario scenario) {
        System.out.println("Executing after scenario hook...");
        try {
            if (scenario.isFailed()) {
                captureScreenshot(scenario); // Capture screenshot if scenario failed
            }
        } catch (Exception e) {
            System.out.println("Error during screenshot capture: " + e.getMessage());
        } finally {
            baseTest.tearDown(); // Quit WebDriver after each scenario
        }
    }

    private void captureScreenshot(Scenario scenario) {
        WebDriver driver = baseTest.getDriver();
        if (driver instanceof TakesScreenshot) {
            TakesScreenshot screenshotTaker = (TakesScreenshot) driver;
            File screenshot = screenshotTaker.getScreenshotAs(OutputType.FILE);

            Path screenshotsPath = Paths.get("target", "screenshots");
            File screenshotsFolder = screenshotsPath.toFile();

            if (!screenshotsFolder.exists()) {
                boolean created = screenshotsFolder.mkdirs();
                if (created) {
                    System.out.println("Screenshots folder created: " + screenshotsFolder.getAbsolutePath());
                }
            }

            String screenshotName = scenario.getName().replaceAll(" ", "_") + ".png";
            File destinationFile = new File(screenshotsFolder, screenshotName);

            try {
                FileUtils.copyFile(screenshot, destinationFile);
                scenario.attach(FileUtils.readFileToByteArray(destinationFile), "image/png", screenshotName);
                System.out.println("Screenshot saved at: " + destinationFile.getAbsolutePath());
            } catch (IOException e) {
                System.out.println("Failed to capture screenshot: " + e.getMessage());
            }
        } else {
            System.out.println("Driver does not support screenshot capture.");
        }
    }
}
