package lab8;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class lab8_3 extends JFrame implements ActionListener {
    JLabel textLabel;
    JTextField textField;
    JButton saveBtn, clearBtn, showBtn;
    JButton addBtn, subBtn, mulBtn, divBtn, perBtn, rootBtn, posBtn;
    Container container;
    NumberNew obj;

    public lab8_3() {
        super("Program Calculate Number");
        container = getContentPane();
        container.setLayout(new FlowLayout());
        textLabel = new JLabel("Enter number :");
        textLabel.setFont(new Font("Courier New", Font.BOLD, 20));
        container.add(textLabel);
        textField = new JTextField(10);
        textField.setFont(new Font("Courier New", Font.BOLD, 24));
        container.add(textField);
        saveBtn = new JButton(" Save ");
        saveBtn.setFont(new Font("Courier New", Font.BOLD, 20));
        saveBtn.addActionListener(this);
        container.add(saveBtn);
        clearBtn = new JButton(" Clear ");
        clearBtn.setFont(new Font("Courier New", Font.BOLD, 20));
        clearBtn.addActionListener(this);
        container.add(clearBtn);
        showBtn = new JButton(" Show ");
        showBtn.setFont(new Font("Courier New", Font.BOLD, 20));
        showBtn.addActionListener(this);
        container.add(showBtn);
        addBtn = new JButton(" + ");
        addBtn.setFont(new Font("Courier New", Font.BOLD, 20));
        addBtn.addActionListener(this);
        container.add(addBtn);
        subBtn = new JButton(" - ");
        subBtn.setFont(new Font("Courier New", Font.BOLD, 20));
        subBtn.addActionListener(this);
        container.add(subBtn);
        mulBtn = new JButton(" * ");
        mulBtn.setFont(new Font("Courier New", Font.BOLD, 20));
        mulBtn.addActionListener(this);
        container.add(mulBtn);
        divBtn = new JButton(" / ");
        divBtn.setFont(new Font("Courier New", Font.BOLD, 20));
        divBtn.addActionListener(this);
        container.add(divBtn);
/* ******************************************************************** */
        perBtn = new JButton(" % ");
        perBtn.setFont(new Font("Courier New", Font.BOLD, 20));
        perBtn.addActionListener(this);
        container.add(perBtn);

        rootBtn = new JButton("squ");
        rootBtn.setFont(new Font("Courier New", Font.BOLD, 20));
        rootBtn.addActionListener(this);
        container.add(rootBtn);

        posBtn = new JButton("+/-");
        posBtn.setFont(new Font("Courier New", Font.BOLD, 20));
        posBtn.addActionListener(this);
        container.add(posBtn);

        setSize(370, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        lab8_3 test = new lab8_3();
        // create obj of class NumberNew
        test.obj = new NumberNew();
        test.textField.setText(test.obj.toString());
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == saveBtn) {
            double value = Double.parseDouble(textField.getText());
            obj.setValue(value);
            textField.setText("");
        } else if (event.getSource() == clearBtn) {
            obj.setValue(0);
            textField.setText("");
        } else if (event.getSource() == showBtn) {
            textField.setText(obj.toString());
        } else if (event.getSource() == addBtn) {
            double value = Double.parseDouble(textField.getText());
            obj.add(value);
            textField.setText(obj.toString());
        } else if (event.getSource() == subBtn) {
            double value = Double.parseDouble(textField.getText());
            obj.subtract(value);
            textField.setText(obj.toString());
        } else if (event.getSource() == mulBtn) {
            double value = Double.parseDouble(textField.getText());
            obj.multiply(value);
            textField.setText(obj.toString());
        } else if (event.getSource() == divBtn) {
            double value = Double.parseDouble(textField.getText());
            obj.divide(value);
            textField.setText(obj.toString());
        } else if(event.getSource() == perBtn){
            double value = Double.parseDouble(textField.getText());
            obj.percent(value);
            textField.setText(obj.toString());
        } else if(event.getSource() == rootBtn){
            double value = Double.parseDouble(textField.getText());
            obj.squareroot(value);
            textField.setText(obj.toString());
        } else if(event.getSource() == posBtn){
            double value = Double.parseDouble(textField.getText());
            obj.positive(value);
            textField.setText(obj.toString());
        }
    }
}
