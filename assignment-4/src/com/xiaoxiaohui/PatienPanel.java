/*
 * Created by JFormDesigner on Sat Oct 30 18:21:51 EDT 2021
 */

package com.xiaoxiaohui;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import net.miginfocom.swing.*;

import java.awt.*;

/**
 * @author unknown
 */
public class PatienPanel extends JPanel {
    PatientDirectory patientDirectory;
    PersonDirectory personDirectory;
    public PatienPanel(System system) {
        initComponents();
        this.patientDirectory = system.getPatientDirectory();
        this.personDirectory=system.getPersonDirectory();
        populateTable();
        table1.getTableHeader().setBackground(new Color(255, 255, 255, 0));
    }
    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        model.setRowCount(0);
        for (Patient vs : patientDirectory.getPatientList()) {
            Object[] row = new Object[2];
            row[0] = vs.person.getName();
            row[1] = vs.person.getAge();
            model.addRow(row);
        }

    }

    private void button1MousePressed(MouseEvent e) {
        if(textField2.getText().equals("")||textField3.getText().equals("")||textField1.getText().equals("")){
            JOptionPane.showMessageDialog(this,"empty input");
            textField2.setText("");
            textField3.setText("");
            textField1.setText("");
            return;
        }
        String temp_1 = textField3.getText();
        for(int i=0 ; i<temp_1.length() ; i++){
            if(!Character.isDigit(temp_1.charAt(i))){
                JOptionPane.showMessageDialog(this,"wrong input of age");
                textField3.setText("");
                return;
            }
        }
        
        String house = textField1.getText();
        
        
        String name = textField2.getText();
        int age = Integer.parseInt(textField3.getText());
        Patient patient=new Patient();
        Person person = new Person();
        for(int i=0 ; i<name.length() ; i++){
            if(!Character.isAlphabetic(name.charAt(i))){
                JOptionPane.showMessageDialog(this,"wrong input of name");
                textField2.setText("");
                return;
            }
        }
        person.setAge(age);
        person.setName(name);
        person.setHouse(house);
        patient.setPerson(person);
        patient.encounterHistory = new EncounterHistory();
        patientDirectory.addNewPatient(patient);
        personDirectory.addNewPerson(person);
        textField2.setText("");
        textField3.setText("");
        textField1.setText("");
        JOptionPane.showMessageDialog(null,"New Person and patient added.");
        // TODO add your code here
    }

    private void button4MousePressed(MouseEvent e) {
        populateTable();
    }

    private void button6MousePressed(MouseEvent e) {
        int selected=table1.getSelectedRow();
        if(selected<0){
            JOptionPane.showMessageDialog(this,"please select a row");
            return;
        }
        DefaultTableModel model_1=(DefaultTableModel)table1.getModel();
//        Car selectedCar=(Car) model_1.getValueAt(selected,0);
        personDirectory.deletePerson(selected);
        patientDirectory.deletePatient(selected);
        JOptionPane.showMessageDialog(this,"Person deleted");
        populateTable();
    }

    private void button5MousePressed(MouseEvent e) {
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        int selected=table1.getSelectedRow();
        patientDirectory.getPatientList();
        for(int i = 0; i<model.getRowCount(); i++){
            for(int j = 0; j<model.getColumnCount(); j++){
                if(j==0){
                   String temp_name = (String) model.getValueAt(i,j);
                    for (int g = 0; g < temp_name.length(); g++) {
                        if (!Character.isAlphabetic(temp_name.charAt(i))) {
                            JOptionPane.showMessageDialog(this, "wrong input of age");
                            return;
                        }
                    }
                   patientDirectory.getPatient(i).person.setName(temp_name);
                }
                else{
                    String temp_age=(String) model.getValueAt(i,j);
                    for(int g=0 ; g<temp_age.length() ; g++){
                        if(!Character.isDigit(temp_age.charAt(i))){
                            JOptionPane.showMessageDialog(this,"wrong input of age");
                            return;
                        }
                    }
                    int age1= Integer.parseInt(temp_age);

                    patientDirectory.getPatient(i).person.setAge(age1);
                }
            }
        }
        JOptionPane.showMessageDialog(this,"successful change");
        populateTable();
        // TODO add your code here
    }

    private void button2MousePressed(MouseEvent e) {
        int selected=table1.getSelectedRow();

    }

    private void button4MouseEntered(MouseEvent e) {
        // TODO add your code here
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        this2 = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        label1 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        button6 = new JButton();
        button5 = new JButton();
        button4 = new JButton();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder( 0
        , 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM
        , new java .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) ,
         getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
        ) {if ("\u0062order" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
        setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]"));

        //======== this2 ========
        {
            this2.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]" +
                "[322,fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]",
                // rows
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]"));

            //======== scrollPane1 ========
            {

                //---- table1 ----
                table1.setModel(new DefaultTableModel(
                    new Object[][] {
                        {null, null},
                    },
                    new String[] {
                        "name", "age"
                    }
                ));
                scrollPane1.setViewportView(table1);
            }
            this2.add(scrollPane1, "cell 1 1 1 10");

            //---- label2 ----
            label2.setText("name");
            this2.add(label2, "cell 2 4");
            this2.add(textField2, "cell 3 4");

            //---- label3 ----
            label3.setText("age");
            this2.add(label3, "cell 2 6");
            this2.add(textField3, "cell 3 6");

            //---- label1 ----
            label1.setText("house");
            this2.add(label1, "cell 2 8");
            this2.add(textField1, "cell 3 8");

            //---- button1 ----
            button1.setText("add");
            button1.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    button1MousePressed(e);
                }
            });
            this2.add(button1, "cell 3 10");

            //---- button6 ----
            button6.setText("delete");
            button6.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    button6MousePressed(e);
                }
            });
            this2.add(button6, "cell 1 11");

            //---- button5 ----
            button5.setText("save");
            button5.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    button5MousePressed(e);
                }
            });
            this2.add(button5, "cell 1 13");

            //---- button4 ----
            button4.setText("Refresh");
            button4.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    button4MouseEntered(e);
                }
                @Override
                public void mousePressed(MouseEvent e) {
                    button4MousePressed(e);
                }
            });
            this2.add(button4, "cell 1 15");
        }
        add(this2, "cell 0 0");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel this2;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JTextField textField3;
    private JLabel label1;
    private JTextField textField1;
    private JButton button1;
    private JButton button6;
    private JButton button5;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
