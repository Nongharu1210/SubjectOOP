// package lab13.lab13_03;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class lab13_03 extends JFrame implements ActionListener {
    private Clock time;
    private JButton playBtn, stopBtn, setBtn, alarmBtn, okBtn;
    private JTextField hourTextField, minuteTextField, secondTextField;
    private JLabel hourLabel, minuteLabel, secondLabel, periodLabel;
    private JComboBox<String> pComboBox;
    private String[] p = {"AM","PM"};
    private JPanel p1,p2;
    
    private int mode = 0;

    public lab13_03() {
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        p1 = new JPanel();
        p2 = new JPanel();
        playBtn = new JButton("Start Time");
        playBtn.addActionListener(this);
        stopBtn = new JButton("Stop Time");
        stopBtn.addActionListener(this);
        setBtn = new JButton("Set Time");
        setBtn.addActionListener(this);
        alarmBtn = new JButton("Set Alarm");
        alarmBtn.addActionListener(this);
        time = new Clock();
        p1.add(playBtn);
        p1.add(stopBtn);
        p1.add(setBtn);
        p1.add(alarmBtn);
        p1.add(time);
        p1.setPreferredSize(new Dimension(400,400));
        hourLabel = new JLabel("Hour");
        hourTextField = new JTextField(5);
        p2.add(hourLabel);
        p2.add(hourTextField);
        minuteLabel = new JLabel("Minute");
        minuteTextField = new JTextField(5);
        p2.add(minuteLabel);
        p2.add(minuteTextField);
        secondLabel = new JLabel("Second");
        secondTextField = new JTextField(5);
        p2.add(secondLabel);
        p2.add(secondTextField);
        periodLabel = new JLabel("Period");
        pComboBox = new JComboBox<String>(p);
        p2.add(periodLabel);
        p2.add(pComboBox);
        okBtn = new JButton("OK");
        okBtn.addActionListener(this);
        p2.add(okBtn);
        p2.setPreferredSize(new Dimension(120,300));
        p2.setVisible(false);
        c.add(p1);
        c.add(p2);
    }

    public void paint(Graphics g) {
        super.paint(g);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playBtn) {
            time.start();
            playBtn.setEnabled(false);
        }
        else if (e.getSource() == stopBtn) {
            time.stop();
            playBtn.setEnabled(true);
        }
        else if (e.getSource() == setBtn) {
            hourTextField.setText(""+time.getHour());
            minuteTextField.setText(""+time.getMinute());
            secondTextField.setText(""+time.getSecond());
            if(time.getPeriod() == true) pComboBox.setSelectedIndex(0);
            else pComboBox.setSelectedIndex(1);
            p2.setVisible(true);
            p1.setVisible(false);
        }
        else if (e.getSource() == okBtn) {
            int h = Integer.parseInt(hourTextField.getText());
            int m = Integer.parseInt(minuteTextField.getText());
            int s = Integer.parseInt(secondTextField.getText());
            boolean p;
            if(mode == 0){
                if(pComboBox.getSelectedIndex() == 0) p = true;
                else p = false;
                time.setHour(h);
                time.setMinute(m);
                time.setSecond(s);
                time.setPeriod(p);
            }
            else{
                time.setAlarm(h, m);
            }
            p2.setVisible(false);
            p1.setVisible(true);
            mode = 0;
        }
        else if(e.getSource() == alarmBtn){
            mode = 1;
            hourTextField.setText("8");
            minuteTextField.setText("00");
            secondTextField.setText("00");
            pComboBox.setSelectedIndex(0);
            p2.setVisible(true);
            p1.setVisible(false);
        }
    }
    public static void main(String[] args) {
        lab13_03 window = new lab13_03();
        window.setSize(420,420);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}