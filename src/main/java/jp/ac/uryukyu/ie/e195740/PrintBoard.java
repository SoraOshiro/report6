package jp.ac.uryukyu.ie.e195740;

public class PrintBoard {
    void print(String[][] board){
        for(int i=0;i<8;i++){
            System.out.println("•-----•-----•-----•-----•-----•-----•-----•-----•");
            System.out.print("|");
            for(int j=0;j<8;j++){
                if(board[i][j]==null){
                    System.out.print("     |");
                }else{
                    System.out.print("  "+board[i][j]+"  |");
                }
            }
            System.out.println();
        }
        System.out.println("•-----•-----•-----•-----•-----•-----•-----•-----•");
    }
}
