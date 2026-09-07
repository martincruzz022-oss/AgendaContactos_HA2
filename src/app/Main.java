package app;

import service.Agenda;

import java.util.Scanner;

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

            opcion = ns.nextInt();
            ns.nextLine();

            switch (opcion) {

                case 1:
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    break;

                case 6:
                    break;

                case 7:

                    break;

                case 8:
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