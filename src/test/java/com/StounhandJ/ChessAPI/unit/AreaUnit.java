package com.StounhandJ.ChessAPI.unit;

import com.StounhandJ.ChessAPI.service.chess.Piece;
import com.StounhandJ.ChessAPI.service.chess.Area;

import com.StounhandJ.ChessAPI.service.chess.exception.FieldIsOccupiedException;
import com.StounhandJ.ChessAPI.service.chess.exception.PieceNotFoundException;
import com.StounhandJ.ChessAPI.service.chess.pieces.Horse;
import com.StounhandJ.ChessAPI.service.chess.pieces.Rook;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
public class AreaUnit {
    Area area;
    Piece piece_one;
    Piece piece_two;
    Integer x_one = 10;
    Integer y_one = 5;
    Integer x_two = 7;
    Integer y_two = 2;

    @Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(
                AreaUnit.generate(0, 5, 7, 2),
                AreaUnit.generate(4, 6, 1, 4));
    }

    private static Object[] generate(Integer x_one, Integer y_one, Integer x_two, Integer y_two) {
        Piece piece_one_1 = new Horse(x_one, y_one);
        Piece piece_two_1 = new Rook(x_two, y_two);
        return new Object[]{
                new Area(Arrays.asList(piece_one_1, piece_two_1)),
                piece_one_1,
                piece_two_1,
                x_one,
                y_one,
                x_two,
                y_two};
    }

    public AreaUnit(Area area, Piece piece_one, Piece piece_two, Integer x_one, Integer y_one, Integer x_two, Integer y_two) {
        this.area = area;
        this.piece_one = piece_one;
        this.piece_two = piece_two;
        this.x_one = x_one;
        this.y_one = y_one;
        this.x_two = x_two;
        this.y_two = y_two;
    }

    @Before
    public void pieceTestAfter3() {
        List<Piece> pieces = new ArrayList<>() {
        };
        this.piece_one = new Rook(this.x_one, this.y_one);
        this.piece_two = new Rook(this.x_two, this.y_two);
        pieces.add(this.piece_one);
        pieces.add(this.piece_two);

        this.area = new Area(pieces);
    }

    @Test
    public void getPieceTest() throws PieceNotFoundException {
        Piece expected = this.piece_one;

        assertEquals(expected, this.area.getPiece(this.x_one, this.y_one));
    }

    @Test(expected = PieceNotFoundException.class)
    public void getPieceExceptionTest() throws PieceNotFoundException {
        this.area.getPiece(this.x_one + 1, this.y_one - 1);
    }

    @Test
    public void movePieceTest() throws PieceNotFoundException, FieldIsOccupiedException {
        Piece expected = this.piece_one;

        this.area.movePiece(this.x_one, this.y_one, this.x_one + 1, this.y_one + 1);

        assertEquals(expected, this.area.getPiece(this.x_one + 1, this.y_one + 1));
    }

    @Test(expected = FieldIsOccupiedException.class)
    public void movePieceExceptionTest() throws PieceNotFoundException, FieldIsOccupiedException {
        this.area.movePiece(this.x_one, this.y_one, this.x_two, this.y_two);
    }

    @Test(expected = PieceNotFoundException.class)
    public void delPieceTest() throws PieceNotFoundException {
        this.area.delPiece(this.x_one, this.y_one);

        this.area.getPiece(this.x_one, this.y_one);
    }
}
