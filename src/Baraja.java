import java.util.ArrayList;
import java.util.Collections;

public class Baraja {
    private ArrayList<Carta> cartas = new ArrayList<>();


    public Baraja(){};
    public void generarBaraja(){
        for (int i = 0; i <= 9; i++) {
            cartas.add(new CartaNumero(Carta.AMARILLO,String.valueOf(i)));
            cartas.add(new CartaNumero(Carta.AZUL,String.valueOf(i)));
            cartas.add(new CartaNumero(Carta.ROJO,String.valueOf(i)));
            cartas.add(new CartaNumero(Carta.VERDE,String.valueOf(i)));
        }




        for (int i = 0; i < 2; i++) {
            cartas.add(new CartaEspecial(Carta.AMARILLO,"+2"));
            cartas.add(new CartaEspecial(Carta.AZUL,"+2"));
            cartas.add(new CartaEspecial(Carta.ROJO,"+2"));
            cartas.add(new CartaEspecial(Carta.VERDE,"+2"));

            cartas.add(new CartaEspecial(Carta.AMARILLO,"changeDirection"));
            cartas.add(new CartaEspecial(Carta.AZUL,"changeDirection"));
            cartas.add(new CartaEspecial(Carta.ROJO,"changeDirection"));
            cartas.add(new CartaEspecial(Carta.VERDE,"changeDirection"));

            cartas.add(new CartaEspecial(Carta.AMARILLO,"jumpTurn"));
            cartas.add(new CartaEspecial(Carta.AZUL,"jumpTurn"));
            cartas.add(new CartaEspecial(Carta.ROJO,"jumpTurn"));
            cartas.add(new CartaEspecial(Carta.VERDE,"jumpTurn"));
        }

        for (int i = 0; i < 4; i++) {
            cartas.add(new CartaComodin(Carta.NEGRO,"+4"));
            cartas.add(new CartaComodin(Carta.NEGRO,"changeColor"));
        }


        //4 de +4 4 de cambio de color
        //especiales: 2 de cada color y de cada tipo

    }
    public void barajar(){
        Collections.shuffle(cartas);
    }
    public Carta robarCarta(){
        if (cartas.isEmpty()){
            return null;
        }else {
            Carta carta_sacar = cartas.get(0);
            cartas.remove(0);
            return carta_sacar;
        }
    }
    public ArrayList<Carta> getCartas(){
        return cartas;
    }

    @Override
    public String toString() {
        String carta = "";
        for (Carta carta2:cartas){
            carta += carta2;
            carta += "\n";
        }
        return carta;
    }
}
