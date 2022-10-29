/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FilesLoader;

import estructuras_de_datos.Lista_D_E_C;
import estructuras_de_datos.Nodo_D_E_C;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author RYZEN
 */
public class FileToListByLines {
    public static Lista_D_E_C LoadFileInList(File file) throws FileNotFoundException{
        Lista_D_E_C list = new Lista_D_E_C();
        Scanner scan = new Scanner(file);
        while(scan.hasNextLine()){
            Nodo_D_E_C nodo = new Nodo_D_E_C(scan.nextLine());
            list.add_n_last(nodo);
        }
        return list;
    }
    public static Lista_D_E_C leer_lineas(String _D){
        Lista_D_E_C lista = new Lista_D_E_C();
        try{
            BufferedReader bf = new BufferedReader(new FileReader(_D));
            String bfRead;
            while((bfRead = bf.readLine())!=null){
                Nodo_D_E_C nodo = new Nodo_D_E_C(bfRead);
                lista.add_n_last(nodo);
            }
            return lista;
        }catch(IOException e){
            System.err.println(e);
            return null;
        }
    }
}
