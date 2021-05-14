package ds.socket.server;

import ds.socket.server.model.Message;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MySocketServerApp {

    public static final int PORT = 4000;

    public static void main(String[] args) {
        // TODO code application logic here
            MySocketServerApp server = new MySocketServerApp();
            server.runServer();
    }
    
    public void runServer(){
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("SERVER is ready...");
            
            Socket socket = serverSocket.accept();
            
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            
            Message message = (Message) in.readObject();
            process (message);
            out.writeObject(message);
            socket.close();
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    private void process (Message message) {
        //TODO, example capitalise the content of the message
        System.out.println("SERVER: Received message for processing = "+message.getValue());

        message.setValue(message.getValue().toUpperCase());
    }
}
