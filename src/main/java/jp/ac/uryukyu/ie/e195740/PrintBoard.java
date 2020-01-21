package jp.ac.uryukyu.ie.e195740;

/**
 * BoardPrintクラス。盤面を表示する。
 */
public class PrintBoard {
    /**
     * コンストラクタ。盤面を表示。
     * @param board コマが格納された配列
     * @param blackCount 黒コマの数
     * @param whiteCount 白コマの数
     */
    void print(String[][] board,int blackCount,int whiteCount){
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
        System.out.println("black:"+blackCount+"   white:"+whiteCount);
    }
}
