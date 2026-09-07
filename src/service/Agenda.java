package service;

import model.Contacto;

import java.util.HashSet;
import java.util.Set;

public class Agenda {

    // Agenda = conjunto (Set) de contactos
    private final Set<Contacto> contactos;
    private final int size;

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
        if (existeContacto(c)) {
            System.out.println(" Ya existe un contacto con el nombre \"" + c.getNombre() + "\". No se permite duplicar nombre de contacto ");
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
        for (Contacto c : contactos) {
            System.out.println("   " + c);
        }
    }

    //Buscar contacto por nombre y mostrar número telefónico

    public String buscaContacto(String nombre) {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println(" Contacto encontrado - Teléfono: " + c.getTelefono());
                return c.getTelefono();
            }
        }
        System.out.println(" No existe ningún contacto con el nombre \"" + nombre + "\".");
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

}

