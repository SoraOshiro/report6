package jp.ac.uryukyu.ie.e195740;

abstract class Disc {
    String discColour;
    private String playerName;
    Disc(String playerName){
        this.playerName = playerName;
    }

    //getter
    String getDiscColour(){
        return discColour;
    }
    String getPlayerName(){
        return playerName;
    }

}
