

package adtpilac;

/**
 *
 * @author Eliot Humerez
 * 
 */

public class PilaV {
    //ESTA PILA ESTÁ IMPLEMENTADA CON UN VECTOR
    //ESTA PILA ESTÁ IMPLEMENTADA CON UN VECTOR
    //ESTA PILA ESTÁ IMPLEMENTADA CON UN VECTOR
    //ATRIBUTOS
    private int p[];
    private int cima;    
    
    //CONSTRUCTOR
    public PilaV(int cantidad){
        p=new int[cantidad];
        cima=-1;
    }
    
    @Override
    public String toString(){
        String s="Pila [ ";
        int aux=cima;
        while(!esVacia()){
            s=s+pop()+" ";
        }
        cima=aux;
        return s+"]";
    }
    
    public String toStringRecursivo(){
        if (esVacia()) {
            return "Pila [";
        }else{
            int x=pop();
            String s=toStringRecursivo()+" ";
            s=s+x;
            push(x);
            return s;
        }
    }
    
    //MÉTODOS
    public boolean esVacia(){
        return cima==-1;
    }
    
    public boolean esLlena(){
        return cima==p.length-1;
    }
    
    public void push(int elemento){
        //pre:que la pila no esté llena
        if (esLlena()) {
            System.err.println("Error: Pila llena");
            System.exit(1);
        }
        cima++;
        p[cima]=elemento;
    }
    
    public int pop(){
        cima--;
        return p[cima+1];
    }
    
    public int get(){
        return p[cima];
    }
    
    public void invertir(){
        PilaV p=new PilaV(this.cima+1);
        while(!esVacia()){
            p.push(this.pop());
        }
        this.p=p.p;
        this.cima=p.cima;
    }
    
    public void intercambiarMitades(){
        PilaV aux1=new PilaV(cima+1);
        PilaV aux2=new PilaV(cima+1);
        if (cima>0) {
            int c=cima;
            while(!esVacia()){                
                if (cima>c/2) {
                    aux1.push(pop());
                }else{
                aux2.push(pop());                              
                }            
            }
            while(!aux2.esVacia()){
                if (!aux1.esVacia()) {
                    push(aux1.pop());
                }else{
                    push(aux2.pop());
                }
            }
        }
    }
    
    public void invertirDe2(){                
        PilaV aux=new PilaV(cima+1);
        while(!esVacia()){
            int p=pop();
            if (!esVacia()){ 
                aux.push(pop());
            }                        
            aux.push(p);
        }
        p=aux.p;
        cima=aux.cima;
    }
   
    public boolean esEscaleraAsc(){        
        int x=pop();
        int c=cima;
        while(!esVacia()){                                    
            //if (!esVacia()) {//valida para q no haya overflow y asi pueda comparar
                int y=pop();
                if (y<x) {
                return false;                
                }
                x=y;
            //}            
        }        
        cima=c;
        return true;
    }
    
    public boolean esEscaleraDesc(){        
        int x=pop();
        int c=cima;
        while(!esVacia()){                                    
            //if (!esVacia()) {//valida para q no haya overflow y asi pueda comparar
                int y=pop();
                if (y>x) {
                return false;                
                }
                x=y;
            //}            
        }        
        cima=c;
        return true;
    }
    
    public int cantidadElementosPila(){
        return cima+1;
    }
    
    public static void main(String[] args){
        PilaV p=new PilaV(7);
        PilaV q=new PilaV(7);
        p.push(1);
        p.push(2);
        p.push(3);
        p.push(4);
        p.push(5);
        p.push(6);   
        p.push(7);
        //System.out.println(p.toString());
        q.push(7);
        q.push(8);
        q.push(9);
        q.push(10);
        q.push(11);
        q.push(12);
        q.push(13);
        System.out.println(q);
        q.intercambiarMitadesPivote();
        System.out.println(q);
    }
    
    public void intercambiarMitadesPivote(){
        if (cantidadElementosPila()%2==1) {
        ColaV aux=new ColaV(cima+1);
        int mitad=cima/2;
        while(cima>mitad){
            aux.encolar(pop());            
        }
        aux.invertir();
        while(!esVacia()){
            aux.encolar(pop());
        }
        mitad=(aux.cantElementosCola()/2)+1;
        while(aux.cantElementosCola()>=mitad){
            push(aux.decolar());
        }
        aux.invertir();
        while(!aux.esVacia()){
            push(aux.decolar());
        }    
        }        
    }
    
}
