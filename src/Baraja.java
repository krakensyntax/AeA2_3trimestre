import java.util.ArrayList;

public class Baraja {
    private ArrayList<Carta> cartas = new ArrayList<>();


    public Baraja(){};
    public void generarBaraja(){

    }
    public void barajar(){

    }
    //public Carta robarCarta(){

    //}
    public ArrayList<Carta> getCartas(){
        return cartas;
    }

    @Override
    public String toString() {
        return "Baraja[" +
                "cartas=" + cartas +
                ']';
    }
}
