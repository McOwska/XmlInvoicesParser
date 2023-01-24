package com.makowska;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "tns:FakturaWierszCtrl")
@XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
public class FakturaWierszCtrl {
    @XmlElement(name = "tns:LiczbaWierszyFaktur")
    private int amount = FakturaWiersz.number;
    @XmlElement(name = "tns:WartoscWierszyFaktur")
    private BigDecimal sum = FakturaWiersz.sum;
}
