package com.StounhandJ.ChessAPI.unit;

import com.StounhandJ.ChessAPI.service.chess.Piece;
import com.StounhandJ.ChessAPI.service.chess.Area;

import com.StounhandJ.ChessAPI.service.chess.exception.FieldIsOccupiedException;
import com.StounhandJ.ChessAPI.service.chess.exception.PieceNotFoundException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AreaUnit {
    Area area;
    Piece piece_one;
    Piece piece_two;
    Integer x_one = 10;
    Integer y_one = 5;
    Integer x_two = 7;
    Integer y_two = 2;

    @Before
    public void pieceTestAfter3() {
        List<Piece> pieces = new ArrayList<>(){};
        this.piece_one = new Piece(this.x_one, this.y_one);
        this.piece_two = new Piece(this.x_two, this.y_two);
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
        this.area.getPiece(this.x_one+1, this.y_one-1);
    }

    @Test
    public void movePieceTest() throws PieceNotFoundException, FieldIsOccupiedException {
        Piece expected = this.piece_one;

        this.area.movePiece(this.x_one, this.y_one, this.x_one+1, this.y_one+1);

        assertEquals(expected, this.area.getPiece(this.x_one+1, this.y_one+1));
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
