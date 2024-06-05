import java.util.Scanner;
import java.util.Random;

public class App {

    static Scanner scanner = new Scanner(System.in);
    static int jugador;

    static void showMainMenu() { 
        Byte opcionByte;  

        do{
            System.out.println("\n--------------------------------------------");
            System.out.println("---------------- Bienvenide ----------------");
            System.out.println("Que desea hacer?\n");
            System.out.println("1. Jugar\r\n" + //
                            "2. Cómo se juega?\r\n" + //  
                            "3. Salir\r");        
            System.out.println("--------------------------------------------");               
            System.out.print("Seleccione una opcion: ");
            opcionByte = scanner.nextByte();
            System.out.println("--------------------------------------------\n"); 
            
                switch(opcionByte){
                    case 1:
                        Juego();
                        break;
                    case 2: 
                        Instrucciones();
                        break;
                    
                    case 3: 
                        System.out.println("\nSaliendo..."); 
                        break;
                    default:
                        System.out.println("Opcion incorrecta, intente de nuevo...\n"); 
                        break;
                }
        }while(opcionByte!=3);
    }

    static void Juego(){
        int victoriasJugador = 0;
        int victoriasComputadora = 0;
        Byte opcionByte;

        while (victoriasJugador < 2 && victoriasComputadora < 2) {
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
            opcionByte = scanner.nextByte();
            System.out.println("--------------------------------------------\n");

            if (opcionByte == 4) {
                System.out.println("\nSaliendo..."); 
                break;
            }

            int resultado = jugarRonda(opcionByte);

            if (resultado == 1) {
                victoriasJugador++;
            } else if (resultado == -1) {
                victoriasComputadora++;
            }

            System.out.println("--------------------------------------------");
            System.out.println("Victorias Jugador: " + victoriasJugador);
            System.out.println("Victorias Computadora: " + victoriasComputadora);
            System.out.println("--------------------------------------------");

            if (victoriasJugador < 2 && victoriasComputadora < 2) {
                System.out.println("Presiona Enter para volver a jugar...");
                scanner.nextLine(); // Consumir la nueva línea pendiente
                scanner.nextLine(); // Esperar la entrada del usuario
            }
        }

        if (victoriasJugador > victoriasComputadora) {
            System.out.println("¡Felicidades! Ganaste la partida.");
        } else if (victoriasComputadora > victoriasJugador) {
            System.out.println("Lo siento, perdiste la partida.");
        }

        System.out.print("Presiona Enter para volver al menú principal...");
        scanner.nextLine();
        scanner.nextLine();
    }

    static int jugarRonda(int opcionJugador) {
        jugador = opcionJugador;
        Random random = new Random();
        int opcionComputadora = random.nextInt(3) + 1; // 1: Piedra, 2: Papel, 3: Tijera

        String[] opciones = {"Piedra", "Papel", "Tijera"};
        System.out.println("       Jugador       |     Computadora");
        System.out.println("        " + opciones[jugador - 1] + "       |     " + opciones[opcionComputadora - 1] + "\n");

        if (jugador == opcionComputadora) {
            System.out.println("Empate!");
            return 0;

        } else if ((jugador == 1 && opcionComputadora == 3) || 
                   (jugador == 2 && opcionComputadora == 1) || 
                   (jugador == 3 && opcionComputadora == 2)) {
            System.out.println("Ganaste esta ronda!");
            return 1;
            
        } else {
            System.out.println("Perdiste esta ronda!");
            return -1;
        }
        
    }

    static void Instrucciones(){
        Byte opcionByte;

        do {
            System.out.println("--------------------------------------------");    
            System.out.println("     Haz seleccionado ver instrucciones");
            System.out.println("--------------------------------------------");
            System.out.println("Este es un juego de Piedra, Papel o Tijera.\n" + //
                "Lo único que tienes que hacer es seleccionar Jugar y escoger el elemento que desees. \n" + //
                "El juego se juega al mejor de tres rondas. El primero en ganar dos rondas gana la partida.");
            System.out.println("--------------------------------------------");
            System.out.println("1. Salir\r");  
            System.out.println("--------------------------------------------");               
            System.out.print("Seleccione una opcion: ");
            opcionByte = scanner.nextByte();
            System.out.println("--------------------------------------------\n");

            if (opcionByte != 1) {
                System.out.println("Opción incorrecta, intente de nuevo...\n");
            }

        } while (opcionByte != 1);
    }

    public static void main(String[] args) throws Exception {
        showMainMenu();
    }
}


