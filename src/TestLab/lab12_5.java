package TestLab;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class lab12_5 extends JFrame implements KeyListener,ActionListener {
    private int width, height;
    private JButton startBtn, stopBtn;
    private JLabel speed;
    private int x1Min, x1Max, y1Min, y1Max, x2Min, x2Max, y2Min, y2Max;
    private int x1, y1, x2, y2, size, x1Speed, y1Speed, x2Speed, y2Speed;
    Timer swTimer;
    public lab12_5() {
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        speed = new JLabel("" + x1Speed);
        c.add(speed);
        startBtn = new JButton("Play");
        startBtn.addActionListener(this);
        startBtn.addKeyListener(this);
        c.add(startBtn);
        stopBtn = new JButton("Stop");
        stopBtn.addActionListener(this);
        stopBtn.addKeyListener(this);
        c.add(stopBtn);
        width = 480; height = 320;
        x1Min = 1; x1Max = 478;
        y1Min = 30; y1Max = 319;
        x1Speed = 2; y1Speed = 2;
        x1 = 240; y1 = 160;

        x2Min = 1; x2Max = 478;
        y2Min = 30; y2Max = 319;
        x2Speed = -2; y2Speed = -2;
        x2 = 100; y2 = 80;

        size = 60;

        swTimer = new Timer(10, this);
    }   
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor( Color.BLACK );
        g.drawRect( 4, 30, 471, 285);
        g.setColor( Color.BLUE );
        g.fillOval( x1, y1, size, size);
        g.setColor( Color.RED );
        g.fillOval( x2, y2, size, size);
    }
    public void keyPressed(KeyEvent event) {
        if ( event.getKeyChar() == 'p') swTimer.start();
        else if ( event.getKeyChar() == 's') swTimer.stop();
        else if ( event.getKeyChar() == 'd'){
            x1Speed++;
            y1Speed++;
        } 
        else if ( event.getKeyChar() == 'a'){
            x1Speed--;
            y1Speed--;
        } 
    }
    public void keyReleased(KeyEvent event) { }
    public void keyTyped(KeyEvent event) { }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startBtn) swTimer.start();
        else if (e.getSource() == stopBtn) swTimer.stop();
        else {
            move();
            repaint();
        }
    }   
    public void move() {
        //x1
        x1 = x1 + x1Speed;
        y1 = y1 + y1Speed;
        if (x1 < x1Min) {
            x1 = x1Min;
            x1Speed = -x1Speed;
        }
        else if (x1+size > x1Max) {
            x1 = x1Max - size;
            x1Speed = -x1Speed;
        }
        //y1
        if (y1 < y1Min) {
            y1 = y1Min;
            y1Speed = -y1Speed;
        }
        else if (y1+size > y1Max) {
            y1 = y1Max - size;
            y1Speed = -y1Speed;
        }
        //x2
        x2 = x2 + x2Speed;
        y2 = y2 + y2Speed;
        if (x2 < x2Min) {
            x2 = x2Min;
            x2Speed = -x2Speed;
        }
        else if (x2+size > x2Max) {
            x2 = x1Max - size;
            x2Speed = -x2Speed;
        }
        //y2
        if (y2 < y2Min) {
            y2 = y2Min;
            y2Speed = -y2Speed;
        }
        else if (y2+size > y2Max) {
            y2 = y2Max - size;
            y2Speed = -y2Speed;
        }
        if (isCollide(x1, y1, x2, y2, size)){
            x1Speed = -x1Speed;
            y1Speed = -y1Speed;
            x2Speed = -x2Speed;
            y2Speed = -y2Speed;
        }
    }
    public static void main(String[] args) {
        lab12_5 window = new lab12_5();
        window.setSize(480, 330);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
    boolean isCollide(int x1,int y1,int x2, int y2, int size) {
        int x11 = x1 + size;
        int y11 = y1 + size;
        int x22 = x2 + size;
        int y22 = y2 + size;
        if (x22 >= x1 && x2 <= x11)
        if (y22 >= y1 && y2 <= y11) return true;
        return false;
    }
}