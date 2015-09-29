/*
 * Created by HCD at Chaparral Star Academy
 * v1.1 Build 9/29/15
 * Simple starter login that will be worked on throughout the year
 * http://compsciteacher.com
 *
 *
 *
 *
 *
 */
package login;
import java.util.*;

/**
 *
 * Right now we have only used public and void classes
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
        loginCheck();
    }
    /**
     * @param args the command line arguments
     * prints school info
     */
    public static void CSAInfo(){
        System.out.println("----------------------------------------");
        System.out.println("Chaparral Star Academy"
                + "\n14046 Summit Dr"
                + "\nAustin,TX 78728"
                + "\n512.989.2672");
        
        
    }
    /**
     * @param args the command line arguments
     * prints date time using Date() and just making it a string
     * 
     * 
     */
    public static void dateTime(){
        System.out.println("----------------------------------------");
        Date date=new Date();
        System.out.println("Today is "+date.toString());
    }
    
    /**
     * @param args the command line arguments
     * initial greeting that asks for user name and states they are gettig on the school's
     * system. 
     */
    public static void firstGreeting(){
        Scanner nameIn = new Scanner(System.in);
        
        System.out.println("");
        System.out.println("----------------------------------------");
        System.out.println("What is your name?");
        String name = nameIn.nextLine();
        
        System.out.println("Hello, "+name+" welcome to Chaparral Star Academy!");
    }
    /**
     * @param args the command line arguments
     * asks for user initials as their login, allows three users just given through OR ||
     * statements right now
     * on unsuccsseful login returns to main and exits
     */
    public static void loginCheck(){
        System.out.println("----------------------------------------");
        Scanner initialsIn = new Scanner(System.in);
        System.out.println("Please enter your initials to login");
        String initials = initialsIn.nextLine();
        
        if (initials.equals("HCD")||initials.equals("DKE")||initials.equals("JMH")){
            System.out.println("SUCCESSFUL LOGIN");
        } else{
            System.out.println("UNSSUCCESSFUL LOGIN");
            return;
        
        }
        
    }

    
}
