package Conversor;
public class ConversorKelvinParaFarenheit implements Conversor {
    @Override
    public double converte(double temperatura) {
        return temperatura * 9/5 - 459.67;
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
