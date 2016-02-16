package parseInt;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JScrollPane;



public class parseInt {

	private JFrame frame;
	JLabel resultLabel = new JLabel("");
	JTextArea textField = new JTextArea();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					parseInt window = new parseInt();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public parseInt() {
		initialize();
	}
	

	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.textHighlight);
		frame.setBounds(100, 100, 484, 373);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea infoText = new JTextArea();
		infoText.setBackground(SystemColor.textHighlight);
		infoText.setWrapStyleWord(true);
		infoText.setEditable(false);
		infoText.setFont(new Font("Optima", Font.BOLD, 14));
		infoText.setText("This program will parse a string and extract a meaningful integer\n out of it, if it is to be found. If not, the program will return NaN.");
		infoText.setBounds(30, 19, 414, 44);
		frame.getContentPane().add(infoText);
		
		JLabel instructionText = new JLabel("Enter String Here:");
		instructionText.setFont(new Font("Optima", Font.BOLD, 14));
		instructionText.setBounds(64, 113, 128, 16);
		frame.getContentPane().add(instructionText);
		
		JLabel lblResult = new JLabel("Result:");
		lblResult.setFont(new Font("Optima", Font.BOLD, 14));
		lblResult.setBounds(47, 281, 70, 16);
		frame.getContentPane().add(lblResult);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(SystemColor.controlHighlight);
		separator.setBounds(46, 257, 360, 12);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(SystemColor.controlHighlight);
		separator_1.setBounds(46, 184, 360, 12);
		frame.getContentPane().add(separator_1);
		resultLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		resultLabel.setBackground(Color.BLACK);
		
		
		resultLabel.setBounds(134, 281, 268, 26);
		frame.getContentPane().add(resultLabel);
		
		JButton btnParseint = new JButton("parseInt()");
		
		btnParseint.setBackground(new Color(0, 255, 255));
		btnParseint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int number = parse(textField.getText());
				
				if (number == -1)
				{
					resultLabel.setText(String.valueOf(Double.NaN));
				}
				else resultLabel.setText(String.valueOf(number));

				
			}
		});
		btnParseint.setBounds(54, 208, 352, 37);
		frame.getContentPane().add(btnParseint);
		textField.setBounds(204, 72, 202, 100);
		frame.getContentPane().add(textField);
		

		

	}
	
	public enum stateDFA {
	    BEGIN, INTEGER, END, REJECT
	}
	
	private int parse(String text) 
	{
		int number = 0;
		
		if (text == null || text == "")
		{
			JOptionPane.showMessageDialog(null, "Cannot take an empty string!");
		}
		
		int length = text.length();
		
		stateDFA state = stateDFA.BEGIN;
		
		for (int i = 0; i < length; i++)
		{
			char c = text.charAt(i);
			
			if (Character.isDigit(c))
			{
				number *= 10;
				number += Character.digit(c, 10);
			}
			switch (state)
			{
			case BEGIN:
				state = handleBegin(c);
				break;
			case INTEGER:
				state = handleInteger(c);
				break;
			case END:
				state = handleEnd(c);
				break;
			case REJECT:
				return -1;
			}
		}
		
		if (state == stateDFA.REJECT) return -1;
		
		else return number;
	}
	
	private stateDFA handleBegin(char c)
	{
		if (c == ' ' || c == '\n' || c == '\t')
		{
			return stateDFA.BEGIN;
		}
		else if ( Character.isDigit(c))
		{
			return stateDFA.INTEGER;
		}
		else return stateDFA.REJECT;
	}
	
	private stateDFA handleInteger(char c)
	{
		if (c == ' ' || c == '\n' || c == '\t')
		{
			return stateDFA.END;
		}
		else if ( Character.isDigit(c))
		{
			return stateDFA.INTEGER;
		}
		else return stateDFA.REJECT;
	}
	
	private stateDFA handleEnd(char c)
	{
		if (c == ' ' || c == '\n' || c == '\t')
		{
			return stateDFA.END;
		}
		else return stateDFA.REJECT;
	}
}
