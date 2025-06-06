package Conversor;

public class ConversorKelvinParaCelsius implements Conversor {
    @Override
    public double converte(double temperatura) {
        return temperatura - 273.15;
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