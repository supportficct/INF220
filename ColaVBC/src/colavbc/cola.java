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
public class cola {
    int q[];
    int inicio;
    int fin;
    public cola(int cant){
        q=new int[cant];
        fin=-1;
        inicio=-1;
    }
    public  boolean vacia(){
        return inicio==-1;
    }
    public  boolean llena(){
        return (((fin+1)%q.length)==inicio);
    }
    public int get(){
        return q[inicio];
    }
    public void encolar(int ele){
        if(llena()){
            System.err.println("ERROR:COLA llena");
        }else{
          /*  if(fin+1==q.length){
                fin=0;
            }else{
                fin++;
            
            }
            q[fin]=ele;
            */
            if(vacia()){
                inicio=fin=0;
            }else{
               fin=(fin+1)%q.length;
             
            }
            q[fin]=ele; 
            
        }
    }
    public int decolar(){
        int x=q[inicio];
        if(inicio==fin){
            inicio=-1;
            fin=-1;
        }else{
            inicio=(inicio+1)%q.length;
        }
        return x;
    }
  public int cantidad(){
       return ((((fin+q.length)-inicio)%q.length)+1);
   }

  
 
public void invC(cola p,cola q){
    cola aux=new cola(p.cantidad());
    int i=1;
    while (i<=q.cantidad()/2) {        
        i++;
        aux.encolar(p.decolar());
    }
    int j=1;
    while (j<=(p.cantidad()+1)/2) { 
        j++;
        p.encolar(q.decolar());
    }
    int h=1;
    while (h<=(q.cantidad()+1)/2) { 
        h++;
        q.encolar(aux.decolar());
    }
int as=1;
    while (as<=(p.cantidad()+1)/2) { 
        as++;
        int x=p.decolar();
        p.encolar(x);
    }
    int as1=1;
     while (as1<=(p.cantidad()+1)/2) { 
        as1++;
        int x=q.decolar();
        q.encolar(x);
    }
}
  
    @Override
    public String toString() {
 String s="cola [ ";
 if(vacia()){
     return s;
 }
 int i=1;
        while (i<=cantidad()) {
            
            int x=decolar();
            s=s+x;
            s=s+"; ";
            encolar(x);
            i++;
        }
        return s+"]";
    }
    
    
}
