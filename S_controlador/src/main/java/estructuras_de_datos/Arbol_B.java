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
    
    /*    public void addNodo(Nodo_B _a, Nodo_D_E_C nodoLista){
    Nodo_B nodoPalabra = addNodo(_a, this.root);
    Lista_D_E_C lista = (Lista_D_E_C) nodoPalabra.getData();
    lista.add_n_last(nodoLista);
    }*/
    
    /*private Nodo_B addNodo(Nodo_B _a, Nodo_B padre){
    //System.out.println(_a.getId() + "Dentro del Arbol");
    if (padre == null){
    this.size++;
    System.out.println(_a.getId() + "Lo que se incerta");
    return padre = _a;
    } else if(_a.getId().compareTo(padre.getId()) > 0){
    //System.out.println("Se fue a la derecha");
    return addNodo(_a, padre.getHDer());
    } else if(_a.getId().compareTo(padre.getId()) < 0){
    //System.out.println("Se fue a la izquierda");
    return addNodo(_a, padre.getHIzq());
    }
    return padre;
    }
    */
    
    public Nodo_B addNodo(Nodo_B _a){
        return addNodo(_a, this.root);
    }
    
    private Nodo_B addNodo(Nodo_B _a, Nodo_B padre){
        Nodo_B x = this.root;
        Nodo_B y = null;
        while(x != null){
            y = x;
            if((_a.getId()).compareTo(padre.getId()) > 0){
                x = x.getHDer();
            } else {
                x = x.getHIzq();
            }
        }
        if (y == null){
            size++;
            //y = _a;
            //x = _a;
            root = _a;
        } else if (_a.getId().compareTo(y.getId()) > 0){
            size++;
            y.setHDer(_a);
        } else {
            size++;
            y.setHIzq(_a);
        }
        return y;
    }
    
    /*    public Nodo_B buscarNodo(String _a){
    if(root != null){
    System.out.println(root.getId() + "ESTA ES LA RAIZ ");
    }
    return buscarNodo(_a, this.root);
    }
    private Nodo_B buscarNodo(String _a, Nodo_B padre){
    if (padre == null || _a.equals(padre.getId())){
    return padre;
    } else if(_a.compareTo(padre.getId()) > 0){
    System.out.println("SE LLAMA DERECHA");
    return buscarNodo(_a, padre.getHDer());
    } else {
    System.out.println("SE LLAMA IZQUIERDA");
    return buscarNodo(_a, padre.getHIzq());
    }
    }*/
    
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
        System.out.println("fdjskfdsfdsfds " + padre);
        return padre;
    }
    
    /*    public Nodo_B buscarNodoContenido(String _a){
    return buscarNodoContenido(_a, this.root);
    }
    
    private Nodo_B buscarNodoContenido(String _a, Nodo_B padre){
    System.out.println(padre.getId() + " PADRE");
    if ((padre.getId()).contains(_a) || padre == null){
    return padre;
    } else if(_a.compareTo(padre.getId()) > 0){
    return buscarNodo(_a, padre.getHDer());
    } else {
    return buscarNodo(_a, padre.getHIzq());
    }
    }*/
    
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
