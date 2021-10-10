package com.StounhandJ.ChessAPI.service.chess;

import com.StounhandJ.ChessAPI.service.chess.exception.FieldIsOccupiedException;
import com.StounhandJ.ChessAPI.service.chess.exception.PieceNotFoundException;
import com.StounhandJ.ChessAPI.service.chess.exception.UnsuccessfulPieceCreationException;

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
            throws FieldIsOccupiedException, UnsuccessfulPieceCreationException {

        Piece piece;
        try {
            piece = pieceClass.getConstructor(Integer.class, Integer.class, Role.class).newInstance(x, y, role);
        } catch (Exception e) {
            throw new UnsuccessfulPieceCreationException();
        }

        this.addPiece(piece);
    }

    public void addPiece(Piece piece) throws FieldIsOccupiedException {
        if (this.isOccupied(piece.getCoordinateX(), piece.getCoordinateY()))
            throw new FieldIsOccupiedException();
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

    public void movePiece(Integer oldX, Integer oldY, Integer newX, Integer newY) throws PieceNotFoundException, FieldIsOccupiedException {
        movePiece(this.getPiece(oldX, oldY), newX, newY);
    }

    public void movePiece(Piece piece, Integer newX, Integer newY) throws FieldIsOccupiedException {
        if (this.isOccupied(newX, newY))
            throw new FieldIsOccupiedException();

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
        return this.isAvailableMove(this.getPiece(x, y), newX, newY);
    }

    public boolean isAvailableMove(Piece piece, Integer x, Integer y) {
        Integer startX = x < piece.getCoordinateX() ? x : piece.getCoordinateX();
        Integer endX = x > piece.getCoordinateX() ? x : piece.getCoordinateX();

        Integer startY = y < piece.getCoordinateY() ? y : piece.getCoordinateY();
        Integer endY = y > piece.getCoordinateY() ? y : piece.getCoordinateY();

        for (Piece p : this.pieces) {
            if (!p.equals(piece)) {
                if (startX.equals(endX) || startY.equals(endY)) //Straight
                {
                    if ((p.getCoordinateX() > startX && p.getCoordinateX() < endX) ||
                            (p.getCoordinateY() > startY && p.getCoordinateY() < endY))
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

        return piece.isMoved(x, y) && !this.isOccupiedByRole(x, y, piece.getRole());
    }

    //</editor-fold>

    public Piece getPiece(Integer x, Integer y) throws PieceNotFoundException {
        for (Piece piece : this.pieces) {
            if (piece.isCoordinates(x, y)) {
                return piece;
            }
        }
        throw new PieceNotFoundException();
    }

    public boolean isOccupiedByRole(Integer x, Integer y, Role role) {
        for (Piece piece : this.pieces) {
            if (piece.getRole() == role && piece.isCoordinates(x, y)) {
                return true;
            }
        }
        return false;
    }

    public boolean isOccupied(Integer x, Integer y) {
        for (Piece piece : this.pieces) {
            if (piece.isCoordinates(x, y)) {
                return true;
            }
        }
        return false;
    }

//    public List<Integer> area;
//
//    public String event;
//
//    public boolean endGame;
//
//    public void __construct(List<Integer> area) {
//        this.area = area;
//        this.event = "";
//        this.endGame = false;
//    }
//
//
//
//    public boolean checkWhoGoCage(Integer oldX, Integer oldY, Integer x, Integer y, Integer player) {
//        for (mas:
//             this.area) {
//            if (mas["player"] != player) {
//                String path = '\Libraries\Chess\Figure\\'.mas["chessPiece"];
//                ChessPiece figure = new path(mas["coordinates"][0], mas["coordinates"][1], mas["player"], this.area);  // Сделать клонирование area
//                figure.newX = x;
//                figure.newY = y;
//                figure.area.movePiece(oldX, oldY, x, y);
//                if (figure.check() && !(x == mas["coordinates"][0] && y == mas["coordinates"][1])) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    public void checkEnd(Integer player) {
//        checkEnd(player, false);
//    }
//
//    public void checkEnd(Integer player, boolean checkmate) {
//        king = [];
//        this.event = "";
//        this.endGame = false;
//        for(mas : this.area)
//        {
//            if (mas["chessPiece"] == "King" && mas[ "player"] ==player)
//            {
//                king = mas["coordinates"];
//                break;
//            }
//        }
//
//        if (king == []){
//            return;
//        }
//
//        for(mas : this.area)
//        {
//            if (mas["player"] != player) {
//                path = '\Libraries\Chess\Figure\\'.mas["chessPiece"];
//                figure = new path(mas["coordinates"][0], mas["coordinates"][1], mas["player"], this.area);  // Сделать клонирование area
//                figure.newX = king[0];
//                figure.newY = king[1];
//                if (figure.check(false)) {
//                    this.event = "Шах для ". (player == 1 ? "Белых" : "Черных");
//                    if (Checkmate) {
//                        foreach(this.area as item)
//                        {
//                            if (item["player"] == player) {
//                                path2 = '\Libraries\Chess\Figure\\'.item["chessPiece"];
//                                figureChe = new path2(item["coordinates"][0], item["coordinates"][1], item["player"], this.area);
//                                if (figureChe.getPossibleMoves()) {
//                                    return;
//                                }
//                            }
//                        }
//                        this.event = "Мат для ". (player == 1 ? "Белых" : "Черных");
//                        this.endGame = true;
//                    }
//                }
//            }
//        }
//    }
//
//
}
