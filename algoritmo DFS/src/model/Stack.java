package model;

public class Stack {

    Node head;

    public Stack() {

    }

    public void setHead(Node head) {
        this.head = head;
    }
    
    public Node getHead() {
        return head;
    }

    public void push(int[] value) {
        Node n = new Node(value);
        if (!isEmpty()) {
            n.setNext(head);
        }
        head = n;
    }

    public void pop() {
        head = head.next;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    

    public void pushtLast(int[] value) {
        Node n = new Node(value);
        Node q = lastNode();
        if (!isEmpty()) {
            q.setNext(n);
        } else {
            head = n;
        }
    }
    public Node lastNode(){
        if (head == null)
            return null;
        else{
        Node q= head;
        while (q.getNext()!= null){
            q =q.getNext();
        }
        return q;
    }
}
}
