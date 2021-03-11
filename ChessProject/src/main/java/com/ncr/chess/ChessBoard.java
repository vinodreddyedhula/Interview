package com.ncr.chess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ncr.exceptions.InvalidPositionException;
import com.ncr.interfaces.ChessBoardInterface;


public class ChessBoard implements ChessBoardInterface{
	
	  public static final Logger log = LoggerFactory.getLogger( ChessBoard.class );

    public static int MAX_BOARD_WIDTH = 7;
    public static int MAX_BOARD_HEIGHT = 7;

    private Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[MAX_BOARD_WIDTH][MAX_BOARD_HEIGHT];
    }

    /**
     * Adds a chess piece to the chess board
     *
     * @param  Pawn pawn  to add
     * @param xCoordinate Integer x coordinate to set the chess piece to
     * @param yCoordinate Integer x coordinate to set the chess piece to
     * @throws InvalidPositionException if the x,y coordinates are invalid or already occupied
     */
    
	@Override
    public void addPiece(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) throws InvalidPositionException {
    	
    	   //check the legalBoradPosition
    	   if ( !isLegalBoardPosition( xCoordinate, yCoordinate ) )
           {
    		   xCoordinate=-1;
    		   yCoordinate=-1;
    		   pawn.setXCoordinate( xCoordinate );
        	   pawn.setYCoordinate( yCoordinate );
        	   log.debug("Chess Board is not in legal position");
        	   throw new InvalidPositionException( "Position: " + xCoordinate + "," + yCoordinate + " outwith board limits", this, xCoordinate, yCoordinate);
               
        	   }
    	   //checking the coordinates with in the range
    	   if(xCoordinate!=-1 && yCoordinate!=-1) {
        	   pawn.setXCoordinate( xCoordinate );
        	   pawn.setYCoordinate( yCoordinate );
        	   pawn.setPieceColor(pieceColor);
        	   pawn.setChessBoard( this );
               this.pieces[xCoordinate][yCoordinate] = pawn;
               log.info("added pawn successfully");
    	   }

      
    }

	
	 /**
     * Determines if the coordinates provided are valid.  Currently coordinate out of bounds of the board, or those
     * already occupied will be deemed invalid
     *
     * @param xCoordinate Integer for checking the ChessBoard's X coordinate against
     * @param yCoordinate Integer for checking the ChessBoard's Y coordinate against
     * @return Boolean if the x,y coordinates are valid
     */
    @Override
    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
    	
    	//checking the coordinates within the board
    	 if ( xCoordinate < 0 || xCoordinate >= MAX_BOARD_WIDTH || 
    			   yCoordinate < 0 || yCoordinate >= MAX_BOARD_HEIGHT )
         {
    		 log.warn( "Coordinate: {},{} is outwith this board's limits", xCoordinate, yCoordinate );
             return false;
         }
    	 //getting the coordinates of pawn 
         if ( null != getPawnAtCoordinate( xCoordinate, yCoordinate ) )
         {
        	 log.warn( "Coordinate: {},{} is already populated", xCoordinate, yCoordinate );
             return false;
         }
         return true;
    }
    
    /**
     * Returns the Pawn at the requested coordinate
     *
     * @param xCoordinate Integer x coordinate to check for Chess Pieces
     * @param yCoordinate Integer y coordinate to check for Chess Pieces
     * @return Pawn if one found or null
     */
    @Override
    public Pawn getPawnAtCoordinate( int xCoordinate, int yCoordinate )
    {
        return this.pieces[xCoordinate][yCoordinate];
    }
    
    
}
