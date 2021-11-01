package com.xiaoxiaohui;

import java.util.ArrayList;
import java.util.List;

public class EncounterHistory
{
    List<Encounter> encounterList;

    public EncounterHistory() {
        encounterList = new ArrayList<Encounter>();
    }

    public List<Encounter> getEncounterList() {
        return encounterList;
    }

    public void setEncounterList(List<Encounter> encounterList) {
        this.encounterList = encounterList;
    }

    public void addEncouter(Encounter encounter){
        encounterList.add(encounter);
    }
}
