/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FilesLoader;

import estructuras_de_datos.Lista_D_E_C;
import estructuras_de_datos.Nodo_D_E_C;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author RYZEN
 */
public class OrderFiles {
    public static void OrderByNames() throws IOException{
        //Lista_D_E_C BigList = new Lista_D_E_C();
        //BigList = FilesReader.readFiles();
        Lista_D_E_C documents = FileToListByLines.leer_lineas("Biblioteca/ExistingFiles.txt");
        Lista_D_E_C time = FileToListByLines.leer_lineas("Biblioteca/TimeFiles.txt");
        Path fileName = Path.of("Biblioteca/ExistingFiles.txt");
        String str = Files.readString(fileName);
        System.out.println(str);
        
        //Nodo_D_E_C actual = documents.getHead();
        //do {
            
        //} while (documents.getHead() != actual);
        
    }
    public static void OrderByDate() {
        
    }
    public static void OrderByLength() {
        
    }
}
