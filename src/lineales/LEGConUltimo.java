package lineales;

import modelos.I_ListaConUltimo;

public class LEGConUltimo<E> extends LEGGenerica<E> implements I_ListaConUltimo<E> {
    protected NodoLEG<E> ultimo;

    public LEGConUltimo() {
        super();
        ultimo = null;
    }

    public NodoLEG<E> getUltimo() {
        return ultimo;
    }

    public NodoLEG<E> getPrimero() {
        return primero;
    }

    public void insertar(NodoLEG<E> x) {
        if (primero == null) {
            primero = x;
            ultimo = x;

        } else {
            super.insertar(x);
        }

    }

    public void insertarFinal(NodoLEG<E> x) {
        if (primero == null) {
            primero = x;
            ultimo = x;

        } else {
            ultimo.siguiente = x;
            ultimo = x;
        }
    }

    public String toString() {
        return null;
    }

    public boolean eliminar(E elemento) {
        return super.eliminar(elemento);
    }

    public E recuperar(int i) {
        return super.recuperar(i);
    }

    public String toStringIterativo() {
        String res = "";
        NodoLEG<E> aux = primero;
        while (aux != null) {
            res += aux.dato.toString() + "\n";
            aux = aux.siguiente;
        }
        return res;
    }

    public String toStringInversoIterativo() {
        String res = "";
        NodoLEG<E> aux = primero;
        while (aux != null) {
            res = aux.dato.toString() + "\n"+ res;
            aux = aux.siguiente;
        }
        return res;
    }

    private String toStringRecursivo(NodoLEG<E> aux) {
        String res = "";
        res = aux.dato.toString();
        if (!aux.equals(ultimo)) {
            res = res + "\n" + toStringRecursivo(aux.siguiente);
        }
        return res;
    }
    public String toStringRecursivo(){
        String res;
        if(primero==null){
            res="Lista vacía";
        }
        else{
            res=toStringRecursivo(primero);
        }
        return res;
    }
    private String toStringInversoRecursivo(NodoLEG<E> aux) {
        String res = "";
        res = aux.dato.toString();
        if (!aux.equals(ultimo)) {
            res = toStringInversoRecursivo(aux.siguiente) + "\n" + res;
        }
        return res;
    }
    public String toStringInversoRecursivo(){
        String res;
        if(primero==null){
            res="Lista vacía";
        }
        else{
            res=toStringInversoRecursivo(primero);
        }
        return res;
    }
}