package TestLab;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class lab7_3 implements ActionListener {
    JLabel numberLabel;
    JTextField numberField;
    JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btna, btnb, btnc, btnd, btne, btnExit;
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

        btn4 = new JButton(" 4 ");
        btn4.addActionListener(this);
        container.add(btn4);

        btn5 = new JButton(" 5 ");
        btn5.addActionListener(this);
        container.add(btn5);

        btn6 = new JButton(" 6 ");
        btn6.addActionListener(this);
        container.add(btn6);

        btn7 = new JButton(" 7 ");
        btn7.addActionListener(this);
        container.add(btn7);

        btn8 = new JButton(" 8 ");
        btn8.addActionListener(this);
        container.add(btn8);

        btn9 = new JButton(" 9 ");
        btn9.addActionListener(this);
        container.add(btn9);

        btn0 = new JButton(" 0 ");
        btn0.addActionListener(this);
        container.add(btn0);

        //+-*/
        btna = new JButton(" + ");
        btna.addActionListener(this);
        container.add(btna);

        btnb = new JButton(" - ");
        btnb.addActionListener(this);
        container.add(btnb);

        btnc = new JButton(" * ");
        btnc.addActionListener(this);
        container.add(btnc);

        btnd = new JButton(" / ");
        btnd.addActionListener(this);
        container.add(btnd);

        btne = new JButton(" = ");
        btne.addActionListener(this);
        container.add(btne);

        //exit
        btnExit = new JButton(" Exit ");
        btnExit.addActionListener(this);
        container.add(btnExit);

        window.setSize(240, 200);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

    }

    public void actionPerformed(ActionEvent event) {
        String str = numberField.getText();
        int num, sum;
        if (event.getSource() == btn1) {
            str += "1";
            num = 1;
            numberField.setText(str);
        } else if (event.getSource() == btn2) {
            str += "2";
            num = 2;
            numberField.setText(str);
        } else if (event.getSource() == btn3) {
            str += "3";
            num = 3;
            numberField.setText(str);
        } else if (event.getSource() == btn4) {
            str += "4";
            num = 4;
            numberField.setText(str);
        }else if (event.getSource() == btn5) {
            str += "5";
            num = 5;
            numberField.setText(str);
        }else if (event.getSource() == btn6) {
            str += "6";
            num = 6;
            numberField.setText(str);
        }else if (event.getSource() == btn7) {
            str += "7";
            num = 7;
            numberField.setText(str);
        }else if (event.getSource() == btn8) {
            str += "8";
            num = 8;
            numberField.setText(str);
        }else if (event.getSource() == btn9) {
            str += "9";
            num = 9;
            numberField.setText(str);
        }else if (event.getSource() == btn0) {
            str += "0";
            num = 0;
            numberField.setText(str);
        }else if (event.getSource() == btna) {
            str += "+";
            // sum = num + num;
            numberField.setText(str);
        }else if (event.getSource() == btnb) {
            str += "-";
            // sum = num - num;
            numberField.setText(str);
        }else if (event.getSource() == btnc) {
            str += "*";
            // sum = num * num;
            numberField.setText(str);
        }else if (event.getSource() == btnd) {
            str += "/";
            // sum = num / num;
            numberField.setText(str);
        }else if (event.getSource() == btne) {
            str += "=";
            numberField.setText(str);
        }else if (event.getSource() == btnExit) {
            System.exit(0);
        }
        
    } // end method actionPerformed

    public static void main(String[] args) {
        lab7_3 gui = new lab7_3();
    }
}
