package Vista;

import java.util.Scanner;
import Controlador.ControladorJuego;

public class VistaJuegoTerminal implements VistaJuego {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void mostrarMenuPrincipal(ControladorJuego juego) {
        System.out.println("\n--------------------------------------------");
        System.out.println("---------------- Bienvenido ----------------");
        System.out.println("Que desea hacer?\n");
        System.out.println("1. Jugar\r\n" + //
                            "2. Cómo se juega?\r\n" + //  
                            "3. Salir\r");
        System.out.println("--------------------------------------------");
        System.out.print("Seleccione una opcion: ");
    }

        
    public void mostrarInstrucciones() {
        System.out.println("\n--------------------------------------------");
        System.out.println("     Haz seleccionado ver instrucciones");
        System.out.println("--------------------------------------------");
        System.out.println("Este es un juego de Piedra, Papel o Tijera.\n" + //
                           "Lo único que tienes que hacer es seleccionar Jugar y escoger el elemento que desees. \n" + //
                           "El juego se juega al mejor de tres rondas. El primero en ganar dos rondas gana la partida.");
        System.out.println("--------------------------------------------");
        System.out.print("Presiona Enter para salir...");
        scanner.nextLine(); // Consumir la nueva línea pendiente
        scanner.nextLine(); // Esperar la entrada del usuario
    }

    @Override
    public void mostrarMenuJuego() {
        System.out.println("--------------------------------------------");    
        System.out.println("           Haz seleccionado Jugar");
        System.out.println("--------------------------------------------");
        System.out.print("Que desea escoger?\n");
        System.out.println("1. Piedra\r\n" + //
                           "2. Papel\r\n" + //  
                           "3. Tijera\r\n" + //     
                           "4. Salir\r");  
        System.out.println("--------------------------------------------");               
        System.out.print("Seleccione una opcion: ");
    }

    @Override
    public void mostrarResultado(int victoriasJugador, int victoriasComputadora) {
        System.out.println("--------------------------------------------");
        System.out.println("Victorias Jugador: " + victoriasJugador);
        System.out.println("Victorias Computadora: " + victoriasComputadora);
        System.out.println("--------------------------------------------");
    }
}
