/*
 * Created by JFormDesigner on Sat Oct 30 12:40:12 EDT 2021
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
public class CityPanel extends JPanel {
    CityList cityList;
    System system;
    public CityPanel(System system) {
        initComponents();
        this.cityList = system.getCityList();
        populateTable();
        table1.getTableHeader().setBackground(new Color(255, 255, 255, 0));
    }

    private void button4MousePressed(MouseEvent e) {
        if(textField1.getText().equals("")){
            JOptionPane.showMessageDialog(this,"empty input");
            return;
        }
        String name = textField1.getText();
        for(int i=0 ; i<name.length() ; i++){
            if(!Character.isAlphabetic(name.charAt(i))){
                JOptionPane.showMessageDialog(this,"wrong input");
                textField1.setText("");
                return;
            }
        }
        City s = new City();
        s.setName(name);
        cityList.addNewCity(s);
        s.communityList=new CommunityList();
        JOptionPane.showMessageDialog(this,"city added");
        textField1.setText("");
    }

    private void button5MousePressed(MouseEvent e) {
        populateTable();
    }

    private void button2MousePressed(MouseEvent e) {
        int selected=table1.getSelectedRow();
        if(selected<0){
            JOptionPane.showMessageDialog(this,"please select a row");
            return;
        }
        DefaultTableModel model_1=(DefaultTableModel)table1.getModel();
//        Car selectedCar=(Car) model_1.getValueAt(selected,0);
        cityList.deleCity(selected);
        JOptionPane.showMessageDialog(this,"Person deleted");
        populateTable();
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label1 = new JLabel();
        textField1 = new JTextField();
        button2 = new JButton();
        button5 = new JButton();
        button4 = new JButton();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder( 0
        , 0, 0, 0) , "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM
        , new java .awt .Font ("D\u0069al\u006fg" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) ,
         getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
        ) {if ("\u0062or\u0064er" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
        setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[107,fill]" +
            "[96,fill]" +
            "[58,fill]" +
            "[fill]" +
            "[fill]" +
            "[0,fill]" +
            "[263,fill]",
            // rows
            "[]" +
            "[109]" +
            "[49]" +
            "[]" +
            "[]"));

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null},
                },
                new String[] {
                    "city's name"
                }
            ) {
                boolean[] columnEditable = new boolean[] {
                    false
                };
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            table1.setPreferredScrollableViewportSize(new Dimension(450, 300));
            table1.setShowHorizontalLines(false);
            scrollPane1.setViewportView(table1);
        }
        add(scrollPane1, "cell 0 1 4 2");

        //---- label1 ----
        label1.setText("create new city");
        add(label1, "cell 6 1");
        add(textField1, "cell 6 2");

        //---- button2 ----
        button2.setText("delete");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button2MousePressed(e);
            }
        });
        add(button2, "cell 1 3");

        //---- button5 ----
        button5.setText("refresh");
        button5.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button5MousePressed(e);
            }
        });
        add(button5, "cell 3 3");

        //---- button4 ----
        button4.setText("add new city");
        button4.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button4MousePressed(e);
            }
        });
        add(button4, "cell 6 3");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        model.setRowCount(0);
        for ( City vs : cityList.getCityList()) {
            Object[] row = new Object[1];
            row[0] = vs.getName();
            model.addRow(row);
        }
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label1;
    private JTextField textField1;
    private JButton button2;
    private JButton button5;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
