package com.StounhandJ.ChessAPI.service.chess;

import com.StounhandJ.ChessAPI.service.chess.exception.*;
import com.StounhandJ.ChessAPI.service.chess.pieces.King;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Area {

    public Area(List<Piece> pieces) {
        this.pieces = pieces;
    }

    private final List<Piece> pieces;

    private final int SIZE_X = 8;

    private final int SIZE_Y = 8;

    //<editor-fold desc="Add Piece">

    public void addPiece(Integer x, Integer y, Role role, Class<? extends Piece> pieceClass)
            throws NoAvailableMoveException, UnsuccessfulPieceCreationException {

        Piece piece;
        try {
            piece = pieceClass.getConstructor(Integer.class, Integer.class, Role.class).newInstance(x, y, role);
        } catch (Exception e) {
            throw new UnsuccessfulPieceCreationException();
        }

        this.addPiece(piece);
    }

    public void addPiece(Piece piece) throws NoAvailableMoveException {
        if (this.isOccupied(piece.getCoordinateX(), piece.getCoordinateY()))
            throw new NoAvailableMoveException();
        this.pieces.add(piece);
    }

    //</editor-fold>

    //<editor-fold desc="Del Piece">

    public void delPiece(Integer x, Integer y) throws PieceNotFoundException {
        this.delPiece(this.getPiece(x, y));
    }

    public void delPiece(Piece piece) {
        this.pieces.remove(piece);
    }

    //</editor-fold>

    //<editor-fold desc="Move Piece">

    public void movePiece(Integer oldX, Integer oldY, Integer newX, Integer newY) throws PieceNotFoundException, NoAvailableMoveException {
        movePiece(this.getPiece(oldX, oldY), newX, newY);
    }

    public void movePiece(Piece piece, Integer newX, Integer newY) throws NoAvailableMoveException {
        if (!this.isAvailableMove(piece, newX, newY))
            throw new NoAvailableMoveException();

        piece.setCoordinateX(newX).setCoordinateY(newY);
    }

    //</editor-fold>

    //<editor-fold desc="AvailableMove">

    public List<List<Integer>> getAllAvailableMoves(Integer x, Integer y) throws PieceNotFoundException {
        return getAllAvailableMoves(this.getPiece(x, y));
    }

    public List<List<Integer>> getAllAvailableMoves(Piece piece) {
        List<List<Integer>> moves = new ArrayList<>();

        for (Integer x = 0; x < SIZE_X; x++) {
            for (Integer y = 0; y < SIZE_Y; y++) {
                if (this.isAvailableMove(piece, x, y)) {
                    moves.add(Arrays.asList(x, y));
                }
            }
        }

        return moves;
    }

    public boolean isAvailableMove(Integer x, Integer y, Integer newX, Integer newY) throws PieceNotFoundException {
        return this.isAvailableMove(this.getPiece(x, y), newX, newY, true);
    }

    public boolean isAvailableMove(Piece piece, Integer x, Integer y) {
        return this.isAvailableMove(piece, x, y, true);
    }

    public boolean isAvailableMove(Piece piece, Integer x, Integer y, boolean check) {
        Integer startX = x < piece.getCoordinateX() ? x : piece.getCoordinateX();
        Integer endX = x > piece.getCoordinateX() ? x : piece.getCoordinateX();

        Integer startY = y < piece.getCoordinateY() ? y : piece.getCoordinateY();
        Integer endY = y > piece.getCoordinateY() ? y : piece.getCoordinateY();

        for (Piece p : this.pieces) {
            if (!p.equals(piece)) {
                if (startX.equals(endX) || startY.equals(endY)) //Straight
                {
                    if ((p.getCoordinateX() > startX && p.getCoordinateX() < endX && startY.equals(p.getCoordinateY())) ||
                            (p.getCoordinateY() > startY && p.getCoordinateY() < endY && startX.equals(p.getCoordinateX())))
                        return false;
                }

                if (!startX.equals(endX) && !startY.equals(endY) && (endX - startX == endY - startY)) //Diagonally
                {
                    if ((p.getCoordinateX() > startX && p.getCoordinateX() < endX) &&
                            (p.getCoordinateY() > startY && p.getCoordinateY() < endY))
                        return false;
                }

                // In other cases, ignoring. Example: horse
            }
        }
        var t1 = piece.isMoved(x, y);
        var t2 = this.isOccupiedByRole(x, y, piece.getRole());
        var t3 = (!check || !this.isCheck(piece, x, y));

        return piece.isMoved(x, y) && this.isOccupiedByRole(x, y, piece.getRole()) && (!check || !this.isCheck(piece, x, y));
    }

    //</editor-fold>

    //<editor-fold desc="Get piece and pieces">

    public Piece getPiece(Integer x, Integer y) throws PieceNotFoundException {
        for (Piece piece : this.pieces) {
            if (piece.isCoordinates(x, y)) {
                return piece;
            }
        }
        throw new PieceNotFoundException();
    }

    public List<Piece> getPieces() {
        List<Piece> pieces = new ArrayList<>();
        for (Piece piece : this.pieces) {
            pieces.add(piece.clone());
        }
        return pieces;
    }

    public List<Piece> getPieces(Class<? extends Piece> pieceT) {
        List<Piece> pieces = new ArrayList<>();
        for (Piece piece : this.pieces) {
            if (piece.getClass() == pieceT) {
                pieces.add(piece.clone());
            }
        }
        return pieces;
    }

    public Piece getKing() throws MoreThanOneKingsException, NotFoundKingException {
        List<Piece> pieces = this.getPieces(King.class);

        if (pieces.isEmpty()) {
            throw new NotFoundKingException();
        }
        if (pieces.size() > 1) {
            throw new MoreThanOneKingsException();
        }
        return pieces.get(0);
    }

    //</editor-fold>

    //<editor-fold desc="Is">

    public boolean isCheck(Piece piece, Integer x, Integer y) {

        List<Piece> pieces = this.getPieces();
        for (Piece p : pieces) {
            if (piece.equals(p))
            {
                p.setCoordinateX(x).setCoordinateY(y);
                continue;
            }
        }

        Area areaClone = new Area(pieces);
        Piece king;

        try {
            king = areaClone.getKing();
        } catch (NotFoundKingException | MoreThanOneKingsException e) {
            return false;
        }

        for (Piece p : areaClone.getPieces()) {
            if (areaClone.isAvailableMove(p, king.getCoordinateX(), king.getCoordinateY(), false)) {
                return true;
            }
        }
        return false;
    }

    public boolean isOccupiedByRole(Integer x, Integer y, Role role) {
        for (Piece piece : this.pieces) {
            if (piece.getRole() == role && piece.isCoordinates(x, y)) {
                return false;
            }
        }
        return true;
    }

    public boolean isOccupied(Integer x, Integer y) {
        for (Piece piece : this.pieces) {
            if (piece.isCoordinates(x, y)) {
                return true;
            }
        }
        return false;
    }

    //</editor-fold>

    public Area clone() {
        return new Area(this.getPieces());
    }

}
