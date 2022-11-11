/**
 * Game
 */
public class Game {

    private static final int SLEEPTIME = 100;
    private static final int BOARD_SIZE = 50; 

    public static void main(String[] args) throws InterruptedException {
        boolean[][] startingMatrix = new boolean[BOARD_SIZE][BOARD_SIZE];
        //Matrix for a Glider
        startingMatrix[0][0] = true;
        startingMatrix[0][2] = true;
        startingMatrix[1][1] = true;
        startingMatrix[1][2] = true;
        startingMatrix[2][1] = true;

        GameOfLifeBoard gameBoard = new GameOfLifeBoard(startingMatrix);
        while (true) {
            System.out.println(gameBoard + "\u001B[1;1H");
            gameBoard.nextStep();
            Thread.sleep(SLEEPTIME);
        }
    }
}
