package model;

public class List {

    private NodeL head;

    public List() {

    }

    public NodeL getHead() {
        return head;
    }

    public void setHead(NodeL head) {
        this.head = head;
    }

    public void insertFirst(int[] value) {
        NodeL n = new NodeL(value);
        if (head == null) {
            head = n;
        } else {
            n.setNext(head);
            head = n;
        }
    }

    public void insertLast(int[] value) {
        NodeL n = new NodeL(value);
        NodeL q= lastNode();
        if (q != null) 
            q.setNext(n);
         else 
            head = n;
        
    }

    public NodeL lastNode() {
        if (head == null) 
            return null;
         else {
            NodeL q = head;

            while (q.getNext() != null) 
                q = q.getNext();
            

            return q;

        }
    }

    public NodeL search(int[] value ) {
        NodeL q = head;
        while (q != null) {
            if (q.getValue() == value) {
                return q;
            }
            q = q.getNext();
        }
        return null;
    }

    public int size() {
        int counter = 0;
        NodeL q = head;
        while (q != null) {
            counter++;
            q = q.getNext();
        }
        return counter;
    }

}
