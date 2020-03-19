/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author Prof. Matteo Palitto
 */
// creo un JFrame che contiene il gioco
//permette di avere la barra per il titolo e i classici pulsanti -ox
public class SpaceInvaders extends JFrame {

    // Lo spazio immenso (il Canvas incui dipingere la scena del gioco)
    private Space space = new Space();

    //private Graphics graphics;
    public SpaceInvaders() throws InterruptedException {
        super("Space Invaders 101"); //diamo un titolo alla finestra di gioco
        // quando premo la X della finestra voglio terminare il gioco/programma
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // aggiungo lo spazio profondo alla finestra di gioco
        this.setResizable(false);
        setIgnoreRepaint(true);

        // avvia l'introduzione
        Intro intro = new Intro();
        this.add(intro);
        // impacchetto il tutto e rendo visibile
        this.pack();
        this.setVisible(true);

        intro.run();
//        this.remove(intro);
//        this.add(space);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        new SpaceInvaders();
    }

}







