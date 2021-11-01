package com.xiaoxiaohui;

import java.util.ArrayList;
import java.util.List;

public class HouseList {
    List<House> houseList;

    public void construct(){
        this.houseList = new ArrayList<>();
    }

    public List<House> getHouseList() {
        return houseList;
    }

    public void setHouseList(List<House> houseList) {
        this.houseList = houseList;
    }


    public void addHouse(House house){
        houseList.add(house);
    }

    public House getHouse(int i){
        return houseList.get(i);
    }
    public void  deleteHouse(int i){
        houseList.remove(i);
    }
}
