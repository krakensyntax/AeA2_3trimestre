import java.util.ArrayList;

public class Jugador implements Jugable {
    private String nombre;
    private ArrayList<Carta> mano;
    private int idJugador;
    private static int idJegadorGenerator = 0;

    public Jugador(String nombre){
        this.nombre = nombre;
        mano = new ArrayList<>();
        idJugador = idJegadorGenerator;
        idJegadorGenerator++;
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
    public void jugarCarta(Carta carta, Partida parida) {

    }

    @Override
    public void robarCarta(Baraja baraja) {

    }

    @Override
    public void mostrarEstado() {

    }
}
