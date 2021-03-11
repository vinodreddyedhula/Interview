package com.ncr.chess;

public class ChessBoard {

    public static int MAX_BOARD_WIDTH = 7;
    public static int MAX_BOARD_HEIGHT = 7;

    private Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[MAX_BOARD_WIDTH][MAX_BOARD_HEIGHT];
    }

    public void addPiece(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
    	
    	if(xCoordinate>MAX_BOARD_WIDTH-1 || yCoordinate >MAX_BOARD_HEIGHT-1) {
    		pawn.setXCoordinate(-1);
    		pawn.setYCoordinate(-1);
    		return;
    	}
    	if(pieces[xCoordinate][yCoordinate]!=null) {
    		pawn.setXCoordinate(-1);
    		pawn.setYCoordinate(-1);
    		return;
    	}
    	
    	pawn.setXCoordinate(xCoordinate);
    	pawn.setYCoordinate(yCoordinate);
    	pieces[xCoordinate][yCoordinate]=pawn;
    
        //throw new UnsupportedOperationException("Need to implement ChessBoard.add()");
    }

    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
    	boolean isValid=false;
    	if(xCoordinate==yCoordinate) {
    		isValid=true;
    	}
    	return isValid;
        //throw new UnsupportedOperationException("Need to implement ChessBoard.IsLegalBoardPosition()");
    }
}
