import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener
{	
	int[] numbers;
	TextField sizeLabel;
	TextField numLabel;
	JLabel smallest;
	JLabel array;
	int counter = 0;
	int size = 0;
	
	public void CreateProgram()
	{
		JFrame program = new JFrame("Chocolate Bar");
		program.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(300, 300));
		
		sizeLabel = new TextField();
		sizeLabel.setPreferredSize(new Dimension(120, 30));
		numLabel = new TextField();
		numLabel.setPreferredSize(new Dimension(120, 30));
		smallest = new JLabel();
		array = new JLabel();
		
		
		JButton sizeSubmit = new JButton("Submit Size");
		JButton numSubmit = new JButton("Submit Number");
		JButton calcSmallest = new JButton("Calculate Smallest");
		
	    sizeSubmit.addActionListener(this);
	    numSubmit.addActionListener(this);
		calcSmallest.addActionListener(this);
		
		panel.add(sizeLabel);
		panel.add(sizeSubmit);
		panel.add(numLabel);
		panel.add(numSubmit);
		panel.add(calcSmallest);
		panel.add(smallest);
		panel.add(array);
		
		program.getContentPane().add(panel);
		program.setVisible(true);
		program.pack();
	}
		
	public void actionPerformed(ActionEvent e) throws ArrayIndexOutOfBoundsException
	{
		try
		{	
			String action = e.getActionCommand();
			if (action.equals("Submit Size"))
			{
				size = Integer.parseInt(sizeLabel.getText());
				numbers = new int[size];
				sizeLabel.setText("");
			}
			if (action.equals("Submit Number"))
			{
					numbers[counter] = Integer.parseInt(numLabel.getText());
					counter++;
					numLabel.setText("");
			}
			if (action.equals("Calculate Smallest"))
			{
				smallest.setText("Smallest Number: " + challenge2.calcLeast(numbers));
			}
		}
		catch (ArrayIndexOutOfBoundsException ae)
		{
			smallest.setText("Array out of bounds.");
		}
	}
	
	
	public static void main(String[] args) throws ArrayIndexOutOfBoundsException 
	{
			Main chal2 = new Main();
			chal2.CreateProgram();
	}
}
