/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import Window.Prueba;
import javax.swing.JFrame;

/**
 *
 * @author Juliana
 */
public class Hero extends ElementOfTheGame {
    
    private int amountBombs;

    public Hero(int amountBombs, int positionX, int positionY, boolean haveFire) {
        super(positionX, positionY, haveFire);
        this.amountBombs = amountBombs;
    }



    public int getAmountBombs() {
        return amountBombs;
    }

    public void setAmountBombs(int amountBombs) {
        this.amountBombs = amountBombs;
    }
    
    public void moveHero(int positionRow, int positionColumn, String action){
        
        
        if(action.equalsIgnoreCase("arriba")){
            
            verificateUpHero(positionRow, positionColumn);
        }
        
        else if(action.equalsIgnoreCase("derecha")){
            
            verificateRigthHero(positionRow, positionColumn);
        }
        else if(action.equalsIgnoreCase("izquierda")){
            
            verificateLeftHero(positionRow, positionColumn);
        }
        
        else if(action.equalsIgnoreCase("abajo")){
            
            verificateDownHero(positionRow, positionColumn);
        }        
    }
    
    public void chancePositionHero(int positionRow, int positionColumn, int newPositionRow, int newPositionColumn){
       
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
                    int amountBombs = Global.getAmountBombHero();
                    matrix[row][column] = null;
                  
                    matrix[row][column] = new Hero(amountBombs, row, column,Constant.STATE_WITHOUT_FIRE);
                }
            }
        }
        
    }
    
    public void verificateUpHero(int positionRow, int positionColumn){
       
        int totalRow = Global.getAmountMatrix();
        int totalColumn = Global.getAmountMatrix();
        ElementOfTheGame [][]matrix = Global.getMatrix();        
        
        int verificateNewPositionRow = positionRow - 1;
        int verificateNewPositionColumn = positionColumn;
        
        
        for(int row = 0 ; row < totalRow ; row++ ){
            for(int column = 0 ; column < totalColumn ; column++ ){
               if(verificateNewPositionRow == row && verificateNewPositionColumn == column){
                   if(matrix[row][column] instanceof EmptySpace){
                      
                       ElementOfTheGame elementVeriricateEmpySpace =matrix[row][column];
    
                       boolean haveFireEmptySpace = elementVeriricateEmpySpace.getHaveFire();
                       if(haveFireEmptySpace == true){
                           
                           Global.setDeadHero(true);
                       }                       
                       chancePositionHero(positionRow,positionColumn, verificateNewPositionRow,verificateNewPositionColumn);
                   }
                   else if(matrix[row][column] instanceof Power){
                        int levelBomb = Global.getLevelOfTheBomb();
                        levelBomb++;
                        Global.setLevelOfTheBomb(levelBomb);

                        chancePositionHero(positionRow,positionColumn, verificateNewPositionRow,verificateNewPositionColumn);
                                     
                   }
                   else if(matrix[row][column] instanceof Door){
                      int amountEnemies = obtainAmountEnemiesInTheMatrix();
                      if(amountEnemies == 0){
                          Global.setWinGame(true);
                          
                          ///
                          Timer cronometro= new Timer(Global.getTime());
                          cronometro.OffTimer();
                          System.out.println("****               TIMEEEEEEEEEEEEEEE:           ******"+Global.getTime()); 
                           
                       
                           FillWinGame fillWinGame = new FillWinGame();
                           fillWinGame.start();
                           
                           //y fill win game
                           ///
                      }
                   }
                   else if(matrix[row][column] instanceof Balloon){
                       Global.setDeadHero(true);
                   }
                   else if(matrix[row][column] instanceof Barrel){
                       Global.setDeadHero(true);
                   }
                   
                }
            }
        }         
        
        
    }
    
    
    public int obtainAmountEnemiesInTheMatrix(){

        int amount =0;
        
        int totalRow = Global.getAmountMatrix();
        int totalColumn = Global.getAmountMatrix();
        ElementOfTheGame [][]matrix = Global.getMatrix();        

        
        for(int row = 0 ; row < totalRow ; row++ ){
            for(int column = 0 ; column < totalColumn ; column++ ){
                if(matrix[row][column] instanceof Balloon){
                    amount++;
                }
                else if(matrix[row][column] instanceof Barrel){
                    amount++;
                }
            }
        } 
        return amount;
        
    }
    
    
    public void verificateRigthHero(int positionRow, int positionColumn){
        
        int totalRow = Global.getAmountMatrix();
        int totalColumn = Global.getAmountMatrix();
        ElementOfTheGame [][]matrix = Global.getMatrix();        
        
        int verificateNewPositionRow = positionRow;
        int verificateNewPositionColumn = positionColumn + 1;
        
        
        for(int row = 0 ; row < totalRow ; row++ ){
            for(int column = 0 ; column < totalColumn ; column++ ){
               if(verificateNewPositionRow == row && verificateNewPositionColumn == column){
                   if(matrix[row][column] instanceof EmptySpace){
                       
                       ElementOfTheGame elementVeriricateEmpySpace =matrix[row][column];
                       boolean haveFireEmptySpace = elementVeriricateEmpySpace.getHaveFire();
                       if(haveFireEmptySpace == true){
                           Global.setDeadHero(true);
                       }
                       
                       chancePositionHero(positionRow,positionColumn, verificateNewPositionRow,verificateNewPositionColumn);
                   }
                   else if(matrix[row][column] instanceof Power){
                        int levelBomb = Global.getLevelOfTheBomb();
                        levelBomb++;
                        Global.setLevelOfTheBomb(levelBomb);

                        chancePositionHero(positionRow,positionColumn, verificateNewPositionRow,verificateNewPositionColumn);
                                     
                   }
                   else if(matrix[row][column] instanceof Door){
                      int amountEnemies = obtainAmountEnemiesInTheMatrix();
                      if(amountEnemies == 0){
                          Global.setWinGame(true);
                          
                          ///
                          Timer cronometro= new Timer(Global.getTime());
                          cronometro.OffTimer();
                          System.out.println("****               TIMEEEEEEEEEEEEEEE:           ******"+Global.getTime()); 
                           
                          
                           FillWinGame fillWinGame = new FillWinGame();
                           fillWinGame.start();
                           
                           //y fill win game
                           ///
                      }                       
                   }
                   else if(matrix[row][column] instanceof Balloon){
                       Global.setDeadHero(true);
                   }
                   else if(matrix[row][column] instanceof Barrel){
                       Global.setDeadHero(true);
                   }
                }
            }
        } 
    }
    
    
    public void verificateLeftHero(int positionRow, int positionColumn){
        
        int totalRow = Global.getAmountMatrix();
        int totalColumn = Global.getAmountMatrix();
        ElementOfTheGame [][]matrix = Global.getMatrix();      
        
        int verificateNewPositionRow = positionRow;
        int verificateNewPositionColumn = positionColumn - 1;
        
        
        for(int row = 0 ; row < totalRow ; row++ ){
            for(int column = 0 ; column < totalColumn ; column++ ){
               if(verificateNewPositionRow == row && verificateNewPositionColumn == column){
                   if(matrix[row][column] instanceof EmptySpace){
                       
                       ElementOfTheGame elementVeriricateEmpySpace =matrix[row][column];
                       boolean haveFireEmptySpace = elementVeriricateEmpySpace.getHaveFire();
                       if(haveFireEmptySpace == true){
                           Global.setDeadHero(true);
                       }
                       chancePositionHero(positionRow,positionColumn, verificateNewPositionRow,verificateNewPositionColumn);
                   }
                   else if(matrix[row][column] instanceof Power){
                        int levelBomb = Global.getLevelOfTheBomb();
                        levelBomb++;
                        Global.setLevelOfTheBomb(levelBomb);

                        chancePositionHero(positionRow,positionColumn, verificateNewPositionRow,verificateNewPositionColumn);
                                     
                   }
                   else if(matrix[row][column] instanceof Door){
                      int amountEnemies = obtainAmountEnemiesInTheMatrix();
                      if(amountEnemies == 0){
                          Global.setWinGame(true);
                          
                          Timer cronometro= new Timer(Global.getTime());
                          cronometro.OffTimer();
                          System.out.println("****               TIMEEEEEEEEEEEEEEE:           ******"+Global.getTime()); 
                           
                            
                           FillWinGame fillWinGame = new FillWinGame();
                           fillWinGame.start();
                           
                           //y fill win game
                           ///
                      }                       
                   } 
                    else if(matrix[row][column] instanceof Balloon){
                       Global.setDeadHero(true);
                   }
                   else if(matrix[row][column] instanceof Barrel){
                       Global.setDeadHero(true);
                   }
                }

            }
        }
 
        
    }
    
    public void verificateDownHero(int positionRow, int positionColumn){
 
        int totalRow = Global.getAmountMatrix();
        int totalColumn = Global.getAmountMatrix();
        ElementOfTheGame [][]matrix = Global.getMatrix();        
        
        int verificateNewPositionRow = positionRow + 1;
        int verificateNewPositionColumn = positionColumn;
        
        
        for(int row = 0 ; row < totalRow ; row++ ){
            for(int column = 0 ; column < totalColumn ; column++ ){
               if(verificateNewPositionRow == row && verificateNewPositionColumn == column){
                   if(matrix[row][column] instanceof EmptySpace){
                       
                       ElementOfTheGame elementVeriricateEmpySpace =matrix[row][column];
                       boolean haveFireEmptySpace = elementVeriricateEmpySpace.getHaveFire();
                       if(haveFireEmptySpace == true){
                           Global.setDeadHero(true);
                       }                       
                       chancePositionHero(positionRow,positionColumn, verificateNewPositionRow,verificateNewPositionColumn);
                   }
                   else if(matrix[row][column] instanceof Power){
                        int levelBomb = Global.getLevelOfTheBomb();
                        levelBomb++;
                        Global.setLevelOfTheBomb(levelBomb);

                        chancePositionHero(positionRow,positionColumn, verificateNewPositionRow,verificateNewPositionColumn);
                                     
                   }
                   else if(matrix[row][column] instanceof Door){
                      int amountEnemies = obtainAmountEnemiesInTheMatrix();
                      if(amountEnemies == 0){
                          Global.setWinGame(true);
                          
                          ///
                          Timer cronometro= new Timer(Global.getTime());
                          cronometro.OffTimer();
                          System.out.println("****               TIMEEEEEEEEEEEEEEE:           ******"+Global.getTime()); 
                           
                          
                           FillWinGame fillWinGame = new FillWinGame();
                           fillWinGame.start();
                           
                           //y fill win game
                           ///
                      }                       
                   }
                   else if(matrix[row][column] instanceof Balloon){
                       Global.setDeadHero(true);
                   }
                   else if(matrix[row][column] instanceof Barrel){
                       Global.setDeadHero(true);
                   }
                       
                }
            }
        }        
        
    }
    
    
}
