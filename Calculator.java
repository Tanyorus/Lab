import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame {

    // Components for Normal Mode
    private JTextField num1Field, num2Field;
    private JLabel resultLabel;

    // Components for Scientific Mode
    private JTextField inputField;
    private JLabel sciResultLabel;

    private CardLayout cardLayout; // To switch between modes
    private JPanel mainPanel;      // Main panel to hold mode panels

    public Calculator() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 250);
        setLayout(new BorderLayout()); // Use BorderLayout for overall layout

        // Initialize CardLayout and Main Panel
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Create panels for each mode
        JPanel normalPanel = createNormalPanel();
        JPanel scientificPanel = createScientificPanel();

        // Add panels to the main panel with names
        mainPanel.add(normalPanel, "Normal");
        mainPanel.add(scientificPanel, "Scientific");

        // Add the main panel to the frame
        add(mainPanel, BorderLayout.CENTER);

        // Add mode switching menu
        JMenu modeMenu = new JMenu("Mode");
        JMenuItem normalMode = new JMenuItem("Normal");
        JMenuItem scientificMode = new JMenuItem("Scientific");

        normalMode.addActionListener(e -> cardLayout.show(mainPanel, "Normal"));
        scientificMode.addActionListener(e -> cardLayout.show(mainPanel, "Scientific"));

        modeMenu.add(normalMode);
        modeMenu.add(scientificMode);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(modeMenu);
        setJMenuBar(menuBar);


        setVisible(true);
    }

    // --- Normal Mode Panel ---
    private JPanel createNormalPanel() {
        JPanel panel = new JPanel(new GridLayout(6, 2, 5, 5)); // Grid layout for organization

        JLabel num1Label = new JLabel("Number 1:");
        JLabel num2Label = new JLabel("Number 2:");
        num1Field = new JTextField();
        num2Field = new JTextField();
        resultLabel = new JLabel("Result:");

        JButton addButton = new JButton("Add (+)");
        JButton subtractButton = new JButton("Subtract (-)");
        JButton multiplyButton = new JButton("Multiply (*)");
        JButton divideButton = new JButton("Divide (/)");

        // Action Listeners for Normal Mode Buttons
        addButton.addActionListener(e -> calculate('+'));
        subtractButton.addActionListener(e -> calculate('-'));
        multiplyButton.addActionListener(e -> calculate('*'));
        divideButton.addActionListener(e -> calculate('/'));

        // Add components to the panel
        panel.add(num1Label); panel.add(num1Field);
        panel.add(num2Label); panel.add(num2Field);
        panel.add(addButton); panel.add(subtractButton);
        panel.add(multiplyButton); panel.add(divideButton);
        panel.add(resultLabel);

        return panel;
    }

    // --- Scientific Mode Panel ---
    private JPanel createScientificPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));

        JLabel inputLabel = new JLabel("Input:");
        inputField = new JTextField();
        sciResultLabel = new JLabel("Result:");

        JButton sinButton = new JButton("Sin");
        JButton cosButton = new JButton("Cos");
        JButton tanButton = new JButton("Tan");
        JButton logButton = new JButton("Log");

        // Action Listeners for Scientific Mode Buttons
        sinButton.addActionListener(e -> calculateScientific("sin"));
        cosButton.addActionListener(e -> calculateScientific("cos"));
        tanButton.addActionListener(e -> calculateScientific("tan"));
        logButton.addActionListener(e -> calculateScientific("log"));

        // Add components to the panel
        panel.add(inputLabel); panel.add(inputField);
        panel.add(sinButton); panel.add(cosButton);
        panel.add(tanButton); panel.add(logButton);
        panel.add(sciResultLabel);

        return panel;
    }

    // --- Calculation Logic ---
    private void calculate(char operator) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = 0;

            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/': 
                    if (num2 == 0) {
                        resultLabel.setText("Cannot divide by zero!");
                        return; // Stop further calculation
                    }
                    result = num1 / num2; break;
            }
            resultLabel.setText("Result: " + result);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input!");
        }
    }

    private void calculateScientific(String operation) {
        try {
            double input = Double.parseDouble(inputField.getText());
            double result = 0;

            switch (operation) {
                case "sin": result = Math.sin(Math.toRadians(input)); break; //toRadians for angles
                case "cos": result = Math.cos(Math.toRadians(input)); break;
                case "tan": result = Math.tan(Math.toRadians(input)); break;
                case "log": result = Math.log10(input); break; //Base 10 logarithm
            }
            sciResultLabel.setText("Result: " + result);
        } catch (NumberFormatException ex) {
            sciResultLabel.setText("Invalid input!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Calculator());
    }
}