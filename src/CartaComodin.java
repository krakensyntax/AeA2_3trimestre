import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CartaComodin extends Carta {
    public CartaComodin(String color, String valor) {
        super(color, valor);
    }
    public void cambiarColor(String color){
        super.setColor(color);
    }
    public void aplicarEfecto(Partida partida){

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
                carta += NEGRO + linea + Carta.RESET;
                carta += "\n";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return carta;


    }
}
