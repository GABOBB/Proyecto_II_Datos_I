/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FilesLoader;



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

    public void readPdf(String files) throws IOException {
        //Loading an existing document
      File file = new File(files);
      PDDocument document =  Loader.loadPDF(file);
      //Instantiate PDFTextStripper class
      PDFTextStripper pdfStripper = new PDFTextStripper();

      //Retrieving text from PDF document
      String text = pdfStripper.getText(document);
      System.out.println(text);

      //Closing the document
      document.close();
    }
    
    public void readDocx(String files) throws IOException{
        try {
            FileInputStream fis = new FileInputStream(files);

            XWPFDocument docx = new XWPFDocument(fis) ;
            
            List<XWPFParagraph> paragraphList = docx.getParagraphs();


            for(XWPFParagraph paragraph: paragraphList){

               System. out.println(paragraph.getText());
            }

        } catch (FileNotFoundException e) {
            
        }
        
    }
}
