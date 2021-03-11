package com.ncr.exceptions;

import com.ncr.chess.MovementType;
import com.ncr.chess.Pawn;

public class InvalidMovementException extends ChessPieceException
{
    protected int xCoordinate;
    protected int yCoordinate;
    protected MovementType movementType;

    public InvalidMovementException( String message, Pawn chessPiece, int xCoordinate, int yCoordinate, MovementType movementType )
    {
        super( message, chessPiece );
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.movementType = movementType;
    }

    public InvalidMovementException( String message, Pawn chessPiece, int xCoordinate, int yCoordinate, MovementType movementType, Throwable cause )
    {
        super( message, chessPiece, cause );
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.movementType = movementType;
    }

    public int getxCoordinate()
    {
        return xCoordinate;
    }

    public int getyCoordinate()
    {
        return yCoordinate;
    }
}
