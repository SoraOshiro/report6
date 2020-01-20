package jp.ac.uryukyu.ie.e195740;
import java.util.Scanner;

public class Board {
    private String board[][] = new String[8][8];
    void preparationDisc(int rowsNum, int columnsNum, Disc disc){
        board[rowsNum-1][columnsNum-1] = disc.getDiscColour();
        disc.count();
    }

    void operationDisc(Disc disc){
        boolean checkBoard = false;
        System.out.println("Now "+disc.getPlayerName()+"'s turn.");
        boolean pass = passCheck();
        if(!pass) {
            setDisc(disc);
        }
    }

    void setDisc(Disc disc){
        boolean checkBoard = false;
        while (!checkBoard) {
            System.out.println("plz insert rows num.(1~8)");
            Scanner row = new Scanner(System.in);
            int rNum = row.nextInt();
            System.out.println("plz insert columns num.(1~8)");
            Scanner column = new Scanner(System.in);
            int cNum = column.nextInt();
            if (rNum > 8 || rNum < 1 || cNum > 8 || cNum < 1 || board[rNum - 1][cNum - 1] != null) {
                System.out.println("cannot action. plz reinsert.");
            } else {
                board[rNum - 1][cNum - 1] = disc.getDiscColour();
                disc.count();
                checkBoard = true;
                turnUp(rNum-1,cNum-1,disc);
                turnDown(rNum-1,cNum-1,disc);
                turnLeft(rNum-1,cNum-1,disc);
                turnRight(rNum-1,cNum-1,disc);
                turnLeftUp(rNum-1,cNum-1,disc);
                turnLeftDown(rNum-1,cNum-1,disc);
                turnRightUp(rNum-1,cNum-1,disc);
                turnRightDown(rNum-1,cNum-1,disc);

            }
        }

    }

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

    boolean passCheck(){
        boolean pCheck = false;
        boolean returnCheck = false;
        String pass;
        System.out.println("Do you wanna pass?(y/n)");
        while(!pCheck){
            Scanner pc = new Scanner(System.in);
            pass = pc.next();
            if(pass.equals("y")){
                pCheck = true;;
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
    String[][] getBoard(){
        return board;
    }
}
