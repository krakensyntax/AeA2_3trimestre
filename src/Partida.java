import java.util.ArrayList;
import java.util.Collections;

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
        mazo.barajar();
        Carta carta = mazo.robarCarta();

        if (carta instanceof CartaComodin){
            mazo.getCartas().add(carta);

        }
        while (!(mazo.robarCarta() instanceof CartaNumero) || !(mazo.robarCarta() instanceof CartaEspecial)){
            mazo.barajar();
        }
        mazo.getCartas().remove(carta);
        descarte.getCartas().add(carta);
    }
    private void reponerDescarte(){
        if (mazo.getCartas().isEmpty()){
            mazo=descarte;
            mazo.barajar();
        }
    }
    private void cambiarTurno(){
        int contador_turno = 0;
        while (sentido){
            contador_turno += 1;
            turno = Math.floorMod(contador_turno, jugadores.size());
        }



    }
    public void saltarTurno(){

    }
//    public Jugador getSiguienteJugador(){
//
//    }
    private boolean esCartaValida(Carta carta){
        if (descarte.getCartas().isEmpty()){
            return true;
        } else if (carta instanceof CartaComodin){
            return true;
        } else if (carta.getColor().equals(descarte.getCartas().get(0).getColor())) {
            return true;
        } else if (carta.getValor().equals(descarte.getCartas().get(0).getValor())) {
            return true;
        } else {
            return false;
        }

    }
    public void turno(){
        getTurno();
        jugadores.get(turno).getNombre();
        jugadores.get(turno).getIdJugador();
        descarte.getCartas().get(0).toString();

    }
    public boolean verificarVictoria(){
        boolean ganador = false;
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getMano().isEmpty()){
                System.out.println("ha ganado");
                ganador = true;
            }
        }
        return ganador;
    }



}
