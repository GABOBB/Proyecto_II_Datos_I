/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package c_interface;

import java.io.File;
import java.io.IOException;
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
}
