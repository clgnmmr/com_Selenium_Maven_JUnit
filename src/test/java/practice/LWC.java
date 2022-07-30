package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class LWC extends TestBase {
    @Test
    public void test() throws InterruptedException {
        //- https://www.lcwaikiki.com/tr-TR/TR sitesi açılır.
        driver.get("https://www.lcwaikiki.com/tr-TR/TR");
        //- Ana sayfanın açıldığı kontrol edilir. Siteye login olunur
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.lcwaikiki.com/tr-TR/TR"));

        WebElement girisYapButonu= driver.findElement(By.xpath("(//a[@class='header-dropdown-toggle'])[1]"));

        girisYapButonu.click();

        WebElement emailKutusu=driver.findElement(By.xpath("(//input[@class='text-input'])[1]"));
        WebElement passwordKutusu=driver.findElement(By.xpath("(//input[@class='text-input'])[2]"));

        emailKutusu.sendKeys("testinium.umutulupinar@gmail.com");
        passwordKutusu.sendKeys("Testinium2021");

        WebElement loginButonu=driver.findElement(By.xpath("//button[text()='Giriş Yap']"));
        loginButonu.click();

        Thread.sleep(20000);

        //- Login işlemi kontrol edilir.
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement hesabimButonu=driver.findElement(By.xpath("(//span[@class='dropdown-label'])[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(hesabimButonu));
        Assert.assertEquals("Hesabım",hesabimButonu.getText());


  //    //- Arama kutucuğuna “pantolan” kelimesi girilir.

  //    WebElement aramaKutusu=driver.findElement(By.xpath("//input[@id='search-form__input-field__search-input']"));

  //    aramaKutusu.sendKeys("pantolan", Keys.ENTER);
  //    //- Sayfanın sonuna scroll edilir.
  //    Actions ac=new Actions(driver);
  //    ac.sendKeys(Keys.PAGE_DOWN);



  //    //- “Daha fazla ürün gör “ butonuna tıklanır.
  //    WebElement dahaFazlaUrunGorButonu=driver.findElement(By.xpath("//input[@id='search-form__input-field__search-input']"));

  //    JavascriptExecutor js=(JavascriptExecutor) driver;
  //    js.executeScript("arguments[0].click();",dahaFazlaUrunGorButonu);

        //- Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir.
        //- Seçilen ürün sepete eklenir.
        //- Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır.
        //- Adet arttırılarak ürün adedinin 2 olduğu doğrulanır.
        //- Ürün sepetten silinerek sepetin boş olduğu kontrol edilir






    }




}
