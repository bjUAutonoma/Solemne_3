package solemne_3;
import java.util.Scanner;

public class Solemne_3 extends Listas {
    
    public static void main(String[] args) { //Inicio del Algoritmo
        Solemne_3 temp = new Solemne_3(); //Creación de objeto de la clase
        temp.menu(); //Llamada a método valid
    }
    public static final int input(){ //Toma de datos 'int' en menús
        try{
            int option;
            Scanner input = new Scanner(System.in);
            option = input.nextInt(); //Asignación por teclado a 'option'
            System.out.println(); //Salto de Línea
            return option;
        }
        catch (Exception InputMissmatchException){ //Opcion si no se ingresa un entero
            System.out.println("\nOPCION INVALIDA");
            return input();
        }
    }
    public static final String input_2(){ //Toma de datos 'String' en menús
        try{
            String option;
            Scanner input_2 = new Scanner(System.in);
            option = input_2.nextLine(); //Asignación por teclado a 'option'
            System.out.println(); //Salto de Línea
            return option;
        }
        catch (Exception InputMissmatchException){ //Opcion si no se ingresa un entero
            System.out.println("\nOPCION INVALIDA");
            return input_2();
        }
    }
    public void menu(){ //Menu Principal
        System.out.println("{BIENVENIDO AL GESTOR DE VUELOS}"
                + "\n"
                + "\n (1) Menu Vuelos"
                + "\n (2) Menu Pasajeros"
                + "\n (3) Proceso de Abordaje"
                + "\n (4) Finalizar");
        switch (input()) {
            case 1: //Menu Vuelos
                menu_flight();
                break;
            case 2: //Menu Pasajeros
                menu_passenger();
                break;
            case 3: //Proceso de Abordaje
                menu_approach();
                break;
            case 4: //Cierre del algoritmo
                System.exit(0);
                break;
            default: //Opcion fuera de rango
                System.out.println("OPCION INVALIDA\n");
                menu();
                break;
        }
    }
    
    Lista_Vuelos lista_vuelos = new Lista_Vuelos();
    
    public void menu_flight(){ //Menu de Vuelos
        System.out.println("MENU VUELOS:"
                + "\n"
                + " \n(1) Crear Vuelo"
                + " \n(2) Editar Vuelo"
                + " \n(3) Eliminar Vuelo (no se puede eliminar si hay pasajeros)"
                + " \n(4) Mostrar Vuelos"
                + " \n(5) Volver al Menu Principal");
        switch (input()){
            case 1: //Crear Vuelos
                System.out.println("Ingrese el destino:");
                String destiny = input_2();
                System.out.println("Ingrese el horario:");
                int hour = input();
                System.out.println("Ingrese el nombre del vuelo:");
                String name = input_2();
                Vuelos vuelo = new Vuelos(destiny,hour,name);
                System.out.println("Se ha creado el vuelo:");
                vuelo.show_flight();
                lista_vuelos.add_flight(vuelo);
                //Falta metodo para guardar los vuelos
                break;
            case 2: //Editar Vuelo
                System.out.println("Ingrese el nombre del vuelo a editar:");
                lista_vuelos.edit_flight(input_2());
                break;
            case 3: //Eliminar Vuelo (no se puede eliminar si hay pasajeros)
                System.out.println("Igrese nombre del vuelo a eliminar:");
                lista_vuelos.delete_flight(input_2());
                break;
            case 4: //Mostrar Vuelos
                lista_vuelos.show_flights();
                break;
            case 5: //Volver al Menu Principal
                menu();
                break;
            default: //Opcion fuera de rango
                System.out.println("OPCION INVALIDA\n");
                break;
        }
        menu_flight();
    }
    
    Listas lista_pasajeros = new Listas();
    
    public void menu_passenger(){ //Menu Pasajeros
        System.out.println("MENU PASAJEROS:"
                + "\n"
                + " \n(1) Crear Pasajero"
                + " \n(2) Editar Pasajero"
                + " \n(3) Eliminar pasajero"
                + " \n(4) Asociar Pasajero a Vuelo"
                + " \n(5) Lista de Pasajeros en un Vuelo"
                + " \n(6) Volver al Menu Principal");
        switch (input()){
            case 1: //Crear Pasajero
                System.out.println("Ingrese el ID:");
                String id = input_2();
                System.out.println("Ingrese el nombre:");
                String name = input_2();
                System.out.println("Ingrese la nacionalidad:");
                String nation = input_2();
                System.out.println("Ingrese el asiento:");
                int seat = input();
                Pasajeros pasajero = new Pasajeros(id, name, nation, seat);
                System.out.println("Se ha creado el pasajero:");
                pasajero.show_passenger();
                lista_pasajeros.add_passenger(pasajero);
                break;
            case 2: //Editar Pasajero
                System.out.println("Ingrese el nombre del pasajero que desea editar:");
                lista_pasajeros.edit_passengers(input_2());
                break;
            case 3: //Eliminar Pasajero
                System.out.println("Ingrese el nombre del pasajero que desea eliminar:");
                lista_pasajeros.delete_passenger(input_2());
                break;
            case 4: //Asociar Pasajero a Vuelo
                break;
            case 5: //Lista de Pasajeros en un Vuelo
                break;
            case 6: //Volver al Menu Principal
                menu();
                break;
            default: //Opcion fuera de rango
                System.out.println("OPCION INVALIDA\n");
                break;
        }
        menu_passenger();
    }
    public void menu_approach(){ //Menu de Abordaje
        System.out.println("MENU ABORDAJE:"
                + "\n"
                + " \n(1) Iniciar Abordaje"
                + " \n(2) Volver al Menu Principal");
        switch (input()){
            case 1: //Iniciar Abordaje
                System.out.println("A que vuelo desea ingresar los pasajeros?");
                abordaje(input_2());
                break;
            case 2: //Volver al Menu Principal
                menu();
                break;
            default: //Opcion fuera de rango
                System.out.println("OPCION INVALIDA\n");
                break;
        }
        menu_approach();
    }
}