package service;

import model.Contacto;

import java.util.HashSet;
import java.util.Set;

import java.util.ArrayList;
import java.util.Comparator;

public class Agenda {

    // Agenda = conjunto (Set) de contactos
    private final Set<Contacto> contactos;
    private final int size;

    public Agenda () {
        this.size = 10;
        this.contactos = new HashSet<>();
    }

    // Usuario indica num de contactos a añadir
    public Agenda(int size) {
        this.size = size;
        this.contactos = new HashSet<>();
    }

    //Añadir contacto si hay espacios disponibles o si el nombre no existe
    public boolean añadirContacto(Contacto c) {
        if (agendaLlena()) {
            System.out.println(" La agenda se ha quedado sin espacio");
            return false;
        }

        if (c.getNombre() == null || c.getNombre().trim().isEmpty()) {
            System.out.println("El nombre no puede estar vacío.");
            return false;
        }

        if (c.getApellido() == null || c.getApellido().trim().isEmpty()) {
            System.out.println("El apellido no puede estar vacío.");
            return false;
        }

        if (existeContacto(c)) {
            System.out.println(" Ya existe un contacto con el mismo nombre y apellido.");
            return false;
        }

        contactos.add(c);
        System.out.println(" Se ha añadido correctamente el contacto! ");
        return true;
    }

    // Indicar si el nombre ya existe
    public boolean existeContacto(Contacto c) {
        return contactos.contains(c);
    }

    // Desplegar la lista de contactos
    public void listarContactos() {

        if (contactos.isEmpty()) {
            System.out.println(" Agenda vacía. Añada contactos ");
            return;
        }

        System.out.println(" CONTACTOS (" + contactos.size() + "/" + size + ") ---");

        ArrayList<Contacto> listaOrdenada = new ArrayList<>(contactos);

        listaOrdenada.sort(
                Comparator.comparing(
                        Contacto::getNombre,
                        String.CASE_INSENSITIVE_ORDER
                ).thenComparing(
                        Contacto::getApellido,
                        String.CASE_INSENSITIVE_ORDER
                )
        );

        for (Contacto c : listaOrdenada) {
            System.out.println("   " + c);
        }
    }

    //Buscar contacto por nombre y mostrar número telefónico

    public String buscarContacto(String nombre, String apellido) {
        for (Contacto c : contactos) {

            if (c.getNombre().equalsIgnoreCase(nombre)
                    && c.getApellido().equalsIgnoreCase(apellido)) {

                System.out.println("Contacto encontrado - Teléfono: " + c.getTelefono());

                return c.getTelefono();
            }
        }

        System.out.println("No se encontró el contacto.");
        return null;
    }

    // Indica cuántos espacios quedan en la agenda
    public int espaciosLibres() {
        return size - contactos.size();
    }

    // Señala si se han ocupado todos los espacios
    public boolean agendaLlena() {
        return contactos.size() >= size;
    }

    // eliminar contacto
    public boolean eliminarContacto(Contacto contacto) {
        if (!existeContacto(contacto)) {
            return false;
        }
        contactos.remove(contacto);
        return true;
    }

    public boolean modificarTelefono(
            String nombre,
            String apellido,
            String nuevoTelefono) {

        for (Contacto c : contactos) {

            if (c.getNombre().equalsIgnoreCase(nombre)
                    && c.getApellido().equalsIgnoreCase(apellido)) {

                c.setTelefono(nuevoTelefono);

                System.out.println("Teléfono actualizado correctamente.");

                return true;
            }
        }

        System.out.println("No se encontró el contacto.");

        return false;
    }

}