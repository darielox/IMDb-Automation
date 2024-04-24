import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignInTest extends BaseTest {

    @Test
    public void testSignIn() {
        // Navigate to IMDb's home page
        driver.get("https://www.imdb.com");

        // Click on the "Sign In" link
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();

        // Wait for the sign-in page to load and click on "Sign in with IMDb"
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Sign in with IMDb')]"))).click();

        // Wait for the sign-in form to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email")));

        // Enter email
        WebElement emailInput = driver.findElement(By.id("ap_email"));
        emailInput.sendKeys("your_email@example.com"); // Use environment variable or secure storage

        // Enter password
        WebElement passwordInput = driver.findElement(By.id("ap_password"));
        passwordInput.sendKeys("your_password"); // Use environment variable or secure storage

        // Click on the sign-in button
        WebElement signInButton = driver.findElement(By.id("signInSubmit"));
        signInButton.click();

        // Verify sign-in by checking for a sign-out link or user-specific element
        // This will depend on how IMDb's UI identifies a signed-in state
        // Here's a hypothetical example that checks for a user profile element
        boolean isSignedIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("navUserMenu"))).isDisplayed();

        Assert.assertTrue(isSignedIn, "Sign in was not successful.");
    }
}
