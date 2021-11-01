/*
 * Created by JFormDesigner on Sat Oct 30 18:23:48 EDT 2021
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
public class PersonPanel extends JPanel {

    PersonDirectory personDirectory;
    System system;
    public PersonPanel(System system) {
        initComponents();
        this.personDirectory =system.getPersonDirectory();
        populateTable();
        table1.getTableHeader().setBackground(new Color(255, 255, 255, 0));
    }
    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        model.setRowCount(0);
        for (Person vs : personDirectory.getPersonList()) {
            Object[] row = new Object[3];
            row[0] = vs.getName();
            row[1] = vs.getAge();
            row[2]=vs.getHouse();

            model.addRow(row);
        }

    }

    private void button3MousePressed(MouseEvent e) {
        if(textField1.getText().equals("")||textField3.getText().equals("")||textField2.getText().equals("")){
            JOptionPane.showMessageDialog(this,"empty input");
            textField1.setText("");
            textField2.setText("");
            textField3.setText("");
            return;
        }
        String temp_1 = textField1.getText();
        for(int i=0 ; i<temp_1.length() ; i++){
            if(!Character.isDigit(temp_1.charAt(i))){
                JOptionPane.showMessageDialog(this,"wrong input of age");
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                return;
            }
        }
        String name = textField3.getText();
        int age = Integer.parseInt(textField1.getText());
        Person person = new Person();
        for(int i=0 ; i<name.length() ; i++){
            if(!Character.isAlphabetic(name.charAt(i))){
                JOptionPane.showMessageDialog(this,"wrong input of name");
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                return;
            }
        }
        String house = textField2.getText();
        person.setAge(age);
        person.setName(name);
        person.setHouse(house);
        personDirectory.addNewPerson(person);
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        JOptionPane.showMessageDialog(null,"New Person added.");
        // TODO add your code here
    }

    private void button2MousePressed(MouseEvent e) {
        populateTable();
    }

    private void button1MousePressed(MouseEvent e) {
        int selected=table1.getSelectedRow();
        if(selected<0){
            JOptionPane.showMessageDialog(this,"please select a row");
            return;
        }
        DefaultTableModel model_1=(DefaultTableModel)table1.getModel();
//        Car selectedCar=(Car) model_1.getValueAt(selected,0);
        personDirectory.deletePerson(selected);
        JOptionPane.showMessageDialog(this,"Person deleted");
        populateTable();
        // TODO add your code here
    }

    private void button4MousePressed(MouseEvent e) {
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        personDirectory.getPersonList();
        for(int i = 0; i<model.getRowCount(); i++) {
            for (int j = 0; j < model.getColumnCount(); j++) {
                if (j == 0) {
                    String temp_name = (String) model.getValueAt(i, j);
                    for (int g = 0; g < temp_name.length(); g++) {
                        if (!Character.isAlphabetic(temp_name.charAt(i))) {
                            JOptionPane.showMessageDialog(this, "wrong input of name");
                            return;
                        }
                    }
                    personDirectory.getPerson(i).setName(temp_name);
                }
                if(j==1){
                        String temp_age = (String) model.getValueAt(i, j);
                        for (int g = 0; g < temp_age.length(); g++) {
                            if (!Character.isDigit(temp_age.charAt(i))) {
                                JOptionPane.showMessageDialog(this, "wrong input of age");

                                return;
                            }
                        }
                        int age1 = Integer.parseInt(temp_age);
                        personDirectory.getPerson(i).setAge(age1);
                    }
                if(j==2){
                    String house = (String) model.getValueAt(i, j);
                    personDirectory.getPerson(i).setHouse(house);
                }
                }
            }
        JOptionPane.showMessageDialog(this,"successful change");
        populateTable();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        this2 = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button4 = new JButton();
        label1 = new JLabel();
        textField2 = new JTextField();
        label2 = new JLabel();
        textField3 = new JTextField();
        label3 = new JLabel();
        textField1 = new JTextField();
        button3 = new JButton();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(
        0,0,0,0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion",javax.swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder
        .BOTTOM,new java.awt.Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt.Color.
        red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.
        beans.PropertyChangeEvent e){if("bord\u0065r".equals(e.getPropertyName()))throw new RuntimeException();}});
        setLayout(new MigLayout(
            "hidemode 3",
            // columns
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
            "[]"));

        //======== this2 ========
        {
            this2.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]" +
                "[251,fill]",
                // rows
                "[]" +
                "[114]" +
                "[]" +
                "[]" +
                "[]"));

            //======== scrollPane1 ========
            {

                //---- table1 ----
                table1.setModel(new DefaultTableModel(
                    new Object[][] {
                        {null, null, null},
                    },
                    new String[] {
                        "name", "age", "house"
                    }
                ));
                scrollPane1.setViewportView(table1);
            }
            this2.add(scrollPane1, "cell 1 1");

            //---- button1 ----
            button1.setText("delete");
            button1.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    button1MousePressed(e);
                }
            });
            this2.add(button1, "cell 1 2");

            //---- button2 ----
            button2.setText("refresh");
            button2.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    button2MousePressed(e);
                }
            });
            this2.add(button2, "cell 1 3");

            //---- button4 ----
            button4.setText("save");
            button4.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    button4MousePressed(e);
                }
            });
            this2.add(button4, "cell 1 4");
        }
        add(this2, "cell 0 0 1 9");

        //---- label1 ----
        label1.setText("house");
        add(label1, "cell 1 1");
        add(textField2, "cell 2 1");

        //---- label2 ----
        label2.setText("name");
        add(label2, "cell 1 2");
        add(textField3, "cell 2 2");

        //---- label3 ----
        label3.setText("age");
        add(label3, "cell 1 3");
        add(textField1, "cell 2 3");

        //---- button3 ----
        button3.setText("add");
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button3MousePressed(e);
            }
        });
        add(button3, "cell 2 4");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel this2;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    private JButton button4;
    private JLabel label1;
    private JTextField textField2;
    private JLabel label2;
    private JTextField textField3;
    private JLabel label3;
    private JTextField textField1;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
