package Conversor;
public class ConversorIdentidade implements Conversor {

    @Override
    public double converte(double distancia) {
        return distancia;
    }
   
    @Override
    public Conversor clone() {
        try {
            return (Conversor) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}