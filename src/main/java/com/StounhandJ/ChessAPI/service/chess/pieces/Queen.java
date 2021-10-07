package com.StounhandJ.ChessAPI.service.chess.pieces;

import com.StounhandJ.ChessAPI.service.chess.Piece;

import static java.lang.Math.abs;

public class Queen extends Piece {
    public Queen(Integer x, Integer y) {
        super(x, y);
    }

    @Override
    public boolean isMoved(Integer x, Integer y) {
        int posX = abs(this.x - x);
        int posY = abs(this.y - y);
        return (posY == posX) || ((posY == 0 && posX > 0) || (posX == 0 && posY > 0));
    }
}
