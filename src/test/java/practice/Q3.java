package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;

public class Q3 extends TestBase {

    /*
     ...Exercise3...
    // http://the-internet.herokuapp.com/add_remove_elements/
    // click on the "Add Element" button 100 times
    // write a function that takes a number, and clicks the "Delete" button
    // given number of times, and then validates that given number of
    // buttons was deleted

    1.method : createButtons(100)
    2.deleteButtonsAndValidate()
 */

    @Test
    public void test01() {

        // http://the-internet.herokuapp.com/add_remove_elements/
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        // click on the "Add Element" button 100 times
        for (int i = 0; i <100 ; i++) {
            driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();

        }

        // write a function that takes a number, and clicks the "Delete" button
        List<WebElement> deleteTusuListesi=driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));

        int deleteElemanSayisi=deleteTusuListesi.size();

        int silmekIstedigimizAdet=60;
        createButtons(silmekIstedigimizAdet);
                             // given number of times, and then validates that given number of
        List<WebElement> deleteTusuListesi1=driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        int deleteElemanSayisi1=deleteTusuListesi1.size();
        Assert.assertEquals(deleteElemanSayisi-silmekIstedigimizAdet,deleteElemanSayisi1);
                       // buttons was deleted
        deleteButtonsAndValidate();

    }

    private void deleteButtonsAndValidate() {
        List<WebElement> deleteTusuListesi1=driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        for (int i = 0; i <deleteTusuListesi1.size() ; i++) {
            driver.findElement(By.xpath("(//button[@onclick='deleteElement()'])[1]")).click();
        }
    }

    private void createButtons(int i) {

        for (int j = 0; j <i ; j++) {
            driver.findElement(By.xpath("(//button[@onclick='deleteElement()'])[1]")).click();

        }
    }
}
