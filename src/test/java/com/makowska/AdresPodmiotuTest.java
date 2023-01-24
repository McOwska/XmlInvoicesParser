package com.makowska;

import org.junit.Assert;
import org.junit.Test;

public final class AdresPodmiotuTest {
    @Test
    public void getAdressTest(){
        AdresPodmiotu adress = new AdresPodmiotu();
        Assert.assertEquals("ul. Feliksa Radwańskiego 15/1, 30-065 Kraków", adress.getAdress());
    }
}