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
    String __id;
    Object coincidencias;
    Nodo_AVL left; 
    Nodo_AVL right; 
    
    int height;
    
    public Nodo_AVL(String data) {
        this.__id = data; 
        height = 1;
    }
}
