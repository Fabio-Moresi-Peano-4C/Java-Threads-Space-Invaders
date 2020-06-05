/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space_invaders;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 *
 * @author FabioMoresi
 */
public class KeyInputHandler extends KeyAdapter{
    private int pressCount = 1;

    
    public boolean waitingForKeyPress = true;
   
        public void keyPressed(KeyEvent e) {
            final int keyCode = e.getKeyCode();
                    
            switch(keyCode){
            
              case KeyEvent.VK_LEFT: {

System.out.println ( "è stato premuta la freccia sinistra!");
Space.leftPressed = true;
break;
}
              case KeyEvent.VK_RIGHT: {

System.out.println ( "è stato premuta la freccia destra!");
 Space.rightPressed = true;
break;

}
    case KeyEvent.VK_SPACE:{
              System.out.println("FIRE");
              Space.firePressed = true;
              break;}
}
}
            
            
            
            
            
            
               

        
        public void keyReleased(KeyEvent e) {
            final int keyCode = e.getKeyCode();
                switch(keyCode){
            
              case KeyEvent.VK_LEFT: {

System.out.println ( "è stato rilasciata la freccia sinistra!");
Space.leftPressed = false;
break;
}
              case KeyEvent.VK_RIGHT: {

System.out.println ( "è stato rilasciata la freccia destra!");
 Space.rightPressed = false;
break;

}
    case KeyEvent.VK_SPACE:{
              System.out.println("FIRE");
              Space.firePressed = false;
              break;}
}
              
        }

        
        public void keyTyped(KeyEvent e) {
               
                if (waitingForKeyPress) {
                        if (pressCount == 1) {
                                
                                waitingForKeyPress = false;
                               
                                pressCount = 0;
                        } else {
                                pressCount++;
                        }
                }

               
                if (e.getKeyChar() == 27) {
                        System.exit(0);
                }
        }
}
