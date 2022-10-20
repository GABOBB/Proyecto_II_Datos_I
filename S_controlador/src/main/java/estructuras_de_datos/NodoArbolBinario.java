/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras_de_datos;

/**
 *
 * @author Michael
 */
public class NodoArbolBinario {
    String id;//es la referencia por la cual se identifica el nodo
    Object data;//es la informacion u objeto que contiene el nodo
    NodoArbolBinario LeftSon;
    NodoArbolBinario RigthSon;
    
    public NodoArbolBinario(String id,Object data){
        
        this.id = id;
        this.data = data;
        this.LeftSon = null;
        this.RigthSon = null;
        
      
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public Object getData(){
        return data;
    }

    public void setData(Object data){
        this.data = data;
    }

    public NodoArbolBinario getRigtSon(){
        return RigthSon;
    }

    public void setRigthSon(NodoArbolBinario RigthSon ){
        this.RigthSon = RigthSon;
    }

    public NodoArbolBinario getLeftSon(){
        return LeftSon;
    }

    public void setLeftSon(NodoArbolBinario LeftSon){
        this.LeftSon = LeftSon;
    }
        
    
    
    
}
