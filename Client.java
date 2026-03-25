import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 5000;

        try {
            Socket socket = new Socket(host, port);

            Scanner scanner = new Scanner(System.in);

            System.out.print("digite a base: ");
            String base = scanner.nextLine();

            System.out.print("digite a altura: ");
            String altura = scanner.nextLine();

            String mensagem = base + "," + altura;

            OutputStream output = socket.getOutputStream();
            output.write(mensagem.getBytes());

            InputStream input = socket.getInputStream();
            byte[] resposta = new byte[1024];
            int tamanho = input.read(resposta);

            System.out.println("resposta do servidor: " + new String(resposta, 0, tamanho));

            socket.close();

        } catch (Exception e) {
            System.out.println("erro: " + e.getMessage());
        }
    }
}