public class BasicArray {
    private String[] elements;
    private int count;

    public BasicArray(int capacity) {
        elements = new String[capacity];
        count = 0;
    }

    private void resizeIfNecessary() {
        if ((count + 1) >= elements.length) {
            // make a larger array
            String[] newArray = new String[elements.length * 2];

            // copy the elements over
            for (int i = 0; i < elements.length; i++) {
                newArray[i] = elements[i];
            }

            // replace the array
            elements = newArray;
        }
    }

    public void insertEnd(String newValue) {
        // check if we have enough space
        resizeIfNecessary();

        // insert the value
        elements[count] = newValue;
        count++;
    }

    public void insertStart(String newValue) {
        // check if we have enough space
        resizeIfNecessary();

        // shift all the values to the right
        for (int i = count - 1; i >= 0; i--) {
            elements[i + 1] = elements[i];
        }

        // insert the value
        elements[0] = newValue;
        count++;
    }

    public void insertAt(int index, String newValue) {
        // handle invalid indices
        if ((index >= count) || (index < 0)) {
            throw new ArrayIndexOutOfBoundsException("No such index: " + index);
        }

        // check if we have enough space
        resizeIfNecessary();

        // move all the elements (starting at index) to the right
        for (int i = count - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }

        // add the value
        elements[index] = newValue;
        count++;
    }

    public void print() {
        System.out.print("[ ");
        for (int i = 0; i < count; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        BasicArray list = new BasicArray(2);
        list.print();
        list.insertEnd("Sandra");
        list.print();
        list.insertEnd("Paolo");
        list.print();
        list.insertStart("Carla");
        list.print();
        list.insertAt(1, "Jim");
        list.print();
    }
}