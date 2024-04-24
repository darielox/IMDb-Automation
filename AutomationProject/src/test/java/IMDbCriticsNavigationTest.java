import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class IMDbCriticsNavigationTest extends BaseTest {

    @Test
    public void testCriticsNavigation() throws InterruptedException {
        // Step 1: Navigate to the movie page
        driver.get("https://www.imdb.com/title/tt0071562/");

        WebElement metascoreLink = driver.findElement(By.cssSelector("a[href*='/criticreviews']")); // Example selector
        metascoreLink.click();
        Thread.sleep(2000); // Pause to observe

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 800);");
        Thread.sleep(1000);
        driver.findElement(By.linkText("See all 18 reviews on Metacritic.com")).click();
        Thread.sleep(1000);
        driver.get("https://www.imdb.com/title/tt0071562/");
        Thread.sleep(1000);

        WebElement userReviewsLink = driver.findElement(By.cssSelector("a[href*='/title/tt0071562/reviews/?ref_=tt_ov_rt']"));
        userReviewsLink.click();
        // Optionally, add a pause to observe the navigation
        Thread.sleep(2000);

        WebElement hideSpoilersCheckbox = driver.findElement(By.cssSelector("input[type='checkbox'][name='spoiler']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", hideSpoilersCheckbox);
        Thread.sleep(2000);

        // Wait for the dropdown to be visible
        WebElement ratingDropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("ratingFilter")));

        // Interact with the dropdown to select "10 Stars"
        Select ratingDropdown = new Select(ratingDropdownElement);
        ratingDropdown.selectByValue("10"); // Assuming "10" is the value for 10 Stars
        Thread.sleep(2000);
        // Wait for the page to reload or for a specific element indicating the completion of the form submission due to the checkbox's onchange event'

        // Wait for the "Sort by" dropdown to be visible
        WebElement sortByDropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("lister-sort-by")));

        // Interact with the dropdown to select "Review Rating" option
        // The actual value or visible text used to select "Review Rating" needs to be adjusted based on the dropdown options
        Select sortByDropdown = new Select(sortByDropdownElement);
        sortByDropdown.selectByVisibleText("Review Rating"); // Use the actual text that appears for the option, adjust as needed
        Thread.sleep(2000);

        driver.get("https://www.imdb.com/title/tt0071562/");
        Thread.sleep(2000);

        WebElement criticsReviewsLink = driver.findElement(By.cssSelector("a[href*='/title/tt0071562/externalreviews/?ref_=tt_ov_rt']"));
        criticsReviewsLink.click();
        // Optionally, add a pause to observe the navigation
        Thread.sleep(2000);

        // Click the link using its visible text
        driver.findElement(By.linkText("rogerebert.com [Roger Ebert]")).click();

        // Optionally, add a pause to observe the navigation
        Thread.sleep(2000);
    }
}
