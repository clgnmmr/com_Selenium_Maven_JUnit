package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C03_MouseActions1 extends TestBase {

    //1- Yeni bir class olusturalim: MouseActions1

    @Test
    public void test01(){
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://www.lcwaikiki.com/tr-TR/TR");
        String ilkSayfaWindowHandleDegeri= driver.getWindowHandle();
        //3- Cizili alan uzerinde sag click yapalim
        WebElement ciziliAlan=driver.findElement(By.id("hot-spot"));
        Actions actions=new Actions(driver);
        actions.moveToElement(ciziliAlan).contextClick().perform();



        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu
        //    test edelim.
        String expectedYazi="You selected a context menu";
        String actualYazi=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazi,actualYazi);
        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        //6- Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Set<String>  windowHandleSet = driver.getWindowHandles();
        String ikinciSayfaWindowHandleDegeri="";
        for (String each:windowHandleSet
             ) {
            if (!each.equals(ilkSayfaWindowHandleDegeri)){
                ikinciSayfaWindowHandleDegeri=each;
            }
        }
        driver.switchTo().window(ikinciSayfaWindowHandleDegeri);

        String expectedTitle = "Elemental Selenium";
        String actualTitle=driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).getText();
        Assert.assertEquals(expectedTitle, actualTitle);


    }

    @Test
    public void test02(){

        //- https://www.lcwaikiki.com/tr-TR/TR sitesi açılır.
        driver.get("https://www.lcwaikiki.com/tr-TR/TR");
        //- Ana sayfanın açıldığı kontrol edilir. Siteye login olunur
        WebElement anasayfaBaslık=driver.findElement(By.xpath("//a[@class='main-header-logo']"));
        Assert.assertTrue(anasayfaBaslık.isDisplayed());
        //- Login işlemi kontrol edilir.
        //- Arama kutucuğuna “pantolan” kelimesi girilir.
        //- Sayfanın sonuna scroll edilir.
        //- “Daha fazla ürün gör “ butonuna tıklanır.
        //- Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir.
        //- Seçilen ürün sepete eklenir.
        //- Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır.
        //- Adet arttırılarak ürün adedinin 2 olduğu doğrulanır.
        //- Ürün sepetten silinerek sepetin boş olduğu kontrol edilir.
    }

}
