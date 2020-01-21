package jp.ac.uryukyu.ie.e195740;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    Board board = new Board();
    Disc w = new WhiteDisc("hoge");

    @Test
    void isPositionClear() {
        int[] position = new int[2];
        position[0]=5;
        position[1]=5;
        board.setDisc(position,w);
        assertEquals(false,board.isPositionClear(5,5));
    }
}