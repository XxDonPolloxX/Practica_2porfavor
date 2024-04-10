import java.time.LocalTime;
public class Corredor {
    private String nombre;
    private int dorsal;
    private LocalTime tiempo;
    public Corredor(String nombre, int dorsal, LocalTime tiempo){
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
    public LocalTime getTiempo(){
        return tiempo;
    }
}
