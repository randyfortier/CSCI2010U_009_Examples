public class BasicLinkedList {
    class Node {
        public Node next;
        public String value;
    }

    private Node start;
    private int count;

    public BasicLinkedList() {
        start = null;
        count = 0;
    }

    public void insertEnd(String newValue) {
        // create a new node for our value
        Node newNode = new Node();
        newNode.value = newValue;
        newNode.next = null;

        // increase the size
        count++;

        // handle the special case
        if (start == null) {
            start = newNode;
            return;
        }

        // go to the last element
        Node current = start;
        while (current.next != null) {
            current = current.next;
        }

        // add the element
        current.next = newNode;
    }

    public void insertStart(String newValue) {
        // create a new node for our value
        Node newNode = new Node();
        newNode.value = newValue;
        newNode.next = start;

        // increase the size
        count++;

        // add the element
        start = newNode;
    }

    public void removeEnd() {
        // handle the empty list special case
        if (count == 0) {
            // can't return an element that doesn't exist!
            return; 
        }

        count--;

        // navigate to the second last element
        Node current = start;
        Node previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }

        // handle the 1-element list special case
        if (previous == null) {
            start = null;
            return;
        }

        // delete the element
        previous.next = null;
    }

    public void removeStart() {
        // handle the empty list special case
        if (count == 0) {
            // can't return an element that doesn't exist!
            return; 
        }

        count--;

        start = start.next;
    }

    public void delete(String value) {
        if (count == 0) {
            return;
        }

        // find the node we need to delete
        Node current = start;
        Node previous = null;
        while ((current != null) && 
               (!current.value.equals(value))) {
            previous = current;
            current = current.next;
        }

        // delete the element
        if (previous == null) {
            // deleting the first element
            // Note:  This was where our bug was located
            //        current --becomes--> current.next
            start = current.next;
        } else if (current != null) {
            // deleting non-first element
            previous.next = current.next;
        }
    }

    public void print() {
        System.out.print("[ ");
        Node current = start;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        BasicLinkedList list = new BasicLinkedList();
        list.print();
        list.insertEnd("Sally");
        list.print();
        list.insertEnd("Kumar");
        list.print();
        list.insertEnd("Carla");
        list.print();
        list.removeEnd();
        list.print();
        list.removeStart();
        list.print();
        list.insertStart("Roger");
        list.print();
        list.delete("Roger");
        list.print();
    }
}