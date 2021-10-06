package com.StounhandJ.ChessAPI.unit;

import com.StounhandJ.ChessAPI.service.chess.Piece;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class PieceTest {

    Piece piece;
    Integer x = 10;
    Integer y = 5;

    @Before
    public void pieceTestAfter3() {
        this.piece = new Piece(this.x, this.y);
    }

    @Test
    public void getCoordinateYTest() {
        Integer expected = this.y;

        assertEquals(expected, this.piece.getCoordinateY());
    }

    @Test
    public void getCoordinateXTest() {
        Integer expected = this.x;

        assertEquals(expected, this.piece.getCoordinateX());
    }

    @Test
    public void setCoordinateYTest() {
        Integer expected = this.y + 2;

        this.piece.setCoordinateY(expected);

        assertEquals(expected, this.piece.getCoordinateY());
    }

    @Test
    public void setCoordinateXTest() {
        Integer expected = this.x + 2;

        this.piece.setCoordinateX(expected);

        assertEquals(expected, this.piece.getCoordinateX());
    }

    @Test
    public void setCoordinatesTest() {
        Integer[] expected = new Integer[]{this.x + 5, this.y - 5};

        this.piece.setCoordinates(expected[0], expected[1]);

        assertArrayEquals(expected, this.piece.getCoordinates());
    }

    @Test
    public void getCoordinatesTest() {
        Integer[] expected = new Integer[]{this.x, this.y};

        assertArrayEquals(expected, this.piece.getCoordinates());
    }

}
