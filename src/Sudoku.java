public class Sudoku {

    private static final int[][] GRID_TO_SOLVE = {
            {0, 0, 3, 6, 4, 0, 0, 5, 0},
            {0, 0, 5, 0, 0, 9, 6, 4, 0},
            {8, 0, 6, 0, 0, 0, 1, 0, 3},
            {0, 0, 9, 0, 0, 6, 0, 8, 0},
            {2, 5, 0, 8, 0, 3, 0, 1, 6},
            {0, 1, 0, 2, 0, 0, 7, 0, 0},
            {5, 0, 1, 0, 0, 0, 3, 0, 4},
            {0, 6, 2, 4, 0, 0, 5, 0, 0},
            {0, 3, 0, 0, 6, 5, 8, 0, 0}
        };


    public static void main(String[] args) {
        Resolver solver = new Resolver(GRID_TO_SOLVE);
        solver.resolve();
    }


}
