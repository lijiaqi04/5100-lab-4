/*
 * Created by JFormDesigner on Sat Oct 30 19:22:21 EDT 2021
 */

package com.xiaoxiaohui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import net.miginfocom.swing.*;

/**
 * @author unknown
 */
public class VitalPanel extends JPanel {

    PatientDirectory patientDirectory;
    System system;
    public VitalPanel( System system) {
        initComponents();
        this.patientDirectory = system.patientDirectory;
        populateTable();
        table1.getTableHeader().setBackground(new Color(255, 255, 255, 0));
    }


    private void button3MousePressed(MouseEvent e) {
        if(textField1.getText().equals("")||textField3.getText().equals("")||textField2.getText().equals("")||textField4.getText().equals("")||textField5.getText().equals("")||textField6.getText().equals("")){
            JOptionPane.showMessageDialog(this,"empty input");
            textField1.setText("");
            textField2.setText("");
            textField3.setText("");
            textField4.setText("");
            textField5.setText("");
            textField6.setText("");
            return;
        }
        int i =0;


        String temp_4 = textField4.getText();
        for(i=0 ; i<temp_4.length() ; i++){
            if(!Character.isDigit(temp_4.charAt(i))){
                JOptionPane.showMessageDialog(this,"wrong input of pulse rate");
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
                textField5.setText("");
                textField6.setText("");
                return;
            }
        }

        String temp_2 = textField2.getText();
        for(i=0 ; i<temp_2.length() ; i++){
            if(!Character.isDigit(temp_2.charAt(i))){
                JOptionPane.showMessageDialog(this,"wrong input of blood pressure");
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
                textField5.setText("");
                textField6.setText("");
                return;
            }
        }

        String temp_3 = textField3.getText();
        for(i=0 ; i<temp_3.length() ; i++){
            if(!Character.isDigit(temp_3.charAt(i))){
                JOptionPane.showMessageDialog(this,"wrong input of temperature");
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
                textField5.setText("");
                textField6.setText("");
                return;
            }
        }

        String temp_1 = textField1.getText();
        for(i=0 ; i<temp_1.length() ; i++){
            if(!Character.isDigit(temp_1.charAt(i))){
                JOptionPane.showMessageDialog(this,"wrong input of respiration rate");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
                textField5.setText("");
                textField6.setText("");
                textField1.setText("");
                return;
            }
        }
        String temp_5 = textField5.getText();
        i =0;
        while(i<patientDirectory.getPatientList().size()&&!patientDirectory.getPatientList().get(i).person.getName().equals(temp_5)){
            i++;
        }
        if(i>=patientDirectory.getPatientList().size()){
            textField1.setText("");
            textField2.setText("");
            textField3.setText("");
            textField4.setText("");
            textField5.setText("");
            JOptionPane.showMessageDialog(this,"wrong input of name");
            return;
        }
        int temp = i ;

        String temp_6 = textField6.getText();
        for(i=0 ; i<temp_1.length() ; i++){
            if(!Character.isDigit(temp_1.charAt(i))){
                JOptionPane.showMessageDialog(this,"wrong input of low blood pressure");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
                textField5.setText("");
                textField6.setText("");
                textField1.setText("");
                return;
            }

        }
        if(Integer.parseInt(temp_6)<=Integer.parseInt(temp_2)){
            JOptionPane.showMessageDialog(this,"high pressure is lower than low pressure");
            return;
        }


        Encounter encounter = new Encounter();
        Vital_Signs vital_signs =new Vital_Signs();
        vital_signs.setLowbloodPressure(Integer.parseInt(temp_2));
        vital_signs.setHighbloodPressure(Integer.parseInt(temp_6));
        vital_signs.setPulseRate(Integer.parseInt(temp_4));
        vital_signs.setRespirationRate(Integer.parseInt(temp_1));
        vital_signs.setTemperature(Integer.parseInt(temp_3));
        encounter.vitalSigns = vital_signs;


        patientDirectory.getPatient(temp).encounterHistory.addEncouter(encounter);
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        textField5.setText("");
        textField1.setText("");
        textField6.setText("");
        JOptionPane.showMessageDialog(null,"New vital signs  added.");
        // TODO add your code here
    }
    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        model.setRowCount(0);
        for (Patient vs : patientDirectory.getPatientList()) {
            if (vs.getEncounterHistory() == null) {
                continue;
            } else {
                for (Encounter s : vs.getEncounterHistory().getEncounterList()) {
                    Object[] row = new Object[6];
                    row[0] = vs.person.getName();
                    row[1] = s.vitalSigns.getPulseRate();
                    row[4] = s.vitalSigns.getHighbloodPressure();
                    row[5] = s.vitalSigns.getLowbloodPressure();
                    row[2] = s.vitalSigns.getTemperature();
                    row[3] = s.vitalSigns.getRespirationRate();
                    model.addRow(row);
                }
            }
        }

    }

    private void button2MousePressed(MouseEvent e) {
        populateTable();
    }

    private void button1MousePressed(MouseEvent e) {
        // TODO add your code here
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        this2 = new JPanel();
        this3 = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        label1 = new JLabel();
        textField4 = new JTextField();
        label4 = new JLabel();
        textField2 = new JTextField();
        label5 = new JLabel();
        textField6 = new JTextField();
        label2 = new JLabel();
        textField3 = new JTextField();
        label3 = new JLabel();
        textField1 = new JTextField();
        label6 = new JLabel();
        textField5 = new JTextField();
        button3 = new JButton();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(
        0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax.swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder
        .BOTTOM,new java.awt.Font("D\u0069alog",java.awt.Font.BOLD,12),java.awt.Color.
        red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.
        beans.PropertyChangeEvent e){if("\u0062order".equals(e.getPropertyName()))throw new RuntimeException();}});
        setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[831,fill]" +
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
                "[680,fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]",
                // rows
                "[113]" +
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

            //======== this3 ========
            {
                this3.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[fill]" +
                    "[547,fill]",
                    // rows
                    "[0]" +
                    "[152]" +
                    "[]" +
                    "[]" +
                    "[]"));

                //======== scrollPane1 ========
                {

                    //---- table1 ----
                    table1.setModel(new DefaultTableModel(
                        new Object[][] {
                            {null, null, null, null, null, null},
                        },
                        new String[] {
                            "patient name", "Pulse Rate", "Temperature", "Respiration Rate", "high Blood Pressure", "low blood presure"
                        }
                    ) {
                        boolean[] columnEditable = new boolean[] {
                            false, false, false, false, false, true
                        };
                        @Override
                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return columnEditable[columnIndex];
                        }
                    });
                    scrollPane1.setViewportView(table1);
                }
                this3.add(scrollPane1, "cell 1 0 1 2");

                //---- button1 ----
                button1.setText("delete");
                button1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        button1MousePressed(e);
                    }
                });
                this3.add(button1, "cell 1 2");

                //---- button2 ----
                button2.setText("refresh");
                button2.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        button2MousePressed(e);
                    }
                });
                this3.add(button2, "cell 1 3");
            }
            this2.add(this3, "cell 0 1 1 7");

            //---- label1 ----
            label1.setText("pulse rate");
            this2.add(label1, "cell 1 1");
            this2.add(textField4, "cell 3 1");

            //---- label4 ----
            label4.setText("low blood pressure");
            this2.add(label4, "cell 1 2");
            this2.add(textField2, "cell 3 2");

            //---- label5 ----
            label5.setText("high blood pressure");
            this2.add(label5, "cell 1 3");
            this2.add(textField6, "cell 3 3");

            //---- label2 ----
            label2.setText("temperature");
            this2.add(label2, "cell 1 4");
            this2.add(textField3, "cell 3 4");

            //---- label3 ----
            label3.setText("respiration rate");
            this2.add(label3, "cell 1 5");
            this2.add(textField1, "cell 3 5");

            //---- label6 ----
            label6.setText("patient name");
            this2.add(label6, "cell 1 6");
            this2.add(textField5, "cell 3 6");

            //---- button3 ----
            button3.setText("add");
            button3.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    button3MousePressed(e);
                }
            });
            this2.add(button3, "cell 3 7");
        }
        add(this2, "cell 0 0");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel this2;
    private JPanel this3;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    private JLabel label1;
    private JTextField textField4;
    private JLabel label4;
    private JTextField textField2;
    private JLabel label5;
    private JTextField textField6;
    private JLabel label2;
    private JTextField textField3;
    private JLabel label3;
    private JTextField textField1;
    private JLabel label6;
    private JTextField textField5;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
