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
public class HiddenObject extends ElementOfTheGame{
    private boolean useObject;

    public HiddenObject(boolean useObject, int positionX, int positionY, boolean haveFire) {
        super(positionX, positionY, haveFire);
        this.useObject = useObject;
    }

    public boolean isUseObject() {
        return useObject;
    }

    public void setUseObject(boolean useObject) {
        this.useObject = useObject;
    }


}


    
    

