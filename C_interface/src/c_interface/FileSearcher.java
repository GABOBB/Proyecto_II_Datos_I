/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package c_interface;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javafx.stage.FileChooser;

/**
 *
 * @author RYZEN
 */
public class FileSearcher {
    public static String FindFile() throws IOException{
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        return selectedFile.getAbsolutePath();
    }
 
    public static String FindMultiple(){
        FileChooser filechooser = new FileChooser();
        filechooser.setTitle ("Open Multiple Files Dialog");
        
        //esta lista es usada por que la biblioteca lo requiere
        List <File> list =  filechooser.showOpenMultipleDialog(null);
        String varios_archivos = "";
        if (list!= null){
            varios_archivos += "variosarchivos";
            for (int i=0;i<list.size();i++){
                varios_archivos+= "-_-"  + list.get(i);
                System.out.println(list.get(i));
                
            }
            
            
        }
        System.out.println(varios_archivos + "ESTOS SON VARIOS ARCHIVOS");
        return varios_archivos;
        
    }
}
