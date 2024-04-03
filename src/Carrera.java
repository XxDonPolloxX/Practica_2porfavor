public class Carrera {
    private String nombre;
    private String poblacion;
    private String fecha;
    private float distancia;
    public Carrera(String nombre, String poblacion, String fecha, float distancia){
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.fecha = fecha;
        this.distancia = distancia;
    }

    public String getNombre() {
        return nombre;
    }
    public String getPoblacion(){
        return poblacion;
    }

    public String getFecha() {
        return fecha;
    }

    public float getDistancia() {
        return distancia;
    }
}
