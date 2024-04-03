package modelos;

public interface Cola<E> {
    void encolar(E x);
    E desencolar();
    E primero();
    boolean esVacia();
}
