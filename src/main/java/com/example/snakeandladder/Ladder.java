package com.example.snakeandladder;

import javafx.scene.shape.Line;

public class Ladder extends Line {
    private double topPosX;
    private double topPosY;
    private double bottomPosX;
    private int bottomTileNum;
    private double bottomPosY;
    private int topTileNum;

    public Ladder(double topPosX, double topPosY, int topTileNum, double bottomPosX, double bottomPosY, int bottomTileNum) {
        this.topPosX = topPosX;
        this.bottomPosX= bottomPosX;
        this.topPosY = topPosY;
        this.topTileNum = topTileNum;
        this.bottomPosY = bottomPosY;
        this.bottomTileNum = bottomTileNum;
    }
    public double getTopPosX() {
        return topPosX;
    }
    public double getTopPosY() {
        return topPosY;
    }
    public double getBottomPosX() {
        return bottomPosX;
    }
    public double getBottomPosY() {
        return bottomPosY;
    }
    public int getBottomTileNum() {
        return this.bottomTileNum;
    }
    public int getTopTileNum() {
        return this.topTileNum;
    }
}
