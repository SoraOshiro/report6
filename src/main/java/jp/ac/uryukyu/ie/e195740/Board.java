package jp.ac.uryukyu.ie.e195740;
import javax.swing.*;
import java.util.Scanner;

public class Board {
    private String board[][] = new String[8][8];
    void preparationDisc(int rowsNum, int columnsNum, Disc disc){
        board[rowsNum-1][columnsNum-1] = disc.getDiscColour();
        disc.count();
    }

    void setDisc(Disc disc){
        boolean checkBoard = false;
        System.out.println("Now "+disc.getPlayerName()+"'s turn.");
        boolean pass = passCheck();
        if(!pass) {
            while (!checkBoard) {
                System.out.println("plz insert rows num.(1~8)");
                Scanner row = new Scanner(System.in);
                int rNum = row.nextInt();
                System.out.println("plz insert columns num.(1~8)");
                Scanner column = new Scanner(System.in);
                int cNum = column.nextInt();
                if (rNum > 8 || rNum < 1 || cNum > 8 || cNum < 1 || board[rNum - 1][cNum - 1] != null) {
                    System.out.println("cannot action. plz reinsert.");
                } else {
                    board[rNum - 1][cNum - 1] = disc.getDiscColour();
                    disc.count();
                    checkBoard = true;
                }
            }
        }
    }

    boolean passCheck(){
        boolean pCheck = false;
        boolean returnCheck = false;
        String pass;
        System.out.println("Do you wanna pass?(y/n)");
        while(!pCheck){
            Scanner pc = new Scanner(System.in);
            pass = pc.next();
            if(pass.equals("y")){
                pCheck = true;;
                returnCheck = true;
            }else if(pass.equals("n")){
                pCheck = true;
                returnCheck = false;
            }else{
                System.out.println("(y/n)");
            }
        }
        return returnCheck;
    }

    //getter
    String[][] getBoard(){
        return board;
    }
}
