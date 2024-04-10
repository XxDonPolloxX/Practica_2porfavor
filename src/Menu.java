import lineales.ArrayCola;
import java.util.Scanner;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Menu {
    private Scanner sc = new Scanner(System.in);
    private ArrayCola<Corredor> corredores = new ArrayCola<Corredor>();
    private Carrera carrera;
    public void datosCarrera(){
        String nombre, poblacion, fecha;
        float distancia;
        System.out.println("Introduzca nombre de la carrera: ");
        nombre = sc.nextLine();
        System.out.println("Introduzca población de la carrera: ");
        poblacion = sc.nextLine();
        System.out.println("Introduzca fecha de la carrera: ");
        fecha = sc.nextLine();
        System.out.println("Introduzca distancia de la carrera: ");
        distancia = sc.nextFloat();
        carrera = new Carrera(nombre, poblacion, fecha, distancia);
    }

    public void regDatosCor(){
        String nombre, tiempoaux;
        LocalTime tiempo;
        int dorsal, hora, min, seg;
        System.out.println("Introduzca el dorsal del corredor:");
        dorsal = sc.nextInt();
        sc.nextLine();
        System.out.println("Introduzca el nombre del corredor que desea registrar:");
        nombre = sc.nextLine();
        System.out.println("Introduzca el tiempo que tardo el corredor en terminar la carrera, en formato (HH:MM:SS):");
        tiempoaux = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        tiempo = LocalTime.parse(tiempoaux, formatter);
        Corredor corredor = new Corredor(nombre, dorsal, tiempo);
        corredores.encolar(corredor);

    }
    public void mostrarDatosCorredor(){
        String nombre;
        Corredor c;
        ArrayCola<Corredor> aux = new ArrayCola<Corredor>();
        System.out.println("Introduzca el nombre del corredor a buscar: ");
        nombre = sc.nextLine();
        while(!corredores.esVacia()){
            c = corredores.desencolar();
            if(c.getNombre().equals(nombre)){
                System.out.println("INFORMACION DE UN CORREDOR");
                System.out.println("Dorsal \t Corredor/a \t Tiempo Corredor/a");
                System.out.println(c.getDorsal() + "\t" + c.getNombre() + "\t" + c.getTiempo());
            }
            aux.encolar(c);
        }
        corredores = aux;
    }
    public void listadoTiempCarrera(){
        Corredor c;
        System.out.println("LISTADO DE TIEMPOS DE CARRERA (sin ordenar)");
        System.out.println("Dorsal \t Corredor/a \t Tiempo Corredor/a");
        System.out.println("--------------------------------------------");
        ArrayCola<Corredor> aux = new ArrayCola<Corredor>();
        while (!corredores.esVacia()){
            c = corredores.desencolar();
            System.out.println(c.getDorsal() + "\t" + c.getNombre() + "\t" + c.getTiempo());
            aux.encolar(c);
        }
        corredores = aux;
    }
    public void clasificaion(){
        ArrayCola<Corredor> aux = new ArrayCola<Corredor>();
        Corredor c, minimo;
        aux.encolar(corredores.desencolar());
        minimo=aux.primero();
        while(!corredores.esVacia()){
            c = corredores.desencolar();
            if(c.getTiempo().compareTo(minimo.getTiempo())<=0){
                aux.encolar(c);
                minimo=c;
                do{
                    aux.encolar(aux.desencolar());
                }while(aux.primero()!=minimo);
            }
            else {
                if (c.getTiempo().compareTo(aux.primero().getTiempo()) >= 0) {
                    aux.encolar(c);
                }
                else {
                    aux.encolar(aux.desencolar());
                }
            }


        }
        while(aux.primero()!=minimo){
            aux.encolar(aux.desencolar());
        }
        corredores=aux;
        System.out.println(aux.toString());
    }

}
