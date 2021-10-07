package com.StounhandJ.ChessAPI.service.chess.pieces;

import com.StounhandJ.ChessAPI.service.chess.Piece;
import com.StounhandJ.ChessAPI.service.chess.Role;

import static java.lang.Math.abs;

public class Pawn extends Piece {

    public Pawn(Integer x, Integer y, Role role) {
        super(x, y, role);
    }

    @Override
    public boolean isMoved(Integer x, Integer y) {
        int posX = abs(this.x - x);
        int posY = this.y - y;

        return ((this.role == Role.BLACK && posY==1 ) || (this.role == Role.WHITE && posY==-1))
                && (posX==1 || posX==0);
    }
}
