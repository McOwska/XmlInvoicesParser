package com.makowska;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

@XmlRootElement(name = "tns:Faktura")
@XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
public class Faktura {
    @XmlTransient
    public static int number = 0;
    @XmlTransient
    public static BigDecimal sum = new BigDecimal(0);
    @XmlElement(name = "tns:KodWaluty")
    private String KodWaluty = "PLN";
    @XmlElement(name = "tns:P_1")
    private Date P_1;
    @XmlElement(name = "tns:P_2A")
    private String P_2A;
    @XmlElement(name = "tns:P_3A")
    private String P_3A;
    @XmlElement(name = "tns:P_3B")
    private String P_3B;
    @XmlElement(name = "tns:P_3C")
    private String P_3C;
    @XmlElement(name = "tns:P_3D")
    private String P_3D;
    @XmlElement(name = "tns:P_4A")
    private String P_4A = "PL";
    @XmlElement(name = "tns:P_4B")
    private String P_4B;
    @XmlElement(name = "tns:P_5B")
    private String P_5B;
    @XmlElement(name = "tns:P_6")
    private Date P_6;
    @XmlElement(name = "tns:P_13_1")
    private BigDecimal P_13_1;
    @XmlElement(name = "tns:P_14_1")
    private BigDecimal P_14_1;
    @XmlElement(name = "tns:P_15")
    private BigDecimal P_15;
    @XmlElement(name = "tns:P_16")
    private Boolean P_16 = false;
    @XmlElement(name = "tns:P_17")
    private Boolean P_17 = false;
    @XmlElement(name = "tns:P_18")
    private Boolean P_18 = false;
    @XmlElement(name = "tns:P_18A")
    private Boolean P_18A = false;
    @XmlElement(name = "tns:P_19")
    private Boolean P_19 = false;
    @XmlElement(name = "tns:P_20")
    private Boolean P_20 = false;
    @XmlElement(name = "tns:P_21")
    private Boolean P_21 = false;
    @XmlElement(name = "tns:P_22")
    private Boolean P_22 = false;
    @XmlElement(name = "tns:P_23")
    private Boolean P_23 = false;
    @XmlElement(name = "tns:P_106E_2")
    private Boolean P_106E_2 = false;
    @XmlElement(name = "tns:106E_3")
    private Boolean P_106E_3 = false;
    @XmlElement(name = "tns:RodzajFaktury")
    private String RodzajFaktury = "VAT";

    Faktura() {}
    Faktura(Invoice invoice){
        this.P_1 = invoice.getDateOfIssue();
        this.P_2A = invoice.getInvoiceNumber();
        this.P_3A = invoice.getName();
        this.P_3B = invoice.getName()+"-ADDRESS";
        this.P_3C = IdentyfikatorPodmiotu.PelnaNazwa;
        this.P_3D = AdresPodmiotu.getAdress();
        this.P_4B = IdentyfikatorPodmiotu.NIP;
        this.P_5B = invoice.getNIP();
        this.P_6 = invoice.getDateOfSale();
        this.P_13_1 = invoice.getNetPriceSum();
        this.P_15 = invoice.getGrossPriceSum();
        this.P_14_1 = P_15.subtract(P_13_1);
        number++;
        sum = sum.add(P_15);    }

    public BigDecimal getGrossPriceSum(){
        return this.P_15;
    }

}
