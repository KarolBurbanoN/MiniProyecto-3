package Vista;

import Controlador.ControladorJuego;

public interface VistaJuego {
    void mostrarMenuPrincipal(ControladorJuego juego);
    void mostrarInstrucciones();
    void mostrarMenuJuego();
    void mostrarResultado(int victoriasJugador, int victoriasComputadora);
}
