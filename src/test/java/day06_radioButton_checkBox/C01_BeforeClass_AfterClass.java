package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BeforeClass_AfterClass {
    /*
    BeforeClass ve AfterClass notasyonları sadece static methodlar icin calışır
     */

   static WebDriver driver;
    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(15));

    }
    @AfterClass
    public static void tearDown() throws InterruptedException{
        driver.close();


    }
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
    }
    @Test
    public void test02(){
        driver.get("https://www.techproeducation.com");
    }
    @Test
    public void test03(){
        driver.get("https://www.facebook.com");
    }





}
