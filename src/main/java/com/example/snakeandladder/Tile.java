package com.example.snakeandladder;

class Tile {
    private double x;
    private double y;
    private double width;
    private double height;
    private int tileNum;
    private String type;
    public Tile (double x, double y, double width, double height, int tileNum, String type) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.tileNum = tileNum;
        this.type = type;
    }
    public double getPosX() {
        return this.x;
    }
    public double getPosY() {
        return this.y;
    }
    public int getTileNum() {
        return this.tileNum;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }
}