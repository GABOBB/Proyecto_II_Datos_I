package estructuras_de_datos;

/**
 *
 * @author RYZEN
 */
public class Nodo_B {
    private String id;
    private Object data; 
    private Nodo_B HIzq; 
    private Nodo_B HDer;

    public Nodo_B(String id, Object data) {
        this.id = id;
        this.data = data;
        this.HIzq = null;
        this.HDer = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Nodo_B getHIzq() {
        return HIzq;
    }

    public void setHIzq(Nodo_B HIzq) {
        this.HIzq = HIzq;
    }

    public Nodo_B getHDer() {
        return HDer;
    }

    public void setHDer(Nodo_B HDer) {
        this.HDer = HDer;
    }
    
    
}
