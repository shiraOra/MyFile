package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //drawRectangle3(2,3,4,5);
        //drawRectangle2(2,3,4,5);
        //drawX(10);
        /*char arr[][]=new char[2][5];
        arr[0]=new char[]{'1','2','3','4','5'};
        arr[1]=new char[]{'2','3','4','5','6'};
        printArray(arr);*/
       /* TwoDimensionalArray matrix= new TwoDimensionalArray(4,3);

        matrix.set(0,2,100);
        System.out.println(matrix.get(0,2));
        matrix.print();*/
       /*Canvas canvas=new Canvas(60,50);
       canvas.drawRectangle2(5,8,5,5);
       canvas.drawRectangle2(6,6,3,3);
       canvas.render();*/
       int arr[]=new int[] {45,12,80,15,8,2};
        heapSort(arr);
        printArray(arr);
    }

    static void heapSort(int [] arr) {
        MyPriorityQueue myPriorityQueue = new MyPriorityQueue(arr);
        for (int i=0;i<arr.length;i++){
            int max=myPriorityQueue.extractMax();
            arr[arr.length-1-i]=max;
        }
    }
    static DivisionResult divide (int x, int y){
        if(y==0)
            return null;
        int result=0;
        int sum=y;
        int lagestProductOfY=0;
        while(sum<=x){
            sum+=y;
            lagestProductOfY+=y;
            result++;
        }
        DivisionResult divisionResult = new DivisionResult();
        divisionResult.times=result;
        divisionResult.remainder=x-lagestProductOfY;
        return divisionResult;
    }
    static void drawRectangle(int x,int y,int width,int hight)
    {
        for (int i=0;i<y;i++)
            System.out.println("");
        for (int i=0;i<x;i++)
            System.out.print(" ");
        for(int i=0;i<width;i++)
            System.out.print("*");
        System.out.println();
        for(int i=0;i<hight-2;i++){
            for (int j=0;j<x;j++)
                System.out.print(" ");
            System.out.print("*");
            for(int j=0;j<width-2;j++)
                System.out.print(" ");
            System.out.print("*");
            System.out.println("");
    }
        for (int i=0;i<x;i++)
            System.out.print(" ");
    for(int i=0;i<width;i++)
            System.out.print("*");

    }
    static void drawRectangle2(int x,int y,int width,int hight)
    {
        for (int i=0;i<y;i++)
            System.out.println("");

        for (int i=0;i<hight;i++)
        {
            for (int j=0;j<x;j++)
            System.out.print(" ");
            if(i==0 ||i==hight-1){

                for(int j=0;j<width;j++)
                    System.out.print("*");
            }
            else{
                System.out.print("*");
                for(int j=0;j<width-2;j++)
                    System.out.print(" ");
                System.out.print("*");

            }

                System.out.println();
        }
    }
    static void drawRectangleTeacher(int x,int y,int width,int hight){
        for (int i=0;i<y;i++)
            System.out.println("");
        //for
    }
    static void drawRectangle3(int x,int y,int width,int hight)
    {
        char arr [][]= new char[y+hight][x+width];
        for(int i=0;i<y+hight-1;i++)
        {
            for(int j=0;j<=+width-1;j++)
                if(i==y || i==y+hight || j==x || j==x+width)
                    arr[i][j]='*';
                else
                    arr[i][j]=' ';
        }
        printArray(arr);
       /* for(int i=0;i<x+width-1;i++){
            for(int j=0;j<y+hight-1;j++)
                System.out.print(arr[i][j]);
            System.out.println("");*/
        }

       /* for (int i=0;i<y;i++)
            System.out.println("");

        for (int i=0;i<hight;i++)
        {
            for (int j=0;j<x;j++)
                System.out.print(" ");
            if(i==0 ||i==hight-1){

                for(int j=0;j<width;j++)
                    System.out.print("*");
            }
            else{
                System.out.print("*");
                for(int j=0;j<width-2;j++)
                    System.out.print(" ");
                System.out.print("*");

            }

            System.out.println();
        }*/


    static void drawX(int num){
        char[][] arr=new char[num][num];
        for(int i=0;i<num;i++)
            for(int j=0;j<num;j++)
                if(i==j||i+j+1==num)
                    arr[i][j]='*';
                else
                    arr[i][j]=' ';
        printArray(arr);
       /* for(int i=0;i<num;i++) {
            for (int j = 0; j < num; j++)
                System.out.print(arr[i][j]);
            System.out.println("");
        }*/
    }
    static void printArray(int[]arr){
        for(int i=0;i<arr.length;i++) {
                System.out.print(arr[i]+",");
        }
    }
    static void printArray(char[][]arr){
        for(int i=0;i<arr.length;i++) {
            for (int j = 0; j < arr[0].length; j++)
                System.out.print(arr[i][j]);
            System.out.println("");
        }
    }
    static void printMoreThanKnd4(int[] arr){
        int k=4-1;
        ElementCount[] elementCounts=new ElementCount[k];

        for(int i=0;i<elementCounts.length;i++)
            elementCounts[i]=new ElementCount(123,0);
        for(int i=0;i<arr.length;i++){
            int j;
            for(j=0;j<k;j++){
                if(arr[i]==elementCounts[j].element){
                    elementCounts[j].counter++;
                    break;
                }
            }
            if(j==k){
                int l;
                for(l=0;l<k;l++){
                    if(elementCounts[l].counter==0){
                        elementCounts[l].element=arr[i];
                        elementCounts[l].counter=1;
                        break;
                    }
                }
                if(l==k){
                    for (l=0;l<k;l++)
                        elementCounts[l].counter--;
                }
            }
        }
        for(int i=0;i<k;i++){
            int actualCount=0;
            for(int j=0;j<arr.length;j++){
                if(arr[j]==elementCounts[i].element)
                    actualCount++;
            }
            if(actualCount>arr.length/(k+1))
                System.out.println(elementCounts[i].element);
        }


    }
    static int amIpivot(int[] arr) {
        int max = Integer.MIN_VALUE;
        int next = 0;
        for (int i = 0; i < arr.length; i++) {
            if(i<arr.length-1)
                next = arr[i + 1];
            if (arr[i] > max) {
                max = arr[i];
//next=arr[i+1];
            }
            if (next <= arr[i]) {
                i++; //for will add another 1 to i
//next=arr[i];
            } else {
                int j = i;
                while (next > max && j < arr.length - 1) {
                    j++;
                    next = arr[j];
                }
                if (j == arr.length - 1)
                    return i;
            }
        }
        return -1;
    }
    static int findSmallLarge(int[]arr){
        /*
        1. create 2 arrays, left max and right max
        2. Traverse two input arrays, left max and rightMin, and fill leftMax such that leftMax[i] will contains the max elemnt up to index i in arr.
        3.Do the same with rightMin but from right-left;
        4. Traverse the array, if an elemnt in index i, if greater than leftMax[i] and also smaller than rightMin[i] then we've found such element.
        */
        int [] leftMax=new int[arr.length];
        leftMax[0]=Integer.MIN_VALUE;
        for(int i=1;i<arr.length;i++)
            leftMax[i]=Math.max(leftMax[i-1],arr[i-1]);
        int rightMin=Integer.MAX_VALUE;
        for(int i=arr.length-1;i>=0;i--){
            if(leftMax[i]<arr[i]&& rightMin>arr[i])
                return i;
            rightMin=Math.min(rightMin,arr[i]);
        }
        return -1;

    }
    }

class DivisionResult {
    int times;
    int remainder;
};
class TwoDimensionalArray{
    private int arr[] ;
    //private int rows;
    private int columns;
    public TwoDimensionalArray(int rows,int columns) {
        arr = new int[rows*columns];
        this.columns=columns;
    }
    public void set(int row,int column,int value){
       /* if(row>=arr.length||column>=arr[row].length)
            throw new IndexOutOfBoundsException();*/
        arr[pos(row,column)]=value;

    }
    public int get(int row,int column ){
        /*if(row>=arr.length||column>=arr[row].length)
            throw new IndexOutOfBoundsException();*/
        return arr[pos(row,column)];
    }
    private int pos(int row,int column) {
        return row * columns +column;
    }
    public int columns(){
        return this.columns;
    }
    public int rows(){
        return arr.length/columns;
    }
    public void print(){
        for(int i=0;i<rows();i++){
            for (int j=0;j<columns;j++)
                System.out.print(arr[pos(i,j)]);
            System.out.println();
        }
    }



};

class ElementCount{
    int element;
    int counter;
    public ElementCount(int element, int counter){
        this.counter=counter;
        this.element=element;
    }
}

//X וY הם השיעורים של הנקודה השמאלית העליונה של המלבן
//width, hight


