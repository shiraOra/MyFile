package com.company;

/**
 * Created by hackeru on 2/15/2017.
 */
public class Node {
    int value;
    Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Node(int value) {
        this.value = value;
    }

    public static Node mergeSort(Node first){
        Node head=first;
        Node middle,last;
        if(head==null ||head.next==null)
            return head;
        middle=head; last=head;
        int counter=0;
        while (last.next!=null){
            last=last.next;
            counter++;
            if (counter%2==0)
                middle=middle.next;
        }
            Node temp=middle.next;
            middle.next=null;
            middle=temp;
            Node headSorted=mergeSort(head);
            Node middleSorted=mergeSort(middle);
            return merge(headSorted,middleSorted);




    }

    public static void mergeSort(Node list, int size){
    if (size==0)
        return;
    int i=0;
    Node half=list;
    while(i++<size/2)half=half.next;
    mergeSort(list,size/2);
    mergeSort(half,size/2);
    list=merge(list,half);
    }
    static Node ourMerge(Node list1,Node list2){
        Node res=list1;
        Node iterator;
        if(list1.value<list2.value) {
            list1 = list1.next;
        }
        else
            res=list2;
            list2=list2.next;
        iterator=res;
        while(list1.next!=null&&list2.next!=null){

            if(list1.value<list2.value) {
                iterator.next=list1;
                list1=list1.next;
            }
            else {
                iterator.next=list2;
                list2=list2.next;
            }
            iterator=iterator.next;

        }
        if(list1.next!=null)
            iterator.next=list1;
        else
            iterator.next=list2;
        return res;

    }
   public static Node merge(Node a, Node b){

       Node anchor = new Node(123);
       Node tail = anchor;
       while(true){
           if(a == null) {
               //if either list runs out, use the other one.
               tail.next = b;
               break;
           }else if (b == null){
               tail.next = a;
               break;
           }
           if(a.value <= b.value){
               tail.next = a;
               a = a.next;
           }else{
               tail.next = b;
               b = b.next;
           }
           tail = tail.next;
       }
       return anchor.next;
   }
}
