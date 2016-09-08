package adtcolac;

/**
 *
 * @author Eliot Humerez
 */
public class ColaL {
    private Nodo Inicio;
    private Nodo Final;
    private int cantElementos;
    
    public ColaL(){
        Inicio=null;
        Final=null;
        cantElementos=0;
    }
    
    public boolean esVacia(){
        return Inicio==null;
    }
    
    public boolean esLleno(){
        Nodo aux=new Nodo();
        return aux==null;
    }
    
    public int get(){
        return Inicio.getData();
    }
    
    public void encolar(int elemento){
        if (esLleno()) {
            System.out.println("Error ColaL llena.");
            System.exit(1);
        }        
        
        Nodo aux=new Nodo(elemento);
        
        if (esVacia()) 
        {
            Inicio=Final=aux;
        }else
        {
            Final.setLink(aux);
            Final=aux;
        }
        cantElementos++;
    }
    
    public int decolar(){
        //LAS FUNCIONES NO LLEVAN PRECONDICION
        //SI ESTA VACIA CONTROLAR ESA PRECONDICION AFUERA EN EL FORMULARIO
        int x=Inicio.getData();
        if (Inicio==Final) {
                Inicio=Final=null;
            }else{
                Inicio=Inicio.getLink();
            }
        cantElementos--;
        return x;
    }
    
    public boolean esEscaleraAsc(){        
        Nodo aux=Final;
        Nodo auxi=Inicio;
        
        int x=decolar();
        
        while(!esVacia()){
            
            //if (!esVacia()) {//valida para q no haya overflow y asi pueda comparar
                int y=decolar();
                if (y<x) {
                return false;                
                }
                x=y;
            //}            
        }
        Final=aux;
        Inicio=auxi;
        return true;
    }
    
    
    public boolean esEscaleraDesc(){        
        Nodo aux=Final;
        Nodo auxi=Inicio;
        
        int x=decolar();
        
        while(!esVacia()){            
                        
            //if (!esVacia()) {//valida para q no haya overflow y asi pueda comparar
                int y=decolar();
                if (y>x) {
                return false;                
                }
                x=y;
            //}            
        }
        Final=aux;
        Inicio=auxi;
        return true;
    }
    
    @Override
    public String toString(){
        String s="ColaL { ";
        Nodo i=Inicio;
        Nodo f=Final;
        while(!esVacia()){
            s=s+decolar()+" ";
        }
        Inicio=i;
        Final=f;
        return s+"}";
    }
    
    public void invertirDe2(){
        invertirRDe2(Inicio);
    }
    
    public void invertirRDe2(Nodo ini) {
        if (!esVacia()) {
            int x=decolar();
            int y=decolar();
            invertirR(Inicio);            
            encolar(y);
            encolar(x);           
        }
    }
    
    public static void main(String[] args){
        ColaL c=new ColaL();
        c.encolar(10);
        c.encolar(9);
        c.encolar(8);       
        c.encolar(7);
        c.encolar(5);       
        c.encolar(7);
        System.out.println(c);
        c.decolar();
        c.decolar();
        c.encolar(4);
        c.decolar();
        System.out.println(c);
    }
    
    public void invertir(){
        invertirR(Inicio);
    }
    
    public void invertirR(Nodo ini){
        if (!esVacia()) {
            int x=decolar();
            invertirR(Inicio);
            encolar(x);
        }
    }
    
}
