package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButton {
    WebDriver driver;
    //1. Bir class oluşturun : RadioButtonTest
    //2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(15));
    }
     @Test
     public void test() throws InterruptedException {
         //-https://www.facebook.com adresine gidin
         driver.get("https://www.facebook.com");
         //-Cookies’i kabul edin
         //-“Create an Account” button’una basin
         driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
         //-“radio buttons” elementlerini locate edin
         WebElement kadınElementi=driver.findElement(By.xpath("//input[@value='1']"));
         WebElement erkekElementi=driver.findElement(By.xpath("//input[@value='2']"));
         WebElement ozelElementi=driver.findElement(By.xpath("//input[@value='-1']"));
         //-Secili degilse cinsiyet butonundan size uygun olani secin
        Thread.sleep(3000);
         String cinsiyet="erkek";
         System.out.println(kadınElementi.getText());
         if (!erkekElementi.isSelected()){
             erkekElementi.click();
         }
     }


    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
