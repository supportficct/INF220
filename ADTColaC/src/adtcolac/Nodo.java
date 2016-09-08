
package adtcolac;

/**
 *
 * @author Eliot Humerez 
 *  Sígueme en Twitter @EliotGHumerez
 *  En Facebook www.facebook.com/ehumerez
 * 
 */

public class Nodo {
    private int Data;
    private Nodo Link;
    
    public Nodo(){
        Link=null;
    }
    
    public Nodo(int elemento){
        this.Data=elemento;
        this.Link=null;        
    }

    public int getData() {
        return Data;
    }

    public void setData(int Data) {
        this.Data = Data;
    }

    public Nodo getLink() {
        return Link;
    }

    public void setLink(Nodo Link) {
        this.Link = Link;
    }
    
    
    
}
