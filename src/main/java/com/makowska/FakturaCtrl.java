package com.makowska;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "tnsLFakturaCtrl")
@XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
public class FakturaCtrl {
    @XmlElement(name = "tns:LiczbaFaktur")
    private int LiczbaFaktur = Faktura.number;
    @XmlElement(name = "tns:WartoscFaktur")
    private BigDecimal WartoscFaktur = Faktura.sum;

}
