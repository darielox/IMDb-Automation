import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class NavigateMoreLikeThisSectionTest extends BaseTest {

    @Test
    public void clickMoreLikeThis() throws InterruptedException {
        // Navigate to the IMDb page for "The Godfather Part II"
        driver.get("https://www.imdb.com/title/tt0071562/");

        //Scroll to More Like This section
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 3300);");
        Thread.sleep(1000);

        // Selector for the right arrow within the "More like this" section
        By rightArrowSelector = By.xpath("//section[@data-testid='MoreLikeThis']//div[contains(@class, 'ipc-shoveler__arrow--right')]");
        // Wait until the arrow is visible and clickable
        WebElement rightArrow = wait.until(ExpectedConditions.elementToBeClickable(rightArrowSelector));
        rightArrow.click();
        Thread.sleep(1000);
        rightArrow.click();
        Thread.sleep(1000);

        // Selector for the left arrow within the "More like this" section
        By leftArrowSelector = By.xpath("//section[@data-testid='MoreLikeThis']//div[contains(@class, 'ipc-shoveler__arrow--left')]");
        WebElement leftArrow = wait.until(ExpectedConditions.elementToBeClickable(leftArrowSelector));
        leftArrow.click();
        Thread.sleep(1000);
        leftArrow.click();
        Thread.sleep(1000);

        // Method to click the "Watch options" button
        By watchOptionsSelector = By.xpath("//button[contains(@class, 'ipc-btn--on-accent2') and .//span[text()='Watch options']]");
        WebElement watchOptionsButton = wait.until(ExpectedConditions.elementToBeClickable(watchOptionsSelector));
        watchOptionsButton.click();
        Thread.sleep(2000);
    }
}
