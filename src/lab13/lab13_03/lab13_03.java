package lab13.lab13_03;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class lab13_03 extends JApplet implements ActionListener {
    private Clock time;
    private JButton playBtn, stopBtn;

    public void init() {
        setSize(400, 400);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        playBtn = new JButton("Stat Time");
        playBtn.addActionListener(this);
        stopBtn = new JButton("Stop Time");
        stopBtn.addActionListener(this);
        time = new Clock();
        c.add(playBtn);
        c.add(stopBtn);
        c.add(time);
    }

    public void paint(Graphics g) {
        super.paint(g);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playBtn) {
            time.start();
            playBtn.setEnabled(false);
        } else if (e.getSource() == stopBtn) {
            time.stop();
            playBtn.setEnabled(true);
        }
    }
}