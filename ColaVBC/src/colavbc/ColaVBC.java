/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colavbc;

/**
 *
 * @author LeOnardO
 */
public class ColaVBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      cola p=new cola(6);
       cola q=new cola(6);
       cola r=new cola(6);
       p.encolar(1);
       p.encolar(2);
       p.encolar(3);
       p.encolar(4);
       p.encolar(5);
       p.encolar(6);
       q.encolar(7);
       q.encolar(8);
       q.encolar(9);
       q.encolar(10);
       q.encolar(11);
       q.encolar(12);
        r.invC(p, q);
        System.out.println(p.toString());
        System.out.println(q.toString());
        
    }
    
}
