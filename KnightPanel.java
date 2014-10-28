import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

//this knight panel will display a checker board 
//it has methods that will allow a knight chess piece to
//run through the board in order to find a solution for it 
//to land on each square once without repeating a square 
//included also is a method to check if all the squares have 
//been visited by the knight
//Author: Joe Bisesto 10/1/13

public class KnightPanel extends JPanel {

	KnightLabel[][] knight; // two dimensional array of knightLabels
	private final int ROW; // the amount of rows on the board
	private final int COL; // amount of cols on the board
	private int count = 0; 

	public KnightPanel(int r, int c) {

		ROW = r; // set rows equal to r
		COL = c; // set col equal to c

		setLayout(new GridLayout(r, c)); // grid layout

		knight = new KnightLabel[r][c]; // create the knight and add to panel
		

		for (int i = 0; i < r; i++) {
			for (int y = 0; y < c; y++) {

				if (i % 2 == 0 && y % 2 == 0 || i % 2 == 1 && y % 2 == 1) {

					knight[i][y] = new KnightLabel(r, c);
					knight[i][y].knightColor = Color.white; 
					knight[i][y].setBackground(Color.white);
					knight[i][y].setOpaque(true);
					

					add(knight[i][y]);

				} else {

					knight[i][y] = new KnightLabel(r, c);
					knight[i][y].knightColor = Color.black; 
					knight[i][y].setBackground(Color.black);
					knight[i][y].setOpaque(true);
					

					add(knight[i][y]);

				}

			}
		}
		knight[0][0].setVisited(true); 
		count++;
	}

	public void quest(int row, int col) {
		
		//int countVisit = countVisited(row, col, knight);
		
		//if the count is equal to all the rows and cols then you are done
		if (count == ROW * COL) {

			System.out.println("SOLUTION FOUND!");
			pause(1000);
			System.exit(0);
		} else { //run the recursive backtracking
			// up-left = r-2,c-1 *
			if (isOnBoard(row - 2, col - 1)
					&& !knight[row - 2][col - 1].isVisited()) {

				// do something
				knight[row - 2][col - 1].setForeground(Color.red);
				count++;
				knight[row - 2][col - 1].setVisited(true);
				
				pause(10);
				knight[row - 2][col - 1].setText(""+count);
				// do recursion
				
				quest(row - 2, col - 1);
				
				// backtrack
				count--; 
				knight[row - 2][col - 1].setVisited(false);
				knight[row - 2][col - 1].setBackground(knight[row-2][col-1].knightColor);
				knight[row - 2][col - 1].setText("");
				

				// how do i color it back to checker?

				// how do i color it back to checker?

			}

			// up-right = r-2,c+1 *
			if (isOnBoard(row - 2, col + 1)
					&& !knight[row - 2][col + 1].isVisited()) {
				// do something
				knight[row - 2][col + 1].setForeground(Color.red);
				count++;
				knight[row - 2][col + 1].setVisited(true);
				
				knight[row - 2][col + 1].setText(""+count);
				pause(10);
				// do recursion
				quest(row - 2, col + 1);
				
				// backtrack
				count--;
				knight[row - 2][col + 1].setVisited(false);
				knight[row - 2][col + 1].setBackground(knight[row-2][col+1].knightColor);
				knight[row - 2][col + 1].setText("");
			}

			// down-left = r+2, c-1 *
			if (isOnBoard(row + 2, col - 1)
					&& !knight[row + 2][col - 1].isVisited()) {
				// do something
				knight[row + 2][col - 1].setForeground(Color.red);
				count++; 
				knight[row + 2][col - 1].setVisited(true);
				
				knight[row + 2][col - 1].setText(""+count);
				pause(10);
				// do recursion
				quest(row + 2, col - 1);
				
				// backtrack
				count--;
				knight[row + 2][col - 1].setVisited(false);
				knight[row + 2][col - 1].setBackground(knight[row+2][col-1].knightColor);
				knight[row + 2][col - 1].setText("");
				
				

			}

			// down-right = r+2,c+1*
			if (isOnBoard(row + 2, col + 1)
					&& !knight[row + 2][col + 1].isVisited()) {
				// do something
				knight[row + 2][col + 1].setForeground(Color.red);
				count++;
				knight[row + 2][col + 1].setText(""+count);
				knight[row + 2][col + 1].setVisited(true);
				

				pause(10);
				// do recursion
				quest(row + 2, col + 1);
		
				// backtrack
				knight[row + 2][col + 1].setForeground(Color.red);
				count--; 
				knight[row + 2][col + 1].setVisited(false);
				knight[row + 2][col + 1].setBackground(knight[row+2][col+1].knightColor);
				knight[row + 2][col + 1].setText("");
				
				
			}

			// left-up = r-1,c-2*
			if (isOnBoard(row - 1, col - 2)
					&& !knight[row - 1][col - 2].isVisited()) {
				// do something
				knight[row - 1][col-2].setForeground(Color.red);
				count++;
				knight[row - 1][col - 2].setText(""+count);
				knight[row - 1][col - 2].setVisited(true);

				pause(10);
				// do recursion
				quest(row - 1, col - 2);
			
				// backtrack
				count--; 
				
				knight[row - 1][col - 2].setText("");
				knight[row - 1][col - 2].setVisited(false);
				knight[row - 1][col - 2].setBackground(knight[row-1][col-2].knightColor);

			}

			// right-up = r-1,c+2 *
			if (isOnBoard(row - 1, col + 2)
					&& !knight[row - 1][col + 2].isVisited()) {
				// do something
				knight[row - 1][col + 2].setForeground(Color.red);
				count++; 
				knight[row - 1][col + 2].setText(""+count);
				knight[row - 1][col + 2].setVisited(true);
				
				pause(10);
				// do recursion
				quest(row - 1, col + 2);

				// backtrack
				count--; 
				knight[row - 1][col + 2].setText("");
				knight[row - 1][col + 2].setVisited(false);
				knight[row - 1][col + 2].setBackground(knight[row-1][col+2].knightColor);
				

			}

			// left-down = r+1,c-2
			if (isOnBoard(row + 1, col - 2)
					&& !knight[row + 1][col - 2].isVisited()) {
				// do something
				knight[row +1][col - 2].setForeground(Color.red);
				count++; 
				knight[row + 1][col - 2].setText(""+count);
				knight[row + 1][col - 2].setVisited(true);
				
				

				pause(10);
				// do recursion
				quest(row + 1, col - 2);
		
				// backtrack
				count--; 
				knight[row + 1][col - 2].setText("");
				knight[row + 1][col - 2].setVisited(false);
				knight[row + 1][col - 2].setBackground(knight[row+1][col-2].knightColor);

			}

			// right-down = r+1, c+2
			if (isOnBoard(row + 1, col + 2)
					&& !knight[row + 1][col + 2].isVisited()) {
				// do something
				knight[row + 1][col + 2].setForeground(Color.red);
				count++; 
				knight[row + 1][col + 2].setText(""+count);
				knight[row + 1][col + 2].setVisited(true);
				

				pause(10);
				// do recursion
				quest(row + 1, col + 2);

				// backtrack
				knight[row + 1][col + 2].setForeground(Color.red);
				count--; 
				knight[row + 1][col + 2].setVisited(false);
				knight[row + 1][col + 2].setBackground(knight[row+1][col+2].knightColor);
				knight[row + 1][col + 2].setText("");
			

			}
		}

	}

	// this method will test to make sure that the points are actually on the
	// board and will return true if they are
	public boolean isOnBoard(int r, int c) {
		if (r < 0 || r > ROW - 1 || c < 0 || c > COL - 1) {
			return false;
		} else {
			return true;
		}
	}

	// this method will count the amount of visited squares in a two dimensional
	// array of
	// KnightLabels and return that number
	public int countVisited(int r, int c, KnightLabel[][] label) {
		int count = 0; // the number that will be returned
		for (int i = 0; i < ROW; i++) {
			for (int y = 0; y < COL; y++) {
				if (label[i][y].isVisited()) {
					count++;
				}
			}
		}

		return count;

	}

	// pause(): causes a pause of mills milliseconds in code execution.
	public static void pause(int mills) {
		if (mills > 0) {
			try {
				Thread.sleep(mills);
			} catch (InterruptedException e) {
			}
		}
	}

}
