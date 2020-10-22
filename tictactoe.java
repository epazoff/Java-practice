import java.util.Scanner;

public class tictactoe {

    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {

        final int SIZE = 3;
        char[][] board = new char[SIZE][SIZE];

        resetBoard(board);

        System.out.println("Welcome to the Tic-Tac-Toe game!");
        showBoard(board);

        char turn = 'x';
        char winner = ' ';

        System.out.println("You go first, player x!");

        int turncount = 1;
        boolean draw = false;

        while (winner == ' ') {
            play(turn,board);
            showBoard(board);
            turn = (turn == 'x') ? 'o' : 'x';
            winner = checkWinner(board);
            if (turncount == 9) {
                System.out.println("The game was a draw.");
                break;
            }
            turncount++;
        }

        if (winner != ' ') {
            System.out.println("The winner is player "+winner+"!");
        }
    }

    public static void resetBoard(char[][] brd) {
        int r = brd.length;
        int c = brd[0].length;

        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                brd[i][j] = ' ';
            }
        }

    }

    public static void showBoard(char[][] brd) {
        int r = brd.length;
        int c = brd[0].length;

        for (int i=0; i<r; i++) {
            System.out.println("   |   |   ");
            for (int j=0; j<c; j++) {
                String sep = "|";
                if (j==2) {
                    sep = "\n";
                }
                //need to fix how it prints
                System.out.print(" " + brd[i][j] + " " + sep);
            }
            System.out.println("   |   |   ");
            if (i!=2) {
                System.out.println("---+---+---");
            }
        }
    }

    public static void play(char turn, char[][] brd) {
        System.out.print("\nEnter the vertices of where you want to play, "+turn+": ");
        int r = sc.nextInt();
        int c = sc.nextInt();

        while (r<0 || r>2 || c<0 || c>2 || brd[r][c] != ' ') {
            System.out.print("\nThat cell is invalid, please choose another: ");
            r = sc.nextInt();
            c = sc.nextInt();
        }

        brd[r][c] = turn;
    }

    public static char checkWinner(char[][] brd) {
        char win = ' ';
        int r = brd.length;
        int c = brd[0].length;

        for (int i=0; i<r; i++) {
            if (brd[i][0] == brd[i][1] && brd[i][0] == brd[i][2]) {
                win = brd[i][0];
                break;
            }
        }

        for (int j=0; j<c; j++) {
            if (brd[0][j] == brd[1][j] && brd[0][j] == brd[2][j]) {
                win = brd[0][j];
                break;
            }
        }

        if (brd[0][0] == brd[1][1] && brd[0][0] == brd[2][2]) {
            win = brd[0][0];
        }

        if (brd[0][2] == brd[1][1] && brd[0][2] == brd[2][0]) {
            win = brd[0][2];
        }

        return win;
    }
}
