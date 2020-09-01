import java.util.Scanner;

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
    private boolean haveWin;
    private int counts;
    private int lastPlayer;


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
        haveWin = false;
        counts = 0;
        lastPlayer = 0;
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
    public void move(int row, int col, int player) {

        // Check if the field already have chess
        if (marked[row][col]) {
            System.out.println("Invalid -- Invalid input since there is chess exist already!");
            return;
        }

        // Check if the user in this turn different from last turn
        if (lastPlayer == 0) {
            lastPlayer = player;
        } else if (lastPlayer == player) {
            System.out.println("Invalid -- It is the other user's turn. ");
            return;
        }
        lastPlayer = player;


        marked[row][col] = true;
        counts++;

        int symbol = (player == PLAYER_1) ? SYMBOL_O : SYMBOL_X;
        String chess = (player == PLAYER_1) ? "O" : "X";
        System.out.println("User" + player + " draw" + chess + " in row " + row +" and col " + col);


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
            setHaveWin(true);
            System.out.println("Player " + player + " wins");
        }
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
        haveWin = false;
        counts = 0;
        lastPlayer = 0;
        System.out.println();
    }

    public static void inputEngine(TicTacToeTest game) {

        System.out.println("Game started：");
        Scanner sc = new Scanner(System.in);
        String str = null;
        while(!(str=sc.nextLine()).equals("exit")){
            String regex = "[0-2],[0-2],[1,2]";
            if (!str.matches(regex)) {
                System.out.println("Invalid -- Incorrect input. The correct format is [0-2],[0-2],[1,2], like 1,1,1 or 2,0,2");
            } else {
                String[] inputs = str.split(",");
                int user = Integer.valueOf(inputs[2]);
                int row = Integer.valueOf(inputs[0]);
                int col = Integer.valueOf(inputs[1]);

                game.move(row, col, user);
            }

            // One user wins
            if(game.isHaveWin()) {
                game.refresh();
            }

            // The borad is full but no one wins.
            if (game.getCounts() == BOARD_SIZE * BOARD_SIZE) {
                System.out.println("Game over. No one wins");
                game.refresh();
            }

        }
    }

    public int getCounts() {
        return counts;
    }

    public boolean isHaveWin() {
        return haveWin;
    }

    public void setHaveWin(boolean haveWin) {
        this.haveWin = haveWin;
    }

    public static void main(String[] args) {
        inputEngine(new TicTacToeTest());

//        game.move(1, 1, 1);
//        game.move(1, 0, 2);
//        game.move(2, 0, 1);
//        game.move(0, 2, 2);
//        game.move(2, 2, 1);
//        game.move(2, 1, 2);
//        game.move(0, 0, 1);
//
//        game.refresh();
//
//        game.move(0, 0, 1);
//        game.move(1, 1, 2);
//        game.move(2, 0, 1);
//        game.move(1, 0, 2);
//        game.move(1, 2, 1);
//        game.move(0, 2, 2);
//        game.move(2, 1, 1);
//        game.move(2, 2, 2);
//        game.move(0, 1, 1);


    }
}