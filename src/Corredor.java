public class Corredor {
    private String nombre;
    private int dorsal;
    private String tiempo;
    public Corredor(String nombre, int dorsal, String tiempo){
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.tiempo = tiempo;
    }
    public String getNombre() {
        return nombre;
    }
    public int getDorsal(){
        return dorsal;
    }
    public String getTiempo(){
        return tiempo;
    }
}
