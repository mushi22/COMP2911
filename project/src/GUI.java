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
	private JFrame frame = new JFrame("Sudoku Solver"); 
	private Container pane = new Container();
	private Dimension frameSize = new Dimension(800, 500);
	private Insets gridInsets = new Insets(10, 10, 10, 10);
	private GUI gui;
	private JPanel left;
	private JPanel right;
	
	/* Constructors */
	public GUI() { 
		
	}
	
	/**
	 * Initialise the elements of the frame 
	 */
	public void initialise() throws InterruptedException { 
		
		gui = new GUI();
		
		gui.frame.setSize(gui.frameSize);
		
		// creates a new layout
		GridBagLayout gridBagLayout = new GridBagLayout();
		
		// sets layout of frame to be of GridBagLayout
		gui.pane.setLayout(gridBagLayout);
		
		// create a "Original" label and position it correctly in the pane
		JLabel original = new JLabel("Original");
		GridBagConstraints gbc_originalLabel = new GridBagConstraints();
		gbc_originalLabel.gridx = 0;
		gbc_originalLabel.gridy = 0;
		gbc_originalLabel.fill = GridBagConstraints.HORIZONTAL;
		gui.pane.add(original, gbc_originalLabel);
	
		// create a 9x9 grid on the left panel under the Original label
		GridBagConstraints gbc_leftNineByNine = new GridBagConstraints();
		gbc_leftNineByNine.gridx = 0;
		gbc_leftNineByNine.gridy = 1;
		gbc_leftNineByNine.fill = GridBagConstraints.BOTH;
		left = gui.createLeft9x9();
		gui.pane.add(left, gbc_leftNineByNine);
		
		// create a "Solved" label and position it correctly in the pane
		JLabel solved = new JLabel("Solved");
		GridBagConstraints gbc_solvedLabel = new GridBagConstraints();
		gbc_solvedLabel.gridx = 600;
		gbc_solvedLabel.gridy = 0;
		gbc_solvedLabel.insets = gui.gridInsets;
		gui.pane.add(solved, gbc_solvedLabel);
		
		// create a 9x9 grid on the right panel under the Solved label
		GridBagConstraints gbc_rightNineByNine = new GridBagConstraints();
		gbc_rightNineByNine.gridx = 600;
		gbc_rightNineByNine.gridy = 1;
		gbc_rightNineByNine.fill = GridBagConstraints.BOTH;
		right = gui.createRight9x9();
		gui.pane.add(right, gbc_rightNineByNine);
	
		// create a solve button and position it correctly in the pane
		JButton solve = new JButton("Solve");
		solve.addMouseListener(new MouseAdapter() {
		   @Override
		   public void mouseClicked(MouseEvent evt){
                       gui.pane.remove(right);
		      GridBagConstraints gbc_rightNineByNine = new GridBagConstraints();
		gbc_rightNineByNine.gridx = 600;
		gbc_rightNineByNine.gridy = 1;
		gbc_rightNineByNine.fill = GridBagConstraints.BOTH;
                right=gui.updateRight9x9();
		gui.pane.add(right, gbc_rightNineByNine);
                gui.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.frame.add(gui.pane);
		gui.frame.setVisible(true);
		   }
		});
		GridBagConstraints gbc_solveButton = new GridBagConstraints();
		gbc_solveButton.gridx = 400;
		gbc_solveButton.gridy = 100;
		gui.pane.add(solve, gbc_solveButton);

		// create an exit button and position it correctly in the pane
		JButton exit = new JButton("Exit");
		exit.addMouseListener(new MouseAdapter() {			// exit button's functionality 
			@Override				
			public void mouseClicked(MouseEvent evt){		// on mouse click 
				System.exit(0);								// system exit
			}
		});
		GridBagConstraints gbc_exitButton = new GridBagConstraints();
		gbc_exitButton.gridx = 400;
		gbc_exitButton.gridy = 200;
		gbc_exitButton.fill = GridBagConstraints.BOTH;
		gui.pane.add(exit, gbc_exitButton);
		gui.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.frame.add(gui.pane);
		gui.frame.setVisible(true);
	}
	
	public JPanel createLeft9x9() { 
		
		JPanel inner = null;
		JPanel outer =  new JPanel(new GridLayout(3,3));
		Dimension dimSize = new Dimension (100, 100);
		
		GUIController guiController = new GUIController();
		int[][] board = guiController.getBoardArray().getBoard();
		
		for (int i = 0; i < 9; i++) {	
			inner = new JPanel(new GridLayout(3, 3));
			inner.setBorder(BorderFactory.createLineBorder(Color.black));
			for(int j = 0; j <= 8; j++) {
				int cellValue = 0;							// create an int 
				cellValue = board[3*(i / 3) + j/3][3*(i % 3) + j%3];					// to store the board number
				Integer newInt = new Integer(cellValue);	// change the type to an Integer
				String stringCellValue = newInt.toString();	// allowing us to convert it to a string
				inner.add(new JTextField(stringCellValue));	// add the string value 
				inner.setPreferredSize(dimSize);			// set the size 
			}
			for(int k = 0; k <=8; k++) {		// add the 3x3 into the big pane
				outer.add(inner);
			}
		}
		return outer;
	}
	public JPanel createRight9x9() { 
		
		JPanel inner = null;
		JPanel outer =  new JPanel(new GridLayout(3,3));
		JTextField[][] numbers = new JTextField[9][9];
		Dimension dimSize = new Dimension (100, 100);
		
		for (int k = 0; k < 9; k++) {
			inner = new JPanel(new GridLayout(3,3));
			inner.setBorder(BorderFactory.createLineBorder(Color.black));
			for(int i = 0; i <= 8; i++){
				numbers[i][k] = new JTextField();
				inner.add(numbers[i][k]);
				inner.setPreferredSize(dimSize);
			}
			for(int i = 0; i <=8; i++){
				outer.add(inner);
			}
		}
		return outer;
	}

	public JPanel updateRight9x9() { 
		
		JPanel inner = null;
		JPanel outer =  new JPanel(new GridLayout(3,3));
		Dimension dimSize = new Dimension (100, 100);
		
		GUIController guiController = new GUIController();
		int[][] board = guiController.getSolvedBoardArray().getBoard();
		for (int i = 0; i < 9; i++) {	
			inner = new JPanel(new GridLayout(3, 3));
			inner.setBorder(BorderFactory.createLineBorder(Color.black));
			for(int j = 0; j <= 8; j++) {
				int cellValue = 0;							// create an int 
				cellValue = board[3*(i / 3) + j/3][3*(i % 3) + j%3];					// to store the board number
				Integer newInt = new Integer(cellValue);	// change the type to an Integer
				String stringCellValue = newInt.toString();	// allowing us to convert it to a string
				inner.add(new JTextField(stringCellValue));	// add the string value 
				inner.setPreferredSize(dimSize);			// set the size 
			}
			for(int k = 0; k <=8; k++) {		// add the 3x3 into the big pane
				outer.add(inner);
			}
		}
		return outer;
	
	}
}
		
