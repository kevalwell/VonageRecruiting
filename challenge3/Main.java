import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener
{	
	int length = 0;
	int width = 0;
	TextField lengthLabel;
	TextField widthLabel;
	JLabel result;
	challenge3 calc = new challenge3();
	
	public void CreateProgram()
	{
		JFrame program = new JFrame("Chocolate Bar");
		program.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(300, 300));
		
		lengthLabel = new TextField();
		lengthLabel.setPreferredSize(new Dimension(120, 30));
		widthLabel = new TextField();
		widthLabel.setPreferredSize(new Dimension(120, 30));
		result = new JLabel();
		
		JButton lengthSubmit = new JButton("Submit Length");
		JButton widthSubmit = new JButton("Submit Width");
		JButton calcBreaks = new JButton("Calculate Breaks");
		
		lengthSubmit.addActionListener(this);
		widthSubmit.addActionListener(this);
		calcBreaks.addActionListener(this);
		
		panel.add(lengthLabel);
		panel.add(lengthSubmit);
		panel.add(widthLabel);
		panel.add(widthSubmit);
		panel.add(calcBreaks);
		panel.add(result);
		
		program.getContentPane().add(panel);
		program.setVisible(true);
		program.pack();
	}
		
	public void actionPerformed(ActionEvent e)
	{
		String action = e.getActionCommand();
		if (action.equals("Submit Length"))
		{
			length = Integer.parseInt(lengthLabel.getText());
			lengthLabel.setText("");
		}
		if (action.equals("Submit Width"))
		{
			width = Integer.parseInt(widthLabel.getText());
			widthLabel.setText("");
		}
		if (action.equals("Calculate Breaks"))
		{
			result.setText("Total Breaks: " + Integer.toString(challenge3.break_chocolate(length, width)));
		}
	}
	
	
	public static void main(String[] args)
	{
		Main chal3 = new Main();
		chal3.CreateProgram();
	}
}
