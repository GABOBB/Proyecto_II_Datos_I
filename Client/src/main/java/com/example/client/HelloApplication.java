package com.example.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        final String HOST = "127.0.0.1";
        final int PORT = 5000;
        DataInputStream in;
        DataOutputStream out;

        try {
            Socket clientSocket = new Socket(HOST, PORT);

            in = new DataInputStream(clientSocket.getInputStream());
            out = new DataOutputStream(clientSocket.getOutputStream());

            out.writeUTF("Hello world from client!!");

            String message = in.readUTF();
            System.out.println(message);

            clientSocket.close();

        } catch (IOException e) {
            System.out.println(e);
        }
        launch();
    }
}