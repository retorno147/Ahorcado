package ahorcado;

import java.util.Scanner;

/**
 *
 * @author Gonzalo
 */
public class Juego {
    
    public  String pedirString(Scanner sn, String mensaje) {

        System.out.println(mensaje);
        return sn.next();

    }

    
    public  char[] generarCaracteres() {

        char[] caracter = new char[26];
        for (int i = 0, j = 97; i < caracter.length; i++, j++) {
            caracter[i] = (char) j;
        }

        return caracter;

    }

    public  boolean comprobarAlfabeto(String cadena) {

        char caracter;

        for (int i = 0; i < cadena.length(); i++) {
            caracter = cadena.charAt(i);
            if (!Character.isAlphabetic(caracter)) {
                return true;
            }
        }

        return false;

    }

    public  boolean fin(int puntos[], int puntuacionSuperar) {

        for (int i = 0; i < puntos.length; i++) {
            if (puntos[i] >= puntuacionSuperar) {
                return true;
            }
        }

        return false;

    }

    public  String Validar(Scanner sn, String mensaje, String mensajeError) {

        String palabra;
        boolean correcto;
        do {
            correcto=true;
            palabra = pedirString(sn, mensaje).toLowerCase();

            if (comprobarAlfabeto(palabra) || palabra.length() <= 1) {
                System.out.println(mensajeError);
                correcto=false;
            }

        } while (!correcto);

        return palabra;
    }
       
    public String rellenaGuiones(String cadena) {

        String palabra = "";
        for (int i = 0; i < cadena.length(); i++) {
            palabra += "_"; //le pongo el guion
        }

        return palabra;
    }

    public  void mostrarPalabra(String cadena) {

        for (int i = 0; i < cadena.length(); i++) {
            System.out.print(cadena.charAt(i) + " ");
        }

        System.out.println("");

    }

    public  boolean palabraCorrecta(String palabraOriginal, String palabraUsuario) {

        return palabraOriginal.equals(palabraUsuario);

    }

   
    public void mostrarRepetidos(char[] abecedario, boolean insertados[]) {

        System.out.print("Repetidas: ");
        for (int i = 0; i < insertados.length; i++) {
            //Si esta insertado, se muestra el caracter
            if (insertados[i]) {
                System.out.print(abecedario[i]);
            }

        }
        System.out.println("");
    }

    

    public int numRemplazo(String cadenaOriginal, char caracter) {

        int remplazos = 0;
        char caracterCadena;
        for (int i = 0; i < cadenaOriginal.length(); i++) {
            caracterCadena = cadenaOriginal.charAt(i);
            if (caracterCadena == caracter) {
                remplazos++;
            }
        }
        return remplazos;

    }

    public String remplazar(String cadenaOriginal, String cadenaRemplazar, char caracter) {

        String cadenaRemplazo = "";
        char caracterCadena;
        for (int i = 0; i < cadenaOriginal.length(); i++) {
            caracterCadena = cadenaOriginal.charAt(i);

            if (caracterCadena == caracter) {
                cadenaRemplazo += caracter;
            } else {
                cadenaRemplazo += cadenaRemplazar.charAt(i);
            }
        }
        return cadenaRemplazo;

    }

     
    public boolean caracterIntroducido(boolean[] insertados, char caracter) {
        return insertados[caracter - 'a'];
    }

    public void actualizarInsertado(boolean[] insertados, char caracter) {

        insertados[caracter - 'a'] = true;

    }


   
    public void actualizarInsertados(boolean insertados[]) {

        for (int i = 0; i < insertados.length; i++) {
            insertados[i] = false;
        }

    }
}
