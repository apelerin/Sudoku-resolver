public class Resolver {

    private int[][] ogrid;
    private int[][] solvedGrid;

    public Resolver(int[][] grid){
        this.ogrid = grid;
    }

    private boolean rowOk(int[][] grid, int row, int col, int nbr) {
        for (int i = 0; i < 8; i++) {
            if (grid[i][col] == nbr) {
                return false;
            }
        }
        return true;
    }
    private boolean colOk(int[][] grid, int row, int col, int nbr) {
        for (int i = 0; i < 8; i++) {
            if (grid[row][i] == nbr) {
                return false;
            }
        }
        return true;
    }
    private boolean squareOk(int[][] grid, int row, int col, int nbr) {
        int colStart = col - col % 3;
        int rowStart = row - row % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[rowStart + i][colStart + j] == nbr) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean gridIsFull(int[][] grid) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isOk(int[][] grid, int row, int col, int nbr) {
        return rowOk(grid, row, col, nbr) && colOk(grid, row, col, nbr) && squareOk(grid, row, col, nbr);
    }

    private int[] emptyCell(int[][] grid) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] == 0) {
                    int[] array = {i, j};
                    return array;
                }
            }
        }
        int[] a = {10, 10};
        return a;
    }

    public void resolve() {
        this.solve(this.ogrid);
    }

    private boolean solve(int[][] grid) {
        if (gridIsFull(grid)) {
            this.displayGrid(grid);
            return true;
        }

        int[] caseToSolve = emptyCell(grid);
        int row = caseToSolve[0];
        int col = caseToSolve[1];
        for (int i = 1; i <= 9; i++) {
            //System.out.println(row + " : " + col + "                   " + i);
            if (isOk(grid, row, col, i)) {
                System.out.println(row + " : " + col + "                   " + i);
                grid[row][col] = i;
                if (solve(grid)) {
                    this.solvedGrid = grid;
                    return true;
                }
                grid[row][col] = 0;
            }
        }
        return false;
    }

    public  void displayGrid(int[][] grid) {
        for (int i = 0; i < 9; i++) {
            System.out.print('|');
            for (int j = 0; j < 9; j++) {
                System.out.print(grid[i][j] + " | ");
            }
            System.out.println("\n|----------------------------------|");
        }
        System.out.println("\n\n\n\n\n");
    }
}
