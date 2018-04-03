/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author Juliana
 */
public class Barrel extends ElementOfTheGame implements Movement{
    
    private boolean destroyed;
    private boolean seMovio = false;

    public Barrel(boolean destroyed, int positionX, int positionY, boolean haveFire) {
        super(positionX, positionY, haveFire);
        this.destroyed = destroyed;
    }


    public boolean isSeMovio() {
        return seMovio;
    }

    public void setSeMovio(boolean seMovio) {
        this.seMovio = seMovio;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }
    
   @Override
   public void moveObject(int row, int column){
       
       FillBarrel fillBarrel = new FillBarrel();
       fillBarrel.start();
       
   }
    
}
