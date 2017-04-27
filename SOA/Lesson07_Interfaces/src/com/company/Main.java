package com.company;



public class Main {
    public class Shape{

        public void draw(boolean[][]canvas){

        }
    }

    public static void main(String[] args) {

 /*       Dog myDog=Dog.getDog();
        myDog.setName("snoopy");
        System.out.println(myDog.name);
        Dog anotherDog=Dog.getDog();
        System.out.println(anotherDog.name);
       *//* Button btnLogin=new Button();
        btnLogin.setListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("button clicked");
            }
        });
        btnLogin.detectClick();
        Siren s=new Siren();
        MotionSensor sensor=new MotionSensor();
        Police p=new Police();
        sensor.setListener(p);
        sensor.detectMotion();
        sensor.setListener(s);
        sensor.detectMotion();*//*
	// write your code here
        ArrayList arrayList=new ArrayList();
        arrayList.add(1);
        arrayList.add(8);
        arrayList.add(56);
        arrayList.add(30,1);
        arrayList.remove(2);
        System.out.println(arrayList);*/
        Node list1 =
                new Node(2,
                        new Node(7,
                                new Node(18)));


        Node list2 =
                new Node(5,
                        new Node(6,
                                new Node(20)));
        Node merged=Node.ourMerge(list1,list2);
        while (merged!=null){
            System.out.println(merged.value);
            merged=merged.next;
        }


    }
    interface Rollable{
        void roll(float degree);
    }
    interface Drawable{
        void draw(boolean [][]canvas);
    }
    class Ball implements Rollable{
        void bounce(){};

        @Override
        public void roll(float degree) {

        }
    }
    class cylinder extends Shape implements Rollable{

        @Override
        public void roll(float degree) {

        }

        @Override
        public void draw(boolean[][] canvas) {
            super.draw(canvas);
        }
    }
    static void bubbleSort(int[] arr){
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
    }

//Singleton
    static class Dog{

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
        private static Dog d;
        private Dog(){

        }
        public static Dog getDog(){
            if (d==null)
                d=new Dog();
            return d;
        }
    }

    /*static void merge2Lists(LinkedList list1,LinkedList list2)
    {
        while (list1.hasNext()&&list2.hasNext()){
            if(list1.)
        }

    }

    static void merge(int[] arr, int l, int m, int r){
        int n1 = m-l+1;
        int n2 = r-m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = arr[m + 1 + i];
        }
        int i=0, j=0;
        int k = l;
        while (i<n1 && j<n2){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            arr[k] = L[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    static void mergeSort(int[] arr, int l, int r){
        if(l < r){
            int m = (l+r)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }*/
}


