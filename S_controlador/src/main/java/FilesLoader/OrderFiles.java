/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FilesLoader;

import AlgoritmosOrdenamiento.Quicksort;
import AlgoritmosOrdenamiento.BubbleSort;
import AlgoritmosOrdenamiento.Radix;
import com.mycompany.s_controlador.S_controlador;
import estructuras_de_datos.Lista_D_E_C;
import estructuras_de_datos.Nodo_D_E_C;
import java.io.BufferedWriter;
import java.io.File;
import FilesLoader.FilesReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author RYZEN
 */
public class OrderFiles {
    private static Lista_D_E_C LoadBigList() throws IOException{
        Lista_D_E_C BigList = new Lista_D_E_C();
        BigList = FilesReader.readFiles();
        return BigList; 
    }
    public static Lista_D_E_C OrderByNames() throws IOException{
        //Lista_D_E_C BigList = new Lista_D_E_C();
        //BigList = FilesReader.readFiles();
        
        
        Path fileName = Path.of("Biblioteca/ExistingFiles.txt");
        String str = Files.readString(fileName);
        
        Path timeName = Path.of("Biblioteca/TimeFiles.txt");
        String tstr = Files.readString(timeName);
        
        System.out.println("EXISTINGFILES");
        //System.out.println(str);
        String [] parts;
        parts = str.split("\n");
        System.out.println(parts.length);
        
        String [] timeParts;
        timeParts = tstr.split("\n");
        
        //System.out.println(parts.length)
        
        parts = Quicksort.quickSort(parts);
        
        File BibliotecaInfo = new File("Biblioteca/ExistingFiles.txt");
        FileWriter DocumentsWriter = new FileWriter(BibliotecaInfo, false);
        BufferedWriter DocumentsBw = new BufferedWriter(DocumentsWriter);
        DocumentsBw.write(parts[0].substring(0, parts[0].length() - 1));
        DocumentsBw.newLine();
        DocumentsBw.write(parts[1].substring(0, parts[1].length() - 1));
        DocumentsBw.newLine();
        DocumentsBw.write(parts[2].substring(0, parts[2].length() - 1));
        DocumentsBw.newLine();
        DocumentsBw.write(parts[3].substring(0, parts[3].length() - 1));
        DocumentsBw.newLine();
        DocumentsBw.close();
        
        File TimeInfo = new File("Biblioteca/TimeFiles.txt");
        FileWriter TimeWriter = new FileWriter(TimeInfo, false);
        BufferedWriter TimeBw = new BufferedWriter(TimeWriter);
        
        for(int i = 0; i < parts.length; i++){
            for(int k = 0; k < timeParts.length; k++){
                if(timeParts[k].contains(parts[i].substring(0, parts[i].length() - 1))){
                    System.out.println("ESCRIBE");
                    TimeBw.write(timeParts[k].substring(0, timeParts[k].length() - 1));
                    TimeBw.newLine();
                }
            }
        }
        TimeBw.close(); 
        return LoadBigList();
        
    }
    public static Lista_D_E_C OrderByDate() throws IOException {
        Path fileName = Path.of("Biblioteca/ExistingFiles.txt");
        String str = Files.readString(fileName);
        
        Path timeName = Path.of("Biblioteca/TimeFiles.txt");
        String tstr = Files.readString(timeName);
        
        File BibliotecaInfo = new File("Biblioteca/ExistingFiles.txt");
        FileWriter DocumentsWriter = new FileWriter(BibliotecaInfo, false);
        BufferedWriter DocumentsBw = new BufferedWriter(DocumentsWriter);
        
        File TimeInfo = new File("Biblioteca/TimeFiles.txt");
        FileWriter TimeWriter = new FileWriter(TimeInfo, false);
        BufferedWriter TimeBw = new BufferedWriter(TimeWriter);
        
        
        System.out.println("EXISTINGFILES");
        //System.out.println(str);
        
        String [] parts;
        parts = str.split("\n");
        
        System.out.println("CANT DE NUMEROS");
        System.out.println(parts.length);
        
        String [] dateParts;
        dateParts = tstr.split("@1729@");
        
        String [] wholeParts;
        wholeParts = tstr.split("\n");
        System.out.println("CANT DE WHOLE" + wholeParts.length);
        
        int amountOfData;
        amountOfData = parts.length;
        
        System.out.println(dateParts.length);
        long infoArray[] = new long[amountOfData];
        int w = 0;
        for(int i = 0; i < dateParts.length; i++){
            if(i%3 == 1){
                long info = (long) (Integer.parseInt(dateParts[i + 1].substring(0,4))*Math.pow(10, 10)
                        + Integer.parseInt(dateParts[i + 1].substring(5,7))*Math.pow(10, 8)
                        + Integer.parseInt(dateParts[i + 1].substring(8,10))*Math.pow(10, 6)
                        + Integer.parseInt(dateParts[i].substring(0,2))*Math.pow(10, 4)
                        + Integer.parseInt(dateParts[i].substring(3,5))*Math.pow(10, 2)
                        + Integer.parseInt(dateParts[i].substring(6,8))*Math.pow(10, 0));
                //System.out.println(info);
                infoArray[w] = info;
                w = w + 1;
            }
        }
        
        
        BubbleSort.bubbleSort(infoArray);
        System.out.println("ORDENADOS");
        
        
        
        for(int i = 0; i < wholeParts.length; i++){
            String date; 
            date = dateParts[3*i + 2].substring(0, 4) +
                    dateParts[3*i + 2].substring(5, 7) + 
                    dateParts[3*i + 2].substring(8, 10) + 
                    dateParts[3*i + 1].substring(0, 2) +
                    dateParts[3*i + 1].substring(3, 5)+
                    dateParts[3*i + 1].substring(6, 8);
            //System.out.println(date + "DATE");
            
            for(int k = 0; k < infoArray.length; k++){
                String temp = Long.toString(infoArray[k]);
                //System.out.println(temp + "TEMP");
                if(temp.equals(date)){
                    System.out.println("TRUE");
                    System.out.println(wholeParts[k].substring(0, wholeParts[k].length() - 1));
                    System.out.println(parts[k].substring(0, parts[k].length() - 1));
                    TimeBw.write(wholeParts[k].substring(0, wholeParts[k].length() - 1));
                    TimeBw.newLine();
                    DocumentsBw.write(parts[k].substring(0, parts[k].length() - 1));
                    DocumentsBw.newLine();
                }
            }
        }
        TimeBw.close();
        DocumentsBw.close();
        return LoadBigList();
        
    }
    public static Lista_D_E_C OrderByLength() throws IOException {
        Lista_D_E_C BigList = new Lista_D_E_C();
        Lista_D_E_C LocalList = new Lista_D_E_C();
        BigList = FilesReader.readFiles();
        
        Path fileName = Path.of("Biblioteca/ExistingFiles.txt");
        String str = Files.readString(fileName);
        
        Path timeName = Path.of("Biblioteca/TimeFiles.txt");
        String tstr = Files.readString(timeName);
        
        String [] parts;
        parts = str.split("\n");
        
        String [] tparts;
        tparts = tstr.split("\n");
        
        
        
        Nodo_D_E_C actual = BigList.getHead();
        do {
            System.out.println(actual.getId());
            actual = actual.get_N();
        } while (actual != BigList.getHead());
        

        //Nodo_D_E_C TextList = BigList.Buscar("Bendecida.txt");
        //LocalList = (Lista_D_E_C) TextList.getData();
        //System.out.println(LocalList.size);
        
        String files;
        files = "";
        int directions[];
        directions = new int[parts.length];
        
        String[] filesParts; 
        
        
        for(int i = 0; i < parts.length; i++){
            Nodo_D_E_C TextList = BigList.Buscar(parts[i].substring(0, parts[i].length() - 1));
            LocalList = (Lista_D_E_C) TextList.getData();
            System.out.println(LocalList.size);
            directions[i] = LocalList.size;
            files += parts[i].substring(0, parts[i].length() - 1) + "@1729@" + LocalList.size + "@1729@";
        }
        
        filesParts = files.split("@1729@");
        
        Radix.radixsort(directions, directions.length);
        
        System.out.println("COMIENZA");
        
        for(int i = 0; i < directions.length; i++){
            System.out.println(directions[i]);
            //System.out.println(filesParts[i]);
        }
        System.out.println("PARTS");
        for(int i = 0; i < filesParts.length; i++){
            System.out.println(filesParts[i]);    
        }
        
        System.out.println("PARTS2");
        
        File BibliotecaInfo = new File("Biblioteca/ExistingFiles.txt");
        FileWriter DocumentsWriter = new FileWriter(BibliotecaInfo, false);
        BufferedWriter DocumentsBw = new BufferedWriter(DocumentsWriter);
        
        File TimeInfo = new File("Biblioteca/TimeFiles.txt");
        FileWriter TimeWriter = new FileWriter(TimeInfo, false);
        BufferedWriter TimeBw = new BufferedWriter(TimeWriter);
        
        for(int i = 0; i < directions.length; i++){
            for(int k = 0; k < filesParts.length; k++){
                String dir = Integer.toString(directions[i]);
                if(dir.equals(filesParts[k])){
                    System.out.println(filesParts[k - 1]);
                    DocumentsBw.write(filesParts[k - 1]);
                    DocumentsBw.newLine();
                    System.out.println(filesParts[k]);
                    for(int w = 0; w < tparts.length; w++){
                        if(tparts[w].contains(filesParts[k - 1])){
                            System.out.println(tparts[w]);
                            TimeBw.write(tparts[w].substring(0, tparts[w].length() - 1));
                            TimeBw.newLine();
                        }
                    }
                }
            }
        }
        DocumentsBw.close();
        TimeBw.close();
        return LoadBigList();
        
    }

   
}
