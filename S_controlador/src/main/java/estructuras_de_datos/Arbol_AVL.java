package estructuras_de_datos;

/**
 *
 * @author Gabriel
 */
public class Arbol_AVL {
    private Nodo_AVL root; 
    public Arbol_AVL(){
        root = null;
    }
    static Lista_D_E_C lista = new Lista_D_E_C();
    public void buscar(Nodo_AVL aux, String id, Lista_D_E_C lista){
        if (aux != null){
            if (aux.id.equalsIgnoreCase(id)){
                Nodo_D_E_C nodo = new Nodo_D_E_C(id);
                lista.add_n_last(nodo);
                aux = aux.HDer;
                buscar(aux, id, lista);
            } else {
                if(id.compareTo(aux.id) <= 0){
                    aux = aux.HIzq;
                } else {
                    aux = aux.HDer;
                }
                buscar(aux, id, lista);
            }
        }
    }
    
    public int obtenerBal(Nodo_AVL x){
        if(x == null){
            return -1;
        } else {
            return x.balan;
        }
    }
    
    public Nodo_AVL rotIzq(Nodo_AVL c){
        Nodo_AVL auxN = c.HIzq;
        c.HIzq = auxN.HDer;
        auxN.HDer = c;
        c.balan = Math.max(obtenerBal(c.HIzq), obtenerBal(c.HDer)) + 1;
        auxN.balan = Math.max(obtenerBal(auxN.HIzq), obtenerBal(auxN.HDer)) + 1;
        return auxN;
    }
    
    public Nodo_AVL rotDer(Nodo_AVL c){
        Nodo_AVL auxN = c.HDer;
        c.HDer = auxN.HIzq;
        auxN.HIzq = c;
        c.balan = Math.max(obtenerBal(c.HIzq), obtenerBal(c.HDer)) + 1;
        auxN.balan = Math.max(obtenerBal(c.HIzq), obtenerBal(c.HDer)) + 1;
        return auxN;
    }
    
    public Nodo_AVL rotDobIzq(Nodo_AVL c){
        Nodo_AVL auxN;
        c.HIzq = rotDer(c.HIzq);
        auxN = rotIzq(c);
        return auxN;
    }
    
    public Nodo_AVL rotDobDer(Nodo_AVL c){
        Nodo_AVL auxN; 
        c.HDer = rotIzq(c.HIzq);
        auxN = rotDer(c);
        return auxN;
    }
    
    public Nodo_AVL NewIncert(Nodo_AVL nuevo, Nodo_AVL sub){
        Nodo_AVL NPadre = sub;
        if(nuevo.id.compareTo(sub.id) <= 0){
            if(sub.HIzq == null){
                sub.HIzq = nuevo;
            } else {
                sub.HIzq = NewIncert(nuevo, sub.HIzq);
                if((obtenerBal(sub.HIzq) - obtenerBal(sub.HDer)) == 2){
                    if(nuevo.id.compareTo(sub.HIzq.id) <0){
                        NPadre = rotIzq(sub);
                    } else {
                        NPadre = rotDobIzq(sub);
                    }
                }
            }
        } else if (nuevo.id.compareTo(sub.id) > 0){
            if(sub.HDer == null){
                sub.HDer = nuevo;
            } else {
                sub.HDer = NewIncert(nuevo, sub.HDer);
                if ((obtenerBal(sub.HDer) - obtenerBal(sub.HIzq) == 2)){
                    if(nuevo.id.compareTo(sub.HDer.id) > 0){
                        NPadre = rotDer(sub);
                    } else {
                        NPadre = rotDobDer(sub);
                    }
                }
            }
        }
        if ((sub.HIzq == null) && (sub.HDer != null)){
            sub.balan = sub.HDer.balan + 1;
        } else if (sub.HDer == null && sub.HIzq != null){
            sub.balan = sub.HIzq.balan + 1;
        } else {
            sub.balan = Math.max(obtenerBal(sub.HIzq), obtenerBal(sub.HDer)) + 1;
        }
        return NPadre;
    }
    
    
    public void incert(String word, int pos){
        Nodo_AVL nuevo = new Nodo_AVL(word, pos, 0);
        if (root == null){
            root = nuevo;
        } else {
            root = NewIncert(nuevo, root);
        }
    }
    
    static int CompararAVL = 0;
    public void inOrder(Nodo_AVL r, String word, Lista_D_E_C lista){
        CompararAVL++;
        if ((r != null) && r.id.equalsIgnoreCase(word)){
            r.ComparacionesAVL = CompararAVL;
            Nodo_D_E_C node = new Nodo_D_E_C("");
            node.setData(r);
            CompararAVL = 0;
        }
        if (r != null){
            inOrder(r.HIzq, word, lista);
            System.out.println(r.id);
            inOrder(r.HDer, word, lista);
        } 
    }
    
    public Nodo_AVL getRoot(){
        return this.root;
    }
}

   
   
   


   
