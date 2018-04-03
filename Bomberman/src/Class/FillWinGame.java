/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import Window.Prueba;
import Window.ReviewWindow;
import com.sun.webkit.ThemeClient;
import java.applet.AudioClip;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Juliana
 */
public class FillWinGame extends Thread{

    public FillWinGame() {
    }
    
    public void run(){
        
        winMusic();
        try {
            FillWinGame.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(FillWinGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        endGame();

    }    
    
    public void winMusic(){
       
        AudioClip sonido;
       sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Sound/winMusic.wav"));
       sonido.play();        
    }
    public void endGame(){
        JFrame window = Global.getReturnJFrame();

        ReviewWindow prueba = new ReviewWindow();
        prueba.setVisible(true);
        window.dispose();        
    }
}
