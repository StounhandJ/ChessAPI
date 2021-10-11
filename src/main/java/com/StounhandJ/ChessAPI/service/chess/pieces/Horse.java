package com.StounhandJ.ChessAPI.service.chess.pieces;

import com.StounhandJ.ChessAPI.service.chess.Piece;
import com.StounhandJ.ChessAPI.service.chess.Role;

import static java.lang.Math.abs;

public class Horse extends Piece {
    public Horse(Integer x, Integer y, Role role) {
        super(x, y, role);
    }

    @Override
    public boolean isMoved(Integer x, Integer y) {
        int posX = abs(this.getCoordinateX() - x);
        int posY = abs(this.getCoordinateY() - y);
        return (posY == 2 && posX == 1) || (posX == 2 && posY == 1);
    }

    @Override
    public Horse clone() {
        return new Horse(this.getCoordinateX(), this.getCoordinateY(), this.getRole());
    }
}
