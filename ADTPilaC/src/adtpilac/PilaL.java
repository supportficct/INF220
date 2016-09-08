package adtpilac;

/**
 *
 * @author Eliot Humerez
 * 
 */

public class PilaL {
    private Nodo p;
    
    public PilaL(){
        p=null;
    }
    
    public PilaL(Nodo p){
        this.p=p;
    }    
    
    //ESTE TOSTRING SOLO ACCEDE A LOS GETDATA DE LOS NODOS DE LA PILA
    public String toString1(){
        String s="Pila [ ";
        Nodo aux=p;
        while(aux!=null){
            s=s+aux.getData()+" ";
            aux=aux.getLink();
        }
        return s+"]";
    }
    //ESTE TOSTRING USA UNA PILA AUX PARA COPIAR A LA ORIGINAL ACCEDIENDO A CADA NODO CON
    //COMPORTAMIENTO DE PILA (POP)
    public String toString2(){
        Nodo aux1=p;
        PilaL aux2=new PilaL(aux1);
        String s="Pila [ ";
        while(!aux2.esVacia()){
            s=s+aux2.pop()+" ";            
        }
        return s+"]";
    }
    
    @Override
    public String toString(){
        String s="Pila { ";
        Nodo aux=p;        
        while(!esVacia()){
            s=s+pop()+" ";
        }
        p=aux;
        return s+"}";
    }
    
    public boolean esVacia(){
        return p==null;
    }
    
    public boolean esLleno(){
        Nodo aux=new Nodo();
        return aux==null;
    }
    
    public void push(int elemento){
        if (esLleno()) {
            System.err.println("Error: Pila llena");
            System.exit(1);
        }
        Nodo aux=new Nodo(elemento);
        aux.setLink(p);
        p=aux;
    }
    
    public int pop(){
        //las funciones no tiene precondicion
        int x=p.getData();
        p=p.getLink();
        return x;
    }
    
    public int get(){
        return p.getData();
    }
    
    public void invertirDe2(){                
        PilaL aux=new PilaL();
        while(!esVacia()){
            int p=pop();
            if (!esVacia()){ 
                aux.push(pop());
            }                        
            aux.push(p);
        }
        p=aux.p;        
    }
    
    public int cantidad(){
        int count=0;
        Nodo aux=p;
        while(aux!=null){
            aux=aux.getLink();
            count++;
        }
        return count;
    }
    
    public void intercambiarMitades(){
        PilaL aux1=new PilaL();
        PilaL aux2=new PilaL();
        int ca=cantidad();
        if (ca>0) {
            int c=ca;
            while(!esVacia()){                
                if (ca>c/2) {
                    aux1.push(pop());
                    ca--;
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
    
    public void eliminarEle(int ele){
        if (!esVacia()) {
            PilaL aux = new PilaL();
            while (!esVacia()) {                
                aux.push(pop());
                if (aux.get()==ele) {
                    aux.pop();
                    }
            }
            if (!aux.esVacia()) {
                while(!aux.esVacia()) {
                    push(aux.pop());
                } 
            }      
        }
    }
    
    public void eliminarUnaVez(int ele){
        if (!esVacia()) {
            boolean sw = false;
            PilaL aux = new PilaL();
            while (!esVacia()) {                
                aux.push(pop());
                if (aux.get()==ele && !sw) {
                    aux.pop();
                    sw = true;
                    }
            }
            if (!aux.esVacia()) {
                while(!aux.esVacia()) {
                    push(aux.pop());
                } 
            }      
        }
      }
      
      
      public void insertarOrdenadoAsc(int ele){
          if (!esVacia()) {
             PilaL aux = new PilaL();
              boolean flag = false;
              while (!esVacia()&&!flag) {                  
                  aux.push(pop());
                  if(aux.get()<=ele){
                      push(aux.pop());
                      push(ele);
                      flag = true;
                  }
              }
              while (!aux.esVacia()) {                  
                  push(aux.pop());
              }
      }
      }
    
    public boolean esEscaleraAsc(){        
        int x=pop();
        Nodo c=p;
        while(!esVacia()){                                    
            //if (!esVacia()) {//valida para q no haya overflow y asi pueda comparar
                int y=pop();
                if (y<x) {
                return false;                
                }
                x=y;
            //}            
        }        
        p=c;
        return true;
    }
    
    public boolean esEscaleraDesc(){        
        int x=pop();
        Nodo c=p;
        while(!esVacia()){                                    
            //if (!esVacia()) {//valida para q no haya overflow y asi pueda comparar
                int y=pop();
                if (y>x) {
                return false;                
                }
                x=y;
            //}            
        }        
        p=c;
        return true;
    }  
      
    public static void main(String[] args){
        PilaL p=new PilaL();
        p.push(1);
        p.push(2);
        p.push(3);
        p.push(4);
        System.out.println(p.toString());
        p.pop();
        System.out.println(p.toString());
        //p.eliminarEle(2);
        //p.intercambiarMitades();
        p.insertarOrdenadoAsc(10);
        p.insertarOrdenadoAsc(7);
        System.out.println(p.toString());
    }
    
}
