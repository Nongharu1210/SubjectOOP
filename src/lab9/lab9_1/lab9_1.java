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
    int count = 0;

    /** Creates a new instance of lab9_1 */
    public lab9_1() {
        super("Program Student Register");
        initStudent();
        initSubject();
        initGui();
        reg = new Register(new Student(), 5);
    }

    public void initStudent() {
        std = new Student[3];
        studentStr = new String[3];
        std[0] = new Student("5066260010", "AAAAA", "BBBBBBBBBBB");
        std[1] = new Student("5066260024", "DDDDD", "GGGGGGGGGG");
        std[2] = new Student("5066260035", "HHHHH", "KKKKKKKKKKK");
        studentStr[0] = std[0].toString();
        studentStr[1] = std[1].toString();
        studentStr[2] = std[2].toString();
    }

    public void initSubject() {
        sub = new Subject[5];
        subjectStr = new String[5];
        sub[0] = new Subject("662305", "IT Laboratory II", 1);
        sub[1] = new Subject("662309", "Data Structure", 3);
        sub[2] = new Subject("662310", "Database System", 3);
        sub[3] = new Subject("662317", "Data Communication", 3);
        sub[4] = new Subject("662327", "Advanced Computer Programming", 3);
        subjectStr[0] = sub[0].toString();
        subjectStr[1] = sub[1].toString();
        subjectStr[2] = sub[2].toString();
        subjectStr[3] = sub[3].toString();
        subjectStr[4] = sub[4].toString();
    }

    public void initGui() {
        container = getContentPane();
        container.setLayout(new FlowLayout());
        stdLabel = new JLabel("Select Student : ");
        container.add(stdLabel);
        stdCombo = new JComboBox<String>(studentStr);
        stdCombo.setMaximumRowCount(3);
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
        subCombo.setMaximumRowCount(5);
        container.add(subCombo);
        addsubBtn = new JButton("Add Subject");
        addsubBtn.setEnabled(false);
        addsubBtn.addActionListener(this);
        container.add(addsubBtn);
        subTextArea = new JTextArea(5, 50);
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
        setSize(450, 250);
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
            subTextArea.append(sub[n].toString() + "\n");
            reg.setSubject(sub[n], count);
            count++;
            if (count == 5)
                addsubBtn.setEnabled(false);
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