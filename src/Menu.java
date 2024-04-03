import lineales.ArrayCola;

import java.util.Scanner;

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
        int dorsal, hora, min, seg;
        System.out.println("Introduzca el nombre del corredor que desea registrar:");
        sc.nextLine();
        nombre = sc.nextLine();
        System.out.println("Introduzca el dorsal del corredor:");
        dorsal = sc.nextInt();
        sc.nextLine();
        System.out.println("Introduzca el tiempo que tardo el corredor en terminar la carrera, en formato (HH:MM:SS):");
        tiempoaux = sc.nextLine();
        String[] tiempoArray = tiempoaux.split(":");
        hora = Integer.parseInt(tiempoArray[0]);
        min = Integer.parseInt(tiempoArray[1]);
        seg = Integer.parseInt(tiempoArray[2]);
        String tiempo = hora + ":" + min + ":" + seg;
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
        Corredor c;
        aux.encolar(corredores.primero());
        while(!corredores.esVacia()){
            c = corredores.desencolar();
            if(c.getTiempo()>(aux.primero().getTiempo())){
                aux.encolar(c);
                for(int i=0; i<aux.getTallaActual()-1;i++){
                    aux.encolar(aux.desencolar());
                }
            }
            else{

            }


        }
    }

}
