
// set the package name
package com.dellpogie;

// add reference to Swing library
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

// add reference to Abstract Window Toolkit
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// BasicCalculator class is inheriting from the JFrame class, part of the Swing library
public class BasicCalculator extends JFrame implements ActionListener {

    // declare input and result text field
    private final JTextField txtField;

    // declare number buttons
    private final JButton[] btnNumber;

    // declare operator buttons
    private final JButton btnAdd;
    private final JButton btnSubtract;
    private final JButton btnMultiply;
    private final JButton btnDivide;
    private final JButton btnEquals;
    private final JButton btnClear;

    // declare panel for buttons
    private final JPanel panel;

    // declare and initialize inputs and result variable
    private double num1 = 0, num2 = 0, result = 0;

    // declare mathematical operator
    private char operator;

    // declare and initialize font
    private final Font myFont = new Font("Arial", Font.BOLD, 20);

    // create a constructor
    public BasicCalculator() {

        // initialize the frame
        this.setTitle("Basic Calculator");
        this.setSize(400, 550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        // initialize the input and result text field
        txtField = new JTextField();
        txtField.setBounds(50, 25, 300, 50);
        txtField.setFont(myFont);
        txtField.setEditable(false);
        this.add(txtField);

        // initialize the number buttons
        btnNumber = new JButton[10];
        for (int i = 0; i < 10; i++) {
            btnNumber[i] = new JButton(String.valueOf(i));
            btnNumber[i].setFont(myFont);
            btnNumber[i].addActionListener(this);
        }

        // initialize the function buttons
        btnAdd = new JButton("+");
        btnSubtract = new JButton("-");
        btnMultiply = new JButton("*");
        btnDivide = new JButton("/");
        btnEquals = new JButton("=");
        btnClear = new JButton("C");

        // add action listeners for function buttons
        btnAdd.addActionListener(this);
        btnSubtract.addActionListener(this);
        btnMultiply.addActionListener(this);
        btnDivide.addActionListener(this);
        btnEquals.addActionListener(this);
        btnClear.addActionListener(this);

        // initialize fonts for function buttons
        btnAdd.setFont(myFont);
        btnSubtract.setFont(myFont);
        btnMultiply.setFont(myFont);
        btnDivide.setFont(myFont);
        btnEquals.setFont(myFont);
        btnClear.setFont(myFont);

        // initialize panel for the buttons
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // add buttons to the panel
        panel.add(btnNumber[1]);
        panel.add(btnNumber[2]);
        panel.add(btnNumber[3]);
        panel.add(btnAdd);
        panel.add(btnNumber[4]);
        panel.add(btnNumber[5]);
        panel.add(btnNumber[6]);
        panel.add(btnSubtract);
        panel.add(btnNumber[7]);
        panel.add(btnNumber[8]);
        panel.add(btnNumber[9]);
        panel.add(btnMultiply);
        panel.add(btnClear);
        panel.add(btnNumber[0]);
        panel.add(btnEquals);
        panel.add(btnDivide);

        // display in the form
        this.add(panel);
        this.setVisible(true);

    }

    // create an action listener method
    @Override
    public void actionPerformed(ActionEvent e) {

        // logic to identify the number that was clicked by the user
        for (int i = 0; i < 10; i++) {
            // if number is identified then ...
            if (e.getSource() == btnNumber[i]) {
                // the number will then be displayed in the input and result text field
                txtField.setText(txtField.getText() + i);
            }
        }

        // addition listener logic
        if (e.getSource() == btnAdd) {
            // scan the first number input
            num1 = Double.parseDouble(txtField.getText());
            // set add operator
            operator = '+';
            // clear the input and result text field
            txtField.setText("");
        }

        // subtraction listener logic
        if (e.getSource() == btnSubtract) {
            // scan the first number input
            num1 = Double.parseDouble(txtField.getText());
            // set subtract operator
            operator = '-';
            // clear the input and result text field
            txtField.setText("");
        }

        // multiplication listener logic
        if (e.getSource() == btnMultiply) {
            // scan the first number input
            num1 = Double.parseDouble(txtField.getText());
            // set multiply operator
            operator = '*';
            // clear the input and result text field
            txtField.setText("");
        }

        // division listener logic
        if (e.getSource() == btnDivide) {
            // scan the first number input
            num1 = Double.parseDouble(txtField.getText());
            // set divide operator
            operator = '/';
            // clear the input and result text field
            txtField.setText("");
        }

        // results listener logic
        if (e.getSource() == btnEquals) {
            // scan the second number input
            num2 = Double.parseDouble(txtField.getText());

            // calculate based on the selected operator
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }

            // display the result
            txtField.setText(String.valueOf(result));

            // logic for lengthy operations
            // assign the result value as first number input (save in memory),
            // waiting for the second number from the user
            num1 = result;

        }

        // if the user clicks the Clear or C button
        if (e.getSource() == btnClear) {
            // clear the input and result text field
            txtField.setText("");
            // clear result from memory
            result = 0;
        }
    }

    // entry point in Java
    public static void main(String[] args) {

        // create calculator instance
        new BasicCalculator();

    }
}
