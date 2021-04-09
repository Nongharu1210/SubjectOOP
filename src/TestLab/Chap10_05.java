package TestLab;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Chap10_05 extends JFrame implements ActionListener, MouseMotionListener {
    private ImageIcon image;
    private JButton ovalBtn, rectBtn, imageBtn, clearBtn;
    private JPanel area1, area2;
    private JTextField StatusText;

    public Chap10_05() {
        super("Program Gui Using Panel 2");
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        area1 = new JPanel();
        area1.setPreferredSize(new Dimension(320, 70));
        area1.setBorder(BorderFactory.createLineBorder(

                Color.RED, 3));
        ovalBtn = new JButton("Oval");
        ovalBtn.addActionListener(this);
        rectBtn = new JButton("Rectangle");
        rectBtn.addActionListener(this);
        imageBtn = new JButton("Image");
        imageBtn.addActionListener(this);
        clearBtn = new JButton("Clear");
        clearBtn.addActionListener(this);
        StatusText = new JTextField(30);
        area1.add(ovalBtn);
        area1.add(rectBtn);
        area1.add(imageBtn);
        area1.add(clearBtn);
        area1.add(StatusText);
        area2 = new JPanel();
        area2.setPreferredSize(new Dimension(320, 260));
        area2.setBorder(BorderFactory.createLineBorder(

                Color.RED, 3));
        area2.addMouseMotionListener(this);
        c.add(area1);
        c.add(area2);
        image = new ImageIcon("d:/beach.jpg");
        setForeground(Color.YELLOW);
        addMouseMotionListener(this);
    }

    public void paint(Graphics g) {
        super.paint(g);
    }

    public void clearArea(JPanel area) {
        area.paint(area.getGraphics());
    }

    public void draw(Graphics g, int type) {
        switch (type) {
        case 1:

            clearArea(area2);
            g.fillOval(100, 60, 120, 120);
            break;
        case 2:

            clearArea(area2);
            g.fillRect(100, 60, 120, 120);
            break;
        case 3:

            image.paintIcon(area2, g, 10, 10);
            break;

        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ovalBtn)
            draw(area2.getGraphics(), 1);
        else if (e.getSource() == rectBtn)
            draw(area2.getGraphics(), 2);
        else if (e.getSource() == imageBtn)
            draw(area2.getGraphics(), 3);
        else if (e.getSource() == clearBtn)
            clearArea(area2);

    }

    public void mouseMoved(MouseEvent e) {
        StatusText.setText(e.getX() + ", " + e.getY());
    }

    public void mouseDragged(MouseEvent e) {
    }

    public static void main(String[] args) {
        Chap10_05 window = new Chap10_05();
        window.setSize(450, 400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}