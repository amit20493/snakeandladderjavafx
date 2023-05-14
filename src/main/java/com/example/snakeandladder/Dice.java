package com.example.snakeandladder;

import javafx.event.ActionEvent;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class Dice {
    private final Rectangle myDice;
    private String diceNum;
    public Dice(Rectangle myDice) {
        this.myDice = myDice;
    }
    public String generateRandom() {
        Random rand = new Random();
        int myRand = rand.nextInt(6) + 1;
        String URL = "file:\\C:\\Users\\harsh\\Desktop\\AP Project\\SnakeAndLadder\\src\\main\\java\\com\\example\\snakeandladder\\" + myRand + ".jpg";
        Image im = new Image(URL, false);
        myDice.setFill(new ImagePattern(im));
        myDice.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
        return Integer.toString(myRand);
    }
    public String getDiceNum() {
        return this.diceNum;
    }
    public void diceRoll() {
        myDice.setStroke(Color.rgb(255, 255, 255));
        this.diceNum = generateRandom();
    }
}
