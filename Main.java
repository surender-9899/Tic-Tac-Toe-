package org.telusko;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){
                board[row][col] = ' ';
            }
        }

        char player = 'X';
        boolean  gameOver = false;
        Scanner scanner = new Scanner(System.in);

        while(!gameOver){
            printBoard(board);
            System.out.println("Player" + player + "enter position (1-9):");
            int pos = scanner.nextInt();
            int[] rc = indexing(pos);
            int row = rc[0];
            int col = rc[1];


            if(board[row][col] == ' '){
                board[row][col] = player;
                gameOver = Won(board, player);

                if (gameOver){
                    System.out.println("Player" + player + "has Won");
                }
                else{
                    if(player == 'X'){
                        player = 'O';
                    }
                    else{
                        player = 'X';
                    }
                }
            }
            else{
                System.out.println("Invalid Move try again!");
            }
        }
        printBoard(board);
    }

    private static boolean Won(char[][] board, char player) {
        for(int row = 0; row < board.length; row++){
            if(board[row][0] ==player && board[row][1] == player && board[row][2] == player){
                return true;
            }
        }

        for(int col = 0; col < board.length; col++){
            if(board[0][col] ==player && board[1][col] == player && board[2][col] == player){
                return true;
            }
        }

        if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }
        if(board[0][2] == player && board[1][1] == player && board[2][0] == player){
            return true;
        }
        return false;

    }

    private static int[] indexing(int pos) {
        int row = (pos - 1) / 3;
        int col = (pos - 1) % 3;
        return new int[]{row, col};
    }

    private static void printBoard(char[][] board) {
        System.out.println("   _   _   _ ");

        for(int row = 0; row < board.length; row++){
            System.out.print(" | ");
            for(int col = 0; col < board[row].length; col++){
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
        System.out.println("   -   -   - ");
    }
}