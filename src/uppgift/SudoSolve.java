package uppgift;

import java.util.*;

public class SudoSolve implements SudokuSolver {
	
	int[][] grid;
	
	public SudoSolve(int[][] grid) {
		this.grid = grid;
	}
	
	private void testValidInput(int r, int c) {
		if (r < 0 || r > this.getDimension()-1 ||
				c < 0 || c > this.getDimension()-1) {
			throw new IllegalArgumentException();
		}
	}
	
	
	public void setNumber(int r, int c, int nbr) {
		testValidInput(r, c);
		if (nbr < 1 || nbr > 9) {
			throw new IllegalArgumentException();
		}
		grid[r][c] = nbr;
	}
	

	public int getNumber(int r, int c) {
		testValidInput(r, c);
		return grid[r][c];
	}
	

	public void clearNumber(int r, int c) {
		testValidInput(r, c);
		grid[r][c] = 0;
	}
	

	public boolean isValid(int r, int c, int nbr) {
		testValidInput(r, c);
		if (nbr < 1 || nbr > 9) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < getDimension(); i++) {
			if (grid[r][i] == nbr && grid[r][i] != grid[r][c]) return false;
		}
		for (int i = 0; i < getDimension(); i++) {
			if (grid[i][c] == nbr && grid[i][c] != grid[r][c]) return false;
		}
		int x = (r/3) * 3;
		int y = (c/3) * 3;
		for (int i = x; i < x+3; i++) {
			for (int j = y; j < y+3; j++) {
				if (grid[i][j] == nbr && grid[i][j] != grid[r][c]) return false;
			}
		}
		
		return true;
	}

	// Kontrollerar att alla ifyllda siffrorna uppfyller reglerna.
	public boolean isAllValid() {
		for (int i = 0; i < getDimension(); i++) {
			for (int j = 0; j < getDimension(); j++) {
				if (!isValid(i, j, grid[i][j])) {
					return false;
				}
			}
		}
		return true;
	}
		
	// Försöker lösa sudokut och returnerar true om det var lösbart, annars false.
	public boolean solve() {		
		return solve(0, 0, 1);
	}	
	
	private boolean solve(int r, int c, int i) {
		if (i == 10) return false; 
		if (r == getDimension()-1 && c == getDimension()) { 
			return true;
		}
		if (c == getDimension()) {
			c = 0;
			r++;
		}
		
		if (grid[r][c] == 0) {
			if (isValid(r, c, i)) {
				grid[r][c] = i;
				if (!solve(r, c+1, 1)) {
					grid[r][c] = 0;
					return solve(r, c, i+1);
				}				
				return solve(r, c+1, 1);
			}
			else {
				return solve(r, c, i+1);
			}
		} else {
			return solve(r, c+1, 1);
		}
	}
		
	// Tömmer alla rutorna i sudokut
	public void clear() {
		for (int i = 0; i < grid[0].length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j] = 0;
			}
		}
	}
		
	/**
	 * Returns the numbers in the grid. An empty box i represented
	 * by the value 0.
	 * 
	 * @return the numbers in the grid
	 */
	public int[][] getMatrix() {
		return grid.clone();
	}

	/**
	 * Fills the grid with the numbers in nbrs.
	 * 
	 * @param nbrs the matrix with the numbers to insert
	 * @throws IllegalArgumentException
	 *             if nbrs have wrong dimension or containing values not in [0..9] 
	 */
	public void setMatrix(int[][] nbrs) throws IllegalArgumentException {
		
	}

}
