package com.StounhandJ.ChessAPI.service.chess.pieces;

import com.StounhandJ.ChessAPI.service.chess.Piece;

import static java.lang.Math.abs;

public class Pawn extends Piece {
    public Pawn(Integer x, Integer y) {
        super(x, y);
    }

    @Override
    public boolean isMoved(Integer x, Integer y) {
        int posX = abs(this.x - x);
        int posY = abs(this.y - y);

        return posY==1 && (posX==1 || posX==0);
    }
}
