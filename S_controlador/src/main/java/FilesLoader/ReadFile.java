/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FilesLoader;



import estructuras_de_datos.Lista_D_E_C;
import estructuras_de_datos.Nodo_D_E_C;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.Loader;

import org.apache.pdfbox.pdmodel.PDDocument;

import org.apache.pdfbox.text.PDFTextStripper;

import org.apache.poi.xwpf.usermodel.XWPFDocument; 
import org.apache.poi.xwpf.usermodel.XWPFParagraph;




/**
 *
 * @author Admin
 */
public class ReadFile {

    public Lista_D_E_C readPdf(String files) throws IOException {
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
    
    public Lista_D_E_C readDocx(String files) throws IOException{
        Lista_D_E_C list = new Lista_D_E_C();
        try {
            FileInputStream fis = new FileInputStream(files);

            XWPFDocument docx = new XWPFDocument(fis) ;
            
            List<XWPFParagraph> paragraphList = docx.getParagraphs();


            for(XWPFParagraph paragraph: paragraphList){

               
            }

        } catch (FileNotFoundException e) {
            
        }
        return null;
        
    }
}
