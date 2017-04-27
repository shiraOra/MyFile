package com.company;

/**
 * Created by hackeru on 2/1/2017.
 */
public class Canvas {
    private  boolean[][]canvas;
    public Canvas(int width,int height) {
        canvas=new boolean[height][width];
    }
    public void drawRectangle(int x, int y, int width, int height){
        int row=0, col=0;
        for (int i = 0; i < y; i++)
             row++;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < x; j++)
                col++;
            for (int j = 0; j < width; j++) {
                if(i==0 || i==height-1 || j == 0 ||
                        j == width-1)
                    canvas[row][col]=true;
                col++;
            }
            row++;
            col=0;
        }
    }
    public void drawRectangle2(int x, int y, int width, int height) {
        for (int i = 0; i < width; i++) {
            canvas[y][x + i] = true;
            canvas[y + height][x + i] = true;
        }
        for (int i = 0; i <=height; i++) {
            canvas[y + i][x] = true;
            canvas[y + i][x + width] = true;
        }
    }
    public void render(){
        for (int i=0;i<canvas.length;i++){
            for(int j=0;j<canvas[i].length;j++){
                System.out.print(canvas[i][j]?"*":" ");
            }
            System.out.println();
        }
    }


}

/*
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


}
*/
/*
class ElementCount{
    int element;
    int counter;
    public ElementCount(int element, int counter){
        this.counter=counter;
        this.element=element;
    }
}*/