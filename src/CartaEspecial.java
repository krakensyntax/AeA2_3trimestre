import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CartaEspecial extends Carta implements Colorable {
    public CartaEspecial(String color, String valor) {
        super(color, valor);
    }
    public void aplicarEfecto(Partida partida){
        if (partida.getDescarte().getCartas().get(0).getValor().equals("+2")){
            for (int i = 0; i < 2; i++) {
                partida.getSiguienteJugador().getMano().add(partida.getMazo().getCartas().get(i));
            }
        } else if (partida.getDescarte().getCartas().get(0).getValor().equals("jumpTurn")) {
            partida.saltarTurno();

        } else if (partida.getDescarte().getCartas().get(0).getValor().equals("changeDirection")) {
            if (partida.isSentido()){
                partida.setSentido(false);
            }else {
                partida.setSentido(true);
            }
        }

    }

    @Override
    public void cambiarColor(String color) {
        setColor(color);
    }

    @Override
    public String toString() {
        File file = new File("src/assets-1/"+getValor()+".txt");
        String carta = "";
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                carta += super.getColor() + linea + Carta.RESET;
                carta += "\n";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return carta;
    }
}
