package com.evmeister;

import java.util.HashMap;
import java.util.Map;

public class Node {

    static public enum pegPositions {
        A, B, C, D, E, F, G, H, I, J, K, L, M, N, O;
    }

    static public enum adjacentPositions {
        left, lowerLeft, upperLeft, right, lowerRight, upperRight;
    }

    // State
    private boolean hasPeg = false;
    private Map<adjacentPositions, Node> adjacentNodes;

    Node(boolean peg) {
        this.hasPeg = peg;
        this.adjacentNodes = new HashMap<>();
    }

    public void setPeg(boolean peg) {
        this.hasPeg = peg;
    }

    public boolean getPeg() {
        return this.hasPeg;
    }

    // Method to add an adjacent node
    public void addAdjacentNode(adjacentPositions position, Node node) {
        adjacentNodes.put(position, node);
    }

    // Method to get an adjacent node
    public Node getAdjacentNode(adjacentPositions position) {
        return adjacentNodes.get(position);
    }

    // Example method to print node connections
    public void printConnections() {
        for (Map.Entry<adjacentPositions, Node> entry : adjacentNodes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().hasPeg);
        }
    }
}
