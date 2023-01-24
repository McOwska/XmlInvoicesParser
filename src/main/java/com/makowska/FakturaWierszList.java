package com.makowska;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "listaPozycji")
@XmlAccessorType(XmlAccessType.FIELD)

public class FakturaWierszList {
    @XmlElement(name = "FakturaWiersz")
    List<FakturaWiersz> list;

    public FakturaWierszList(){
        list = new ArrayList<>();
    }
    public void addItem(FakturaWiersz item){
        list.add(item);
    }
    public int getSize(){
        return this.list.size();
    }
}
