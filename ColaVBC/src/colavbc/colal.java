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
public class colal {
    int cant;
    Nodo inicio;
    Nodo fin;
    public colal(){
        inicio=null;
        fin=null;
        cant=0;
    }
    public boolean vacia()
    {
        return inicio==null;
    }
    public boolean llena(){
        Nodo aux=new Nodo();
        return aux==null;
    }
    public int get()
    {
        return inicio.getDato();
    }
    public void encolar(int ele){
        if(llena()){
            System.err.println("ERROR COLA LLENA");
        }else{
            Nodo p=new Nodo(ele);
            if(vacia()){
                inicio=p;
                fin=p;
            }else{
                fin.setEnlace(p);
                fin=p;
            }
            cant++;
        }
    }
    public int decolar(){
        int x=inicio.getDato();
        if(inicio==fin){
            inicio=null;
            fin =null;
        }else{
            inicio=inicio.getEnlace();
            cant--;
          
        }
        return x;
    }

    @Override
    public String toString() {
        String s="cola  {";
        colal aux=this;
        int cant1=cant;
        while (cant1>0) {
            cant1--;
            s=s+aux.decolar()+";";
        }
        return s;
    }
    
    }

