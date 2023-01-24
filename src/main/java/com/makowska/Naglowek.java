package com.makowska;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name = "tns:Naglowek")
public class Naglowek {
    @XmlElement(name = "tns:KodFormularza")
    public String KodFormularza = "JPK_FA (3)";
    @XmlElement(name = "tns:WariantFormularza")
    private int WariantFormularza = 3;
    @XmlElement(name = "tns:CelZlozenia")
    private int CelZlozenia = 1;
    @XmlElement(name = "tns:DataWytworzeniaJPK")
    private Date DataWytworzeniaJPK = new Date(2021, 10, 28);
    @XmlElement(name = "tns:DataOd")
    private Date DataOd = new Date(2020, 10, 01);
    @XmlElement(name = "tns:DataDo")
    private Date DAtaDo = new Date(2020, 12,31);
    @XmlElement(name = "tns:KodUrzedu")
    private int KodUrzedu = 1208;
}
