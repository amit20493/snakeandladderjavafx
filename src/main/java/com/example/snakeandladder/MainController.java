package com.example.snakeandladder;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
import javafx.util.Duration;

public class MainController {
    @FXML
    private Label winnerStatus;
    @FXML
    private Circle winnerPlayer;
    @FXML
    private Rectangle myDice;

    private Player player1;
    private Player player2;

    public void initialize() {
        this.player1 = new Player("Player1", Player1, Main.board, myDice);
        this.player1.setTurn(true);
        Image im = new Image("file:\\C:\\Users\\harsh\\Desktop\\AP Project\\SnakeAndLadder\\src\\main\\arrowOne.jpg", false);
        arrow.setFill(new ImagePattern(im));
        TranslateTransition tt = new TranslateTransition();
        tt.setNode(arrow);
        tt.setDuration(Duration.millis(500));
        tt.setCycleCount(TranslateTransition.INDEFINITE);
        tt.setByY(10);
        tt.setAutoReverse(true);
        tt.play();
        this.player2 = new Player("Player2", Player2, Main.board, myDice);
    }

    public void playerOneClick(ActionEvent event) throws Exception {
        if (!Main.gameOver && this.player1.isTurn()) {
            if (this.player1.isLocked()) {
                int diceNum = Integer.parseInt(this.player1.getDiceNum());
                if (diceNum == 6) {
                    double posX = this.player1.getBoard().getBoard()[0][0].getPosX();
                    double posY = this.player1.getBoard().getBoard()[0][0].getPosY();
                    this.player1.unlock();
                    this.player1.movePlayerOnTile(posX, posY, 1);
                }
                if (this.player1.getTile().getType().equals("LadderTail")) {
                    double posX = this.player1.getCurrPosX();
                    double posY = this.player1.getCurrPosY();
                    int topTileNum = this.player1.getTileNum();
                    for (int i = 0; i < 8; i++) {
                        if (Main.laddersList[i].getBottomTileNum() == this.player1.getTileNum()) {
                            posX = Main.laddersList[i].getTopPosX();
                            posY = Main.laddersList[i].getTopPosY();
                            topTileNum = Main.laddersList[i].getTopTileNum();
                            break;
                        }
                    }
                    this.player1.movePlayerOnTile(posX, posY, topTileNum);
                }
                this.player1.setTurn(false);
                this.player2.setTurn(true);
                TranslateTransition tt = new TranslateTransition();
                tt.setNode(arrow);
                tt.setDuration(Duration.millis(500));
                tt.setCycleCount(1);
                tt.setByX(130);
                tt.setAutoReverse(false);
                tt.play();
                return;
            }
            if (!this.player1.isCompleted()) {
                int diceNum = Integer.parseInt(this.player1.getDiceNum());
                int currTile = this.player1.getTileNum();
                int nextTile = currTile + diceNum;
                if (nextTile > 100) {
                    this.player1.setTurn(false);
                    this.player2.setTurn(true);
                    TranslateTransition tt = new TranslateTransition();
                    tt.setNode(arrow);
                    tt.setDuration(Duration.millis(500));
                    tt.setCycleCount(1);
                    tt.setByX(130);
                    tt.setAutoReverse(false);
                    tt.play();
                    return;
                }
                while (currTile < nextTile) {
                    int i = currTile / 10;
                    int j;
                    if ((currTile + 1) % 10 == 0) {
                        j = 9;
                    } else {
                        j = ((currTile + 1) % 10) - 1;
                    }
                    double posX = this.player1.getBoard().getBoard()[i][j].getPosX();
                    double posY = this.player1.getBoard().getBoard()[i][j].getPosY();
                    this.player1.movePlayerOnTile(posX, posY, nextTile);
                    currTile++;
                }
                if (this.player1.getTile().getType().equals("LadderTail")) {
                    double posX = this.player1.getCurrPosX();
                    double posY = this.player1.getCurrPosY();
                    int topTileNum = this.player1.getTileNum();
                    for (int i = 0; i < 8; i++) {
                        if (Main.laddersList[i].getBottomTileNum() == this.player1.getTileNum()) {
                            posX = Main.laddersList[i].getTopPosX();
                            posY = Main.laddersList[i].getTopPosY();
                            topTileNum = Main.laddersList[i].getTopTileNum();
                            break;
                        }
                    }
                    this.player1.movePlayerOnTile(posX, posY, topTileNum);
                }
                else if (this.player1.getTile().getType().equals("SnakeHead")) {
                    double posX = this.player1.getCurrPosX();
                    double posY = this.player1.getCurrPosY();
                    int tailTileNum = this.player1.getTileNum();
                    for (int i = 0; i < 7; i++) {
                        if (Main.snakesList[i].getHeadTileNum() == this.player1.getTileNum()) {
                            posX = Main.snakesList[i].getTailPosX();
                            posY = Main.snakesList[i].getTailPosY();
                            tailTileNum = Main.snakesList[i].getTailTileNum();
                            break;
                        }
                    }
                    this.player1.movePlayerOnTile(posX, posY, tailTileNum);
                }
                if (this.player1.getTileNum() == 100) {
                    this.player1.setCompleted();
                    Main.gameOver = true;
                    winnerStatus.setText("WINNER");
                    winnerPlayer.setFill(Paint.valueOf("#fc1414"));
                    arrow.setFill(Paint.valueOf("TRANSPARENT"));
                    return;
                }

                this.player1.setTurn(false);
                this.player2.setTurn(true);
                TranslateTransition tt = new TranslateTransition();
                tt.setNode(arrow);
                tt.setDuration(Duration.millis(500));
                tt.setCycleCount(1);
                tt.setByX(130);
                tt.setAutoReverse(false);
                tt.play();
            }
        }
    }
    public void playerTwoClick(ActionEvent event) throws Exception {
        if (!Main.gameOver && this.player2.isTurn()) {
            if (this.player2.isLocked()) {
                int diceNum = Integer.parseInt(this.player2.getDiceNum());
                if (diceNum == 6) {
                    double posX = this.player2.getBoard().getBoard()[0][0].getPosX();
                    double posY = this.player2.getBoard().getBoard()[0][0].getPosY();
                    this.player2.unlock();
                    this.player2.movePlayerOnTile(posX, posY, 1);
                }
                if (this.player2.getTile().getType().equals("LadderTail")) {
                    double posX = this.player2.getCurrPosX();
                    double posY = this.player2.getCurrPosY();
                    int topTileNum = this.player2.getTileNum();
                    for (int i = 0; i < 8; i++) {
                        if (Main.laddersList[i].getBottomTileNum() == this.player2.getTileNum()) {
                            posX = Main.laddersList[i].getTopPosX();
                            posY = Main.laddersList[i].getTopPosY();
                            topTileNum = Main.laddersList[i].getTopTileNum();
                            break;
                        }
                    }
                    this.player2.movePlayerOnTile(posX, posY, topTileNum);
                }
                this.player2.setTurn(false);
                this.player1.setTurn(true);
                TranslateTransition tt = new TranslateTransition();
                tt.setNode(arrow);
                tt.setDuration(Duration.millis(500));
                tt.setCycleCount(1);
                tt.setByX(-130);
                tt.setAutoReverse(false);
                tt.play();
                return;
            }
            if (!this.player2.isCompleted()) {
                int diceNum = Integer.parseInt(this.player2.getDiceNum());
                int currTile = this.player2.getTileNum();
                int nextTile = currTile + diceNum;
                if (nextTile > 100) {
                    this.player2.setTurn(false);
                    this.player1.setTurn(true);
                    TranslateTransition tt = new TranslateTransition();
                    tt.setNode(arrow);
                    tt.setDuration(Duration.millis(500));
                    tt.setCycleCount(1);
                    tt.setByX(-130);
                    tt.setAutoReverse(false);
                    tt.play();
                    return;
                }
                while (currTile < nextTile) {
                    int i = currTile / 10;
                    int j;
                    if ((currTile + 1) % 10 == 0) {
                        j = 9;
                    }
                    else {
                        j = ((currTile + 1) % 10) - 1;
                    }
                    double posX = this.player2.getBoard().getBoard()[i][j].getPosX();
                    double posY = this.player2.getBoard().getBoard()[i][j].getPosY();
                    this.player2.movePlayerOnTile(posX, posY, nextTile);
                    currTile++;
                }
                if (this.player2.getTile().getType().equals("LadderTail")) {
                    double posX = this.player2.getCurrPosX();
                    double posY = this.player2.getCurrPosY();
                    int topTileNum = this.player2.getTileNum();
                    for (int i = 0; i < 8; i++) {
                        if (Main.laddersList[i].getBottomTileNum() == this.player2.getTileNum()) {
                            posX = Main.laddersList[i].getTopPosX();
                            posY = Main.laddersList[i].getTopPosY();
                            topTileNum = Main.laddersList[i].getTopTileNum();
                            break;
                        }
                    }
                    this.player2.movePlayerOnTile(posX, posY, topTileNum);
                }
                else if (this.player2.getTile().getType().equals("SnakeHead")) {
                    double posX = this.player2.getCurrPosX();
                    double posY = this.player2.getCurrPosY();
                    int tailTileNum = this.player2.getTileNum();
                    for (int i = 0; i < 7; i++) {
                        if (Main.snakesList[i].getHeadTileNum() == this.player2.getTileNum()) {
                            posX = Main.snakesList[i].getTailPosX();
                            posY = Main.snakesList[i].getTailPosY();
                            tailTileNum = Main.snakesList[i].getTailTileNum();
                            break;
                        }
                    }
                    this.player2.movePlayerOnTile(posX, posY, tailTileNum);
                }
                if (this.player2.getTileNum() == 100) {
                    this.player2.setCompleted();
                    Main.gameOver = true;
                    winnerStatus.setText("WINNER");
                    winnerPlayer.setFill(Paint.valueOf("DODGERBLUE"));
                    arrow.setFill(Paint.valueOf("TRANSPARENT"));
                    return;
                }
                this.player2.setTurn(false);
                this.player1.setTurn(true);
                TranslateTransition tt = new TranslateTransition();
                tt.setNode(arrow);
                tt.setDuration(Duration.millis(500));
                tt.setCycleCount(1);
                tt.setByX(-130);
                tt.setAutoReverse(false);
                tt.play();
            }
        }
    }
    // --------------------------------------- Players -----------------------------------------------------------------
    @FXML
    private Circle Player1;
    @FXML
    private Circle Player2;
    // -----------------------------------------------------------------------------------------------------------------
    // -------------------------------------- Arrow --------------------------------------------------------------------
    @FXML
    private Rectangle arrow;
    // -----------------------------------------------------------------------------------------------------------------

}
