package com.company;


public class Main {

    public static void main(String[] args) {
	// write your code here
        Node n1=new Node(5);
        Node n2=new Node(8);
        Node n3=new Node(2);
        Node n4=new Node(9);
        Node n5=new Node(19);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        printLinkedList(n1);
        Node temp=n4.next;
        n4.next=n3;
        n2.next=n4;
        n3.next=temp;
        printLinkedList(n1);
    }
    public static void printLinkedList(Node node){
        while(node!=null) {
            System.out.print(node.value + " ");
            node=node.next;
        }
        System.out.println();
    }
}
