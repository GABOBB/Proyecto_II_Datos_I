/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package c_interface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;

public class C_interface extends Application {
    
    @Override
    
    public void start(Stage pstage){
        send("Hello world from client!!");
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(C_interface.class.getResource("/visual/FXMLmain.fxml"));
            Pane ventana = (Pane) loader.load();
            Scene scene = new Scene(ventana);
            pstage.setScene(scene);
            FXMLmainC c = loader.getController();
            //c.setStage(pstage);
            pstage.show();
        }catch(IOException e){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setTitle("Error");
            a.setContentText("error cargando la ventana");
            a.showAndWait();  
            
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public void send(String a){
        final String HOST = "127.0.0.1";
        final int PORT = 5000;
        DataInputStream in;
        DataOutputStream out;
        
        try {
            Socket clientSocket = new Socket(HOST, PORT);

            in = new DataInputStream(clientSocket.getInputStream());
            out = new DataOutputStream(clientSocket.getOutputStream());

            out.writeUTF(a);

            String message = in.readUTF();
            System.out.println(message);

            clientSocket.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}