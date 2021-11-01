/*
 * Created by JFormDesigner on Sat Oct 30 16:41:23 EDT 2021
 */

package com.xiaoxiaohui;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import net.miginfocom.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author unknown
 */
public class CommunityPanel extends JPanel {
    CommunityList communityList;
    CityList cityList;
    PatientDirectory patientDirectory;
    System system;

    public CommunityPanel(System system) {
        initComponents();
        this.cityList = system.getCityList();
        this.patientDirectory = system.getPatientDirectory();
        populateTable();
        table1.getTableHeader().setBackground(new Color(255, 255, 255, 0));
    }

    private void button1MousePressed(MouseEvent e) {
        populateTable();
    }

    private void button4MousePressed(MouseEvent e) {
        int selected = table1.getSelectedRow();
        if (selected < 0) {
            JOptionPane.showMessageDialog(this, "please select a row");
            return;
        }
        DefaultTableModel model_1 = (DefaultTableModel) table1.getModel();
//        Car selectedCar=(Car) model_1.getValueAt(selected,0);
        communityList.deletCommunity(selected);
        JOptionPane.showMessageDialog(this, "Person deleted");
        populateTable();
    }

    private void button3MousePressed(MouseEvent e) {
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            String temp_name = (String) model.getValueAt(i, 0);
            int x = 0;
            while(x<cityList.getCityList().size()&&!temp_name.equals(cityList.getCity(x).getName())){
                x++;
            }
            if(x>=cityList.getCityList().size()){
                JOptionPane.showMessageDialog(this, "no such city");
                return;
            }
            for(int j = 1 ;j<model.getColumnCount();j++){
                String temp = (String) model.getValueAt(i,j);
                for (int g = 0; g < temp_name.length(); g++) {
                    if (!Character.isAlphabetic(temp_name.charAt(i))) {
                        JOptionPane.showMessageDialog(this, "wrong input of age");
                        return;
                    }
                }
                cityList.getCity(x).communityList.getCommunity(i-x).setName(temp);
            }
        }
        JOptionPane.showMessageDialog(this, "successful change");
        populateTable();
    }

    private void button2MousePressed(MouseEvent e) {
        if(textField1.getText().equals("")||textField2.getText().equals("")){
            JOptionPane.showMessageDialog(this,"empty input");
            return;
        }
        String city_name=textField2.getText();
        int j = 0;
        while(j<cityList.getCityList().size()&&!cityList.getCity(j).getName().equals(city_name)){
            j++;
        }
        if(j==cityList.getCityList().size()){
            JOptionPane.showMessageDialog(this,"no such city");
            textField1.setText("");
            textField2.setText("");
            return;
        }
        String name = textField1.getText();
        for(int i=0 ; i<name.length() ; i++){
            if(!Character.isAlphabetic(name.charAt(i))){
                JOptionPane.showMessageDialog(this,"wrong input");
                textField1.setText("");
                textField2.setText("");
                return;
            }
        }
        Community s =new Community();
        s.setName(textField1.getText());
        cityList.getCity(j).communityList.addCommunity(s);
        JOptionPane.showMessageDialog(this,"city added");
        textField1.setText("");
        textField2.setText("");
    }

    private void button5MousePressed(MouseEvent e) {
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        int count = 0;
        boolean isAbnormal = false;
        int selected = table1.getSelectedRow();
        if (selected < 0) {
            JOptionPane.showMessageDialog(this, "please select a row");
            return;
        }
        String name = (String) model.getValueAt(selected,1);
        List<House> list =new ArrayList<>();
        List<Patient> list1 = new ArrayList<>();
        for(City s:cityList.getCityList()){
            for( Community v : s.communityList.getCommunityList()) {
                if (v.getName().equals(name)) {
                    if (v.getHouseList() == null) {
                        continue;
                    } else {
                        for (House x : v.getHouseList().houseList) {
                            list.add(x);
                        }
                        for (Patient y : patientDirectory.getPatientList()) {
                            for (House z : list) {
                                if (z.getName().equals(y.getPerson().getHouse())) {
                                    list1.add(y);
                                }
                            }
                        }
                        for (Patient g : list1) {
                            if (g.getEncounterHistory() == null) {
                                continue;
                            } else {
                                for (Encounter k : g.getEncounterHistory().getEncounterList()) {
                                    if (k.getVitalSigns().getLowbloodPressure() < 60 || k.getVitalSigns().getHighbloodPressure() > 120) {
                                        isAbnormal = true;
                                    }
                                }

                                if (isAbnormal) {
                                    count++;
                                }
                            }
                        }

                        }
                    }
                }

        }
        String number = String.valueOf(count);
        textField3.setText(number);
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        this2 = new JPanel();
        label3 = new JLabel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button5 = new JButton();
        textField3 = new JTextField();
        button1 = new JButton();
        button4 = new JButton();
        button3 = new JButton();
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        button2 = new JButton();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder
        (0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax.swing.border.TitledBorder.CENTER,javax.swing.border
        .TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt
        .Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void
        propertyChange(java.beans.PropertyChangeEvent e){if("\u0062ord\u0065r".equals(e.getPropertyName()))throw new RuntimeException()
        ;}});
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
                "[188,fill]" +
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
                "[]"));
            this2.add(label3, "cell 3 1");

            //======== scrollPane1 ========
            {

                //---- table1 ----
                table1.setModel(new DefaultTableModel(
                    new Object[][] {
                        {null, null},
                        {null, null},
                    },
                    new String[] {
                        "City name", "Community Name"
                    }
                ) {
                    boolean[] columnEditable = new boolean[] {
                        false, true
                    };
                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return columnEditable[columnIndex];
                    }
                });
                scrollPane1.setViewportView(table1);
            }
            this2.add(scrollPane1, "cell 1 2");

            //---- button5 ----
            button5.setText("search number");
            button5.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    button5MousePressed(e);
                }
            });
            this2.add(button5, "cell 2 2");
            this2.add(textField3, "cell 3 2");

            //---- button1 ----
            button1.setText("refresh");
            button1.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    button1MousePressed(e);
                }
            });
            this2.add(button1, "cell 1 3");

            //---- button4 ----
            button4.setText("delete");
            button4.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    button4MousePressed(e);
                }
            });
            this2.add(button4, "cell 1 5");

            //---- button3 ----
            button3.setText("save");
            button3.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    button3MousePressed(e);
                }
            });
            this2.add(button3, "cell 1 6");

            //---- label1 ----
            label1.setText("comunity name");
            this2.add(label1, "cell 0 8");
            this2.add(textField1, "cell 1 8");

            //---- label2 ----
            label2.setText("city name");
            this2.add(label2, "cell 0 9");
            this2.add(textField2, "cell 1 9");

            //---- button2 ----
            button2.setText("add");
            button2.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    button2MousePressed(e);
                }
            });
            this2.add(button2, "cell 3 9");
        }
        add(this2, "cell 0 0");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        model.setRowCount(0);
        for (City vs : cityList.getCityList() ) {
            for (Community s : vs.communityList.getCommunityList()) {
                Object[] row = new Object[2];
                row[1] = s.getName();
                row[0] = vs.getName();
                model.addRow(row);
            }
        }

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel this2;
    private JLabel label3;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button5;
    private JTextField textField3;
    private JButton button1;
    private JButton button4;
    private JButton button3;
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
