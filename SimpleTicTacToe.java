package tictactoe;

import java.util.Scanner;

public class Main {

    private static char[][] symbols;
    private static int x;
    private static int y;
    private static int Xcount;
    private static int Ocount;
    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        gameMenu();
    }

    public static void gameMenu() {
        symbols = setField();
        printField();
        gameProcess();

    }


    public static char[][] setField() {
        int n = 3;
        char[][] ch = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ch[i][j] = ' ';
            }
        }
        return ch;
    }

    public static void printField() {
        System.out.println("---------");
        for (int i = 0; i < symbols.length; i++) {
            System.out.print("|" + " ");
            for (int j = 0; j < symbols.length; j++) {
                System.out.print(symbols[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static void gameProcess() {
        boolean gameEnd;
        int turn = 1;
        while (true) {
            while (true) {
                System.out.print("Enter the coordinates: ");
                String xStr = sc.next();
                String yStr = sc.next();
                try {
                    x = Integer.parseInt(xStr);
                    y = Integer.parseInt(yStr);
                } catch (NumberFormatException e) {
                    System.out.println("You should enter numbers!");
                    continue;
                }
                if (x > 3 || x < 0 || y > 3 || y < 0) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                if (symbols[x - 1][y - 1] == ' ' && turn % 2 != 0) {
                    symbols[x - 1][y - 1] = 'X';
                    ++turn;
                } else if (symbols[x - 1][y - 1] == ' ' && turn % 2 == 0) {
                    symbols[x - 1][y - 1] = 'O';
                    ++turn;
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }
                break;
            }
            printField();
            gameEnd = checkState();
            if (gameEnd) {
                break;
            }
            
        }

    }
    public static boolean checkState() {
        Xcount = symbolCounter('X');
        Ocount = symbolCounter('O');
        boolean XWon = isWinner('X');
        boolean OWon = isWinner('O');
        if (XWon && !OWon) {
            System.out.println("X wins");
            return true;
        } else if (OWon && !XWon) {
            System.out.println("O wins");
            return true;
        } else if (Xcount + Ocount == 9) {
            System.out.println("Draw");
            return true;
        }
        return false;

    }

    public static boolean isWinner(char ch) {

        if (symbols[0][0] == ch && symbols[0][0] == symbols[0][1] && symbols[0][1] == symbols[0][2]) {
            return true;
        } else if (symbols[1][0] == ch && symbols[1][0] == symbols[1][1] && symbols[1][1] == symbols[1][2]) {
            return true;
        } else if (symbols[2][0] == ch && symbols[2][0] == symbols[2][1] && symbols[2][1] == symbols[2][2]) {
            return true;
        } else if (symbols[0][0] == ch && symbols[0][0] == symbols[1][0] && symbols[1][0] == symbols[2][0]) {
            return true;
        } else if (symbols[0][1] == ch && symbols[0][1] == symbols[1][1] && symbols[1][1] == symbols[2][1]) {
            return true;
        } else if (symbols[0][2] == ch && symbols[0][2] == symbols[1][2] && symbols[1][2] == symbols[2][2]) {
            return true;
        } else if (symbols[0][0] == ch && symbols[0][0] == symbols[1][1] && symbols[1][1] == symbols[2][2]) {
            return true;
        } else if (symbols[0][2] == ch && symbols[0][2] == symbols[1][1] && symbols[1][1] == symbols[2][0]) {
            return true;
        }
        return false;

    }

    public static int symbolCounter(char ch) {
        int counter = 0;
        for (int i = 0; i < symbols.length; i++) {
            for (int j = 0; j < symbols[2].length; j++) {
                if (symbols[i][j] == ch) {
                    ++counter;
                }
            }
        }
        return counter;
    }
}
