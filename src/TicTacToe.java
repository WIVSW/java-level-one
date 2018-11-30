/**
 * Java. Level 1. Lesson 4. Tic Tac Toe
 *
 * @author Oleg Postnikov
 * @version dated Dec 1, 2018
 */
public class TicTacToe {

    private static final int SIZE = 5;
    private static final int DOTS_TO_WIN = 4;

    private static final char DOT_EMPTY = '•';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';

    private static char[][] map;

    public static void main(String[] args) {
        initMap();
        printMap();
    }

    private static void initMap() {
        map = new char[SIZE][SIZE];

        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
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

}
