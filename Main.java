import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.OutputStream;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Starting server...");

            ServerSocket ss = new ServerSocket(8080);
            System.out.println("Server started. Listening on port 8080");
            
            Socket socket = ss.accept();
            System.out.println("Client accepted");
            
            Path filePath = Paths.get("data.txt");
            byte[] fileBytes = Files.readAllBytes(filePath);

            OutputStream output = socket.getOutputStream();

            String headers = "HTTP/1.1 200 OK\r\n" +
                            "Content-Length: " + fileBytes.length + "\r\n" +
                            "Content-Type: text/plain\r\n" +
                            "\r\n";

            output.write(headers.getBytes(StandardCharsets.UTF_8));
            output.write(fileBytes);
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}