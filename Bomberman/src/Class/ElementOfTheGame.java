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
public class ElementOfTheGame {
    
    
    private int positionX;
    private int positionY;
    private boolean haveFire;

    public ElementOfTheGame(int positionX, int positionY, boolean haveFire) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.haveFire = haveFire;
    }
    
    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public boolean getHaveFire() {
        return haveFire;
    }

    public void setHaveFire(boolean haveFire) {
        this.haveFire = haveFire;
    }


      
}
