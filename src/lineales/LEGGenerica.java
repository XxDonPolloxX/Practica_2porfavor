package lineales;

public class LEGGenerica <E>{
    protected NodoLEG<E> primero;

    public LEGGenerica(){
        primero = null;
    }

    public void insertar(NodoLEG<E> x){
        x.siguiente = primero;
        primero = x;


    }

    public void insertarFinal(NodoLEG<E> x){
        NodoLEG<E> aux = primero;
        if(aux == null){
            primero = x;
        }
        else{
            while (aux.siguiente != null){
                aux = aux.siguiente;
            }
            aux.siguiente = x;
        }
    }
    public String toString(){
        String res = "";
        for (NodoLEG<E> aux = primero;null != aux; aux = aux.siguiente){
            res += aux.getDato().toString() + "\n";
        }
        return res;
    }
    public boolean eliminar(E x){
        NodoLEG<E> aux = primero, ant = null;
        boolean res = false;
        if (aux == null){
            System.out.println("Lista vacia");
        }else {
            while (!aux.getDato().equals(x)){
                ant = aux; aux = aux.siguiente;
            }
            if (aux != null){
                res = true;
                if (ant == null){
                    primero = aux.siguiente;
                }else {
                    ant.siguiente = aux.siguiente;
                }
            }
        }
        return res;
    }
    public E recuperar(int i){
        NodoLEG<E> aux;
        int j;
        for (aux = primero, j=0; j<i; aux=aux.siguiente, j++){;}
        return aux.dato;
    }
}