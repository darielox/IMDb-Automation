import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        // Make sure to point to the correct location of the Edge WebDriver
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("C:\\Users\\12394\\AppData\\Roaming\\JetBrains\\IntelliJIdea2024.1\\extensions\\Adblock.crx"));
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Wait a brief moment for any additional tabs to open
        try {
            Thread.sleep(2500); // wait for 3 seconds to allow any additional tabs to fully open
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Close any additional tabs
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        String originalWindow = windowHandles.get(0); // Assuming the first window is the main window

        for (int i = 1; i < windowHandles.size(); i++) { // Start from 1 assuming index 0 is your main tab
            driver.switchTo().window(windowHandles.get(i));
            driver.close();
        }

        // Switch back to the original window
        driver.switchTo().window(originalWindow);

    }

    @AfterMethod
        public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }
    }
