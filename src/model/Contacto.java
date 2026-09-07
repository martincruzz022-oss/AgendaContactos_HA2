package model;

public class Contacto extends Persona {

    private String telefono;

    public Contacto() {
        super();
    }

    public Contacto(String nombre, String apellido, String telefono) {
        super(nombre, apellido);
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return getNombre() + " " + getApellido() + " - Tel: " + telefono;
    }
}