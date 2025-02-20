

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab11_q2 {

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Simple Calculation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 200);

        // Create a panel to hold the components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,1));// 3 rows , 2 colums

        // Create labels and text fields for the two numbers
        JLabel number1Label = new JLabel("Enter your first number ");
        JTextField number1Field = new JTextField();

        JLabel number2Label = new JLabel("Enter your second number ");
        JTextField number2Field = new JTextField();
        //use number1Lable and number1Field , number2Lable and number2Field

        // Create buttons for addition and subtraction
        JButton addButton = new JButton("Add(+)");
        JButton subtractButton = new JButton("Subtract(-)");
        //addButton and subtractButton 

        // Create a label to display the result
        JLabel resultLabel = new JLabel("Result : ");
        //resultLabel 

        // Add components to the panel
       panel.add(number1Label);
       panel.add(number1Field);
       panel.add(number2Label);
       panel.add(number2Field);
       panel.add(addButton);
       panel.add(subtractButton);
       panel.add(new JLabel(" "));
       panel.add(resultLabel);
     

        // Add an action listener to the add button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double number1 = Double.parseDouble(number1Field.getText());
                    double number2 = Double.parseDouble(number2Field.getText());
                    double result = number1 + number2;
                    resultLabel.setText("Result: " + result);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Please enter valid numbers.");
                }
            }
        });
        
        // Add an action listener to the subtract button
        subtractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double number1 = Double.parseDouble(number1Field.getText());
                    double number2 = Double.parseDouble(number2Field.getText());
                    double result = number1 - number2;
                    resultLabel.setText("Result: " + result);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Please enter valid numbers.");
                }
            }
        });

        // Add the panel and result label to the frame
        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);
        frame.add(resultLabel, BorderLayout.SOUTH);

        // Set the frame to be visible
        frame.setVisible(true);
    }
}



