package Assignment4.Challenge;
import java.util.Scanner;

public class TicTacToe {

    private static final char X = 'X';
    private static final char O = 'O';
    private static final char BLANK = '#';
    private static boolean flag=false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < 3; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        int xCount = countPieces(board, X);
        int oCount = countPieces(board, O);
        int result = minimax(board, xCount == oCount);

        if(result == 1){
            System.out.println("Crosses win");
        } else if(result == -1){
            System.out.println("Noughts win");
        } else {
            System.out.println("Draw");
        }
    }

    private static int countPieces(char[][] board, char piece) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == piece) {
                    count++;
                }
            }
        }
        return count;
    }

    static int minimax(char[][] board, boolean isMaximizing) {
        int count2=0;
        char result = findWinner(board);
        if (result == X) {
            flag=true;
            return 1;
        } else if (result == O) {
            flag=false;
            return -1;
        } else if (isFull(board)) {
            return 0;
        }

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == BLANK) {
                        board[i][j] = 'X';
                        int score = minimax(board, false);
                        board[i][j] = BLANK;
                        if (score > bestScore) {
                            bestScore = score;
                        }
                        count2++;
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == BLANK) {
                        board[i][j] = 'O';
                        int score = minimax(board, true);
                        board[i][j] = BLANK;
                        if (score < bestScore) {
                            bestScore = score;
                        }
                        count2++;
                    }
                }
            }
            return bestScore;
        }
    }

    private static char findWinner(char[][] board) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != BLANK) {
                return board[i][0];
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != BLANK) {
                return board[0][i];
            }
        }

        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != BLANK) {
            return board[0][0];
        }

        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != BLANK) {
            return board[0][2];
        }

        return BLANK;  
    }

    private static boolean isFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == BLANK) {
                    return false;
                }
            }
        }
        return true;
    }
}
