package com.evmeister;

import java.util.HashMap;
import java.util.Map;

import com.evmeister.Node.pegPositions;

public class GameBoard {
    /*
     * The peg board puzzle is a triangle shaped game board with 15 holes. One is
     * left open to start the game, for 14 pegs total.
     * The holes are represented by a map of nodes linked by reference, and stored
     * in a list to iterate through.
     * The nodes have a positiion letter in case I need to throw an error that would
     * only happen if I made a typo in the GameBoard class.
     * Maybe I can use it to check whether a move is legal, i.e. so the game doesn't
     * jump corners
     * A is ascii #65. add 15 and you are at P
     * 
     *     A - A is at [0] in the List
     *    B C
     *   D E F
     *  G H I J
     * K L M N O - O is at [14] in the List
     */

    static private byte numPegs = 14;
    static public Map<Node.pegPositions, Node> board;
    static public final boolean PEG = true;
    static public final boolean NO_PEG = false;

    static public void initBoard() {
        GameBoard.board = new HashMap<>();
        for (Node.pegPositions position : Node.pegPositions.values()) {
            board.put(position, position == Node.pegPositions.A ? new Node(NO_PEG) : new Node(PEG));
        }
        board.get(Node.pegPositions.A).addAdjacentNode(Node.adjacentPositions.lowerLeft, board.get(Node.pegPositions.B));
    }

    private void setLeftRight(Node left, Node right) {
    //    board.get(left).addAdjacentNode(right, right);
    }
   
    // Accessor methods for the number of pegs
    static public byte getNumPegs() {
        return numPegs;
    }

    static public void resetPegsRemaining() {
        numPegs = 14;
    }

    static public void removePeg() {
        numPegs--;
    }
}