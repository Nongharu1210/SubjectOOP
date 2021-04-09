package lab11.lab11_03;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

public class lab11_3 extends JFrame implements ActionListener {
    Timer swTimer;
    Container container;
    JTextField inField;
    JLabel showJLabel;
    int x = 0, y = 0, w = 0, h = 0, Red = 0, Green = 0, Blue = 0;

    public lab11_3() {
        super("Program Using Timer");
        swTimer = new Timer(1000, this);
        swTimer.start();
        container = getContentPane();
        container.setLayout(new FlowLayout());
        showJLabel = new JLabel("Input Shape filloval, drawoval, fillRect, drawRect : ");
        container.add(showJLabel);
        inField = new JTextField(10);
        container.add(inField);
        inField.addActionListener(this);
    }

    public void paint(Graphics g) {
        super.paint(g);
         x = 20 + (int) (Math.random() * 720);
         y = 20 + (int) (Math.random() * 900);
         w = 50 + (int) (Math.random() * 1920);
         h = 50 + (int) (Math.random() * 1080);
         Red = (int) (Math.random() * 256);
         Green = (int) (Math.random() * 256);
         Blue = (int) (Math.random() * 256);
        g.setColor(new Color(Red, Green, Blue));
        // g.setColor(new Color(Lime, Fuchsia, Aqua));
        //g.drawOval(x, y, 20, 20);
    }


    public void actionPerformed(ActionEvent event) {
        Graphics g = getGraphics();
        if(event.getSource()==inField){
            if(inField.getText().equals("fillOval") || inField.getText().equals("fO")){
                paint(g);
                g.fillOval(x,y,w,h); 
            }else if(inField.getText().equals("drawOval") || inField.getText().equals("do")){
                paint(g);
                g.drawOval(x, y, w, h);
            }else if(inField.getText().equals("fillRect") || inField.getText().equals("fr")){
                paint(g);
                g.fillRect(x, y, w, h);
            }else if(inField.getText().equals("drawRect") || inField.getText().equals("dr")){
                paint(g);
                g.drawRect(x, y, w, h);
            }
        }  
    }

    public static void main(String[] args) {
        lab11_3 test = new lab11_3();
        test.setSize(480, 300);
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setVisible(true);
    }
}