public class Main {
    public static void main(String[] args) {
        CartaNumero cartaNumero = new CartaNumero(Carta.NEGRO,"5");
        System.out.println(cartaNumero);
        Baraja baraja = new Baraja();

        baraja.generarBaraja();

        
        System.out.println(baraja.getCartas().get(0));
        baraja.robarCarta();
        System.out.println(baraja);

        Jugador jugador = new Jugador("serhii");

        System.out.println(baraja.getCartas().get(0).toString());

    }
}
