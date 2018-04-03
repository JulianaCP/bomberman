/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Class;

/**
 *
 * @author Johanna
 */
public class Block extends ElementOfTheGame {
    private HiddenObject hiddenObject;
    private boolean destroyed;

    public Block(boolean destroyed, int positionX, int positionY, boolean haveFire) {
        super(positionX, positionY, haveFire);
        this.destroyed = destroyed;
    }

    public HiddenObject getHiddenObject() {
        return hiddenObject;
    }

    public void setHiddenObject(HiddenObject hiddenObject) {
        this.hiddenObject = hiddenObject;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }
    
    
    
}
