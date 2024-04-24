import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeAndSearchBoxTest extends BaseTest {

    @Test
    public void testHomeAndSearchBox() {
        driver.get("https://www.imdb.com");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("IMDb"), "Home page didn't load successfully.");

        WebElement searchBox = driver.findElement(By.id("suggestion-search"));
        Assert.assertTrue(searchBox.isDisplayed(), "Search box is not visible.");
    }
}
