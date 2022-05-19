package day08_alerts_iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Alerts {

WebDriver driver;
     @Before
    public void setUp() throws Exception {
       WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();

       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

     }
     @After
    public void tearDown(){

        // driver.close();
     }
     @Test
    public void test01(){
         /*
         herhangi bir web sitesine gidince veya bir web sitesinde herhangi bir işlem yatıgımızda ortaya cıkan uyarılara alert denir


         eğer bir alert inspect yapılabiliyorise o alert otomasyon ile kullanılabilir
         bu tur alert lere html alert denir ve bunlar icin ekstra bir işlem yapmaya gerek yoktur
         tum webelementler gibi locate edip istedigimiz islemleri yapabiliriz

         driver.get("https://www.facebook.com");
          ancak web uygulamalarında html alert yanında java script alert de bulunablir
          js alertler locate edilemez
          selenium da js alerler icin ozel bir yontem geliştirmiştir

          */

         driver.get("https://the-internet.herokuapp.com/javascript_alerts");
         driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

         driver.switchTo().alert().accept();
         //alerte ok basın ve result kısmında "You successfully clicked an alert" yazdıgını test et

         String expectedResult ="You successfully clicked an alert";
         String actualResult=driver.findElement(By.xpath("//p[@id='result']")).getText();
         Assert.assertEquals(expectedResult, actualResult);

     }
}
