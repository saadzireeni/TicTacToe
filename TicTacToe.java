import java.util.Objects;
import java.util.Scanner;

public class Tictactoe2 {

    static String emptyCell = " ";

    public static void main(String[] args) {

        int size = 3;
        String[][] board = new String[size][size];
        Scanner scan = new Scanner(System.in);


        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = emptyCell;
            }
        }
        printBoard(board, size);
        String player;
        for (int i = 1; i <= 9; i++) {
            if (i % 2 != 0) {
                player = "X";
            } else {
                player = "O";
            }
            System.out.print("Enter Coordinates: ");
            String cell = scan.nextLine();
            int row = cell.charAt(0) - 49;
            int col = cell.charAt(2) - 49;
            if (cell.length() == 3) {
                if (cell.charAt(1) == ' ') {
                    if ((row >= 0 && row < 3) && (col >= 0 && col < 3)) {
                        if(board[row][col].equals(emptyCell)){
                            printBoard(board, size, player, row, col);
                        }
                        else{
                            System.out.println("Cell is already taken");
                            i--;
                        }
                        if (xWins(board)) {
                            System.out.println("X wins");
                            break;
                        } else if (oWins(board)) {
                            System.out.println("O wins");
                            break;
                        } else if (draw(board)) {
                            System.out.println("Draw");
                            break;
                        }

                    } else {
                        System.out.println("Error 3 input must be 2 numbers (between 1 and 3) separated with space only");
                        i--;
                    }
                } else {
                    System.out.println("Error 2 input must be 2 numbers separated with space only");
                    i--;
                }
            } else {
                System.out.println("Error 1 input length must be 2 numbers separated with space only");
                i--;
            }
        }
        //winnerChecker(board);
    }

    public static void printBoard(String[][] board, int size) {
        System.out.println("---------");

        for (int i = 0; i < size; i++) {
            System.out.print("| ");
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static void printBoard(String[][] board, int size, String player, int row, int col) {


        System.out.println("---------");

        for (int i = 0; i < size; i++) {
            System.out.print("| ");
            for (int j = 0; j < size; j++) {
                if(board[row][col].equals(emptyCell)){
                    board[row][col] = player;
                }
                else {
                    System.out.println("Cell is already taken");
                }
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static boolean xWins(String[][] board) {
        //Rows
        if (board[0][0].equals("X") && board[0][1].equals("X") && board[0][2].equals("X")) {
            return true;
        }
        if (board[1][0].equals("X") && board[1][1].equals("X") && board[1][2].equals("X")) {
            return true;
        }
        if (board[2][0].equals("X") && board[2][1].equals("X") && board[2][2].equals("X")) {
            return true;
        }
        //cols
        if (board[0][0].equals("X") && board[1][0].equals("X") && board[2][0].equals("X")) {
            return true;
        }
        if (board[0][1].equals("X") && board[1][1].equals("X") && board[2][1].equals("X")) {
            return true;
        }
        if (board[0][2].equals("X") && board[1][2].equals("X") && board[2][2].equals("X")) {
            return true;
        }
        //Diagonal
        if (board[0][0].equals("X") && board[1][1].equals("X") && board[2][2].equals("X")) {
            return true;
        }
        return board[0][2].equals("X") && board[1][1].equals("X") && board[2][0].equals("X");
    }

    public static boolean oWins(String[][] board) {
        //Rows
        if (board[0][0].equals("O") && board[0][1].equals("O") && board[0][2].equals("O")) {
            return true;
        }
        if (board[1][0].equals("O") && board[1][1].equals("O") && board[1][2].equals("O")) {
            return true;
        }
        if (board[2][0].equals("O") && board[2][1].equals("O") && board[2][2].equals("O")) {
            return true;
        }
        //cols
        if (board[0][0].equals("O") && board[1][0].equals("O") && board[2][0].equals("O")) {
            return true;
        }
        if (board[0][1].equals("O") && board[1][1].equals("O") && board[2][1].equals("O")) {
            return true;
        }
        if (board[0][2].equals("O") && board[1][2].equals("O") && board[2][2].equals("O")) {
            return true;
        }
        //Diagonal
        if (board[0][0].equals("O") && board[1][1].equals("O") && board[2][2].equals("O")) {
            return true;
        }
        return board[0][2].equals("O") && board[1][1].equals("O") && board[2][0].equals("O");
    }

    public static boolean draw(String[][] board) {
        return (!xWins(board)) && (!oWins(board)) && (emptyCells(board, emptyCell) == 0);
    }


    public static int emptyCells(String[][] board, String emptyCell) {
        int emptyCellsCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals(emptyCell)) {
                    emptyCellsCount += 1;
                }
            }
        }
        return emptyCellsCount;
    }


}
