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
public class Nodo {
    int dato;
      Nodo enlace;
    public Nodo(int dato) {
        this.dato = dato;
        enlace=null;
    }

    public Nodo() {
    enlace=null;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public void setEnlace(Nodo enlace) {
        this.enlace = enlace;
    }

    public int getDato() {
        return dato;
    }

    public Nodo getEnlace() {
        return enlace;
    }
  
    
    
}
