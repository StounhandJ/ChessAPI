package com.StounhandJ.ChessAPI.service.chess.pieces;

import com.StounhandJ.ChessAPI.service.chess.Piece;
import com.StounhandJ.ChessAPI.service.chess.Role;

import static java.lang.Math.abs;

public class Rook extends Piece {

    public Rook(Integer x, Integer y, Role role) {
        super(x, y, role);
    }

    @Override
    public boolean isMoved(Integer x, Integer y) {
        int posX = abs(this.getCoordinateX() - x);
        int posY = abs(this.getCoordinateY() - y);
        return ((posY == 0 && posX > 0) || (posX == 0 && posY > 0));
    }

    @Override
    public Rook clone() {
        return new Rook(this.getCoordinateX(), this.getCoordinateY(), this.getRole());
    }
}
