package jp.ac.uryukyu.ie.e195740;

/**
 * BlackDiscクラス。Discクラスの子クラス。
 */
public class BlackDisc extends Disc {

    /**
     * コンストラクタ。プレイヤー名とコマ色の設定。
     * @param playerName プレイヤー名。
     */
    BlackDisc(String playerName){
        super(playerName);
        discColour = "⚪︎";
    }
}
