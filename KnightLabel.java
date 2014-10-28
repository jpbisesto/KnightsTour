import java.awt.Color;

import javax.swing.JLabel;

//creates a knightLabel that extends JLabel and includes added things specific to knightlabel
//Author: Joe Bisesto

public class KnightLabel extends JLabel {
	int row, col;
	boolean visited;
	Color knightColor;

	public KnightLabel(int r, int c) {
		this.row = r;
		this.col = c;
		setBackground(knightColor);

	}

	// getter to get the row
	public int getRow() {
		return row;
	}

	// getter to get the col
	public int getCol() {
		return col;
	}

	// getter to see if it is even col
	public boolean isEvenCol() {
		int col = getCol();
		if (col % 2 == 0) {
			return true;
		} else {
			return false;
		}

	}

	// getter to see if it is visited or not
	public boolean isVisited() {
		return visited;
	}

	// setter to set visited
	public boolean setVisited(boolean set) {
		if (set == true) {
			visited = true;
			return visited;
		} else {
			visited = false;
			return visited;
		}
	}
	// end of class
}
