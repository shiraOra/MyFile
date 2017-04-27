package com.company;

/**
 * Created by hackeru on 2/16/2017.
 */
public class NodeWithHead {



        Node value;
        NodeWithHead next;

        public NodeWithHead(Node value, NodeWithHead next) {
            this.value = value;
            this.next = next;
        }

    public NodeWithHead(Node value) {
        this.value = value;
    }

    public  static void sortKlists1(NodeWithHead nodeWithHead){
            while (nodeWithHead.next!=null){
                nodeWithHead.value=Node.merge(nodeWithHead.value,nodeWithHead.next.value);
                nodeWithHead.next=nodeWithHead.next.next;
            }
        }

  /*  public static void printLinkedLists(NodeWithHead nodeWithHead){
        while (nodeWithHead.next!=null){

        }
    }*/
  public static void sortKlists2(NodeWithHead nodeWithHead){


  }




    public static class Node{
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
        public static void print(Node node){

        }

    }
}
