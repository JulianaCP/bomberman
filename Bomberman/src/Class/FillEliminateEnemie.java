/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.applet.AudioClip;

/**
 *
 * @author Juliana
 */
public class FillEliminateEnemie extends Thread{

    public FillEliminateEnemie() {
    }
    
    public void run(){
       
        
        AudioClip sonido;
       sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Sound/DieEnemie.mid"));
       sonido.play(); 

    }     
    
}
