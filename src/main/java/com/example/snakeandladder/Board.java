package com.example.snakeandladder;

import javafx.event.ActionEvent;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.Arrays;

public class Board extends Rectangle {
    private Tile[][] board;
    private Snake[] snakes;
    private Ladder[] ladders;

    public Board(Tile[][] board, Snake[] snakes, Ladder[] ladders) {
        this.board = board;
        this.snakes = snakes;
        this.ladders = ladders;
    }
    public Snake[] getSnakesList() {
        return this.snakes;
    }
    public Tile[][] getBoard() {
        return this.board;
    }
    public Ladder[] getLaddersList() {
        return this.ladders;
    }
    public Tile getTile(int i, int j) {
        return board[i][j];
    }
}




