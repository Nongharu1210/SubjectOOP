package lab13.lab13_02;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

public class Animation extends JPanel implements ActionListener {
    private int width = 320;
    private int height = 240;
    private Timer time;
    private ImageIcon image[] = new ImageIcon[30];
    private int imageNo = 0;
    private Color color;

    public Animation() {
        super();
        setPreferredSize(new Dimension(width, height));
        setBorder(BorderFactory.createBevelBorder(0));
        time = new Timer(100, this);
        loadImage();
        color = getBackground();
    }

    public Animation(int w, int h) {
        super();
        width = w;
        height = h;
        setPreferredSize(new Dimension(width, height));
        setBorder(BorderFactory.createBevelBorder(0));
        time = new Timer(100, this);
        loadImage();
        color = getBackground();
    }

    private void loadImage() {
        for (int n = 0; n < image.length; n++) {
            image[n] = new ImageIcon("images\\deitel" + n + ".gif");
        }
    }

    public void play() {
        time.start();
    }

    public void stop() {
        time.stop();
    }

    public void actionPerformed(ActionEvent e) {
        nextImage();
        Graphics g = getGraphics();
        g.setColor(color); // Color.WHITE);
        g.fillRect(1, 1, width, height);
        image[imageNo].paintIcon(this, getGraphics(), 1, 1);
    }

    public void nextImage() {
        imageNo++;
        if (imageNo == 30)
            imageNo = 0;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
