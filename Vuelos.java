package solemne_3;

public class Vuelos {
    
    private String destino;
    private int horario;
    private String nombre;
    
    public Vuelos(String destino, int horario, String nombre){
        this.destino = destino;
        this.horario = horario;
        this.nombre = nombre;
    }
    public String get_destino() {
        return destino;
    }
    public void set_destino(String destino) {
        this.destino = destino;
    }
    public int get_horario() {
        return horario;
    }
    public void set_horario(int horario) {
        this.horario = horario;
    }
    public String get_nombre() {
        return nombre;
    }
    public void set_nombre(String nombre) {
        this.nombre = nombre;
    }
    public void show_flight(){
        System.out.printf("DESTINO: %s\n",get_destino());
        System.out.printf("HORARIO: %shr\n",get_horario());
        System.out.printf("NOMBRE: %s\n\n",get_nombre());
    }
}
