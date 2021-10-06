package com.StounhandJ.ChessAPI.service.chess;

import com.StounhandJ.ChessAPI.service.chess.exception.FieldIsOccupiedException;
import com.StounhandJ.ChessAPI.service.chess.exception.PieceNotFoundException;

import java.util.List;

public class Area {

    List<Piece> pieces;

    public Area(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public void delPiece(Integer x, Integer y) throws PieceNotFoundException {
        this.pieces.remove(this.getPiece(x, y));
    }

    public void movePiece(Integer oldX, Integer oldY, Integer newX, Integer newY) throws PieceNotFoundException, FieldIsOccupiedException {
        if (this.isOccupied(newX, newY))
            throw new FieldIsOccupiedException();

        this.getPiece(oldX, oldY)
                .setCoordinateX(newX)
                .setCoordinateY(newY);
    }

    public Piece getPiece(Integer x, Integer y) throws PieceNotFoundException {
        for (Piece piece : this.pieces) {
            if (piece.isCoordinates(x, y)) {
                return piece;
            }
        }
        throw new PieceNotFoundException();
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
