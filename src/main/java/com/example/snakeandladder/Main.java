package com.example.snakeandladder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class Main extends Application{
    public static Tile[][] tileArray = new Tile[10][10];
    public static Snake[] snakesList = new Snake[7];
    public static Ladder[] laddersList = new Ladder[8];
    public static Board board;
    public static boolean gameOver = false;
    public static void main(String[] args) {
        // ---------------------------- Tiles --------------------------------------------------------------------------
        boolean isReversed = false;
        double x = 0.0;
        double y = -67.0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Tile tile = new Tile(x, y,48.0, 48.0, (i * 10) + (j + 1), "none");
                tileArray[i][j] = tile;
                if (j == 9) {
                    break;
                }
                if (isReversed) {
                    x -= 48;
                }
                else {
                    x += 48;
                }
            }
            isReversed = !isReversed;
            y -= 48;
        }
        Main.tileArray[0][0].setType("LadderTail");
        Main.tileArray[0][3].setType("LadderTail");
        Main.tileArray[0][5].setType("SnakeTail");
        Main.tileArray[0][7].setType("LadderTail");
        Main.tileArray[0][9].setType("SnakeTail");
        Main.tileArray[1][3].setType("LadderHead");
        Main.tileArray[1][7].setType("SnakeTail");
        Main.tileArray[2][0].setType("LadderTail");
        Main.tileArray[2][3].setType("SnakeTail");
        Main.tileArray[2][5].setType("SnakeTail");
        Main.tileArray[2][7].setType("LadderTail");
        Main.tileArray[2][9].setType("LadderHead");
        Main.tileArray[3][7].setType("LadderHead");
        Main.tileArray[3][5].setType("SnakeHead");
        Main.tileArray[3][1].setType("SnakeHead");
        Main.tileArray[4][1].setType("LadderHead");
        Main.tileArray[4][7].setType("SnakeHead");
        Main.tileArray[4][9].setType("LadderTail");
        Main.tileArray[5][5].setType("SnakeTail");
        Main.tileArray[6][1].setType("SnakeHead");
        Main.tileArray[6][6].setType("LadderHead");
        Main.tileArray[7][0].setType("LadderTail");
        Main.tileArray[7][5].setType("LadderHead");
        Main.tileArray[7][7].setType("SnakeTail");
        Main.tileArray[7][9].setType("LadderTail");
        Main.tileArray[8][7].setType("SnakeHead");
        Main.tileArray[9][1].setType("LadderHead");
        Main.tileArray[9][4].setType("SnakeHead");
        Main.tileArray[9][6].setType("SnakeHead");
        Main.tileArray[9][8].setType("LadderHead");
//        for(int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                System.out.println(Main.tileArray[i][j].getTileNum() + " " +  Main.tileArray[i][j].getPosX() + " " + Main.tileArray[i][j].getPosY());
//            }
//        }
        // -------------------------------------------------------------------------------------------------------------
        // --------------------------- Snakes --------------------------------------------------------------------------
        Snake snake1 = new Snake(192.0, -211.0, 240.0, -67.0, 36, 6);
        Snake snake2 = new Snake(384.0, -211.0, 432.0, -67.0, 32, 10);
        Snake snake3 = new Snake(336.0, -259.0, 240.0, -163.0, 48, 26);
        Snake snake4 = new Snake(48.0, -355.0, 96.0, -115.0, 62, 18);
        Snake snake5 = new Snake(144.0, -499.0, 96.0, -403.0, 97, 78);
        Snake snake6 = new Snake(240.0, -499.0, 192.0, -307.0, 95, 56);
        Snake snake7 = new Snake(336.0, -451.0, 144.0, -163.0, 88, 24);
        Main.snakesList = new Snake[]{snake1, snake2, snake3, snake4, snake5, snake6, snake7};
        // -------------------------------------------------------------------------------------------------------------
        // ------------------------- Ladders ---------------------------------------------------------------------------
        Ladder ladder1 = new Ladder(96.0, -211.0, 38, 0.0, -67.0, 1);
        Ladder ladder2  = new Ladder(288.0, -115.0, 14, 144.0, -67.0, 4);
        Ladder ladder3 = new Ladder(432.0, -163.0, 30, 336.0, -67.0, 8);
        Ladder ladder4 = new Ladder(48.0, -259.0, 42, 0.0, -163.0, 21);
        Ladder ladder5 = new Ladder(288.0, -355.0, 67, 432.0, -259.0, 50);
        Ladder ladder6 = new Ladder(48.0, -499.0, 99, 0.0, -403.0, 80);
        Ladder ladder7 = new Ladder(384.0, -499.0, 92, 432.0, -403.0, 71);
        Ladder ladder8 = new Ladder(192.0, -403.0, 76, 336.0, -163.0, 28);
        Main.laddersList = new Ladder[]{ladder1, ladder2, ladder3, ladder4, ladder5, ladder6, ladder7, ladder8};
        // -------------------------------------------------------------------------------------------------------------
        board = new Board(tileArray, snakesList, laddersList);
        // ----------------------- Players -----------------------------------------------------------------------------
        // -------------------------------------------------------------------------------------------------------------
        launch(args);
    }
    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("game.fxml"));
//            ImageView selectedImage = new ImageView();
//            Image board = new Image(Main.class.getResourceAsStream("file:\\C:\\Users\\harsh\\Desktop\\AP Project\\SnakeAndLadder\\src\\main\\java\\com\\example\\snakeandladder\\board.jpg"));
//            selectedImage.setImage(board);
            Scene scene = new Scene(root);
            stage.getIcons().add(new Image("file:\\C:\\Users\\harsh\\Desktop\\AP Project\\SnakeAndLadder\\src\\main\\icon.jpg"));
            stage.setTitle("Snake And Ladder");
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
