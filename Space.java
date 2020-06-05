/*
 * /*
 * ****************************
 * *    2020(c)Project by    *
 * *                          *
 * *       Moresi Fabio       *
 * *          4C Inf          *
 * *                          *
 * ****************************
 * */
package space_invaders;


import com.golden.gamedev.object.AnimatedSprite;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 *
 * @author FabioMoresi
 */
public class Space extends Canvas {
    public final int w = 800;
    public final int h = 600;

    public BufferedImage  alien,ship;
    
    public int H = 0;
    public static boolean firePressed = false;
    public static boolean leftPressed = false;
    public static boolean rightPressed = false;
    public int Sx = 0; 
    
    public Space() {
        //In questa classe creiamo lo sfondo per il nostro gioco

        System.out.println("Imposto lo sfondo ,attendi");

        setBackground(Color.BLACK);

        setSize(800, 500);
        
        ImageCanvas();
        
        addKeyListener(new KeyInputHandler());
        
        requestFocus();
    }
public void ImageCanvas() {
   
        try {
             ship = ImageIO.read(new File("Immagini/ship.png"));
          
alien = ImageIO.read(new File("Immagini/alien.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
     
}
