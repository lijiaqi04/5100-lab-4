package com.xiaoxiaohui;

import java.util.ArrayList;
import java.util.List;

public class CityList {
    List<City> cityList;



    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }
    public void addNewCity(City city){
        cityList.add(city);
    }
    public void deleCity(int i){
        cityList.remove(i);
    }
    public City getCity(int i){
        return  cityList.get(i);
    }
    public void addCity(City city){
        cityList.add(city);
    }
}
