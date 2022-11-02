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

 /**
 * Clase para abrir los arvhivos seleccionados en el lo que se pueda leer
 * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556, gabriel 
 */
public class AbrirArchivos {
    
    public static void abrir(String id) throws IOException{
        
        ProcessBuilder p = new ProcessBuilder();

        p.command("cmd.exe", "/c", "Biblioteca\\" + id );
        
        p.start();

    }
    
}
