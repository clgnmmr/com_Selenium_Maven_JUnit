package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {
    /*
    1-amazon anasayfaya gidin https://www.amazon.com
    2- 3 farklı test methodu oluşturarak asagıdaki görevleri yapın
    3- url 'in  "amazon" icerdiğini test edin
    4- title'in "facebook" icermedigini test edin
    5- sol ust kosedeki amazon logosunun göründüğünü test edin
     */
    static WebDriver driver;

      @BeforeClass
    public static void setup(){

          WebDriverManager.chromedriver().setup();
          driver=new ChromeDriver();
          driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(Duration.ofDays(15));
          //amazon anasayfaya gidin https://www.amazon.com
          driver.navigate().to("https://www.amazon.com");

    }
    @AfterClass
    public static  void tearDown(){
          driver.close();
    }
    @Test
    public void test01(){

        //url 'in  "amazon" icerdiğini test edin
          String expected = "amazon";
          String actual = driver.getCurrentUrl();
        Assert.assertTrue(actual.contains(expected));
    }
    @Test
    public void test02(){
        //title'in "facebook" icermedigini test edin
          String expectedWord="facebook";
          String actualTitle = driver.getTitle();

          Assert.assertFalse(actualTitle.contains(expectedWord));
    }
    @Test
    public void test03(){
        //sol ust kosedeki amazon logosunun göründüğünü test edin
          //   id= nav-logo-sprites
    WebElement logoElement= driver.findElement(By.id("nav-logo-sprites"));
    Assert.assertTrue(logoElement.isDisplayed());
    }
}
