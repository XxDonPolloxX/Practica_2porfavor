package lineales;

import modelos.Cola;

import java.lang.reflect.Array;

public class ArrayCola<E> implements Cola<E> {
    protected E elArray[];
    protected int fin, primero, tallaActual;
    protected static final int CAPACIDAD_POR_DEFECTO = 200;
    public ArrayCola(){
        elArray=(E[]) new Object[CAPACIDAD_POR_DEFECTO];
        tallaActual = 0;
        primero = 0;
        fin = -1;

    }
    public void encolar(E x){
        if(tallaActual == elArray.length){
            duplicarArray();
        }
        fin = incrementa(fin);
        elArray[fin]=x;
        tallaActual++;
    }
    public E desencolar(){
        E elPrimero = elArray[primero];
        primero = incrementa(primero);
        tallaActual--;
        return elPrimero;
    }
    public E primero(){
        return elArray[primero];
    }
    public boolean esVacia(){
        return (tallaActual == 0);
    }
    private int incrementa(int indice){
        if(++indice == elArray.length){
            indice = 0;
        }
        return indice;
    }
    public String toString() {
        String res = "";
        int aux = primero;
        for(int i = 0; i < tallaActual;i++, aux = incrementa(aux)){
            res += elArray[aux] + "";
        }
        return res;

    }
    public void duplicarArray(){
        E nuevo[] = (E[]) new Object[elArray.length*2];
        for(int i = 0; i<tallaActual; i++, primero = incrementa(primero)){
            nuevo[i] = elArray[primero];
        }
        elArray = nuevo;
        primero = 0;
        fin = tallaActual -1;
    }
}
