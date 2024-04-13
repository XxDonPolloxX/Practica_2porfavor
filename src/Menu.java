import lineales.ArrayCola;
import lineales.LECola;
import modelos.Cola;

import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.util.Scanner;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Menu {
    private Scanner sc = new Scanner(System.in);
    private Cola<Corredor> corredores;
    private Carrera carrera;
    private int opcion;
    public Menu(int opcion){
        corredores=comprobarOpcion();
    }
    public Cola<Corredor> comprobarOpcion(){
        Cola<Corredor> cola;
        if(opcion==0){
            cola = new ArrayCola<Corredor>();
        }
        else{
            cola = new LECola<Corredor>();
        }
        return cola;
    }

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
        Cola<Corredor> aux;
        aux = comprobarOpcion();
        System.out.println("Introduzca el nombre del corredor a buscar: ");
        nombre = sc.nextLine();
        while(!corredores.esVacia()){
            c = corredores.desencolar();
            if(c.getNombre().equals(nombre)){
                System.out.println("INFORMACION DE UN CORREDOR");
                System.out.println("Dorsal \t Corredor/a \t Tiempo Corredor/a");
                System.out.println(c.getDorsal() + "\t" + c.getNombre() + "\t" + c.getTiempo());
                aux.encolar(c);
            }
        }
        corredores = aux;
    }
    public void listadoTiempCarrera(){
        Corredor c;
        System.out.println("LISTADO DE TIEMPOS DE CARRERA (sin ordenar)");
        System.out.println("Dorsal \t Corredor/a \t Tiempo Corredor/a");
        System.out.println("--------------------------------------------");
        Cola<Corredor> aux = comprobarOpcion();
        while (!corredores.esVacia()){
            c = corredores.desencolar();
            System.out.println(c.getDorsal() + "\t" + c.getNombre() + "\t" + c.getTiempo());
            aux.encolar(c);
        }
        corredores = aux;
    }
    public void clasificaion(){
        Cola<Corredor> aux = comprobarOpcion();
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
        System.out.println(toStringClasificacion(aux));
    }
    public String toStringClasificacion(Cola<Corredor> aux){

        Corredor c, primero;
        int segundos, segundosPrimero;
        LocalTime tiempoCorredor;
        primero=aux.primero();
        String res="";
        segundosPrimero=pasarASegundos(primero.getTiempo());
        while(!aux.esVacia()){
            c=aux.desencolar();
            segundos=pasarASegundos(c.getTiempo());
            segundos=segundos-segundosPrimero;
            tiempoCorredor=pasarATiempo(segundos);
            res=res+c.getNombre()+"\t"+c.getDorsal()+"\t"+tiempoCorredor+"\n";

        }
        return res;
    }
    public void resDatCarrera(){
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("\t\t\t CARRERA");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("Carrera:   " + carrera.getNombre());
        System.out.println("Población: " + carrera.getPoblacion());
        System.out.println("Fecha:     " + carrera.getFecha());
        System.out.println("Distancia: " + carrera.getDistancia());
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("\t\t\t RESUMEN FINAL");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("-Numero de corredores participantes en la carrera:" + numCorredores());
        Corredor ganador = buscarGanador();
        System.out.println("\n-Vencedor/a de la carrera: " + ganador.getNombre() + "(Dorsal " + ganador.getDorsal() + ")  -->  Tiempo total: " + ganador.getTiempo());
        System.out.println("\n-Tiempo medio empleado por los corredores: " + tiempoMedio());
    }
    //Crea un metodo que devuelva el numero total de corredores
    public int numCorredores(){
        int num=0;
        Corredor c;
        Cola<Corredor> aux = comprobarOpcion();
        while(!corredores.esVacia()){
            c = corredores.desencolar();
            num++;
            aux.encolar(c);
        }
        corredores = aux;
        return num;
    }
    public Corredor buscarGanador(){
        Corredor c, ganador;
        Cola<Corredor> aux = comprobarOpcion();
        aux.encolar(corredores.desencolar());
        ganador = aux.primero();
        while(!corredores.esVacia()){
            c = corredores.desencolar();
            if(c.getTiempo().compareTo(ganador.getTiempo())<0){
                aux.encolar(c);
                ganador = c;
                do{
                    aux.encolar(aux.desencolar());
                }while(aux.primero()!=ganador);
            }
            else{
                aux.encolar(c);
            }
        }
        while(aux.primero()!=ganador){
            aux.encolar(aux.desencolar());
        }
        corredores = aux;
        return ganador;
    }
    public LocalTime tiempoMedio(){
        Corredor c;
        int numCorredores = numCorredores();
        int segundosTotales = 0;
        Cola<Corredor> aux = comprobarOpcion();
        while(!corredores.esVacia()){
            c = corredores.desencolar();
            segundosTotales += pasarASegundos(c.getTiempo());
            aux.encolar(c);
        }
        corredores = aux;
        int segundosMedios = segundosTotales / numCorredores;
        return pasarATiempo(segundosMedios);
    }
    public int pasarASegundos(LocalTime t){
        int seg;
        seg=t.getSecond()+t.getMinute()*60+t.getHour()*3600;
        return seg;
    }
    public LocalTime pasarATiempo(int segundos){
        LocalTime t;
        String horas, minutos, segundosString;
        String tiempoaux;
        horas=String.format("%02d", segundos/3600);
        segundosString=String.format("%02d",segundos%60);
        minutos=String.format("%02d",(segundos/60)%60);
        tiempoaux=horas+":"+minutos+":"+segundosString;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        t = LocalTime.parse(tiempoaux, formatter);
        return t;
    }


}
