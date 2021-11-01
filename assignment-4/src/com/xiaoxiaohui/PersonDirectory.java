package com.xiaoxiaohui;

import java.util.ArrayList;
import java.util.List;

public class PersonDirectory {
    List<Person> personList;

    public PersonDirectory() {
        this.personList = new ArrayList<>();
    }
    public Person addNewPerson(Person person){
        personList.add(person);
        return person;
    }
    public Person getPerson(int i){
        return personList.get(i);
    }
    public List<Person> getPersonList() {
        return personList;
    }

    public void deletePerson(int vs){
        personList.remove(vs);
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}
