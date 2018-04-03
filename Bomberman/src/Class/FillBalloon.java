/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import Window.GameWindow;
import java.util.Random;
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
public class FillBalloon extends Thread {

    public FillBalloon() {
    
    }
    
    
    
    
    
    @Override
    public void run(){
        System.out.println("QQQQQQQQQQQQQQQQQQQQq  Entra al fill balloon");
         
        try {
            FillBalloon.sleep(1000);
            moveBalloonFill(); 
            
        } catch (InterruptedException ex) {
            Logger.getLogger(FillBalloon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    
    
        public void moveBalloonFill(){
   // solo prueba
        System.out.println("realizo un movimiento oooooooooooooooooooooo");
        
        
        int totalRow = Global.getAmountMatrix();
        int totalColumn = Global.getAmountMatrix();
        ElementOfTheGame [][]matrix = Global.getMatrix();
        
        int cont = 0;
        for(int row = 0 ; row < totalRow ; row++ ){
            for(int column = 0 ; column < totalColumn ; column++ ){
                if(matrix[row][column] instanceof Balloon){
                
                    
                    System.out.println("\n\n\row: " + row + "Column:  "+ column);
                 //   ElementOfTheGame elementOfTheGame = matrix[row][column];
                   // Balloon balloon = (Balloon)elementOfTheGame; 
                   // balloon.
                    
                    cont++;
                     int v = obtainNextMoveBalloon(row, column);
                      continue;
                     /*
                     
                     System.out.println("v" + v +"  \n\nEntraaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n\n");     
                           
                     Global.setNextMovementBalloon(5); 
                     
                     
                     
          
                           
                            
                       */     
                   
                     
                     
                }
            }
        } 
        
        
         try {
                        FillBalloon.sleep(111);
                     

                    } catch (InterruptedException ex) {
                        Logger.getLogger(FillBalloon.class.getName()).log(Level.SEVERE, null, ex);
                    }

                 //   GameWindow w = new GameWindow();
                 // w.setVisible(true);
                    llamar();////////////////////////////////////   borrar

                                System.out.println("\n\nEntraaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n\n");     
                            try {
                        FillBalloon.sleep(4000);
                       

                    } catch (InterruptedException ex) {
                        Logger.getLogger(FillBalloon.class.getName()).log(Level.SEVERE, null, ex);
                    }
        
                            System.out.println("777777777777777777777777777777777777777777777777777777777777777777777777777777777777777");
        
        if(cont==0){
            FillBalloon.interrupted();
            return;
        }                    
        moveBalloonFill();
        
    }
    
    
      public int obtainNextMoveBalloon(int row, int column){
        
        Random random = new Random();
        int ramdomNumber;
        
        
        
        ramdomNumber = (int)(random.nextDouble() * Constant.AMOUNT_MOVEMENT);
        
        
        
        System.out.println("random: " + ramdomNumber);
        
        if(ramdomNumber == Constant.NUM_REPRESENTATION_OF_RIGHT){
            System.out.println("derecha \n");
            Global.setNextMovementBalloon(ramdomNumber); 
            verificateRigth(row,column);
        }
        
        if(ramdomNumber == Constant.NUM_REPRESENTATION_OF_UP){
            System.out.println("arriba\n");
            Global.setNextMovementBalloon(ramdomNumber); 
            veificateUp(row,column);
        }
        
        if(ramdomNumber == Constant.NUM_REPRESENTATION_OF_LEFT){
            System.out.println("izquierda \n");
            Global.setNextMovementBalloon(ramdomNumber); 
            veificateLeft(row,column);
        }
        
        if(ramdomNumber == Constant.NUM_REPRESENTATION_OF_DOWN){
            System.out.println("abajo \n");
            Global.setNextMovementBalloon(ramdomNumber); 
            verificateDown(row,column);
        }
        return 0;
        
        
    }
    
    public void chancePosition(int positionRow, int positionColumn, int newPositionRow, int newPositionColumn ){
        

        
        int totalRow = Global.getAmountMatrix();
        int totalColumn = Global.getAmountMatrix();
        ElementOfTheGame [][]matrix = Global.getMatrix();
        
        for(int row = 0 ; row < totalRow ; row++ ){
            for(int column = 0 ; column < totalColumn ; column++ ){
                if(row == positionRow && column == positionColumn){
                    matrix[row][column] = null;
                    matrix[row][column] = new EmptySpace(row,column,Constant.STATE_WITHOUT_FIRE);
                }
                else if(row == newPositionRow && column == newPositionColumn){
                    matrix[row][column] = null;
                    matrix[row][column] = new Balloon(Constant.DEFAULT_STATE_OF_THE_BALLOON, row, column,Constant.STATE_WITHOUT_FIRE);
                }
                

     
            }
        }

         
    }    
    
    
    public void verificateRigth(int PositionRow, int PositionColumn){
        int totalRow = Global.getAmountMatrix();
        int totalColumn = Global.getAmountMatrix();
        ElementOfTheGame [][]matrix = Global.getMatrix();      
        
        int verificateNewPositionRow = PositionRow;
        int verificateNewPositionColumn = PositionColumn +1;
        
        
        for(int row = 0 ; row < totalRow ; row++ ){
            for(int column = 0 ; column < totalColumn ; column++ ){
               if(verificateNewPositionRow == row && verificateNewPositionColumn == column){
                   if(matrix[row][column] instanceof EmptySpace){
                       chancePosition(PositionRow,PositionColumn, verificateNewPositionRow,verificateNewPositionColumn);
                   }
                   else if(matrix[row][column] instanceof Hero){
                       Global.setDeadHero(true);
                       FillRefresh fillRefresh = new FillRefresh();
                       fillRefresh.start();
                   }                   
                   
                }
            }
        }
    }        
        

    

    public void veificateUp(int positionRow, int positionColumn){
 
        int totalRow = Global.getAmountMatrix();
        int totalColumn = Global.getAmountMatrix();
        ElementOfTheGame [][]matrix = Global.getMatrix();       
        
        int verificateNewPositionRow = positionRow - 1;
        int verificateNewPositionColumn = positionColumn;
        
        
        for(int row = 0 ; row < totalRow ; row++ ){
            for(int column = 0 ; column < totalColumn ; column++ ){
               if(verificateNewPositionRow == row && verificateNewPositionColumn == column){
                   if(matrix[row][column] instanceof EmptySpace){
                       chancePosition(positionRow,positionColumn, verificateNewPositionRow,verificateNewPositionColumn);
                   }
                    else if(matrix[row][column] instanceof Hero){
                       Global.setDeadHero(true);
                       FillRefresh fillRefresh = new FillRefresh();
                       fillRefresh.start();
                   }  
                   
                }
            }
        }        
        
    }
    
    public void veificateLeft(int positionRow, int positionColumn){

        int totalRow = Global.getAmountMatrix();
        int totalColumn = Global.getAmountMatrix();
        ElementOfTheGame [][]matrix = Global.getMatrix();       
        
        int verificateNewPositionRow = positionRow;
        int verificateNewPositionColumn = positionColumn - 1 ;
        
        
        for(int row = 0 ; row < totalRow ; row++ ){
            for(int column = 0 ; column < totalColumn ; column++ ){
               if(verificateNewPositionRow == row && verificateNewPositionColumn == column){
                   if(matrix[row][column] instanceof EmptySpace){
                       chancePosition(positionRow,positionColumn, verificateNewPositionRow,verificateNewPositionColumn);
                   }
                   else if(matrix[row][column] instanceof Hero){
                       Global.setDeadHero(true);
                       FillRefresh fillRefresh = new FillRefresh();
                       fillRefresh.start();
                   }  
                   
                }
            }
        }         
    }    

    public void verificateDown(int positionRow, int positionColumn){
    // no esta listo    
        int totalRow = Global.getAmountMatrix();
        int totalColumn = Global.getAmountMatrix();
        ElementOfTheGame [][]matrix = Global.getMatrix();       
        
        int verificateNewPositionRow = positionRow + 1;
        int verificateNewPositionColumn = positionColumn;
        
        
        for(int row = 0 ; row < totalRow ; row++ ){
            for(int column = 0 ; column < totalColumn ; column++ ){
               if(verificateNewPositionRow == row && verificateNewPositionColumn == column){
                   if(matrix[row][column] instanceof EmptySpace){
                       chancePosition(positionRow,positionColumn, verificateNewPositionRow,verificateNewPositionColumn);
                   }
                    else if(matrix[row][column] instanceof Hero){
                       Global.setDeadHero(true);
                       FillRefresh fillRefresh = new FillRefresh();
                       fillRefresh.start();
                   }  
                   
                }
            }
        } 
        
    }    
    int cont = 0;
    public void llamar(){
      
        JFrame window = Global.getReturnJFrame();
                             
                     
       window.getContentPane().removeAll();
       window.invalidate();
       window.validate();
       window.repaint();
       SwingUtilities.updateComponentTreeUI(window);

       refresh();    

                    
    }
    public void refresh(){
       
        JFrame window = Global.getReturnJFrame();
                        
        System.out.println("RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
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
                       System.out.println("B1");
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

    }    
}
