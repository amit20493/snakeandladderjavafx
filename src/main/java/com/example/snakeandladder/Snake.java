package com.example.snakeandladder;

import javafx.scene.shape.Line;

public class Snake extends Line {
    private double headPosX;
    private double headPosY;
    private double tailPosX;
    private double tailPosY;
    private int tailTileNum;
    private int headTileNum;

    public Snake(double headPosX, double headPosY, double tailPosX, double tailPosY, int headTileNum, int tailTileNum) {
        this.headPosX = headPosX;
        this.headPosY = headPosY;
        this.tailPosX = tailPosX;
        this.tailPosY = tailPosY;
        this.headTileNum = headTileNum;
        this.tailTileNum = tailTileNum;
    }
    public int getTailTileNum() {
        return tailTileNum;
    }
    public int getHeadTileNum() {
        return headTileNum;
    }
    public double getHeadPosX() {
        return headPosX;
    }
    public double getHeadPosY() {
        return headPosY;
    }
    public double getTailPosX() {
        return tailPosX;
    }
    public double getTailPosY() {
        return tailPosY;
    }
}
