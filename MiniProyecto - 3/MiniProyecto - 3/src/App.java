/**
 * @file JframeJuegoGUI.java
 * @brief 
 * @author
 *         - Sebastian Castro - 2359435
 *         - Karol Burbano - 2359305
 *         -Veronica Mujica - 2359406
 *         -Jeidy Murillo - 2359310 
 */


import Controlador.ControladorJuego;
import Modelo.Juego;
import Vista.VistaJuegoTerminal;
import Vista.VistaJuego;
import Vista.VistaJuegoGUI;

public class App {

    public static void main(String[] args) throws Exception {
        Juego modelo = new Juego();
        VistaJuegoTerminal vista = new Vista.VistaJuegoTerminal();
        // VistaJuegoGUI vista = new Vista.VistaJuegoGUI();
        ControladorJuego controlador = new ControladorJuego();
        //controlador.mostrarInterfaz();
    }
}


