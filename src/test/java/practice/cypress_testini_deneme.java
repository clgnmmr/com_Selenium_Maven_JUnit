package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class cypress_testini_deneme {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }
    @AfterClass
    public static void tearDown(){
        driver.close();

    }

    @Test
    public void test01()  {
        driver.navigate().to("https://www.saucedemo.com/");

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl ="https://www.saucedemo.com/";
        Assert.assertEquals(expectedUrl,actualUrl);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        actualUrl = driver.getCurrentUrl();
         expectedUrl ="https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(expectedUrl,actualUrl);

        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();

        WebElement sepetSembolElement=driver.findElement(By.className("shopping_cart_link"));

        Assert.assertTrue(sepetSembolElement.isDisplayed());

        sepetSembolElement.click();


        actualUrl = driver.getCurrentUrl();
        expectedUrl ="https://www.saucedemo.com/cart.html";
        Assert.assertEquals(expectedUrl,actualUrl);

        WebElement urunTitleElementi=driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));

        Assert.assertTrue(urunTitleElementi.isDisplayed());

        driver.findElement(By.xpath("//button[@id='checkout']")).click();

        actualUrl = driver.getCurrentUrl();
        expectedUrl ="https://www.saucedemo.com/checkout-step-one.html";
        Assert.assertEquals(expectedUrl,actualUrl);

        driver.findElement(By.id("first-name")).sendKeys("deneme");
        driver.findElement(By.id("last-name")).sendKeys("calısması");
        driver.findElement(By.id("postal-code")).sendKeys("58800");


        driver.findElement(By.id("continue")).click();


        actualUrl = driver.getCurrentUrl();
        expectedUrl ="https://www.saucedemo.com/checkout-step-two.html";
        Assert.assertEquals(expectedUrl,actualUrl);

        urunTitleElementi=driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));

        Assert.assertTrue(urunTitleElementi.isDisplayed());
        driver.findElement(By.xpath("//button[@id='finish']")).click();

    }

}
