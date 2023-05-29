package org.example;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel{
    static final int WIDTH = 800;
    static final int HEIGHT = 800;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (WIDTH*HEIGHT)/UNIT_SIZE;
    boolean running = true;
    GamePanel() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawComponent(g);
    }

    public void drawComponent(Graphics g) {
        if (running){
            for (int i = 0; i <HEIGHT/UNIT_SIZE; i++) {
                g.drawLine(i * UNIT_SIZE, 0, i*UNIT_SIZE, HEIGHT);
                g.drawLine(0, i * UNIT_SIZE, WIDTH, i * UNIT_SIZE);
            }
        }
    }
}
