package ahorcado;

import java.util.Scanner;

/**
 *
 * @author Gonzalo
 */
public class Ahorcado {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");
        Juego g = new Juego();
        Jugador j = new Jugador();

        //CONSTANTE
        final int PARTIDA_A_GANAR = 3;
        final int FALLOS = 6;
        final int JUGADORES = 2;
        final int NUMERO_CARACTERES = 26;

        //Variables y arrays
        String jugadores[] = new String[JUGADORES];
        int puntos_por_jugador[] = new int[JUGADORES];
        int turno = 0;

        //Arrays palabras
        String palabraElegida;
        String pista;
        char abecedario[] = g.generarCaracteres();
        boolean caracteresInsertado[] = new boolean[NUMERO_CARACTERES];

        ///Contar los numeros de errores
        int numeroFallos = FALLOS;

        String palabraAdivinar;
        String palabraUsuario;
        

        for (int i = 0; i < jugadores.length; i++) {
            jugadores[i] = g.pedirString(teclado, "Escribe nombre del jugador " + (i + 1) +" : ").toLowerCase();
        }

       
        while (!g.fin(puntos_por_jugador, PARTIDA_A_GANAR)) {

            palabraElegida = g.Validar(teclado, "Escribe una palabra " + jugadores[turno]+ " :",
                    "Error, escribe palabra con solo caracteres y sin espacios y de longitud de mas de 1");

       
             for (int i = 0; i < 20; i++) {
                System.out.println("");
             }

             palabraAdivinar = g.rellenaGuiones(palabraElegida);
           

            while (!g.palabraCorrecta(palabraElegida, palabraAdivinar) && numeroFallos > 0) {

                g.mostrarPalabra(palabraAdivinar);
                g.mostrarRepetidos(abecedario, caracteresInsertado);

                palabraUsuario = g.pedirString(teclado, "Escribe una letra, si escribes una palabra como escribir la solucion");

                if (palabraUsuario.length() == 1) {

                    if (Character.isAlphabetic((palabraUsuario.charAt(0)))) {

                        if (g.caracterIntroducido(caracteresInsertado, palabraUsuario.charAt(0))) {
                            System.out.println("El caracter ya esta puesto, elige otro");
                        } else if (g.numRemplazo(palabraElegida, palabraUsuario.charAt(0)) > 0) {
                            palabraAdivinar = g.remplazar(palabraElegida, palabraAdivinar, palabraUsuario.charAt(0));
                        } else {
                            numeroFallos--;
                            System.out.println("Fallo, te quedan " + numeroFallos + " intentos");
                        }
                        g.actualizarInsertado(caracteresInsertado, palabraUsuario.charAt(0));
                    }
                    
                

                } else if(!g.palabraCorrecta(palabraElegida, palabraUsuario)){
                    
                    numeroFallos--;
                    System.out.println("Fallo, no es la palabra.");
                    
                }else{
                    palabraAdivinar= palabraUsuario;
                    System.out.println("Enhorabuena, PALABRA ACERTADA");
                }

            }

            if (numeroFallos > 0) {
               j.sumaPuntosOtroJugador(puntos_por_jugador, 1, turno);
               turno = j.cambiaTurno(turno, jugadores.length-1);
            } else {
                
                puntos_por_jugador[turno]++;
            }
            
            j.mostrarPuntuaciones(jugadores, puntos_por_jugador);

            numeroFallos = FALLOS;
            g.actualizarInsertados(caracteresInsertado);
        }
        
        j.mostrarGanador(puntos_por_jugador, jugadores, PARTIDA_A_GANAR);
        System.out.println("Final");
    }

}




