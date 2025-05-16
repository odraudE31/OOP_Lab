import java.io.*;
import java.net.*;
import java.util.Scanner;

public class CalculatorClient {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println("[WARN] use: java CalculatorClient <IP> <porta>");
            return;
        }

        String servidor = args[0];
        int porta = Integer.parseInt(args[1]);

        Socket socket = new Socket(servidor, porta);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        Scanner teclado = new Scanner(System.in);

        System.out.println("Connected to server. Type two ints or 'q' to quit.");

        while (true) {
            System.out.print("Type two ints separated by a space: ");
            String linha = teclado.nextLine();

            if (linha.equalsIgnoreCase("q")) {
                out.println("you quitted");
                break;
            }

            out.println(linha);
            String resposta = in.readLine();
            System.out.println("Server response to sum: " + resposta);
        }

        teclado.close();
        in.close();
        out.close();
        socket.close();
    }
}
