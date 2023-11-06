package ru.sberbank.edu;
import jdk.internal.util.ArraysSupport;


import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public class CustomArrayImpl<T> implements CustomArray<T> {

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    private int size, modCount;
    transient Object[] elementData;

    public CustomArrayImpl(){
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    /**
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Add single item.
     *
     * @param item
     */
    @Override
    public boolean add(T item) {
        modCount++;
        if (size == elementData.length)
            elementData = grow( size + 1);
        elementData[size] = item;
        size++;
        return true;
    }

    private Object[] grow(int minCapacity) {
        int oldCapacity = elementData.length;
        if (oldCapacity > 0 || elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            int newCapacity = ArraysSupport.newLength(oldCapacity,
                    minCapacity - oldCapacity, /* minimum growth */
                    oldCapacity >> 1           /* preferred growth */);
            return elementData = Arrays.copyOf(elementData, newCapacity);
        } else {
            return elementData = new Object[Math.max(10, minCapacity)];
        }
    }


    /**
     * Add all items.
     *
     * @param items
     * @throws IllegalArgumentException if parameter items is null
     */
    @Override
    public boolean addAll(T[] items) {
        modCount++;
        int numNew = items.length;
        if (numNew == 0)
            return false;
        Object[] elementData;
        final int s;
        if (numNew > (elementData = this.elementData).length - (s = size))
            elementData = grow(s + numNew);
        System.arraycopy(items, 0, elementData, s, numNew);
        size = s + numNew;
        return true;
    }

    /**
     * Add all items.
     *
     * @param items
     * @throws IllegalArgumentException if parameter items is null
     */
    @Override
    public boolean addAll(Collection<T> items) {
        Object[] a = items.toArray();
        //return addAll(a);
        modCount++;
        int numNew = a.length;
        if (numNew == 0)
            return false;
        Object[] elementData;
        final int s;
        if (numNew > (elementData = this.elementData).length - (s = size))
            elementData = grow(s + numNew);
        System.arraycopy(a, 0, elementData, s, numNew);
        size = s + numNew;
        return true;
    }

    /**
     * Add items to current place in array.
     *
     * @param index - index
     * @param items - items for insert
     * @throws ArrayIndexOutOfBoundsException if index is out of bounds
     * @throws IllegalArgumentException       if parameter items is null
     */
    @Override
    public boolean addAll(int index, T[] items) {
        //Object[] a = items.toArray();
        modCount++;
        int numNew = items.length;
        if (numNew == 0)
            return false;
        Object[] elementData;
        final int s;
        if (numNew > (elementData = this.elementData).length - (s = size))
            elementData = grow(s + numNew);

        int numMoved = s - index;
        if (numMoved > 0)
            System.arraycopy(elementData, index,
                    elementData, index + numNew,
                    numMoved);
        System.arraycopy(items, 0, elementData, index, numNew);
        size = s + numNew;
        return true;
    }

    /**
     * Get item by index.
     *
     * @param index - index
     * @throws ArrayIndexOutOfBoundsException if index is out of bounds
     */
    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return elementData(index);
    }

    @SuppressWarnings("unchecked")
    T elementData(int index) {
        return (T) elementData[index];
    }

    /**
     * Set item by index.
     *
     * @param index - index
     * @param item
     * @return old value
     * @throws ArrayIndexOutOfBoundsException if index is out of bounds
     */
    @Override
    public T set(int index, T item) {
        T oldValue = elementData(index);
        elementData[index] = item;
        return oldValue;
    }

    /**
     * Remove item by index.
     *
     * @param index - index
     * @throws ArrayIndexOutOfBoundsException if index is out of bounds
     */
    @Override
    public void remove(int index) {
        final Object[] es = elementData;

        //@SuppressWarnings("unchecked") T oldValue = (T) es[index];
        fastRemove(es, index);
    }

    private void fastRemove(Object[] es, int i) {
        modCount++;
        final int newSize;
        if ((newSize = size - 1) > i)
            System.arraycopy(es, i + 1, es, i, newSize - i);
        es[size = newSize] = null;
    }

    /**
     * Remove item by value. Remove first item occurrence.
     *
     * @param item - item
     * @return true if item was removed
     */
    @Override
    public boolean remove(T item) {
        final Object[] es = elementData;
        int i = 0;
        found:
        {
            for (; i < size; i++)
                if (item.equals(es[i]))
                    break found;
            return false;
        }
        fastRemove(es, i);
        return true;
    }
    /**
     * Checks if item exists.
     *
     * @param item - item
     * @return true or false
     */
    @Override
    public boolean contains(T item) {
        return false;
    }

    /**
     * Index of item.
     *
     * @param item - item
     * @return index of element or -1 of list doesn't contain element
     */
    @Override
    public int indexOf(T item) {
        return 0;
    }

    /**
     * Grow current capacity to store new elements if needed.
     *
     * @param newElementsCount - new elements count
     */
    @Override
    public void ensureCapacity(int newElementsCount) {
        if (newElementsCount > elementData.length
                && !(elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA
                && newElementsCount <= 5)) {
            modCount++;
            grow(newElementsCount);
        }
    }

    /**
     * Get current capacity.
     */
    @Override
    public int getCapacity() {
        return 0;
    }

    /**
     * Reverse list.
     */
    @Override
    public void reverse() {

    }

    /**
     * Get copy of current array.
     */
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }
}
