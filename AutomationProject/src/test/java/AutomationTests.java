import org.testng.annotations.*;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.util.Scanner;
import java.util.List;
import javax.swing.JOptionPane;

public class AutomationTests {
    private WebDriver driver;
    private Scanner scanner = new Scanner(System.in);

    @BeforeSuite
    public void setUpSuite() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\12394\\Desktop\\Chromedriver\\chromedriver.exe");
        scanner = new Scanner(System.in);
    }

    @BeforeTest
    public void setUpTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDownTest() {
        driver.quit();
        scanner.close();
    }

    // Test method to check if a number is a palindrome. A palindrome is a number that reads the same backward as forward.
    @Test (priority = 1)
    public void testPalindrome() {
        String input = JOptionPane.showInputDialog("Enter a number to check if it is a palindrome:");
        int number = Integer.parseInt(input);
        // Asserts if the original number is equal to its reversed version.
        assert number == reverseNumber(number) : "Test failed: The number is not a palindrome.";
        JOptionPane.showMessageDialog(null, number + " is a palindrome.");
    }

    // Test method to calculate factorial. The factorial of a non-negative integer n is the product of all positive integers less than or equal to n.
    @Test (priority = 2)
    public void testFactorial() {
        String input = JOptionPane.showInputDialog("Enter a number to calculate its factorial:");
        int number = Integer.parseInt(input);
        // Calls factorial method and checks if the calculation is correct by comparing it to the method result again.
        int calculatedFactorial = factorial(number);
        assert calculatedFactorial == factorial(number) : "Test failed: Factorial calculation is incorrect.";
        JOptionPane.showMessageDialog(null, "The factorial of " + number + " is " + calculatedFactorial + ".");
    }

    // Test method to check if a number is prime. A prime number is a natural number greater than 1 that has no positive divisors other than 1 and itself.
    @Test (priority = 3)
    public void testPrime() {
        String input = JOptionPane.showInputDialog("Enter a number to check if it is prime:");
        int number = Integer.parseInt(input);
        // Asserts true if the number is prime, using the isPrime method.
        assert isPrime(number) : "Test failed: The number is not prime.";
        JOptionPane.showMessageDialog(null, number + " is a prime number.");
    }

    // Helper method to reverse a number. It iteratively extracts each digit and builds the reversed number.
    private int reverseNumber(int number) {
        int reverse = 0;
        while (number != 0) {
            int digit = number % 10; // Get the last digit of the number
            reverse = reverse * 10 + digit; // Append the digit to the reversed number
            number /= 10; // Remove the last digit from the original number
        }
        return reverse;
    }

    // Recursive method to calculate factorial. It multiplies the number by the factorial of the number minus one until it reaches 1.
    private int factorial(int n) {
        if (n == 0) return 1; // Base case: the factorial of 0 is 1
        else return n * factorial(n-1); // Recursive case: multiply n by the factorial of n-1
    }

    // Method to determine if a number is prime. It checks divisibility from 2 to the square root of the number.
    private boolean isPrime(int num) {
        if (num <= 1) return false; // 0 and 1 are not prime numbers
        for (int i = 2; i <= Math.sqrt(num); i++) { // Only check up to the square root of num
            if (num % i == 0) return false; // If num is divisible by any number other than 1 and itself, it is not prime
        }
        return true; // If no divisors were found, the number is prime
    }

    // Test method to check the page title against an expected value
    @Test(priority = 4)
    public void testPageTitle() {
        driver.get("https://discord.com/");
        String expectedTitle = "Discord";
        String actualTitle = driver.getTitle();
        Assert.assertNotEquals(actualTitle, expectedTitle, "The actual title matches the expected title.");
    }

    // Test method to verify the URL of the webpage
    @Test(priority = 5)
    public void testURL() {
        driver.get("https://discord.com/");
        String expectedURL = "https://discord.com/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, "The URL does not match the expected URL.");
    }

    // Test method to check if the number of <p> elements matches the expected size
    @Test(priority = 6)
    public void testElementSize() {
        driver.get("https://discord.com/");
        List<WebElement> elements = driver.findElements(By.tagName("p"));
        int expectedSize = 1;  // Assuming we expect 1 paragraph element
        Assert.assertEquals(elements.size(), expectedSize, "The size of the elements does not match the expected size.");
    }

    // Main method to run the TestNG tests from the command line
    public static void main(String[] args) {
        org.testng.TestNG.main(new String[]{AutomationTests.class.getName()});
    }
}