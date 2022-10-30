/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FilesLoader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.LocalTime;



/**
 *
 * @author RYZEN
 */
public class FileCopy {
    static LocalTime localTime;
    static LocalDate localDate;
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
        localTime = LocalTime.now();
        localDate = LocalDate.now();
        
        File selectedFile = new File(Path);
        
        File LoadedFiles = new File("Biblioteca/ExistingFiles.txt");
        File TimeFiles = new File("Biblioteca/TimeFiles.txt");
        FileWriter LoadedFilesWriter = new FileWriter(LoadedFiles, true);
        FileWriter LoadedTimeWriter = new FileWriter(TimeFiles, true);
        
        BufferedWriter FileBw = new BufferedWriter(LoadedFilesWriter);
        BufferedWriter TimeBw = new BufferedWriter(LoadedTimeWriter);
        
        String time;
        time = String.valueOf(localTime);
        String parts = time.substring(0, 8);
        
        
        FileBw.write(selectedFile.getName());
        TimeBw.write(selectedFile.getName() + "@1729@" + parts + "@1729@" + String.valueOf(localDate));
        
        FileBw.newLine();
        TimeBw.newLine();
        TimeBw.close();
        FileBw.close();
        
        File UserFile = new File("Biblioteca/" + selectedFile.getName());
        System.out.println(selectedFile.getName());
        FileWriter file = new FileWriter("Biblioteca/" + selectedFile.getName(), true);
        copyFileUsingStream(selectedFile, UserFile);//Se llama al metodo para copiar el archivo de la cancion en la ruta definida
        //return selectedFile.getAbsolutePath();
    }    
}
