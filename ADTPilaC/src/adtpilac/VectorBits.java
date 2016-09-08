
package adtpilac;

/**
 *
 * @author Eliot Humerez
 * 
 */

class VectorBits {
    private int v[];
    private int cantElementos;
    private int cantBits;
    
    public VectorBits(int cantElementos,int cantBits){
        int nroBits=cantElementos*cantBits;
        int nroEnt=nroBits/32;
        if (nroBits%32!=0) {
            nroEnt++;
        }
        v=new int[nroEnt];
        this.cantElementos=cantElementos;
        this.cantBits=cantBits;
    }
    
   public void insertar(int elemento,int posicion){
       int x = elemento;
        int z = (int) (Math.pow(2, cantBits)-1);
        int NE = nroEntero(posicion);
        int NB = nroBit(posicion);
        z = z << NB;
        z = ~z;
        v[NE] = v[NE] & z;
        elemento = elemento << NB;
        v[NE] = v[NE] | elemento;
        if ((NB + cantBits) > 32) {
            int BitF = ((NB + cantBits)-32);
            x = x >>> (cantBits - BitF);
            z = (int) (Math.pow(2, cantBits)-1);
            z = z >>> (cantBits - BitF);
            z = ~z;
            v[NE+1] = v[NE+1] & z;
            v[NE+1] = v[NE+1] | x;
        }
   }

    public int getCantElementos() {
        return cantElementos;
    }

    public void setCantElementos(int cantElementos) {
        this.cantElementos = cantElementos;
    }

    public int getCantBits() {
        return cantBits;
    }

    public void setCantBits(int cantBits) {
        this.cantBits = cantBits;
    }

    private int nroEntero(int posicion) {
        return ((posicion-1)*cantBits)/32;
    }

    private int nroBit(int posicion) {
        return (((posicion-1)*cantBits)%32);
    }
    
    public int Sacar(int pos){
        int z = (int) (Math.pow(2, cantBits)-1);
        int NE = nroEntero(pos);
        int NB = nroBit(pos);
        z = z << NB;
        z = z & v[NE];
        z = z >>> NB;
        if ((NB + cantBits) > 32) {
            int BitF = ((NB + cantBits)-32);
            int z1 = (int) (Math.pow(2, cantBits)-1);
            z1 = z1 >>> (cantBits - BitF);
            z1 = z1 & v[NE+1];
            z1 = z1 << (cantBits - BitF);
            z = z | z1;
        }
        return z;
    }
    
    @Override
    public String toString() {
        String s = "[";
        for (int i = 1; i <= cantElementos; i++) {
            s = s + Sacar(i)+",";
        }
        s = s.substring(0, s.length()-1);
        s = s + "]";
        return s;
    } 
    
    public static void main(String[] args){
        VectorBits v=new VectorBits(4, 6);
        v.insertar(4, 1);
        v.insertar(64, 2);
        v.insertar(3, 3);
//        v.insertar(16, 3);
        System.out.println(v);
    }
    
    
}
