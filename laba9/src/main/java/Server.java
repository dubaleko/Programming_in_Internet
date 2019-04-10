import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public  static  void  main(String[] args) throws IOException {
        try(ServerSocket serverSocket = new ServerSocket(8190, 2)) {
            Socket socket = serverSocket.accept();
            Scanner scanner = new Scanner(socket.getInputStream());
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            System.out.println(scanner.nextLine());
            while(scanner.hasNextLine())
            {
                String str  = scanner.nextLine();
                System.out.println(str);
                if (str.equals("exit"))
                    break;
            }
        }
    }
}
