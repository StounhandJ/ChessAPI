package com.StounhandJ.ChessAPI.unit;

import com.StounhandJ.ChessAPI.service.chess.Piece;

import com.StounhandJ.ChessAPI.service.chess.Role;
import com.StounhandJ.ChessAPI.service.chess.pieces.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(Parameterized.class)
public class PieceTest {

    Piece piece;
    Integer x;
    Integer y;

    @Parameterized.Parameters(name = "{index}: {0}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Bishop(6, 5, Role.BLACK), 6, 5},
                {new Horse(2, 2, Role.BLACK), 2, 2},
                {new King(4, 0, Role.BLACK), 4, 0},
                {new Pawn(3, 4, Role.BLACK), 3, 4},
                {new Queen(1, 8, Role.BLACK), 1, 8},
                {new Rook(0, 2, Role.BLACK), 0, 2},
        });
    }

    public PieceTest(Piece piece, Integer x, Integer y) {
        this.piece = piece;
        this.x = x;
        this.y = y;
    }

    @Before
    public void pieceTestAfter3() {
        this.piece.setCoordinateX(this.x)
                  .setCoordinateY(this.y);
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

    @Test
    public void isCoordinatesTrueTest() {
        assertTrue(this.piece.isCoordinates(this.x, this.y));
    }

    @Test
    public void isCoordinatesFalseTest() {
        assertFalse(this.piece.isCoordinates(this.x - 1, this.y + 1));
    }

}
