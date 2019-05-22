package bio.echo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIOEchoService {

    //服務端处理业务逻辑线程池
    private static final ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {

        int port = 8082;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            Socket socket = null;
            while (true) {
                socket = serverSocket.accept();
                executor.submit(new BIOEchoServerHandler(socket));
            }
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }

    }

}
