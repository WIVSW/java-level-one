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
    private final char[] PLAYER_TYPE = {DOT_X, DOT_O};
    private final int[][][][] WINNING_SEQUENCES = calculateWinningSequences();

    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    private char[][] map;

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
            char dot = PLAYER_TYPE[playerTypeIndex];

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

        return getWinningSequencesForDots(dots).length > 0;
    }

    private Sequence[] getWinningSequencesForDots(char[] dots) {
        Sequence[] result = {};

        for(int i = 0; i < WINNING_SEQUENCES.length; i++) {
            // iterate type of sequences (horizontal, vertical, diagonal, reverse diagonal)

            for(int j = 0; j < WINNING_SEQUENCES[i].length; j++) {
                // iterate sequence of coords
                int count = 0;
                Sequence sequence = new Sequence();

                for(int k = 0; k < WINNING_SEQUENCES[i][j].length; k++) {
                    // iterate coords
                    int[] coords = WINNING_SEQUENCES[i][j][k];

                    if (coords == null) {
                        continue;
                    }

                    int x = coords[0];
                    int y = coords[1];

                    if (checkDotsInCoords(x, y, dots)) {
                        count++;
                        sequence.add(x, y);
                    } else {
                        count = 0;
                        sequence = new Sequence();
                    }

                    if (count >= DOTS_TO_WIN) {
                        count = 0;
                        result = push(result, sequence);
                    }
                }
            }
        }

        return result;
    }

    private class Sequence {
       public int countO = 0;
       public int countX = 0;
       public int countEmpty = 0;
       public int[][] items = {};

       public void add(int x, int y) {
           int[] coords = {x, y};
           char dot = map[y][x];

           push(coords);
           increaseCount(dot);
       }

       private void push(int[] coords) {
           int length = items.length;
           int[][] newItems = new int[length + 1][2];

           for(int i = 0; i < length; i++) {
               newItems[i] = items[i];
           }

           newItems[length] = coords;
           this.items = newItems;
       }

       private void increaseCount(char dot) {
           switch(dot) {
               case DOT_O:
                   this.countO++;
                   break;
               case DOT_X:
                   this.countX++;
                   break;
               case DOT_EMPTY:
                   this.countEmpty++;
                   break;
           }
       }

    }

    private boolean checkDotsInCoords(int x, int y, char[] dots) {
        for(int i = 0; i < dots.length; i++) {
            if (map[y][x] == dots[i]) {
                return true;
            }
        }

        return false;
    }

    private int[][][][] calculateWinningSequences() {
        int[][][][] sequences = {
                getHorizontalCoords(),
                getVerticalCoords(),
                getDiagonalCoords(),
                getReverseDiagonalCoords()
        };

        return sequences;
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
        int[][][] coords = new int[(diff * 2) + 1][SIZE][2];

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
        char[] dots = {DOT_X, DOT_EMPTY};
        Sequence[] sequences = getWinningSequencesForDots(dots);
        sequences = filterSequencesByDotXCount(sequences);
        return new TurnResult(random.nextInt(SIZE), random.nextInt(SIZE));
    }

    private Sequence[] filterSequencesByDotXCount(Sequence[] sequences) {
        Sequence[] newSequences = {};

        for(int i = 0; i < sequences.length; i++) {
            if (newSequences.length > 0) {
                if (newSequences[0].countX < sequences[i].countX) {
                    Sequence[] refreshed = { sequences[i] };
                    newSequences = refreshed;
                } else if (newSequences[0].countX == sequences[i].countX) {
                    newSequences = push(newSequences, sequences[i]);
                }
            } else {
                newSequences = push(newSequences, sequences[i]);
            }
        }

        return newSequences;
    }

    private Sequence[] push(Sequence[] sequences, Sequence item) {
        int length = sequences.length;
        Sequence[] newSequence = new Sequence[length + 1];

        for(int i = 0; i < length; i++) {
            newSequence[i] = sequences[i];
        }

        newSequence[length] = item;

        return newSequence;
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
