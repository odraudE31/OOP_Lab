import java.util.Scanner;

public class ConversorTemp {
    public static void main(String[] args) {
        if(args.length > 0){
            int escolha = Integer.parseInt(args[0]);

            try (Scanner scan = new Scanner(System.in)) {
                double value = scan.nextDouble();
                
                redirectConversion(escolha, value);
            }
        } 
        
        else {
            System.out.print("\n1) C para F" + 
                             "\n2) F para C" +
                             "\n3) C para K" +
                             "\n4) K para C" +
                             "\n5) K para F\n");
        }
    }

    private static void redirectConversion(int escolha, double value){
        Formulas formula = new Formulas();
        PrintingSolutions prints = new PrintingSolutions();
        double result;

        switch (escolha) {
            case 1:
                result = formula.C2F(value);
                prints.printFarenheit(result);
                break;
            
            case 2:
                result = formula.F2C(value);
                prints.printCelsius(result);
                break;
            
            case 3:
                result = formula.C2K(value);
                prints.printKelvin(result);
                break;

            case 4:
                result = formula.K2C(value);
                prints.printCelsius(result);
                break;

            default:
                result = formula.K2F(value);
                prints.printFarenheit(result);
                break;
        }
    }
}

class Formulas{
    // Beware that the names are small due to the simplicity of the program

    public double C2F(double value){
        return (value * 9/5) + 32;
    }

    public double F2C(double value){
        return (value - 32) * 5/9;
    }

    public double C2K(double value){
        return value + 273.15;
    }

    public double K2C(double value){
        return value - 273.15;
    }

    public double K2F(double value){
        return (value - 273.15) * 9/5 + 32;
    }
}

class PrintingSolutions {
    public void printFarenheit(double result){
        System.out.println("A temperatura em Farenheit é: " + result);
    }

    public void printKelvin(double result){
        System.out.println("A temperatura em Kelvin é: " + result);
    }

    public void printCelsius(double result){
        System.out.println("A temperatura em Celsius é: " + result);
    }
}
