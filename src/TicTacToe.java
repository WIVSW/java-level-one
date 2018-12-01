/**
 * Java. Level 1. Lesson 4. Tic Tac Toe
 *
 * @author Oleg Postnikov
 * @version dated Dec 1, 2018
 */
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private final int SIZE = 5;
    private final int DOTS_TO_WIN = 4;

    private final char DOT_EMPTY = '•';
    private final char DOT_X = 'X';
    private final char DOT_O = 'O';

    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    private char[][] map;
    private char[] playerType = {DOT_X, DOT_O};

    public static void main(String[] args) {
        new TicTacToe().game();
    }

    void game() {
        initMap();
        printMap();
        runGame();
    }

    private void runGame() {
        int playerTypeIndex = 0;

        while(true) {
            char dot = playerType[playerTypeIndex];

            turn(dot);
            printMap();

            if (checkWin(dot)) {
                System.out.println(getPlayerNameFromDot(dot) + " победил");
                break;
            }

            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }

            playerTypeIndex ^= 1;
        }

        System.out.println("Игра закончена");
    }

    private boolean checkWin(char dot) {
        // horizontal
        char[] dots = {dot};
        int[][][][] sequences = {
            getHorizontalCoords(),
            getVerticalCoords(),
            getDiagonalCoords(),
            getReverseDiagonalCoords()
        };

        for(int i = 0; i < sequences.length; i++) {
            // iterate type of coords (horizontal, vertical, diagonal)

            for(int j = 0; j < sequences[i].length; j++) {
                // iterate sequence of coords
                int count = 0;

                for(int k = 0; k < sequences[i][j].length; k++) {
                    // iterate coords
                    int[] coords = sequences[i][j][k];

                    if (coords == null) {
                        continue;
                    }

                    int x = coords[0];
                    int y = coords[1];

                    count = checkDotsInCoords(x, y, dots) ? count + 1 : 0;

                    if (count >= DOTS_TO_WIN) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean checkDotsInCoords(int x, int y, char[] dots) {
        for(int i = 0; i < dots.length; i++) {
            if (map[y][x] == dots[i]) {
                return true;
            }
        }

        return false;
    }

    private int[][][] getHorizontalCoords() {
        return buildStraightCoords(true);
    }

    private int[][][] getVerticalCoords() {
        return buildStraightCoords(false);
    }

    private int[][][] getDiagonalCoords() {
        return buildDiagonalCoords(false);
    }

    private int[][][] getReverseDiagonalCoords() {
        return buildDiagonalCoords(true);
    }

    private int[][][] buildDiagonalCoords(boolean isReverse) {
        // coords[sequence][coords][x,y]
        int diff = SIZE - DOTS_TO_WIN;
        int[][][] coords = new int[SIZE][SIZE][2];

        for(int k = -diff; k <= diff; k++) {

            int size = SIZE - Math.abs(k);

            for(int i = 0; i < SIZE; i++) {
                if (i >= size) {
                    coords[k + diff][i] = null;
                    continue;
                }

                int x = isReverse ? SIZE - 1 - i + Math.min(k, 0) : i + Math.max(k, 0);
                int y = isReverse ? i + Math.max(k, 0) : i - Math.min(k, 0);

                coords[k + diff][i] = createCoords(x, y);

            }

        }

        return coords;
    }

    private int[][][] buildStraightCoords(boolean isReverse) {
        // coords[sequence][coords][x,y]
        int[][][] coords = new int[SIZE][SIZE][2];

        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                coords[i][j] = isReverse ? createCoords(j, i) : createCoords(i, j);
            }
        }

        return coords;
    }

    private int[] createCoords(int x, int y) {
        int[] coords = {x, y};
        return coords;
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

    private void turn(char dot) {
        TurnResult result;

        do {
            result = dot == DOT_X ? humanTurn() : aiTurn();
        } while(!isCellValid(result.x, result.y));

        map[result.y][result.x] = dot;

        System.out.println(getPlayerNameFromDot(dot) + " cходил в точку " + (result.x + 1) + " " + (result.y + 1));
    }

    private TurnResult humanTurn() {
        System.out.println("Введите координаты в формате X Y в диапозоне от 1 до " + SIZE);
        return new TurnResult(scanner.nextInt() - 1, scanner.nextInt() - 1);
    }

    private TurnResult aiTurn() {
        return new TurnResult(random.nextInt(SIZE), random.nextInt(SIZE));
    }

    private class TurnResult {
        public int x;
        public int y;

        public TurnResult(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private String getPlayerNameFromDot(char dot) {
        return dot == DOT_X ? "Человек" : "Искуственный Интеллект";
    }

}
