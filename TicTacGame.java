import java.util.Random;
import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework
class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char board[][] = { {' ','|',' ','|',' '},
        {'-','+','-','+','-'},{' ','|',' ','|',' '},{'-','+','-','+','-'},
        {' ','|',' ','|',' '}
        };
        int turn = 0;
        printBoard(board);
        System.out.println("Press 1 to play with CPU or press any number to play with friend");
        int str = scan.nextInt();
        if(str == 1)
        {
            char t = 'P';
            while(turn < 9) {
                System.out.println("Enter your position");
                int p1 = scan.nextInt();
                while(checkP(p1,board)) {
                    System.out.println("ops! wrong position Enter your position again");
                    p1 = scan.nextInt();
                }
                turn++;
                mark(p1,board,t);
                printBoard(board);
                if(winner(board))
                {
                    System.out.println("Congrats! you won");
                    return;
                }
                if(turn >= 9)
                break;
                System.out.println("CPU turn");
                t = 'C';
                Random r = new Random();
                int cpu = r.nextInt(9) + 1;
                while(checkP(cpu,board))
                {
                    cpu = r.nextInt(9) + 1;
                }
                mark(cpu,board,t);
                printBoard(board);
                if(winner(board))
                {
                    System.out.println("Sorry CPU won");
                    return;
                }
                t = 'P';
                turn++;
            }
            System.out.println("Draw!");
        }
        else
        {
            char t = 'P';
            while(turn < 9) {
                System.out.println("player 1 enter your position");
                int p1 = scan.nextInt();
                while(checkP(p1,board)) {
                    System.out.println("ops! wrong position player 1 Enter your position again");
                    p1 = scan.nextInt();
                }
                turn++;
                mark(p1,board,t);
                printBoard(board);
                if(winner(board))
                {
                    System.out.println("Player 1 Won!");
                    return;
                }
                if(turn >= 9)
                break;
                System.out.println("player 2 turn player 2 Enter your position");
                t = 'C';
                //Random r = new Random();
                int cpu = scan.nextInt();
                while(checkP(cpu,board))
                {
                    System.out.println("ops! wrong position player 2 Enter your position again");
                    cpu = scan.nextInt();
                }
                mark(cpu,board,t);
                printBoard(board);
                if(winner(board))
                {
                    System.out.println("Player 2 Won!");
                    return;
                }
                t = 'P';
                turn++;
            }
            System.out.println("Draw!");
        }
    }
    public static void printBoard(char board[][]) {
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
                System.out.print(board[i][j]);
            System.out.println();
        }
    }
    public static boolean checkP(int p,char[][] board) {
        boolean ans = false;
        switch(p) {
            case 1:
            if(board[0][0] != ' ')
                ans = true;
            break;
            case 2:
            if(board[0][2] != ' ')
                ans = true;
            break;
            case 3:
            if(board[0][4] != ' ')
                ans = true;
            break;
            case 4:
            if(board[2][0] != ' ')
                ans = true;
            break;
            case 5:
            if(board[2][2] != ' ')
                ans = true;
            break;
            case 6:
            if(board[2][4] != ' ')
                ans = true;
            break;
            case 7:
            if(board[4][0] != ' ')
                ans = true;
            break;
            case 8:
            if(board[4][2] != ' ')
                ans = true;
            break;
            case 9:
            if(board[4][4] != ' ')
                ans = true;
            break;
            default:
            ans = true;
            break;
        }
        return ans;
    }
    public static void mark(int p, char [][] board, char t) {
        char ans = 'X';
        if(t == 'C')
            ans = 'O';
        switch(p) {
            case 1:
            board[0][0] = ans;
            break;
            case 2:
            board[0][2] = ans;
            break;
            case 3:
            board[0][4] = ans;
            break;
            case 4:
            board[2][0] = ans;
            break;
            case 5:
            board[2][2] = ans;
            break;
            case 6:
            board[2][4] = ans;
            break;
            case 7:
            board[4][0] = ans;
            break;
            case 8:
            board[4][2] = ans;
            break;
            case 9:
            board[4][4] = ans;
            break;
            default:
            break;
        }
    }
    public static boolean winner(char[][] board) {
        if(board[0][0] != ' ' && board[0][0] == board[0][2] && board[0][2] == board[0][4])
            return true;
        if(board[2][0] != ' ' && board[2][0] == board[2][2] && board[2][2] == board[2][4])
            return true;
        if(board[4][0] != ' ' && board[4][0] == board[4][2] && board[4][2] == board[4][4])
            return true;
        if(board[0][0] != ' ' && board[0][0] == board[2][0] && board[2][0] == board[4][0])
            return true;
        if(board[0][2] != ' ' && board[0][2] == board[2][2] && board[2][2] == board[4][2])
            return true;
        if(board[0][4] != ' ' && board[0][4] == board[2][4] && board[2][4] == board[4][4])
            return true;
        if(board[0][0] != ' ' && board[0][0] == board[2][2] && board[2][2] == board[4][4])
            return true;
        if(board[0][4] != ' ' && board[0][4] == board[2][2] && board[2][2] == board[4][0])
            return true;
        return false;
    }
}