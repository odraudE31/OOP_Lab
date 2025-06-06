package Conversor;

public class ConversorFarenheitParaKelvin implements Conversor {
    @Override
    public double converte(double temperatura) {
        return temperatura + 459.67 * 5 / 9;
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