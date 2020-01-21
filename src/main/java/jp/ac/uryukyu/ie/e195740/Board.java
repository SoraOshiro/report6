package jp.ac.uryukyu.ie.e195740;
import java.util.Scanner;

/**
 * Boardクラス
 * コマの格納、裏返しの処理など。
 */
public class Board {
    private String board[][] = new String[8][8];

    /**
     * コンストラクタ。
     * 宣言時に初期配置を完了させる。
     */
    Board(){
        board[3][3] = "⚫︎";
        board[4][4] = "⚫︎";
        board[3][4] = "⚪︎";
        board[4][3] = "⚪︎";
    }

    /**
     * ターン中のコマの操作をするメソッド。
     * @param disc コマの情報
     */
    void operationDisc(Disc disc){
        int discPosition[];
        System.out.println("Now "+disc.getPlayerName()+"'s turn.");
        boolean pass = passCheck();
        if(!pass) {
            discPosition = selectPosition();
            setDisc(discPosition,disc);
            turnDisc(discPosition,disc);
        }
    }

    /**
     * 指定された座標にコマを格納するメソッド。
     * @param position [0]にy座標、[1]にx座標が格納されている。
     * @param disc コマの情報
     */
    void setDisc(int[] position, Disc disc){
        int a = position[0];
        int b = position[1];
        board[a][b] = disc.getDiscColour();
        disc.count();
    }

    /**
     * コマを置く座標を決定するためのメソッド。
     * @return position 座標が格納された配列。
     */
    int[] selectPosition(){
        int a = -1;
        int b = -1;
        int position[] = new int[2];
        boolean positionChecker = false;

        while(!positionChecker) {
            while (a < 0 || 7 < a) {
                System.out.println("plz insert rows num.(1~8)");
                Scanner aPosition = new Scanner(System.in);
                a = aPosition.nextInt() - 1;
            }
            while (b < 0 || 7 < b) {
                System.out.println("plz insert columns num.(1~8)");
                Scanner bPosition = new Scanner(System.in);
                b = bPosition.nextInt() - 1;
            }
            positionChecker = isPositionClear(a, b);
        }
        position[0] = a;
        position[1] = b;
        return position;

    }

    /**
     * コマを配置しようとしている座標が空かどうかを判定するメソッド。
     * @param a y座標
     * @param b x座標
     * @return 空の場合true,空ではない場合falseを返す。
     */
    boolean isPositionClear(int a, int b){
        if(board[a][b] == null){
            return true;
        }else{
            System.out.println("This position was already set disc. plz another position.");
            return false;
        }
    }

    /**
     * コマを裏返すメソッドをまとめたメソッド。
     * @param position 指定された座標
     * @param disc コマの情報
     */
    void turnDisc(int[] position, Disc disc){
        int a = position[0];
        int b = position[1];
        turnUp(a,b,disc);
        turnDown(a,b,disc);
        turnLeft(a,b,disc);
        turnRight(a,b,disc);
        turnLeftUp(a,b,disc);
        turnLeftDown(a,b,disc);
        turnRightUp(a,b,disc);
        turnRightDown(a,b,disc);
    }

    /**
     * 上方向の裏返しの処理をするメソッド。
     * @param a y軸の座標
     * @param b x軸の座標
     * @param disc コマの情報
     */
    void turnUp(int a,int b,Disc disc){
        if(a>1){
            if(board[a-1][b]!=disc.getDiscColour() && board[a-1][b]!=null){
                for(int i = 2;true;i++){
                    if(a-i<0||board[a-i][b] == null){
                        break;
                    }else if(board[a-i][b].equals(disc.getDiscColour())){
                        for(int t =1;t<i;t++){
                            board[a-t][b] = disc.getDiscColour();
                            disc.count();
                        }
                        break;
                    }
                }
            }
        }
    }

    /**
     * 下方向の裏返しの処理をするメソッド。
     * @param a y軸の座標
     * @param b x軸の座標
     * @param disc コマの情報
     */
    void turnDown(int a,int b,Disc disc){
        if(a<6){
            if(board[a+1][b]!=disc.getDiscColour() ||  board[a+1][b] != null){
                for(int i = 2;i<8;i++){
                    if(a+i>7||board[a+i][b] == null){
                        break;
                    }else if(board[a+i][b].equals(disc.getDiscColour())){
                        for(int t =1;t<i;t++){
                            board[a+t][b] = disc.getDiscColour();
                            disc.count();
                        }
                        break;
                    }
                }
            }
        }
    }

    /**
     * 左方向の裏返しの処理をするメソッド。
     * @param a y軸の座標
     * @param b x軸の座標
     * @param disc コマの情報
     */
    void turnLeft(int a,int b,Disc disc){
        if(b<6){
            if(board[a][b+1]!=disc.getDiscColour() ||  board[a][b+1] != null){
                for(int i = 2;i<8;i++){
                    if(b+i>7||board[a][b+i] == null){
                        break;
                    }else if(board[a][b+i].equals(disc.getDiscColour())){
                        for(int t =1;t<i;t++){
                            board[a][b+t] = disc.getDiscColour();
                            disc.count();
                        }
                        break;
                    }
                }
            }
        }
    }

    /**
     * 右方向の裏返しの処理をするメソッド。
     * @param a y軸の座標
     * @param b x軸の座標
     * @param disc コマの情報
     */
    void turnRight(int a,int b,Disc disc){
        if(b>1){
            if(board[a][b-1]!=disc.getDiscColour() ||  board[a][b-1] != null){
                for(int i = 2;i<8;i++){
                    if(b-i<0||board[a][b-i] == null){
                        break;
                    }else if(board[a][b-i].equals(disc.getDiscColour())){
                        for(int t =1;t<i;t++){
                            board[a][b-t] = disc.getDiscColour();
                            disc.count();
                        }
                        break;
                    }
                }
            }
        }
    }

    /**
     * 左上方向の裏返しの処理をするメソッド。
     * @param a y軸の座標
     * @param b x軸の座標
     * @param disc コマの情報
     */
    void turnLeftUp(int a,int b,Disc disc){
        if(a>1 && b>1){
            if(board[a-1][b-1]!=disc.getDiscColour() ||  board[a-1][b-1] != null){
                for(int i = 2;i<8;i++){
                    if(a-i<0||b-i<0||board[a-i][b-i] == null){
                        break;
                    }else if(board[a-i][b-i].equals(disc.getDiscColour())){
                        for(int t =1;t<i;t++){
                            board[a-t][b-t] = disc.getDiscColour();
                            disc.count();
                        }
                        break;
                    }
                }
            }
        }
    }

    /**
     * 左下方向の裏返しの処理をするメソッド。
     * @param a y軸の座標
     * @param b x軸の座標
     * @param disc コマの情報
     */
    void turnLeftDown(int a,int b,Disc disc){
        if(a<6 && b>1){
            if(board[a+1][b-1]!=disc.getDiscColour() ||  board[a+1][b-1] != null){
                for(int i = 2;i<8;i++){
                    if(a+i>7||b-i<0||board[a+i][b-i] == null){
                        break;
                    }else if(board[a+i][b-i].equals(disc.getDiscColour())){
                        for(int t =1;t<i;t++){
                            board[a+t][b-t] = disc.getDiscColour();
                            disc.count();
                        }
                        break;
                    }
                }
            }
        }
    }

    /**
     * 右上方向の裏返しの処理をするメソッド。
     * @param a y軸の座標
     * @param b x軸の座標
     * @param disc コマの情報
     */
    void turnRightUp(int a,int b,Disc disc){
        if(a>1 && b<6){
            if(board[a-1][b+1]!=disc.getDiscColour() ||  board[a-1][b+1] != null){
                for(int i = 2;i<8;i++){
                    if(a-i<0||b+i>7||board[a-i][b+i] == null){
                        break;
                    }else if(board[a-i][b+i].equals(disc.getDiscColour())){
                        for(int t =1;t<i;t++){
                            board[a-t][b+t] = disc.getDiscColour();
                            disc.count();
                        }
                        break;
                    }
                }
            }
        }
    }

    /**
     * 右下方向の裏返しの処理をするメソッド。
     * @param a y軸の座標
     * @param b x軸の座標
     * @param disc コマの情報
     */
    void turnRightDown(int a,int b,Disc disc){
        if(a<6 && b<6){
            if(board[a+1][b+1]!=disc.getDiscColour() ||  board[a+1][b+1] != null){
                for(int i = 2;i<8;i++){
                    if(a+i>7||b+i>7||board[a+i][b+i] == null){
                        break;
                    }else if(board[a+i][b+i].equals(disc.getDiscColour())){
                        for(int t =1;t<i;t++){
                            board[a+t][b+t] = disc.getDiscColour();
                            disc.count();
                        }
                        break;
                    }
                }
            }
        }
    }

    /**
     * 手番をパスするかどうかの真偽値を返す。
     * @return returnCheck パスするかどうかの真偽値(trueでパス)
     */
    boolean passCheck(){
        boolean pCheck = false;
        boolean returnCheck = false;
        String pass;
        System.out.println("Do you wanna pass?(y/n)");
        while(!pCheck){
            Scanner pc = new Scanner(System.in);
            pass = pc.next();
            if(pass.equals("y")){
                pCheck = true;
                returnCheck = true;
            }else if(pass.equals("n")){
                pCheck = true;
                returnCheck = false;
            }else{
                System.out.println("(y/n)");
            }
        }
        return returnCheck;
    }

    //getter

    /**
     * boardを返す
     * @return board コマが格納されている配列
     */
    String[][] getBoard(){
        return board;
    }
}
