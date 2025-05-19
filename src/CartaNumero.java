import java.io.*;

public class CartaNumero extends Carta {
    public CartaNumero(String color, String valor) {
        super(color, valor);
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