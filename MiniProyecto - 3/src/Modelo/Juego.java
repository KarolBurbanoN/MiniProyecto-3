package Modelo;

public class Juego {
    private int victoriasJugador;
    private int victoriasComputadora;

    public Juego() {
        victoriasJugador = 0;
        victoriasComputadora = 0;
    }

    public int getVictoriasJugador() {
        return victoriasJugador;
    }

    public int getVictoriasComputadora() {
        return victoriasComputadora;
    }

    public void incrementarVictoriasJugador() {
        victoriasJugador++;
    }

    public void incrementarVictoriasComputadora() {
        victoriasComputadora++;
    }

    public void reiniciarVictorias() {
        this.victoriasJugador = 0;
        this.victoriasComputadora = 0;
    }
}

