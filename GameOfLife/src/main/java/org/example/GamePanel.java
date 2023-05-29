package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GamePanel extends JPanel{
    static final int WIDTH = 800;
    static final int HEIGHT = 800;
    static int UNIT_SIZE = 25;
    static final int GAME_UNITS = (WIDTH*HEIGHT)/UNIT_SIZE;
    JSlider slider = new JSlider(5, 25);

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
                squareX = e.getX();
                squareY = e.getY();
                System.out.println(squareX + " " + squareY);
                UNIT_SIZE = slider.getValue();
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {

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
        this.add(slider);
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
        squareX =UNIT_SIZE*(Math.round((float) squareX /UNIT_SIZE));
        squareY = UNIT_SIZE*(Math.round((float) squareY /UNIT_SIZE));
        g.setColor(Color.WHITE);
        g.fillRect(squareX, squareY, UNIT_SIZE, UNIT_SIZE);
    }

}
