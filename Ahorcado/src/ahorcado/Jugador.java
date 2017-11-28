package ahorcado;

import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Jugador {
    
    Scanner teclado= new Scanner(System.in);
    
   
    
    public void sumaPuntosOtroJugador(int[] puntos, int puntosSuperar, int pos_excluida) {

        for (int i = 0; i < puntos.length; i++) {
            if (i != pos_excluida) {
                puntos[i]++;
            }

        }
    }
    public int cambiaTurno(int turnoActual, int limite) {

        if (turnoActual == limite) {
            return 0;
        } else {
            return ++turnoActual; //importante que sea pre-incremento
        }

    }

    public void mostrarPuntuaciones(String[] jugadores, int[] puntos) {

        for (int i = 0; i < jugadores.length; i++) {
            System.out.println(jugadores[i] + ": " + puntos[i] + " puntos");
        }
        System.out.println("");
    }

   
    public void mostrarGanador(int[] puntos, String jugadores[], int puntosSuperar) {

        int indiceGanador = 0;
        for (int i = 0; i < puntos.length; i++) {
            if (puntos[i] >= puntosSuperar) {
                indiceGanador = i; //obtenemos el indice
                break;
            }
        }

        System.out.println("El ganador es " + jugadores[indiceGanador]);

    }
}
