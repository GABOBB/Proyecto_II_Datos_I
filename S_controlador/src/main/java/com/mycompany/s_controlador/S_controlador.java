package com.mycompany.s_controlador;

import estructuras_de_datos.Lista_D_E_C;
import estructuras_de_datos.Nodo_D_E_C;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import FilesLoader.ReadFile;



/**
 * @author Gabriel
 */
public class S_controlador {
    private Lista_D_E_C documentos = new Lista_D_E_C();
    private Lista_D_E_C avl = new Lista_D_E_C();
    private Lista_D_E_C bst = new Lista_D_E_C();
    
    public S_controlador(){
        cargar();
    }

    public static void main(String[] args) throws IOException {
        new S_controlador();
    }
    
    
    public void cargar(){
        on_server();
    }
    public void on_server(){
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        DataInputStream in;
        DataOutputStream out;
        final int PORT = 5000;
        final boolean FLAG = true;


        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is On!");

            while (true) {
                clientSocket = serverSocket.accept();
                System.out.println("Client Connected [1]");

                in = new DataInputStream(clientSocket.getInputStream());
                out = new DataOutputStream(clientSocket.getOutputStream());

                String message = in.readUTF();
                System.out.println(message);
                if (message.equals("FILECHOOSER")){
                    ReadFile docx= new ReadFile();
                    docx.readDocx("Tareaextraclaseresolucion.docx");
                    out.writeUTF("sincolo@@@<html><head></head><body>hola como estamos</body></html>");

                }else{out.writeUTF("colo**@@@<html><head></head><body>hola<font color = green> como es</font>tamos</body></html>-_-sincolo@@@<html><head></head><body>hola como estamos</body></html>");

                }
                clientSocket.close();
                System.out.println("client disconnected[1]");
            }
        } catch (IOException e) {
            Logger.getLogger(S_controlador.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    private String to_html_fraces(Lista_D_E_C lista){
        boolean closed = true;
        Nodo_D_E_C actual = lista.getHead();
        String html = "<html><head></head><body>";
        while(actual.get_N()!=lista.getHead()){
            
            if(actual.getFlag() && closed){
                
                html+="<font color = red>";
                html+=" "+actual.getId();
                closed=false;
                
            }else if(actual.getFlag() && !closed){
                html+=" "+actual.getId();
            }else if (!actual.getFlag() && !closed){
                html+="</font>";
                html+=" "+actual.getId();
                closed=true;
            }else{
                html+=" "+actual.getId();
            }
            actual = actual.get_N();
        }
        html += "</body></html>";
        return html;
    }
}
