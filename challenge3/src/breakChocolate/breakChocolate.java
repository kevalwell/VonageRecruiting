package breakChocolate;

import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;





public class breakChocolate {

	//Instance variables
	private JFrame frame;
	private JTextField mText;
	private JTextField nText;
	private JTextArea result = new JTextArea();
	private int N;
	private int M;
	private int width = 400;
	private int height = 400;
	private int extend = 30;

	
	
	class MyCanvas extends JComponent {

		  public void paint(Graphics g) {
			  
			Color chocolate = new Color (123, 63, 0);
		    g.setColor(chocolate);
		    g.fillRect(100, 200, width, height);  
		    
		    g.setColor(Color.BLACK);   

		    //This draws the horizontal splitting lines
		    int wIncr = width/N;
		    for (int i = 1; i < N; i++)
		    {
		    	g.drawLine(100 + (i*wIncr), 200 - extend , 100 + (i*wIncr), 200 + height + extend);
		    }

		    //This draws the vertical splitting lines
		    int hIncr = height/M;
		    for (int i = 1; i < M; i++)
		    {
		    	g.drawLine(100 - extend, 200 + (i*hIncr) , 100 + width + extend, 200 + (i*hIncr));
		    }
		  }
		  
		}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					breakChocolate window = new breakChocolate();
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
	public breakChocolate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		
		JTextArea txtrThisProgramDraws = new JTextArea();
		txtrThisProgramDraws.setFont(new Font("Optima", Font.BOLD, 15));
		txtrThisProgramDraws.setText("This program draws a chocolate bar of dimensions n-by-m. It then splits the\n chocolate bar into n*m 1-by-1 square pieces and draws all breaking"
				+ " lines.");
		txtrThisProgramDraws.setEditable(false);
		txtrThisProgramDraws.setBounds(43, 25, 501, 52);
		frame.getContentPane().add(txtrThisProgramDraws);
		
		JTextArea txtrDimensions = new JTextArea();
		txtrDimensions.setText("Dimensions:");
		txtrDimensions.setFont(new Font("Optima", Font.BOLD, 15));
		txtrDimensions.setBounds(43, 89, 90, 19);
		frame.getContentPane().add(txtrDimensions);
		
		JTextArea txtrN = new JTextArea();
		txtrN.setText("N = ");
		txtrN.setFont(new Font("Optima", Font.BOLD, 15));
		txtrN.setBounds(226, 89, 34, 19);
		frame.getContentPane().add(txtrN);
		
		JTextArea txtrM = new JTextArea();
		txtrM.setText("M =");
		txtrM.setFont(new Font("Optima", Font.BOLD, 15));
		txtrM.setBounds(391, 89, 34, 19);
		frame.getContentPane().add(txtrM);
		
		mText = new JTextField();
		mText.setBounds(425, 84, 56, 28);
		frame.getContentPane().add(mText);
		mText.setColumns(10);
		
		nText = new JTextField();
		nText.setColumns(10);
		nText.setBounds(261, 84, 56, 28);
		frame.getContentPane().add(nText);
		
		result.setText("");
		result.setFont(new Font("Optima", Font.BOLD, 15));
		result.setBounds(210, 650, 250, 30);
		result.setVisible(false);
		frame.getContentPane().add(result);
		
		JButton draw = new JButton("Draw!");
		draw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (nText.getText().isEmpty() || mText.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please enter an integer for both dimensions!");
				}
				
				else
					
					  try {
						    N = Integer.parseInt(nText.getText());
						    M = Integer.parseInt((mText.getText()));
						    MyCanvas canvas = new MyCanvas();
							frame.getContentPane().add(canvas);
							frame.setVisible(true);
							result.setVisible(true);
							result.setText("Number of breaks required:  " + ((N*M) - 1));

						  } catch (NumberFormatException z) {
								JOptionPane.showMessageDialog(null, "Please enter correctly formatted integers!\nError: " + z);
						  }
				
				
			}
		});
		draw.setBounds(31, 120, 513, 29);
		frame.getContentPane().add(draw);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(43, 161, 501, 6);
		frame.getContentPane().add(separator);
		

	}

}
