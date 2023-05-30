package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements ActionListener{
    static final int WIDTH = 800;
    static final int HEIGHT = 800;
    static int UNIT_SIZE = 20;
    static final int GAME_UNITS = (WIDTH*HEIGHT)/UNIT_SIZE;
//    JSlider slider = new JSlider(5, 25);
    int delay = 100;
    Timer timer;
    ArrayList<Square> squareList = new ArrayList<>();
    int squareX;
    int squareY;
    boolean running = true;
    GamePanel() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
//        this.add(slider);
        timer = new Timer(delay, this);
//        UNIT_SIZE = slider.getValue();
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                squareX = e.getX();
                squareY = e.getY();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                UNIT_SIZE = slider.getValue();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        for (int i = 0; i <HEIGHT/UNIT_SIZE; i++) {
            for (int j = 0; j <HEIGHT; j++) {
                squareList.add(new Square(j * UNIT_SIZE, i * UNIT_SIZE));
            }
        }
        timer.start();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawComponent(g);
    }

    public void drawComponent(Graphics g) {
            createSquare(squareList);
            drawSquare(g, squareList);
    }

    public void createSquare(ArrayList<Square> squareList) {
        squareX =UNIT_SIZE*(Math.round((float) squareX /UNIT_SIZE));
        squareY = UNIT_SIZE*(Math.round((float) squareY /UNIT_SIZE));
        for(Square square : squareList){
            if (squareX == square.getSquareX() && squareY == square.getSquareY()){
                square.setVisible(true);
            }
        }
    }

    public void drawSquare(Graphics g, ArrayList<Square> squareList) {
        for (Square square : squareList) {
            int x = square.getSquareX();
            int y = square.setSquareY();
            g.setColor(square.getColor());
            g.fillRect(x, y, UNIT_SIZE, UNIT_SIZE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
