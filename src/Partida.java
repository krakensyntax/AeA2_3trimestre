import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Partida {
    Scanner scanner = new Scanner(System.in);
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
        for (int i = 0; i < 5; i++) {
            mazo.barajar();
        }

        Carta carta;
        do {

            carta = mazo.robarCarta();
            mazo.getCartas().add(carta);
            mazo.barajar();

        }while(carta instanceof CartaComodin);

        mazo.getCartas().remove(carta);
        descarte.getCartas().add(carta);
    }
    private void reponerDescarte(){
        if (mazo.getCartas().isEmpty()){
            mazo.getCartas().addAll(descarte.getCartas());
            descarte.getCartas().clear();
            mazo.barajar();
        }
    }
    private void cambiarTurno(){

        if (sentido){
            turno = Math.floorMod(turno+1, jugadores.size());
        } else {
            turno = Math.floorMod(turno-1, jugadores.size());
        }



    }
    public void saltarTurno(){
        cambiarTurno();
        cambiarTurno();
    }
    public Jugador getSiguienteJugador(){
        int nextplayer;
        if (sentido){
            nextplayer = Math.floorMod(turno+1, jugadores.size());
        } else {
            nextplayer = Math.floorMod(turno-1, jugadores.size());
        }
        return jugadores.get(nextplayer);
    }
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

        System.out.println("El nombre del jugador: "+ jugadores.get(turno).getNombre()+" y su ID: "+jugadores.get(turno).getIdJugador());
        System.out.println(descarte.getCartas().get(0));
        jugadores.get(turno).mostrarEstado();

        System.out.println("Accion por realizar: (1-robar carta del mazo/2-jugar carta de la mano)");

        int accionRealizar = scanner.nextInt();
        do {
            if (accionRealizar==1){

                if (mazo.getCartas().isEmpty()){
                    reponerDescarte();
                }
                Carta cartaDeRobar = mazo.robarCarta();
                jugadores.get(turno).getMano().add(cartaDeRobar);
                cambiarTurno();
                break;


            }else if (accionRealizar==2){
                System.out.println("Indica el numero de carta que quiere ponel: ");
                int cartaJugar = scanner.nextInt();
                if (cartaJugar >= 0 && cartaJugar < jugadores.get(turno).getMano().size()){
                    Carta cartaJugar2 = jugadores.get(turno).getMano().get(cartaJugar);
                    if (esCartaValida(cartaJugar2)){
                        jugadores.get(turno).jugarCarta(cartaJugar2,this);
                        cambiarTurno();
                        break;
                    }else {
                        System.out.println("Carta no es valida vuelve a poner otra carta valida!");

                    }


                }else {
                    System.out.println("numero no es valido");
                }

            }else {
                System.out.println("Vuelve a intentar lo");
            }

        }while(accionRealizar!=1 && accionRealizar !=2);


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
