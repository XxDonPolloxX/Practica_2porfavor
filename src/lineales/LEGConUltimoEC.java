package lineales;
//importa una libreria comparable

import modelos.I_ListaConUltimoEC;


public class LEGConUltimoEC<E extends Number> extends LEGConUltimo<E> implements I_ListaConUltimoEC<E> {
    public LEGConUltimoEC() {
        super();
    }

    public void borrarMinimo() {
        if (primero == null) {
            System.out.println("Lista vacía");
        }
        else {
            NodoLEG<E> aux = primero, ant = null, min = primero, antMin = null;
            while (aux != null) {
                if ((int)aux.getDato() < (int)min.getDato()) {
                    min = aux;
                }
                aux = aux.siguiente;
            }
            if(!eliminar(min.getDato())){
                System.out.println("Elemento no borrado");
            }
        }
    }

    public void moverCabeza() throws FalloEnOperacion {
        NodoLEG<E> aux;
        if ((int)primero.getDato() < (int)ultimo.getDato()) {
            aux = primero.siguiente;
            ultimo.siguiente = primero;
            ultimo = primero;
            ultimo.siguiente = null;
            primero = aux;
        } else {
            throw new FalloEnOperacion();
        }
    }

    public void insertarCentinelas() {
        NodoLEG<E> aux = null;
        if ((int)ultimo.getDato() % 2 == 0 ){
            aux = primero;
            do{
                if (((int)aux.getDato() % 2 == 0) && ((int)aux.siguiente.getDato()>=0) && ((int)aux.getDato() >=0)) {
                    NodoLEG<E> centinela = new NodoLEG<E>((E) new Integer(-12));
                    centinela.siguiente = aux.siguiente;
                    aux.siguiente = centinela;
                    aux=centinela;
                }
            aux=aux.siguiente;}while (aux!=ultimo);
            NodoLEG<E> centinela = new NodoLEG<E>((E) new Integer(-12));
            if((int)ultimo.getDato()>=0){
                ultimo.siguiente = centinela;
                ultimo = centinela;
            }

        }
    }
    public boolean insertarCentinelasSinUltimo(NodoLEG<E> aux){

        if(aux.siguiente==null){
            if((int)aux.getDato()%2==0 && (int)aux.getDato()>=0){
                NodoLEG<E> centinela = new NodoLEG<E>((E) new Integer(-12));
                aux.siguiente=centinela;
                ultimo = centinela;
                return true;
            }
            else{
                return false;
            }
        }
        else{
            if(insertarCentinelasSinUltimo(aux.siguiente)){
                if((int)aux.getDato()%2==0 && (int)aux.getDato()>=0 && (int)aux.siguiente.getDato()>=0){
                    NodoLEG<E> centinela = new NodoLEG<E>((E) new Integer(-12));
                    centinela.siguiente=aux.siguiente;
                    aux.siguiente=centinela;
                }
                return true;
            }
            else {
                return false;
            }
        }

    }

}
