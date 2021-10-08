package com.StounhandJ.ChessAPI.unit;

import com.StounhandJ.ChessAPI.service.chess.Area;
import com.StounhandJ.ChessAPI.service.chess.Piece;
import com.StounhandJ.ChessAPI.service.chess.Role;
import com.StounhandJ.ChessAPI.service.chess.exception.PieceNotFoundException;
import com.StounhandJ.ChessAPI.service.chess.pieces.Horse;
import com.StounhandJ.ChessAPI.service.chess.pieces.Rook;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class AreaMovedTest {

    private static Stream<Arguments> trueMove() {
        return Stream.of(

                arguments(Arrays.asList(
                                new Horse(1, 1, Role.WHITE),
                                new Rook(3, 2, Role.WHITE)
                        ),
                        Arrays.asList(
                                Arrays.asList(0, 3),
                                Arrays.asList(2, 3),
                                Arrays.asList(3, 0)
                        )),
                arguments(Arrays.asList(
                                new Horse(1, 1, Role.WHITE),
                                new Rook(3, 2, Role.BLACK)
                        ),
                        Arrays.asList(
                                Arrays.asList(0, 3),
                                Arrays.asList(3, 2),
                                Arrays.asList(2, 3),
                                Arrays.asList(3, 0)
                        )),

                arguments(Arrays.asList(
                                new Horse(2, 2, Role.WHITE),
                                new Horse(4, 1, Role.WHITE),
                                new Rook(2, 1, Role.BLACK)
                        ),
                        Arrays.asList(
                                Arrays.asList(2, 0),
                                Arrays.asList(0, 1),
                                Arrays.asList(1, 1),
                                Arrays.asList(3, 1)
                        ))
        );
    }

    @ParameterizedTest
    @MethodSource({"trueMove"})
    public void addAllAvailableMovesDataTest(List<Piece> pieces, List<List<Integer>> expected) throws PieceNotFoundException {
        Piece piece = pieces.get(0);
        Area area = new Area(pieces);

        assertTrue(expected.containsAll(area.getAllAvailableMoves(piece.getCoordinateX(), piece.getCoordinateY())));
    }

    @ParameterizedTest
    @MethodSource({"trueMove"})
    public void addAllAvailableMovesTest(List<Piece> pieces, List<List<Integer>> expected) {
        Piece piece = pieces.get(0);
        Area area = new Area(pieces);

        assertTrue(expected.containsAll(area.getAllAvailableMoves(piece)));

    }
}
