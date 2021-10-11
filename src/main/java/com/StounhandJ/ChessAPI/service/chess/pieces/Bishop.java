package com.StounhandJ.ChessAPI.service.chess.pieces;

import com.StounhandJ.ChessAPI.service.chess.Piece;
import com.StounhandJ.ChessAPI.service.chess.Role;

import static java.lang.Math.abs;

public class Bishop extends Piece {

    public Bishop(Integer x, Integer y, Role role) {
        super(x, y, role);
    }

    @Override
    public boolean isMoved(Integer x, Integer y) {
        int posX = abs(this.getCoordinateX() - x);
        int posY = abs(this.getCoordinateY() - y);
        return posY == posX;
    }

    @Override
    public Bishop clone() {
        return new Bishop(this.getCoordinateX(), this.getCoordinateY(), this.getRole());
    }
}
