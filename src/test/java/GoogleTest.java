import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class GoogleTest {

    public static WebDriver driver;

    @Test
    public void searchTest() throws InterruptedException {
        driver.navigate().to("https://www.google.com/");
        WebElement searchBar = driver.findElement(By.name("q"));
        searchBar.sendKeys("AutoTestFramework");
        searchBar.submit();
        WebElement clearBtn = driver.findElement(By.cssSelector("div.BKRPef"));
        clearBtn.click();
        WebElement searchBarAfterSearch = driver.findElement(By.cssSelector("input[aria-label='Найти']"));
        Assert.assertEquals(searchBarAfterSearch.getText(),"");

    }

    @BeforeMethod
    public void SetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void TearDown() {
        driver.quit();
    }
}
