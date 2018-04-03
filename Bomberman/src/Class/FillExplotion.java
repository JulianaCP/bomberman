/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.applet.AudioClip;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juliana
 */
public class FillExplotion extends Thread{

    public FillExplotion() {
    }
 
    
    public void run(){
        AudioClip sonido;
       sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Sound/Explosion.mid"));
       sonido.play(); 

    }      
}
