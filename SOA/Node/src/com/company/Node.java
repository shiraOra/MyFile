package com.company;

/**
 * Created by hackeru on 2/16/2017.
 */
public class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}
