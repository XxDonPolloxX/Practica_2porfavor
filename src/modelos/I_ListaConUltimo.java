package modelos;

import lineales.NodoLEG;

public interface I_ListaConUltimo<E> {
    public void insertar(NodoLEG<E> x);
    public void insertarFinal(NodoLEG<E> elemento);
    public String toString();
    public boolean eliminar(E elemento);
    public E recuperar(int i);
}
