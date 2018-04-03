/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Class;

import javax.swing.JLabel;

/**
 *
 * @author Johanna
 */
public class Timer extends Thread{
    
     String time;
     Thread tread;
     public static boolean activeTimer;

    public Timer(String time) {
        this.time = time;
        
    }
    
@Override    
public void run(){
        
        Integer minuts = 0 , seconds = 0, thousandths = 0;
        String min="", seg="", mil="";
        try
        {
            while( activeTimer )
            {
                Thread.sleep( 4 );
                
                thousandths += 4;

                
                if( thousandths == 1000 )
                {
                    thousandths = 0;
                    seconds += 1;

                    if( seconds == 60 )
                    {
                        seconds = 0;
                        minuts++;
                    }
                }

                if( minuts < 10 ) min = "0" + minuts;
                else min = minuts.toString();
                if( seconds < 10 ) seg = "0" + seconds;
                else seg = seconds.toString();

                if( thousandths < 10 ) mil = "00" + thousandths;
                else if( thousandths < 100 ) mil = "0" + thousandths;
                else mil = thousandths.toString();
                
                
                time= ( min + ":" + seg + ":" + mil );
                Global.setTime(time);
                //time.setText( min + ":" + seg + ":" + mil );
            }
        }catch(Exception e){}
        
        //time.setText( "00:00:000" );
    } 

    public void inTimer() {
        activeTimer = true;
        tread = new Thread( this );
        tread.start();
    }

    public void OffTimer(){
        activeTimer = false;
    }

    }      
    
    

