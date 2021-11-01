package com.xiaoxiaohui;

import java.util.List;

public class House {
    String name;
    String community;
    List<Person> personList;

    public List<Person> setPersonlist(PersonDirectory personDirectory){
        for(Person s:personDirectory.getPersonList()){
            if(s.getHouse().equals(this.name)){
                personList.add(s);
            }
        }
        return personList;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}
