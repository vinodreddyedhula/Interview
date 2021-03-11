package com.ncr.chess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ncr.exceptions.InvalidMovementException;
import com.ncr.interfaces.PawnInterface;

public class Pawn extends PawnPiece  implements PawnInterface {


	public static final Logger log = LoggerFactory.getLogger( Pawn.class );

	Pawn(PieceColor pieceColor) {
		super(pieceColor);
	}
 
	@Override
    public void move( MovementType movementType, int newXCoordinate, int newYCoordinate ) throws InvalidMovementException
    {
        switch ( movementType )
        {
            case MOVE:
                if ( !isValidMoveForChessPiece( newXCoordinate, newYCoordinate ) )
                {
                	log.error("Invalid Move");
                   throw new InvalidMovementException( "Invalid movement", this, newXCoordinate, newYCoordinate, movementType );
                }
                break;
            case CAPTURE:
                if ( !isValidCaptureForChessPiece( newXCoordinate, newYCoordinate ) )
                {
                	log.error("Invalid Capture");
                   throw new InvalidMovementException( "Invalid movement", this, newXCoordinate, newYCoordinate, movementType );
                }
                break;
            default:
            	log.error("Invalid Type");
                throw new InvalidMovementException( "Unrecognised MovementType: " + movementType, this, newXCoordinate, newYCoordinate, movementType );
                
        }


        // to check  a piece already occupy the new position already 
        Pawn occupyingPiece = getChessBoard().getPawnAtCoordinate( newXCoordinate, newYCoordinate );

        if ( occupyingPiece != null )
        {
        
            if ( this.getPieceColor().equals( occupyingPiece.getPieceColor() ) )
            {
            	// throw error for a Chess piece on the same side already exists at position
            	  throw new InvalidMovementException( "A Chess piece on the same side already exists at position " + newXCoordinate + "," + newYCoordinate, this, newXCoordinate, newYCoordinate, movementType );
            }

            this.capturePiece( occupyingPiece );
        }

        //  move the piece to the new position
        this.setXCoordinate( newXCoordinate );
        this.setYCoordinate( newYCoordinate );

    }

    @Override
    public String toString() {
        return getCurrentPositionAsString();
    }

    protected String getCurrentPositionAsString() {
        String eol = System.lineSeparator();
        return String.format("Current X: {1}{0}Current Y: {2}{0}Piece Color: {3}", eol, xCoordinate, yCoordinate, pieceColor);
    }
    
    @Override
    public boolean isValidMoveForChessPiece( int xCoordinate, int yCoordinate )
    {
        // Pawns can only move one space forward
        if ( this.getyCoordinate() - 2 < 0 )
        {
            // this pawn started at the bottom the of board so y must be one greater than current y coordinate
            return ( yCoordinate - this.getYCoordinate() == 1 );
        }
        else
        {
            // this pawn started at the top the of board so y must be one less than current y coordinate
            return ( yCoordinate - this.getYCoordinate() ) == -1;

        }
    }
    
      public void capturePiece( Pawn capturedPiece ){
        capturedPiece.setXCoordinate( -1 );
        capturedPiece.setYCoordinate( -1 );
        }


	@Override
    public boolean isValidCaptureForChessPiece( int xCoordinate, int yCoordinate )
    {
        throw new UnsupportedOperationException( "Need to implement Pawn.isValidCaptureForChessPiece()" );
    }

}
