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
        for(int i = 0; i < SIZE; i++) {
            int count = 0;

            for(int j = 0; j < SIZE; j++) {
                count = map[i][j] == dot ? count + 1 : 0;

                if (count >= DOTS_TO_WIN) {
                    return true;
                }
            }
        }

        // vertical
        for(int i = 0; i < SIZE; i++) {
            int count = 0;

            for(int j = 0; j < SIZE; j++) {
                count = map[j][i] == dot ? count + 1 : 0;

                if (count >= DOTS_TO_WIN) {
                    return true;
                }
            }
        }

        int diff = SIZE - DOTS_TO_WIN;
        int length = (diff * 2) + 1;
        // diagonal
        for(int k = -diff; k <= diff; k++) {
            int count = 0;
            for(int i = 0; i < SIZE - Math.abs(k); i++) {
                count = map[i - Math.min(k, 0)][i + Math.max(k, 0)] == dot ? count + 1 : 0;

                if (count >= DOTS_TO_WIN) {
                    return true;
                }
            }
        }

        // reverse diagonal
        for(int k = -diff; k <= diff; k++) {
            int count = 0;
            for(int i = 0; i < SIZE - Math.abs(k); i++) {
                count = map[i + Math.max(k, 0)][SIZE - 1 - i + Math.min(k, 0)] == dot ? count + 1 : 0;

                if (count >= DOTS_TO_WIN) {
                    return true;
                }
            }
        }

        return false;
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
