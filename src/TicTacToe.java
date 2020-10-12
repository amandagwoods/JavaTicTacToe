import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> computerPositions = new ArrayList<Integer>();

    public static void main(String[] args) {

        char[][] gameBoard =
                {{' ', '|', ' ', '|', ' '},
                {'_', '+', '_', '+', '_'},
                {' ', '|', ' ', '|', ' '},
                {'_', '+', '_', '+', '_'},
                {' ', '|', ' ', '|', ' '}};
        printGameBoard(gameBoard);


        while(true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your placement (1-9):");
            int playerPosition = scan.nextInt();
            while(playerPositions.contains(playerPosition) || computerPositions.contains(playerPositions)){
                System.out.println("Position taken! Enter a correct Position");
                playerPosition = scan.nextInt();
            }
            placePiece(gameBoard, playerPosition, "player");

            String result = checkWinner();
            if(result.length() > 0) {
                System.out.println(result);
                break;
            }


            Random rand = new Random();
            int computerPosition = rand.nextInt(9) + 1;
            while(playerPositions.contains(computerPosition) || computerPositions.contains(computerPosition)){
                System.out.println("Position taken! Enter a correct Position");
                computerPosition = rand.nextInt(9) + 1;
            }
            placePiece(gameBoard, computerPosition, "computer");

            printGameBoard(gameBoard);

            result = checkWinner();
            if(result.length()>0) {
                System.out.println(result);
                break;
            }
        }



    }

    public static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }


    public static void placePiece(char[][] gameBoard, int position, String user) {

        char symbol = ' ';

        if (user.equals("player")) {
            symbol = 'x';
            playerPositions.add(position);
        } else if (user.equals("computer")) {
            symbol = 'o';
            computerPositions.add(position);
        }

        switch (position) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
        }

    }

    //check winner method
    public static String checkWinner() {
        //figure out what the winning positions are

        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);
        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);
        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(7, 5, 3);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);

        for (List l : winning) {
            if (playerPositions.containsAll(l)) {
                return "You're the winner!";
            } else if (computerPositions.containsAll(l)) {
                return "Computer wins this time :(";
            } else if (playerPositions.size() + computerPositions.size() == 9) {
                return "Tie game.";
            }
        }
        return "";
    }
}
