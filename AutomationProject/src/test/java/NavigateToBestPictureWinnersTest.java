import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class NavigateToBestPictureWinnersTest extends BaseTest {

    @Test
    public void clickBestPictureWinnersByYearLink() throws InterruptedException {
        // Navigate to the IMDb page for "The Godfather Part II"
        driver.get("https://www.imdb.com/title/tt0071562/");

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 3000);");
        Thread.sleep(2000);

        // Locate the link by its text and click it
        WebElement bestPictureWinnersLink = driver.findElement(By.linkText("See the complete list"));
        bestPictureWinnersLink.click();
        Thread.sleep(2000);
        // Verify navigation or perform additional actions on the destination page

        // Wait for the "Sort by" dropdown to be visible
        WebElement sortByDropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("lister-sort-by")));

        // Interact with the dropdown to select "Review Rating" option
        // The actual value or visible text used to select "Review Rating" needs to be adjusted based on the dropdown options
        Select sortByDropdown = new Select(sortByDropdownElement);
        sortByDropdown.selectByVisibleText("IMDb Rating"); // Use the actual text that appears for the option, adjust as needed
        Thread.sleep(2000);

        WebElement gridViewButton = driver.findElement(By.cssSelector("span[title='Grid view']"));
        gridViewButton.click();
        Thread.sleep(2000);
    }
}
