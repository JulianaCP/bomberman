/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author Juliana
 */
public class Global {
    
    public static Global instance;
    
    private Global(){
        
    }
    public static Global getGlobal(){
        if(instance == null){
            return new Global();
        }
        else{
            return instance;
        }
    }

    public static boolean getPutBomb() {
        return putBomb;
    }

    public static void setPutBomb(boolean putBomb) {
        Global.putBomb = putBomb;
    }
    
    
    public static void actualizeGlobal(){
        Global.setPlayerName1("");
        Global.setPlayerName2("");
        Global.setPlayerName3("");
        Global.setPlayerName4("");
        Global.setPlayerName5("");
        
        Global.setMinuts(99);    
        Global.setSeconds(99);
        Global.setMiliseconds(999);
        
        Global.setDeadHero(false);
        Global.setPutBomb(false);
        
        Global.setAmountBombHero(0);
        Global.setGameFinalice(false);
        Global.setWinGame(false);
        
        Global.setHaveBlockBarrierDown(false);
        Global.setHaveBlockBarrierLeft(false);
        Global.setHaveBlockBarrierRight(false);
        Global.setHaveBlockBarrierUp(false);
        
        
        Global.setVar(false);
        Global.setPushA(false);
        
        
        
    }
  
    
    
   private static String playerName1="";
   private static String playerName2= "";
   private static String playerName3= "";
   private static String playerName4= "";
   private static String playerName5= "";

    public static String getPlayerName1() {
        return playerName1;
    }

    public static void setPlayerName1(String playerName1) {
        Global.playerName1 = playerName1;
    }

    public static String getPlayerName2() {
        return playerName2;
    }

    public static void setPlayerName2(String playerName2) {
        Global.playerName2 = playerName2;
    }

    public static String getPlayerName3() {
        return playerName3;
    }

    public static void setPlayerName3(String playerName3) {
        Global.playerName3 = playerName3;
    }

    public static String getPlayerName4() {
        return playerName4;
    }

    public static void setPlayerName4(String playerName4) {
        Global.playerName4 = playerName4;
    }

    public static String getPlayerName5() {
        return playerName5;
    }

    public static void setPlayerName5(String playerName5) {
        Global.playerName5 = playerName5;
    }
   
   private static int cont;
   private static int conta;
   private static String name;
   private static int minuts= 99;
   private static int seconds=99;
   private static int miliseconds= 999;

    public static int getCont() {
        return cont;
    }

    public static void setCont(int cont) {
        Global.cont = cont;
    }

    public static int getConta() {
        return conta;
    }

    public static void setConta(int conta) {
        Global.conta = conta;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Global.name = name;
    }

    public static int getMinuts() {
        return minuts;
    }

    public static void setMinuts(int minuts) {
        Global.minuts = minuts;
    }

    public static int getSeconds() {
        return seconds;
    }

    public static void setSeconds(int seconds) {
        Global.seconds = seconds;
    }

    public static int getMiliseconds() {
        return miliseconds;
    }

    public static void setMiliseconds(int miliseconds) {
        Global.miliseconds = miliseconds;
    }
    
    
    
    
    
    private static boolean deadHero = false;
    private static boolean putBomb = false;
    
    private static JFrame windowVar;
    private static String levelOfTheGame;  // resetear variable al finalizar el juego
    private static int amountBalloon;
    private static int amountBarrel;
    private static int amountBlock;
    private static int amountMatrix;
    private static int amountPower;
    private static int levelOfTheBomb;
    
    private static ElementOfTheGame[][] matrix;
    
    private static ElementOfTheGame[][] matrixCopia;
    
    private static int nextMovementBalloon;
    
    
    private static int amountBombHero = 0;
    
    
    private static boolean gameFinalice = false;

    public static boolean isGameFinalice() {
        return gameFinalice;
    }

    public static void setGameFinalice(boolean gameFinalice) {
        Global.gameFinalice = gameFinalice;
    }
    
    private static boolean winGame = false;

    public static boolean isWinGame() {
        return winGame;
    }

    public static void setWinGame(boolean winGame) {
        Global.winGame = winGame;
    }
    
    //////////////////////////////
    private static ArrayList<Review> reviews;
    private static String time; //nuevoooo....
    
    
        public static String getTime() {
        return time;
    }

    public static void setTime(String time) {
        Global.time = time;
    }
    
    
        public static ArrayList<Review> getReviews() {
        return reviews;
    }
    
    public static void insertNewReview(Review review){
        Global.reviews.add(review);
        
    }
    
    public static void setReviews(ArrayList<Review> reviews) {
        Global.reviews = reviews;
    
    }
    
    /////////////////////////
    
    private static boolean haveBlockBarrierUp = false;
    private static boolean haveBlockBarrierLeft = false;
    private static boolean haveBlockBarrierDown = false;
    private static boolean haveBlockBarrierRight = false;

    public static boolean isHaveBlockBarrierUp() {
        return haveBlockBarrierUp;
    }

    public static void setHaveBlockBarrierUp(boolean haveBlockBarrierUp) {
        Global.haveBlockBarrierUp = haveBlockBarrierUp;
    }

    public static boolean isHaveBlockBarrierLeft() {
        return haveBlockBarrierLeft;
    }

    public static void setHaveBlockBarrierLeft(boolean haveBlockBarrierLeft) {
        Global.haveBlockBarrierLeft = haveBlockBarrierLeft;
    }

    public static boolean isHaveBlockBarrierDown() {
        return haveBlockBarrierDown;
    }

    public static void setHaveBlockBarrierDown(boolean haveBlockBarrierDown) {
        Global.haveBlockBarrierDown = haveBlockBarrierDown;
    }

    public static boolean isHaveBlockBarrierRight() {
        return haveBlockBarrierRight;
    }

    public static void setHaveBlockBarrierRight(boolean haveBlockBarrierRight) {
        Global.haveBlockBarrierRight = haveBlockBarrierRight;
    }
            
            
            
            
    
    private static boolean var = false;

    
    
    private static boolean pushA = false;

    public static boolean getPushA() {
        return pushA;
    }

    public static void setPushA(boolean pushA) {
        Global.pushA = pushA;
    }
    
    
    private static int positionRowOfTheBomb;
    private static int positionColumnOfTheBomb;

    
    public static int getPositionRowOfTheBomb() {
        return positionRowOfTheBomb;
    }

    public static void setPositionRowOfTheBomb(int positionRowOfTheBomb) {
        Global.positionRowOfTheBomb = positionRowOfTheBomb;
    }

    public static int getPositionColumnOfTheBomb() {
        return positionColumnOfTheBomb;
    }

    public static void setPositionColumnOfTheBomb(int positionColumnOfTheBomb) {
        Global.positionColumnOfTheBomb = positionColumnOfTheBomb;
    }
    
    
    
    public static boolean getDeadHero() {
        return deadHero;
    }

    public static void setDeadHero(boolean deadHero) {
        Global.deadHero = deadHero;
    }

    
    public static int getLevelOfTheBomb() {
        return levelOfTheBomb;
    }

    public static void setLevelOfTheBomb(int levelOfTheBomb) {
        Global.levelOfTheBomb = levelOfTheBomb;
    }



    
    
    public static void actualizeCopyMatrix(){
        
        int RowMatrix = Global.getAmountMatrix();
        int ColumnMatrix= Global.getAmountMatrix();
        
        int RowCopyMatrix = Global.getAmountMatrix();
        int ColumnCopyMatrix= Global.getAmountMatrix();
        
        ElementOfTheGame [][]matrix = Global.getMatrix();
        
        
        int amountRow = Global.getAmountMatrix();
        int amountColumn = Global.getAmountMatrix();
        ElementOfTheGame [][] copyMatrix = new ElementOfTheGame[amountRow][amountColumn];
        
        
        for(int row = 0 ; row < RowMatrix ; row++ ){
            for(int column = 0 ; column < ColumnMatrix ; column++ ){
                RowCopyMatrix = row;
                ColumnCopyMatrix = column;
                
                if (matrix[row][column] instanceof BarrierBlock){
                    copyMatrix[RowCopyMatrix][ColumnCopyMatrix]= null;  
                    copyMatrix[RowCopyMatrix][ColumnCopyMatrix] = new BarrierBlock(row, column,Constant.STATE_WITHOUT_FIRE);

                }
                else if(matrix[row][column] instanceof Hero){
                    int amountBombs = Global.getAmountBombHero();
                    copyMatrix[RowCopyMatrix][ColumnCopyMatrix] = null;
                    copyMatrix[RowCopyMatrix][ColumnCopyMatrix]  = new Hero(amountBombs, row, column,Constant.STATE_WITHOUT_FIRE);
                    
                    
                }
                else if(matrix[row][column] instanceof Block){
                    HiddenObject copyHiddenObject = obtainHidenObject(row,column);
                    copyMatrix[RowCopyMatrix][ColumnCopyMatrix]= null; 
                    copyMatrix[RowCopyMatrix][ColumnCopyMatrix] = new Block(Constant.DEFAULT_STATE_OF_THE_BLOCK,row, column,Constant.STATE_WITHOUT_FIRE);

                    ElementOfTheGame elementOfTheGame = copyMatrix[RowCopyMatrix][ColumnCopyMatrix];
                    Block block = (Block)elementOfTheGame;         
                    block.setHiddenObject(copyHiddenObject);                    
                }    
     
                else if(matrix[row][column] instanceof Balloon){
                     copyMatrix[RowCopyMatrix][ColumnCopyMatrix]= null;   
                     copyMatrix[row][column] = new Balloon(Constant.DEFAULT_STATE_OF_THE_BALLOON, row, column,Constant.STATE_WITHOUT_FIRE);
                }      
                else if(matrix[row][column] instanceof Barrel){     
                     copyMatrix[RowCopyMatrix][ColumnCopyMatrix]= null;  
                     copyMatrix[row][column] = new Barrel(Constant.DEFAULT_STATE_OF_THE_BARREL, row, column, Constant.STATE_WITHOUT_FIRE);
                }
                else{
                   copyMatrix[RowCopyMatrix][ColumnCopyMatrix]= null;  
                   copyMatrix[row][column] = new EmptySpace(row, column, Constant.STATE_WITHOUT_FIRE);
                }
            }
        } 
        
        Global.setMatrixCopia(copyMatrix);
        
        
    }

    
    
    
    public static void actualizeMatrix(){
        
        int RowMatrix = Global.getAmountMatrix();
        int ColumnMatrix= Global.getAmountMatrix();
        
        int RowCopyMatrix = Global.getAmountMatrix();
        int ColumnCopyMatrix= Global.getAmountMatrix();
        
        ElementOfTheGame [][]matrix = Global.getMatrix();
        
        
        ElementOfTheGame [][] copyMatrix = Global.getMatrixCopia();
        
        
        for(int row = 0 ; row < RowCopyMatrix ; row++ ){
            for(int column = 0 ; column < ColumnCopyMatrix ; column++ ){
                
                RowMatrix = row;
                ColumnMatrix = column;
                
                if (copyMatrix[row][column] instanceof BarrierBlock){
                    matrix[RowMatrix][ColumnMatrix]= null;  
                    matrix[RowMatrix][ColumnMatrix] = new BarrierBlock(row, column,Constant.STATE_WITHOUT_FIRE);

                }
                else if(copyMatrix[row][column] instanceof Hero){
                    int amountBombs = Global.getAmountBombHero();
                    matrix[RowMatrix][ColumnMatrix] = null;
                    matrix[RowMatrix][ColumnMatrix]  = new Hero(amountBombs, row, column,Constant.STATE_WITHOUT_FIRE);
                    
                    
                }
                else if(copyMatrix[row][column] instanceof Block){
                    HiddenObject copyHiddenObject = obtainHidenObject(row,column);
                    matrix[RowMatrix][ColumnMatrix]= null; 
                    matrix[RowMatrix][ColumnMatrix] = new Block(Constant.DEFAULT_STATE_OF_THE_BLOCK,row, column, Constant.STATE_WITHOUT_FIRE);

                    ElementOfTheGame elementOfTheGame = matrix[RowMatrix][ColumnMatrix];
                    Block block = (Block)elementOfTheGame; 
                    block.setHiddenObject(copyHiddenObject); 
                    
                    if(block.getHiddenObject() instanceof Door){
                        System.out.println("puerta");
                    }
                    if(block.getHiddenObject() ==  null){
                      System.out.print(" vacio " + " )" + "  "); 
                    }                    
                    
                    if(block.getHiddenObject() instanceof Power){
                        System.out.println("poder");
                    }                 
                                       
                }    
     
                else if(copyMatrix[row][column] instanceof Balloon){
                     matrix[RowMatrix][ColumnMatrix]= null;   
                     matrix[RowMatrix][ColumnMatrix] = new Balloon(Constant.DEFAULT_STATE_OF_THE_BALLOON, row, column, Constant.STATE_WITHOUT_FIRE);
                }      
                
                else if(copyMatrix[row][column] instanceof Barrel){     
                     matrix[RowMatrix][ColumnMatrix]= null;  
                     matrix[RowMatrix][ColumnMatrix] = new Barrel(Constant.DEFAULT_STATE_OF_THE_BARREL, row, column, Constant.STATE_WITHOUT_FIRE);
                }
                else{
                    
                   matrix[RowMatrix][ColumnMatrix]= null;  
                   matrix[RowMatrix][ColumnMatrix] = new EmptySpace(row, column, Constant.STATE_WITHOUT_FIRE);
                }
            }
        } 
        
        Global.setMatrix(matrix);
        
        
    }    
    
    
    
    
    public static HiddenObject obtainHidenObject(int row, int column){
        
        ElementOfTheGame elementOfTheGame = matrix[row][column];
        Block block = (Block)elementOfTheGame; 
                       
        HiddenObject hiddenCopy = block.getHiddenObject();
        
        return hiddenCopy;
    }
    

    public static String getLevelOfTheGame() {
        return levelOfTheGame;
    }

    public static void setLevelOfTheGame(String levelOfTheGame) {
        Global.levelOfTheGame = levelOfTheGame;
    }

    public static int getAmountBalloon() {
        return amountBalloon;
    }

    public static void setAmountBalloon(int amountBalloon) {
        Global.amountBalloon = amountBalloon;
    }

    public static int getAmountBarrel() {
        return amountBarrel;
    }

    public static void setAmountBarrel(int amountBarrel) {
        Global.amountBarrel = amountBarrel;
    }

    public static int getAmountBlock() {
        return amountBlock;
    }
    
    public static void setReturnJframe(JFrame window){
        Global.windowVar = window;
    }
    
    public static JFrame getReturnJFrame(){
        return windowVar;
    }
    
   
    

    public static void setAmountBlock(int amountBlock) {
        Global.amountBlock = amountBlock;
    }

    public static int getAmountMatrix() {
        return amountMatrix;
    }

    public static void setAmountMatrix(int amountMatrix) {
        Global.amountMatrix = amountMatrix;
    }

    public static int getAmountPower() {
        return amountPower;
    }

    public static void setAmountPower(int amountPower) {
        Global.amountPower = amountPower;
    }

    public static ElementOfTheGame[][] getMatrix() {
        return matrix;
    }

    public static void setMatrix(ElementOfTheGame[][] matrix) {
        Global.matrix = matrix;
    }

    public static ElementOfTheGame[][] getMatrixCopia() {
        return matrixCopia;
    }

    public static void setMatrixCopia(ElementOfTheGame[][] matrixCopia) {
        Global.matrixCopia = matrixCopia;
    }

    public static int getNextMovementBalloon() {
        return nextMovementBalloon;
    }

    public static void setNextMovementBalloon(int nextMovementBalloon) {
        Global.nextMovementBalloon = nextMovementBalloon;
    }

    public static int getAmountBombHero() {
        return amountBombHero;
    }

    public static void setAmountBombHero(int amountBombHero) {
        Global.amountBombHero = amountBombHero;
    }

    public static boolean getVar() {
        return var;
    }

    public static void setVar(boolean var) {
        Global.var = var;
    }
    
    
    
    
    
    
}
