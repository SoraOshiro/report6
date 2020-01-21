package jp.ac.uryukyu.ie.e195740;
import java.util.Scanner;

/**
 * GameMasterクラス
 * ゲームの手順を管理。
 */
public class GameMaster {
    Board board = new Board();
    PrintBoard printBoard = new PrintBoard();
    Disc black;
    Disc white;
    boolean switchTurn = true;

    /**
     * Discクラスの実体化、プレイヤー名の入力
     */
    GameMaster(){
        System.out.println("plz input 1st player (black side) name");
        Scanner first = new Scanner(System.in);
        String firstName = first.next();
        black = new BlackDisc(firstName);

        System.out.println("plz input 2nd player (white side) name");
        Scanner second = new Scanner(System.in);
        String secondName = second.next();
        white = new WhiteDisc(secondName);
    }

    /**
     * ターンの管理。終了後は試合結果を表示。
     */
    void playGame(){
        int turnCount = 0;
        printBoard.print(board.getBoard());
        while(turnCount<60) {
            if (switchTurn) {
                board.operationDisc(black);
            } else {
                board.operationDisc(white);
            }
            printBoard.print(board.getBoard());
            switchTurn = !switchTurn;
            turnCount += 1;
        }
        if(board.countFinishDisc()){
            System.out.println(black.getPlayerName()+" win!");
        }else{
            System.out.println(white.getPlayerName()+" win!");
        }
    }

}
