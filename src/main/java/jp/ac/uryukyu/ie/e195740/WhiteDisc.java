package jp.ac.uryukyu.ie.e195740;

/**
 * WhiteDiscクラス。Discクラスの子クラス。
 */
public class WhiteDisc extends Disc {
    /**
     * コンストラクタ。
     * プレーヤー名とコマ色の設定。
     * @param playerName プレイヤー名。
     */
    WhiteDisc(String playerName) {
        super(playerName);
        discColour = "⚫︎";
    }

}
