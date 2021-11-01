/*
 * Created by JFormDesigner on Sun Oct 31 18:44:25 EDT 2021
 */

package com.xiaoxiaohui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;
import net.miginfocom.swing.*;

/**
 * @author unknown
 */
public class housePanel extends JPanel {
    HouseList houseList;
    CommunityList communityList;
    CityList cityList;
    System system;
    public housePanel( System system) {
        initComponents();
        this.houseList = new HouseList();
        List<House> list =new ArrayList<>();
        this.cityList = system.getCityList();
        this.communityList=new CommunityList();
        for(City s:cityList.getCityList()){
            for( Community v : s.communityList.getCommunityList()) {
                if (v.getHouseList() == null) {
                    this.communityList.addCommunity(v);
                    continue;
                } else {
                    this.communityList.addCommunity(v);
                    for (House x : v.getHouseList().houseList) {
                        list.add(x);
                    }
                }
            }
        }
        houseList.setHouseList(list);
        populateTable();
        table1.getTableHeader().setBackground(new Color(255, 255, 255, 0));
    }


    private void button1MousePressed(MouseEvent e) {
        populateTable();
        // TODO add your code here
    }

    private void button4MousePressed(MouseEvent e) {
        int selected = table1.getSelectedRow();
        if (selected < 0) {
            JOptionPane.showMessageDialog(this, "please select a row");
            return;
        }
        DefaultTableModel model_1 = (DefaultTableModel) table1.getModel();
//        Car selectedCar=(Car) model_1.getValueAt(selected,0);
        houseList.deleteHouse(selected);
        JOptionPane.showMessageDialog(this, "Person deleted");
        populateTable();
    }

    private void button3MousePressed(MouseEvent e) {
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            String temp_name = (String) model.getValueAt(i, 1);
            int x = 0;
            while(x<communityList.getCommunityList().size()&&!temp_name.equals(communityList.getCommunity(x).getName())){
                x++;
            }
            if(x>=communityList.getCommunityList().size()){
                JOptionPane.showMessageDialog(this, "no such community");
                return;
            }
            houseList.getHouse(i).setCommunity(temp_name);

            String temp = (String) model.getValueAt(i,0);
            houseList.getHouse(i).setName(temp);
        }
        JOptionPane.showMessageDialog(this, "successful change");
        populateTable();
        // TODO add your code here
    }

    private void button2MousePressed(MouseEvent e) {
        if(textField1.getText().equals("")||textField2.getText().equals("")){
            JOptionPane.showMessageDialog(this,"empty input");
            return;
        }
        String community_name=textField1.getText();
        int j = 0;
        while(j<communityList.getCommunityList().size()&&!communityList.getCommunity(j).getName().equals(community_name)){
            j++;
        }
        if(j==communityList.getCommunityList().size()){
            JOptionPane.showMessageDialog(this,"no such community");
            textField1.setText("");
            textField2.setText("");
            return;
        }
        String name = textField2.getText();
        House s= new House();
        s.setCommunity(textField1.getText());
        s.setName(textField2.getText());
        houseList.addHouse(s);
        JOptionPane.showMessageDialog(this,"house added");
        textField1.setText("");
        textField2.setText("");

        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        this2 = new JPanel();
        this3 = new JPanel();
        label3 = new JLabel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button4 = new JButton();
        button3 = new JButton();
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        button2 = new JButton();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder(
        0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder
        . BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt. Color.
        red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .
        beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
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
                "[531,fill]" +
                "[fill]",
                // rows
                "[]" +
                "[]" +
                "[]"));

            //======== this3 ========
            {
                this3.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[fill]" +
                    "[285,fill]" +
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
                this3.add(label3, "cell 3 1");

                //======== scrollPane1 ========
                {

                    //---- table1 ----
                    table1.setModel(new DefaultTableModel(
                        new Object[][] {
                            {null, null},
                            {null, null},
                        },
                        new String[] {
                            "house name", "Community Name"
                        }
                    ));
                    scrollPane1.setViewportView(table1);
                }
                this3.add(scrollPane1, "cell 1 2");

                //---- button1 ----
                button1.setText("refresh");
                button1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        button1MousePressed(e);
                    }
                });
                this3.add(button1, "cell 1 3");

                //---- button4 ----
                button4.setText("delete");
                button4.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        button4MousePressed(e);
                    }
                });
                this3.add(button4, "cell 1 5");

                //---- button3 ----
                button3.setText("save");
                button3.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        button3MousePressed(e);
                    }
                });
                this3.add(button3, "cell 1 6");

                //---- label1 ----
                label1.setText("comunity name");
                this3.add(label1, "cell 0 8");
                this3.add(textField1, "cell 1 8");

                //---- label2 ----
                label2.setText("house name");
                this3.add(label2, "cell 0 9");
                this3.add(textField2, "cell 1 9");

                //---- button2 ----
                button2.setText("add");
                button2.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        button2MousePressed(e);
                    }
                });
                this3.add(button2, "cell 3 9");
            }
            this2.add(this3, "cell 0 0");
        }
        add(this2, "cell 0 0 2 1");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        model.setRowCount(0);
        for(House vs:houseList.getHouseList()) {
                Object[] row = new Object[2];
                row[1] = vs.getCommunity();
                row[0] = vs.getName();
                model.addRow(row);
        }

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel this2;
    private JPanel this3;
    private JLabel label3;
    private JScrollPane scrollPane1;
    private JTable table1;
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
