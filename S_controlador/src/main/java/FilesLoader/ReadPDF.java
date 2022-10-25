/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FilesLoader;



import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.Loader;

import org.apache.pdfbox.pdmodel.PDDocument;

import org.apache.pdfbox.text.PDFTextStripper;
/**
 *
 * @author Admin
 */
public class ReadPDF {

    public void read(String files) throws IOException {
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
}
