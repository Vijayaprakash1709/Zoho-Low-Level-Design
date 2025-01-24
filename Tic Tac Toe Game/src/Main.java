import java.util.Scanner;

public class Main {
    private static char[][] board;
    private static int n;
    private static char currentPlayer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the grid (n x n): ");
        n = scanner.nextInt();

        board = new char[n][n];
        initializeBoard();

        currentPlayer = 'X';
        int moves = 0;
        boolean gameWon = false;

        while (moves < n * n && !gameWon) {
            printBoard();
            System.out.printf("Player %c, enter your move (row and column): ", currentPlayer);
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                moves++;
                if (checkWin(row, col)) {
                    gameWon = true;
                    printBoard();
                    System.out.printf("Player %c wins!%n", currentPlayer);
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        if (!gameWon) {
            printBoard();
            System.out.println("The game is a draw!");
        }

        scanner.close();
    }

    private static void initializeBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '-';
            }
        }
    }

    private static void printBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < n && board[row][col] == '-';
    }

    private static boolean checkWin(int row, int col) {
        return checkRow(row) || checkColumn(col) || checkDiagonals();
    }

    private static boolean checkRow(int row) {
        for (int col = 0; col < n; col++) {
            if (board[row][col] != currentPlayer) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkColumn(int col) {
        for (int row = 0; row < n; row++) {
            if (board[row][col] != currentPlayer) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkDiagonals() {
        boolean diag1 = true, diag2 = true;
        for (int i = 0; i < n; i++) {
            if (board[i][i] != currentPlayer) {
                diag1 = false;
            }
            if (board[i][n - i - 1] != currentPlayer) {
                diag2 = false;
            }
        }
        return diag1 || diag2;
    }
}
