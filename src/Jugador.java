import java.util.ArrayList;
import java.util.Scanner;

public class Jugador implements Jugable {
    private String nombre;
    private ArrayList<Carta> mano;
    private int idJugador;
    private static int idJugadorGenerator = 0;

    public Jugador(String nombre){
        this.nombre = nombre;
        mano = new ArrayList<>();
        idJugador = idJugadorGenerator;
        idJugadorGenerator++;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Carta> getMano() {
        return mano;
    }

    public void setMano(ArrayList<Carta> mano) {
        this.mano = mano;
    }

    public int getIdJugador() {
        return idJugador;
    }

    @Override
    public void jugarCarta(Carta carta, Partida partida) {
        if (mano.contains(carta)){
            mano.remove(carta);
            partida.getDescarte().getCartas().add(0,carta);
        }else{
            System.out.println("no tiene esta carta");
        }
        if (carta instanceof CartaEspecial){
            ((CartaEspecial) carta).aplicarEfecto(partida);
        } else if (carta instanceof CartaComodin){
            ((CartaComodin) carta).aplicarEfecto(partida);
        }
    }

    @Override
    public void robarCarta(Baraja baraja) {
        mano.add(baraja.robarCarta());
    }

    @Override
    public void mostrarEstado() {
        System.out.println("Desea mostrar la mano del jugador? si/no: ");
        Scanner scanner = new Scanner(System.in);
        String responder = scanner.nextLine();

        if (responder.equals("si")){
            System.out.println(mano);
        }else if (responder.equals("no")){
            System.out.println("vale");
        }else {
            System.out.println("intenta de nuevo");
            scanner.nextLine();
        }

    }
}
