/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FilesLoader;



import estructuras_de_datos.Lista_D_E_C;
import estructuras_de_datos.Nodo_D_E_C;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.Loader;

import org.apache.pdfbox.pdmodel.PDDocument;

import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

import org.apache.poi.xwpf.usermodel.XWPFDocument; 
import org.apache.poi.xwpf.usermodel.XWPFParagraph;




/**
 *
 * @author Michael/Gabriel
 */
public class ReadFile {

    public static Lista_D_E_C readPdf(String files) throws IOException {
        Lista_D_E_C list = new Lista_D_E_C();
       
        File file = new File(files);
        PDDocument document =  Loader.loadPDF(file);

        PDFTextStripper pdfStripper = new PDFTextStripper();
        
        String[] text = pdfStripper.getText(document).split(" ");
        
        //System.out.println(text)

        document.close();
        
        for(String i : text){
            Nodo_D_E_C nodo = new Nodo_D_E_C(i);
            list.add_n_last(nodo);  
        }
        return list;
    }
    
    public static Lista_D_E_C readDocx(String files) throws IOException{
       
        Lista_D_E_C list = new Lista_D_E_C();
        
        try {
            FileInputStream fis = new FileInputStream(files);

            XWPFDocument docx = new XWPFDocument(fis) ;
            XWPFWordExtractor text_W = new XWPFWordExtractor(docx);
            String[] text = text_W.getText().split(" ");
            for(String i : text){
                Nodo_D_E_C nodo = new Nodo_D_E_C(i);
                list.add_n_last(nodo);
            }
            
            return list;
            
        } catch (FileNotFoundException e) {
            System.err.println(e);
            return null;
        }
        
           
    }
    
    public static Lista_D_E_C readTxt(String __D){
        /**
         * se encarga de leer archivos txt
         * parametros: 
         * -string __D (la direccion del archivo)
         */
        String text = "";
        try{
            BufferedReader bf = new BufferedReader(new FileReader(__D));
            String bfRead;
            while((bfRead = bf.readLine())!=null){
                text += bfRead +" ";
            }
            String[] text_aux = text.split(" ");
            Lista_D_E_C lista = new Lista_D_E_C();
            for(String i : text_aux){
                Nodo_D_E_C nodo = new Nodo_D_E_C(i);
                lista.add_n_last(nodo);
            }
            return lista;
        }catch(IOException e){
            System.err.println(e);
            return null;
        }
    }
}
