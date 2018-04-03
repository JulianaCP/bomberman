package Window;

import Class.Review;
import Class.Global;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import Class.StringRangeExeption;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class ReviewWindow extends javax.swing.JFrame {

    /**
     * Creates new form ReviewWindow
     */
    public ReviewWindow() {
        initComponents();
      //  Global.setTime("01:24:194");
        String time= Global.getTime();
        timeLabel.setText(time);
        
    }
    
   /**
    * 
    * @throws StringRangeExeption
    * @throws IOException 
    */
    public void reciveInformation() throws StringRangeExeption, IOException{
                
        String name= NameOfThePerson.getText();
        
        try{    
            Range(name);
            createAndWriteInFile(name);
            ReadFile("BombermanProyect.txt");
        }
        catch(StringRangeExeption e){
            System.out.println(e.getMessage());
        } 
        
    }
    
    public void Range(String name) throws StringRangeExeption{
        if(name.length() > 10){
                throw new StringRangeExeption(this);
                
            }
  
    }
      
    public void createAndWriteInFile(String name)throws IOException{
        String ruta = "BombermanProyect.txt";
        
        File archivo = new File(ruta);
        BufferedWriter bw;
        FileWriter buev= new FileWriter(archivo,true);
        if(archivo.exists()) {
            FileReader f = new FileReader(ruta);
            String cadena;
            BufferedReader b = new BufferedReader(f);
            cadena = b.readLine();
            buev= new FileWriter(archivo,true);
            
            
            String [] chain = Global.getTime().split(":");
            String minuts=  chain[0];
            String second=  chain[1];
            String miliSeconds=  chain[2];
            System.out.println(minuts+" "+ second+" "+miliSeconds);
            
             buev.write(name+"-"+minuts+"-"+second+"-"+miliSeconds+",\n");
             JOptionPane.showMessageDialog(this,"The data has been successfully saved.\nThanks for playing.");
           /* buev.write(name+"-\n");
            buev.write(minuts+"-\n");
            buev.write(second+"-\n");
            buev.write(miliSeconds+"-\n+");*/
            
        } 
        
        else {
            
            bw = new BufferedWriter(new FileWriter(archivo,true));
            String [] chain = Global.getTime().split(":");
            String minuts=  chain[0];
            String second=  chain[1];
            String miliSeconds=  chain[2];
            
            
            
            bw.write(name+"-"+minuts+"-"+second+"-"+miliSeconds+",\n");
            JOptionPane.showMessageDialog(this,"The data has been successfully saved.\nThanks for playing.");
           /* bw.write(minuts+"-\n");
            bw.write(second+"-\n");
            bw.write(miliSeconds+"-\n+");*/
        }
        buev.close();
        
        
    }
    
    
    public void theBestPositions(){
        ArrayList reviews= Global.getReviews();
        while(reviews.isEmpty()){
            Review nombre= (Review) reviews.get(0);
            
            System.out.println(nombre.getMiliseconds());  
            
            
        }  
        
    }
    
    /**
     * 
     * @param file - The input file
     * @return arch - The String 
     */
    public static String ReadFile(String file){
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
            
            
            //Testing
           String hora = "";
                
            
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
                    System.out.println("jugdor is :"+test[0]);
                    System.out.println("hora is :"+test[1]);
                    System.out.println("min is :"+test[2]);
                    
                    //}
                    System.out.println("\n");
                   // }
                 }
            
             
                
    
    
            lectorArchivo.close();
            return arch;
            }catch(IOException e){
                    System.out.println("Error:"+e.getMessage());
            }
            return null;
}
    
    
    public void readFile()throws FileNotFoundException, IOException {

       Scanner archivo= null;
       String ruta = "BombermanProyect.txt";
       try{
           archivo= new Scanner(new File(ruta));           
       }
       catch(Exception e){
           System.out.println("sss");
       }
       
       int cont=0;
       int conta= 0;
       String name= "";
       int minuts=0;
       int seconds=0;
       int miliseconds=0;
       
       while(archivo.hasNext()){

            
           if(cont == 4){
               Review review= new Review( name, minuts,seconds,miliseconds);
               Global.insertNewReview(review);
               cont=0;
           }
           
           if(cont == 0){
               name= archivo.nextLine();
               
           }
           else if(cont == 1){
               minuts= archivo.nextInt();
           }
           else if(cont == 2){
               seconds= archivo.nextInt();
           }
           else if(cont == 3){
               miliseconds= archivo.nextInt();
           }
           cont++;
           conta++;
           
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        NameOfThePerson = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        saveBotton = new javax.swing.JButton();
        timeLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Name");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, 84, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Final Time");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, -1, -1));
        getContentPane().add(NameOfThePerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 420, 350, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Save");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, -1, -1));

        saveBotton.setText("SAVE");
        saveBotton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBottonActionPerformed(evt);
            }
        });
        getContentPane().add(saveBotton, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 420, -1, -1));

        timeLabel.setForeground(new java.awt.Color(255, 255, 255));
        timeLabel.setText("TIME");
        getContentPane().add(timeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 120, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Window/winFinal2.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, -10, 880, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveBottonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBottonActionPerformed

                
        try {
            // TODO add your handling code here:
         reciveInformation();
            //readFile();
            //theBestPositions();
        } catch (StringRangeExeption ex) {
           Logger.getLogger(ReviewWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReviewWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

        
        
    }//GEN-LAST:event_saveBottonActionPerformed

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
            java.util.logging.Logger.getLogger(ReviewWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReviewWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReviewWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReviewWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReviewWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NameOfThePerson;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton saveBotton;
    private javax.swing.JLabel timeLabel;
    // End of variables declaration//GEN-END:variables
}
