package adtpilac;

/**
 *
 * @author Eliot Humerez
 */
public class ColaV {

    
    //ATRIBUTOS
    private int q[];
    private int Inicio;
    private int Final;
    
    //CONSTRUCTOR
    public ColaV(int cantidad){
        q=new int[cantidad];
        Inicio=Final=-1;
    }
    @Override
    public String toString(){
        String s="ColaV { ";
        int aux=Final;
        int auxi=Inicio;
        while(!esVacia()){
            s=s+decolar()+" ";
        }
        Final=aux;
        Inicio=auxi;
        return s+"}";
    }
    
    //MÉTODOS
    public boolean esVacia(){
        return (Inicio==-1);
    }
    
    
    public int getLength(){
        return q.length;
    }
    public boolean esLlena(){
        return (Final+1%q.length==Inicio);
    }
    
    public int Get(){
        return q[Inicio];
    }
    
    public void encolar(int elemento){
        //pre: No estar Llena
        if (esLlena()) {
            System.out.println("Error Cola llena");
            System.exit(1);
        }
        if (esVacia()) {
            Inicio=Final=0;
        }else{
            Final=(Final+1)%q.length;
        }

        q[Final]=elemento;
    }
    
    public int decolar(){
        int x=q[Inicio];
        if (Inicio==Final) {
            //Hay un elemento
            Inicio=Final=-1;
        }else{
            Inicio=(Inicio+1)%q.length;
        }
        return x;
    }
    
    public boolean esEscaleraAsc(){        
        int aux=Final;
        int auxi=Inicio;
        
        int x=decolar();
        
        while(!esVacia()){
            
            //if (!esVacia()) {//valida para p no haya overflow y asi pueda comparar
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
        int aux=Final;
        int auxi=Inicio;
        
        int x=decolar();
        
        while(!esVacia()){            
                        
            //if (!esVacia()) {//valida para p no haya overflow y asi pueda comparar
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
    
    
    public void invertirDe2(){
        invertirRDe2(Inicio);
    }
    
    public void invertirRDe2(int ini) {
        if (!esVacia()) {
            int x=decolar();
            int y=decolar();
            invertirR(Inicio);            
            encolar(y);
            encolar(x);
            
        }
    }
    
    public void intercambiarMitades(){
        ColaV aux1=new ColaV(q.length);
        int mitad=cantElementosCola()/2;
        while(cantElementosCola()>mitad){
            int x=decolar();
            aux1.encolar(x);             
        }
        while(!aux1.esVacia()){
            encolar(aux1.decolar());
        }
    }
    //Este metodo devuelve 1 si inicio > final; 0 si Final >=inicio de lo contrario 2
    public int inicioFinal(){
        int i=Inicio;
        int f=Final;
        int cant=0;
        if (i>f) {
            cant=(q.length-(i-f))+1;
            return 1;
        }else{
            if(f>=i){
                cant=(f-i)+1;
                return 0;
            }
        }
        return 2;
    }
    
    public int cantElementosCola(){
        int i=Inicio;
        int f=Final;
        int cant=0;
        if (i>f) {
            cant=(q.length-(i-f))+1;
        }else{
            if(f>=i){
                cant=(f-i)+1;
            }
        }
        return cant;
    }
    
    public static void main(String[] args){
        ColaV q=new ColaV(6);
        ColaV p=new ColaV(6);
        q.encolar(1);
        q.encolar(2);
        q.encolar(3);
        q.encolar(4);
        q.encolar(5);
        q.encolar(6);        
        System.out.println("Q "+q);
        p.encolar(7);
        p.encolar(8);
        p.encolar(9);
        p.encolar(10);
        p.encolar(11);
        p.encolar(12);
        System.out.println("P "+p);
        System.out.println(p.cantElementosCola());
        q.cambiar(p,q);
        System.out.println("Q "+q);
        System.out.println("P "+p);
    }
    
    public void cambiar(ColaV p, ColaV q) {
        if (p.cantElementosCola()%2==0 && q.cantElementosCola()%2==0) {
        int mitadp=p.cantElementosCola()/2;
        int mitadq=q.cantElementosCola()/2;
        ColaV auxp=new ColaV(p.getLength());
        ColaV auxq=new ColaV(q.getLength());
        while(p.cantElementosCola()>mitadp){
            auxp.encolar(p.decolar());            
        }
        while(q.cantElementosCola()>mitadq){
            auxq.encolar(q.decolar());            
        }
        while(!p.esVacia()){
            auxq.encolar(p.decolar());
            auxp.encolar(q.decolar());
        }        
        p.q=auxq.q;
        q.q=auxp.q;
        p.Inicio=auxq.Inicio;
        p.Final=auxq.Final;
        q.Inicio=auxp.Inicio;
        q.Final=auxp.Final;     
        }        
    }
    
    public void invertir(){
        invertirR(Inicio);
    }
    
    public void invertirR(int ini) {
        if (!esVacia()) {
            int x=decolar();
            invertirR(Inicio);
            encolar(x);
        }
    }
    
    
    
}
