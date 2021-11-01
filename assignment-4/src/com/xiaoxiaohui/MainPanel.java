/*
 * Created by JFormDesigner on Sat Oct 30 11:58:27 EDT 2021
 */

package com.xiaoxiaohui;

import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author unknown
 */
public class MainPanel extends JPanel {
    System system;
    public MainPanel() {
        initComponents();
        system = new System();
        system.createPatienDirectory();
        system.createCityList();
    }

    private void button4MousePressed(MouseEvent e) {
        CityPanel c= new CityPanel(system);
        splitPane1.setRightComponent(c);
    }

    private void button5MousePressed(MouseEvent e) {
        PersonPanel c=new PersonPanel(system);
        splitPane1.setRightComponent(c);
    }

    private void button6MousePressed(MouseEvent e) {
        PatienPanel c =new PatienPanel(system);
        splitPane1.setRightComponent(c);
    }

    private void button7MousePressed(MouseEvent e) {
        CommunityPanel c=new CommunityPanel(system);
        splitPane1.setRightComponent(c);
    }

    private void button1MousePressed(MouseEvent e) {
        VitalPanel c = new VitalPanel(system);
        splitPane1.setRightComponent(c);
    }

    private void button2MousePressed(MouseEvent e) {
        housePanel c = new housePanel(system);
        splitPane1.setRightComponent(c);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        splitPane1 = new JSplitPane();
        panel3 = new JPanel();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        button1 = new JButton();
        button2 = new JButton();
        panel4 = new JPanel();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (
        new javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn"
        , javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM
        , new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 )
        , java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (
        new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
        ) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( )
        ; }} );
        setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[667,fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[376]" +
            "[]"));

        //======== splitPane1 ========
        {

            //======== panel3 ========
            {
                panel3.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[127,fill]" +
                    "[fill]",
                    // rows
                    "[84]" +
                    "[57]" +
                    "[94]" +
                    "[76]" +
                    "[91]" +
                    "[]"));

                //---- button4 ----
                button4.setText("city");
                button4.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        button4MousePressed(e);
                    }
                });
                panel3.add(button4, "cell 0 0");

                //---- button5 ----
                button5.setText("person");
                button5.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        button5MousePressed(e);
                    }
                });
                panel3.add(button5, "cell 0 1");

                //---- button6 ----
                button6.setText("patient");
                button6.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        button6MousePressed(e);
                    }
                });
                panel3.add(button6, "cell 0 2");

                //---- button7 ----
                button7.setText("community");
                button7.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        button7MousePressed(e);
                    }
                });
                panel3.add(button7, "cell 0 3");

                //---- button1 ----
                button1.setText("vital signs");
                button1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        button1MousePressed(e);
                    }
                });
                panel3.add(button1, "cell 0 4");

                //---- button2 ----
                button2.setText("house");
                button2.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        button2MousePressed(e);
                    }
                });
                panel3.add(button2, "cell 0 5");
            }
            splitPane1.setLeftComponent(panel3);

            //======== panel4 ========
            {
                panel4.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[25,fill]" +
                    "[15,fill]",
                    // rows
                    "[]" +
                    "[]" +
                    "[]"));
            }
            splitPane1.setRightComponent(panel4);
        }
        add(splitPane1, "cell 0 0 3 3");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    public static void main(String args[]){
//    Main main = new Main();
        MainPanel main = new MainPanel();
//        TestPanel main = new TestPanel();
//        main
//        textField1.setText(text);
        JFrame frame =new JFrame();
        frame.add(main);
        frame.setVisible(true);
        frame.setSize(800,600);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JSplitPane splitPane1;
    private JPanel panel3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button1;
    private JButton button2;
    private JPanel panel4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
