/**
 * GameOfLifeBoard
 * 
 * @author backspace-phill
 */
public class GameOfLifeBoard {
    private static final int NUM_CELLS_FOR_SUVIVAL = 2;
    private static final int NUM_CELL_FOR_ALIVE = 3;
    private static final char FILLED_CELL_CHAR = '#';
    private static final char EMPTY_CELL_CHAR = ' ';

    private              int lenX;
    private              int leny; 
    private              boolean[][] gameBoard;


    public GameOfLifeBoard(boolean[][] initalBoard) {
        gameBoard = initalBoard;
        lenX = gameBoard.length;
        leny = gameBoard[0].length;
        if (!boolArrayIsSquare(gameBoard)) {
            System.err.println("ERROR: gameBoard not VAILD it must be square!");
            System.exit(-1);
        }
        lenX = gameBoard.length    - 1;
        leny = gameBoard[0].length - 1;

    }

    public void nextStep() {
        int[][] neighbourMatrix = getNeighbourMatrix();
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                if (neighbourMatrix[i][j] == NUM_CELL_FOR_ALIVE) {
                    gameBoard[i][j] = true;
                } else if (neighbourMatrix[i][j] == NUM_CELLS_FOR_SUVIVAL
                          || neighbourMatrix[i][j] == NUM_CELL_FOR_ALIVE) {
                    gameBoard[i][j] = gameBoard[i][j];
                } else if (neighbourMatrix[i][j] < NUM_CELLS_FOR_SUVIVAL
                          || neighbourMatrix[i][j] > NUM_CELL_FOR_ALIVE) {
                    gameBoard[i][j] = false;
                }
            }
        }
    }
    private int[][] getNeighbourMatrix() {
        int[][] output = new int[gameBoard.length][gameBoard[0].length];
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                output[i][j] = sumOfNeighbours(i, j);
            }
        }
        return output;
    }

    public int sumOfNeighbours(int x, int y) {
        int sum = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                sum += (gameBoard[absModWrap(i, lenX)][absModWrap(j, leny)]) ? 1 : 0;
            }
        }
        sum -= (gameBoard[absModWrap(x, lenX)][absModWrap(y, leny)]) ? 1 : 0;
        return sum;
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < lenX; i++) {
            for (int j = 0; j < leny; j++) {
                output += (gameBoard[j][i]) ? FILLED_CELL_CHAR : EMPTY_CELL_CHAR;
            }
            output += "\n";
        }
        return output;
    }
    public static boolean boolArrayIsSquare(boolean[][] inArray) {
        for (boolean[] bs : inArray) {
            if (bs.length != inArray.length) {
                return false;
            }
        }
        return true;
    }
    private static int absModWrap(int num, int max) {
        num = (num < 0)   ? max - Math.abs(num % max)  : num;
        num = (num > max) ? Math.abs(num % max)        : num;
        return num;
    }
}
