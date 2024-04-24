import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class AdvanceSearch extends BaseTest {

    @Test
    public void filterByTitleType() throws InterruptedException {
        // Navigate to the IMDb Advanced Title Search page
        driver.get("https://www.imdb.com/search/title/");

        // Step 1: Click the accordion to expand the "Title Type" section
        WebElement titleTypeAccordion = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@data-testid='accordion-item-titleTypeAccordion']")));
        titleTypeAccordion.click();

        // Wait for the "Movie" button to become clickable after expanding the section
        WebElement movieButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='test-chip-id-movie']")));

        // Click the "Movie" button to filter by movies
        movieButton.click();
        Thread.sleep(1000);

        // Replace 'accordion-item-releaseDateAccordion' with the actual data-testid or identifier for the Release Date accordion
        WebElement releaseDateAccordion = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@data-testid='accordion-item-releaseDateAccordion']")));
        releaseDateAccordion.click();
        Thread.sleep(1000);

        // Locate the "Release Date" text box by its 'data-testid' and clear any existing value
        WebElement releaseDateTextbox1 = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-testid='releaseYearMonth-start']")));
        releaseDateTextbox1.clear(); // Clear the text box before entering a new value

        // Enter "1972" into the first text box
        releaseDateTextbox1.sendKeys("1972");
        Thread.sleep(1000);

        // Locate the "Release Date" text box by its 'data-testid' and clear any existing value
        WebElement releaseDateTextbox2 = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-testid='releaseYearMonth-end']")));
        releaseDateTextbox2.clear(); // Clear the text box before entering a new value

        // Enter "1972" into the second text box
        releaseDateTextbox2.sendKeys("1974");
        Thread.sleep(1000);

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
        Thread.sleep(1000);
        //
        WebElement genreAccordion = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@data-testid='accordion-item-genreAccordion']")));
        genreAccordion.click();
        Thread.sleep(1000);

        // Wait for the "Crime" button to become clickable after expanding the section
        WebElement crimeButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='test-chip-id-Crime']")));

        // Click the "Crime" button to filter by crime genre
        crimeButton.click();
        Thread.sleep(1000);

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 200);");
        Thread.sleep(1000);

        WebElement awardsAccordion = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@data-testid='accordion-item-awardsAccordion']")));
        awardsAccordion.click();
        Thread.sleep(1000);

        // Wait for the "Crime" button to become clickable after expanding the section
        WebElement oscarButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='test-chip-id-oscar-winning']")));

        // Click the "Oscar-Winning" button to filter by oscar award winners
        oscarButton.click();
        Thread.sleep(1000);

        WebElement seeResultsButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.//span[contains(text(), 'See results')]]")));
        seeResultsButton.click();
        Thread.sleep(3000);
    }
}