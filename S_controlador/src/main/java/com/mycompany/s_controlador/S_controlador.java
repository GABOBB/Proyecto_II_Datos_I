package com.mycompany.s_controlador;

import FilesLoader.FileCopy;
import FilesLoader.FilesReader;
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
import estructuras_de_datos.NodoArbolBinario;



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
    
    
    public void cargar() throws IOException{
        this.documentos = FilesReader.readFiles();
        Nodo_D_E_C __act = this.documentos.getHead();
        do{
            Arbol_AVL _avlt = new Arbol_AVL();  ArbolBinarioBusqueda _abbt = new ArbolBinarioBusqueda();
            
            Lista_D_E_C l_temp = (Lista_D_E_C) __act.getData();
            Nodo_D_E_C __act_aux = l_temp.getHead();
            
            do{
                
            cargar_a_bst(__act_aux,_abbt);
            
            }while(__act_aux!=l_temp.getHead());
            Nodo_D_E_C nodo = new Nodo_D_E_C(__act.getId(),_abbt);
            
            __act = __act.get_N();
        }while(__act != this.documentos.getHead());
        on_server();
    }
    private void cargar_a_avl(){}
    private void cargar_a_bst(Nodo_D_E_C __act_aux, ArbolBinarioBusqueda _abbt){
        
                NodoArbolBinario _abbt_aux = _abbt.exist(__act_aux.getId());
                if(_abbt_aux!=null){
                    Lista_D_E_C rr = (Lista_D_E_C) _abbt_aux.getData();
                    Nodo_D_E_C nodo = new Nodo_D_E_C(__act_aux.getId(),__act_aux);
                    rr.add_n_last(nodo);
                }else{
                    Lista_D_E_C rr = new Lista_D_E_C();
                    Nodo_D_E_C nodo = new Nodo_D_E_C(__act_aux.getId());
                    rr.add_n_last(nodo);
                    _abbt.add(__act_aux.getId(), rr);
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
                try{
                    String[] p = message.split("@@@");
                    String[] p_aux = p[1].split(" ");
                    if(p[0]=="P"){
                        for(String i : p_aux){
                            System.out.println("marcador 1");
                            //metodo que buca una palabra
                            Lista_D_E_C temp = this.__bst;
                            Nodo_D_E_C actl = temp.getHead();
                            do{
                                ArbolBinarioBusqueda actB = (ArbolBinarioBusqueda) actl.getData();
                                alzar_bandera(actB.buscar(i));
                            }while(actl != temp.getHead());
                            String x = to_html_f();
                            System.out.println(x);
                            out.writeUTF(x);
                        }
                    }else{
                        //metodo que busca la frase entera
                    }
                    
                }catch(Exception e){
                    if (message.equals("FILECHOOSER")){
                        String x = to_html_f();
                        out.writeUTF(x);
                    } else if (message.contains("PATH")){
                        System.out.println("Detects");
                        String m = message.substring(0, message.length() - 4);
                        System.out.println(m);
                        FileCopy.FileLoader(m);
                    } else{
                        String x = to_html_f();
                        out.writeUTF(x);

                    }
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
            while(act.get_N() != documento.getHead()){
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
                html += "</body></html>";
                act = act.get_N();
            }
            if(actual.get_N() != this.documentos.getHead()){
                html_final += html + "-_-";
            }else{
                html_final += html;
            }
            actual = actual.get_N(); 
            
        }while(actual != this.documentos.getHead());
        
        return html_final;
    }
    
    /*private String to_html_fraces(Lista_D_E_C lista){
        boolean closed = true;
        Nodo_D_E_C actual = lista.getHead();
        String html = "@@@<html><head></head><body>";
        while(actual.get_N()!=lista.getHead()){
            
            if(actual.getFlag() && closed){
                
                html+="<font color = red>";
                html+=" "+actual.getId();
                closed=false;
                
            }else if(actual.getFlag() && !closed){
                html+=" "+actual.getId();
            }else if (!actual.getFlag() && !closed){
                html+="</font>";
                html+=" "+actual.getId();
                closed=true;
            }else{
                html+=" "+actual.getId();
            }
            actual = actual.get_N();
        }
        html += "</body></html>";
        return html;
    }*/ 
    
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
            Lista_D_E_C lista_C = (Lista_D_E_C) af.getData();
            Nodo_D_E_C ac = lista_C.getHead();
            do{
                ac.setFlag(true);
                ac = ac.get_N();
            }while(ac != lista_C.getHead());
        af = af.get_N();
        }while(af != lista_F.getHead());
    }
}
