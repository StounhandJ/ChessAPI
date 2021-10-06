package com.StounhandJ.ChessAPI.service.chess.exception;

public class FieldIsOccupiedException extends Exception {

    public FieldIsOccupiedException() {
        super("This field is occupied");
    }
}
