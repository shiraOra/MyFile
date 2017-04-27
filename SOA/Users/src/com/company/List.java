package com.company;

import java.util.Iterator;

/**
 * Created by hackeru on 2/14/2017.
 */
public interface List<T> extends Iterator<T> ,Iterable<T>{
    void add(T x);
    void add(T x, int index);
    void remove(int index);
    void set(int index, T x);
    T get(int index);

    /**
     * finds an element in the list
     * @param x the element we're looking for
     * @return the position first in the list, zero based. return -1 if not found.
     */
    int indexOf(T x);
    T [] toArray();
    int size();


}
