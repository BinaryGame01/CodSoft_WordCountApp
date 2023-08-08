import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class WordCountApp extends JFrame {
    private JLabel charLabel, wordLabel;
    private JTextArea textArea;
    private JButton countButton;

    public WordCountApp() {
        setTitle("Word Counter");

        charLabel = new JLabel("Characters: ");
        charLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        charLabel.setForeground(Color.blue);

        wordLabel = new JLabel("Words: ");
        wordLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        wordLabel.setForeground(Color.blue);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        countButton = new JButton("Count");
        countButton.addActionListener(new CountButtonListener());

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(countButton, BorderLayout.SOUTH);

        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(2, 1));
        labelPanel.add(charLabel);
        labelPanel.add(wordLabel);

        add(labelPanel, BorderLayout.WEST);
        add(panel, BorderLayout.CENTER);

        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class CountButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String text = textArea.getText();
            charLabel.setText("Characters: " + text.length());
            String words[] = text.split("\\s");
            wordLabel.setText("Words: " + words.length);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WordCountApp());
    }
}
