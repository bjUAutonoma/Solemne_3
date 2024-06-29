package solemne_3;

public class Pasajeros {
    
    private String id;
    private String nombre;
    private String nacionalidad;
    private int asiento;
    
    public Pasajeros(String id, String nombre, String nacionalidad, int asiento){
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.asiento = asiento;
    }
    public String get_id() {
        return id;
    }
    public void set_id(String id) {
        this.id = id;
    }
    public String get_nombre() {
        return nombre;
    }
    public void set_nombre(String nombre) {
        this.nombre = nombre;
    }
    public String get_nacionalidad() {
        return nacionalidad;
    }
    public void set_nacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    public int get_asiento() {
        return asiento;
    }
    public void set_asiento(int asiento) {
        this.asiento = asiento;
    }
    public void show_passenger(){
        System.out.printf("ID: %s \n",get_id());
        System.out.printf("Nombre: %s \n",get_nombre());
        System.out.printf("Nacionalidad: %s \n",get_nacionalidad());
        System.out.printf("Asiento: %d \n\n",get_asiento());
    }
}
