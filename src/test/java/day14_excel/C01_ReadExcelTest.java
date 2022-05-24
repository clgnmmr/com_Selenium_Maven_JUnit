package day14_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcelTest {

    @Test
    public void readExcelTest() throws IOException {
        //7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";
        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);
        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook wrkbook= WorkbookFactory.create(fis);
        //10. WorkbookFactory.create(fileInputStream)

        //11. Worksheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet=wrkbook.getSheet("Sayfa1");
        //12. Row objesi olusturun sheet.getRow(index)
        Row row=sheet.getRow(3);
        //13. Cell objesi olusturun row.getCell(index)
        Cell cell= row.getCell(3);
         System.out.println(cell.getStringCellValue());

         //3 indexdeki satırın 3.indexdeki datanı cezayir oldugunu test edin
        String expectedData="Cezayir";
        String actualData=cell.toString();
        Assert.assertEquals(expectedData,actualData);
    }
}
