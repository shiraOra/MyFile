package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code here
     /*   long now= System.currentTimeMillis();
        Random random=new Random(now);
        for(int i=0;i<5;i++)
            System.out.println(random.nextInt(345)+",");*/
            int arr[]=new int[]{4,3,6,9,5,2,1,17,29,45,33,21,82,81};
        System.out.println(quickSelectTeacher(arr,3,0,arr.length));

    }


static void bubbleSort(int[]arr){
        int upTo= arr.length-1;
        boolean isSorted=false;
        while (!isSorted){
            isSorted=true;
            for (int i=0;i<upTo;i++){
                if(arr[i]>arr[i+1]){
                    int temp=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                    isSorted=false;
                }
            }
            upTo--;
        }
    }
    static void insertSort(int arr[]){
    for(int i=1;i<arr.length;i++){
        int key=arr[i];
        int j=i-1;
        while(j>=0 && arr[j]>key){
            arr[j+1]=arr[j];
            j--;
        }
        arr[j+1]=key;
    }
    }
  /*  static void merge(int []arr, int l, int m,int r){
        int n1=m-l+1;
        int n2=r-m;
        int[]L=new int[n1];
        int []R=  new int[n2];
        for(int i=0;i<n2;i++){
            R[i]=arr[m+1+i];
        }
        int i=0,j=0;
        int k=l;
        while(i<n1&& j<n2){
            if(L[i]<=R[j]){
                arr[k]=L[i];
                j++;
            }
            else{
                arr[k]=R[j];
                j++;
            }
            k++;
        }
        while (i<n)

    }*/
    static int binarySearch(int[] arr, int left, int right, int x){
           	if(right >= left){
            	int middle = left + (right-left)/2;
            	if(arr[middle] == x)
            			return middle;
            	if(arr[middle] < x)
            			return binarySearch(arr, middle+1, right, x);
            	return binarySearch(arr, left, middle-1, x);
            }
          	return -1;
       	}


 /*      	static void bubbleSort(int[] arr){
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

         	static void insertionSort(int arr[]){
        		for (int i = 1; i < arr.length; i++) {
            			int key = arr[i];
            			int j = i-1;
            			while(j>=0 && arr[j] > key){
         				arr[j+1] = arr[j];
         				j--;
         			}
         		arr[j+1] = key;
         	}
 	}

 +	static void merge(int[] arr, int l, int m, int r){
 		int n1 = m-l+1;
 		int n2 = r-m;
 		int[] L = new int[n1];
 		int[] R = new int[n2];
 		for (int i = 0; i < n1; i++) {
    +			L[i] = arr[l + i];
    +		}
 		for (int i = 0; i < n2; i++) {
    +			R[i] = arr[m + 1 + i];
    +		}
 	int i=0, j=0;
 	int k = l;
 	while (i<n1 && j<n2){
 +			if(L[i] <= R[j]){
     +				arr[k] = L[i];
     +				i++;
     +			}else{
     +				arr[k] = R[j];
     +				j++;
     +			}
 +			k++;
 +		}
 	while(i<n1){
 +			arr[k] = L[i];
 +			i++;
 +			k++;
 +		}
 	while(j<n2){
 +			arr[k] = R[j];
 +			j++;
 +			k++;
 +		}
 }



   static void printArray(int[] arr){
 	System.out.print("{");
 	for (int i = 0; i < arr.length; i++) {
 +			System.out.print(arr[i]);
 +			if(i<arr.length-1)
     +				System.out.print(",");
 +		}
 	System.out.println("}");
 }
 */



    static int partition(int[] arr, int low, int high){
        if (high==low)
            return low;
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if(arr[j] <= pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }

    static void quicksort(int []arr ,int low,int high){
        if (low< high) {
            int pi = partition(arr, low, high);
            quicksort(arr,low,pi-1);
            quicksort(arr,pi+1,high);
        }
    }

    static int randomizedPartition(int[]arr,int low, int high){
        Random random =new Random(System.currentTimeMillis());
        int pos=low+random.nextInt(high-low);
        int temp=arr[high];
        arr[high]=arr[pos];
        arr[pos]=temp;
        return partition(arr,low,high);

    }
//פונקציה המקבלת מערך ומספר K מי הוא האיבר הK בגודלו במערך
    static int quickSelect(int []arr, int k, int low, int high)
    {
            int p=partition(arr,0,arr.length);
              if(p==k)
                  return arr[k-1];
              if(p>k)

                 return quickSelect(arr,k,0,p);
              else
                  return quickSelect(arr,k-p,p,arr.length);


    }
   //The teacher's function
   static int quickSelectTeacher(int []arr, int l, int r, int k){
        if(k>0 &&k<= r-l+1) {
            int pos = randomizedPartition(arr, l, r);
            if (pos + l == k - 1)
                return arr[pos];
            if (pos - l > k - 1)
                return quickSelectTeacher(arr, l, pos - 1, k);

            return quickSelectTeacher(arr, pos + 1, r, k - pos + l - 1);
        }
        return Integer.MAX_VALUE;

        }
    }





