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
        Node newNode = new Node();
        newNode.value = newValue;
        newNode.next = null;

        // handle empty list special case
        if (start == null) {
            start = newNode;
            return;
        }

        // navigate to the last element
        Node current = start;
        while (current.next != null) {
            current = current.next;
        }

        // insert the value after the last element
        current.next = newNode;

        // update the count
        count++;
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
        list.delete("Carla");
        list.print();
    }
}