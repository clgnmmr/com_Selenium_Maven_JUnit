package practice;



import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class Q08_ExplicitlyWait extends TestBase {


/*
    //go to web site : https://www.jqueryscript.net/demo/bootstrap-alert-box/
    //maximize the window
    //click on action dialog button
    //if need use explicitly wait
    //click on the ok button
    //accept the alert message
 */

    @Test
    public void test01() {
        driver.get("https://www.jqueryscript.net/demo/bootstrap-alert-box/");
        driver.findElement(By.xpath("//button[@id='action']")).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[@class='text-info']"))));

        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='text-info']")).isDisplayed());

        driver.findElement(By.xpath("//button[@id='dialog-mycodemyway-action']")).click();
        driver.switchTo().alert().accept();
    }
}


