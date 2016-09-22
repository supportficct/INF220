package bitwise;
/**
 * Ayudantia 1/2016 Eddy Escalante
 */
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

public class Bitwise {

    private byte x;

    public Bitwise(byte z) {
        this.x = 0; //// [0,0,0,0,0,0,0,0]
    }

    public void setbit1(byte pos) {
        byte z = (byte) Math.pow(2, pos - 1); /// (2^(3-1)) = (2^2) = 4
        x = (byte) ((byte) x | z); /// [0,0,0,0,0,0,0,0] | [0,0,0,0,0,1,0,0] = [0,0,0,0,0,1,0,0]
    }

    public void setbit0(byte pos) {
        byte z = (byte) Math.pow(2, pos - 1); /// 2^6 = 
        z = (byte) ~z;
        x = (byte) ((byte) x & z);
    }

    public void setbit(byte pos, int bit) {
        if (bit == 0) {
            setbit0(pos);
        } else {
            setbit1(pos);
        }
    }

    public int getbit(byte Nrobit) {
        byte z = (byte) Math.pow(2, Nrobit - 1);
        z = (byte) (z & x);
        if (z == 0) {
            return 0;
        } else {
            return 1;
        }

    }

    public void Add(int posicion) {
        if (0 <= posicion && posicion <= 7) {
            setbit((byte) posicion, 1);
        }
    }

    public void Suprimir(int posicion) {
        if (0 <= posicion && posicion <= 7) {
            setbit((byte) posicion, 0);
        }
    }
    
    @Override
    public String toString() {
        System.out.println("Class Bitwise de 8 bits \n");
        System.out.println("Bitwise = { [8] [7] [6] [5] [4] [3] [2] [1] }   ----> Posiciones");
        String m = "  bitwise { ";
        for (byte i = 8; i >= 1; i--) {
            m = m + "[" + getbit(i) + "] ";
        }
        return m + " }";
    }

    public static void main(String[] args) {

        byte zz = 0; ////[1.1.1.1.1.1.1]
        Bitwise b = new Bitwise(zz);
        System.out.println("----------------------BITWISE------------------------");

        byte bi = 3;
        b.setbit(bi, 1);
        
        b.setbit((byte) 7, 1);
        b.setbit((byte) 7, 0);

        b.Add(5);
        b.Add(4);
        b.Add(7);
        b.Suprimir(5);

        System.out.println("valor en 7 = " + b.getbit((byte) 7));

        String mostrar = b.toString();

        System.out.println(mostrar);

        System.out.println("----------------------BITWISE------------------------");
    }

}
