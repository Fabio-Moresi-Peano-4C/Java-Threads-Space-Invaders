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
import java.util.ArrayList;
import java.util.Random;
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

class Space extends Canvas {
    protected final int w = 800;
    protected final int h = 600;

    Space() {
       System.out.println("Setting canvas background and dimentions ");

       setBackground (Color.BLACK);
       setSize(w, h);
    }
    
}

class Point {
    int x;
    int y;
    
    void setPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Intro extends Space {
    private int i = 0;
    private BufferStrategy strategy;
    private Point stelle1[] = new Point[222];
    private Point stelle2[] = new Point[222];
        
    void run() throws InterruptedException {
        createBufferStrategy(2);
        strategy = getBufferStrategy();
        
        //creo i 2 cieli stellati
        //due vettori ognuno con le coordinate delle 222 stelle
        for (int i = 0; i < 222; i++) {
          Random r = new Random();
          stelle1[i] = new Point();
          stelle1[i].x = Math.abs(r.nextInt()) % w;
          stelle1[i].y = Math.abs(r.nextInt()) % h;
        }        


        for (int i = 0; i < 222; i++) {
          Random r = new Random();
          stelle2[i] = new Point();
          stelle2[i].x = Math.abs(r.nextInt()) % w;
          stelle2[i].y = Math.abs(r.nextInt()) % h;
        }        

        
        for(i=98;i>0;i-=1) {
            disegna(i);
            Thread.sleep(10);
        }
//        //Thread.sleep(100);
//        for(i=0;i<10;i+=1) {
//            disegna(i);
//            //Thread.sleep(10);
//        }
        int j = 0;
        while(true) {
            for(j=0;j<98;j++) {
                disegna(j);
                Thread.sleep(30);
            }
            for(j=98;j>0;j--) {
                disegna(j);
                Thread.sleep(30);
            }
        }
    }
   
    void disegna(int n) {
        //chiediamo il buffer in cui comporre la nuova immagine
        Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
        //cancelliamo l'immagine precedente coprendola con un rettangolo nero
        g.setColor(Color.black);
        g.fillRect(0,0,w,h);
 
        //meta' del cielo non brilla
        Color stelleColor=new Color(222,222,222);
        g.setColor(stelleColor);
        for (int i = 0; i < 111; i++) {
          g.drawLine(stelle1[i].x, stelle1[i].y, stelle1[i].x, stelle1[i].y);
          g.drawLine(stelle2[i].x, stelle2[i].y, stelle2[i].x, stelle2[i].y);
       }        
        
        //vario il colore delle stelle ad ogni fotogramma
        //in modo che le stelle del cielo stellato 1 da bianche
        //gradualmente diventino nere
        //e viceversa il colore delle stelle del cielo stellato 2
        //gradualmente da nere diventino bianche
        //cielo stellato1
        int rgb;
        if (n > 50)  rgb = (n % 50) * 5;
        else rgb = (((n -1) % 50) - 50) * -5;
        System.out.println("n: "+ n + " rgb1: " + rgb);
        stelleColor=new Color(rgb,rgb,rgb);
        g.setColor(stelleColor);
        for (int i = 111; i < 222; i++) {
          g.drawLine(stelle1[i].x, stelle1[i].y, stelle1[i].x, stelle1[i].y);
        }        
        
        //cielo stellato2
        if (n < 50)  rgb = (n % 50) * 5;
        else rgb = (((n + 1) % 50) - 50) * -5;
        System.out.println("n: "+ n + " rgb2: " + rgb);
        stelleColor=new Color(rgb,rgb,rgb);
        g.setColor(stelleColor);
        for (int i = 111; i < 222; i++) {
          g.drawLine(stelle2[i].x, stelle2[i].y, stelle2[i].x, stelle2[i].y);
        }        
        
        // scrivi nel buffer la scritta in Rosso 
        g.setColor(Color.red);
        g.setFont(new Font("Bold", Font.PLAIN, 40+i));
        g.drawString("Space Invaders", 100+i, 100+i);
        g.setFont(new Font("Bold", Font.PLAIN, 10+i));
        g.drawString("          by Matteo Palitto", 110+i+i, 110+i+i);
        //rilascia risorse create per la composizione di questa immagine
        g.dispose(); 
        //visualizza la nuova immagine sullo schermo
        strategy.show(); 
    }

}
