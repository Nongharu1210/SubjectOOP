// package lab13.lab13_03;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;

public class Clock extends JPanel implements ActionListener {
    private int width = 300;
    private int height = 300;
    private int xC = 150;
    private int yC = 150;
    private Color red, blue, green;
    private int Hour, Minute, Second, AHour, AMinute, mode = 0;
    private boolean period;
    private double angle1 = -270, angle2 = -180, angle3 = -270;
    private Timer time;
    private Clip clip;
    private AudioInputStream audioInputStream;

    public Clock() {
        super();
        
        setPreferredSize( new Dimension(width, height));
        setBorder( BorderFactory.createBevelBorder(0));
        red = Color.RED;
        blue = Color.BLUE;
        green = Color.GREEN;
        setFont(new Font("Tahoma",Font.BOLD,16));
        Hour = 11;
        Minute = 59;
        Second = 50;
        period = false;
        angle1 = -270 - (Second*6);
        angle2 = -270 - (Minute*6);
        angle3 = -270 - (Hour*30);
        time = new Timer(1000, this);
    }

    public Clock(int h, int m, int s) {
        Hour = h;
        Minute = m;
        Second = s;
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawOval( xC -145, yC -145, 290, 290);
        g.drawOval( xC -146, yC -146, 292, 292);
        drawText(g);
        if(period) g.drawString("AM", 140, 187);
        else g.drawString("PM", 140, 187);
        g.setColor( red );
        int x = (int)(125 * Math.cos( toRadians(angle1) ));
        int y = (int)(125 * Math.sin( toRadians(angle1) ));
        // Second
        if (angle1 <= 90)
            g.drawLine( 150, 150, xC+x, yC-y );
        else if (angle1 <= 180)
            g.drawLine( 150, 150, xC+x, yC-y );
        else if (angle1 <= 270)
            g.drawLine( 150, 150, xC+x, yC-y );
        else if (angle1 <= 360)
            g.drawLine( 150, 150, xC+x, yC-y );
        // Minute
        g.setColor( green );
        x = (int)(100 * Math.cos( toRadians(angle2) ));
        y = (int)(100 * Math.sin( toRadians(angle2) ));
        if (angle2 <= 90)
            g.drawLine( 150, 150, xC+x, yC-y );
        else if (angle2 <= 180)
            g.drawLine( 150, 150, xC+x, yC-y );
        else if (angle2 <= 270)
            g.drawLine( 150, 150, xC+x, yC-y );
        else if (angle2 <= 360)
            g.drawLine( 150, 150, xC+x, yC-y );
        // Hour
        g.setColor( blue );
        x = (int)(80 * Math.cos( toRadians(angle3) ));
        y = (int)(80 * Math.sin( toRadians(angle3) ));
        if (angle3 <= 90)
            g.drawLine( 150, 150, xC+x, yC-y );
        else if (angle3 <= 180)
            g.drawLine( 150, 150, xC+x, yC-y );
        else if (angle3 <= 270)
            g.drawLine( 150, 150, xC+x, yC-y );
        else if (angle3 <= 360)
            g.drawLine( 150, 150, xC+x, yC-y );
        g.setColor( Color.BLACK );
        g.fillOval(xC - 4, yC -4, 8, 8);
    }
    
    public void drawText(Graphics g) {
        g.drawString("12",140,22);
        g.drawString("11",80,40);
        g.drawString("10",30,90);

        g.drawString("9", 10,157);
        g.drawString("8", 30,217);
        g.drawString("7", 80,267);

        g.drawString("1", 210,40);
        g.drawString("2", 260,90);
        g.drawString("3", 280,157);

        g.drawString("6", 145,290);
        g.drawString("5", 210,267);
        g.drawString("4", 260,217);

        
    }
    
    private double toRadians(double angle) {
        return( Math.PI * angle / 180.0);
    }

    public void start() {
        time.start();
    }

    public void stop() {
        time.stop();
    }

    public void actionPerformed(ActionEvent e) {
        angle1 = -270 - (Second*6);
        angle2 = -270 - (Minute*6);
        angle3 = -270 - (Hour*30);
        if (Second == 60) {
        angle1 = -270;
        Second = 0;
        Minute = Minute + 1;
            if (Minute == 60) {
                angle2 = -270;
                Minute = 0;
                Hour = Hour + 1;
                angle3 = angle3 - 30;
                if (Hour == 12) {
                    angle3 = -270;
                    Hour = 0;
                    period = !period;
                }
            }
            else {
                angle2 = angle2 - 6;
            }
        }
        else {
            angle1 = angle1 - 6;
            Second = Second + 1;
        }
        if(Hour == AHour && Minute == AMinute && mode == 1){
            sound();
            mode = 0;
        }
        repaint();
    }   

    public void setHour(int h){
        Hour = h;
    }

    public void setMinute(int m){
        Minute = m;
    }

    public void setSecond(int s){
        Second = s;
    }

    public void setPeriod(boolean p){
        period = p;
    }

    public int getHour(){
        return Hour;
    }

    public int getMinute(){
        return Minute;
    }

    public int getSecond(){
        return Second;
    }

    public boolean getPeriod(){
        return period;
    }

    public void sound() {
        try {
            audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("TF050.wav"));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void stopSound(){
        clip.stop();
    }

    public void setAlarm(int h, int m){
        AHour = h;
        AMinute = m;
        mode = 1;
    }
}