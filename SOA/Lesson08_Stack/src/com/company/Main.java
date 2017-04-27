package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayStack<Integer> arrayStack=new ArrayStack<>();
        arrayStack.push(5);
        arrayStack.push(3);
        arrayStack.push(2);
        arrayStack.push(1);
        arrayStack.push(8);
        arrayStack.push(9);
        arrayStack.push(4);
        sortStack(arrayStack);
    }


    public static void remove(Stack stack, Object obj) {
        Stack temp = new ArrayStack();
        while (!stack.isEmpty()) {
            Object o = stack.pop();
            if (!obj.equals(o)) {
                temp.push(o);
                break;
            }
        }
        while (!temp.isEmpty())
            stack.push(temp.pop());
    }

    public static void reverseStack(Stack stack) {
        Stack stack1 = new ArrayStack();
        while (!stack.isEmpty()) {
            stack1.push(stack.pop());
        }
        Stack stack2 = new ArrayStack();
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        while (!stack2.isEmpty()) {
            stack.push(stack2.pop());
        }

    }
public static void printStack(Stack stack){
        while (!stack.isEmpty()){
            Object o=stack.pop();
            System.out.print(o+" ");
        }
    System.out.println();
}

public static void sortStack(Stack stack){
    printStack(stack);
    Stack temp = new ArrayStack();
    temp=bubblesSortStack(stack,temp);
    printStack(temp);
}
public static Stack<Comparable> bubblesSortStack(Stack<Comparable> stack1,Stack<Comparable> stack2){
    stack2.push(stack1.pop());
    while (!stack1.isEmpty()){
        Comparable c1= stack1.pop();
        Comparable c2=stack2.pop();
        if(c1.compareTo(c2)>0){
            stack2.push(c1);
            stack2.push(c2);
        }
        else {
            stack2.push(c2);
            stack2.push(c1);
        }
    }
    return stack2;


}

}
