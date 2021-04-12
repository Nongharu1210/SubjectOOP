
// 6306021422194
import java.awt.*;
import javax.swing.*;

public class minion extends JFrame {
    public minion() {
        super("I am Minion");
    }

    public void paint(Graphics g) {
        super.paint(g);

        // ผม
        g.setColor(Color.BLACK);
        g.drawArc(200, 90, 80, 80, 0, 110);
        g.setColor(Color.BLACK);
        g.drawArc(215, 90, 80, 80, 0, 110);
        g.setColor(Color.BLACK);
        g.drawArc(270, 90, 80, 80, 50, 140);
        g.setColor(Color.BLACK);
        g.drawArc(280, 90, 80, 80, 50, 140);

        // แขน
        g.setColor(Color.YELLOW);
        g.fillArc(345, 285, 40, 90, -70, 190);
        g.setColor(Color.BLACK);
        g.fillOval(360, 355, 30, 25);
        g.setColor(Color.YELLOW);
        g.fillArc(175, 285, 40, 90, 270, -200);
        g.setColor(Color.BLACK);
        g.fillOval(170, 355, 30, 25);

        // ตัว
        g.setColor(Color.YELLOW);
        g.fillRoundRect(200, 100, 160, 300, 200, 100);

        // แว่นตา
        g.setColor(Color.BLACK);
        g.fillRect(200, 160, 160, 15);
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(220, 135, 60, 60);
        g.setColor(Color.BLACK);
        g.drawRoundRect(220, 135, 60, 60, 100, 100);
        g.setColor(Color.WHITE);
        g.fillOval(225, 140, 50, 50);
        g.setColor(Color.BLACK);
        g.drawRoundRect(225, 140, 50, 50, 100, 100);
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(280, 135, 60, 60);
        g.setColor(Color.BLACK);
        g.drawRoundRect(280, 135, 60, 60, 100, 100);
        g.setColor(Color.WHITE);
        g.fillOval(285, 140, 50, 50);
        g.setColor(Color.BLACK);
        g.drawRoundRect(285, 140, 50, 50, 100, 100);

        // ลูกตา
        g.setColor(Color.RED);
        g.fillOval(250, 155, 20, 20);
        g.setColor(Color.BLACK);
        g.drawRoundRect(250, 155, 20, 20, 100, 100);
        g.setColor(Color.BLACK);
        g.fillOval(255, 160, 10, 10);
        g.setColor(Color.RED);
        g.fillOval(290, 155, 20, 20);
        g.setColor(Color.BLACK);
        g.drawRoundRect(290, 155, 20, 20, 100, 100);
        g.setColor(Color.BLACK);
        g.fillOval(295, 160, 10, 10);

        // ปาก
        g.drawArc(220, 140, 120, 100, -40, -100);

        // ขา
        g.setColor(Color.BLACK);
        g.fillRect(240, 400, 30, 60);
        g.setColor(Color.BLACK);
        g.fillOval(225, 440, 45, 30);
        g.setColor(Color.BLACK);
        g.fillRect(290, 400, 30, 60);
        g.setColor(Color.BLACK);
        g.fillOval(290, 440, 45, 30);

        // เสื้อ
        g.setColor(Color.BLUE);
        g.fillRect(220, 270, 120, 110);
        g.setColor(Color.CYAN);
        g.fillArc(245, 265, 70, 90, 0, -180);
        g.setColor(Color.BLUE);
        g.fillRect(200, 270, 20, 15);
        g.setColor(Color.BLACK);
        g.drawRect(200, 270, 40, 15);
        g.setColor(Color.BLUE);
        g.fillRect(340, 270, 20, 15);
        g.setColor(Color.BLACK);
        g.drawRect(320, 270, 40, 15);
        g.setColor(Color.BLUE);
        g.fillArc(200, 305, 160, 120, 0, -180);

    }

    public static void main(String[] args) {
        minion obj = new minion();
        obj.setSize(550, 500);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.setVisible(true);
    }
}
