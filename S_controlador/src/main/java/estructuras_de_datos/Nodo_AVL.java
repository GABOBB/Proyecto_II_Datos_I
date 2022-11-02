/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras_de_datos;

/**
 *
 * @author Gabriel
 */
public class Nodo_AVL {
    String id; 
    int ComparacionesAVL;
    int pos, balan;
    Nodo_AVL HIzq, HDer;
    
    public Nodo_AVL(String id, int pos, int ComparacionesAVL){
        this.id = id;
        this.pos = pos;
        this.ComparacionesAVL = ComparacionesAVL;
        this.balan = 0;
        this.HIzq = null;
        this.HDer = null;
    }
    
    public int comparaciones(){
        return ComparacionesAVL;
    }
    public void ComparationsAVL(int ComparacionesAVL){
        this.ComparacionesAVL = ComparacionesAVL;
    }
    public String getId() {
        return id;
    }
    public void setPalabra(String Id){
        this.id = id;
    }
    public int getPos(){
        return pos;
    }
    public void setPos(int Position){
        this.pos = Position;
    }
    public int getBal(){
        return balan;
    }
    public void setBalan(int Balan){
        this.balan = Balan;
    }
    public Nodo_AVL get_HIzq(){
        return HIzq;
    }
    public Nodo_AVL get_HDer(){
        return HDer;
    }
    public void setIzq(Nodo_AVL HijoIzquierdo){
        this.HIzq = HijoIzquierdo;
    }
    public void setDer(Nodo_AVL HijoDerecho){
        this.HDer = HijoDerecho;
    }
    
    
    
}
