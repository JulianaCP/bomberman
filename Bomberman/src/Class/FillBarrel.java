/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Class;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Johanna
 */
public class FillBarrel extends Thread{
    int positionHeroX= 0;
    int positionHeroY= 0;
    int positionBarrelX= 0;
    int positionBarrelY= 0;
    
    
    int rigthY = positionBarrelY +1;
    int leftY= positionBarrelY -1;
    int downX= positionBarrelX +1;
    int upX= positionBarrelX -1;
    
   public FillBarrel(){
       
   }
    
   @Override
   public void run(){
       System.out.println("EEEEEEEEEEEtro a barrera creacionnnnnnn2222222");
         
        try {
            FillBarrel.sleep(5000);
            moveBarrel(); 
            
            } catch (InterruptedException ex) {
                Logger.getLogger(FillBarrel.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
     
   
        public void moveBarrel(){
 
        System.out.println("en proceso barrel");
        
        
        int totalRow = Global.getAmountMatrix();
        int totalColumn = Global.getAmountMatrix();
        ElementOfTheGame [][]matrix = Global.getMatrix();
        
        for(int row = 0 ; row < totalRow ; row++ ){
            for(int column = 0 ; column < totalColumn ; column++ ){
                boolean sePuede=true;
                
                
                if(matrix[row][column] instanceof Barrel){
                
                    ElementOfTheGame ele = matrix[row][column];
                    Barrel barrel = (Barrel)ele;
                    if(barrel.isSeMovio()== false){
                        sePuede = true;
                    }
                    
                    if(sePuede == false){
                        continue;
                    }
                    barrel.setSeMovio(true);
                    
                    verificateBarrelAndHeroPosition();
                    
                                            
                try {
                FillBarrel.sleep(5000);
                llamar();
                moveBarrel(); 
                

                } catch (InterruptedException ex) {
                    Logger.getLogger(FillBarrel.class.getName()).log(Level.SEVERE, null, ex);
                }
             
                }
            }
        }       
        
    }
   
 
        
   
   
   public void verificateBarrelAndHeroPosition(){
    
       
       int totalRow = Global.getAmountMatrix();
       int totalColumn = Global.getAmountMatrix();
       ElementOfTheGame [][]matrix = Global.getMatrix();
        
       //para verificar donde está el barril
       for(int row = 0 ; row < totalRow ; row++ ){
            for(int column = 0 ; column < totalColumn ; column++ ){
                boolean sePuede=true;
                if(matrix[row][column] instanceof Barrel){
                
                    ElementOfTheGame ele = matrix[row][column];
                    Barrel barrel = (Barrel)ele;
                    
                        System.out.println("posicion barril");
                        
                        positionBarrelX= row;
                        positionBarrelY= column;
                        
                        System.out.println(positionBarrelX);
                        System.out.println(positionBarrelY);
                        System.out.println("..........................");

                        //para verificar donde esta el heroe y mandarlo a la funcion
                        for(int row2= 0; row2<totalRow ; row2++){
                            for(int column2= 0; column2 < totalColumn; column2++){
                                if(matrix[row2][column2] instanceof Hero){
                                    positionHeroX= row2;
                                    positionHeroY= column2;
                                     System.out.println("POAICION DE HEROE");
                                     System.out.println(positionHeroX);
                                     System.out.println(positionHeroY);
                                     System.out.println("..........................");
                                                                     
                                     
                                    //comparaciones para saber cual metodo aplicar
                                    if((positionBarrelY > positionHeroY && positionBarrelX > positionHeroX) ||
                                            (positionBarrelY > positionHeroY && positionBarrelX == positionHeroX)){
                                        System.out.println("heroe arriba a la izquierda o derecha abaja o ");
                                        heroIsUpLeft();
                                    }

                                    else if((positionBarrelY < positionHeroY && positionBarrelX > positionHeroX ) ||
                                            (positionBarrelY == positionHeroY && positionBarrelX >positionHeroX)){
                                        System.out.println("POAICION DE HEROE444");
                                        heroIsUpRigth();
                                    }

                                    else if((positionBarrelY > positionHeroY && positionBarrelX < positionHeroX)||
                                            (positionBarrelY == positionHeroY && positionBarrelX < positionHeroX)){
                                        System.out.println("POAICION DE HEROE5555");
                                        heroIsDownLeft();
                                        
                                    }
                                    else if((positionBarrelY < positionHeroY && positionBarrelX < positionHeroX) || 
                                            (positionBarrelY < positionHeroY && positionBarrelX == positionHeroX)){
                                        
                                        System.out.println("POAICION DE HEROE66666");
                                        heroIsDownRigth();
                                    }
                                }   
                            }   
                        }                          
                }  
            }
       }    
   }
   
   

   
   
   
   //////////////////////UP LEFT///////////////////////////////////////////////
   public void heroIsUpLeft(){
  
       

       Random random = new Random();
       int ramdomNumber;  
       
       //barril a la derecha de oponente ahora
       if(positionBarrelY > positionHeroY && positionBarrelX == positionHeroX){
           ramdomNumber = (int)(random.nextDouble() * Constant.AMOUNT_MOVEMENT_DETERMINATE);
           if(ramdomNumber == Constant.NUM_REPRESENTATION_OF_RIGHT){
              veificateUp(positionBarrelX, positionBarrelY);    
          }   
          else{
              veificateLeft(positionBarrelX, positionBarrelY);
          }
       }
       
       else{
           
          ramdomNumber = (int)(random.nextDouble() * Constant.AMOUNT_MOVEMENT_TWO);
          System.out.println("random: " + ramdomNumber);
          if(ramdomNumber == Constant.NUM_REPRESENTATION_OF_RIGHT){
              veificateUp(positionBarrelX, positionBarrelY);
          }
          else{
              veificateLeft(positionBarrelX, positionBarrelY);
          }
       }

          
       }

   
   
   
   
      public void heroIsDownRigth(){
       System.out.println("entro verificacion 2");
       
       Random random = new Random();
       int ramdomNumber;  
       
       //barri a la izquierda
       if(positionBarrelY < positionHeroY && positionBarrelX == positionHeroX){
           ramdomNumber = (int)(random.nextDouble() * Constant.AMOUNT_MOVEMENT_DETERMINATE);
           if(ramdomNumber == Constant.NUM_REPRESENTATION_OF_RIGHT){
              verificateDown(positionBarrelX, positionBarrelY);    
          }
          else{
              verificateRigth(positionBarrelX, positionBarrelY);
          }
       }
       
       else{
           
          ramdomNumber = (int)(random.nextDouble() * Constant.AMOUNT_MOVEMENT_TWO);
  
            System.out.println("random: " + ramdomNumber);
            
            if(ramdomNumber == Constant.NUM_REPRESENTATION_OF_RIGHT){
                verificateDown(positionBarrelX, positionBarrelY);
            }
            else{
                verificateRigth(positionBarrelX, positionBarrelY);
            }
       }
       

       }


   
   
   
   
   ///////////////////////UP RIGTH//////////////////////////////////////////////////////////
   public void heroIsUpRigth(){
       
       System.out.println("entro verificacion 3");

       Random random = new Random();
       int ramdomNumber;  
       
       //el barril esta debajo del oponente en este momento
       if(positionBarrelY == positionHeroY && positionBarrelX >positionHeroX){
           ramdomNumber = (int)(random.nextDouble() * Constant.AMOUNT_MOVEMENT_DETERMINATE);
           if(ramdomNumber == Constant.NUM_REPRESENTATION_OF_RIGHT){
              verificateRigth(positionBarrelX, positionBarrelY);    
          }
          else{
              veificateUp(positionBarrelX, positionBarrelY);
          }
       }
       
       else{
           
          ramdomNumber = (int)(random.nextDouble() * Constant.AMOUNT_MOVEMENT_TWO);
          System.out.println("random: " + ramdomNumber);
          if(ramdomNumber == Constant.NUM_REPRESENTATION_OF_RIGHT){
              veificateUp(positionBarrelX, positionBarrelY);
          }
          else{
              verificateRigth(positionBarrelX, positionBarrelY);
          }
       }
       }
           

    
   
   
   
   
      public void heroIsDownLeft(){
       
       System.out.println("entro verificacion 4");

       
       Random random = new Random();
       int ramdomNumber;  
       
       //barril se encuentra arriba de heroe en este momento
       if(positionBarrelY == positionHeroY && positionBarrelX < positionHeroX){
           
           ramdomNumber = (int)(random.nextDouble() * Constant.AMOUNT_MOVEMENT_DETERMINATE);
           if(ramdomNumber == Constant.NUM_REPRESENTATION_OF_RIGHT){
              veificateLeft(positionBarrelX, positionBarrelY);    
          }
          else{
              verificateDown(positionBarrelX, positionBarrelY);
          }
       }
       
       else{
           
          ramdomNumber = (int)(random.nextDouble() * Constant.AMOUNT_MOVEMENT_TWO);
          System.out.println("random: " + ramdomNumber);
          if(ramdomNumber == Constant.NUM_REPRESENTATION_OF_RIGHT){
              verificateDown(positionBarrelX, positionBarrelY);
          }
          else{
              veificateLeft(positionBarrelX, positionBarrelY);
          }
       }
           
   }
   
   
   
   
   
    public void chancePosition(int positionRow, int positionColumn, int newPositionRow, int newPositionColumn ){
        
        System.out.println("REALIZO MOVIMIENTO EL BARRIL JAJAJAJAJJAAJJAJAAJAJAJAJJ");
        
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
                    matrix[row][column] = new Barrel(Constant.DEFAULT_STATE_OF_THE_BARREL, row, column,Constant.STATE_WITHOUT_FIRE);
                    System.out.println("Posicion actual barril");
                    System.out.println(row);
                    System.out.println(column);
                    System.out.println("_____________________________");
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
                       System.out.println("right tomo el barril");
                       chancePosition(PositionRow,PositionColumn, verificateNewPositionRow,verificateNewPositionColumn);
                   }
                   else if(matrix[row][column] instanceof Hero){
                       Global.setDeadHero(true);
                       FillRefresh fillRefresh = new FillRefresh();
                       fillRefresh.start();
                   }  
                   else{
                       veificateUp( PositionRow, PositionColumn);
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
                       System.out.println("up tomo el barril");
                       chancePosition(positionRow,positionColumn, verificateNewPositionRow,verificateNewPositionColumn);
                   }
                   else if(matrix[row][column] instanceof Hero){
                       Global.setDeadHero(true);
                       FillRefresh fillRefresh = new FillRefresh();
                       fillRefresh.start();
                   }  
                   else{
                       veificateLeft( positionRow, positionColumn);
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
                       System.out.println("left tomo el barril");
                       chancePosition(positionRow,positionColumn, verificateNewPositionRow,verificateNewPositionColumn);
                   }
                   else if(matrix[row][column] instanceof Hero){
                       Global.setDeadHero(true);
                       FillRefresh fillRefresh = new FillRefresh();
                       fillRefresh.start();
                   }  
                   else{
                       verificateDown(positionRow, positionColumn);
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
                       System.out.println("Down tomo el barril");
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
    
    

