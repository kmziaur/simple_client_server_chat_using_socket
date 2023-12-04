//K.M Ziaur Rahman
//CSE, BRUR

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        try (ServerSocket serverSocket = new ServerSocket(3333)) {

            System.out.println("Welcome to Server ChatSide");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected Successfully, Now start Chatting");

            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

            while (true) {

                Object text = in.readObject();
                System.out.println("Client Says: " + (String) text);

                Scanner snrs = new Scanner(System.in);
                String text1 = snrs.nextLine();

                out.writeObject(text1);
            }
        }

    }
}
