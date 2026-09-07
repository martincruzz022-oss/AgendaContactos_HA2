package util;

public class Validador {
    //checa si el texto esta vacio



    public static boolean validarTexto(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return false;
        }
        return true;
    }


    public static boolean validarNombre(String nombre){
        if (!validarTexto(nombre)){
            return false;
        }
        for (int i = nombre.length()-1; i >= 0; i--){
            char letra = nombre.charAt(i);
            if (Character.isDigit(letra)) {
                return false;
            }
        }return true;
    }


    // si cumple con lo de arriba ya puede pasar los sig filtros

    public static boolean validarApellido (String apellido){
        if (!validarTexto(apellido)){
            return false;
        }
        for (int i = apellido.length()-1; i >= 0; i--){
            char letra = apellido.charAt(i);
            if (Character.isDigit(letra)) {
                return false;
            }
        }return true;
    }

    public static boolean validarTel (String numero){
        if (!validarTexto(numero)){
            return false;
        }
        if (numero.length() != 10) {
            return false;
        }
        for (int i = numero.length()-1; i >= 0; i--) {
            char letra = numero.charAt(i);
            if (!Character.isDigit(letra)) {
                return false;
            }
        }
        return true;
    }
}

