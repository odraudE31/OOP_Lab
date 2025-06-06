package Conversor;
// Interface de conversores de temperatura
public interface Conversor extends Cloneable {
    public double converte(double value);
    Conversor clone();
} 
