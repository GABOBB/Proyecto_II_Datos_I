package auxiliares;
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
    
    public void add_n_first(Nodo_D_E_C nodo){//añade un nodo al principio de la lista
        if(this.size==0){
            this.head=nodo;
            nodo.set_N(nodo);
            nodo.set_P(nodo);
            this.size++;
        }else{
            Nodo_D_E_C a = this.head;
            nodo.set_N(a);
            a = a.get_P();
            nodo.set_P(a);
            a.set_N(nodo);
            nodo.get_N().set_P(nodo);
            this.head = nodo;
            this.size++;
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
    
    public Nodo_D_E_C getHead(){
        return this.head;
    }
}
