package jp.ac.uryukyu.ie.e195740;
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
        while(checkBoard == false){
            System.out.println("plz insert rows num.(1~8)");
            Scanner row = new Scanner(System.in);
            int rNum = row.nextInt();
            System.out.println("plz insert columns num.(1~8)");
            Scanner column = new Scanner(System.in);
            int cNum = column.nextInt();
            if(rNum>8||rNum<1||cNum>8||cNum<1||board[rNum-1][cNum-1] != null){
                System.out.println("cannot action. plz reinsert.");
            }else{
                board[rNum-1][cNum-1] = disc.getDiscColour();
                checkBoard = true;
            }
        }

    }

    //getter
    String[][] getBoard(){
        return board;
    }
}
