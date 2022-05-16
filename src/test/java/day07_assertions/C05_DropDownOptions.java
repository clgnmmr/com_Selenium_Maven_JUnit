package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;


public class C05_DropDownOptions {
    /*
    amazon ana sayfaya git
    dropdown menuden books sec
    sectiğimiz option yazdıralım

    dropdowndaki  opsiyonların toplam sayısının
    20 oldugunu test edin
     */
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(15));
    }
    @After
public  void tearDown(){
        driver.close();
    }
    @Test
    public void test01()  {
        driver.navigate().to("https://www.amazon.com");
        WebElement ddm=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Books");// gorunur text
        //select.selectByIndex(5);// ındex le secer
        // select.selectByValue("search-alias=stripbooks-intl-ship");// value secer
        //bir dropdown ile calışırken son secilen elemana ulaşmak isterseniz alttaki sistemi kullanmalısınız
        //bu method bize webelement doner uzerindeki yazdırmak icin getText kullanılır
        System.out.println("select.getFirstSelectedOption().getText() = " + select.getFirstSelectedOption().getText());
        List<WebElement> optionList=select.getOptions();
        int optionSayisi=optionList.size();
        int expectedOptionSayisi=28;
        Assert.assertEquals(expectedOptionSayisi,optionSayisi);

        //Assert.assertTrue(optionSayisi==expectedOptionSayisi);
    }
}
