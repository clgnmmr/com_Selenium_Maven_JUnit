package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_BestBuyAssertions {

    WebDriver driver;
//1) Bir class oluşturun: BestBuyAssertions
//2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki
//testleri yapin
//○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
//○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
//○ logoTest => BestBuy logosunun görüntülendigini test edin
//○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(15));
    }

    @Test
    public void test()  {
        //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki
        driver.get("https://www.bestbuy.com/");
       //testleri yapin

       //○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        String expectedUrl="https://www.bestbuy.com/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals("Url beklenenden farkli",expectedUrl,actualUrl);
      //○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String expectedTitle ="Rest";
        String actualTitle= driver.getTitle();
        Assert.assertFalse("sayfa baslıgı expected iceriyor",actualTitle.contains(expectedTitle));
      //○ logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logoElement= driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue("bestbuy logosu gozukmuyor", logoElement.isDisplayed());
      //○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement listElement=driver.findElement(By.xpath("//button[text()='Français']"));
        Assert.assertTrue("Fransızca linki gözükmüyor",listElement.isDisplayed());


    }








    @After
    public void tearDown() throws InterruptedException {
        driver.close();
    }


}
