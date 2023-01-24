package com.makowska;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;

public final class InvoiceTest {
    @Test
    public void defaultCounstructorTest(){
        Invoice invoice = new Invoice();
        Assert.assertEquals(new BigDecimal(0), invoice.getNetPriceSum());
    }

    @Test
    public void constructorTest() throws ParseException {
        String [] newItem1 = {"name", "adress", "NIP", "2019-01-01", "2019-01-01", "invoiceNumber", "title", "1", "600,00 zł", "23", "138,00 zł", "600,00 zł", "738,00 zł", "800,00 zł", "800,00 zł"};
        Item item = new Item(newItem1);

        Invoice invoice = new Invoice(item);
        Assert.assertEquals(new BigDecimal(600).setScale(2), invoice.getNetPriceSum());

    }

}