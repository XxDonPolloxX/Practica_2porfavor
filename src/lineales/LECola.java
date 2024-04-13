package lineales;

import modelos.Cola;

public class LECola<E> extends LEGConUltimo<E> implements Cola<E> {

    public void encolar(E x) {
        super.insertarFinal(new NodoLEG<E>(x));

    }

    public E desencolar() {
        E dato;
        dato = getPrimero().dato;
        eliminar(primero.getDato());
        return dato;
    }

    public E primero() {
        return primero.getDato();
    }

    public boolean esVacia() {
        if(primero==null || ultimo==null){
            return true;
        }
        else {
            return false;
        }

    }
}
