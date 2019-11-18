public class SimpleListMap {
    private class MapNode {
        public MapNode next;
        public int key;
        public String value;
    }

    private MapNode start = null;
    private int count = 0;

    private MapNode findNode(int key) {
        MapNode current = start;
        while (current != null && current.key != key) {
            current = current.next;
        }
        return current;
    }

    public String put(int key, String newValue) {
        MapNode node = findNode(key);

        if (node == null) {
            // add a new entry
            MapNode newNode = new MapNode();
            newNode.key = key;
            newNode.value = newValue;
            newNode.next = start;
            start = newNode;

            count++;

            return null;
        } else {
            // modify the existing entry
            String oldValue = node.value;
            node.value = newValue;
            return oldValue;
        }
    }

    public String get(int key) {
        MapNode node = findNode(key);
        return node == null ? null : node.value;
        /*
        if (node == null) {
            return null;
        } else {
            return node.value;
        }
        */
    }

    public String remove(int key) {
        // handle the special case: empty list
        if (start == null) {
            return null;
        }

        MapNode current = start;
        MapNode pred = null;
        while (current != null && current.key != key) {
            pred = current;
            current = current.next;
        }
        if (current != null) {
            if (pred == null) {
                start = current.next;
            } else {
                pred.next = current.next;
            }
            count--;
            return current.value;
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return (start == null);
    }

    public int size() {
        return count;
    }

    public void print() {
        MapNode current = start;
        while (current != null) {
            System.out.print("(" +
                             current.key + 
                             "," +
                             current.value +
                             ") ");
            current = current.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        SimpleListMap map = new SimpleListMap();

        System.out.println("isEmpty()? " + map.isEmpty());

        map.print();
        System.out.println("put(5,A): " + map.put(5, "A"));
        map.print();
        System.out.println("put(7,B): " + map.put(7, "B"));
        map.print();
        System.out.println("put(2,C): " + map.put(2, "C"));
        map.print();
        System.out.println("put(8,D): " + map.put(8, "D"));
        map.print();
        System.out.println("put(2,E): " + map.put(2, "E"));
        map.print();

        System.out.println("get(7): " + map.get(7));
        System.out.println("get(4): " + map.get(4));
        System.out.println("get(2): " + map.get(2));

        System.out.println("size(): " + map.size());

        System.out.println("remove(5): " + map.remove(5));
        map.print();
        System.out.println("remove(2): " + map.remove(2));
        map.print();
        System.out.println("remove(4): " + map.remove(4));
        map.print();
        
        System.out.println("isEmpty()? " + map.isEmpty());
    }
}