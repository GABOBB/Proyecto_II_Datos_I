package estructuras_de_datos;

/**
 *
 * @author Gabriel
 */
public class Arbol_AVL {
    Nodo_AVL root;
    
    public int height(Nodo_AVL N) {
        if (N == null)
            return 0;
        
        return N.height;
    }
    
    private int max(int a, int b) {
        return (a > b) ? a : b;
    }
    
    public Lista_D_E_C exist(String search){
        return exist(this.root, search);
    }
    
    private Lista_D_E_C exist(Nodo_AVL root, String search){
        Lista_D_E_C lis1 = new Lista_D_E_C();
        
        if(root == null){
            return lis1;
            
        } else if (search.compareTo(root.getId()) > 0) {
            
            if (root.getId().contains(search)){
            Nodo_D_E_C nodo = new Nodo_D_E_C(root.__id,root.coincidencias);
            lis1.add_n_last(nodo); 
            }
            
            return exist(root.right, search);
            
        } else if (search.compareTo(root.getId()) < 0) {
            
            if (root.getId().contains(search)){
            Nodo_D_E_C nodo = new Nodo_D_E_C(root.__id,root.coincidencias);
            lis1.add_n_last(nodo);
            }
            
            return exist(root.left, search);
            
        }
        return null;
    }
    
   public Nodo_AVL rotacionDerecha(Nodo_AVL y){
       Nodo_AVL x = y.left;
       Nodo_AVL T2 = x.right;
       
       x.right = y;
       y.left = T2;
       
       y.height = max(height(y.left), height(y.right)) + 1;
       x.height = max(height(x.left), height(x.right)) + 1;
       
       return x;
   }
   public Nodo_AVL rotacionIzquierda (Nodo_AVL x){
       Nodo_AVL y = x.right;
       Nodo_AVL T2 = y.left;
       
       
       y.left = x;
       x.right = T2;
       
       x.height = max(height(x.left), height(x.right)) + 1;
       y.height = max(height(y.left), height(x.right)) + 1;
       
       return y;
   }
   public int getBalance(Nodo_AVL N){
       if (N == null)
           return 0;
       return height(N.left) - height(N.right);
   }
   
    public Nodo_AVL insert(Nodo_AVL node, String key) {
        if (node == null)
            return (new Nodo_AVL(key));
 
        if (key.compareTo(node.__id) > 0)
            node.left = insert(node.left, key);
        else if (key.compareTo(node.__id) < 0)
            node.right = insert(node.right, key);
        else 
            return node;
        node.height = 1 + max(height(node.left),
                              height(node.right));
        int balance = getBalance(node);

        if (balance > 1 && key.compareTo(node.left.__id) > 0)
            return rotacionDerecha(node);
 
        if (balance < -1 && key.compareTo(node.right.__id) < 0)
            return rotacionIzquierda(node);
 
        if (balance > 1 && key.compareTo(node.left.__id) < 0) {
            node.left = rotacionIzquierda(node.left);
            return rotacionDerecha(node);
        }
 
        if (balance < -1 && key.compareTo(node.right.__id) > 0) {
            node.right = rotacionDerecha(node.right);
            return rotacionIzquierda(node);
        }
 
        return node;
    }
 
    public void preOrder(Nodo_AVL node) {
        if (node != null) {
            System.out.print(node.__id + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }   
}

   
   
   


   
