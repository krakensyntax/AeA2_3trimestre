public class Main {
    public static void main(String[] args) {
        CartaNumero cartaNumero = new CartaNumero(Carta.NEGRO,"5");
        System.out.println(cartaNumero);
        Baraja baraja = new Baraja();

        baraja.generarBaraja();

        System.out.println(baraja);
        System.out.println(baraja.getCartas().size());
    }
}
