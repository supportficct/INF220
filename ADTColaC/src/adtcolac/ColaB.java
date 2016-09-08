package adtcolac;

/**
 *
 * @author Eliot Humerez
 */
public class ColaB {
   private VectorBits q;
   private int Inicio;
   private int Final;
   
   public ColaB(int cantElemento,int cantBits){
       q=new VectorBits(cantElemento, cantBits);
       Inicio=Final=0;
   }
   
   public boolean esVacia(){
       return Inicio==0;
   }
   
   public boolean esLlena(){
       return Final+1%q.getCantElementos()==Inicio;
   }
   
   public int get(){
       return q.Sacar(Inicio);
   }
   
   public void encolar(int elemento){
       if (esLlena()) {
           System.out.println("Error Cola llena.");
           System.exit(1);
       }
       if (esVacia()) {
           Inicio=Final=1;
       }else{
           Final=Final+1%q.getCantElementos();
       }
       q.insertar(elemento, Final);
   }
   
   public int decolar(){
       int x=q.Sacar(Inicio);
       if (Inicio==Final) {
           Inicio=Final=0;
       }else{
           Inicio=Inicio+1%q.getCantElementos();
       }
       return x;
   }
   @Override
   public String toString(){
       String s="ColaB { ";
       int i=Inicio;
       int f=Final;
       while(!esVacia()){
           s=s+decolar()+" ";
       }
       Inicio=i;Final=f;
       return s+"}";
   }
   
   
   public boolean esEscaleraAsc(){        
        int aux=Final;
        int auxi=Inicio;
        
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
        int aux=Final;
        int auxi=Inicio;
        
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
    
   public static void main(String[] args){
       ColaB c=new ColaB(10, 8);
       c.encolar(10);
       c.encolar(9);
       c.encolar(8);
       c.encolar(7);
       c.encolar(6);
       c.encolar(5);
       System.out.println(c);
       c.invertirDe2();
       System.out.println(c);
   }

    public void invertir() {
         invertirR(Inicio);
    }
   
    private void invertirR(int ini){
        if (!esVacia()) {
            int x=decolar();
            invertirR(Inicio);
            encolar(x);
        }
    }
   
}
