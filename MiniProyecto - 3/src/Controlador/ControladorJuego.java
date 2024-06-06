package Controlador;

import Modelo.Juego;
import Vista.VistaJuego;
import java.util.Random;
import java.util.Scanner;

public class ControladorJuego{

    private Juego modelo;
    private VistaJuego vista;
    private Scanner scanner;

    public ControladorJuego(Juego modelo, VistaJuego vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.scanner = new Scanner(System.in);
    }


    public void mostrarInterfaz() {
        byte opcion;

        do {
            vista.mostrarMenuPrincipal(this);
            opcion = scanner.nextByte();
            switch (opcion) {
                case 1:
                    jugar();
                    break;
                case 2:
                    vista.mostrarInstrucciones();
                    scanner.nextLine(); // Para esperar la selección de salir
                    break;
                case 3:
                    System.out.println("\nSaliendo...");
                    break;
                default:
                    System.out.println("Opción incorrecta, intente de nuevo...\n");
                    break;
            }
        } while (opcion != 3);
    }

    private void jugar() {
        modelo.reiniciarVictorias();

        while (modelo.getVictoriasJugador() < 2 && modelo.getVictoriasComputadora() < 2) {
            vista.mostrarMenuJuego();
            byte opcion = scanner.nextByte();

            if (opcion == 4) {
                System.out.println("\nSaliendo...");
                break;
            }
            

            int resultado = jugarRonda(opcion);

            if (resultado == 1) {
                modelo.incrementarVictoriasJugador();
            } else if (resultado == -1) {
                modelo.incrementarVictoriasComputadora();
            }

            vista.mostrarResultado(modelo.getVictoriasJugador(), modelo.getVictoriasComputadora());

            if (modelo.getVictoriasJugador() < 2 && modelo.getVictoriasComputadora() < 2) {
                System.out.println("Presiona Enter para volver a jugar...");
                scanner.nextLine(); // Consumir la nueva línea pendiente
                scanner.nextLine(); // Esperar la entrada del usuario
            }
        }

        if (modelo.getVictoriasJugador() > modelo.getVictoriasComputadora()) {
            System.out.println("¡Felicidades! Ganaste la partida.");
        } else if (modelo.getVictoriasComputadora() > modelo.getVictoriasJugador()) {
            System.out.println("Lo siento, perdiste la partida.");
        }

        System.out.print("Presiona Enter para volver al menú principal...");
        scanner.nextLine();
        scanner.nextLine();
    }

    private int jugarRonda(int opcionJugador) {
        opcionJugador--; // Ajustar el valor para que 1 -> 0, 2 -> 1, 3 -> 2
        Random random = new Random();
        int opcionComputadora = random.nextInt(3); // 0: Piedra, 1: Papel, 2: Tijera

        String[] opciones = {"Piedra", "Papel", "Tijera"};
        System.out.println("       Jugador       |     Computadora");
        System.out.println("        " + opciones[opcionJugador] + "       |     " + opciones[opcionComputadora] + "\n");

        if (opcionJugador == opcionComputadora) {
            System.out.println("Empate!");
            return 0;
        } else if ((opcionJugador == 0 && opcionComputadora == 2) ||
                   (opcionJugador == 1 && opcionComputadora == 0) ||
                   (opcionJugador == 2 && opcionComputadora == 1)) {
            System.out.println("Ganaste esta ronda!");
            return 1;
        } else {
            System.out.println("Perdiste esta ronda!");
            return -1;
        }
    }

}