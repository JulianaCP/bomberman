/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Class;

/**
 *
 * @author Johanna
 */
public class Review {

    private String name;
    private int minuts;
    private int seconds;
    private int miliseconds;

    public Review(String name, int minuts, int seconds, int miliseconds) {
        this.name = name;
        this.minuts = minuts;
        this.seconds = seconds;
        this.miliseconds = miliseconds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinuts() {
        return minuts;
    }

    public void setMinuts(int minuts) {
        this.minuts = minuts;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getMiliseconds() {
        return miliseconds;
    }

    public void setMiliseconds(int miliseconds) {
        this.miliseconds = miliseconds;
    }

        
 
    }
    


