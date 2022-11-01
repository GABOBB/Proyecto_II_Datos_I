package com.mycompany.s_controlador;

import FilesLoader.AbrirArchivos;
import FilesLoader.FileCopy;
import FilesLoader.FilesReader;
import FilesLoader.OrderFiles;
import estructuras_de_datos.Lista_D_E_C;
import estructuras_de_datos.Nodo_D_E_C;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import FilesLoader.ReadFile;
import estructuras_de_datos.ArbolBinarioBusqueda;
import estructuras_de_datos.Arbol_AVL;
import estructuras_de_datos.Arbol_B;
import estructuras_de_datos.NodoArbolBinario;
import estructuras_de_datos.Nodo_AVL;
import estructuras_de_datos.Nodo_B;



/**
 * @author Gabriel
 */
public class S_controlador {
    private Lista_D_E_C documentos = new Lista_D_E_C();
    private Lista_D_E_C __avl = new Lista_D_E_C();
    private Lista_D_E_C __bst = new Lista_D_E_C();
    
    public S_controlador() throws IOException{
        cargar();
    }

    public static void main(String[] args) throws IOException {
        new S_controlador();
    }
    
    
    public void cargar(){
        try {
        this.documentos = FilesReader.readFiles();
        Nodo_D_E_C __act = this.documentos.getHead();
        
        do {
            Arbol_B arbolBinario = new Arbol_B(__act.getId());
            Lista_D_E_C palabras = (Lista_D_E_C) __act.getData();
            Nodo_D_E_C palabra = palabras.getHead();
            
            
            do {
                //System.out.println(palabra.getId() + " ACTUAL");
                
                //ESTO ESTA BIEN COMO SE CARGA, EL ERROR ESTA ADENTRO :) 
                
                
                cargar_a_bst(palabra.getId(),arbolBinario, palabra);
                
                System.out.println("Se Carga ID" + palabra.getId());
                System.out.println("Se carga palabra" + palabra.get_N().get_N().getId());
                
                
                palabra = palabra.get_N();
            } while (palabra != palabras.getHead());
            Nodo_D_E_C nodo = new Nodo_D_E_C(__act.getId(), arbolBinario);
            System.out.println(nodo.getId() + "NODO QUE SE METE EN EL ARBOL");
            this.__bst.add_n_last(nodo);
            __act = __act.get_N();
            System.out.println(__act.getId() + "ARCHIVO DE ARCHIVOS");
            
        } while (__act != this.documentos.getHead());
        } catch (Exception e){
            System.out.println("ERROR EN LA CARGA EN ARBOL" + e);
        }
        try {
        on_server();
        } catch (Exception e){
            System.out.println("No sirve el server" + e);
        }
    }
    
    
    private void cargar_a_avl(Nodo_D_E_C n_l, Arbol_AVL _avl){
        
        Nodo_AVL n_avl = _avl.exist(n_l.getId(),n_l);
        if(n_avl != null){
            _avl.insert(n_avl.getId(), n_l);
        }
    }
    
    
    
    private void cargar_a_bst(String id, Arbol_B arbolBinario, Nodo_D_E_C MiNodo){
        Nodo_D_E_C NodoPalabra = new Nodo_D_E_C(id);
        
        Nodo_B nodoEncontrado = arbolBinario.buscarNodo(id);
        
        if(nodoEncontrado == null){
            Lista_D_E_C lista = new Lista_D_E_C();
            Nodo_D_E_C tempNodo = new Nodo_D_E_C(id);
            tempNodo.set_N(MiNodo);
            NodoPalabra.setData(tempNodo);
            lista.add_n_last(NodoPalabra);
            Nodo_B nodoNuevo = new Nodo_B(NodoPalabra.getId(), lista);
            //System.out.println("LISTA " + lista.getHead().getData() + lista.getHead().get_N().getData());
            System.out.println("Lo que meto en ID " + nodoNuevo.getId() + "Lo que meto en LISTA" + nodoNuevo.getData());
            
            System.out.println("ID de lista" +
                    MiNodo.getId() +
                    MiNodo.get_N().getId() +
                    MiNodo.get_N().get_N().getId());

            arbolBinario.addNodo(nodoNuevo);
            
            
        } else {
            Lista_D_E_C ListaEncontrada = (Lista_D_E_C) nodoEncontrado.getData();
            ListaEncontrada.add_n_last(NodoPalabra);
        }
    }
    
    private void on_server() throws IOException{
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        DataInputStream in;
        DataOutputStream out;
        final int PORT = 5000;
        final boolean FLAG = true;
        


        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is On!");

            while (true) {
                clientSocket = serverSocket.accept();
                System.out.println("Client Connected [1]");

                in = new DataInputStream(clientSocket.getInputStream());
                out = new DataOutputStream(clientSocket.getOutputStream());

                String message = in.readUTF();
                System.out.println(message);
                
                    
                    if(message.contains("P@@@")){
                        String[] palabras = message.split("@@@")[1].split(" ");
                        Lista_D_E_C Godzilla = new Lista_D_E_C();
                        try {
                        for(String i : palabras){
                            System.out.println(i);
                        }
                        Nodo_D_E_C n_bst = this.__bst.getHead();
                        
                        do{
                            //Arbol_AVL t_avl = (Arbol_AVL) n_avl.getData();
                            Arbol_B t_bst = (Arbol_B) n_bst.getData();
                            System.out.println(t_bst.getSize() + "TAMAÑO ARBOL");
                            //t_bst.imprimirNodosDerechos();
                            //System.out.println(t_bst.buscarNodoContenido("Proyecto"));
                            System.out.println(t_bst.buscarNodo(palabras[0]) + " ID");
                            
                            Nodo_B nodoInfo = t_bst.buscarNodo(palabras[0]);
                            
                            Lista_D_E_C Marquito = (Lista_D_E_C) nodoInfo.getData();
                            Nodo_D_E_C Marquitos = (Nodo_D_E_C) Marquito.getHead();
                            
                            do {
                                Nodo_D_E_C UltimoAux = (Nodo_D_E_C) Marquitos.getData();
                                Nodo_D_E_C NodoAux = UltimoAux.get_N();
                                Nodo_D_E_C NodoAuxAux = NodoAux;
                                Godzilla.setHead(NodoAux);
                                do {
                                    System.out.println(NodoAux.getId() + "ZORRAS");
                                    //Godzilla.add_n_last(NodoAux);
                                    NodoAux = NodoAux.get_N();
                                } while(NodoAuxAux != NodoAux );
                                
                                NodoAux.setFlag(true);
                                System.out.println(NodoAux.getId() + "MAMAPICHAS");
                                Marquitos = Marquitos.get_N();
                                
                                
                                System.out.println(Godzilla.getHead().getId() + " GODZILLA");
                                System.out.println(Godzilla.getHead().get_N().getId()  + " GODZILLA");
                                System.out.println(Godzilla.getHead().get_N().get_N().getId()  + " GODZILLA");
                                System.out.println(Godzilla.getHead().get_N().get_N().get_N().getId()  + " GODZILLA");
                                System.out.println(Godzilla.getHead().get_N().get_N().get_N().get_N().getId()  + " GODZILLA");
                                
                            } while (Marquitos != Marquito.getHead());
                            
                            //System.out.println("TIPO DE LISTA " + Godzilla.getHead().getData().getClass());
                            //}
                            //n_avl = n_avl.get_N();
                            
                            
                            //n_bst = n_bst.get_N();
                        }while(n_bst!=this.__bst.getHead());
                        //String x = to_html_f();
                        
                        String x = to_html_f(Godzilla);
                        out.writeUTF(x);
                        this.limpia_bandera();
                        } catch (Exception e) {
                            String x = to_html_f();
                            out.writeUTF(x);
                        }
                        
                    }else if(message.contains("F@@@")){
                        String[] palabras = message.split("@@@")[1].split(" ");
                    }else if (message.equals("FILECHOOSER")){
                        //String x = to_html_f();
                        //out.writeUTF(x);
                        
                    } else if (message.contains("PATH")){
                        System.out.println("Detects");
                        String m = message.substring(0, message.length() - 4);
                        System.out.println(m);
                        FileCopy.FileLoader(m);
                    } else if (message.equals("Nombre")){
                        System.out.println("Se ordena por el nombre");
                        this.documentos = OrderFiles.OrderByNames();
                        String x = to_html_f();
                        out.writeUTF(x);
                    } else if (message.equals("Creacion")){
                        System.out.println("Se ordena por creacion");
                        this.documentos = OrderFiles.OrderByDate();
                        String x = to_html_f();
                        out.writeUTF(x);
                    } else if (message.equals("Palabras")){
                        System.out.println("Se ordena por cantidad de palabras");
                        this.documentos = OrderFiles.OrderByLength();
                        String x = to_html_f();
                        out.writeUTF(x);
                    } else if (message.contains("ruta@")){
                        String[] s = message.split("@");
                        System.out.println(s[1]);
                        
                        AbrirArchivos.abrir(s[1]);
                    } else{
                        this.documentos = FilesReader.readFiles();
                        String x = to_html_f();
                        out.writeUTF(x);
                    }
                    
                clientSocket.close();
                System.out.println("client disconnected[1]");
            }
        } catch (IOException e) {
            Logger.getLogger(S_controlador.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    private String to_html_f(){
        Nodo_D_E_C actual = this.documentos.getHead();
        String html_final = "";
        
        do{
            String id = actual.getId();
            Lista_D_E_C documento = (Lista_D_E_C)(actual.getData());
            
            boolean closed = true;
            
            String html = id+"@@@<html><head></head><body>";
            Nodo_D_E_C act = documento.getHead();
            do{
                if(act.getFlag() && closed){
                    html += "<font color = red>";
                    html += " " + actual.getId();
                    closed = false;
                }else if(!act.getFlag() && !closed){
                    html += "</font>";
                    html += " " + actual.getId();
                    closed=true;
                }else if(act.getFlag() && !closed){
                    html += " " + act.getId();
                }else{
                    html += " " + act.getId();
                }
                
                act = act.get_N();
            } while(act != documento.getHead());
            
            
            html += "</body></html>";
            if(actual.get_N() != this.documentos.getHead()){
                html_final += html + "-_-";
            }else{
                html_final += html;
            }
            actual = actual.get_N(); 
            
        }while(actual != this.documentos.getHead());
        //System.out.println(html_final);
        return html_final;
    }
    private String to_html_f(Lista_D_E_C tempData){
       
        String html_final = "";
        

            String id = tempData.getHead().getId();
            Nodo_D_E_C documento = (Nodo_D_E_C)(tempData.getHead());
            
            boolean closed = true;
            
            String html = id+"@@@<html><head></head><body>";
            Nodo_D_E_C act = tempData.getHead();
            
            do{
                if(act.getFlag() && closed){
                    html += "<font color = red>";
                    html += " " + tempData.getHead().getId();
                    closed = false;
                }else if(!act.getFlag() && !closed){
                    html += "</font>";
                    html += " " + tempData.getHead().getId();
                    closed=true;
                }else if(act.getFlag() && !closed){
                    html += " " + act.getId();
                }else{
                    html += " " + act.getId();
                }
                
                act = act.get_N();
            } while(act != tempData.getHead());
            
            html += "</body></html>";
            if(documento.get_N() != tempData.getHead()){
                html_final  += html + "-_-";
            } else {
                html_final += html + "-_-";
            }
            documento = documento.get_N();
            
            
            System.out.println(html_final);
        return html_final;
    }

    public void limpia_bandera(){
        Nodo_D_E_C act_d = this.documentos.getHead();
        do{
            Lista_D_E_C l_p = (Lista_D_E_C) act_d.getData();
            Nodo_D_E_C act_p = (Nodo_D_E_C) l_p.getHead();
            do{
                if(act_p.getFlag()){act_p.setFlag(false);}
                act_p = act_p.get_N();
            }while(act_p != l_p.getHead());
            act_d = act_d.get_N();
        }while(act_d != this.documentos.getHead());
    
    }
    
    public void alzar_bandera(Lista_D_E_C lista_F){
        Nodo_D_E_C af = lista_F.getHead();
        do{
            af.setFlag(true);
            System.out.println(af.getFlag() + " Flag");
            af = af.get_N();
            
        }while(af != lista_F.getHead());
    }
}