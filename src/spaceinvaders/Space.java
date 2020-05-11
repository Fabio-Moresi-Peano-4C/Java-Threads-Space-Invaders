package spaceinvaders;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root
 */

    class Space extends Canvas {

    protected final int w = 800;
    protected final int h = 600;

    public BufferedImage alien, ship;
    public int H = 0;
    public static boolean firePressed = false;
    public static boolean leftPressed = false;
    /** True if the right cursor key is currently pressed */
    public static boolean rightPressed = false;
    public int Sx = 0; //ship X position


    Space() {
        System.out.println("Setting canvas background and dimentions ");

        setBackground(Color.BLACK);
        setSize(w, h);
        ImageCanvas();
        addKeyListener(new KeyInputHandler());
        // request the focus so key events come to us
        requestFocus();
    }

    public void ImageCanvas() {
        try {
            alien = ImageIO.read(new File("alien.png"));
            ship = ImageIO.read(new File("ship.png"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
//        @Override
//        public Dimension getPreferredSize() {
//            return img == null ? new Dimension(200, 200) : new Dimension(img.getWidth(), img.getHeight());
//        }

}

