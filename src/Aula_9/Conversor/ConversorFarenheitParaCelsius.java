package Conversor;

public class ConversorFarenheitParaCelsius implements Conversor {

    @Override
    public double converte(double temperatura) {
        return 5*(temperatura-32)/9;    
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
