import java.io.*;
import java.net.*;

public class CalculatorServer {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("[WARN] use: java CalculatorServer <porta>");
            return;
        }

        int porta = Integer.parseInt(args[0]);

        ServerSocket servidor = new ServerSocket(porta);
        System.out.println("Server started at port " + porta + ". Awaiting connection...");

        Socket cliente = servidor.accept();
        System.out.println("Client connected: " + cliente.getInetAddress().getHostAddress());

        BufferedReader in = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
        PrintWriter out = new PrintWriter(cliente.getOutputStream(), true);

        String linha;
        while ((linha = in.readLine()) != null) {
            if (linha.equalsIgnoreCase("q")) {
                break;
            }

            try {
                String[] partes = linha.split(" ");
                int a = Integer.parseInt(partes[0]);
                int b = Integer.parseInt(partes[1]);
                int soma = a + b;
                out.println("Result: " + soma);
            } catch (Exception e) {
                out.println("[ERR] invalid entry.");
            }
        }

        System.out.println("Connection ended.");
        in.close();
        out.close();
        cliente.close();
        servidor.close();
    }
}
