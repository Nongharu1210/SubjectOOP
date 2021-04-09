package lab11.lab11_01;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class lab11_01 extends JFrame implements ActionListener {
    private JButton year;
    private JTextField interestField, amountField;
    private Invest myMoney;

    public lab11_01() {
        super("Program Calculate Interest of Bank");
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(new JLabel("Enter amount : "));
        amountField = new JTextField(10);
        amountField.addActionListener(this);
        c.add(amountField);
        c.add(new JLabel("Enter interest rate : "));
        interestField = new JTextField(8);
        interestField.addActionListener(this);
        c.add(interestField);
        year = new JButton("Another Year");
        year.addActionListener(this);
        c.add(year);
        myMoney = new Invest();
    }

    public void paint(Graphics g) {
        super.paint(g);
        myMoney.displayInterest(g);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == amountField) {
            String s = amountField.getText();
            if (s.equals("") == false) {
                float amount = Float.parseFloat(s);
                myMoney.setAmount(amount);
            }
        } else if (event.getSource() == interestField) {
            String s = interestField.getText();
            if (s.equals("") == false) {
                float rate = Float.parseFloat(s);
                myMoney.setRate(rate);
            }
        } else {
            myMoney.anotherYear();
        }
        repaint();
    }

    public static void main(String[] args) {
        lab11_01 test = new lab11_01();
        test.setSize(300, 200);
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setVisible(true);
    }
}
