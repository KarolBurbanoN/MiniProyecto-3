import Controlador.ControladorJuego;
import Modelo.Juego;
import Vista.VistaJuegoTerminal;
import Vista.VistaJuego;
import Vista.VistaJuegoGUI;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        Juego modelo = new Juego();
        String[] options = {"Terminal", "Interfaz Gráfica"};
        int choice = JOptionPane.showOptionDialog(null, "Seleccione el modo de juego", "Modo de juego",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        
        VistaJuego vista;
        if (choice == 1) {
            vista = new VistaJuegoGUI();
        } else {
            vista = new VistaJuegoTerminal();
        }
        
        ControladorJuego controlador = new ControladorJuego(modelo, vista);
        controlador.mostrarInterfaz();
    }
}

