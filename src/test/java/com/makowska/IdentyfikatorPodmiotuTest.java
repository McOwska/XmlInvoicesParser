package com.makowska;

import org.junit.Assert;
import org.junit.Test;

public final class IdentyfikatorPodmiotuTest{
    @Test
    public void constructorTest(){
        IdentyfikatorPodmiotu id = new IdentyfikatorPodmiotu();
        Assert.assertEquals("6762484560", id.NIP);
        Assert.assertEquals("\"CORE LOGIC\" SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ", id.PelnaNazwa);
    }

}