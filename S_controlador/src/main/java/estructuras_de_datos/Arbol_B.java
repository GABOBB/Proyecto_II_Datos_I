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
    private int size;
    private int Depth;
    private String id;
    
    public Arbol_B (String k){
        this.id = k;
    }
    
    public Nodo_B getRoot(){
        return this.root; 
    }
    
    public Nodo_B addNodo(Nodo_B _a){
        return addNodo(_a, this.root);
    }
    
    private Nodo_B addNodo(Nodo_B _a, Nodo_B padre){
        Nodo_B x = padre;
        Nodo_B y = null;
        while(x != null){
            y = x;
            if((_a.getId()).compareTo(x.getId()) > 0){
                System.out.println("Se agrega a la derecha");
                x = x.getHDer();
            } else if (_a.getId().compareTo(x.getId()) < 0){
                System.out.println("Se agrega a la izquierda");
                x = x.getHIzq();
            }
            
        }
        if (y == null){
            size++;
            //y = root;
            root = _a;
        } else if (_a.getId().compareTo(y.getId()) > 0){
            size++;
            y.setHDer(_a);
            
        } else if (_a.getId().compareTo(y.getId()) < 0){
            size++;
            y.setHIzq(_a);
        }
        return y;
    }
    
    
    public Nodo_B buscarNodo(String _a){
        return buscarNodo(this.root, _a);
    }
    
    private Nodo_B buscarNodo(Nodo_B padre, String _a){
        while (padre != null){
            if (_a.compareTo(padre.getId()) > 0){
                System.out.println(padre.getId() + " derecha");
                padre = padre.getHDer();
            } else if (_a.compareTo(padre.getId()) < 0){
                System.out.println(padre.getId() + " izquierda");
                padre = padre.getHIzq();
            } else {
                System.out.println("LO ENCUENTRA" + padre.getId());
                return padre;
            }
        }
        System.out.println("ENCUENTRA EL ARBOL " + padre);
        return padre;
    }
    

    
    public void imprimirNodosDerechos(){
        imprimirNodosDerechos(this.root);
    }
    
    private void imprimirNodosDerechos(Nodo_B padre){
        if(padre.getHDer() != null){
            System.out.println(padre.getHDer().getId() + " Nodo Derecho");
            imprimirNodosDerechos(padre.getHDer());
        }
    }
    
    public int getSize() {
        return size;
    }
    
    
}
