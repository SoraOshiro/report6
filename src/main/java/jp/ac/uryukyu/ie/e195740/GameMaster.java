package jp.ac.uryukyu.ie.e195740;
import java.util.Scanner;

public class GameMaster {
    Board board = new Board();
    PrintBoard printBoard = new PrintBoard();
    Disc black;
    Disc white;
    boolean switchTurn = true;
    GameMaster(){
        System.out.println("plz input 1st player name");
        Scanner first = new Scanner(System.in);
        String firstName = first.next();
        black = new BlackDisc(firstName);

        System.out.println("plz input 2nd player name");
        Scanner second = new Scanner(System.in);
        String secondName = second.next();
        white = new WhiteDisc(secondName);
    }
    void setGame(){
        board.preparationDisc(4,4,white.getDiscColour());
        board.preparationDisc(5,5,white.getDiscColour());
        board.preparationDisc(4,5,black.getDiscColour());
        board.preparationDisc(5,4,black.getDiscColour());
        printBoard.print(board.getBoard());
    }

    void playGame(){
        if(switchTurn){
            board.setDisc(black);
        }else{
            board.setDisc(white);
        }
        printBoard.print(board.getBoard());
        switchTurn = !switchTurn;
    }

}
