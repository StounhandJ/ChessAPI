package com.StounhandJ.ChessAPI.unit;


import com.StounhandJ.ChessAPI.service.chess.Piece;
import com.StounhandJ.ChessAPI.service.chess.Role;
import com.StounhandJ.ChessAPI.service.chess.pieces.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class PieceMoveTest {


    private static Stream<Arguments> trueMove() {
        return Stream.of(

                arguments(new Bishop(2, 2, Role.BLACK), 3, 3),
                arguments(new Bishop(2, 2, Role.BLACK), 1, 1),
                arguments(new Bishop(2, 2, Role.BLACK), 1, 3),

                arguments(new Horse(5, 5, Role.BLACK), 6, 7),
                arguments(new Horse(5, 5, Role.BLACK), 7, 4),
                arguments(new Horse(5, 5, Role.BLACK), 3, 6),

                arguments(new King(2, 2, Role.BLACK), 3, 3),
                arguments(new King(2, 2, Role.BLACK), 1, 2),
                arguments(new King(2, 2, Role.BLACK), 3, 1),

                arguments(new Pawn(2, 2, Role.BLACK), 2, 1),
                arguments(new Pawn(2, 2, Role.BLACK), 1, 1),
                arguments(new Pawn(2, 2, Role.BLACK), 3, 1),
                arguments(new Pawn(2, 2, Role.WHITE), 2, 3),
                arguments(new Pawn(2, 2, Role.WHITE), 1, 3),
                arguments(new Pawn(2, 2, Role.WHITE), 3, 3),

                arguments(new Queen(2, 2, Role.BLACK), 3, 3),
                arguments(new Queen(2, 2, Role.BLACK), 1, 1),
                arguments(new Queen(2, 2, Role.BLACK), 2, 5),
                arguments(new Queen(2, 2, Role.BLACK), 5, 2),
                arguments(new Queen(2, 2, Role.BLACK), 3, 3),

                arguments(new Rook(2, 2, Role.BLACK), 2, 5),
                arguments(new Rook(2, 2, Role.BLACK), 5, 2),
                arguments(new Rook(2, 2, Role.BLACK), 0, 2)
        );
    }

    private static Stream<Arguments> falseMove() {
        return Stream.of(

                arguments(new Bishop(2, 2, Role.BLACK), 4, 3),
                arguments(new Bishop(2, 2, Role.BLACK), 1, 2),

                arguments(new Horse(5, 5, Role.BLACK), 7, 5),
                arguments(new Horse(5, 5, Role.BLACK), 7, 3),
                arguments(new Horse(5, 5, Role.BLACK), 4, 6),

                arguments(new King(2, 2, Role.BLACK), 4, 3),
                arguments(new King(2, 2, Role.BLACK), 1, 0),

                arguments(new Pawn(2, 2, Role.BLACK), 1, 2),
                arguments(new Pawn(2, 2, Role.BLACK), 1, 0),
                arguments(new Pawn(2, 2, Role.BLACK), 2, 3),
                arguments(new Pawn(2, 2, Role.WHITE), 1, 2),
                arguments(new Pawn(2, 2, Role.WHITE), 1, 4),
                arguments(new Pawn(2, 2, Role.WHITE), 2, 1),

                arguments(new Queen(2, 2, Role.BLACK), 4, 3),
                arguments(new Queen(2, 2, Role.BLACK), 0, 1),

                arguments(new Rook(2, 2, Role.BLACK), 3, 5),
                arguments(new Rook(2, 2, Role.BLACK), 5, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("trueMove")
    public void trueMoveTest(Piece piece, Integer new_x, Integer new_y) {
        assertTrue(piece.isMoved(new_x, new_y), String.format(
                "from %d:%d to %d:%d",
                piece.getCoordinateX(),
                piece.getCoordinateY(),
                new_x,
                new_y
                ));
    }

    @ParameterizedTest
    @MethodSource({"falseMove"})
    public void falseMoveTest(Piece piece, Integer new_x, Integer new_y) {
        assertFalse(piece.isMoved(new_x, new_y), String.format(
                "from %d:%d to %d:%d",
                piece.getCoordinateX(),
                piece.getCoordinateY(),
                new_x,
                new_y
                ));
    }
}
