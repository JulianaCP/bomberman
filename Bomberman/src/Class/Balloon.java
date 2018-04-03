/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.util.Random;

/**
 *
 * @author Juliana
 */
public class Balloon extends ElementOfTheGame implements Movement{

    private boolean destroyed;

    public Balloon(boolean destroyed, int positionX, int positionY, boolean haveFire) {
        super(positionX, positionY, haveFire);
        this.destroyed = destroyed;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }
    
    @Override
    public void moveObject(int row, int column){
        
        
       FillBalloon fillBalloon = new FillBalloon();
       fillBalloon.start();
       
    }
    
  
    
}
