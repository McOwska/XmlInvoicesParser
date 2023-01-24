package com.makowska;

import org.junit.Assert;
import org.junit.Test;


public final class XlsxReaderTest {
    @Test
    public void readXlsxTest() {
        ItemList allInvoices = new ItemList();
        XlsxReader reader = new XlsxReader();
        reader.readXlsxFile("src/faktury-xlsx.xlsx", allInvoices);
        Assert.assertNotNull(allInvoices.itemByIndex(0));
    }

}