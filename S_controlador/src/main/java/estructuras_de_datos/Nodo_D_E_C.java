package estructuras_de_datos;
/**
 *
 * @author Gabriel
 */
public class Nodo_D_E_C {
    private String id;//es la referencia por la cual se identifica el nodo
    private Object data;//es la informacion u objeto que contiene el nodo
    private boolean flag = false;
    private Nodo_D_E_C _N;//es el nodo siguiente en la lista
    private Nodo_D_E_C _P;//es el nodo anterios en la lista
    
    public Nodo_D_E_C(String id, Object data){//genera un nodo con informacion
        this.id = id;
        this.data = data;
        this._N = null;
        this._P = null;
    }
    
    public Nodo_D_E_C(String id){//genera un nodo sin informacion
        this.id = id;
        this.data = null;
        this._N = null;
        this._P = null;
        //System.out.println(id+"nodo_D_E_C");
    }
    
    public boolean getFlag(){
        return this.flag;
    }
    
    public void setFlag(boolean f){
        this.flag = f;
    }
    
    public String getId(){//devuelve la referencia (id) del nodo
        return this.id;
    }

    public void setId(String id){//setea la referencia (id) del nodo
        this.id = id;
    }

    public Object getData(){//devuelve la informacion (data) del nodo
        return data;
    }

    public void setData(Object data){//setea la informacion (data) del nodo
        this.data = data;
    }

    public Nodo_D_E_C get_N(){//devuelve el nodo siguiente en la lista (_N)
        return _N;
    }

    public void set_N(Nodo_D_E_C _N){//setea el nodo siguiente en la lista (_N)
        this._N = _N;
    }

    public Nodo_D_E_C get_P(){//devuelve el nodo anterior en la lista (_P)
        return _P;
    }

    public void set_P(Nodo_D_E_C _P){//setea el nodo anterior en la lista (_P)
        this._P = _P;
    }
    
}
   