package lab13.lab13_02;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class lab13_02 extends JFrame implements ActionListener {
    private Animation display;
    private JButton playBtn, stopBtn;

    public lab13_02() {
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        playBtn = new JButton("Play");
        playBtn.addActionListener(this);
        stopBtn = new JButton("Stop");
        stopBtn.addActionListener(this);
        display = new Animation();
        c.add(playBtn);
        c.add(stopBtn);
        c.add(display);
    }

    public void paint(Graphics g) {
        super.paint(g);
    }

    public void stop() {
        display.stop();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playBtn) {
            display.play();
            playBtn.setEnabled(false);
        } else if (e.getSource() == stopBtn) {
            display.stop();
            playBtn.setEnabled(true);
        }
    }

    public static void main(String[] args) {
        lab13_02 window = new lab13_02();
        window.setSize(400, 350);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
