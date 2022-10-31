/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras_de_datos;

/**
 *
 * @author RYZEN
 */
public class Arbol_B {
    private Nodo_B root;
    private int Depth;
    private String id;
    
    public void addNodo(Nodo_B _a, Nodo_D_E_C nodoLista){
        Nodo_B nodoPalabra = addNodo(_a, this.root);
        Lista_D_E_C lista = (Lista_D_E_C) nodoPalabra.getData();
        lista.add_n_last(nodoLista);
    }
    
    private Nodo_B addNodo(Nodo_B _a, Nodo_B padre){
        if (padre == null){
            return root = _a;
        } else if(_a.getId().compareTo(padre.getId()) > 0){
            if (padre.getHDer() == null){
                padre.setHDer(_a);
            } else {
                return addNodo(_a, padre.getHDer());
            }
        } else if(_a.getId().compareTo(padre.getId()) < 0){
            if (padre.getHIzq() == null){
                padre.setHIzq(_a);
            } else {
                return addNodo(_a, padre.getHIzq());
            }
        }
        return _a;
    }
    
    public Nodo_B buscarNodo(String _a){
        return buscarNodo(_a, this.root);
    }
    private Nodo_B buscarNodo(String _a, Nodo_B padre){
        if (padre == null || _a.equals(padre.getId())){
            return padre;
        } else if(_a.compareTo(padre.getId()) > 0){
            return buscarNodo(_a, padre.getHDer());
        } else {
            return buscarNodo(_a, padre.getHIzq());
        }
    }
    
}
