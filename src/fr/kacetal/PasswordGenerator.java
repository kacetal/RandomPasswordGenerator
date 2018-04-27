package fr.kacetal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import fr.kacetal.staticGenerators.*;

public class PasswordGenerator {
	
	private JButton generateButton;
	
	private JCheckBox checkBox09, checkBoxAZ, checkBoxaz;
	
	private JSpinner spinnerPasswordLength;
	
	private JTextField textPassword;
	
	private String result;
	
	private void createGUI() {
		JFrame mainFrame = new JFrame("Password Generator");
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel(new BorderLayout());
		JPanel topPanel = new JPanel(new FlowLayout());
		
		Font mainFont = new Font(Font.SERIF, Font.BOLD, 18);
		
		generateButton = new JButton("Generate Password");
		generateButton.setFont(mainFont);
		generateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				passwordGenerator();				
			}
		});
		
		checkBox09 = new JCheckBox("0 - 9");
		checkBox09.setFont(mainFont);
		checkBoxAZ = new JCheckBox("A - Z");
		checkBoxAZ.setFont(mainFont);
		checkBoxaz = new JCheckBox("a - z");
		checkBoxaz.setFont(mainFont);
		
		SpinnerModel modelSpinnerPasswordLength = new SpinnerNumberModel(20, 1, 40, 1);
		spinnerPasswordLength = new JSpinner(modelSpinnerPasswordLength);
		spinnerPasswordLength.setFont(mainFont);
		
		JLabel spinnerLabel = new JLabel("Password length");
		spinnerLabel.setFont(mainFont);
		
		textPassword = new JTextField("PASSWORD");
		textPassword.setFont(mainFont);
		textPassword.setHorizontalAlignment(JTextField.CENTER);
		textPassword.setEditable(false);
		
		topPanel.add(checkBox09);
		topPanel.add(checkBoxAZ);
		topPanel.add(checkBoxaz);
		topPanel.add(spinnerLabel);
		topPanel.add(spinnerPasswordLength);
		
		mainPanel.add(topPanel, BorderLayout.NORTH);
		mainPanel.add(textPassword, BorderLayout.CENTER);
		mainPanel.add(generateButton, BorderLayout.SOUTH);
		
		mainFrame.getContentPane().add(mainPanel);
		mainFrame.setPreferredSize(new Dimension(500, 150));
		mainFrame.setResizable(false);
		mainFrame.pack();
		mainFrame.setVisible(true);
		
	}
	
	private void passwordGenerator() {

        int maxLengthPassword = (int) spinnerPasswordLength.getValue();

        int counter = 0;
        
        result = "";
        
        if ( !(checkBox09.isSelected() || checkBoxAZ.isSelected() || checkBoxaz.isSelected()) ) {			
        	textPassword.setText("JUST CHECK IT!");
        	return;
		}

        while (true) {
            result += GeneratorASCIIChar.generateRandomASCIIChar(checkBox09.isSelected(), checkBoxAZ.isSelected(), checkBoxaz.isSelected());
            counter++;
            if (counter == maxLengthPassword) break;
        }
        textPassword.setText(result);
	}
	
	public static void main(String[] args) {
		PasswordGenerator frame = new PasswordGenerator();
		frame.createGUI();
	}
	
}
