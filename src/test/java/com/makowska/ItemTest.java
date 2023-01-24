package com.makowska;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class ItemTest {
    @Test
    public void stringToPriceTest1(){
        String str = "600,00 zł";
        Assert.assertEquals(600.00, Item.stringToPrice(str), 0.0);
    }

    @Test
    public void stringToPriceTest2(){
        String str = "6 000,00 zł";
        Assert.assertEquals(6000.00, Item.stringToPrice(str), 0.0);
    }


    @Test
    public void constructorTest() throws ParseException {
        String[] newItem = {"name", "adress", "NIP", "2019-01-01", "2019-01-01", "invoiceNumber", "title", "1", "600,00 zł", "23", "138,00 zł", "600,00 zł", "738,00 zł", "800,00 zł", "800,00 zł"};
        Item item = new Item(newItem);
        Assert.assertEquals("name", item.getName());
        Assert.assertEquals("adress", item.getAdress());
        Assert.assertEquals("NIP", item.getNIP());
        Assert.assertEquals(new SimpleDateFormat("yyyy-MM-dd").parse("2019-01-01"), item.getDateOfIssue());
        Assert.assertEquals(new SimpleDateFormat("yyyy-MM-dd").parse("2019-01-01"), item.getDateOfSale());
        Assert.assertEquals("invoiceNumber", item.getInvoiceNumber());
        Assert.assertEquals("title", item.getTitle());
        Assert.assertEquals(new BigDecimal(1).setScale(2), item.getQuantity());
    }






}