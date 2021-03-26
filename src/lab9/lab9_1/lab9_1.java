package lab9.lab9_1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public final class lab9_1 extends JFrame implements ActionListener {
    Student std[];
    Subject sub[];
    String[] studentStr, subjectStr;
    Container container;
    JComboBox<String> stdCombo, subCombo;
    JLabel stdLabel, subLabel;
    JButton addstdBtn, addsubBtn, saveBtn, clearBtn, cancleBtn;
    JTextField stdText;
    JTextArea subTextArea;
    JScrollPane subScroll;
    Register reg;
    int count = 0, maxCredit = 0;

    /** Creates a new instance of lab9_1 */
    public lab9_1() {
        super("Program Student Register");
        initStudent();
        initSubject();
        initGui();
        reg = new Register(new Student(), 10);
    }

    public void initStudent() {
        std = new Student[10];
        studentStr = new String[10];
        std[0] = new Student("6306021422194", "wetpisit", "surin");
        std[1] = new Student("6306021412091", "akarat", "singlor");
        std[2] = new Student("63060214122071", "thasanee", "boontiam");
        std[3] = new Student("5066260035", "natsucha", "suwanpatapee");
        std[4] = new Student("5066260036", "aaaaaa", "qqqqqq");
        std[5] = new Student("5066260037", "ssssss", "wwwwww");
        std[6] = new Student("5066260038", "dddddd", "eeeeee");
        std[7] = new Student("5066260040", "ffffff", "rrrrrr");
        std[8] = new Student("5066260050", "gggggg", "tttttt");
        std[9] = new Student("5066260034", "hhhhhh", "yyyyyy");
        studentStr[0] = std[0].toString();
        studentStr[1] = std[1].toString();
        studentStr[2] = std[2].toString();
        studentStr[3] = std[3].toString();
        studentStr[4] = std[4].toString();
        studentStr[5] = std[5].toString();
        studentStr[6] = std[6].toString();
        studentStr[7] = std[7].toString();
        studentStr[8] = std[8].toString();
        studentStr[9] = std[9].toString();
    }

    public void initSubject() {
        sub = new Subject[9];
        subjectStr = new String[9];
        sub[0] = new Subject("060223115", "SYSTEM ANALYSIS AND DESIGN", 3);
        sub[1] = new Subject("060223116", "OBJECT-ORIENTED PROGRAMMING", 3);
        sub[2] = new Subject("060223117", "OBJECT-ORIENTED PROGRAMMING", 1);
        sub[3] = new Subject("060223118", "WEB APPLICATION DEVELOPMENT", 3);
        sub[4] = new Subject("060223120", "COMPUTER ARCHITECTURE AND OR", 3);
        sub[5] = new Subject("060223121", "INFORMATION TECHNOLOGY PROJE", 1);
        sub[6] = new Subject("060223124", "DATA COMMUNICATION AND COMPU", 3);
        sub[7] = new Subject("080103062", "PRACTICAL ENGLISH II", 3);
        sub[8] = new Subject("091521545", "testcom", 3);
        subjectStr[0] = sub[0].toString();
        subjectStr[1] = sub[1].toString();
        subjectStr[2] = sub[2].toString();
        subjectStr[3] = sub[3].toString();
        subjectStr[4] = sub[4].toString();
        subjectStr[5] = sub[5].toString();
        subjectStr[6] = sub[6].toString();
        subjectStr[7] = sub[7].toString();
        subjectStr[8] = sub[8].toString();
    }

    public void initGui() {
        container = getContentPane();
        container.setLayout(new FlowLayout());
        stdLabel = new JLabel("Select Student : ");
        container.add(stdLabel);
        stdCombo = new JComboBox<String>(studentStr);
        stdCombo.setMaximumRowCount(10);
        container.add(stdCombo);
        addstdBtn = new JButton("Add Student");
        addstdBtn.addActionListener(this);
        container.add(addstdBtn);
        stdText = new JTextField(40);
        stdText.setEditable(false);
        container.add(stdText);
        subLabel = new JLabel("Select Subject : ");
        container.add(subLabel);
        subCombo = new JComboBox<String>(subjectStr);
        subCombo.setMaximumRowCount(9);
        container.add(subCombo);
        addsubBtn = new JButton("Add Subject");
        addsubBtn.setEnabled(false);
        addsubBtn.addActionListener(this);
        container.add(addsubBtn);
        subTextArea = new JTextArea(10, 45);
        subTextArea.setEditable(false);
        subScroll = new JScrollPane(subTextArea);
        container.add(subScroll);
        saveBtn = new JButton(" Save ");
        saveBtn.setEnabled(false);
        saveBtn.addActionListener(this);
        container.add(saveBtn);
        cancleBtn = new JButton(" Cancle ");
        cancleBtn.setEnabled(false);
        cancleBtn.addActionListener(this);
        container.add(cancleBtn);
        setSize(550, 330);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == addstdBtn) {
            int n = stdCombo.getSelectedIndex();
            stdText.setText(std[n].toString());
            reg.setStudent(std[n]);
            addstdBtn.setEnabled(false);
            addsubBtn.setEnabled(true);
            saveBtn.setEnabled(true);
            cancleBtn.setEnabled(true);
        } else if (event.getSource() == addsubBtn) {
            int n = subCombo.getSelectedIndex();
            // subTextArea.append(sub[n].toString() + "\n");
            // reg.setSubject(sub[n], count);
            // count++;
            if (maxCredit+sub[n].getSubjectCredit()>18||count == 8) {//กำหนดห้ามเกิน 18 หน่วยกิต ห้ามเกิน 8 วิชา
                addsubBtn.setEnabled(false);
                JOptionPane.showMessageDialog(this, "Credit > 18", "error", JOptionPane.ERROR_MESSAGE);
            } else {
                reg.setSubject(sub[n], count);
                count++;
                maxCredit += sub[n].getSubjectCredit();
                //subTextArea.append(sub[n].toString());
                subTextArea.append(sub[n].toString() + "\n");
            
            }
                
        } else if (event.getSource() == saveBtn) {
            String output = "";
            output = "Student :" + reg.getStudent();
            output += "\nSubject:\n";
            for (int n = 0; n < count; n++)
                output += reg.getSubject(n) + "\n";
            JOptionPane.showMessageDialog(this, output, "Registration Data", JOptionPane.INFORMATION_MESSAGE);
            resetBtn();
        } else if (event.getSource() == cancleBtn) {
            stdText.setText("");
            subTextArea.setText("");
            count = 0;
            resetBtn();
        }
    }

    public void resetBtn() {
        addstdBtn.setEnabled(true);
        addsubBtn.setEnabled(false);
        saveBtn.setEnabled(false);
        cancleBtn.setEnabled(false);
        stdText.setText("");
        subTextArea.setText("");
    }

    public static void main(String[] args) {
        lab9_1 lab9_1 = new lab9_1();
    }
}