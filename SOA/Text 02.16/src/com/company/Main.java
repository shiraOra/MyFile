package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        LinkedListTar2.Node anchor=new LinkedListTar2.Node(2);
        LinkedListTar2.Node node1 =
                new LinkedListTar2.Node(90,
                        new LinkedListTar2.Node(171,
                                new LinkedListTar2.Node(11,
                                        new LinkedListTar2.Node(1))));
        LinkedListTar2 list1=new LinkedListTar2(anchor,node1);
        LinkedListTar2.Node node=new LinkedListTar2.Node(4);


      list1.insertionSortLinkedList();
      //  list1.printList();
      //list1.bubbleSortLinkedList();
//list1.insertionSortLinkedList();
    //  list1.insertNode(node);
    //  list1.printList();
//list1.printList();



        NodeWithHead.Node list2 =
                new NodeWithHead.Node(1,
                        new NodeWithHead.Node(2,
                                new NodeWithHead.Node(3)));
        NodeWithHead.Node list3 =
                new NodeWithHead.Node(4,
                        new NodeWithHead.Node(10,
                                new NodeWithHead.Node(20)));
        NodeWithHead.Node list4 =
                new NodeWithHead.Node(5,
                        new NodeWithHead.Node(8,
                                new NodeWithHead.Node(30)));



        NodeWithHead nodeWithHead=
                new NodeWithHead(list3,
                        new NodeWithHead(list2,
                                new NodeWithHead(list4)));
        NodeWithHead.sortKlists1(nodeWithHead);

    }


}
