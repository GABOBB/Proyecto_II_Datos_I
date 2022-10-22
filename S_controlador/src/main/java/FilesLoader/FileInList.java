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
    public static DCLinkedList<String> LoadFileOfStringsIntoDCLinkedList(File file) throws FileNotFoundException {
        DCLinkedList<String> list = new DCLinkedList<>();
        //Se coloca en el scanner el archivo para leerlo
        Scanner scan = new Scanner(file);
        //Se hace un while para que se lea mientras haya siguiente línea
        scan.useDelimiter("[^A-Za-z]+");
        while (scan.hasNextLine()){
            list.add(scan.nextLine());
        }
        return list;
    }
    
    
}
