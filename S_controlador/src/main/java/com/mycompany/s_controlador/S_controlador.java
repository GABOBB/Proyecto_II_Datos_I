package com.mycompany.s_controlador;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Gabriel
 */
public class S_controlador {

 public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        DataInputStream in;
        DataOutputStream out;
        final int PORT = 5000;
        final boolean FLAG = true;
       
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is On !");

            while (true) {
                clientSocket = serverSocket.accept();
                System.out.println("Client Connected");

                in = new DataInputStream(clientSocket.getInputStream());
                out = new DataOutputStream(clientSocket.getOutputStream());

                String message = in.readUTF();
                System.out.println(message);
                if (message.equals("FILECHOOSER")){
                    System.out.println("Works");
                }

                out.writeUTF("Message received");

                clientSocket.close();
                System.out.println("client disconnected");
            }
        } catch (IOException e) {
            Logger.getLogger(S_controlador.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
