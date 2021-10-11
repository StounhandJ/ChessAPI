package com.StounhandJ.ChessAPI.unit;

import com.StounhandJ.ChessAPI.service.chess.Area;
import com.StounhandJ.ChessAPI.service.chess.Piece;
import com.StounhandJ.ChessAPI.service.chess.Role;
import com.StounhandJ.ChessAPI.service.chess.exception.PieceNotFoundException;
import com.StounhandJ.ChessAPI.service.chess.pieces.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class AreaCheckTest {

    private static Stream<Arguments> trueMove() {
        return Stream.of(

                arguments(Arrays.asList(
                                new Horse(3, 2, Role.WHITE),
                                new Bishop(2, 3, Role.BLACK),
                                new King(4, 1, Role.WHITE),
                                new Rook(2, 0, Role.WHITE)
                        )),
                arguments(Arrays.asList(
                                new Bishop(2, 4, Role.BLACK),
                                new King(2, 5, Role.BLACK),
                                new Queen(2, 2, Role.WHITE)
                        ))
        );
    }

    @ParameterizedTest
    @MethodSource({"trueMove"})
    public void getAllAvailableMovesDataTest(List<Piece> pieces) throws PieceNotFoundException {
        Piece piece = pieces.get(0);
        Area area = new Area(pieces);
        List<List<Integer>> actual = area.getAllAvailableMoves(piece.getCoordinateX(), piece.getCoordinateY());

        assertTrue(actual.isEmpty());
    }

}
