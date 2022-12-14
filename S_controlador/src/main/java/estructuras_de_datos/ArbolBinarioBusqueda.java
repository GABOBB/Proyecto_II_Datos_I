package estructuras_de_datos;

/**
 *
 * @author Michael
 */
public class ArbolBinarioBusqueda {
    NodoArbolBinario root;
    
    public ArbolBinarioBusqueda(){
        root = null;
    }
    
    public NodoArbolBinario exist(String search){
        return exist(this.root,search);
    }
    
    private NodoArbolBinario exist(NodoArbolBinario root,String search){
        if(root == null){
            return null;
        }
        if(root.getId().equals(search)){
        
            return root;
        }else if(root.getId().compareTo(search)<0){
        
            return exist(root.LeftSon,search);
            
        }else if(root.getId().compareTo(search)>0){
            
            return exist(root.RigthSon,search);
            
        } 
        return null;
    }
    
    public Lista_D_E_C buscar(String search) {
        return buscar(this.root, search);
    }

    private Lista_D_E_C buscar(NodoArbolBinario root, String search) {
        Lista_D_E_C lista_1 = new Lista_D_E_C();
    
        if (root == null) {
            return lista_1;
            
        } else if (search.compareTo(root.getId()) > 0) {
            if (root.getId().contains(search)) {
                Nodo_D_E_C nodo = new Nodo_D_E_C(root.getId(),root.data);
                lista_1.add_n_last(nodo);
            } 
            return buscar(root.RigthSon,search);
        }else {
            if (root.getId().contains(search)) {
                Nodo_D_E_C nodo = new Nodo_D_E_C(root.getId(),root.data);
                lista_1.add_n_last(nodo);
            }
            return buscar(root.LeftSon,search);
        }
    }

    public void add(String id,Object dato) {
        if (this.root == null) {
            this.root = new NodoArbolBinario(id, dato);
            System.out.println("raiz");
        } else {
            this.add(this.root, dato, id);
        }
    }
    
    private void add(NodoArbolBinario padre, Object dato, String id) {
        if (id.compareTo( padre.getId())>0) {
            if (padre.getRigtSon() == null) {
                padre.setRigthSon(new NodoArbolBinario(id,dato));
                System.out.println("derecha");
            } else {
                this.add(padre.getRigtSon(), dato, id);
            }
        } else {
            if (padre.getLeftSon()== null) {
                padre.setLeftSon(new NodoArbolBinario(id,dato));
                System.out.println("izquierda");
            } else {
                this.add(padre.getLeftSon(), dato, id);
            }
        }
    }
    
   
    
    public NodoArbolBinario Search(String id){
        NodoArbolBinario aux = root;
        while(!(aux.getId().equals(id))){
            if (root == null){
                return null;
            }
            else if (id.compareTo( root.getId())>0) {
                aux = aux.getRigtSon();
            }
            else{
                aux = aux.getLeftSon();
            }
            
        }return aux;
        
        
        }
    
    public void delete(String id){
         NodoArbolBinario aux = root;
         NodoArbolBinario father = root;
         boolean son = true;
         
         while (!aux.getId().equals(id)) {
            father=aux;
            if (aux==null){
                return ;
            }
            else if (id.compareTo(aux.getId())>0){
                son=false;
                aux=aux.getRigtSon();
            }else{
                son=true;
                aux=aux.getLeftSon();
            }
            
         }
         
         if(aux.getLeftSon()==null && aux.getRigtSon() == null){
             if(aux == root){
                 root = null;
             }
             else if (son){
                 father.setLeftSon(null);
                
             }else{
                 father.setRigthSon(null);
             }
         }else if(aux.getRigtSon()== null){
             if(aux == root){
                 root = aux.getLeftSon();
             }
             else if(son==true){
                 father.setLeftSon(aux.getLeftSon());
                 
             }else{
                 father.setRigthSon(aux.getLeftSon());                      
             }
         }else if (aux.getLeftSon() == null){
             if(aux == root){
                 root = aux.getRigtSon();
             }
             else if (son==true){
                 father.setLeftSon(aux.getRigtSon());
             }else{
                  father.setRigthSon(aux.getRigtSon());   
             }
         }
    }
}
