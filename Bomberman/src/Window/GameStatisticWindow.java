/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Window;

import Class.Global;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JLabel;
import jdk.nashorn.internal.ir.LabelNode;

/**
 *
 * @author Juliana
 */
public class GameStatisticWindow extends javax.swing.JFrame {

    /**
     * Creates new form GameStatisticWindow
     */
    public GameStatisticWindow() {
        initComponents();
        
        this.setTitle("Game Statistics");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
       
        
        ReadFile("BombermanProyect.txt");
        Global.setConta(1);
        ReadFile("BombermanProyect.txt");
        Global.setConta(2);
        ReadFile("BombermanProyect.txt");
        Global.setConta(3);
        ReadFile("BombermanProyect.txt");
        Global.setConta(4);
        ReadFile("BombermanProyect.txt");
        
    }

public void comprobatePosition(String name)    {
         if(Global.getConta() == 0) {
                System.out.println("CONT 0");
                Global.setPlayerName1(name);
               labelNamePersonChangeLabelTopNumber1.setText(Global.getName());
               labelTimePersonChangeLabelTopNumber1.setText(String.valueOf(Global.getMinuts()+":"+Global.getSeconds()+":"+Global.getMiliseconds()));   
            }

            if(Global.getConta() == 1) {
                 System.out.println("CONT 1");
                 Global.setPlayerName2(name);
               labelNamePersonChangeLabelTopNumber2.setText(Global.getName());
               labelTimePersonChangeLabelTopNumber2.setText(String.valueOf(Global.getMinuts()+":"+Global.getSeconds()+":"+Global.getMiliseconds()));   
            }

            if(Global.getConta() == 2) {
                 System.out.println("CONT 2");
                 Global.setPlayerName3(name);
               labelNamePersonChangeLabelTopNumber3.setText(Global.getName());
               labelTimePersonChangeLabelTopNumber3.setText(String.valueOf(Global.getMinuts()+":"+Global.getSeconds()+":"+Global.getMiliseconds()));   
            }

            if(Global.getConta() == 3) {
                 System.out.println("CONT 3");
                 Global.setPlayerName4(name);
               labelNamePersonChangeLabelTopNumber4.setText(Global.getName());
               labelTimePersonChangeLabelTopNumber4.setText(String.valueOf(Global.getMinuts()+":"+Global.getSeconds()+":"+Global.getMiliseconds()));   
            }

            if(Global.getConta() == 4) {
                 System.out.println("CONT 4");
                 Global.setPlayerName5(name);
               labelNamePersonChangeLabelTopNumber5.setText(Global.getName());
               labelTimePersonChangeLabelTopNumber5.setText(String.valueOf(Global.getMinuts()+":"+Global.getSeconds()+":"+Global.getMiliseconds()));   
            }
}
    
    
    
    
    
    
     public  String ReadFile(String file){
        try {
            
            File f;
            FileReader lectorArchivo;
            f = new File(file);
            lectorArchivo = new FileReader(f);
            BufferedReader br = new BufferedReader(lectorArchivo);
            String arch="";
            String aux="";
            while(true){
                    aux=br.readLine();
                    if(aux!=null)
                            arch=arch+aux;
                    else
                            break;
            }
            br.close();
            
            
          
                
            
            //String subString = arch.substring(0,8);
            //System.out.println("test : "+ subString);
            String[] split = arch.split(",");
            // System.out.println("split is: "+ split[0]);
            String[] players = new String[split.length];
            System.out.println("lenght is :"+split.length);
	    	for (int i = 0; i < split.length; i++) {
                   // for (int j = 0; j < 4; j++) {
                    players[i]=split[i];
                    //a-01dkf, b-21l-bla
                    String[] splitPlayers = arch.split("-");
                   // System.out.println("jugador : " + i + split[i]);
                    System.out.println("jugador is :"+players[i]);
                    String[] test = players[i].split("-");
                    
                    System.out.println("largo de splitplayers is :"+splitPlayers.length);
                    //for (int j = 0; j < splitPlayers.length; j++) {
                    
                    
                    String name= test[0];
                    int minuts= Integer.parseInt(test[1]);
                    int seconds= Integer.parseInt(test[2]);
                    int miliseconds= Integer.parseInt(test[3]);
                    System.out.println("jugdoresss is :"+test[0]);
                    System.out.println("horaaaa is :"+test[1]);
                    System.out.println("minedeee is :"+test[2]);
                    

                    
                    System.out.println(Global.getPlayerName1());
                    System.out.println(name);
                    if(!Global.getPlayerName1().equals(name) && !Global.getPlayerName2().equals(name) &&
                            !Global.getPlayerName3().equals(name) && !Global.getPlayerName4().equals(name) &&
                            !Global.getPlayerName5().equals(name)){

                                 if(Global.getMinuts()> minuts){
                                    System.out.println("fcfvdfvdfvdf4444444444444444444444444444444444444444444444444");
                                    Global.setName(name);
                                    Global.setMinuts(minuts);
                                    Global.setSeconds(seconds);
                                    Global.setMiliseconds(miliseconds);
                                    System.out.println("rrrrrrr");
                                    
                                    comprobatePosition( name);
                               
                                    
                                    
                                    continue;
                                }

                                else if(Global.getMinuts() == minuts && Global.getSeconds()> seconds){
                                    Global.setName(name);
                                    Global.setMinuts(minuts);
                                    Global.setSeconds(seconds);
                                    Global.setMiliseconds(miliseconds);
                                    System.out.println("fcfvdfvdfvdf");
                                    
                                    comprobatePosition(name);
                                    
                                    
                                    continue;
                                }
                                else if( Global.getSeconds()== seconds && Global.getMiliseconds()> miliseconds){
                                    Global.setName(name);
                                    Global.setMinuts(minuts);
                                    Global.setSeconds(seconds);
                                    Global.setMiliseconds(miliseconds);
                                    System.out.println("vrrwwwdddddd");
                                    
                                    
                                    comprobatePosition(name);
                                    continue;
                                }
                                else if( Global.getSeconds()== seconds && Global.getMiliseconds()== miliseconds){
                                    Global.setName(name);
                                    Global.setMinuts(minuts);
                                    Global.setSeconds(seconds);
                                    Global.setMiliseconds(miliseconds);
                                    System.out.println("vrrwwwdddddd");
                                    
                                    
                                    comprobatePosition(name);
                                    continue;
                                }

                                System.out.println("jugdoreee is :"+test[0]);
                                System.out.println("horafff is :"+test[1]);
                                System.out.println("minede is :"+test[2]);
                                System.out.println("\n");

                             }

                           
       
                    }
                    
                    System.out.println("prueba superada 2");
                    System.out.println(Global.getMinuts());
                    Global.setName("");
                    Global.setMinuts(99);
                    Global.setSeconds(99);
                    Global.setMiliseconds(999);
                    
    
    System.out.println("prueba superada 3");
            lectorArchivo.close();
            return arch;
            }catch(IOException e){
                    System.out.println("Error:"+e.getMessage());
            }
            return null;
}
    
    
    

    
    
    
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        labelNameStatistics = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelNameStatistics1 = new javax.swing.JLabel();
        labelNamePersonChangeLabelTopNumber1 = new javax.swing.JLabel();
        labelTimePersonChangeLabelTopNumber1 = new javax.swing.JLabel();
        labelNamePersonChangeLabelTopNumber2 = new javax.swing.JLabel();
        labelTimePersonChangeLabelTopNumber2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelNameStatistics2 = new javax.swing.JLabel();
        labelNamePersonChangeLabelTopNumber3 = new javax.swing.JLabel();
        labelTimePersonChangeLabelTopNumber3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelNameStatistics3 = new javax.swing.JLabel();
        labelNamePersonChangeLabelTopNumber4 = new javax.swing.JLabel();
        labelTimePersonChangeLabelTopNumber4 = new javax.swing.JLabel();
        labelNamePersonChangeLabelTopNumber5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labelNameStatistics4 = new javax.swing.JLabel();
        labelTimePersonChangeLabelTopNumber5 = new javax.swing.JLabel();
        labelTimeStatistics2 = new javax.swing.JLabel();
        labelTimeStatistics3 = new javax.swing.JLabel();
        labelTimeStatistics5 = new javax.swing.JLabel();
        labelTimeStatistics1 = new javax.swing.JLabel();
        labelTimeStatistics4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI Black", 1, 45)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Game Statistics");
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, -20, 460, 150));

        labelNameStatistics.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        labelNameStatistics.setText("Name:");
        getContentPane().add(labelNameStatistics, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel1.setText("5.  ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel2.setText("1.  ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        labelNameStatistics1.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        labelNameStatistics1.setText("Name:");
        getContentPane().add(labelNameStatistics1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, -1, -1));

        labelNamePersonChangeLabelTopNumber1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(labelNamePersonChangeLabelTopNumber1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 130, 30));

        labelTimePersonChangeLabelTopNumber1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelTimePersonChangeLabelTopNumber1.setText("Number1");
        getContentPane().add(labelTimePersonChangeLabelTopNumber1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, 150, 30));

        labelNamePersonChangeLabelTopNumber2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelNamePersonChangeLabelTopNumber2.setText("number2");
        getContentPane().add(labelNamePersonChangeLabelTopNumber2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 60, 30));

        labelTimePersonChangeLabelTopNumber2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelTimePersonChangeLabelTopNumber2.setText("Number2");
        getContentPane().add(labelTimePersonChangeLabelTopNumber2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 210, 110, 20));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel3.setText("2.  ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, -1, -1));

        labelNameStatistics2.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        labelNameStatistics2.setText("Name:");
        getContentPane().add(labelNameStatistics2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, -1, -1));

        labelNamePersonChangeLabelTopNumber3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelNamePersonChangeLabelTopNumber3.setText("Number3");
        getContentPane().add(labelNamePersonChangeLabelTopNumber3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, -1, -1));

        labelTimePersonChangeLabelTopNumber3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelTimePersonChangeLabelTopNumber3.setText("Number3");
        getContentPane().add(labelTimePersonChangeLabelTopNumber3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 270, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel4.setText("3.  ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, -1));

        labelNameStatistics3.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        labelNameStatistics3.setText("Name:");
        getContentPane().add(labelNameStatistics3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, -1, -1));

        labelNamePersonChangeLabelTopNumber4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelNamePersonChangeLabelTopNumber4.setText("Number4");
        getContentPane().add(labelNamePersonChangeLabelTopNumber4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, -1, -1));

        labelTimePersonChangeLabelTopNumber4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelTimePersonChangeLabelTopNumber4.setText("Number4");
        getContentPane().add(labelTimePersonChangeLabelTopNumber4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 320, -1, -1));

        labelNamePersonChangeLabelTopNumber5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelNamePersonChangeLabelTopNumber5.setText("Number5");
        getContentPane().add(labelNamePersonChangeLabelTopNumber5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel6.setText("4.  ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, -1, -1));

        labelNameStatistics4.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        labelNameStatistics4.setText("Name:");
        getContentPane().add(labelNameStatistics4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, -1, -1));

        labelTimePersonChangeLabelTopNumber5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelTimePersonChangeLabelTopNumber5.setText("Number5");
        getContentPane().add(labelTimePersonChangeLabelTopNumber5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 370, -1, -1));

        labelTimeStatistics2.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        labelTimeStatistics2.setText("Time: ");
        getContentPane().add(labelTimeStatistics2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 200, -1, -1));

        labelTimeStatistics3.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        labelTimeStatistics3.setText("Time: ");
        getContentPane().add(labelTimeStatistics3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 260, -1, -1));

        labelTimeStatistics5.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        labelTimeStatistics5.setText("Time: ");
        getContentPane().add(labelTimeStatistics5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 360, -1, -1));

        labelTimeStatistics1.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        labelTimeStatistics1.setText("Time: ");
        getContentPane().add(labelTimeStatistics1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, -1, -1));

        labelTimeStatistics4.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        labelTimeStatistics4.setText("Time: ");
        getContentPane().add(labelTimeStatistics4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 310, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Window/ImageWhite.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 660, 360));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Window/imageBlack.png"))); // NOI18N
        jLabel7.setText("jLabel7");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 530));

        jMenu1.setText("File");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Window/BackImage.jpg"))); // NOI18N
        jMenuItem1.setText("Back");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        LevelSelectionWindow window = new LevelSelectionWindow();
        window.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        PrincipalWindow window = new PrincipalWindow();
        window.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(GameStatisticWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameStatisticWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameStatisticWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameStatisticWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameStatisticWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel labelNamePersonChangeLabelTopNumber1;
    private javax.swing.JLabel labelNamePersonChangeLabelTopNumber2;
    private javax.swing.JLabel labelNamePersonChangeLabelTopNumber3;
    private javax.swing.JLabel labelNamePersonChangeLabelTopNumber4;
    private javax.swing.JLabel labelNamePersonChangeLabelTopNumber5;
    private javax.swing.JLabel labelNameStatistics;
    private javax.swing.JLabel labelNameStatistics1;
    private javax.swing.JLabel labelNameStatistics2;
    private javax.swing.JLabel labelNameStatistics3;
    private javax.swing.JLabel labelNameStatistics4;
    private javax.swing.JLabel labelTimePersonChangeLabelTopNumber1;
    private javax.swing.JLabel labelTimePersonChangeLabelTopNumber2;
    private javax.swing.JLabel labelTimePersonChangeLabelTopNumber3;
    private javax.swing.JLabel labelTimePersonChangeLabelTopNumber4;
    private javax.swing.JLabel labelTimePersonChangeLabelTopNumber5;
    private javax.swing.JLabel labelTimeStatistics1;
    private javax.swing.JLabel labelTimeStatistics2;
    private javax.swing.JLabel labelTimeStatistics3;
    private javax.swing.JLabel labelTimeStatistics4;
    private javax.swing.JLabel labelTimeStatistics5;
    // End of variables declaration//GEN-END:variables
}
