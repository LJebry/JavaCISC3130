/**
 * A capacity-bounded list of String elements. Each list has a capacity, which is the maximum number of elements that the list can hold at one time.
 * Each list also has a size, which is the number of elements currently held by the list. The elements of a list have indexes: the first element
 * is at index 0, the second element is at index 1, and so on. Null elements are allowed.
 */
public interface BoundedList<E> extends Iterable<E> {
    /**
     * Returns the number maximum number of elements that this list can hold at the same time.
     * @return the capacity
     */
    int capacity();

    /**
     * Returns the number of elements currently held in this list.
     * @return the size, which is less than or equal to the capacity
     */
    int size();

    /**
     * Adds the specified element to the end of this list, if the list isn't already full.
     * For example, if {@code list} is a StringBoundedList with capacity 10 that represents {@code [a, b, c]},
     * then saying {@code list.add("d")} makes {@code list} represent {@code [a, b, c, d]}.
     * @param s the String to add
     * @throws IllegalStateException if this list is already full
     */
    void add(E s);

    /**
     * Returns the element at the specified index in this list.
     * @param index the position of the desired element.
     * @return the element (possibly null) at the specified position
     * @throws IndexOutOfBoundsException if index is negative, or greater than or equal to the size
     */
    E get(int index);
    /**
     * Replaces the old element at the specified index with the new element, and returns the old element.
     * @param index the index where an element should be replaced
     * @param element the new element
     * @return the old element
     * @throws IndexOutOfBoundsException if index is negative, or greater than or equal to the size
     */
    E set(int index, E element);

    /**
     * Return the index of the first occurrence of the specified String in this list, or -1 if it doesn't occur in this list.
     * @param s the String to search for (possibly null)
     * @return the index of the first occurrence of s, or -1 if not found
     */
    int indexOf(E s);

    /**
     * Return the index of the last occurrence of the specified String in this list, or -1 if it doesn't occur in this list.
     * @param s the String to search for (possibly null)
     * @return the index of the last occurrence of s, or -1 if not found
     */
    int lastIndexOf(E s);
    /**
     * Makes the list empty.
     */
    void clear();

    void add(int index, E s);
    E remove(int index);
    boolean remove(E s);

    default boolean isEmpty(){
        return size() == 0;
    }
    default boolean isFull(){
        return size() == capacity();
    }
    default E getFirst(){
        return get(0);
    }
    default E getLast(){
        return get(size()-1);
    }
    default E setFirst(E s){
        return set(0, s);
    }
    default E setLast(E s){
        return set(size()-1, s);
    }
    default boolean contains(E s){
        return indexOf(s) != -1;
    }

    default void addAll(BoundedList<? extends E> other) {
        if (this.size() + other.size() > this.capacity()) {
            throw new IllegalStateException("total sizes can not be greater than capacity");
        }

        for (int i = 0; i < other.size(); i++) {
            this.add(other.get(i));
        }
    }

    default void copyTo(BoundedList<? super E> other) {
        if (this.size() + other.size() > other.capacity()) {
            throw new IllegalStateException("total sizes can not be greater than capacity");
        }

        for (int i = 0; i < this.size(); i++) {
            other.add(this.get(i));
        }
    }



}
