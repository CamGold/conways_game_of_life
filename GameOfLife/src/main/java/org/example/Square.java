package org.example;

import java.awt.*;

public class Square {
    private Boolean visible;
    int squareX;
    int squareY;

    public Square(int squareX, int squareY) {
        this.squareX = squareX;
        this.squareY = squareY;
        this.visible = false;
    }
    public int getSquareX() {
        return this.squareX;
    }

    public int getSquareY() {
        return this.squareY;
    }
    public Color getColor() {
        if(visible){
            return Color.WHITE;
        }
        else{
            return Color.BLACK;
        }
    }
    public void setVisible(boolean visible){
        this.visible = visible;
    }


    public int setSquareY(){
        return this.squareY;
    }

}
