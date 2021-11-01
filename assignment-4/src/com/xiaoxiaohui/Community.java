package com.xiaoxiaohui;

import java.util.ArrayList;
import java.util.List;

public class Community extends City {
    String name;
    HouseList houseList;


    public HouseList getHouseList() {
        return houseList;
    }

    public void setHouseList(HouseList houseList) {
        this.houseList = houseList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
