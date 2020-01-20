package jp.ac.uryukyu.ie.e195740;

public class Board {
    private String board[][] = new String[8][8];
    void preparationDisc(int rowsNum, int columnsNum, String disc){
        board[rowsNum-1][columnsNum-1] = disc;
    }

    void setDisc(int rowsNum, int columnsNum, String disc){
        board[rowsNum-1][columnsNum-1] = disc;
    }

    //getter
    String[][] getBoard(){
        return board;
    }
}
