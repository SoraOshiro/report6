package jp.ac.uryukyu.ie.e195740;

/**
 * Discクラス。WhiteDiscとBlackDiscの親クラス。
 */
abstract class Disc {
    String discColour;
    int discCount = 2;
    private String playerName;

    /**
     * コンストラクタ。
     * プレイヤー名を保存。
     * @param playerName プレイヤーの名前。
     */
    Disc(String playerName){
        this.playerName = playerName;
    }

    /**
     * 盤面上のコマのカウント。
     */
    void count(){
        discCount += 1;
    }

    //getter

    /**
     * getDiscColour.
     * @return discColourを返す
     */
    String getDiscColour(){
        return discColour;
    }

    /**
     * getPlayerName.
     * @return playerNameを返す。
     */
    String getPlayerName(){
        return playerName;
    }

    /**
     * getDiscCount.
     * @return discCountを返す。
     */
    int getDiscCount(){return discCount;}

}
