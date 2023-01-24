package com.makowska;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@XmlRootElement(name = "tns:FakturaWiersz")
@XmlAccessorType(XmlAccessType.FIELD)
public class FakturaWiersz {
    @XmlTransient
    public static int number = 0;
    @XmlElement(name = "tns:P_2B")
    private String P_2B;
    @XmlElement(name = "tns:P_7")
    private String P_7;
    @XmlElement(name = "tns:P_8A")
    private String P_8A = "szt";
    @XmlElement(name = "tns:P_8B")
    private BigDecimal P_8B;
    @XmlElement(name = "tns:P_9A")
    private BigDecimal P_9A;
    @XmlElement(name = "tns:P_9B")
    private BigDecimal P_9B;
    @XmlElement(name = "tns:P_11")
    private BigDecimal P_11;
    @XmlElement(name = "tns:P_12")
    private int P_12;
    @XmlTransient
    public static BigDecimal sum = new BigDecimal(0);


    public FakturaWiersz() {
    }

    FakturaWiersz(Item item){
        this.P_2B = item.getInvoiceNumber();
        this.P_7 = item.getTitle();
        this.P_8B = item.getQuantity();
        this.P_9A = item.getNetPrice();
        this.P_9B = item.getUnitPrice();
        this.P_11 = item.getGrossPrice();
        this.P_12 = item.getTaxRate();
        number++;
        sum = sum.add(P_9B);
    }
    public String getName(){
        return this.P_7;
    }
}
