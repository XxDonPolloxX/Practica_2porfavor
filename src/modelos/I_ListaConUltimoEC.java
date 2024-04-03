package modelos;

import lineales.FalloEnOperacion;

public interface I_ListaConUltimoEC<E extends Number> {
    public void borrarMinimo();
    public void moverCabeza() throws FalloEnOperacion;
    public void insertarCentinelas();
}
