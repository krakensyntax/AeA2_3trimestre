import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayList<Jugador> jugadores = new ArrayList<>();
        System.out.println("Bienvenida a uno en terminal");
        System.out.println("Cuantos jugadores van a participar?(minimo 2): ");
        int cantidadJugadores = scanner.nextInt();

        for (int i = 1; i <= cantidadJugadores; i++) {

            System.out.println("Nombre del jugador "+i+": ");
                jugadores.add(new Jugador(scanner.next()));

        }
        Baraja baraja = new Baraja();
        baraja.generarBaraja();
        baraja.barajar();

        for (int i = 0; i <jugadores.size() ; i++) {
            jugadores.get(i);
            for (int j = 0; j < 7 ; j++) {
                jugadores.get(i).getMano().add(baraja.robarCarta());

            }
        }

        Partida partida = new Partida(jugadores,baraja);
        partida.iniciarPartida();

        do {
            partida.turno();
        }while(!partida.verificarVictoria());



    }
}
