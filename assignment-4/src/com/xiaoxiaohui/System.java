package com.xiaoxiaohui;

import java.util.ArrayList;
import java.util.List;

public class System {
    PatientDirectory patientDirectory;
    PersonDirectory personDirectory;
    CityList cityList;

    public PatientDirectory getPatientDirectory() {
        return patientDirectory;
    }

    public void createPatienDirectory(){
        patientDirectory = new PatientDirectory();
        patientDirectory.patientList = new ArrayList<>();
        personDirectory = new PersonDirectory();
        Patient patient_1 = new Patient();
        Patient patient_2 = new Patient();
        EncounterHistory  encounterHistory= new EncounterHistory();
        patient_1.encounterHistory=encounterHistory;
        Encounter encounter_1=new Encounter();
        Vital_Signs vitalSigns = new Vital_Signs();
        Vital_Signs vitalSigns1=new Vital_Signs();
        vitalSigns.setTemperature(70);
        vitalSigns.setRespirationRate(30);
        vitalSigns.setHighbloodPressure(120);
        vitalSigns.setPulseRate(70);
        vitalSigns1.setLowbloodPressure(50);
        encounter_1.vitalSigns=vitalSigns;
        encounterHistory.addEncouter(encounter_1);
        Encounter encounter_2=new Encounter();
        vitalSigns1.setTemperature(70);
        vitalSigns1.setRespirationRate(30);
        vitalSigns1.setHighbloodPressure(130);
        vitalSigns1.setLowbloodPressure(60);
        vitalSigns1.setPulseRate(78);
        encounter_2.vitalSigns=vitalSigns1;
        encounterHistory.addEncouter(encounter_2);
        Patient patient = new Patient();
        Person person=new Person();
        Person person1=new Person();
        Person person2=new Person();
        person2.setHouse("building1");
        patient.setPerson(person2);
        patient.encounterHistory = new EncounterHistory();
        patientDirectory.addNewPatient(patient);
        person.setPatient(false);
        personDirectory.addNewPerson(person2);
        person2.setAge(23);
        person2.setName("dik");
        person.setName("David");
        person.setAge(19);
        person.setHouse("building2");
        person.setPatient(true);
        patient_1.setPerson(person);
        patient_1.setEncounterHistory(encounterHistory);
        patientDirectory.patientList.add(patient_1);
        person1.setName("Tom");
        person1.setAge(22);
        person1.setHouse("building1");
        person1.setPatient(true);
        patient_2.setPerson(person1);
        personDirectory.addNewPerson(person);
        personDirectory.addNewPerson(person1);
        patientDirectory.patientList.add(patient_2);
        patient_2.setEncounterHistory(encounterHistory);
    }

    public void createCityList(){
        City city = new City();
        city.setName("boston");
        CommunityList communityList=new CommunityList();
        city.communityList=communityList;
        cityList=new CityList();
        Community community=new Community();
        community.setName("malden");
        city.setName("boston");
        communityList.addCommunity(community);
        Community community1=new Community();
        community1.setName("quincy");
        communityList.addCommunity(community1);
        city.communityList=communityList;
        List<City> s = new ArrayList<>();
        cityList.setCityList(s);
        cityList.addCity(city);
        HouseList houseList =new HouseList();
        HouseList houseList3 = new HouseList();
        List<House> houseList1 =new ArrayList<>();
        List<House> houseList2 =new ArrayList<>();
        House house=new House();
        house.setName("building1");
        house.setCommunity("malden");
        houseList1.add(house);
        House house1 =new House();
        house1.setName("building2");
        house1.setCommunity("quincy");
        houseList2.add(house1);
        houseList.setHouseList(houseList1);
        houseList3.setHouseList(houseList2);
        community.houseList=houseList;
        community1.houseList=houseList3;
    }

    public void setPatientDirectory(PatientDirectory patientDirectory) {
        this.patientDirectory = patientDirectory;
    }

    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }

    public void setPersonDirectory(PersonDirectory personDirectory) {
        this.personDirectory = personDirectory;
    }

    public CityList getCityList() {
        return cityList;
    }

    public void setCityList(CityList cityList) {
        this.cityList = cityList;
    }
}
