/*
 * /*
 * ****************************
 * *    2020(c)Project by     *
 * *                          *
 * *       Moresi Fabio       *
 * *          4C Inf          *
 * *                          *
 * ****************************
 * */
package space_invaders;

import com.golden.gamedev.object.AnimatedSprite;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferStrategy;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author FabioMoresi
 */
public class Intro extends Space {
   private int lifeCounter;
public AnimatedSprite alienex;
    BufferedImage[] aliexp;
    private int i = 0;
    private BufferStrategy strategy;
    private Point stelle1[] = new Point[222];
    private Point stelle2[] = new Point[222];
    private Point bullets[] = new Point[99];
    private int bullN = 0; // numero di proiettili nello schermo
    private boolean reuse = false;

    void run() throws InterruptedException, IOException {
lifeCounter=3;
        createBufferStrategy(2);

        strategy = getBufferStrategy();

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

        for (i = 98; i > 0; i -= 1) {
            disegna(i, true);
            Thread.sleep(10);
        }

        while (true) {

            for (i = 0; i < 98; i++) {
                disegna(i, false);
                Thread.sleep(59);
            }

            for (i = 98; i > 0; i--) {
                disegna(i, false);
                Thread.sleep(59);
            }
        }
    }

    public void disegna(int n, boolean scritte) throws IOException {

        Graphics2D g = (Graphics2D) strategy.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, w, h);

        
        Color stelleColor = new Color(222, 222, 222);
        g.setColor(stelleColor);
        for (int i = 0; i < 111; i++) {
            g.drawLine(stelle1[i].x, stelle1[i].y, stelle1[i].x, stelle1[i].y);
            g.drawLine(stelle2[i].x, stelle2[i].y, stelle2[i].x, stelle2[i].y);
        }

        int rgb;
        if (n > 50) {
            rgb = (n % 50) * 5;
        } else {
            rgb = (((n - 1) % 50) - 50) * -5;
        }

        stelleColor = new Color(rgb, rgb, rgb);
        g.setColor(stelleColor);
        for (int i = 111; i < 222; i++) {
            g.drawLine(stelle1[i].x, stelle1[i].y, stelle1[i].x, stelle1[i].y);
        }

        if (n < 50) {
            rgb = (n % 50) * 5;
        } else {
            rgb = (((n + 1) % 50) - 50) * -5;
        }

        stelleColor = new Color(rgb, rgb, rgb);
        g.setColor(stelleColor);
        for (int i = 111; i < 222; i++) {
            g.drawLine(stelle2[i].x, stelle2[i].y, stelle2[i].x, stelle2[i].y);
        }

        int j;
        if (scritte) {
            j = i;
        } else {
            j = 0;
        }
      
        g.setColor(Color.blue);
        
            
             g.setFont(new Font("Arial", Font.PLAIN, 40 + j));
        g.drawString("Space Invaders", 100 + j, 100 + j);
        g.setFont(new Font("Arial", Font.PLAIN, 10 + j));
        g.drawString("          by Moresi Fabio", 110 + j + j, 110 + j + j);
          
        
        
       g.setFont(new Font("Arial", Font.PLAIN, 40));
        g.drawString("Life = "+lifeCounter, 600 , 100 );
        
        H += 1;
        if (H > 390) {
         
          H=0;
           
            lifeCounter = lifeCounter-1;
             System.out.println("Le tue vite sono "+ lifeCounter);
        }
        if (lifeCounter == 0){
            g.clearRect(0, 0, 800, 1000);
            
             g.setFont(new Font("Arial", Font.PLAIN, 80));
        g.drawString("GAME OVER", 150 , 250 );
        
        
        }
        if (lifeCounter <= 0){
            
          lifeCounter=0;
        
        
        }
        
        for (int k = 0; k < 400; k += 40) {
            g.drawImage(alien, n * 4 + k, H, 50, 50, null);
        }
        

        if (leftPressed) {
            Sx = Sx - 10;
        }
        if (rightPressed) {
            Sx = Sx + 10;
        }
        if (Sx > 750) {
            Sx = 750;
        }
        if (Sx < 0) {
            Sx = 0;
        }
        
        g.drawImage(ship, Sx, 420, 80, 70, null);
        int bng;
        bng =0;
        for (int bn = 0; bn < bullN; bn++) {
            int updatedY = bullets[bn].y - 10;
            
            bullets[bn].y = updatedY;
        
        if(updatedY == H){
        
        int exp;
        exp =0;
        exp++;
        exp++;
       if(exp==2){
            alien = ImageIO.read(new File("Immagini/exp1.png"));
        exp++;
             
        }
        if(exp==3){
            alien = ImageIO.read(new File("Immagini/exp2.png"));
        exp++;
        }    
       
        if(exp==4){
            alien = ImageIO.read(new File("Immagini/exp3.png"));
        exp++;
        }  
        
    if(exp==5){
            alien = ImageIO.read(new File("Immagini/exp4.png"));
        exp++;
             
        }
if(exp==6){
            alien = ImageIO.read(new File("Immagini/exp5.png"));
        exp++;
             
        }
if(exp==7){
            alien = ImageIO.read(new File("Immagini/exp6.png"));
        exp++;
             
        }
        }}
        for (int bn = 0; bn < bullN; bn++) {
            int updatedY = bullets[bn].y - 10;
            g.drawLine(bullets[bn].x, bullets[bn].y, bullets[bn].x, updatedY);
            bullets[bn].y = updatedY;
        }
        if (firePressed) {
            System.out.println(bullN + " : " + Sx);
            if (reuse == false) {
                bullets[bullN] = new Point();
            }
            bullets[bullN].x = Sx + 25;
            bullets[bullN].y = 421; 
            bullN++;
            if (bullN >= 99) {
                bullN = 0;
                reuse = true;
            }
            firePressed = false;
        }
        

        g.dispose();

        strategy.show();
    }

    public int getH() {
        return H;
    }

}
