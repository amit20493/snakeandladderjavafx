package com.example.snakeandladder;

import javafx.animation.PathTransition;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Player extends Circle {
//    private double prevPosX;
//    private double prevPosY;
    private double currPosX;
    private double currPosY;
    private Circle player;
    private Dice dice;
    private boolean completed = false;
    private boolean locked = true;
    private boolean turn = false;
    private int tileNum = 0;
    private Board board;
    private String name;

    public Player(String name, Circle player, Board board, Rectangle myDice) {
        this.name = name;
        this.player = player;
        this.board = board;
        this.dice = new Dice(myDice);

    }
//    public Circle getPlayer(){
//        return this.player;
//    }
    public Board getBoard() {
        return this.board;
    }
    public int getTileNum() {
        return tileNum;
    }
    public Tile getTile() {
        int i = (this.tileNum - 1) / 10;
        int j;
        if ((this.tileNum) % 10 == 0) {
            j = 9;
        }
        else {
            j = ((this.tileNum) % 10) - 1;
        }
        return this.board.getTile(i, j);
    }
    public void setTileNum(int tileNum) {
        this.tileNum = tileNum;
    }
//    public double getPrevPosX() {
//        return prevPosX;
//    }
//    public void setPrevPosX(double prevPosX) {
//        this.prevPosX = prevPosX;
//    }
//    public double getPrevPosY() {
//        return prevPosY;
//    }
//    public void setPrevPosY(double prevPosY) {
//        this.prevPosY = prevPosY;
//    }
    public double getCurrPosX() {
        return currPosX;
    }
    public void setCurrPosX(double currPosX) {
        this.currPosX = currPosX;
    }
    public double getCurrPosY() {
        return currPosY;
    }
    public void setCurrPosY(double currPosY) {
        this.currPosY = currPosY;
    }
    public boolean isLocked() {
        return this.locked;
    }
    public void unlock() {
        this.locked = false;
    }
    public boolean isTurn() {
        return turn;
    }
    public void setTurn(boolean turn) {
        this.turn = turn;
    }
    public String getDiceNum() {
        this.dice.diceRoll();
        return this.dice.getDiceNum();
    }
    public boolean isCompleted() {
        return completed;
    }
    public void setCompleted() {
        this.completed = true;
    }
    public void movePlayerOnTile(double posX, double posY, int tileNum) {
        PathTransition pt = new PathTransition();
        pt.setNode(this.player);
        Line line = new Line();
        line.setStartX(this.getCurrPosX());
        line.setStartY(this.getCurrPosY());
        line.setEndX(posX);
        line.setEndY(posY);
        pt.setDuration(Duration.seconds(1));
        pt.setPath(line);
        pt.setCycleCount(1);
        pt.play();
        setTileNum(tileNum);
        this.setCurrPosX(posX);
        this.setCurrPosY(posY);
    }
}


