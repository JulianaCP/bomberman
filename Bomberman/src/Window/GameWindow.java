/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Window;

import java.awt.Color;

import Class.ElementOfTheGame;
import Class.Global;
import Class.Matrix;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Class.Block;
import Class.BarrierBlock;
import Class.Balloon;
import Class.Barrel;
import Class.Constant;
import Class.EmptySpace;
import Class.Hero;
import java.awt.event.KeyEvent;
import javax.accessibility.AccessibleRole;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import Class.FillBomb;
import Class.Bomb;
import Class.Door;
import Class.FillRefresh;
import Class.Power;
import Class.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juliana
 */
public class GameWindow extends javax.swing.JFrame {

    /**
     * Creates new form GameWindow
     */
    public GameWindow() {
        initComponents();
        
        Global.setReturnJframe(this);
        
        this.setTitle("Bomberman");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        Color color = new Color(43, 154, 5);
        getContentPane().setBackground(color);
      
     //   Timer timer = new Timer(labelTime);
       // timer.inTimer();
        
        
        if(Global.getVar() == false){
            Matrix matrix = new Matrix();

            int row = Global.getAmountMatrix();
            int column = Global.getAmountMatrix();
            matrix.createMatrix(row, column);
            Global.setVar(true);
        
        }
        
        
        
      fillMatrixImage();
        
      Timer cronometro= new Timer(Global.getTime());
      cronometro.inTimer();
        
      iniciateMovementElementBalloon();
      iniciateMovementElementBarrel(); 
        

        
    }
    
    public void iniciateMovementElementBalloon(){
   
        int totalRow = Global.getAmountMatrix();
        int totalColumn = Global.getAmountMatrix();
        ElementOfTheGame [][]matrix = Global.getMatrix(); 
        
        for(int row = 0 ; row < totalRow ; row++ ){
            for(int column = 0 ; column < totalColumn ; column++ ){
                if(matrix[row][column] instanceof Balloon){
                
                    ElementOfTheGame elementOfTheGame = matrix[row][column];
                    Balloon balloon = (Balloon)elementOfTheGame; 
                    balloon.moveObject(row, column);
                    return;
                }
            }
        }        
    }
    
        public void iniciateMovementElementBarrel(){
   
        int totalRow = Global.getAmountMatrix();
        int totalColumn = Global.getAmountMatrix();
        ElementOfTheGame [][]matrix = Global.getMatrix(); 
        
        for(int row = 0 ; row < totalRow ; row++ ){
            for(int column = 0 ; column < totalColumn ; column++ ){
                if(matrix[row][column] instanceof Barrel){
                
                    ElementOfTheGame elementOfTheGame = matrix[row][column];
                    Barrel barrel = (Barrel)elementOfTheGame; 
                    barrel.moveObject(row, column);
                    return;
                }
            }
        }        
    }
    
    public void pruebaImpresion(){
        
        int totalRow = Global.getAmountMatrix();
        int totalColumn = Global.getAmountMatrix();
        ElementOfTheGame [][]matrix = Global.getMatrix();  
        
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
    }
    
    
    

    
   public void fillMatrixImage(){
 
        this.getContentPane().removeAll();
        this.invalidate();
        this.validate();
        this.repaint();
        SwingUtilities.updateComponentTreeUI(this);
                        
        System.out.println("iiiiiiiiiiiiiiiiiiiiiiiiii");
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
                       add(label);  
                       continue;
                    
                }                
                
                  if (matrix[row][column] instanceof BarrierBlock){
                       
                       JLabel label = new JLabel(); 
                       label.setIcon(new ImageIcon(getClass().getResource("/Window/BarrierBlockImage.jpg")));
                       label.setBounds(y,x,30,30);
                       add(label);   
                  }
                  
                  else if(matrix[row][column] instanceof Bomb){
                        
                       JLabel label = new JLabel(); 
                       label.setIcon(new ImageIcon(getClass().getResource("/Window/bombImage.jpg")));
                       label.setBounds(y,x,30,30);
                       add(label);                      
                  }                  
                  else if(matrix[row][column] instanceof Block){
                        
                       JLabel label = new JLabel(); 
                       label.setIcon(new ImageIcon(getClass().getResource("/Window/BlockImage.jpg")));
                       label.setBounds(y,x,30,30);
                       add(label);                      
                  }
                  
                  else if(matrix[row][column] instanceof Block){
                        
                       JLabel label = new JLabel(); 
                       label.setIcon(new ImageIcon(getClass().getResource("/Window/BlockImage.jpg")));
                       label.setBounds(y,x,30,30);
                       add(label);                      
                  }
                  else if(matrix[row][column] instanceof Hero){
                      System.out.println("DEad "+ Global.getDeadHero() + "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
                        boolean wasDeadHero = Global.getDeadHero();
                        
                        if(wasDeadHero == true){
                            
                            JLabel label = new JLabel(); 
                            label.setIcon(new ImageIcon(getClass().getResource("/Window/heroDead.png")));
                            label.setBounds(y,x,30,30);
                            add(label);  
      
                        }                          
               
                       
                        else if(Global.getPutBomb()==true){
                        JLabel label = new JLabel(); 
                        label.setIcon(new ImageIcon(getClass().getResource("/Window/heroPruebaConBomba.jpg")));
                        label.setBounds(y,x,30,30);
                        this.add(label);                           
                      }
                      
                       System.out.println("eee");
                       JLabel label = new JLabel(); 
                       label.setIcon(new ImageIcon(getClass().getResource("/Window/heroPrueba.jpg")));
                       label.setBounds(y,x,30,30);
                       add(label);                      
                  }                  
                 
                  else if(matrix[row][column] instanceof Balloon){
                        
                       JLabel label = new JLabel(); 
                       label.setIcon(new ImageIcon(getClass().getResource("/Window/baloon.jpg")));
                       label.setBounds(y,x,30,30);
                       add(label);                      
                  }
                  else if(matrix[row][column] instanceof Power){
                        
                       JLabel label = new JLabel(); 
                       label.setIcon(new ImageIcon(getClass().getResource("/Window/PowerImage.jpg")));
                       label.setBounds(y,x,30,30);
                       add(label);                      
                  }                  
                  else if(matrix[row][column] instanceof Door){
                        
                       JLabel label = new JLabel(); 
                       label.setIcon(new ImageIcon(getClass().getResource("/Window/doorImage.jpg")));
                       label.setBounds(y,x,30,30);
                       add(label);                      
                  }                   
                  
                  
                  else if(matrix[row][column] instanceof Barrel){
                        
                       JLabel label = new JLabel(); 
                       label.setIcon(new ImageIcon(getClass().getResource("/Window/Barrel.jpg")));
                       label.setBounds(y,x,30,30);
                       add(label);                      
                  } 
                  
            }
        }       
        

        
        

   }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTime = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(1025, Short.MAX_VALUE)
                .addComponent(labelTime)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(labelTime)
                .addContainerGap(653, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        int code;
        String data = "";
        
        
        code = evt.getKeyCode();
        data = evt.getKeyText(code);
     
  
//        pruebaImpresion();
//      System.out.println("\n\n\n\n\n Prueba impresion copia de lista111111111111111111111111111111111111111111111111 \n\n");

        if(Global.getDeadHero() == true){
            return;
        }
        
        if(Global.isWinGame() == true){
            return;
        }
        
        int totalRow = Global.getAmountMatrix();
        int totalColumn = Global.getAmountMatrix();
        ElementOfTheGame [][]matrix = Global.getMatrix();
        

        if(data.equalsIgnoreCase("A")){
            
            
            
            if(Global.getPutBomb() == true){
                System.out.println("no entra");
                return;
            }
            
            int amountBombInMatrix = obtainAmountBombExistInMatrix();
            int amountBombInGlobal = Global.getAmountBombHero();
            
            
            if(amountBombInGlobal < Constant.MAX_NUMBER_OF_BOMB_IN_THE_MATRIX){
                System.out.println("\n\n\nespacio\n\n\n");
                FillBomb fillBomb = new FillBomb();
                fillBomb.start();
                Global.setPushA(true);
                amountBombInGlobal++;
                Global.setAmountBombHero(amountBombInGlobal);
            }
            
            if(amountBombInMatrix ==0){
                
                Global.setAmountBombHero(Constant.DEFAULT_INITIAL_AMOUNT_OF_BOMB_IN_USE_THAT_HAVE_THE_HERO);
                amountBombInGlobal = Global.getAmountBombHero();
                
                System.out.println("\n\n\nespacio\n\n\n");
                FillBomb fillBomb = new FillBomb();
                fillBomb.start();
                Global.setPushA(true);
                amountBombInGlobal++;
                Global.setAmountBombHero(amountBombInGlobal);
                
            }
            else{
                return;
            }

        }
        
        
        
        for(int row = 0 ; row < totalRow ; row++ ){
            for(int column = 0 ; column < totalColumn ; column++ ){
                if(matrix[row][column] instanceof Hero){
                 
                    ElementOfTheGame elementOfTheGameses = matrix[row][column];
                    Hero hero = (Hero)elementOfTheGameses;
                    
                    
                   if(data.equalsIgnoreCase("Abajo")){
                        
                        hero.moveHero(row, column, "Abajo");
                        pruebaImpresion();
                        this.getContentPane().removeAll();
                        this.invalidate();
                        this.validate();
                        this.repaint();
                        SwingUtilities.updateComponentTreeUI(this);
                        
                        
                        if(matrix[row][column] instanceof EmptySpace){
                            if(Global.getPutBomb() == true){
                                    putBombInMatrix(row, column);
                                    Global.setPutBomb(false);
                            }                            
                        }
                        
                        fillMatrixImage();
                 
                       if(Global.getDeadHero() == true){
                          Timer cronometro= new Timer(Global.getTime());
                          cronometro.OffTimer();
                          System.out.println("****               TIMEEEEEEEEEEEEEEE:           ******"+Global.getTime()); 
                           
                           
                       FillRefresh fillRefresh = new FillRefresh();
                       fillRefresh.start();
                            
                        }
                        return;
                    }
                    
                    else if(data.equalsIgnoreCase("Derecha")){
                        hero.moveHero(row, column, "Derecha");
                        pruebaImpresion();
      
                        this.getContentPane().removeAll();
                        this.invalidate();
                        this.validate();
                        this.repaint();
                        SwingUtilities.updateComponentTreeUI(this);

                        if(matrix[row][column] instanceof EmptySpace){
                            if(Global.getPutBomb() == true){
                                    putBombInMatrix(row, column);
                                    Global.setPutBomb(false);
                            }                            
                        }
                        
                        fillMatrixImage();
                        if(Global.getDeadHero() == true){
                        
                          Timer cronometro= new Timer(Global.getTime());
                          cronometro.OffTimer();
                          System.out.println("****               TIMEEEEEEEEEEEEEEE:           ******"+Global.getTime()); 
                           
                           
                       FillRefresh fillRefresh = new FillRefresh();
                       fillRefresh.start();
                            
                        }

                        return;
                    }
                    
                    else if(data.equalsIgnoreCase("Izquierda")){
                        
                        hero.moveHero(row, column, "Izquierda");
                        
                        pruebaImpresion();
                        this.getContentPane().removeAll();
                        this.invalidate();
                        this.validate();
                        this.repaint();
                        SwingUtilities.updateComponentTreeUI(this);
                        
                        if(matrix[row][column] instanceof EmptySpace){
                            if(Global.getPutBomb() == true){
                                    putBombInMatrix(row, column);
                                    Global.setPutBomb(false);
                            }                            
                        }
                        
                        fillMatrixImage();
                       if(Global.getDeadHero() == true){
                        
                          Timer cronometro= new Timer(Global.getTime());
                          cronometro.OffTimer();
                          System.out.println("****               TIMEEEEEEEEEEEEEEE:           ******"+Global.getTime()); 
                           
                           
                       FillRefresh fillRefresh = new FillRefresh();
                       fillRefresh.start();
                            
                        }
                        
                        return;
                    }
                    
                    else if(data.equalsIgnoreCase("Arriba")){
                        
                        hero.moveHero(row, column, "Arriba");
                        pruebaImpresion();
                        this.getContentPane().removeAll();
                        this.invalidate();
                        this.validate();
                        this.repaint();
                        SwingUtilities.updateComponentTreeUI(this);
                        
                        if(matrix[row][column] instanceof EmptySpace){
                            if(Global.getPutBomb() == true){
                                    putBombInMatrix(row, column);
                                    Global.setPutBomb(false);
                            }                            
                        }
                        

                        
                        fillMatrixImage();
                       if(Global.getDeadHero() == true){
                        
                          Timer cronometro= new Timer(Global.getTime());
                          cronometro.OffTimer();
                          System.out.println("****               TIMEEEEEEEEEEEEEEE:           ******"+Global.getTime()); 
                           
                           
                       FillRefresh fillRefresh = new FillRefresh();
                       fillRefresh.start();
                            
                        }
                        
                        
                        return;
                    }
                    
                }
            }
        }        

    }//GEN-LAST:event_formKeyPressed

    public int obtainAmountBombExistInMatrix(){
        int amount = 0;
        
        int totalRow = Global.getAmountMatrix();
        int totalColumn = Global.getAmountMatrix();
        ElementOfTheGame [][]matrix = Global.getMatrix();       
        
        for(int row = 0 ; row < totalRow ; row++ ){
            for(int column = 0 ; column < totalColumn ; column++ ){
                if(matrix[row][column] instanceof Bomb){
                    amount++;
                }
            }
        }        
        
        return amount;
    }
    
    public void putBombInMatrix(int rowActualCharacter, int columnActualCharacter){
        
        int bombNumber = Global.getAmountBombHero();
      
        
        int totalRow = Global.getAmountMatrix();
        int totalColumn = Global.getAmountMatrix();
        ElementOfTheGame [][]matrix = Global.getMatrix();       
        
        for(int row = 0 ; row < totalRow ; row++ ){
            for(int column = 0 ; column < totalColumn ; column++ ){
                if(rowActualCharacter == row && columnActualCharacter == column){
                    if(matrix[row][column] instanceof EmptySpace){
                        matrix[row][column] = null;
                        
                        int powerOfBomb = Global.getLevelOfTheBomb();
                        
                        matrix[row][column] = new Bomb(powerOfBomb,Constant.DEFAULT_STATE_OF_HIDDEN_OBJECT_WITHOUT_USE,bombNumber, row, column, Constant.STATE_WITHOUT_FIRE);
                    }
                }
            }
        }    
     
        
    }
       
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameWindow().setVisible(true);
            }
        });
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelTime;
    // End of variables declaration//GEN-END:variables
}
