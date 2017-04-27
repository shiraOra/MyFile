package com.company;

/**
 * Created by hackeru on 2/16/2017.
 */
public class LinkedListTar2 {

    public LinkedListTar2(Node anchor, int size) {
    }

    private Node anchor;


    public LinkedListTar2(Node anchor, Node current) {
        this.anchor = anchor;
        this.anchor.next=current;

    }

    public void bubbleSortLinkedList() {
        Node end=null;
        while (end!=anchor.next) {
            Node theOneBefore = this.anchor;
            Node current = theOneBefore.next;
            Node next = current.next;

            while (next != end&& current!=null ) {

                    if (current.value > next.value) {
                        Node temp = next.next;
                        theOneBefore.next = next;
                        next.next = current;
                        current.next = temp;
                        theOneBefore = next;
                        next = current.next;
                    } else {
                        next = next.next;
                        theOneBefore = current;
                        current = current.next;

                    }

                }
                end = current;
            }

        }
    public void insertionSortLinkedList() {
        Node theOneBefore;
        Node head = anchor.next;
        Node current = head.next;
        Node iterator;
        while (current != null) {
            printList();
            System.out.println("****");
            iterator = head;
            theOneBefore = anchor;
            while(iterator!=current){

                if (current.value < iterator.value) {
                        if (iterator==head){
                            head=current;
                        }
                        Node temp = current.next;
                        theOneBefore.next = current;
                        current.next = iterator;
                        iterator.next = temp;
                        break;
                    }

                else {
                    iterator = iterator.next;
                    theOneBefore=theOneBefore.next;
                }


            }
            current=current.next;

        }
    }
/*public void insertNode(Node node){
         Node iterator=anchor.next;
         Node theOneBefore=anchor;
         while (iterator!=null){

             if(iterator.value>node.value) {

                 theOneBefore.next = node;
                 node.next = iterator;
                 break;
             }
             else {
                 iterator=iterator.next;
             theOneBefore=theOneBefore.next;
         }
         }
}*/











  /*  static void bubbleSort(int[] arr){
        int upTo = arr.length-1;
        boolean isSorted = false;
        while(!isSorted){
            isSorted = true;
            for (int i = 0; i < upTo; i++) {
                if(arr[i] > arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    isSorted = false;
                }
            }
            upTo--;
        }
    }*/

public  void printList(){
    Node iterator=this.anchor.next;
    while (iterator!=null) {
        System.out.println(iterator.value);
        iterator=iterator.next;
    }
}
    public static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            next = null;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }


    }
}
