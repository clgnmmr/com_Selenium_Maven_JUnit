package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertions {
    //Bir Class olusturalim YanlisEmailTesti
    //http://automationpractice.com/index.php sayfasina gidelim
    //Sign in butonuna basalim
    //Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda “Invalid email address” uyarisi ciktigini test edelim
     WebDriver driver;

    @Before
    public  void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(15));

    }

    @After
    public  void tearDown() {
        driver.close();
    }

    @Test
    public void test01() {
        //http://automationpractice.com/index.php sayfasina gidelim
        driver.get("http://automationpractice.com/index.php");
        //testleri yapin
        //Sign in butonuna basalim
        driver.findElement(By.xpath("//a[@class='login']")).click();
//Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda
        driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("kadirtepecikgmail.com");
        driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
        //“Invalid email address” uyarisi ciktigini test edelim
        WebElement hataElement = driver.findElement(By.xpath("//*[text()='Invalid email address']"));
        Assert.assertTrue(hataElement.isDisplayed());


    }
}
