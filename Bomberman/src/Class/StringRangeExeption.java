/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Class;

import java.awt.Label;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Johanna
 */

public class StringRangeExeption extends Exception{
    
     public StringRangeExeption(JFrame window) {
        super("The name is out of range.\nRange: 10."); 
        JOptionPane.showMessageDialog(window,"The name is out of range.\nRange: 10." );
               
        
    }
    
    
   public StringRangeExeption(String msg) {
        super(msg);
    }
    
    
}
