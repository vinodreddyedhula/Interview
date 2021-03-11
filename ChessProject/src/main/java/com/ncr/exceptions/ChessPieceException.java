package com.ncr.exceptions;
import com.ncr.chess.Pawn;

public class ChessPieceException extends Exception
{
    private Pawn chessPiece;

    public ChessPieceException( String message, Pawn chessPiece )
    {
        super( message );
        this.chessPiece = chessPiece;
    }

    public ChessPieceException( String message, Pawn chessPiece, Throwable cause )
    {
        super( message, cause );
        this.chessPiece = chessPiece;
    }
}
