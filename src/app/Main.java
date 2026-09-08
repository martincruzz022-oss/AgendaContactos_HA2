package app;

import model.Contacto;
import service.Agenda;

import java.util.Scanner;
import util.Validador;

public class Main {
    public static void main(String[] args) {
        Scanner ns = new Scanner(System.in);

        Agenda agenda = new Agenda();

        int opcion;

        do {

            System.out.println("\n===== AGENDA DE CONTACTOS =====");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Verificar si existe contacto");
            System.out.println("4. Listar contactos");
            System.out.println("5. Eliminar contacto");
            System.out.println("6. Modificar teléfono");
            System.out.println("7. Verificar agenda llena");
            System.out.println("8. Mostrar espacios libres");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");

            if (ns.hasNextInt()) {
                opcion = ns.nextInt();
                ns.nextLine();
            } else {
                System.out.println("Opcion no válida, debes ingresar un número del 1 al 9.");
                ns.nextLine();
                opcion = 0;
            }

            switch (opcion) {

                case 1:

                    System.out.print("Nombre: ");
                    String nombre = ns.nextLine().trim();

                    if (!Validador.validarNombre(nombre)) {
                        if (!Validador.validarTexto(nombre)) {
                            System.out.println("El nombre no puede estar vacío.");
                        } else {
                            System.out.println("El nombre no puede contener números.");
                        }
                        break;
                    }

                    System.out.print("Apellido: ");
                    String apellido = ns.nextLine().trim();

                    if (!Validador.validarApellido(apellido)) {
                        if (!Validador.validarTexto(apellido)) {
                            System.out.println("El apellido no puede estar vacío.");
                        } else {
                            System.out.println("El apellido no puede contener números.");
                        }
                        break;
                    }

                    System.out.print("Teléfono: ");
                    String telefono = ns.nextLine().trim();

                    if (!Validador.validarTel(telefono)) {
                        if (!Validador.validarTexto(telefono)) {
                            System.out.println("El teléfono no puede estar vacío.");
                        } else if (telefono.length() != 10) {
                            System.out.println("El teléfono debe tener exactamente 10 dígitos.");
                        } else {
                            System.out.println("El teléfono solo puede contener números.");
                        }
                        break;
                    }

                    Contacto nuevoContacto =
                            new Contacto(nombre, apellido, telefono);

                    agenda.añadirContacto(nuevoContacto);

                    break;

                case 2:

                    System.out.print("Nombre: ");
                    nombre = ns.nextLine();

                    System.out.print("Apellido: ");
                    apellido = ns.nextLine();

                    agenda.buscarContacto(nombre, apellido);

                    break;

                case 3:

                    System.out.print("Nombre: ");
                    nombre = ns.nextLine();

                    System.out.print("Apellido: ");
                    apellido = ns.nextLine();

                    Contacto contactoBuscar =
                            new Contacto(nombre, apellido, "");

                    if (agenda.existeContacto(contactoBuscar)) {
                        System.out.println("El contacto existe.");
                    } else {
                        System.out.println("El contacto no existe.");
                    }

                    break;

                case 4:
                    agenda.listarContactos();
                    break;

                case 5:

                    System.out.print("Nombre: ");
                    nombre = ns.nextLine();

                    System.out.print("Apellido: ");
                    apellido = ns.nextLine();

                    Contacto contactoEliminar =
                            new Contacto(nombre, apellido, "");

                    if (agenda.eliminarContacto(contactoEliminar)) {
                        System.out.println("Contacto eliminado correctamente.");
                    } else {
                        System.out.println("No se encontró el contacto.");
                    }

                    break;

                case 6:
                    System.out.println("Dame tu nombre: ");
                    nombre = ns.nextLine().trim();

                    System.out.println("Dame tu apellido: ");
                    apellido = ns.nextLine().trim();

                    System.out.println("Ingresa tu nuevo numero: ");
                    String nuevoTelefono = ns.nextLine().trim();

                    if (!Validador.validarTel(nuevoTelefono)) {

                        if (!Validador.validarTexto(nuevoTelefono)) {
                            System.out.println("El teléfono no puede estar vacío.");
                        } else if (nuevoTelefono.length() != 10) {
                            System.out.println("El teléfono debe tener exactamente 10 dígitos.");
                        } else {
                            System.out.println("El teléfono solo puede contener números.");
                        }

                        break;
                    }

                    agenda.modificarTelefono(nombre, apellido, nuevoTelefono);

                    break;

                case 7:
                    if (agenda.agendaLlena()){
                        System.out.println("La agenda esta llena");
                    } else {
                        System.out.println("Aún hay espacio en la agenda");
                    }

                    break;

                case 8:
                    System.out.println("Espacios disponibles en la agenda: " + agenda.espaciosLibres());
                    break;

                case 9:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 9);

    }
}