
package model;
public class Node {
    private int[] value;
    Node next;
    public Node (){
        
    }

    public Node(int[] value) {
        this.value = value;
    }
    
  public void setValue(int[] value) {
        this.value = value;
    }
  
    public int[] getValue() {
        return value;
    }

   public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }
}
    