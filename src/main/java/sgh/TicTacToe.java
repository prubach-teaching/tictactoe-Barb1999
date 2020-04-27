package sgh;

import java.io.File;

import java.util.Scanner;

public class TicTacToe {

    public enum Result { NOT_FINISHED, NO_WINNER, X_WON, O_WON }

    public static Result checkBoard(String boardFileName) {
        File boardFile = new File(boardFileName);
        System.out.println(boardFile.getAbsolutePath());

        Scanner p = new Scanner(boardFile);
        int kolumny = 5;
        int wiersze = 3;
         
            char[][] Gra = new char[wiersze][kolumny];


            for (int rzad = 0; p.hasNextLine() && rzad < wiersze; rzad++) {
                char[] abc = p.nextLine().toCharArray();
                for (int i = 0; i < kolumny && i < abc.length; i++) {
                    Gra[rzad][i] = abc[i];
                }
            }

            for (int m = 0; m < wiersze; m++) {
                for (int n = 0; n < kolumny; n++) {
                    if (Gra[m][n] == 'x') {
                    	Gra[m][n] = 1;
                    }
                    else if (Gra[m][n] == 'o') {
                    		Gra[m][n] = 100;
                    }
                    else if (Gra[m][n] == ';') {
                    	    Gra[m][n] = 0;
                    }
                }

            }

            //check rows for winning
            for (int m=0; m<wiersze; m++) {
                if ((Gra[m][0] + Gra[m][2] + Gra[m][4]) == 3) {
                    return Result.X_WON;
                }
                else if ((Gra[m][0] + Gra[m][2] + Gra[m][4]) == 300) {
                    return Result.O_WON;
                }
            }

            //check columns for winning
            for (int n=0; n<kolumny; n++) {
                if ((Gra[0][n] + Gra[1][n] + Gra[2][n]) == 3) {
                    return Result.X_WON;
                }
                else if ((Gra[0][n] + Gra[1][n] + Gra[2][n]) == 300) {
                    return Result.O_WON;
                }
            }

            //check 1st diagonal for winning
            if ((Gra[0][0] + Gra[1][2] + Gra[2][4]) == 3) {
                return Result.X_WON;
            } else if ((Gra[0][0] + Gra[1][2] + Gra[2][4]) == 300) {
                return Result.O_WON;
            }

            //check 2nd diagonal for winning
            if ((Gra[0][4] + Gra[1][2] + Gra[2][0]) == 3) {
                return Result.X_WON;
            } else if ((Gra[0][4] + Gra[1][2] + Gra[2][0]) == 300) {
                return Result.O_WON;
            }

            //check for empty spaces
            for (int m = 0; m < wiersze; m++) {
                
                for (int n = 0; n < kolumny; n++) {

                    if (Gra[m][n] != 1 && Gra[m][n] != 100 && Gra[m][n] != 0) {
                        return Result.NOT_FINISHED;
                    }
                }
            }
        
        return Result.NO_WINNER;
    }
    
    public static void main(String[] args) {
        Result res = checkBoard("boards/tick0.csv");
        System.out.println(res);
    }
