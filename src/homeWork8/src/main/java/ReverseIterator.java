import java.util.Iterator;
import java.util.List;

/**
 * Created by Master on 07.08.2016.
 */
class ReverseIterator<T> implements Iterator<T> {
    private List<T> list;
    private int counter;

    public ReverseIterator(List<T> list) {
        this.list = list;
        counter = list == null ? 0 : list.size();
    }

    @Override
    public boolean hasNext() {
        return counter != 0;
    }

    @Override
    public T next() {
        return counter == 0 ? null : list.get(--counter);
    }

    @Override
    public void remove() {
        list.remove(--counter);
    }
}
