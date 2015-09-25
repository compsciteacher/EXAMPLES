/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;
import java.util.*;

/**
 *
 * @author hdavis
 */
public class Login {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CSAInfo();
        dateTime();
        firstGreeting();
    }
    public static void CSAInfo(){
        System.out.println("----------------------------------------");
        System.out.println("Chaparral Star Academy"
                + "\n14046 Summit Dr"
                + "\nAustin,TX 78728"
                + "\n512.989.2672");
        
        
    }
    public static void dateTime(){
        System.out.println("----------------------------------------");
        Date date=new Date();
        System.out.println("Today is "+date.toString());
    }
    public static void firstGreeting(){
        System.out.println("");
        System.out.println("----------------------------------------");
        System.out.println("Hello, welcome to Chaparral Star Academy");
    }
}
