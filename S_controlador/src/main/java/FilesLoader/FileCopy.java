/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FilesLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;



/**
 *
 * @author RYZEN
 */
public class FileCopy {
    public static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }

    public static void FileLoader(String Path) throws IOException, NullPointerException {
        System.out.println("FUNCIONA");
        File selectedFile = new File(Path);
        File UserFile = new File("Biblioteca/" + selectedFile.getName());
        System.out.println(selectedFile.getName());
        FileWriter file = new FileWriter("Biblioteca/" + selectedFile.getName(), true);
        copyFileUsingStream(selectedFile, UserFile);//Se llama al metodo para copiar el archivo de la cancion en la ruta definida
        //return selectedFile.getAbsolutePath();
    }    
}
