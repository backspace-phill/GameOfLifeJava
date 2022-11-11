/**
  * Game
  */
 public class Game {
 
    public static void main(String[] args) throws InterruptedException {

        boolean[][] startingMatrix = new boolean[50][50];

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
            Thread.sleep(100, 0);
        }


    }
 }
