package com.ncr.interfaces;

import com.ncr.chess.Pawn;
import com.ncr.chess.PieceColor;
import com.ncr.exceptions.InvalidPositionException;

public interface ChessBoardInterface {

	void addPiece(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) throws InvalidPositionException;

	boolean isLegalBoardPosition(int xCoordinate, int yCoordinate);

	Pawn getPawnAtCoordinate(int xCoordinate, int yCoordinate);

}
