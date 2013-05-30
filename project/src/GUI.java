import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class GUI {

	/* Constants defined here for clarity */
	private static JFrame frame = new JFrame("Sudoku Solver"); 
	private static Container pane = new Container ();
	private static Dimension frameSize = new Dimension (800, 500);
	private static Insets gridInsets = new Insets (10, 10, 10, 10);
	
	
	/**
	 * Launches the application
	 */
	public static void main(String[] args) { 
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() { 
				//createAndShow();
				initialise();
			}
		});
	}

	/**
	 * Creates and show the window
	 */
	private static void createAndShow() { 
		
		// forces the application to close when the program is exited.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.add(pane);
		
		frame.pack();
		// shows the window 
		frame.setVisible(true);
		
	}
	
	/**
	 * Initialise the elements of the frame 
	 */
	private static void initialise() { 
		
		frame.setSize(frameSize);
		
		// creates a new layout
		GridBagLayout gridBagLayout = new GridBagLayout();
		
		//GridLayout gridLayout = new GridLayout(10, 10);
		
		// sets layout of frame to be of GridBagLayout
		pane.setLayout(gridBagLayout);
		
		// create a "Original" label and position it correctly in the pane
		JLabel original = new JLabel("Original");
		GridBagConstraints gbc_originalLabel = new GridBagConstraints();
		gbc_originalLabel.gridx = 0;
		gbc_originalLabel.gridy = 0;
		gbc_originalLabel.fill = gbc_originalLabel.HORIZONTAL;
		pane.add(original, gbc_originalLabel);
	
		GridBagConstraints gbc_leftNineByNine = new GridBagConstraints();
		gbc_leftNineByNine.gridx = 2;
		gbc_leftNineByNine.gridy = 1;
		gbc_leftNineByNine.fill = GridBagConstraints.BOTH;
		pane.add(create9x9(), gbc_leftNineByNine);
		
		// create a "Solved" label and position it correctly in the pane
		JLabel solved = new JLabel("Solved");
		GridBagConstraints gbc_solvedLabel = new GridBagConstraints();
		gbc_solvedLabel.gridx = 600;
		gbc_solvedLabel.gridy = 0;
		gbc_solvedLabel.insets = gridInsets;
		pane.add(solved, gbc_solvedLabel);
		
		GridBagConstraints gbc_rightNineByNine = new GridBagConstraints();
		gbc_rightNineByNine.gridx = 700;
		gbc_rightNineByNine.gridy = 1;
	//	gbc_rightNineByNine.fill = GridBagConstraints.BOTH;
		pane.add(create9x9(), gbc_rightNineByNine);

		// create a solve button and position it correctly in the pane
		JButton solve = new JButton("Solve");
		GridBagConstraints gbc_solveButton = new GridBagConstraints();
		gbc_solveButton.gridx = 150;
		gbc_solveButton.gridy = 500;
		pane.add(solve, gbc_solveButton);
	
		// create an exit button and position it correctly in the pane
		JButton exit = new JButton("Exit");
		exit.addMouseListener(new MouseAdapter() {			// exit button's functionality 
			@Override				
			public void mouseClicked(MouseEvent evt){		// on mouse click 
				System.exit(0);								// system exit
			}
		});
		GridBagConstraints gbc_exitButton = new GridBagConstraints();
		gbc_exitButton.gridx = 500;
		gbc_exitButton.gridy = 500;
		gbc_exitButton.fill = GridBagConstraints.BOTH;
		pane.add(exit, gbc_exitButton);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(pane);
		frame.setVisible(true);

	}
	
	public static JPanel create9x9() { 
		
		JPanel inner = null;
		JPanel outer =  new JPanel(new GridLayout(3,3));
		for (int k =0; k<9; k++) {
			inner = new JPanel(new GridLayout(3,3));
			inner.setBorder(BorderFactory.createLineBorder(Color.black));
			for(int i =0; i <=8; i++){
				inner.add(new JTextField(1));
			}
			for(int i = 0; i <=8; i++){
				outer.add(inner);
			}
		}
		return outer;
	}
	
	
}