package Conversor;

public class ConversorCelsiusParaFarenheit implements Conversor {

    @Override
    public double converte(double temperatura) {
        return 9*temperatura/5 + 32;
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


