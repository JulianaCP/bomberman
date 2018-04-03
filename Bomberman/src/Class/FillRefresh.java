/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import Window.GameOverWindow;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Juliana
 */
public class FillRefresh extends Thread{
   
    public FillRefresh() {
        

       
        
    }   
    
    
    
    public void run(){
        refresh();
        endGame();

    } 
    
    
 
    public void refresh(){
       
                JFrame window = Global.getReturnJFrame();
                             
                     
       window.getContentPane().removeAll();
       window.invalidate();
       window.validate();
       window.repaint();
       SwingUtilities.updateComponentTreeUI(window);
        
        int totalRow = Global.getAmountMatrix();
        int totalColumn = Global.getAmountMatrix();
        ElementOfTheGame [][]matrix = Global.getMatrix(); 
        
        for(int row = 0 ; row < totalRow ; row++ ){
            for(int column = 0 ; column < totalColumn ; column++ ){
                
                int x = row * 30;
                int y = column * 30;
                
                ElementOfTheGame elementMatrix =matrix[row][column];
                boolean haveExplotion = elementMatrix.getHaveFire();
                if(haveExplotion == true){
                    
                    if(matrix[row][column] instanceof BarrierBlock){
                        continue;
                    }
                    
                       JLabel label = new JLabel(); 
                       label.setIcon(new ImageIcon(getClass().getResource("/Window/fireImage.png")));
                       label.setBounds(y,x,30,30);
                       window.add(label);  
                       continue;
                    
                }
                

                if (matrix[row][column] instanceof BarrierBlock){

                       JLabel label = new JLabel(); 
                       label.setIcon(new ImageIcon(getClass().getResource("/Window/BarrierBlockImage.jpg")));
                       label.setBounds(y,x,30,30);
                       window.add(label); 
                       
          
                  }
                  else if(matrix[row][column] instanceof Block){
                        System.out.println("C");
                       JLabel label = new JLabel(); 
                       label.setIcon(new ImageIcon(getClass().getResource("/Window/BlockImage.jpg")));
                       label.setBounds(y,x,30,30);
                       window.add(label); 
                       FillBalloon.interrupted();
                  }
                  else if(matrix[row][column] instanceof EmptySpace){
                        continue;
                  }                  
                  else if(matrix[row][column] instanceof Bomb){
                       JLabel label = new JLabel(); 
                       label.setIcon(new ImageIcon(getClass().getResource("/Window/bombImage.jpg")));
                       label.setBounds(y,x,30,30);
                       window.add(label);
                  }  
                  else if(matrix[row][column] instanceof Hero){
                      boolean deadCharacter = Global.getDeadHero();
                      
                      if(deadCharacter == true){
                           JLabel label = new JLabel(); 
                            label.setIcon(new ImageIcon(getClass().getResource("/Window/heroDead.png")));
                            label.setBounds(y,x,30,30);
                            window.add(label);   

                                               
                      }
                      
                      boolean pushA = Global.getPushA();
                      if(pushA == true){
                        ElementOfTheGame element = matrix[row][column];

                        Hero hero = (Hero)element;
                        int amount = hero.getAmountBombs();
                        amount++;
                        hero.setAmountBombs(amount);

                        Global.setPutBomb(true);

                         JLabel label = new JLabel(); 
                         label.setIcon(new ImageIcon(getClass().getResource("/Window/heroPruebaConBomba.jpg")));
                         label.setBounds(y,x,30,30);
                         window.add(label);
                         Global.setPushA(false);
                      }
                       JLabel label = new JLabel(); 
                       label.setIcon(new ImageIcon(getClass().getResource("/Window/heroPrueba.jpg")));
                       label.setBounds(y,x,30,30);
                       window.add(label);   
                    
                  }                  
                 
                  else if(matrix[row][column] instanceof Balloon){
                        
                       JLabel label = new JLabel(); 
                       label.setIcon(new ImageIcon(getClass().getResource("/Window/baloon.jpg")));
                       label.setBounds(y,x,30,30);
                       window.add(label);                      
                  }
                  else if(matrix[row][column] instanceof Power){
                        
                       JLabel label = new JLabel(); 
                       label.setIcon(new ImageIcon(getClass().getResource("/Window/PowerImage.jpg")));
                       label.setBounds(y,x,30,30);
                       window.add(label);                      
                  }                  
                  else if(matrix[row][column] instanceof Door){
                        
                       JLabel label = new JLabel(); 
                       label.setIcon(new ImageIcon(getClass().getResource("/Window/doorImage.jpg")));
                       label.setBounds(y,x,30,30);
                       window.add(label);                      
                  }                   
                  
                  
                  else if(matrix[row][column] instanceof Barrel){
                        
                       JLabel label = new JLabel(); 
                       label.setIcon(new ImageIcon(getClass().getResource("/Window/Barrel.jpg")));
                       label.setBounds(y,x,30,30);
                       window.add(label);                      
                  } 
                  
            }
           
        } 
         
        window.repaint();
        
       
        
        
        System.out.println("salio de bomba");
            
    }
    
    
    public void endGame(){
        
        JFrame window = Global.getReturnJFrame();
        boolean wasDeadHero2 = Global.getDeadHero();
       
         if(wasDeadHero2 == true && Global.isGameFinalice() ==false){
             Global.setGameFinalice(true);
              try {
                  FillLoseGame fillLoseGame = new FillLoseGame();
                  fillLoseGame.start();
                  FillBomb.sleep(4000);


              } catch (InterruptedException ex) {
                  Logger.getLogger(FillBomb.class.getName()).log(Level.SEVERE, null, ex);
              } 
             
                                
                  GameOverWindow gameOverWindow = new GameOverWindow();
                  gameOverWindow.setVisible(true);
                  Global.setDeadHero(false); 
                  window.dispose();
        
        }         
    }
}
