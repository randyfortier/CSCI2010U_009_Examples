public class Matrix {
    private int numRows;
    private int numCols;
    private float[] values;

    public Matrix(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;

        values = new float[numRows * numCols];
    }

    public void set(int r, int c, float val) {
        values[r * numCols + c] = val;
    }

    public float get(int r, int c) {
        return values[r * numCols + c];
    }

    public Matrix multiply(Matrix other) {
        if (this.numCols != other.numRows) {
            throw new IllegalArgumentException("Incompatible matrix sizes");
        }

        Matrix result = new Matrix(this.numRows, other.numCols);
        for (int r = 0; r < this.numRows; r++) {
            for (int c = 0; c < other.numCols; c++) {
                float total = 0.0f;
                for (int i = 0; i < this.numCols; i++) {
                    // count how many times this happens:
                    total += this.get(r, i) * other.get(i, c);
                }
                result.set(r, c, total);
            }
        }

        return result;
    }

    public void print() {
        for (int r = 0; r < this.numRows; r++) {
            for (int c = 0; c < this.numCols; c++) {
                System.out.print(this.get(r, c) + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Matrix a = new Matrix(2, 3);
        a.set(0, 0, 1.0f);
        a.set(0, 1, 2.0f);
        a.set(0, 2, 3.0f);
        a.set(1, 0, 4.0f);
        a.set(1, 1, 5.0f);
        a.set(1, 2, 6.0f);
        System.out.println("a:");
        a.print();

        Matrix b = new Matrix(3, 2);
        b.set(0, 0, 7.0f);
        b.set(0, 1, 8.0f);
        b.set(1, 0, 9.0f);
        b.set(1, 1, 10.0f);
        b.set(2, 0, 11.0f);
        b.set(2, 1, 12.0f);
        System.out.println("b:");
        b.print();

        Matrix result = a.multiply(b);
        System.out.println("a * b:");
        result.print();
    }
}