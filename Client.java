//K.M Ziaur Rahman
//CSE,BRUR

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException {

        System.out.println("Welcome to Client ChatSide");
        Socket socket = new Socket("127.0.0.1", 3333);
        System.out.println("Server connected successfully,Now start chatting: ");

        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        Scanner snr = new Scanner(System.in);
        String text = snr.nextLine();
        out.writeObject(text);

        while (true) {
            try {

                Object gettext = in.readObject();
                System.out.println("Server Says: " + (String) gettext);

                String text2 = snr.nextLine();
                out.writeObject(text2);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
