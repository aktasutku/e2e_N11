import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class n11_UrunEkleme {
    private WebDriver driver;

    @BeforeEach//only runs once before test runs
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Disabled
//    @Test
    public void testN11Scenario() throws InterruptedException {
        driver.get("https://www.n11.com");

        //Confirms page is correct
        String expectedPageTitle = "n11 - 10 Üzerinden 11'lik Alışveriş Deneyimi";
        String actualPageTitle = driver.getTitle();

        assertEquals(expectedPageTitle, actualPageTitle);


        //Search an item
        WebElement searchInput = driver.findElement(By.id("searchData"));
        searchInput.sendKeys("Samsung S23 Ultra", Keys.ENTER);

        //Check how many serch results
        String searchResultsText = driver.findElement(By.className("resultText")).getText();
        String expectedResultText = "Samsung S23 Ultra için 3,205 sonuç bulundu.";

        assertEquals(expectedResultText, searchResultsText);

        //Navigate to the previous page
        Thread.sleep(500);
        driver.navigate().back();

        //Navigate to the next page
        Thread.sleep(500);
        driver.navigate().forward();
    }


    //Close Browser After run the tests
    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
