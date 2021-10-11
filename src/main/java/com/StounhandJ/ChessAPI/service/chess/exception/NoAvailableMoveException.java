package com.StounhandJ.ChessAPI.service.chess.exception;

public class NoAvailableMoveException extends Exception {

    public NoAvailableMoveException() {
        super("No available move");
    }
}
