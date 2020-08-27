package TicTacToe;

public class TicTacToeTest {

    private static final int BOARD_SIZE = 3;
    private static final int PLAYER_1 = 1;
    private static final int SYMBOL_O = 1;
    private static final int SYMBOL_X = -1;
    private int[] rows;
    private int[] cols;
    private int diagnonal_1;
    private int diagnonal_2;
    private boolean[][] marked;

    /**
     *  Here, rows[i] represents the scores of row i.
     *  For example, if player1 marked twice and player2 marked once in row i, rows[i] = 1 + 1 + (-1) = 2;
     *  There are the same definitions for cols[i], diagnonal_1 and diagnonal_2.
     *  There are two diggnonals, one of them have row == col, and the other have row + col = 2(BOARD_SIZE-1)
     */
    public TicTacToeTest() {
        rows = new int[BOARD_SIZE];
        cols = new int[BOARD_SIZE];
        diagnonal_1 = 0;
        diagnonal_2 = 0;
        marked = new boolean[BOARD_SIZE][BOARD_SIZE];
    }

    /**
     * Player1 : 1;
     * Player2:  2;
     * O : 1;
     * X : -1;
     * @param row
     * @param col
     * @param player
     * @return
     */
    public int move(int row, int col, int player) {

        if (marked[row][col]) {
            throw new RuntimeException("Invalid!");
        }

        marked[row][col] = true;

        int symbol = (player == PLAYER_1) ? SYMBOL_O : SYMBOL_X;


        rows[row] += symbol;
        cols[col] += symbol;

        if (row == col) {
            diagnonal_1 += symbol;
        }

        if (row + col == BOARD_SIZE - 1) {
            diagnonal_2 += symbol;
        }

        if (isWIn(row, col))
        {
            System.out.println("Player " + player + " wins");
            return player;
        }
        System.out.println("No one wins");
        return 0;
    }

    /**
     * The win conditions are if rows[i]/col[i]/diagnonal_1/diagnonal_2 is equal to 3 or -3
     * @param row
     * @param col
     * @return
     */
    public boolean isWIn(int row, int col) {
        return Math.abs(rows[row]) == BOARD_SIZE || Math.abs(cols[col]) == BOARD_SIZE || Math.abs(diagnonal_1) == BOARD_SIZE || Math.abs(diagnonal_2) == BOARD_SIZE;
    }

    public void refresh() {
        rows = new int[BOARD_SIZE];
        cols = new int[BOARD_SIZE];
        diagnonal_1 = 0;
        diagnonal_2 = 0;
        marked = new boolean[BOARD_SIZE][BOARD_SIZE];
        System.out.println();
    }

    public static void main(String[] args) {

        TicTacToeTest game = new TicTacToeTest();
        game.move(1, 1, 1);
        game.move(1, 0, 2);
        game.move(2, 0, 1);
        game.move(0, 2, 2);
        game.move(2, 2, 1);
        game.move(2, 1, 2);
        game.move(0, 0, 1);

        game.refresh();

        game.move(0, 0, 1);
        game.move(1, 1, 2);
        game.move(1, 0, 1);
        game.move(2, 0, 2);
        game.move(0, 2, 1);
        game.move(2, 1, 2);
        game.move(2, 2, 1);
        game.move(1, 2, 2);


    }
}