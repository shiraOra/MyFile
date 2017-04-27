package com.company;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by hackeru on 2/14/2017.
 */
public class LinkedList implements List,Iterator,Iterable{

    private Node anchor;
    private Node last;
    private Node current;
    private int size;
    public LinkedList(){
        anchor=new Node(123);
        last=anchor;
        size=0;
    }

    @Override
    public void add(int x) {
    /*if(size==0)
        anchor.next=new Node(x);
    else{
        Node pointer=anchor;
        while(pointer.next!=null) {
            pointer=pointer.next;
        }
        pointer.next=new Node(x);
        }*/
    last.next=new Node(x);
    last=last.next;
        size++;
    }

    @Override
    public void add(int x, int index) {
    if(index<0||index>size)
        throw new IndexOutOfBoundsException();
    else{
        Node pointer=anchor;
        for (int i = 0; i <index-1 ; i++) {
            pointer = pointer.next;
        }
        Node pointerNext=pointer.next;
        pointer.next=new Node(x);
        pointer.next.next=pointerNext;
        size++;
        }
    }

    @Override
    public void remove(int index) {
        if(index<0||index>size)
            throw new IndexOutOfBoundsException();
        else{
            Node pointer=anchor;
            for (int i = 0; i <index-1 ; i++) {
                pointer = pointer.next;
            }
            pointer.next=pointer.next.next;

            size--;
        }
    }

    @Override
    public void set(int index, int x) {
        if(index<0||index>size)
            throw new IndexOutOfBoundsException();
        Node pointer=anchor;
         for (int i = 0; i <index ; i++) {
            pointer = pointer.next;
        }
        pointer.value=x;

    }

    @Override
    public int get(int index) {
        if(index<0||index>size)
            throw new IndexOutOfBoundsException();
        Node pointer=anchor;
        for (int i = 0; i <index ; i++) {
            pointer = pointer.next;
        }
        return pointer.value;
    }

    @Override
    public int indexOf(int x) {
            Node pointer=anchor.next;
            for (int i = 0; i <=size ; i++) {
                if(pointer.value==x)
                    return i;
                pointer=pointer.next;
            }
        return -1;
    }

    @Override
    public int[] toArray() {
        if(size==-1)
            throw new IndexOutOfBoundsException();
        int arr[]=new int[size];
        Node pointer=anchor.next;
        for (int i = 0; i <size ; i++) {
            arr[i]=pointer.value;
            pointer=pointer.next;
        }
        return arr;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (size==0)
            return "{}";
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("{");
        Node node=anchor.next;
        for (int i = 0; i <size-1 ; i++,node=node.next) {
            stringBuilder.append(node.value+",");
        }
        stringBuilder.append(node.next.value);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    @Override
    public Iterator iterator() {
        current=anchor;
        return this;
    }

    @Override
    public boolean hasNext() {
        return current.next!=null;
    }

    @Override
    public Object next() {
        current=current.next;
        return current.value;
    }



    private static class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }


}
