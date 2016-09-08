package adtcolac;

/**
 *
 * @author Eliot Humerez
 */
public class ADTColaC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ColaV c=new ColaV(6);
        c.encolar(1);
        c.encolar(2);
        c.encolar(3);
        c.encolar(4);
        c.encolar(5);
        c.encolar(6);
        System.out.println(c.toString());
        c.decolar();
        c.decolar();
        c.decolar();
        c.decolar();
        //c.decolar();
        c.encolar(2);
        c.encolar(4);
        c.decolar();    
        System.out.println(c.toString());
    }
    
}
