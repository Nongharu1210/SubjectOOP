package lab11.lab11_04;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class lab11_04 extends JFrame {
    private JButton plainBtn, fancyBtn;

    public lab11_04() {
        super("Program Using Image on Button");
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        plainBtn = new JButton("Plain Button");
        c.add(plainBtn);
        // ImageIcon plane1 = new ImageIcon("d:/airplan201.gif");
        // ImageIcon plane2 = new ImageIcon("d:/airplan202.gif");
        
        //ตำแหน่ง file รูปภาพที่อยู่ภายในตัวเครื่อง
        ImageIcon plane1 = new ImageIcon("d:/SubjectOOP/lib/image/airplane201.gif");
        ImageIcon plane2 = new ImageIcon("d:/SubjectOOP/lib/image/airplane202.gif");

        // ImageIcon plane1 = new ImageIcon(
        // getClass().getResource("airplan201.gif") );
        // ImageIcon plane2 = new ImageIcon(
        // getClass().getResource("airplan202.gif") );
        
        fancyBtn = new JButton("Fancy Button", plane1);
        fancyBtn.setRolloverIcon(plane2);
        c.add(fancyBtn);
        ButtonHandler handler = new ButtonHandler();
        fancyBtn.addActionListener(handler);
        plainBtn.addActionListener(handler);
    }

    private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            JOptionPane.showMessageDialog(lab11_04.this, "You pressed : " + event.getActionCommand());
        }
    }

    public static void main(String[] args) {
        lab11_04 test = new lab11_04();
        test.setSize(280, 200);
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setVisible(true);
    }
}
