import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
 
public class StudentRegistrationForm extends JFrame implements ActionListener { 
 
    JLabel l1, l2, l3; 
    JTextField t1, t2, t3; 
    JButton submit, clear; 
 
    StudentRegistrationForm() { 
 
        setTitle("Student Registration Form"); 
        setSize(400, 300); 
        setLayout(new FlowLayout()); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
 
        l1 = new JLabel("Name:"); 
        l2 = new JLabel("Roll Number:"); 
        l3 = new JLabel("Course:"); 
 
        t1 = new JTextField(20); 
        t2 = new JTextField(20); 
        t3 = new JTextField(20); 
 
        submit = new JButton("Submit"); 
        clear = new JButton("Clear"); 
 
        submit.addActionListener(this); 
        clear.addActionListener(this); 
 
        add(l1); 
        add(t1); 
 
        add(l2); 
        add(t2); 
 
        add(l3); 
        add(t3); 
 
        add(submit); 
        add(clear); 
 
        setVisible(true); 
    } 
 
    public void actionPerformed(ActionEvent e) { 
 
        if (e.getSource() == submit) { 
            String name = t1.getText(); 
            String roll = t2.getText(); 
            String course = t3.getText(); 
 
            JOptionPane.showMessageDialog(this, 
                    "Registration Successful!\n\n" 
                    + "Name: " + name 
                    + "\nRoll Number: " + roll 
                    + "\nCourse: " + course); 
        } 
 
        if (e.getSource() == clear) { 
            t1.setText(""); 
            t2.setText(""); 
            t3.setText(""); 
        } 
    } 
 
    public static void main(String[] args) { 
        new StudentRegistrationForm(); 
    } 
}
