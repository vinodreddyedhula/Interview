package com.ncr.chess;

import org.junit.Before;
import org.junit.Test;

import com.ncr.chess.ChessBoard;
import com.ncr.chess.MovementType;
import com.ncr.chess.Pawn;
import com.ncr.chess.PieceColor;
import com.ncr.exceptions.InvalidMovementException;
import com.ncr.exceptions.InvalidPositionException;

import static org.junit.Assert.*;

public class PawnTest {

    private ChessBoard chessBoard;
    private Pawn testSubject;

    @Before
    public void setUp() {
        this.chessBoard = new ChessBoard();
        this.testSubject = new Pawn(PieceColor.BLACK);
    }

    @Test
    public void testChessBoard_Add_Sets_XCoordinate() throws InvalidPositionException {
        this.chessBoard.addPiece(testSubject, 6, 3, PieceColor.BLACK);
        assertEquals(6, testSubject.getXCoordinate());
    }

    @Test
    public void testChessBoard_Add_Sets_YCoordinate() throws InvalidPositionException {
        this.chessBoard.addPiece(testSubject, 6, 3, PieceColor.BLACK);
        assertEquals(3, testSubject.getYCoordinate());
    }


    @Test
    public void testPawn_Move_IllegalCoordinates_Right_DoesNotMove() throws InvalidPositionException, InvalidMovementException {
        chessBoard.addPiece(testSubject, 6, 3, PieceColor.BLACK);
        testSubject.move(MovementType.MOVE, 7, 3);
        assertEquals(6, testSubject.getXCoordinate());
        assertEquals(3, testSubject.getYCoordinate());
    }

    @Test
    public void testPawn_Move_IllegalCoordinates_Left_DoesNotMove() throws InvalidPositionException, InvalidMovementException {
        chessBoard.addPiece(testSubject, 6, 3, PieceColor.BLACK);
        testSubject.move(MovementType.MOVE, 4, 3);
        assertEquals(6, testSubject.getXCoordinate());
        assertEquals(3, testSubject.getYCoordinate());
    }

    @Test
    public void testPawn_Move_LegalCoordinates_Forward_UpdatesCoordinates() throws InvalidPositionException, InvalidMovementException {
        chessBoard.addPiece(testSubject, 6, 3, PieceColor.BLACK);
        testSubject.move(MovementType.MOVE, 6, 2);
        assertEquals(6, testSubject.getXCoordinate());
        assertEquals(2, testSubject.getYCoordinate());
    }

}