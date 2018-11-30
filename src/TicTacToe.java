/**
 * Java. Level 1. Lesson 4. Tic Tac Toe
 *
 * @author Oleg Postnikov
 * @version dated Dec 1, 2018
 */
public class TicTacToe {

    private final int SIZE = 5;
    private final int DOTS_TO_WIN = 4;

    private final char DOT_EMPTY = '•';
    private final char DOT_X = 'X';
    private final char DOT_O = 'O';

    private char[][] map;
    private char[] playerType = {DOT_X, DOT_O};

    public static void main(String[] args) {
        new TicTacToe().game();
    }

    void game() {
        int playerTypeIndex = 0;
        initMap();
        printMap();
    }

    private void initMap() {
        map = new char[SIZE][SIZE];

        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private void printMap() {
        System.out.print("_|_");
        for(int i = 0; i < SIZE; i++) {
            System.out.print( (i + 1) + "_");
        }
        System.out.print("\n");

        for(int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + "| ");
            for(int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    private boolean isMapFull() {
        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            return false;
        }

        return map[y][x]== DOT_EMPTY;
    }

}
