import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class lab12_03 extends JFrame implements ActionListener, MouseListener {
    int x1, y1, x2, y2, color = 1;
    JButton btnLine, btnRect, btnCircle, btnClear, blackBtn, blueBtn, cyanBtn, dark_grayBtn, grayBtn, greenBtn, lightBtn, magentaBtn, yellowBtn, pinkBtn, redBtn, whiteBtn;
    JTextField text1, text2;
    Color oldColor1, oldColor2;
    char typeShape = 'L';

    public lab12_03() {
        super("");
        Container c = getContentPane();
        c.setLayout( new FlowLayout());
        btnLine = new JButton("Line");
        btnLine.addActionListener( this );
        //c.add(btnLine);
        btnRect = new JButton("Rectangle");
        btnRect.addActionListener( this );
        //c.add(btnRect);
        btnCircle = new JButton("Circle");
        btnCircle.addActionListener( this );
        //c.add(btnCircle);
        btnClear = new JButton("Clear");
        btnClear.addActionListener( this );
        //c.add(btnClear);

        btnRect = new JButton("     Rectangle     ");
        btnRect.addActionListener(this);
        btnRect.setBackground(Color.YELLOW);
        btnRect.setForeground(Color.RED);
        btnRect.setForeground(Color.RED);
        btnRect.setBorder(BorderFactory.createLineBorder(Color.RED));
        c.add(btnRect);

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

        //buttons
        g.setColor(Color.YELLOW);
        g.fillRect(45, 35, 55, 25);
        g.fillRect(105, 35, 90, 25);
        g.fillRect(200, 35, 70, 25);
        g.fillRect(275, 35, 65, 25);
        g.setColor(Color.RED);
        g.drawRect(45, 35, 55, 25);
        g.drawRect(105, 35, 90, 25);
        g.drawRect(200, 35, 70, 25);
        g.drawRect(275, 35, 65, 25);
        g.drawString("LINE",57, 53);
        g.drawString("RECT",132, 53);
        g.drawString("CIRCLE",212, 53);
        g.drawString("CLEAR",287, 53);

        //color
        g.setColor(Color.BLACK);
        g.fillRect(10, 70, 25, 25);
        g.setColor(Color.BLUE);
        g.fillRect(40, 70, 25, 25);
        g.setColor(Color.CYAN);
        g.fillRect(70, 70, 25, 25);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(100, 70, 25, 25);
        g.setColor(Color.GRAY);
        g.fillRect(130, 70, 25, 25);
        g.setColor(Color.GREEN);
        g.fillRect(160, 70, 25, 25);
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(190, 70, 25, 25);
        g.setColor(Color.MAGENTA);
        g.fillRect(220, 70, 25, 25);
        g.setColor(Color.ORANGE);
        g.fillRect(250, 70, 25, 25);
        g.setColor(Color.PINK);
        g.fillRect(280, 70, 25, 25);
        g.setColor(Color.RED);
        g.fillRect(310, 70, 25, 25);
        g.setColor(Color.WHITE);
        g.fillRect(340, 70, 25, 25);
        g.setColor(Color.BLACK);
        g.drawRect(10, 70, 25, 25);
        g.drawRect(40, 70, 25, 25);
        g.drawRect(70, 70, 25, 25);
        g.drawRect(100, 70, 25, 25);
        g.drawRect(130, 70, 25, 25);
        g.drawRect(160, 70, 25, 25);
        g.drawRect(190, 70, 25, 25);
        g.drawRect(220, 70, 25, 25);
        g.drawRect(250, 70, 25, 25);
        g.drawRect(280, 70, 25, 25);
        g.drawRect(310, 70, 25, 25);
        g.drawRect(340, 70, 25, 25);

        switch (color){
            case 1 :
            g.setColor(Color.BLACK);
            break;
            case 2 :
            g.setColor(Color.BLUE);
            break;
            case 3 :
            g.setColor(Color.CYAN);
            break;
            case 4 :
            g.setColor(Color.DARK_GRAY);
            break;
            case 5 :
            g.setColor(Color.GRAY);
            break;
            case 6 :
            g.setColor(Color.GREEN);
            break;
            case 7 :
            g.setColor(Color.LIGHT_GRAY);
            break;
            case 8 :
            g.setColor(Color.MAGENTA);
            break;
            case 9 :
            g.setColor(Color.ORANGE);
            break;
            case 10 :
            g.setColor(Color.PINK);
            break;
            case 11 :
            g.setColor(Color.RED);
            break;
            case 12 :
            g.setColor(Color.WHITE);
            break;
            default : break;
        }

        switch (typeShape) {
            case 'L' :
            g.drawLine(x1, y1, x2, y2);
            break;
        case 'R' :
            g.drawRect(x1, y1, x2-x1, y2-y1);
            break;
        case 'C' :
            g.drawOval(x1, y1, x2-x1, y2-y1);
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
        x1 = event.getX();
        y1 = event.getY();
        text1.setText("(X1 = "+x1+",Y1 = "+y1+")" );

        boolean line = isInside(45,35,55,25,x1,y1);
        boolean rect = isInside(105,35,90,25,x1,y1);
        boolean cir = isInside(200,35,70,25,x1,y1);
        boolean clr = isInside(275,35,65,25,x1,y1);

        boolean black = isInside(10,70,25,25,x1,y1);
        boolean blue = isInside(40,70,25,25,x1,y1);
        boolean cyan = isInside(70,70,25,25,x1,y1);
        boolean dgray = isInside(100,70,25,25,x1,y1);
        boolean gray = isInside(130,70,25,25,x1,y1);
        boolean green = isInside(160,70,25,25,x1,y1);
        boolean lgray = isInside(190,70,25,25,x1,y1);
        boolean magenta = isInside(220,70,25,25,x1,y1);
        boolean orange = isInside(250,70,25,25,x1,y1);
        boolean pink = isInside(280,70,25,25,x1,y1);
        boolean red = isInside(310,70,25,25,x1,y1);
        boolean white = isInside(340,70,25,25,x1,y1);
        
        if (line) typeShape = 'L';
        if (rect) typeShape = 'R';
        if (cir) typeShape = 'C';
        if (clr) {
                x1 = y1 = x2 = y2 = 0;
                text1.setText("");
                text2.setText("");
        }
        if (black) color = 1;
        if (blue) color = 2;
        if (cyan) color = 3;
        if (dgray) color = 4;
        if (gray) color = 5;
        if (green) color = 6;
        if (lgray) color = 7;
        if (magenta) color = 8;
        if (orange) color = 9;
        if (pink) color = 10;
        if (red) color = 11;
        if (white) color = 12;

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
        window.setSize(550, 400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
    boolean isInside(int x,int y,int width,int height, int x1, int y1) {
        int x2 = x + width;
        int y2 = y + height;
        if (x1 >= x && x1 <= x2)
        if (y1 >= y && y1 <= y2) return true;
        return false;
    }
}