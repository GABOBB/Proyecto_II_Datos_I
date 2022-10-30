/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras_de_datos;

/**
 *
 * @author Gabriel
 */
public class Nodo_AVL {
    public String __id;
    public Object coincidencias;
    public Nodo_AVL left; 
    public Nodo_AVL right; 
    
    int height;
    
    public Nodo_AVL(String id, Object coincidencia) {
        this.__id = id;
        this.coincidencias = coincidencia;
        height = 1;
    }
    
    public Nodo_AVL(String id) {
        this.__id = id;
        height = 1;
    }
    
    public String getId() {
        return __id;
    }

    public void setId(String __id) {
        this.__id = __id;
    }

    public Object getCoincidencias() {
        return coincidencias;
    }

    public void setCoincidencias(Object coincidencias) {
        this.coincidencias = coincidencias;
    }

    public Nodo_AVL getLeft() {
        return left;
    }

    public void setLeft(Nodo_AVL left) {
        this.left = left;
    }

    public Nodo_AVL getRight() {
        return right;
    }

    public void setRight(Nodo_AVL right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
}
