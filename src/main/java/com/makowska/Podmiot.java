package com.makowska;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "tns:Podmiot1")
@XmlAccessorType(XmlAccessType.FIELD)
public class Podmiot {
    @XmlElement(name = "tns:IdentyfikatorPodmiotu")
    IdentyfikatorPodmiotu IdentyfikatorPodmiotu = new IdentyfikatorPodmiotu();
    @XmlElement(name = "tns:AdresPodmiotu")
    AdresPodmiotu Adres = new AdresPodmiotu();

}
