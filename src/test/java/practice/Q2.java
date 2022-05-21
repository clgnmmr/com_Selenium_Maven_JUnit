package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class Q2 {
    /*
    ...Exercise2...
    http://www.bestbuy.com 'a gidin,
    Sayfa basliginin "Best" icerdigini(contains) dogrulayin
    Ayrica Relative Locator kullanarak;
        logoTest => BestBuy logosunun gorunutulenip goruntulenmedigini dogrulayin
        mexicoLinkTest => Linkin gorunutulenip goruntulenmedigini dogrulayin
 */

     WebDriver driver;

    @Before
    public void setUp() {
     WebDriverManager.chromedriver().setup();
     driver =new ChromeDriver();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void test01()  {
        // http://www.bestbuy.com 'a gidin,
        driver.get("http://www.bestbuy.com");
        //    Sayfa basliginin "Best" icerdigini(contains) dogrulayin
        String expectedTitle = "Best";
         String actualTitle=driver.getTitle();
         Assert.assertTrue(actualTitle.contains(expectedTitle));
        //    Ayrica Relative Locator kullanarak;
        //        logoTest => BestBuy logosunun gorunutulenip goruntulenmedigini dogrulayin
        WebElement logoElementi=driver.findElement(By.xpath("//img[@class='logo']"));
        Assert.assertTrue(logoElementi.isDisplayed());

        //        mexicoLinkTest => Linkin gorunutulenip goruntulenmedigini dogrulayin
        WebElement mexicoElementi=driver.findElement(By.xpath("(//img[@alt='Mexico'])[1]"));
        Assert.assertTrue(mexicoElementi.isDisplayed());

    }

    @After
    public void tearDown() {
        driver.close();
    }

}
