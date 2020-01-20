package jp.ac.uryukyu.ie.e195740;

public class Main {
    public static void main(String[] args){
        GameMaster game = new GameMaster();
        game.setGame();
        while(true){
            game.playGame();
        }
    }
}
