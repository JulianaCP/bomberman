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
public class FillBomb extends Thread {

    public FillBomb() {
        
    }   
    
    
    
    public void run(){
        System.out.println("\n\n\nFill Bombaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n\n\n");
         
    
        try {
            llamar();
            Thread.sleep(3000);
         //   FillBalloon.sleep(3000);
           // FillBarrel.sleep(3500);
            ExploteBomb();
            System.out.println("EXPLOTAAAAAAAAA  EXPLOTAAAAAAAA  EXPLOTAAAAAAAAA  EXPLOTAAAAAAAA   EXPLOTAAAAAAAAA  EXPLOTAAAAAAAA EXPLOTAAAAAAAAA  EXPLOTAAAAAAAA   ");
            llamar();
            Thread.sleep(2500);
            //FillBalloon.sleep(2000);
          //  FillBarrel.sleep(2500);
            actualizeMatrixEliminateObjectWithFire();
            

            
            llamar();
            FillBalloon.sleep(200);
            FillBarrel.sleep(250);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(FillBalloon.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(FillBarrel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void actualizeMatrixEliminateObjectWithFire(){
        
        int totalRow = Global.getAmountMatrix();
        int totalColumn = Global.getAmountMatrix();
        ElementOfTheGame [][]matrix = Global.getMatrix(); 
        
        
        for(int row = 0 ; row < totalRow ; row++ ){
            for(int column = 0 ; column < totalColumn ; column++ ){
                ElementOfTheGame elementEliminateWithFire = matrix[row][column];
                boolean haveFire = elementEliminateWithFire.getHaveFire();
                
                if(matrix[row][column] instanceof Hero){
                    if(haveFire == true){
                        elementEliminateWithFire.setHaveFire(false);
                        Global.setDeadHero(true);
                        Global.setPutBomb(false);                        
                    }
                }
                if(matrix[row][column] instanceof Bomb){
                    if(haveFire == true){
                        elementEliminateWithFire.setHaveFire(false);
                        matrix[row][column] = null;
                        matrix[row][column] = new EmptySpace(row,column,Constant.STATE_WITHOUT_FIRE);                        
                    }

                }
                else if(haveFire == true){
                    if(elementEliminateWithFire instanceof EmptySpace){
                        elementEliminateWithFire.setHaveFire(false);
                    }
                    else if(elementEliminateWithFire instanceof Balloon){
                        //
                        FillEliminateEnemie fillEliminateEnemie = new FillEliminateEnemie();
                        fillEliminateEnemie.start();
                        //
                        elementEliminateWithFire.setHaveFire(false);
                        matrix[row][column] = null;
                        matrix[row][column] = new EmptySpace(row,column,Constant.STATE_WITHOUT_FIRE);                       
                    }
                    else if(elementEliminateWithFire instanceof Barrel){
                        //
                        FillEliminateEnemie fillEliminateEnemie = new FillEliminateEnemie();
                        fillEliminateEnemie.start();
                        //                        
                        elementEliminateWithFire.setHaveFire(false);
                        matrix[row][column] = null;
                        matrix[row][column] = new EmptySpace(row,column,Constant.STATE_WITHOUT_FIRE);                           
                    }
                    else if(elementEliminateWithFire instanceof Block){
                        elementEliminateWithFire.setHaveFire(false);
                        Block block = (Block)elementEliminateWithFire; 
                        
                        if(block.getHiddenObject() ==  null){
                            matrix[row][column] = null;
                            matrix[row][column] = new EmptySpace(row,column,Constant.STATE_WITHOUT_FIRE);                            
                        }
                        else if(block.getHiddenObject() instanceof Power){
                            matrix[row][column] = null;
                            matrix[row][column] = new Power(Constant.STATE_WITHOUT_FIRE, row, column, Constant.DEFAULT_STATE_OF_HIDDEN_OBJECT_WITHOUT_USE);
                        }
                        else if(block.getHiddenObject() instanceof Door){
                            matrix[row][column] = null;
                            matrix[row][column] = new Door(Constant.STATE_WITHOUT_FIRE, row, column, Constant.DEFAULT_STATE_OF_HIDDEN_OBJECT_WITHOUT_USE);
                        }                        
                    }
                    
                    else if(elementEliminateWithFire instanceof Power){
                        elementEliminateWithFire.setHaveFire(false);                          
                    }                    
                    else if(elementEliminateWithFire instanceof Door){
                        elementEliminateWithFire.setHaveFire(false);                          
                    }                     
                }
                
            }
        }         
        
    }
    
    
    
    
   public void ExploteBomb(){
       verificateHeroBomb();
       obtainPositionOfTheBombToExplote();
       putAnalysedThrBomb();
        
        ///////////////////////
       FillExplotion fillExplotion = new FillExplotion();
       fillExplotion.start();
       
       ////////////////////////
       putFireInRangeOfBomb();
      

   }
   public void lookCharacterWithBomb(){
        int totalRow = Global.getAmountMatrix();
        int totalColumn = Global.getAmountMatrix();
        ElementOfTheGame [][]matrix = Global.getMatrix(); 
        
       System.out.println("sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss"); 
        for(int row = 0 ; row < totalRow ; row++ ){
            for(int column = 0 ; column < totalColumn ; column++ ){
                if(matrix[row][column] instanceof Hero){
                    Global.setPositionRowOfTheBomb(row);
                    Global.setPositionColumnOfTheBomb(column);
                    putFireInRangeOfBomb();
                    putFireInRangeOfBombWithoutHero();
                    actualizeMatrixEliminateObjectWithFire();
                    try {
                        FillBomb.sleep(200);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(FillBomb.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            }
        }        
   }
   
   
   public void putFireInRangeOfBombWithoutHero(){
  JFrame window = Global.getReturnJFrame();
                             
                     
       window.getContentPane().removeAll();
       window.invalidate();
       window.validate();
       window.repaint();
       SwingUtilities.updateComponentTreeUI(window);
       

        window = Global.getReturnJFrame();
                        
        System.out.println("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
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
                      continue;
                    
                  }                  
                 
                  else if(matrix[row][column] instanceof Balloon){
                        
                       JLabel label = new JLabel(); 
                       label.setIcon(new ImageIcon(getClass().getResource("/Window/Barrel.jpg")));
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
                        
                      continue;                      
                  } 
                  
            }
           
        } 
       ////////////////
        FillExplotion fillExplotion = new FillExplotion();
       fillExplotion.start();
        //////////////////
       
       window.repaint();
        
        
        
        
        System.out.println("salio de bomba");
            
    }
    
   
   
   
   public void putAnalysedThrBomb(){
       int positionRow = Global.getPositionRowOfTheBomb();
       int positionColumn = Global.getPositionColumnOfTheBomb();
 
   
   
   
        int totalRow = Global.getAmountMatrix();
        int totalColumn = Global.getAmountMatrix();
        ElementOfTheGame [][]matrix = Global.getMatrix(); 
        
        
        for(int row = 0 ; row < totalRow ; row++ ){
            for(int column = 0 ; column < totalColumn ; column++ ){
                if(row == positionRow && column == positionColumn){
                    if(matrix[row][column] instanceof Bomb){
                        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                        ElementOfTheGame elementBombPutAnalised = matrix[row][column];
                        Bomb wasAnalisedBomb = (Bomb)elementBombPutAnalised;
                        wasAnalisedBomb.setTheBombWasAnalyzed(true);
                        return;                        
                    }
                    

                }
                
            }
        }    
        lookCharacterWithBomb();
   }
   
   public void verificateHeroBomb(){
       if(Global.getPutBomb() == true){
           Global.setDeadHero(true);
           System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
           lookCharacterWithBomb();
           llamar();
           
           try {
               FillBalloon.sleep(9000);
               FillBarrel.sleep(9000);
           } catch (InterruptedException ex) {
               Logger.getLogger(FillBomb.class.getName()).log(Level.SEVERE, null, ex);
               Logger.getLogger(FillBarrel.class.getName()).log(Level.SEVERE, null, ex);
               Logger.getLogger(FillBalloon.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       
   }
   
   public void obtainPositionOfTheBombToExplote(){
 
        int totalRow = Global.getAmountMatrix();
        int totalColumn = Global.getAmountMatrix();
        ElementOfTheGame [][]matrix = Global.getMatrix(); 
        
        int numberOfTheBombSmaller = 55;
        
        
        for(int row = 0 ; row < totalRow ; row++ ){
            for(int column = 0 ; column < totalColumn ; column++ ){
                if(matrix[row][column] instanceof Bomb){
                    ElementOfTheGame elementObtainSmallerBomb = matrix[row][column];
                    Bomb bombSmallerNumber = (Bomb)elementObtainSmallerBomb;
                    int numberInBomb = bombSmallerNumber.getBombNumber();
                    boolean wasAnalysis = bombSmallerNumber.getTheBombWasAnalyzed();
                    if(wasAnalysis == false){
                        if(numberInBomb < numberOfTheBombSmaller){
                            System.out.println("analizar bomba: numer in bomb "+ numberInBomb);
                            System.out.println("analizar bomba: numberOfTheBombSmaller "+ numberOfTheBombSmaller);
                            numberOfTheBombSmaller = numberInBomb;
                            
                            Global.setPositionRowOfTheBomb(row);
                            Global.setPositionColumnOfTheBomb(column);
                                                     
                        }
                       
                    }
                }
                
            }
        }
        
   }
   public void putFireInRangeOfBomb(){
      
       Global.setHaveBlockBarrierUp(false);
       Global.setHaveBlockBarrierRight(false);
       Global.setHaveBlockBarrierLeft(false);
       Global.setHaveBlockBarrierDown(false);
       
       int positionRowUp = Global.getPositionRowOfTheBomb();
       int positionColumnUp = Global.getPositionColumnOfTheBomb();
       
       int positionRowRight = Global.getPositionRowOfTheBomb();
       int positionColumnRight = Global.getPositionColumnOfTheBomb();
       
       int positionRowLeft = Global.getPositionRowOfTheBomb();
       int positionColumnLeft = Global.getPositionColumnOfTheBomb();
       
       int positionRowDown = Global.getPositionRowOfTheBomb();
       int positionColumnDown = Global.getPositionColumnOfTheBomb();       
       
       System.out.println("arriba  row  "+positionRowUp + "   column  " + positionColumnUp + "\n\n");
        putFire(positionRowUp,positionColumnUp);
       
       boolean barrier;
               
       int stop = Global.getLevelOfTheBomb();
       for(int i =0 ; i<stop; i++){

         
           
           if(Global.isHaveBlockBarrierUp() == false){
                int fireUpRow = positionRowUp -1;
                int fireUpColumn = positionColumnUp;
                positionRowUp = fireUpRow;
                positionColumnUp = fireUpColumn;
                barrier = putFire(fireUpRow,fireUpColumn);               
                if(barrier == true){
                    Global.setHaveBlockBarrierUp(true);
                }
                
           
           }

            
            if(Global.isHaveBlockBarrierRight() == false){
                int fireRightRow = positionRowRight;
                int fireRightColumn = positionColumnRight + 1;
                positionRowRight = fireRightRow;
                positionColumnRight = fireRightColumn;
                barrier = putFire(fireRightRow,fireRightColumn);
                if(barrier == true){
                    Global.setHaveBlockBarrierRight(true);
                }                
            }

            
            if(Global.isHaveBlockBarrierLeft() == false){
                int fireLeftRow = positionRowLeft;
                int fireLeftColumn = positionColumnLeft - 1;
                positionRowLeft = fireLeftRow;
                positionColumnLeft = fireLeftColumn;
                barrier = putFire(fireLeftRow,fireLeftColumn);                
                if(barrier == true){
                    Global.setHaveBlockBarrierLeft(true);
                }
            }

            if(Global.isHaveBlockBarrierDown() == false){
                int fireDownRow = positionRowDown + 1;
                int fireDownColumn = positionColumnDown;
                positionRowDown = fireDownRow;
                positionColumnDown = fireDownColumn;

                barrier = putFire(fireDownRow,fireDownColumn);
                if(barrier == true){
                    Global.setHaveBlockBarrierDown(true);
                }                
            }

       }
           
   }
   
   public boolean putFire(int firePositionRow, int firePositionColumn){

        int totalRow = Global.getAmountMatrix();
        int totalColumn = Global.getAmountMatrix();
        ElementOfTheGame [][]matrix = Global.getMatrix(); 
        
        
        for(int row = 0 ; row < totalRow ; row++ ){
            for(int column = 0 ; column < totalColumn ; column++ ){
               System.out.println("\n\nciclo  "+row + "   column  " + column + "llego row " +firePositionRow+ "llego column  "+firePositionColumn+"\n\n");
                if(firePositionRow == row && firePositionColumn == column){
       
                    System.out.println("\n\nciclo en if row  "+row + "   column  " + column + "llego row " +firePositionRow+ "llego column  "+firePositionColumn+ "\n\n");
                    if( matrix[row][column] instanceof BarrierBlock){
                        
                        return true;
                    }
                    if(matrix[row][column] instanceof Bomb){
                        
                        System.out.println("entro en put fire bomb");
                    ElementOfTheGame element = matrix[row][column];
                    element.setHaveFire(true);  
                    continue;
                    }
                    
                    System.out.println("fire bomb");
                    ElementOfTheGame element = matrix[row][column];
                    element.setHaveFire(true);
                    return false;
                }
                
            }
        }
        return false;
   }

    
    
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
                          Timer cronometro= new Timer(Global.getTime());
                          cronometro.OffTimer();
                          System.out.println("****               TIMEEEEEEEEEEEEEEE:           ******"+Global.getTime()); 
                            
                                
                  GameOverWindow gameOverWindow = new GameOverWindow();
                  gameOverWindow.setVisible(true);
                  Global.setDeadHero(false); 
                  window.dispose();
        
        }        
        
        
        System.out.println("salio de bomba");
            
    }
    
    
    
}
