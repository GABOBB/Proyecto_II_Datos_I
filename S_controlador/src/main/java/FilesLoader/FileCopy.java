/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FilesLoader;

import estructuras_de_datos.Lista_D_E_C;
import estructuras_de_datos.Nodo_D_E_C;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;



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
        TimeBw.write(selectedFile.getName() + "@1729@" + parts + "@1729@" + String.valueOf(localDate) + "@1729@");
        
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
    public static void FileErraser(String Path) throws FileNotFoundException, IOException{
        Lista_D_E_C listFiles = listToFilesByLines("Biblioteca/ExistingFiles.txt");
        Lista_D_E_C listDates = listToFilesByLines("Biblioteca/TimeFiles.txt");
        
        
        File selectedFile = new File("Biblioteca/" + Path);
        System.out.println("Biblioteca/"+ Path);
        Path errPath = Paths.get(selectedFile.getAbsolutePath());
        System.out.println(selectedFile.getAbsolutePath());
        try {
            Files.delete(errPath);
        } catch (Exception e){
            System.out.println("El error " + e);
        }
        
        
        
        
        File BibliotecaInfo = new File("Biblioteca/ExistingFiles.txt");
        File TimeInfo = new File("Biblioteca/TimeFiles.txt");
        
        FileWriter DocumentsWriter = new FileWriter(BibliotecaInfo, false);
        BufferedWriter DocumentsBw = new BufferedWriter(DocumentsWriter);
        
        FileWriter TimeWriter = new FileWriter(TimeInfo, false);
        BufferedWriter TimeBw = new BufferedWriter(TimeWriter);
        
        
        Nodo_D_E_C actual = listFiles.getHead();
        do {
        if(!actual.getId().contains(Path)){
            System.out.println(actual.getId() + "Primer ID");
            DocumentsBw.write(actual.getId());
            DocumentsBw.newLine();
        }
        actual = actual.get_N();
        } while (actual != listFiles.getHead());
        
        Nodo_D_E_C actual2 = listDates.getHead();
        do {
            if(!actual2.getId().contains(Path)){
                System.out.println(actual2.getId() + "Segundo ID");
                TimeBw.write(actual2.getId());
                TimeBw.newLine();
        }
        actual2 = actual2.get_N();
        
        
        } while (actual2 != listDates.getHead());
        
        DocumentsBw.close();
        TimeBw.close();
    }
    public static Lista_D_E_C listToFilesByLines(String Path) throws FileNotFoundException{
        
        Lista_D_E_C list = new Lista_D_E_C();
        File file = new File(Path);
        Scanner scan = new Scanner(file);
        
        while(scan.hasNext()){
            
            String word = scan.next();
            Nodo_D_E_C nodo = new Nodo_D_E_C(word);
            list.add_n_last(nodo);
            
        }
        return list;
    }
}