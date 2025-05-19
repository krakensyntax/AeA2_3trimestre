import java.util.ArrayList;

public class Partida {
    private ArrayList<Jugador> jugadores;
    private Baraja mazo;
    private Baraja descarte;
    private boolean sentido;
    private int turno;

    public Partida(ArrayList<Jugador> jugadores, Baraja mazo) {
        this.jugadores = jugadores;
        this.mazo = mazo;
        descarte = new Baraja();
        sentido = true;
        turno = 0;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public Baraja getMazo() {
        return mazo;
    }

    public Baraja getDescarte() {
        return descarte;
    }

    public boolean isSentido() {
        return sentido;
    }

    public void setSentido(boolean sentido) {
        this.sentido = sentido;
    }

    public int getTurno() {
        return turno;
    }

    public void iniciarPartida(){

    }
    private void reponerDescarte(){

    }
    private void cambiarTurno(){

    }
    public void saltarTurno(){

    }
//    public Jugador getSiguienteJugador(){
//
//    }
//    private boolean esCartaValida(Carta carta){
//
//    }
    public void turno(){

    }
//    public boolean verificarVictoria(){
//
//    }



}
