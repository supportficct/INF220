package adtpilac;

/**
 *
 * @author Eliot Humerez
 * 
 */

public class ADTPilaC {

    public static void main(String[] args) {
        PilaV p=new PilaV(6);
        p.push(1);
        p.push(2);
        p.push(3);
        p.push(4);
        p.push(5);
        //p.push(6);        
        System.out.println(p);
        p.intercambiarMitades();
        System.out.println(p);
    }
    
}
