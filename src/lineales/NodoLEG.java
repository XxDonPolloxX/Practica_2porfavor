package lineales;

public class NodoLEG <E>{
    protected E dato;
    protected NodoLEG<E> siguiente;

    public NodoLEG(E dato){
        this.dato = dato;
        this.siguiente = null;
    }

    public NodoLEG(E dato, NodoLEG<E> siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }
    public E getDato(){return dato;}

}

