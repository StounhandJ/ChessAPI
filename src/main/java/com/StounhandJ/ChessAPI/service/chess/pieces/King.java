package com.StounhandJ.ChessAPI.service.chess.pieces;

import com.StounhandJ.ChessAPI.service.chess.Piece;
import com.StounhandJ.ChessAPI.service.chess.Role;

import static java.lang.Math.abs;

public class King extends Piece {

    public King(Integer x, Integer y, Role role) {
        super(x, y, role);
    }

    @Override
    public boolean isMoved(Integer x, Integer y) {
        int posX = abs(this.x - x);
        int posY = abs(this.y - y);
        return posY <= 1 && posX <= 1;
    }
}
