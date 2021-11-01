package com.xiaoxiaohui;

import javax.swing.*;
import javax.swing.table.*;
import net.miginfocom.swing.*;

import java.util.ArrayList;
import java.util.List;

public class Person {
    String name;
    int age;
    String house;
    int ID;
    boolean isPatient;
    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public boolean isPatient() {
        return isPatient;
    }

    public void setPatient(boolean patient) {
        isPatient = patient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
