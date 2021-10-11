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
        int posX = abs(this.getCoordinateX() - x);
        int posY = abs(this.getCoordinateY() - y);
        return posY <= 1 && posX <= 1;
    }

    @Override
    public King clone() {
        return new King(this.getCoordinateX(), this.getCoordinateY(), this.getRole());
    }
}
