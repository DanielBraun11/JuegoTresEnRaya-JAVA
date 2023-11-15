import java.util.Scanner;

public class TresEnRaya {

    // Tamaño del tablero
    private static final int FILAS = 3;
    private static final int COLUMNAS = 3;

    // Representación del tablero
    private static char[][] tablero = new char[FILAS][COLUMNAS];

    // Jugador actual
    private static char jugadorActual = 'X';

    public static void main(String[] args) {
        inicializarTablero();
        mostrarTablero();

        while (true) {
            realizarJugada();
            mostrarTablero();

            if (haGanado()==true) {
                System.out.println("¡Jugador " + jugadorActual + " ha ganado!");
                break;
            } else if (tableroCompleto()) {
                System.out.println("¡Empate!");
                break;
            }

            cambiarJugador();
        }
    }

    // MÉTODO Inicializa el tablero con espacios en blanco
    private static void inicializarTablero() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tablero[i][j] = ' ';
            }
        }
    }

    // MÉTODO Muestra el estado actual del tablero
    private static void mostrarTablero() {
        System.out.println("-------------");
        for (int i = 0; i < FILAS; i++) {
            System.out.print("| ");
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(tablero[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    // MÉTODO Realiza la jugada del jugador actual
    private static void realizarJugada() {
        Scanner scanner = new Scanner(System.in);
        int fila, columna;

        do {
            System.out.println("Jugador " + jugadorActual + ", ingresa la fila (1-3) y la columna (1-3) separadas por espacio:");
            fila = scanner.nextInt() - 1;
            columna = scanner.nextInt() - 1;
        } while (!esMovimientoValido(fila, columna));

        tablero[fila][columna] = jugadorActual;
    }

    // MÉTODO Verifica si el movimiento es válido (casilla vacía)
    private static boolean esMovimientoValido(int fila, int columna) {
        if (fila < 0 || fila >= FILAS || columna < 0 || columna >= COLUMNAS) {
            System.out.println("Movimiento fuera de los límites del tablero. Inténtalo de nuevo.");
            return false;
        } else if (tablero[fila][columna] != ' ') {
            System.out.println("Casilla ocupada. Inténtalo de nuevo.");
            return false;
        }
        return true;
    }

    // MÉTODO Verifica si algún jugador ha ganado
    private static boolean haGanado() {
        // Verificar filas y columnas
        for (int i = 0; i < FILAS; i++) {
            if ((tablero[i][0] == jugadorActual && tablero[i][1] == jugadorActual && tablero[i][2] == jugadorActual) ||
                    (tablero[0][i] == jugadorActual && tablero[1][i] == jugadorActual && tablero[2][i] == jugadorActual)) {
                return true;
            }
        }

        // Verificar diagonales
        if ((tablero[0][0] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][2] == jugadorActual) ||
                (tablero[0][2] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][0] == jugadorActual)) {
            return true;
        }

        return false;
    }

    // Verifica si el tablero está completo (empate)
    private static boolean tableroCompleto() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (tablero[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    // Cambia al siguiente jugador
    private static void cambiarJugador() {
        jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
    }
}













