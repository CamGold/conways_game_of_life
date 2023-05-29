package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GamePanel extends JPanel{
    static final int WIDTH = 800;
    static final int HEIGHT = 800;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (WIDTH*HEIGHT)/UNIT_SIZE;

    int squareX;
    int squareY;
    boolean running = true;
    GamePanel() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                squareX = e.getX();
                squareY = e.getY();
                System.out.println(squareX + " " + squareY);
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
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
            drawSquare(g);
        }
    }

    public void drawSquare(Graphics g) {
        squareX = 25*(Math.round((float) squareX /25));
        squareY = 25*(Math.round((float) squareY /25));
        g.setColor(Color.WHITE);
        g.fillRect(squareX, squareY, UNIT_SIZE, UNIT_SIZE);
    }

}
