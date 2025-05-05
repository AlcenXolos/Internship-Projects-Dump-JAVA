package TicTacToe;

import java.util.Scanner;

public class Main {
    static int turns = 0; // used static variable for storing turn count

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] board = {
            { "_", "_", "_" },
            { "_", "_", "_" },
            { "_", "_", "_" },
        };

        System.out.println("Tic-Tac-Toe Game");
        displayBoard(board);

        while (turns < 9) { // if there are already 9 turns and no winner yet. declare draw
            String player = (turns % 2 == 0) ? "X" : "Y"; // checks turns for player togggle
            playerTurn(player, board); // inputs

            if (hasWinner(player, board)) { 
                System.out.println("Player " + player + " wins!");
                return;
            }
        }

        System.out.println("It's a draw!");
    }

    public static boolean hasWinner(String player, String[][] board) {
        // checking horizontal and vertical
        for (int i = 0; i < 3; i++) {
            if ((board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) ||
                (board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player))) {
                return true;
            }
        }
        // Diagonal checking
        if ((board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) || /* \ */
            (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player))) { /* / */
            return true;
        }

        return false;
    }

    public static void playerTurn(String player, String[][] board) {
        Scanner sc = new Scanner(System.in);
        int row, col;

        while (true) {
            System.out.print("Player " + player + ", enter row and column: ");
            row = sc.nextInt() - 1;
            col = sc.nextInt() - 1;

            if (row >= 0 && row < 3 && col >= 0 && col < 3) {
                if (board[row][col].equals("_")) { // checks if the cell is still blank
                    board[row][col] = player;
                    turns++; 
                    displayBoard(board);
                    break;
                } else {
                    System.out.println("Cell already taken. Try again."); // if there is already a player move, print this
                }
            } else {
                System.out.println("Invalid input. Enter values from 1 to 3.");
            }
        }
    }

    public static void displayBoard(String[][] board) {
        System.out.println("\n  1 2 3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
