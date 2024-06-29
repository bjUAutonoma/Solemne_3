package solemne_3;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Listas {
    
    public LinkedList<Pasajeros> pasajeros = new LinkedList<>();
    
    public void add_passenger(Pasajeros pasajero){
        pasajeros.add(pasajero);
    }
    public void show_passengers(){
        if (!pasajeros.isEmpty()){
            System.out.println("Los pasajeros son:\n");
            for (int i=0;i<pasajeros.size();i++){
                pasajeros.get(i).show_passenger();
            }
        }
    }
    public void edit_passengers(String name){
        if (!pasajeros.isEmpty()){
            for (int i=0;i<pasajeros.size();i++){
                if (pasajeros.get(i).get_nombre().equals(name)){
                    System.out.println("Que desea modificar?"
                            + "(1) ID"
                            + "(2) NOMBRE"
                            + "(3) NACIONALIDAD"
                            + "(4) ASIENTO");
                    Pasajeros  psj = pasajeros.get(i);
                    switch (Solemne_3.input()){
                        case 1:
                            psj.set_id(Solemne_3.input_2());
                            break;
                        case 2:
                            psj.set_nombre(Solemne_3.input_2());
                            break;
                        case 3:
                            psj.set_nacionalidad(Solemne_3.input_2());
                            break;
                        case 4:
                            psj.set_asiento(Solemne_3.input());
                            break;
                    }
                }
            }
        }
    }
    public void delete_passenger(String name){
        for (int i=0;i<pasajeros.size();i++){
            if (pasajeros.get(i).get_nombre().equals(name)){
                System.out.println("SE HA ELIMINADO EL PASAJERO");
                pasajeros.get(i).show_passenger();
                pasajeros.remove(i);
            }
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    public class Node {
    Vuelos data;
    Node next;

        public Node(Vuelos data) {
            this.data = data;
            this.next = null;
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    public class Lista_Vuelos {
        private Node head;
        private Vuelos vuelo;
        // Constructor para crear una lista vacía
        public Lista_Vuelos() {
            this.head = null;
            this.vuelo = new Vuelos(null,0,null);
        }

        // Método para agregar un nuevo nodo al final de la lista
        public void add_flight(Vuelos vuelo) {
            Node new_node = new Node(vuelo);
            if (head == null) {
                head = new_node;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = new_node;
            }
        }
        public Node getHead() {
            return head;
        }
        // Método para imprimir todos los elementos de la lista
        public void show_flights() {
            Node current = head;
            if (current==null){
                System.out.println("NO HAY VUELOS INGRESADOS\n");
                return;
            }
            System.out.println("Los vuelos ingresados son:");
            while (current != null) {
                current.data.show_flight();
                current = current.next;
            }
            System.out.println();
        }
        public void edit_flight(String name){
            Node current = head;
            if (current!=null){
                while (current.next!=null){
                    if (current.data.get_nombre().equals(name)){
                        System.out.println("Que desea modificar?"
                                + "\n(1) DESTINO"
                                + "\n(2) HORARIO"
                                + "\n(3) NOMBRE");
                        switch (Solemne_3.input()){
                            case 1:
                                System.out.println("Ingrese el nuevo destino:");
                                current.data.set_destino(Solemne_3.input_2());
                                break;
                            case 2:
                                System.out.println("Ingrese el nuevo horario:");
                                current.data.set_horario(Solemne_3.input());
                                break;
                            case 3:
                                System.out.println("Ingrese el nuevo nombre:");
                                current.data.set_nombre(Solemne_3.input_2());
                                break;
                        }
                    }
                    current = current.next;
                }
                
            }
        }
        // Método para eliminar un nodo con un valor específico
        public void delete_flight(String name) {
            if (head == null) return;

            if (head.data.get_nombre().equals(name)) {
                head = head.next;
                return;
            }

            Node current = head;
            while (current.next != null && !current.next.data.get_nombre().equals(name)) {
                current = current.next;
            }

            if (current.next != null) {
                current.next = current.next.next;
            }
        }
        public void get_flight(String name){
            Node current = head;
            if (current!=null){
                while (current.next!=null){
                    if (current.data.get_nombre().equals(name)){
                        return;
                    }
                    else{
                        System.out.println("El vuelo no existe");
                    }
                }
            }
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    
    Queue<Pasajeros> on_board = new LinkedList();
    
    public void abordaje(String nombreVuelo) {
        
        Lista_Vuelos vuelos = new Lista_Vuelos();
        vuelos.get_flight(nombreVuelo);
        for (int i=0;i<pasajeros.size();i++) {
            if (pasajeros.get(i).get_asiento() % 2 == 0) {
                on_board.add(pasajeros.get(i));
                System.out.printf("El pasajero %s esta a bordo\n", pasajeros.get(i).get_nombre());
            }
        }
        for (int i=0;i<pasajeros.size();i++) {
            if (pasajeros.get(i).get_asiento() % 2 != 0) {
                on_board.add(pasajeros.get(i));
                System.out.printf("El pasajero %s esta a bordo\n", pasajeros.get(i).get_nombre());
            }
        }
        if (on_board.isEmpty()) {
            System.out.println("La lista de pasajeros del vuelo no esta llena\n");
        }
        else {
            System.out.println("Proceso de abordaje:");
            while (!on_board.isEmpty()) {
                Pasajeros pasajero = on_board.poll();
                System.out.println("Pasajero ID: " + pasajero.get_id() + ", Nombre: " + pasajero.get_nombre());
            }
        }
    }
    public void show_on_board(){
        for (int i=0;i<on_board.size();i++){
            //on_board.forEach(get());
        }
    }
}
