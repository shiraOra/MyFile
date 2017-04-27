package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Writeable writeable1 = new Writeable() {
            @Override
            public void write(String s) {
                System.out.println(s);
            }

        };
        writeable1.write("hello");
        Writeable writeable2 = s -> System.out.println(s);
        writeable2.write("hello");
        BinaryOperator multiplication = (x, y) -> x * y;
        int z = multiplication.operate(5, 7);
        System.out.println(z);
        Point[] points = {new Point(3, 4),
                new Point(7, 3),
                new Point(98, 1)};
        Point p = new Point(7, 3);
        System.out.println(contains(points, p, (a, b) -> a.x == b.x && a.y == b.y));

    }

    public static boolean contains(Point[] arr, Point z, Equal equal) {
        for (int i = 0; i < arr.length; i++) {
            if (equal.areEqual(arr[i], z))
                return true;
        }
        return false;

    }


//אוסף של אברים מאותו טיפוס אבל לא בהכרח ברי השוואה שיתפקד כמו מחסנית
//להגדיר interface שיגדיר מה זה מחסנית ברמה האבסטרקטית- push,pop,
//מתודה isEmpty שבודקת אם המחסנית ריקה
//מחלקה שתממש את זה באמצעות מערך


    interface Equal {
        boolean areEqual(Point x, Point y);
    }

    interface Writeable {
        void write(String s);

    }

    interface BinaryOperator {
        int operate(int x, int y);
    }

public void sortStack(Stack<Comparable>stack){


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

}
class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

}


