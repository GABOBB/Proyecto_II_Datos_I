/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FilesLoader;

import static FilesLoader.FileToListByLines.LoadFileInList;
import static FilesLoader.ReadFile.readDocx;
import static FilesLoader.ReadFile.readPdf;
import static FilesLoader.ReadFile.readTxt;
import estructuras_de_datos.Lista_D_E_C;
import estructuras_de_datos.Nodo_D_E_C;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author RYZEN
 */
public class FilesReader {
    public static Lista_D_E_C readFiles() throws FileNotFoundException, IOException{
        Lista_D_E_C returnable = new Lista_D_E_C();
        Lista_D_E_C documents = new Lista_D_E_C();
        Lista_D_E_C words = new Lista_D_E_C();
        documents = FileToListByLines.leer_lineas("Biblioteca/ExistingFiles.txt");
        //System.out.println(documents.getHead());
        Nodo_D_E_C actual = documents.getHead();
        do{
            String temp = actual.getId();
            System.out.println(actual.getId());
            String [] parts;
            parts = temp.split("\\.");
            String lastPart = parts[parts.length - 1];
            System.out.println(lastPart);
            
            if(lastPart.equals("pdf")){
                words = readPdf("Biblioteca/" + actual.getId());
                Nodo_D_E_C nodo = new Nodo_D_E_C(actual.getId(), words);
            } else if (lastPart.equals("docx")){
                words = readDocx("Biblioteca/" + actual.getId());
                Nodo_D_E_C nodo = new Nodo_D_E_C(actual.getId(), words);
            } else if (lastPart.equals("txt")){
                words = readTxt("Biblioteca/" + actual.getId());
                Nodo_D_E_C nodo = new Nodo_D_E_C(actual.getId(), words);
            }
            
            actual = actual.get_N();
        } while (documents.getHead() != actual);
        
        
        return returnable;
    }
}
