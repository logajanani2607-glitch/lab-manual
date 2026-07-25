import java.awt.*; 
import java.awt.event.*; 
 
public class SimpleCalculator extends Frame implements ActionListener { 
    TextField t1 = new TextField(10), t2 = new TextField(10); 
    Label l = new Label("Result"); 
    Button b = new Button("Add"); 
 
    SimpleCalculator() { 
        setLayout(new FlowLayout()); 
        add(t1); add(t2); add(b); add(l); 
        b.addActionListener(this); 
        setSize(250,150); 
        setVisible(true); 
    } 
 
    public void actionPerformed(ActionEvent e) { 
        int a = Integer.parseInt(t1.getText()); 
        int c = Integer.parseInt(t2.getText()); 
        l.setText("Result : " + (a + c)); 
    } 
 
    public static void main(String[] args) { 
        new SimpleCalculator(); 
    } 
}
