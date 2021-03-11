package com.ncr.interfaces;

import com.ncr.chess.MovementType;
import com.ncr.exceptions.InvalidMovementException;

public interface PawnInterface {
	
	void move(MovementType movementType, int newXCoordinate, int newYCoordinate) throws InvalidMovementException;

	boolean isValidCaptureForChessPiece(int xCoordinate, int yCoordinate);

	boolean isValidMoveForChessPiece(int xCoordinate, int yCoordinate);

}
