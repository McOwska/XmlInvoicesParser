package com.makowska;

import org.junit.Assert;
import org.junit.Test;

public final class NaglowekTest{
    @Test
    public void naglowekTest(){
        Naglowek n = new Naglowek();
        Assert.assertEquals("tns:KodFormularza", n.KodFormularza);
    }
}