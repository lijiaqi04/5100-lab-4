package com.xiaoxiaohui;

import java.util.ArrayList;
import java.util.List;

public class PatientDirectory {
    List<Patient> patientList;



    public Patient addNewPatient(Patient patient){
        patientList.add(patient);
        return patient;
    }
    public void deletePatient(int vs){
        patientList.remove(vs);
    }

    public List<Patient> getPatientList() {
        return patientList;
    }
    public Patient getPatient(int i){
        return patientList.get(i);
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }
}
