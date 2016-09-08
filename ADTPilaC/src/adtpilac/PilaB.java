package adtpilac;

/**
 *
 * @author Eliot Humerez
 * 
 */

public class PilaB {
    private VectorBits p;
    private int cima;    
    
    public PilaB(int cantElementos,int cantBits){
        cima=0;
        p=new VectorBits(cantElementos, cantBits);
    }
    
    public String toString(){
        String s="Pila { ";
        int c=cima;
        while(!esVacia()){
            s=s+pop()+" ";
        }
        cima=c;
        return s+"}";
    }
    
    public boolean esVacia(){
        return (cima==0);
    }
    
    public boolean esLlena(){
        return cima==p.getCantElementos();
    }
    
    public void push(int elemento){
        if (esLlena()) {
            System.out.println("Error: PilaB llena");
            System.exit(1);
        }
        cima++;
        p.insertar(elemento, cima);
    }
    
    public int pop(){
        cima--;
        return p.Sacar(cima+1);
    }
    
    public int Get(){
        return p.Sacar(cima);
    }
    
    public void intercambiarMitades(){
        PilaB aux1=new PilaB(cima,5);
        PilaB aux2=new PilaB(cima,5);
        if (cima>1) {
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
        PilaB aux=new PilaB(cima,6);
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
    
    public static void main(String[] args){
        PilaB p=new PilaB(6, 5);
        p.push(1);
        p.push(2);
        p.push(3);
        p.push(4);
        p.push(5);
        p.push(6);
        System.out.println(p);
        p.invertirDe2();
        System.out.println(p);
    }
    
}
