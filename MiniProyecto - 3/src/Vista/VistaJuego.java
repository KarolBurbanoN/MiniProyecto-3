package Vista;
import Controlador.ControladorJuego;

public interface VistaJuego {
    void mostrarMenuPrincipal(ControladorJuego juego);
    void mostrarInstrucciones(ControladorJuego juego);
    void mostrarMenuJuego(ControladorJuego juego);
    void mostrarResultado(int victoriasJugador, int victoriasComputadora);
}