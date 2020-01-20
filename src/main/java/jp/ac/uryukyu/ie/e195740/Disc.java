package jp.ac.uryukyu.ie.e195740;

abstract class Disc {
    String discColour;
    int discCount = 0;
    private String playerName;
    Disc(String playerName){
        this.playerName = playerName;
    }
    void count(){
        discCount += 1;
    }

    //getter
    String getDiscColour(){
        return discColour;
    }
    String getPlayerName(){
        return playerName;
    }
    int getDiscCount(){return discCount;}

}
