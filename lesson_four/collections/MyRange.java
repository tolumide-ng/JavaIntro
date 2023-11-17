package lesson_four.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyRange implements Iterable<Integer> {
    private final int start;
    private final int end;

    public MyRange(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int index = start;

            @Override
            public boolean hasNext() {
                return index < end;
            }

            @Override
            public Integer next() {
                if(index > end) {
                    throw new NoSuchElementException("" + index);
                }

                return index++;
            }
        };
    }
}