package com.makowska;

import org.junit.Assert;
import org.junit.Test;

public final class CsvReaderTest {
    @Test
    public void readCsvFileTest() {
        ItemList allItems = new ItemList();
        CsvReader csvReader = new CsvReader();
        csvReader.readCsvFile("src/faktury-test.csv", allItems);
        Assert.assertEquals(Item.counter, allItems.getSize()+1);
        Assert.assertEquals(15, Item.header.length);
    }
}