import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ArrayBoundedList<E> implements BoundedList <E> {
    private int size;   // how many elements are in use
    private E [] elements; // length = capacity

    public ArrayBoundedList(int capacity) {
        if (capacity < 0){
            throw new IllegalArgumentException("capacity cant be negative");
        }
        size = 0; // starts empty
        this.elements = (E[]) new Object[capacity];
    }

    @Override
    public int capacity() {
        return elements.length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E s) {
        if (size < capacity()){
            elements[size] = s; // place at the end and increment size bc you added a new element so now increment size
            size++;
        } else {
            throw new IllegalStateException("Array is already full");
        }
    }


    @Override
    public E get(int index) {
        if (index < 0 || index >= size ){
            throw new IndexOutOfBoundsException();
        }
        return elements[index];
    }

    /**
     * Replaces the old element at the specified index with the new element, and returns the old element.
     * @param index the index where an element should be replaced
     * @param element the new element
     * @return the old element
     * @throws IndexOutOfBoundsException if index is negative, or greater than or equal to the size
     */
    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size ){
            throw new IndexOutOfBoundsException();
        }
        E old = elements[index]; //save the old value
        elements[index] = element; //replace with new element
        return old; // return the old value
    }


    @Override
    public int indexOf(E s) {
        // We only look through the 'size' actual elements
        for (int i = 0; i < size; i++) {
            if (s == null) {
                // Looking for null
                if (elements[i] == null) {
                    return i;  // Found null
                }
            } else {
                // Looking for a non-null string
                // Must check that elements[i] itself is not null before .equals(...)
                if (elements[i] != null && s.equals(elements[i])) {
                    return i;  // Found a match
                }
            }
        }
        return -1; // Not found
    }

    /**
     * Return the index of the last occurrence of the specified String in this list, or -1 if it doesn't occur in this list.
     * @param s the String to search for (possibly null)
     * @return the index of the last occurrence of s, or -1 if not found
     */
    @Override
    public int lastIndexOf(E s) {
        for (int i = size - 1; i >= 0; i--) {
            if (s == null) {
                if (elements[i] == null) {
                    return i;
                }
            } else {
                if (elements[i] != null && s.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1; // Not found
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public void add(int index, E s) {
        if (index > size || index < 0){
            throw new IndexOutOfBoundsException();
        } else if(size == capacity()){
            throw new IllegalStateException();
        }

        for (int i = size -1; i >= index; i--){
            elements[i + 1] = elements[i];
        }
        elements[index] = s;
        size++;

    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        E removed = elements[index];

        for (int i = index; i < size-1; i++){
            elements[i] = elements[i+1];
        }
        elements[size-1] = null;
        size--;
        return removed;
    }

    @Override
    public boolean remove(E s) {
        int idx = indexOf(s);
        if (idx == -1){
            //nothing found so nothing removed
            return false;
        }
        remove(idx);
        return true;
    }

    @Override
    public String toString(){
        String result = "[";

        for (int i = 0; i < size; i++){
            if (i > 0) {
                result += ",";
            }
            if (elements [i] == null){
                result += "null";
            } else {
                result += elements[i];
            }
        }
        result += "]";
        return result;
    }

    @Override
    public Iterator<E> iterator() { // Add this method
        return new theIterator();
    }

    private class theIterator implements Iterator<E> {
        private int index = 0;

        @Override
        public boolean hasNext(){
            return index < size;
        }

        @Override
        public E next(){
            if (index >= size){
                throw new NoSuchElementException("no such element");
            }
            return elements[index++];
        }

    }




}
