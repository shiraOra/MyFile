package com.company;

/**
 * Created by hackeru on 2/21/2017.
 */

//פונקציה שממיינת מחסנית אסור להשתמש באף מבנה נתונים אחר חוץ ממחסנית
    //פונקציה שמקבלת מחסנית והופכת את סדר האיברים שלו
public class ArrayStack<T> implements Stack<T>{
    private T arr[];
    private int size;

    public ArrayStack() {
        arr = (T[])new Object[10];
        size=0;
    }

    @Override
    public T pop() {
        if (!isEmpty())
            return arr[--size];
        return null;
    }

    @Override
    public void push(T element) {
        makeRoom();
        arr[size++]=element;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    public void reverseStack(){
        ArrayStack<T> temp=new ArrayStack();
        temp.push(this.pop());
        this.arr=temp.arr;
    }
    @Override
    public T peek() {
        if(isEmpty())
            throw new IndexOutOfBoundsException("Empty Stack!");
        T retVal=pop();
        push(retVal);
        return retVal;
    }
    public void sortStack(){
        ArrayStack<T> tempStack=new ArrayStack<T>();
        tempStack.push(pop());
        while (size>0){

        }
            size--;


    }

    private void makeRoom(){
        if(size == arr.length){
            T[] temp = (T[])new Object[size * 2];
            for (int i = 0; i < size; i++) {
                temp[i] = arr[i];
            }
            this.arr = temp;
        }
    }

}