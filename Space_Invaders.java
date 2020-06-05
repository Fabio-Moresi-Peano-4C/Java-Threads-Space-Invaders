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

import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.imageio.ImageIO;
/**
 *
 * @author FabioMoresi
 */
public class Space_Invaders extends JFrame {

    public Space_Invaders() throws InterruptedException, IOException {
        super("Space Invaders Moresi");
        KeyInputHandler k1 = new KeyInputHandler();
         this.setResizable(false);
         
        setIgnoreRepaint(true);
        
         this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
         
        Intro intro = new Intro();
       this.addKeyListener(k1);
        this.add(intro);
        
        this.pack();
        
        this.setVisible(true);
        this.add(intro);
        intro.run();
       
       
    }

    public static void main(String[] args) throws InterruptedException, IOException {

        new Space_Invaders();
    }

}
