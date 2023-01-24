package com.makowska;

import org.junit.Assert;
import org.junit.Test;
public class ReaderTests {
    @Test
    public void readFileTest() {
        ItemList allItemsCsv = new ItemList();
        CsvReader csvReader = new CsvReader();
        csvReader.readCsvFile("src/faktury-test.csv", allItemsCsv);


        ItemList allItemsXlsx = new ItemList();
        XlsxReader xlsxReader = new XlsxReader();
        xlsxReader.readXlsxFile("src/faktury-xlsx.xlsx", allItemsXlsx);

        Assert.assertEquals(allItemsCsv.getSize()+1, allItemsXlsx.getSize());
    }

}
