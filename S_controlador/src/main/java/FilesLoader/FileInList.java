/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FilesLoader;

import estructuras_de_datos.DCLinkedList;
import estructuras_de_datos.Lista_D_E_C;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author RYZEN
 */
public class FileInList {
     /**
     * Metodo para cargar un archivo en lista doblemente enlazada
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public static DCLinkedList<String> LoadFileOfStringsIntoDCLinkedList(File file) throws FileNotFoundException {
            DCLinkedList<String> list = new DCLinkedList<>();
            Scanner scan = new Scanner(file);

            int count = 0;

            while(scan.hasNext()) {
                String word = scan.next();
                list.add(word);
                count = count + 1;
            }

            return list;
        }
}
