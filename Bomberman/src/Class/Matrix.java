/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.util.Random;
/**
 *
 * @author Juliana
 */
public class Matrix {
    ElementOfTheGame [][]matrix;

    public Matrix() {
    }
    
    public void createMatrix(int amountRow, int amountColumn){
        matrix = new ElementOfTheGame[amountRow][amountColumn];
        System.out.println("obtuvo espacio en matrix");
        fillMatrix();
        
    }
    
    
    public void fillMatrix(){
        System.out.println("1");
        fillMatrixEmpty();
        System.out.println("2");
        fillBarrierBlockOutside();
        System.out.println("3");
        fillBarrierBlockInside();
        fillMatrixHero();
        fillMatrixBlock();
        fillMatrixBalloon();
        fillMatrixBarrel();
        fillMatrixPowerInBlock();
        fillMatrixDoorInBlock();
      
        Global.setMatrix(matrix);
        
    }
    
    
    public void fillMatrixEmpty(){
      
        int totalRow = Global.getAmountMatrix();
        int totalColumn = Global.getAmountMatrix();
        
        System.out.println("total row "+ totalRow + "  total Column  "+ totalColumn);
        
        for(int row = 0 ; row < totalRow ; row++ ){
            System.out.println("puso espacio vacio");
            for(int column = 0 ; column < totalColumn ; column++ ){
                matrix[row][column] = new EmptySpace(row, column, Constant.STATE_WITHOUT_FIRE);
            }
        }
    }
    
    
    public void fillBarrierBlockOutside(){
      
        int totalRow = Global.getAmountMatrix();
        int totalColumn = Global.getAmountMatrix();
        
        for(int row = 0 ; row < totalRow ; row++ ){
            for(int column = 0 ; column < totalColumn ; column++ ){
                System.out.println("fila: "+ row + "  Columna: "+column+"\n");
                if(matrix[row][column] instanceof EmptySpace){
                    if(row == 0){
                        matrix[row][column] = new BarrierBlock(row,column, Constant.STATE_WITHOUT_FIRE);
                       System.out.println("fila: "+ row + "  Columna: "+ column+ "   Creo clase  "+"\n");
                        continue;
                    }
                    else if(row == totalRow-1){
                        matrix[row][column] = new BarrierBlock(row,column, Constant.STATE_WITHOUT_FIRE); 
                        System.out.println("fila: "+ row + "  Columna: "+ column+ "   Creo clase  "+"\n");
                        continue;
                    }
                    else if(column == 0){
                        matrix[row][column] = new BarrierBlock(row,column, Constant.STATE_WITHOUT_FIRE); 
                        //System.out.println("fila: "+ row + "  Columna: "+ column+ "   Creo clase  "+"\n");
                        continue;                   
                   }
                    else if(column == totalColumn-1){
                        //System.out.println("fila: "+ row + "  Columna: "+ column+ "   Creo clase  "+"\n");
                        matrix[row][column] = new BarrierBlock(row,column, Constant.STATE_WITHOUT_FIRE); 
                        continue;              
                    }                
                }
            }
        }
        
      ////////////////////////////////////// pruebas barrier outside
        for(int row = 0 ; row < totalRow ; row++ ){
            for(int column = 0 ; column < totalColumn ; column++ ){
                System.out.print("( " );
                  if (matrix[row][column] instanceof BarrierBlock)
                        System.out.print("bloque" + " )" + "  ");
                  else
                      System.out.print("       )  ");
                  
                  if(column == totalColumn-1){
                      System.out.print("\n\n");
                  }
            }
        }
        
        System.out.println("\n\n\n\nPRUEBAS DE BARRERA EXTREMOS");
        
        
        ////////////////////////////////////// pruebas outside     
             
    }
    
    
    
    public void fillBarrierBlockInside(){
       System.out.println("\n\n\n\nPRUEBAS DE BARRERA EXTREMOS"); 
       
       
        int totalRow = Global.getAmountMatrix();
        int totalColumn = Global.getAmountMatrix();
       
       int contInsideBlockColum = 2;
       int contInsideBlockRow = 2;
       boolean aggregate = false;

       
       for(int row = 0; row<totalRow ; row++){
          
           if(aggregate == true){
               contInsideBlockRow = contInsideBlockRow+2;
               aggregate = false;
               
           }
           for(int column =0; column<totalColumn; column++){              
                if(column == totalColumn-1){
                    contInsideBlockColum = 2;
                    continue;
                }                   
               if(matrix[row][column] instanceof EmptySpace){        
                     if(column == contInsideBlockColum  && row == contInsideBlockRow){
                        aggregate = true;      
                        matrix[row][column] = new BarrierBlock(row, column, Constant.STATE_WITHOUT_FIRE);
                        contInsideBlockColum = contInsideBlockColum +2;
                    }
                }
           }
       }   
       
       ////////////////////////////////////// pruebas barrier Inside
        System.out.println("\n\n\n");
        
        for(int row = 0 ; row < totalRow ; row++ ){
            for(int column = 0 ; column < totalColumn ; column++ ){
                System.out.print("( " );
                  if (matrix[row][column] instanceof BarrierBlock)
                        System.out.print("bloque" + " )" + "  ");
                  else
                      System.out.print("       )  ");
                  
                  if(column == totalColumn-1){
                      System.out.print("\n\n");
                  }
            }
        }
                
        System.out.println("\n\n\n\nPRUEBAS DE BARRERA Internos");
        ////////////////////////////////////// pruebas  barrier Inside
    }
    
    public void fillMatrixHero(){
        int totalRow = Global.getAmountMatrix();
        int totalColumn = Global.getAmountMatrix();
       
        for(int row = 0 ; row < totalRow ; row++ ){
            for(int column = 0 ; column < totalColumn ; column++ ){
               if(matrix[row][column] instanceof EmptySpace ){
                   if(row == 1 && column == 1){
                       matrix[row][column] = new Hero(Constant.DEFAULT_INITIAL_AMOUNT_OF_BOMB_IN_USE_THAT_HAVE_THE_HERO, row, column, Constant.STATE_WITHOUT_FIRE);
                       Global.setAmountBombHero(Constant.DEFAULT_INITIAL_AMOUNT_OF_BOMB_IN_USE_THAT_HAVE_THE_HERO);
                       break; 
                   }
               }
            }
        }
        
        
        
              ////////////////////////////////////// pruebas hero
        for(int row = 0 ; row < totalRow ; row++ ){
            for(int column = 0 ; column < totalColumn ; column++ ){
                System.out.print("( " );
                  if (matrix[row][column] instanceof BarrierBlock)
                        System.out.print("bloque" + " )" + "  ");
                  else if(matrix[row][column] instanceof Hero){
                      System.out.print(" Hero " + " )" + "  ");
                  }
                  else
                      System.out.print("       )  ");
                  
                  if(column == totalColumn-1){
                      System.out.print("\n\n");
                  }
            }
        }
        
        System.out.println("\n\n\n\nPRUEBAS DE BARRERA EXTREMOS");
        
        
        ////////////////////////////////////// pruebas  hero
    }
    
    public void fillMatrixBlock(){
        
        
        System.out.println("\n\n\n\n\n\n\n\n\npppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppp\n\n\n\n");
        Random random = new Random();
        int ramdomNumberRow;
        int ramdomNumberColumn;
        
        int totalRow = Global.getAmountMatrix();
        int totalColumn = Global.getAmountMatrix();
        boolean busyPlace = false;
        boolean placed = false;
        
        int totalBlock = Global.getAmountBlock();
        int contBlockPlacedInMatrix = 0;
        while(contBlockPlacedInMatrix != totalBlock){
            ramdomNumberRow = (int)(random.nextDouble() * totalRow);
            ramdomNumberColumn = (int)(random.nextDouble() * totalRow);
            for(int row = 0 ; row < totalRow ; row++ ){
                if(busyPlace == true){
                    busyPlace = false;
                    break;
                }
                else if(placed == true){
                   placed = false;
                   break;
                }                
                for(int column = 0 ; column < totalColumn ; column++ ){
                    if(row == ramdomNumberRow && column == ramdomNumberColumn){
                        if(matrix[row][column] instanceof EmptySpace){
                            matrix[row][column] = new Block(Constant.DEFAULT_STATE_OF_THE_BLOCK, row, column, Constant.STATE_WITHOUT_FIRE);
                            contBlockPlacedInMatrix++;
                            placed = true;
                            break;
                        }
                        else{
                            busyPlace = true;
                            break;
                        }
                    }
                }
            } 
                   
            
        }
        
      
              ////////////////////////////////////// pruebas block
          int cont = 0;
        for(int row = 0 ; row < totalRow ; row++ ){
            for(int column = 0 ; column < totalColumn ; column++ ){
                System.out.print("( " );
                  if (matrix[row][column] instanceof BarrierBlock)
                        System.out.print("barrier" + " )" + "  ");
                  else if(matrix[row][column] instanceof Hero){
                      System.out.print(" Hero  " + " )" + "  ");
                  }
                  else if(matrix[row][column] instanceof Block){
                      System.out.print(" Block " + " )" + "  ");  
                      cont++;
                  }
                  else
                      System.out.print("        )  ");
                  
                  if(column == totalColumn-1){
                      System.out.print("\n\n");
                  }
            }
        }
        System.out.println("cantidad block: " + cont);
        System.out.println("\n\n\n\nPRUEBAS DE block");
        
        
        ////////////////////////////////////// pruebas  block                
    }
    
    
    public void fillMatrixBalloon(){
   
        Random random = new Random();
            int ramdomNumberRow;
            int ramdomNumberColumn;

            int totalRow = Global.getAmountMatrix();
            int totalColumn = Global.getAmountMatrix();
            boolean busyPlace = false;
            boolean placed = false;

           int contAmountBalloonIntroducedInMatrix = 0;
           int totalBallonIntroduced = Global.getAmountBalloon();

            while(contAmountBalloonIntroducedInMatrix != totalBallonIntroduced){
                ramdomNumberRow = (int)(random.nextDouble() * totalRow);
                ramdomNumberColumn = (int)(random.nextDouble() * totalRow);
                
                for(int row = 0 ; row < totalRow ; row++ ){
                    if(busyPlace == true){
                        busyPlace = false;
                        break;
                    }
                    else if(placed == true){
                       placed = false;
                       break;
                    }                
                    for(int column = 0 ; column < totalColumn ; column++ ){
                        if(row == ramdomNumberRow && column == ramdomNumberColumn){
                            if(matrix[row][column] instanceof EmptySpace){
                                matrix[row][column] = new Balloon(Constant.DEFAULT_STATE_OF_THE_BALLOON, row, column, Constant.STATE_WITHOUT_FIRE);
                                contAmountBalloonIntroducedInMatrix++;
                                placed = true;
                                break;
                            }
                            else{
                                busyPlace = true;
                                break;
                            }
                        }
                    }
                }         


            }
            
        ////////////////////////////////////// pruebas  balloon 
            
        int cont = 0;
        for(int row = 0 ; row < totalRow ; row++ ){
            for(int column = 0 ; column < totalColumn ; column++ ){
                System.out.print("( " );
                  if (matrix[row][column] instanceof BarrierBlock)
                        System.out.print("barrier" + " )" + "  ");
                  else if(matrix[row][column] instanceof Hero){
                      System.out.print(" Hero  " + " )" + "  ");
                  }
                  else if(matrix[row][column] instanceof Block){
                      System.out.print(" Block " + " )" + "  ");  
                  }
                  else if(matrix[row][column] instanceof Balloon){
                      System.out.print("Balloon" + " )" + "  ");  
                      cont++;
                  }      
                  else
                      System.out.print("        )  ");
                  
                  if(column == totalColumn-1){
                      System.out.print("\n\n");
                  }
            }
        }
        System.out.println("cantidad balloon: " + cont);
        System.out.println("\n\n\n\nPRUEBAS DE balloon\n\n");
        
        
        ////////////////////////////////////// pruebas  balloon             
            

        }
    
    public void fillMatrixBarrel(){
 
       Random random = new Random();
       int ramdomNumberRow;
       int ramdomNumberColumn;

        int totalRow = Global.getAmountMatrix();
        int totalColumn = Global.getAmountMatrix();
       boolean busyPlace = false;
       boolean placed = false;

       int contAmountBarrelIntroducedInMatrix = 0;
       int totalBarrelIntroduced = Global.getAmountBarrel();

       while(contAmountBarrelIntroducedInMatrix != totalBarrelIntroduced){
            ramdomNumberRow = (int)(random.nextDouble() * totalRow);
            ramdomNumberColumn = (int)(random.nextDouble() * totalRow);

            for(int row = 0 ; row < totalRow ; row++ ){
                if(busyPlace == true){
                    busyPlace = false;
                    break;
                }
                else if(placed == true){
                   placed = false;
                   break;
                }                
                for(int column = 0 ; column < totalColumn ; column++ ){
                    if(row == ramdomNumberRow && column == ramdomNumberColumn){
                        if(matrix[row][column] instanceof EmptySpace){
                            matrix[row][column] = new Barrel(Constant.DEFAULT_STATE_OF_THE_BARREL, row, column, Constant.STATE_WITHOUT_FIRE);
                            contAmountBarrelIntroducedInMatrix++;
                            placed = true;
                            break;
                        }
                        else{
                            busyPlace = true;
                            break;
                        }
                    }
                }
            }         


        }

    ////////////////////////////////////// pruebas  Barrel 

    int cont = 0;
    for(int row = 0 ; row < totalRow ; row++ ){
        for(int column = 0 ; column < totalColumn ; column++ ){
            System.out.print("( " );
              if (matrix[row][column] instanceof BarrierBlock)
                    System.out.print("barrier" + " )" + "  ");
              else if(matrix[row][column] instanceof Hero){
                  System.out.print(" Hero  " + " )" + "  ");
              }
              else if(matrix[row][column] instanceof Block){
                  System.out.print(" Block " + " )" + "  ");  
              }
              else if(matrix[row][column] instanceof Balloon){
                  System.out.print("Balloon" + " )" + "  ");  
                 
              }      
              else if(matrix[row][column] instanceof Barrel){
                  System.out.print("Barrel " + " )" + "  ");  
                  cont++;
              }  
              else
                  System.out.print("        )  ");

              if(column == totalColumn-1){
                  System.out.print("\n\n");
              }
        }
    }
    System.out.println("cantidad Barrel: " + cont);
    System.out.println("\n\n\n\nPRUEBAS DE Barrel\n\n");


    ////////////////////////////////////// pruebas  Barrel      
        
    }
    
    public void fillMatrixPowerInBlock(){
        
       Random random = new Random();
       int ramdomNumberRow;
       int ramdomNumberColumn;

        int totalRow = Global.getAmountMatrix();
        int totalColumn = Global.getAmountMatrix();
       boolean busyPlace = false;
       boolean placed = false;

       int contAmountPowerIntroducedInMatrix = 0;
       int totalPowerToIntroduced = Global.getAmountPower();

       while(contAmountPowerIntroducedInMatrix != totalPowerToIntroduced){
            ramdomNumberRow = (int)(random.nextDouble() * totalRow);
            ramdomNumberColumn = (int)(random.nextDouble() * totalRow);

            for(int row = 0 ; row < totalRow ; row++ ){
                if(busyPlace == true){
                    busyPlace = false;
                    break;
                }
                else if(placed == true){
                   placed = false;
                   break;
                }                
                for(int column = 0 ; column < totalColumn ; column++ ){
                    if(row == ramdomNumberRow && column == ramdomNumberColumn){
                        if(matrix[row][column] instanceof Block){
                            ElementOfTheGame elementOfTheGame = matrix[row][column];
                            Block block = (Block)elementOfTheGame; 
                       
                            if(block.getHiddenObject() ==  null){
                                Power power = new Power(Constant.STATE_OF_THE_POWER_IS_ACTIVATE, row,column,Constant.DEFAULT_STATE_OF_HIDDEN_OBJECT_WITHOUT_USE);
                                block.setHiddenObject(power);
                             
                                contAmountPowerIntroducedInMatrix++;
                                placed = true;
                                break;        
                            }

                        }
                        else{
                            busyPlace = true;
                            break;
                        }
                    }
                }
            }         


        }

    ////////////////////////////////////// pruebas  Objetos  Ocultos 

    int cont = 0;
    int contPower =0;
    for(int row = 0 ; row < totalRow ; row++ ){
        for(int column = 0 ; column < totalColumn ; column++ ){
            System.out.print("( " );
             if(matrix[row][column] instanceof Block){
                 cont++;
                  ElementOfTheGame elementOfTheGame = matrix[row][column];
                  Block block = (Block)elementOfTheGame;
                  if(block.getHiddenObject() ==  null){
                      System.out.print(" vacio " + " )" + "  "); 
                  }
                  else if(block.getHiddenObject() instanceof Power){
                     System.out.print(" Power " + " )" + "  ");  
                     contPower++;
                  } 
              }
 
              else
                  System.out.print("        )  ");

              if(column == totalColumn-1){
                  System.out.print("\n\n");
              }
        }
    }
    System.out.println("cantidad Power: " + contPower);
       System.out.println("cantidad block: " + cont);
    System.out.println("\n\n\n\nPRUEBAS DE Objetos Ocultos\n\n");


    ////////////////////////////////////// pruebas Objetos  Ocultos   
        
    }
    
    
    public void fillMatrixDoorInBlock(){
       Random random = new Random();
       int ramdomNumberRow;
       int ramdomNumberColumn;

        int totalRow = Global.getAmountMatrix();
        int totalColumn = Global.getAmountMatrix();
       boolean busyPlace = false;
       boolean placed = false;

       int contAmountDoorIntroducedInMatrix = 0;
       int totalDoorToIntroduced = Constant.AMOUNT_OF_DOOR_IN_THE_GAME;

       while(contAmountDoorIntroducedInMatrix != totalDoorToIntroduced){
            ramdomNumberRow = (int)(random.nextDouble() * totalRow);
            ramdomNumberColumn = (int)(random.nextDouble() * totalRow);

            for(int row = 0 ; row < totalRow ; row++ ){
                if(busyPlace == true){
                    busyPlace = false;
                    break;
                }
                else if(placed == true){
                   placed = false;
                   break;
                }                
                for(int column = 0 ; column < totalColumn ; column++ ){
                    if(row == ramdomNumberRow && column == ramdomNumberColumn){
                        if(matrix[row][column] instanceof Block){
                            ElementOfTheGame elementOfTheGame = matrix[row][column];
                            Block block = (Block)elementOfTheGame; 
                       
                            if(block.getHiddenObject() ==  null){
                                Door door = new Door(Constant.DEFAULT_STATE_OF_THE_DOOR,row,column,Constant.DEFAULT_STATE_OF_HIDDEN_OBJECT_WITHOUT_USE);
                                block.setHiddenObject(door);
                             
                                contAmountDoorIntroducedInMatrix++;
                                placed = true;
                                break;        
                            }

                        }
                        else{
                            busyPlace = true;
                            break;
                        }
                    }
                }
            }         


        }
       
       
       

    ////////////////////////////////////// pruebas  Objetos  Ocultos 

    int cont = 0;
    int contPower =0;
    int contDoor = 0;
    for(int row = 0 ; row < totalRow ; row++ ){
        for(int column = 0 ; column < totalColumn ; column++ ){
            System.out.print("( " );
             if(matrix[row][column] instanceof Block){
                 cont++;
                  ElementOfTheGame elementOfTheGame = matrix[row][column];
                  Block block = (Block)elementOfTheGame;
                  if(block.getHiddenObject() ==  null){
                      System.out.print(" vacio " + " )" + "  "); 
                  }
                  else if(block.getHiddenObject() instanceof Power){
                     System.out.print(" Power " + " )" + "  ");  
                     contPower++;
                  } 
                  else if(block.getHiddenObject() instanceof Door){
                     System.out.print(" Door  " + " )" + "  ");  
                     contDoor++;
                  }  
             }
 
              else
                  System.out.print("        )  ");

              if(column == totalColumn-1){
                  System.out.print("\n\n");
              }
        }
    }
    System.out.println("cantidad Power: " + contPower);
       System.out.println("cantidad block: " + cont);
       System.out.println("cantidad door: " + contDoor);
    System.out.println("\n\n\n\nPRUEBAS DE Objetos Ocultos\n\n");


    ////////////////////////////////////// pruebas Objetos  Ocultos 
    
    }
        
    
    
}
