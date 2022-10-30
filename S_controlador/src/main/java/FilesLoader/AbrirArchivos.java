/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FilesLoader;

import java.io.IOException;

/**
 *
 * @author Admin
 */
public class AbrirArchivos {
    
    public static void abrir(String id) throws IOException{
        
        ProcessBuilder p = new ProcessBuilder();

        p.command("cmd.exe", "/c", "Biblioteca\\" + id );
        System.out.println("si funciona arturo se la chupa a marco");
        
        p.start();

    }
    
}
