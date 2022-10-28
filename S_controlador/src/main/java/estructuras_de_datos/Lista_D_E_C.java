package estructuras_de_datos;
/**
 * @author Gabriel
 */
public class Lista_D_E_C {    
    Nodo_D_E_C head;//refiere a la primera pocision en la lista
    int size;//refiere a la catidad de nodos que tiene la lista

    public Lista_D_E_C(){//inicializa una lista con valores nulos
        this.head = null;
        this.size = 0;
    }
    public Nodo_D_E_C getHead(){
    return this.head;
    }
    public void add_n_first(Nodo_D_E_C nodo){//añade un nodo al principio de la lista
        if(this.head!=null){
            this.size++;
            Nodo_D_E_C a = this.head;
            nodo.set_N(a);
            a = a.get_P();
            nodo.set_P(a);
            a.set_N(nodo);
            nodo.get_N().set_P(nodo);
            this.head = nodo;
        }else{
            this.size++;
            this.head=nodo;
            nodo.set_N(nodo);
            nodo.set_P(nodo);
        }
    }
    
    public void add_n_last(Nodo_D_E_C nodo){//añade un nodo al final de la lista
        if(this.head==null){
            this.size++;
            nodo.set_N(nodo);
            nodo.set_P(nodo);
            this.head=nodo;
        }else{
            this.size++;
            Nodo_D_E_C a = this.head;
            nodo.set_N(a);
            a = a.get_P();
            nodo.set_P(a);
            a.set_N(nodo);
            nodo.get_N().set_P(nodo);
        }
    }
    
    public void add_n(Nodo_D_E_C a, Nodo_D_E_C nodo){//añade un nodo en una pocicion espesifica de la lista
        this.size++;
        nodo.set_N(a);
        a = a.get_P();
        nodo.set_P(a);
        a.set_N(nodo);
        nodo.get_N().set_P(nodo);
    }
    
    public Nodo_D_E_C Buscar(String id){
        Nodo_D_E_C a = this.head;
        if(a==null){return null;}
        while(a.get_N()!=this.head){
            if(id == a.getId()){return a;}
            a = a.get_N();
        }
        return null;
    }
    
    public void delet(Nodo_D_E_C nodo){
        Nodo_D_E_C p = nodo.get_P();
        Nodo_D_E_C n = nodo.get_N();
        p.set_N(n);
        n.set_P(p);
        if(nodo==this.head){
            this.head=n;
        }
    }
}
