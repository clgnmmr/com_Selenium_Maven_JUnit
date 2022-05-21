package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q1 {
    /*
    ...Exercise1...
    BeforeClass ile driver ı olusturun ve class icinde static yapin
    Maximize edin, 15 sn bekletin
    http://www.google.com adresine gidin
    arama kutusuna "Green Mile" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna  "Premonition" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna  "The Curious Case of Benjamin Button" yazip, cikan sonuc sayisini yazdirin
    AfterClass ile kapatın

 */
    static WebDriver driver;
        @BeforeClass
    public static void setup(){

            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
           driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        }
        @AfterClass
    public static void tearDown(){
            driver.close();

        }



        @Test
    public void test01(){
            // http://www.google.com adresine gidin
            driver.get("http://www.google.com");

            //    arama kutusuna "Green Mile" yazip, cikan sonuc sayisini yazdirin
            driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Green Mile",Keys.ENTER);
            WebElement resultText=driver.findElement(By.xpath("//div[@id='result-stats']"));
                  String resultNumber=resultText.getText().replaceAll("\\D","");
            System.out.println(" Green Mile ile ilgili arama sonucu : "+resultNumber);

            //    arama kutusuna  "Premonition" yazip, cikan sonic sayisini yazdirin

            driver.findElement(By.xpath("//input[@name='q']")).clear();
            driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Premonition",Keys.ENTER);
            WebElement resultText1=driver.findElement(By.xpath("//div[@id='result-stats']"));
            String resultNumber1=resultText1.getText().replaceAll("\\D","");
            System.out.println(" Premonition ile ilgili arama sonucu : "+resultNumber1);


            //    arama kutusuna  "The Curious Case of Benjamin Button" yazip, cikan sonuc sayisini yazdirin

            driver.findElement(By.xpath("//input[@name='q']")).clear();
            driver.findElement(By.xpath("//input[@name='q']")).sendKeys("The Curious Case of Benjamin Button",Keys.ENTER);
            WebElement resultText2=driver.findElement(By.xpath("//div[@id='result-stats']"));
            String resultNumber2=resultText2.getText().replaceAll("\\D","");
            System.out.println(" Premonition ile ilgili arama sonucu : "+resultNumber2);
        }

}
