package lab7;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class lab7_3 implements ActionListener {
    JLabel numberLabel;
    JTextField numberField;
    JButton btn1, btn2, btn3;
    JFrame window;

    public lab7_3() {
        // obtain content pane and set its layout to FlowLayout
        window = new JFrame("Programm Show Text");
        Container container = window.getContentPane();
        container.setLayout(new FlowLayout());

        // create numberLabel and attach it to content pane
        numberLabel = new JLabel("Show Number : ");
        container.add(numberLabel);
        numberField = new JTextField(10);
        // numberField.setEditable( false );
        container.add(numberField);
        btn1 = new JButton(" 1 ");
        btn1.addActionListener(this);
        container.add(btn1);
        btn2 = new JButton(" 2 ");
        btn2.addActionListener(this);
        container.add(btn2);
        btn3 = new JButton(" 3 ");
        btn3.addActionListener(this);
        container.add(btn3);
        window.setSize(240, 120);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

    }

    public void actionPerformed(ActionEvent event) {
        String str = numberField.getText();
        if (event.getSource() == btn1) {
            str += "1";
            numberField.setText(str);
        } else if (event.getSource() == btn2) {
            str += "2";
            numberField.setText(str);
        } else if (event.getSource() == btn3) {
            str += "3";
            numberField.setText(str);
        }
    } // end method actionPerformed

    public static void main(String[] args) {
        lab7_3 gui = new lab7_3();
    }
}
