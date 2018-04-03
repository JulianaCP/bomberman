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
public class Bomb extends ElementOfTheGame{
    
    private int expanseExplosion;
    
    private boolean TheBombWasAnalyzed;
    private int bombNumber;

    public Bomb(int expanseExplosion, boolean TheBombWasAnalyzed, int bombNumber, int positionX, int positionY, boolean haveFire) {
        super(positionX, positionY, haveFire);
        this.expanseExplosion = expanseExplosion;
        this.TheBombWasAnalyzed = TheBombWasAnalyzed;
        this.bombNumber = bombNumber;
    }

    public int getBombNumber() {
        return bombNumber;
    }

    public void setBombNumber(int bombNumber) {
        this.bombNumber = bombNumber;
    }



    public boolean getTheBombWasAnalyzed() {
        return TheBombWasAnalyzed;
    }

    public void setTheBombWasAnalyzed(boolean TheBombWasAnalyzed) {
        this.TheBombWasAnalyzed = TheBombWasAnalyzed;
    }


    public int getExpanseExplosion() {
        return expanseExplosion;
    }

    public void setExpanseExplosion(int expanseExplosion) {
        this.expanseExplosion = expanseExplosion;
    }
    
    
}
