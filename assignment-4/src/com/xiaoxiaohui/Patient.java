package com.xiaoxiaohui;

import javax.swing.*;
import javax.swing.table.*;
import net.miginfocom.swing.*;

import java.util.List;

public class Patient {
    Person person;
    EncounterHistory encounterHistory;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public EncounterHistory getEncounterHistory() {
        return encounterHistory;
    }

    public void setEncounterHistory(EncounterHistory encounterHistory) {
        this.encounterHistory = encounterHistory;
    }

}
