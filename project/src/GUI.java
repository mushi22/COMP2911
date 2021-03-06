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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI
{

   /* Constants defined here for clarity */
   private JFrame frame = new JFrame("Sudoku Solver");
   private Container pane = new Container();
   private Dimension frameSize = new Dimension(800, 500);
   private Insets gridInsets = new Insets(10, 10, 10, 10);
   private GUI gui;
   private JPanel left;
   private JPanel right;
   private SudokuBoard puzzle;
   private SudokuBoard solvedPuzzle;

   /* Constructors */
   public GUI()
   {
      GUIController guiController = new GUIController();
      // puzzle = guiController.getBoard();
      puzzle = guiController.getGeneratedBoard();
      SolveSudoku tester = new SolveSudoku();
      solvedPuzzle = puzzle.copy();
      solvedPuzzle = tester.recursiveBruteForceSolver(solvedPuzzle);
   }

   /* Methods */
   /**
    * Initialise the elements of the frame
    */
   public void initialise() throws InterruptedException
   {

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
      gui.pane.add(original, gbc_originalLabel);

      // create a 9x9 grid on the left panel under the Original label
      GridBagConstraints gbc_leftNineByNine = new GridBagConstraints();
      gbc_leftNineByNine.gridx = 0;
      gbc_leftNineByNine.gridy = 1;
      // gbc_leftNineByNine.fill = GridBagConstraints.BOTH;
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
      solve.addMouseListener(new MouseAdapter()
      {
         @Override
         public void mouseClicked(MouseEvent evt)
         {
            gui.pane.remove(right);
            GridBagConstraints gbc_rightNineByNine = new GridBagConstraints();
            gbc_rightNineByNine.gridx = 600;
            gbc_rightNineByNine.gridy = 1;
            gbc_rightNineByNine.fill = GridBagConstraints.BOTH;

            long startTime = System.currentTimeMillis();
            right = gui.updateRight9x9();
            long endTime = System.currentTimeMillis();

            // create a textfield showing how long it takes to solve
            JTextArea timeTook = new JTextArea("Time taken: " + (endTime - startTime) + " milliseconds");
            GridBagConstraints gbc_timeTakeArea = new GridBagConstraints();
            gbc_timeTakeArea.gridx = 600;
            gbc_timeTakeArea.gridy = 500;
            gbc_timeTakeArea.fill = 100;
            gui.pane.add(timeTook, gbc_timeTakeArea);

            gui.pane.add(right, gbc_rightNineByNine);
            gui.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gui.frame.add(gui.pane);
            gui.frame.setVisible(true);

         }
      });

      GridBagConstraints gbc_solveButton = new GridBagConstraints();
      gbc_solveButton.gridx = 600;
      gbc_solveButton.gridy = 100;
      gui.pane.add(solve, gbc_solveButton);

      // create an exit button and position it correctly in the pane
      JButton exit = new JButton("Exit");
      exit.addMouseListener(new MouseAdapter()
      {
         // exit button's functionality
         @Override
         public void mouseClicked(MouseEvent evt)
         { // on mouse click
            System.exit(0); // system exit
         }
      });
      GridBagConstraints gbc_exitButton = new GridBagConstraints();
      gbc_exitButton.gridx = 400;
      gbc_exitButton.gridy = 200;
      gbc_exitButton.fill = GridBagConstraints.BOTH;
      gui.pane.add(exit, gbc_exitButton);

      // create an load sudoku button and position it correctly in the pane
      JButton loadSudoku = new JButton("Load Sudoku");
      loadSudoku.addMouseListener(new MouseAdapter()
      {
         // loadSudoku button's functionality
         @Override
         public void mouseClicked(MouseEvent evt)
         { // on mouse click
            GridBagConstraints gbc_leftNineByNineWithInput = new GridBagConstraints();
            gbc_leftNineByNineWithInput.gridx = 0;
            gbc_leftNineByNineWithInput.gridy = 1;
            gbc_leftNineByNineWithInput.fill = GridBagConstraints.BOTH;

            String fileName = JOptionPane.showInputDialog(null,
                  "Please enter a valid filename. ", "Choose a File", JOptionPane.QUESTION_MESSAGE);
            SudokuFileReader sudokuInput = new SudokuFileReader();
            // puzzle = sudokuInput.readInFile(fileName);
            left = gui.updateLeft9x9WithInput(fileName);

            gui.pane.add(left, gbc_leftNineByNineWithInput);
            gui.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gui.frame.add(gui.pane);
            gui.frame.setVisible(true);
         }
      });
      GridBagConstraints gbc_loadSudokuButton = new GridBagConstraints();
      gbc_loadSudokuButton.gridx = 400;
      gbc_loadSudokuButton.gridy = 100;
      gbc_loadSudokuButton.fill = GridBagConstraints.BOTH;
      gui.pane.add(loadSudoku, gbc_loadSudokuButton);

      // create a button that generates a new sudoku
      JButton generate = new JButton("Generate Sudoku");
      generate.addMouseListener(new MouseAdapter()
      {
         @Override
         public void mouseClicked(MouseEvent evt)
         {
            GridBagConstraints gbc_leftNineByNine = new GridBagConstraints();
            gbc_leftNineByNine.gridx = 0;
            gbc_leftNineByNine.gridy = 1;
            gbc_leftNineByNine.fill = GridBagConstraints.BOTH;
            long startTime = System.currentTimeMillis();
            left = gui.updateLeft9x9();
            long endTime = System.currentTimeMillis();

            // create a textfield showing how long it takes to generate
            JTextArea timeTook = new JTextArea("Time taken: " + (endTime - startTime) + " milliseconds");
            GridBagConstraints gbc_timeTakeArea = new GridBagConstraints();
            gbc_timeTakeArea.gridx = 0;
            gbc_timeTakeArea.gridy = 500;
            gbc_timeTakeArea.fill = 100;
            gui.pane.add(timeTook, gbc_timeTakeArea);

            gui.pane.add(left, gbc_leftNineByNine);
            gui.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gui.frame.add(gui.pane);
            gui.frame.setVisible(true);
         }
      });

      GridBagConstraints gbc_generateButton = new GridBagConstraints();
      gbc_generateButton.gridx = 0;
      gbc_generateButton.gridy = 100;
      // gbc_generateButton.fill = GridBagConstraints.BOTH;
      gui.pane.add(generate, gbc_generateButton);

      gui.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      gui.frame.add(gui.pane);
      gui.frame.setVisible(true);
   }

   /**
    * Creates the grid for the left side of the window.
    * 
    * @return the created grid
    */
   public JPanel createLeft9x9()
   {
      JPanel inner = null;
      JPanel outer = new JPanel(new GridLayout(3, 3));
      Dimension dimSize = new Dimension(100, 100);

      for (int i = 0; i < 9; i++) {
         inner = new JPanel(new GridLayout(3, 3));
         inner.setBorder(BorderFactory.createLineBorder(Color.black));
         for (int j = 0; j <= 8; j++) {
            int cellValue = 0; // create an int
            cellValue = puzzle.getBoardArray()[3 * (i / 3) + j / 3][3 * (i % 3) + j % 3];
            Integer newInt = new Integer(cellValue);
            String stringCellValue = newInt.toString(); 
            inner.add(new JTextField(stringCellValue));
            inner.setPreferredSize(dimSize);
         }
         for (int k = 0; k <= 8; k++) { 
            // add the 3x3 into the big pane
            outer.add(inner);
         }
      }
      return outer;
   }

   /**
    * Creates the grid for the right side of the window.
    * 
    * @return the created grid
    */
   public JPanel createRight9x9()
   {
      JPanel inner = null;
      JPanel outer = new JPanel(new GridLayout(3, 3));
      JTextField[][] numbers = new JTextField[9][9];
      Dimension dimSize = new Dimension(100, 100);

      for (int k = 0; k < 9; k++) {
         inner = new JPanel(new GridLayout(3, 3));
         inner.setBorder(BorderFactory.createLineBorder(Color.black));
         for (int i = 0; i <= 8; i++) {
            numbers[i][k] = new JTextField();
            inner.add(numbers[i][k]);
            inner.setPreferredSize(dimSize);
         }
         for (int i = 0; i <= 8; i++) {
            outer.add(inner);
         }
      }
      return outer;
   }

   /**
    * Updates the left side grid which contains the new sudoku.
    * 
    * @return updated grid with correct solution
    */
   public JPanel updateLeft9x9()
   {
      GUIController guiController = new GUIController();
      puzzle = guiController.getGeneratedBoard();

      JPanel inner = null;
      JPanel outer = new JPanel(new GridLayout(3, 3));
      Dimension dimSize = new Dimension(100, 100);

      for (int i = 0; i < 9; i++) {
         inner = new JPanel(new GridLayout(3, 3));
         inner.setBorder(BorderFactory.createLineBorder(Color.black));
         for (int j = 0; j <= 8; j++) {
            int cellValue = 0; // create an int
            cellValue = puzzle.getBoardArray()[3 * (i / 3) + j / 3][3 * (i % 3) + j % 3];
            Integer newInt = new Integer(cellValue); 
            String stringCellValue = newInt.toString();
            inner.add(new JTextField(stringCellValue));
            inner.setPreferredSize(dimSize);
         }
         for (int k = 0; k <= 8; k++) { // add the 3x3 into the big pane
            outer.add(inner);
         }
      }
      return outer;
   }

   /**
    * Updates the left grid with the input which is inputted.
    * 
    * @param fileName
    * @return
    */
   public JPanel updateLeft9x9WithInput(String fileName)
   {

      SudokuFileReader sudokuInput = new SudokuFileReader();
      SudokuBoard boardInput = new SudokuBoard();
      boardInput = sudokuInput.readInFile(fileName);

      setPuzzle(boardInput);

      JPanel inner = null;
      JPanel outer = new JPanel(new GridLayout(3, 3));
      Dimension dimSize = new Dimension(100, 100);

      for (int i = 0; i < 9; i++) {
         inner = new JPanel(new GridLayout(3, 3));
         inner.setBorder(BorderFactory.createLineBorder(Color.black));
         for (int j = 0; j <= 8; j++) {
            int cellValue = 0; // create an int
            cellValue = puzzle.getBoardArray()[3 * (i / 3) + j / 3][3 * (i % 3) + j % 3];
            Integer newInt = new Integer(cellValue); 
            String stringCellValue = newInt.toString();
            inner.add(new JTextField(stringCellValue)); 
            inner.setPreferredSize(dimSize); 
         }
         for (int k = 0; k <= 8; k++) {
            // add the 3x3 into the big pane
            outer.add(inner);
         }
      }
      return outer;
   }

   public void setPuzzle(SudokuBoard board)
   {
      this.puzzle = board;
   }

   /**
    * Updates the right side grid which contains the solved solution.
    * 
    * @return updated grid with correct solution
    */
   public JPanel updateRight9x9()
   {

      SolveSudoku tester = new SolveSudoku();
      solvedPuzzle = puzzle.copy();
      solvedPuzzle = tester.recursiveBruteForceSolver(solvedPuzzle);

      JPanel inner = null;
      JPanel outer = new JPanel(new GridLayout(3, 3));
      Dimension dimSize = new Dimension(100, 100);

      for (int i = 0; i < 9; i++) {
         inner = new JPanel(new GridLayout(3, 3));
         inner.setBorder(BorderFactory.createLineBorder(Color.black));
         for (int j = 0; j <= 8; j++) {
            int cellValue = 0; // create an int
            cellValue = solvedPuzzle.getBoardArray()[3 * (i / 3) + j / 3][3 * (i % 3) + j % 3]; 
            Integer newInt = new Integer(cellValue); 
            String stringCellValue = newInt.toString();
            inner.add(new JTextField(stringCellValue)); 
            inner.setPreferredSize(dimSize); 
         }
         for (int k = 0; k <= 8; k++) {
            // add the 3x3 into the big pane
            outer.add(inner);
         }
      }
      return outer;
   }
}
