import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class GUI {

	/* Constants defined here for clarity */
	private static JFrame frame = new JFrame("Sudoku Solver"); 
	
	
	/**
	 * Launches the application
	 */
	public static void main(String[] args) { 
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() { 
				createAndShow();
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
		
		frame.pack();
		// shows the window 
		frame.setVisible(true);
		
	}
	
	/**
	 * Initialise the elements of the frame 
	 */
	private static void initialise() { 
		
		// creates the boundaries of the window 
		frame.setBounds(0, 0, 1200, 600);
		
		// creates a new layout
		GridBagLayout gridBagLayout = new GridBagLayout();
		
		// sets layout of frame to be of gbl
		frame.setLayout(gridBagLayout);
		
		// create a "Original" label and position it correctly in the pane
		JLabel original = new JLabel("Original");
		GridBagConstraints gbc_originalLabel = new GridBagConstraints();
		gbc_originalLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_originalLabel.gridx = 0;
		gbc_originalLabel.gridy = 0;
		frame.add(original, gbc_originalLabel);
		
		// create a solve button and position it correctly in the pane
		JButton solve = new JButton("Solve");
		GridBagConstraints gbc_solveButton = new GridBagConstraints();
		gbc_solveButton.gridx = 1;
		gbc_solveButton.gridx = 1;
		frame.add(solve, gbc_solveButton);
	}
}
