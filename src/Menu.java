import lineales.ArrayCola;

import java.util.Scanner;

public class Menu {
    private Scanner sc = new Scanner(System.in);
    private ArrayCola corredores = new ArrayCola<Carrera>();
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
        System.out.println("Introduzca el nombre del corredor que desea registrar:");
        String nombre = sc.nextLine();
        System.out.println("Introduzca el dorsal del corredor:");
        int dorsal = sc.nextInt();
        System.out.println("Introduzca el tiempo que tardo el corredor en terminar la carrera, en formato (HH:MM:SS):");
        String tiempoaux = sc.nextLine();
        String[] tiempoArray = tiempoaux.split(":");
        int hora = Integer.parseInt(tiempoArray[0]);
        int min = Integer.parseInt(tiempoArray[1]);
        int seg = Integer.parseInt(tiempoArray[2]);
        String tiempo = hora + ":" + min + ":" + seg;
        Corredor corredor = new Corredor(nombre, dorsal, tiempo);
    }
    
}
