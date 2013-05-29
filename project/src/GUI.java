import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class GUI {

	/* Constants defined here for clarity */
	private static JFrame frame = new JFrame("Sudoku Solver"); 
	private static Container pane = new Container ();
	// hoduku
	
	
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
		
		// creates the boundaries of the window (where the window appears x, and y, height of window, width of window)
		// frame.setBounds(0, 0, 1200, 600);
		
		pane.setBounds(0, 0, 1200, 600);
		
		//pane.setSize(1200, 1000);
		
		// creates a new layout
		GridBagLayout gridBagLayout = new GridBagLayout();
		
		// sets layout of frame to be of GridBagLayout
		pane.setLayout(gridBagLayout);
		
		// create a "Original" label and position it correctly in the pane
		JLabel original = new JLabel("Original");
		GridBagConstraints gbc_originalLabel = new GridBagConstraints();
		gbc_originalLabel.gridx = 0;
		gbc_originalLabel.gridy = 0;
		gbc_originalLabel.ipadx = 600;
		pane.add(original, gbc_originalLabel);
		
		// create a "Solved" label and position it correctly in the pane
		JLabel solved = new JLabel("Solved");
		GridBagConstraints gbc_solvedLabel = new GridBagConstraints();
		gbc_solvedLabel.gridx = 600;
		gbc_solvedLabel.gridy = 0;
		gbc_solvedLabel.ipadx = 600;
		pane.add(solved, gbc_solvedLabel);

		
		// create a solve button and position it correctly in the pane
		JButton solve = new JButton("Solve");
		GridBagConstraints gbc_solveButton = new GridBagConstraints();
		gbc_solveButton.gridx = 100;
		gbc_solveButton.gridy = 100;
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
		gbc_exitButton.gridy = 100;
		pane.add(exit, gbc_exitButton);
		

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(pane);
		frame.pack();
		frame.setVisible(true);

	}
}
