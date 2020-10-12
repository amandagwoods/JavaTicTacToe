import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args){

        char[] [] gameBoard =
                {{' ', '|',' ','|', ' '},
                 {'_', '+','_','+', '_'},
                 {' ', '|',' ','|', ' '},
                 {'_', '+','_','+', '_'},
                 {' ', '|',' ','|', ' '}};
        printGameBoard(gameBoard);

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your placement (1-9):");
        int playerPosition = scan.nextInt();

        placePiece(gameBoard, playerPosition, "player");

        Random rand = new Random();
        int computerPosition = rand.nextInt(9) + 1;
        placePiece(gameBoard, computerPosition, "computer");

        printGameBoard(gameBoard);



    }
        public static void printGameBoard(char[][] gameBoard) {
            for (char[] row : gameBoard) {
                for (char c : row) {
                    System.out.print(c);
                }
                System.out.println();
            }
        }


        public static void placePiece(char[][] gameBoard, int position, String user){

        char symbol = ' ';

        if(user.equals("player")){
                symbol = 'x';
            }else if(user.equals("computer")){
                symbol = 'o';
        }

            switch(position){
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
}
