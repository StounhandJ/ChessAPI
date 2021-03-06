package com.StounhandJ.ChessAPI.service.chess.pieces;

import com.StounhandJ.ChessAPI.service.chess.Piece;
import com.StounhandJ.ChessAPI.service.chess.Role;

import static java.lang.Math.abs;

public class Queen extends Piece {

    public Queen(Integer x, Integer y, Role role) {
        super(x, y, role);
    }

    @Override
    public boolean isMoved(Integer x, Integer y) {
        int posX = abs(this.getCoordinateX() - x);
        int posY = abs(this.getCoordinateY() - y);
        return (posY == posX) || ((posY == 0 && posX > 0) || (posX == 0 && posY > 0));
    }

    @Override
    public Queen clone() {
        return new Queen(this.getCoordinateX(), this.getCoordinateY(), this.getRole());
    }
}
