package jp.ac.uryukyu.ie.e195740;
import java.util.Scanner;

public class GameMaster {
    Board board = new Board();
    PrintBoard printBoard = new PrintBoard();
    Disc black;
    Disc white;
    boolean switchTurn = true;
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
    void setGame(){
        board.preparationDisc(4,4,white);
        board.preparationDisc(5,5,white);
        board.preparationDisc(4,5,black);
        board.preparationDisc(5,4,black);
        printBoard.print(board.getBoard(),black.getDiscCount(),white.getDiscCount());
    }

    void playGame(){
        while(black.getDiscCount()+white.getDiscCount()<64) {
            if (switchTurn) {
                board.operationDisc(black);
            } else {
                board.operationDisc(white);
            }
            printBoard.print(board.getBoard(),black.getDiscCount(),white.getDiscCount());
            switchTurn = !switchTurn;
        }
    }

}
