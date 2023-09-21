package nesting;

public class DataStructure {
    private final static int SIZE = 15;
    private int[] arrayOfInts = new int[SIZE];

    public DataStructure() {
        for (int i = 0; i < SIZE; i++) {
            arrayOfInts[i] = i;
        }
    }

    public void printEven() {
        DataStructureIterator iterator = this.new EvenIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.println();
    }


    interface DataStructureIterator extends java.util.Iterator<Integer> {}

    public class EvenIterator implements DataStructureIterator {
        
        private int nextIndex = 0;

        public boolean hasNext() {
            return (SIZE - 1 >= nextIndex);
        }

        public Integer next() {
            Integer returnValue = Integer.valueOf(arrayOfInts[nextIndex]);

            nextIndex += 2;
            return returnValue;
        }
    }


    public static void main(String s[]) {
        DataStructure ds = new DataStructure();
        ds.printEven();
    }
}
