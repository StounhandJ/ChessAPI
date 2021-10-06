package com.example.chess.service.chess.exception;

public class PieceNotFoundException extends Exception {

    public PieceNotFoundException() {
        super("Piece Not Found");
    }
}
