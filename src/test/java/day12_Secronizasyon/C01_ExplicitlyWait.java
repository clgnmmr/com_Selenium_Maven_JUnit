package day12_Secronizasyon;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitlyWait extends TestBase {


    @Test
    public void implicitlyWaitTesti(){
        //1. Bir class olusturun : WaitTest
        //2. Iki tane metod olusturun : implicitWait() , explicitWait()
        //     Iki metod icin de asagidaki adimlari test edin.
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement yazıElementi=driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        Assert.assertTrue(yazıElementi.isDisplayed());
        //6. Add buttonuna basin
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsbackElement =driver.findElement(By.xpath("//p[text()=\"It's back!\"]"));
        Assert.assertTrue(itsbackElement.isDisplayed());
    }

    @Test
    public void explicitlyWaitTesti(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
       /*
        WebElement yazıElementi=driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        wait.until(ExpectedConditions.visibilityOf(yazıElementi));
        Assert.assertTrue(yazıElementi.isDisplayed());

        yazinin gorunur lmasını beklerken yazının locate ini kullanak sorun oluşturur
        cunku henuz gorunmeyen bir yazının locate edilmesi de mumkun olmayabilir
        (HTML kodlari yazan developer farklı uygulamalr yapılabilir)
        bu durumda bekleme islemi ve locate'i birlikte yapılır
        */

        WebElement yazıElementi=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's gone!\"]")));
        Assert.assertTrue(yazıElementi.isDisplayed());
        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()=\"Add\"]")).click();

        //7. It’s back mesajinin gorundugunu test edin

        WebElement itsBackElementi=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's back!\"]")));
        Assert.assertTrue(itsBackElementi.isDisplayed());

    }
}
