package uppgift;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] = { 
				{ 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
		SudoSolve s = new SudoSolve(grid);
		System.out.println(s.solve());
		printGrid(s.getMatrix());
		//System.out.println(s.isValid(0, 0, 7));
		
	}
	
	
	public static void printGrid(int[][] grid) {
		System.out.println("------------------");
		for(int i = 0; i < grid[0].length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("------------------");
	}

}
