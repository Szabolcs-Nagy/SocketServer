package ds.socket.client;

import ds.socket.server.MySocketServerApp;
import ds.socket.server.model.Message;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MySocketClientApp {

    public static final int PORT = MySocketServerApp.PORT;
    public static final String HOST = "localhost";

    
    public static void main(String[] args) {
        try {
            Socket socket = new Socket(HOST, PORT);
            
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
           
            Message msg = new Message("Hello from the Client");
            out.writeObject(msg);
            
            Message returnedMsg = (Message) in.readObject();
            
            System.out.println("CLIENT: Received message = "+returnedMsg.getValue());
            
        } catch (IOException ex) {
            ex.printStackTrace();        
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
        
    }
    
}
