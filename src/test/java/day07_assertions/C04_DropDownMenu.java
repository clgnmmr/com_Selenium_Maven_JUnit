package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_DropDownMenu {
    /*
    amazona git
    dropdowndan books seceneğini seçip
    java aratalım
    ve arama sonuclarının
    java icerdiğini test edelim
     */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(15));


    }
    @After
    public  void tearDown(){
        driver.close();

    }

    @Test
    public void test01()  {
        //   amazona git
        driver.navigate().to("https://www.amazon.com");
        //    dropdowndan books seceneğini seçmel seçip icin 3 adım vardır
        // 1. adım locate edilir
        WebElement ddm=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        //2 bir Select objesi oluşurmak
        Select select=new Select(ddm);
        // 3. dropdownda var olan optinallardan istedğimiz bir taneyi secelim adım optional
        select.selectByVisibleText("Books");// gorunur text
        //select.selectByIndex(5);// ındex le secer
       // select.selectByValue("search-alias=stripbooks-intl-ship");// value secer
        //    java aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        //    ve arama sonuclarının
        WebElement sonucElement=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String sonucYazısı=sonucElement.getText();
        String arananKelime="Java";
        Assert.assertTrue(sonucYazısı.contains(arananKelime));
        //    java icerdiğini test edelim

    }




}
