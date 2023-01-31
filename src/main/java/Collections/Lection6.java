package Collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Lection6 {
    static <T> Iterable<T> nCopies(T value, int count){
        if(count < 0)
            throw new IllegalArgumentException("Negative count: " + count);
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    int rest = count;
                    @Override
                    public boolean hasNext() {
                        return rest > 0;
                    }

                    @Override
                    public T next() {
                        if( rest-- == 0)
                            throw new NoSuchElementException();
                        return value;
                    }
                };
            }
        };
    }
}
