import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import java.util.regex.*;

public class PersonalDataPrivacyChecker extends JFrame implements ActionListener {

    JTextArea inputArea;
    JTextArea resultArea;

    JButton scanButton;
    JButton redactButton;
    JButton openButton;

    String originalText = "";

    public PersonalDataPrivacyChecker() {

        setTitle("Personal Data Privacy Checker");
        setSize(900,650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        inputArea = new JTextArea();
        resultArea = new JTextArea();

        inputArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 15));

        JScrollPane left = new JScrollPane(inputArea);
        JScrollPane right = new JScrollPane(resultArea);

        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,left,right);
        split.setDividerLocation(430);

        JPanel panel = new JPanel();

        openButton = new JButton("Open Text File");
        scanButton = new JButton("Scan");
        redactButton = new JButton("Redact");

        panel.add(openButton);
        panel.add(scanButton);
        panel.add(redactButton);

        add(panel,BorderLayout.NORTH);
        add(split,BorderLayout.CENTER);

        openButton.addActionListener(this);
        scanButton.addActionListener(this);
        redactButton.addActionListener(this);

        setVisible(true);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> new PersonalDataPrivacyChecker());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==openButton) {

            JFileChooser chooser = new JFileChooser();

            int option = chooser.showOpenDialog(this);

            if(option==JFileChooser.APPROVE_OPTION) {

                File file = chooser.getSelectedFile();

                try {

                    originalText = new String(Files.readAllBytes(file.toPath()));
                    inputArea.setText(originalText);

                }
                catch(Exception ex) {

                    JOptionPane.showMessageDialog(this,"Cannot open file.");

                }
            }

        }

        if(e.getSource()==scanButton) {

            originalText = inputArea.getText();

            resultArea.setText(scanData(originalText));

        }

        if(e.getSource()==redactButton) {

            String redacted = redact(originalText);

            resultArea.setText(redacted);

        }

    }

    private String scanData(String text) {

        StringBuilder report = new StringBuilder();

        report.append("========== Privacy Scan Report ==========\n\n");

        findPattern(report,
                "EMAIL",
                text,
                "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}");

        findPattern(report,
                "PHONE",
                text,
                "\\b[6-9]\\d{9}\\b");

        findPattern(report,
                "AADHAAR",
                text,
                "\\b\\d{4}\\s?\\d{4}\\s?\\d{4}\\b");

        findPattern(report,
                "CREDIT CARD",
                text,
                "\\b\\d{13,16}\\b");

        findPattern(report,
                "PASSWORD",
                text,
                "(?i)(password|pwd|pass)\\s*[:=]\\s*\\S+");

        return report.toString();

    }

    private void findPattern(StringBuilder report,String title,String text,String regex) {

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(text);

        report.append(title);
        report.append("\n------------------------\n");

        int count=0;

        while(matcher.find()) {

            count++;

            report.append(count)
                    .append(". ")
                    .append(matcher.group())
                    .append("\n");

        }

        if(count==0)
            report.append("No ").append(title).append(" Found\n");

        report.append("\n");

    }

    private String redact(String text) {

        text = text.replaceAll(
                "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}",
                "[EMAIL REDACTED]");

        text = text.replaceAll(
                "\\b[6-9]\\d{9}\\b",
                "[PHONE REDACTED]");

        text = text.replaceAll(
                "\\b\\d{4}\\s?\\d{4}\\s?\\d{4}\\b",
                "[AADHAAR REDACTED]");

        text = text.replaceAll(
                "\\b\\d{13,16}\\b",
                "[CARD REDACTED]");

        text = text.replaceAll(
                "(?i)(password|pwd|pass)\\s*[:=]\\s*\\S+",
                "[PASSWORD REDACTED]");

        return text;

    }

}
