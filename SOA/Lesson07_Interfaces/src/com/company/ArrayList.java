package com.company;

/**
 * Created by hackeru on 2/14/2017.
 */
public class ArrayList implements List {
  int[]arr;
  int size;

    public ArrayList() {
        this.arr = new int[10];
        this.size = 0;
    }
    public ArrayList(int[]arr){
        this.arr=arr;
        this.size=arr.length;
    }
    @Override
    public void add(int x) {
        makeRoom();
        arr[size]=x;
        size++;
    }

    @Override
    public void add(int x, int index) {
        makeRoom();
        if (index<0||index>=size)
            throw new IndexOutOfBoundsException();
        else if(index!=size){
            for (int i=size;i>index;i--)
                arr[i]=arr[i-1];
            arr[index]=x;
        }
        size++;
    }

    @Override
    public void remove(int index) {
        if (index<0||index>=size)
            throw new IndexOutOfBoundsException();
        if(index!=size-1){
        for (int i = index; i <size ; i++)
            arr[i] = arr[i + 1];
        }
            size--;

    }

    @Override
    public void set(int index, int x) {
        if (index<0||index>=size)
            throw new IndexOutOfBoundsException();
        arr[index]=x;
    }

    @Override
    public int get(int index) {
        if(index<0||index>=size)
            throw new IndexOutOfBoundsException();
        return arr[index];
    }

    @Override
    public int indexOf(int x) {
        if(size!=0){
            for (int i=0;i<size;i++)
                if(arr[i]==x)
                    return i;
        }
        return -1;
    }

    @Override
    public String toString() {
        if (size==0)
            return "{}";
        String s="{";
        for (int i = 0; i <size-1 ; i++) {
            s+=arr[i]+",";
        }
        s+=arr[size-1];
        s+="}";
        return s;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int[] toArray() {
        int[]temp=new int[size];
        for (int i=0;i<size;i++)
            temp[i]=arr[i];
        return temp;
    }

    private void makeRoom(){
        if(size==arr.length){
            int[]temp =new int[size*2];
            for (int i=0;i<size;i++)
                temp[i]=arr[i];
            this.arr=temp;
        }
    }


}
