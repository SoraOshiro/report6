package jp.ac.uryukyu.ie.e195740;

public class Main {
    public static void main(String[] args){
        Board board = new Board();
        PrintBoard printBoard = new PrintBoard();
        Disc white = new WhiteDisc("hoge");
        Disc black = new BlackDisc("hogeho");

        board.preparationDisc(4,4,white.getDiscColour());
        board.preparationDisc(5,5,white.getDiscColour());
        board.preparationDisc(4,5,black.getDiscColour());
        board.preparationDisc(5,4,black.getDiscColour());
        printBoard.print(board.getBoard());

    }
}
