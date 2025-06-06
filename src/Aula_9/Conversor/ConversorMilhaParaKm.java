package Conversor;
public class ConversorMilhaParaKm implements Conversor {

    @Override
    public double converte(double distancia) {
        return distancia / 0.621371;
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