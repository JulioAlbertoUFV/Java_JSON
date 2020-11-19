package ufv.enrique;

public class Amigo {
    private String nombre;
    private String coche;
    private long edad;

    public Amigo(){

    }

    public Amigo(String nombre, String coche, long edad) {
        this.nombre = nombre;
        this.coche = coche;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCoche() {
        return coche;
    }

    public void setCoche(String coche) {
        this.coche = coche;
    }

    public long getEdad() {
        return edad;
    }

    public void setEdad(long edad) {
        this.edad = edad;
    }
}
