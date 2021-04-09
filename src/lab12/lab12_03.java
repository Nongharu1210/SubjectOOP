package lab12;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class lab12_03 extends JFrame implements ActionListener, MouseListener {
    int x1, y1, x2, y2;
    JButton btnLine, btnRect, btnCircle, btnClear, blackBtn, blueBtn, cyanBtn, dark_grayBtn, grayBtn, greenBtn, lightBtn, magentaBtn, yellowBtn, pinkBtn, redBtn, whiteBtn;
    JTextField text1, text2;
    Color oldColor1, oldColor2;
    char typeShape = 'L';

    public lab12_03() {
        super("");
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        btnLine = new JButton("     Line     ");
        btnLine.addActionListener(this);
        btnLine.setBackground(Color.YELLOW);
        btnLine.setForeground(Color.RED);
        btnLine.setForeground(Color.RED);
        btnLine.setBorder(BorderFactory.createLineBorder(Color.RED));
        c.add(btnLine);

        btnRect = new JButton("     Rectangle     ");
        btnRect.addActionListener(this);
        btnRect.setBackground(Color.YELLOW);
        btnRect.setForeground(Color.RED);
        btnRect.setForeground(Color.RED);
        btnRect.setBorder(BorderFactory.createLineBorder(Color.RED));
        c.add(btnRect);

        btnCircle = new JButton("     Circle     ");
        btnCircle.addActionListener(this);
        btnCircle.setBackground(Color.YELLOW);
        btnCircle.setForeground(Color.RED);
        btnCircle.setForeground(Color.RED);
        btnCircle.setBorder(BorderFactory.createLineBorder(Color.RED));
        c.add(btnCircle);
        
        btnClear = new JButton("     Clear     ");
        btnClear.addActionListener(this);
        btnClear.setBackground(Color.YELLOW);
        btnClear.setForeground(Color.RED);
        btnClear.setForeground(Color.RED);
        btnClear.setBorder(BorderFactory.createLineBorder(Color.RED));
        c.add(btnClear);
        //************************************//
        blackBtn = new JButton("      ");
        blackBtn.addActionListener(this);
        blackBtn.setBackground(Color.black);
        blackBtn.setForeground(Color.white);
        blackBtn.setBorder(BorderFactory.createLineBorder(Color.black));
        c.add(blackBtn);

        blueBtn = new JButton("      ");
        blueBtn.addActionListener(this);
        blueBtn.setBackground(Color.blue);
        blueBtn.setForeground(Color.white);
        blueBtn.setBorder(BorderFactory.createLineBorder(Color.black));
        c.add(blueBtn);

        cyanBtn = new JButton("      ");
        cyanBtn.addActionListener(this);
        cyanBtn.setBackground(Color.cyan);
        cyanBtn.setForeground(Color.white);
        cyanBtn.setBorder(BorderFactory.createLineBorder(Color.black));
        c.add(cyanBtn);

        dark_grayBtn = new JButton("      ");
        dark_grayBtn.addActionListener(this);
        dark_grayBtn.setBackground(Color.DARK_GRAY);
        dark_grayBtn.setForeground(Color.white);
        dark_grayBtn.setBorder(BorderFactory.createLineBorder(Color.black));
        c.add(dark_grayBtn);

        grayBtn = new JButton("      ");
        grayBtn.addActionListener(this);
        grayBtn.setBackground(Color.GRAY);
        grayBtn.setForeground(Color.white);
        grayBtn.setBorder(BorderFactory.createLineBorder(Color.black));
        c.add(grayBtn);

        greenBtn = new JButton("      ");
        greenBtn.addActionListener(this);
        greenBtn.setBackground(Color.GREEN);
        greenBtn.setForeground(Color.white);
        greenBtn.setBorder(BorderFactory.createLineBorder(Color.black));
        c.add(greenBtn);

        lightBtn = new JButton("      ");
        lightBtn.addActionListener(this);
        lightBtn.setBackground(Color.LIGHT_GRAY);
        lightBtn.setForeground(Color.white);
        lightBtn.setBorder(BorderFactory.createLineBorder(Color.black));
        c.add(lightBtn);

        magentaBtn = new JButton("      ");
        magentaBtn.addActionListener(this);
        magentaBtn.setBackground(Color.MAGENTA);
        magentaBtn.setForeground(Color.white);
        magentaBtn.setBorder(BorderFactory.createLineBorder(Color.black));
        c.add(magentaBtn);

        yellowBtn = new JButton("      ");
        yellowBtn.addActionListener(this);
        yellowBtn.setBackground(Color.YELLOW);
        yellowBtn.setForeground(Color.white);
        yellowBtn.setBorder(BorderFactory.createLineBorder(Color.black));
        c.add(yellowBtn);

        pinkBtn = new JButton("      ");
        pinkBtn.addActionListener(this);
        pinkBtn.setBackground(Color.PINK);
        pinkBtn.setForeground(Color.white);
        pinkBtn.setBorder(BorderFactory.createLineBorder(Color.black));
        c.add(pinkBtn);

        redBtn = new JButton("      ");
        redBtn.addActionListener(this);
        redBtn.setBackground(Color.RED);
        redBtn.setForeground(Color.white);
        redBtn.setBorder(BorderFactory.createLineBorder(Color.black));
        c.add(redBtn);

        whiteBtn = new JButton("      ");
        whiteBtn.addActionListener(this);
        whiteBtn.setBackground(Color.WHITE);
        whiteBtn.setForeground(Color.white);
        whiteBtn.setBorder(BorderFactory.createLineBorder(Color.black));
        c.add(whiteBtn);
        //************************************//
        text1 = new JTextField(12);
        text1.setEditable(false);
        c.add(text1);
        text2 = new JTextField(12);
        text2.setEditable(false);
        c.add(text2);
        addMouseListener(this);
        
    }

    public void paint(Graphics g) {
        super.paint(g);
        switch (typeShape) {
        case 'L':
            g.drawLine(x1, y1, x2, y2);
            break;
        case 'R':
            g.drawRect(x1, y1, x2 - x1, y2 - y1);
            break;
        case 'C':
            g.drawOval(x1, y1, x2 - x1, y2 - y1);
            break;
        }
    }

    public void mousePressed(MouseEvent event) {
        if (event.getButton() == 1) { // Mouse Left
            x1 = event.getX();
            y1 = event.getY();
            text1.setText("(X1 = " + x1 + ",Y1 = " + y1 + ")");
        } else if (event.getButton() == 3) { // Mouse Right
            x2 = event.getX();
            y2 = event.getY();
            text2.setText(" (X2 = " + x2 + ",Y2 = " + y2 + ")");
        }
    }

    public void mouseReleased(MouseEvent event) {
    }

    public void mouseClicked(MouseEvent event) {
        repaint();
    }

    public void mouseEntered(MouseEvent event) {
        repaint();
    }

    public void mouseExited(MouseEvent event) {
        repaint();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLine)
            typeShape = 'L';
        else if (e.getSource() == btnRect)
            typeShape = 'R';
        else if (e.getSource() == btnCircle)
            typeShape = 'C';
        else if (e.getSource() == btnClear) {
            x1 = y1 = x2 = y2 = 0;
            text1.setText("");
            text2.setText("");
        }
        repaint();
    }

    public static void main(String[] args) {
        lab12_03 window = new lab12_03();
        window.setSize(320, 240);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
