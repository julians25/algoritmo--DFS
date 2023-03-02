
package model;


public class NodeL {
    private int[] value;
    private String nombre;
    NodeL next;
    public NodeL(){
        
    }
     

    public NodeL(int[] value ) {
         this.nombre=nombre;
         this.value = value;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
   
 
    public void setValue(int[] value) {
        this.value = value;
    }

    public void setNext(NodeL next) {
        this.next = next;
    }

    public int[] getValue() {
        return value;
    }

    public NodeL getNext() {
        return next;
    }
    
}
