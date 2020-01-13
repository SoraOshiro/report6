package jp.ac.uryukyu.ie.e195740;

public class Board {
    private String board[][] = new String[8][8];
    void print(){
        for(int i=0;i<8;i++){
            System.out.println("•-----•-----•-----•-----•-----•-----•-----•-----•");
            System.out.print("|");
            for(int j=0;j<8;j++){
                board[i][j] = " ";
                System.out.print("  "+board[i][j]+"  |");
            }
            System.out.println();
        }
        System.out.println("•-----•-----•-----•-----•-----•-----•-----•-----•");
    }
    void setDisc(int rowsNum, int columnsNum,String disc){
         board[rowsNum-1][columnsNum-1] = disc;
    }
}
