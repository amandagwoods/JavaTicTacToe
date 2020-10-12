public class TicTacToe {

    public static void main(String[] args){

        char[] [] gameBoard =
                {{' ', '|',' ','|', ' '},
                 {'_', '+','_','+', '_'},
                 {' ', '|',' ','|', ' '},
                 {'_', '+','_','+', '_'},
                 {' ', '|',' ','|', ' '}};

        for(char[] row : gameBoard) {
            for(char c:row){
                System.out.print(c);
            }
            System.out.println();
        }
    }
}