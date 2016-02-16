package minElement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import java.awt.Color;

public class minElement {

	//Instance variables
	private JFrame frame;
	private JTextField numIntsText;
	private int[] numArray;
	private JTextArea arrayText = new JTextArea();
	private int length;
	private JLabel currentMin = new JLabel("");
	private JLabel currentElement = new JLabel("");
	private JLabel minElement = new JLabel("");
	private boolean arrayGenerated = false;


	//Constructor
	public minElement() {
		//Initialize application
		initialize();
	}
	

	//Initialize the main window frame and populate its contents
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 204, 204));
		frame.setBounds(100, 100, 497, 486);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea infoText = new JTextArea();
		infoText.setBackground(new Color(255, 204, 204));
		infoText.setFont(new Font("Optima", Font.BOLD, 14));
		infoText.setEditable(false);
		infoText.setText("This program will generate an array of n random integers.\n Then it will find the minimum element in linear time.");
		infoText.setBounds(58, 18, 373, 63);
		frame.getContentPane().add(infoText);
		
		JLabel infoText2 = new JLabel("Number of random integers to generate:");
		infoText2.setFont(new Font("Optima", Font.BOLD, 14));
		infoText2.setBounds(58, 110, 269, 16);
		frame.getContentPane().add(infoText2);
		
		numIntsText = new JTextField();
		numIntsText.setBounds(328, 104, 101, 28);
		frame.getContentPane().add(numIntsText);
		numIntsText.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(237, 93, 1, 12);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.RED);
		separator_1.setBounds(58, 93, 374, 12);
		frame.getContentPane().add(separator_1);
		

		infoText.setEditable(false);
		arrayText.setWrapStyleWord(true);
		arrayText.setLineWrap(true);
		arrayText.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(arrayText);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(58, 200, 373, 70);
		frame.getContentPane().add(scrollPane);
		
		
		JButton genArray = new JButton("Generate Array");
		genArray.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Clearing any previous text
				minElement.setText("");
				currentMin.setText("");
				currentElement.setText("");
				
				//Checking for user input correctness
				if (numIntsText.getText().isEmpty() || Integer.parseInt(numIntsText.getText()) < 1)
				{
					JOptionPane.showMessageDialog(null, "Please enter a positive integer!");
				}
				
				else
				{
					arrayGenerated = true;
					 length = Integer.parseInt(numIntsText.getText());
					numArray = new int[length];

					//Using StringBuilder for concatenation for speed and memory efficiency
					StringBuilder str = new StringBuilder();
					
					//Generating random ints ranging from +100000 to -100000
					for (int i = 0; i < length; i++)
					{
						int random = (int) (100000 * Math.random());
						if (Math.random() < 0.5) random = -random;
						numArray[i] = random;
						
						str.append("[" + random + "], ");
											}
					
					int strLength = str.length();
					str.delete(strLength - 2, strLength);
					
					//Adding the array of ints to the JTextArea in text form
					arrayText.setText(str.toString());
				}
			}
		});
		
		genArray.setBounds(58, 163, 373, 29);
		frame.getContentPane().add(genArray);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(Color.RED);
		separator_2.setBounds(58, 139, 374, 12);
		frame.getContentPane().add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBackground(Color.RED);
		separator_3.setBounds(58, 287, 374, 12);
		frame.getContentPane().add(separator_3);
		
		JLabel lblCurrentMin = new JLabel("Current Min:");
		lblCurrentMin.setFont(new Font("Optima", Font.BOLD, 14));
		lblCurrentMin.setBounds(58, 352, 84, 22);
		frame.getContentPane().add(lblCurrentMin);
		
		currentMin.setFont(new Font("Optima", Font.BOLD, 14));
		currentMin.setBounds(142, 352, 57, 22);
		frame.getContentPane().add(currentMin);
		
		JLabel lblCurrentElement = new JLabel("Current Element:");
		lblCurrentElement.setFont(new Font("Optima", Font.BOLD, 14));
		lblCurrentElement.setBounds(256, 352, 115, 22);
		frame.getContentPane().add(lblCurrentElement);
		
		currentElement.setFont(new Font("Optima", Font.BOLD, 14));
		currentElement.setBounds(369, 352, 57, 22);
		frame.getContentPane().add(currentElement);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBackground(Color.RED);
		separator_4.setBounds(57, 385, 374, 12);
		frame.getContentPane().add(separator_4);
		
		minElement.setEnabled(false);
		minElement.setFont(new Font("Optima", Font.BOLD, 16));
		minElement.setBounds(104, 409, 280, 22);
		frame.getContentPane().add(minElement);
		
		
		JButton findMin = new JButton("Find Minimum Element in Array");
		findMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!arrayGenerated) JOptionPane.showMessageDialog(null, "Please generate an array of random integers first!");
				
				else
				{
				
				int tempMin = Integer.MAX_VALUE;
				currentMin.setText(String.valueOf(tempMin));
				numIntsText.setText("");
				
				//Simple run through the array to find the the minimum value
				for (int i = 0; i < length; i++)
				{
					currentElement.setText(String.valueOf(numArray[i]));
					
					if (tempMin > numArray[i]) tempMin = numArray[i];
					
					currentMin.setText(String.valueOf(tempMin));

				}
				
				//Updating JLabels to display info
				minElement.setEnabled(true);
				minElement.setText("Minimum Element is:   " + tempMin);
				currentElement.setEnabled(false);
				currentMin.setEnabled(false);
				
			}
			}
		});
		findMin.setBounds(58, 311, 373, 29);
		frame.getContentPane().add(findMin);
	}
	
	
	//Launches a new window to begin the application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					minElement window = new minElement();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
