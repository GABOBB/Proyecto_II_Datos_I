package com.mycompany.s_controlador;

import estructuras_de_datos.Lista_D_E_C;
import estructuras_de_datos.Nodo_D_E_C;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Gabriel
 */
public class Archivos {
    public Lista_D_E_C leerA(String __D){
        String text = "";
        try{
            BufferedReader bf = new BufferedReader(new FileReader(__D));
            String bfRead;
            while((bfRead = bf.readLine())!=null){
                text += bfRead;
            }
            String[] text_aux = text.split(" ");
            Lista_D_E_C lista = new Lista_D_E_C();
            for(String i : text_aux){
                Nodo_D_E_C nodo = new Nodo_D_E_C(i);
                lista.add_n_first(nodo);
            }
            return lista;
        }catch(IOException e){
            System.err.println(e);
            return null;
        }
    }
}
