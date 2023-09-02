import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

public class stepdef {

    private WebDriver driver;
    private int penDriveQty;

    @Given("User searches for HP Pen Drive")
    public void userSearchesForHPPenDrive() {
        // Initialize the WebDriver (you should add logic for configuring the browser dynamically)
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://example.com"); // Replace with your actual website URL
    }

    @When("Add the first result on the page with quantity {int}")
    public void addTheFirstResultOnThePageWithQuantity(Integer qty) {
        WebElement searchResults = driver.findElement(By.id("search-results")); // Replace with the actual element
        // Find the first result and click it
        WebElement firstResult = searchResults.findElement(By.cssSelector(".result-item:first-child"));
        firstResult.click();

        // Set the quantity for the order
        penDriveQty = qty;
    }

    @Then("Cart should display {int} pen drive")
    public void cartShouldDisplayPenDrive(Integer expectedQty) {
        // Assume you have a mechanism to interact with the cart and check the quantity
        // Replace the following code with your actual cart verification logic
        WebElement cart = driver.findElement(By.id("cart")); // Replace with the actual cart element
        WebElement cartQty = cart.findElement(By.cssSelector(".cart-quantity"));
        int actualQty = Integer.parseInt(cartQty.getText());

        Assert.assertEquals(expectedQty, actualQty);

        // Close the browser after the test
        driver.quit();
    }
}
