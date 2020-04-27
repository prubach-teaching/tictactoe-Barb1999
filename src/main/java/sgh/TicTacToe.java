package sgh;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TicTacToe {

    public enum Result { NOT_FINISHED, NO_WINNER, X_WON, O_WON }

    public static Result checkBoard(String boardFileName) throws FileNotFoundException {
        File boardFile = new File(boardFileName);
        System.out.println(boardFile.getAbsolutePath());

        Scanner scanner = new Scanner(boardFile);

            int totalRow = 3;
            int totalColumn = 5;
            char[][] GameBoard = new char[totalRow][totalColumn];


            for (int row = 0; scanner.hasNextLine() && row < totalRow; row++) {
                char[] chars = scanner.nextLine().toCharArray();
                for (int i = 0; i < totalColumn && i < chars.length; i++) {
                    GameBoard[row][i] = chars[i];
                }
            }

            for (int m = 0; m < totalRow; m++) {
                for (int n = 0; n < totalColumn; n++) {
                    if (GameBoard[m][n] == 'x') {
                        GameBoard[m][n] = 1;
                    }
                    else if (GameBoard[m][n] == 'o') {
                            GameBoard[m][n] = 100;
                    }
                    else if (GameBoard[m][n] == ';') {
                        GameBoard[m][n] = 0;
                    }
                }

            }

            //check rows for winning
            for (int m=0; m<totalRow; m++) {
                if ((GameBoard[m][0] + GameBoard[m][2] + GameBoard[m][4]) == 3) {
                    return Result.X_WON;
                }
                else if ((GameBoard[m][0] + GameBoard[m][2] + GameBoard[m][4]) == 300) {
                    return Result.O_WON;
                }
            }

            //check columns for winning
            for (int n=0; n<totalColumn; n++) {
                if ((GameBoard[0][n] + GameBoard[1][n] + GameBoard[2][n]) == 3) {
                    return Result.X_WON;
                }
                else if ((GameBoard[0][n] + GameBoard[1][n] + GameBoard[2][n]) == 300) {
                    return Result.O_WON;
                }
            }

            //check 1st diagonal for winning
            if ((GameBoard[0][0] + GameBoard[1][2] + GameBoard[2][4]) == 3) {
                return Result.X_WON;
            } else if ((GameBoard[0][0] + GameBoard[1][2] + GameBoard[2][4]) == 300) {
                return Result.O_WON;
            }

            //check 2nd diagonal for winning
            if ((GameBoard[0][4] + GameBoard[1][2] + GameBoard[2][0]) == 3) {
                return Result.X_WON;
            } else if ((GameBoard[0][4] + GameBoard[1][2] + GameBoard[2][0]) == 300) {
                return Result.O_WON;
            }

            //check for empty spaces
            for (int m = 0; m < totalRow; m++) {
                
                for (int n = 0; n < totalColumn; n++) {

                    if (GameBoard[m][n] != 1 && GameBoard[m][n] != 100 && GameBoard[m][n] != 0) {
                        return Result.NOT_FINISHED;
                    }
                }
            }
        
        return Result.NO_WINNER;
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Result res = checkBoard("boards/tick0.csv");
        System.out.println(res);
    }
}
