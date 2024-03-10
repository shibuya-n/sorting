import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    // Generate random array of 1000 integers, take the average run time of and rank the 3 sorting algorithms

    static ArrayList<Integer> x = new ArrayList<>();

    public static void loadArray(){
        for (int i = 0;i < 1000; i++){
            int rand = (int)(Math.random()*100) + 1;
            x.add(i, rand);
        }
    }

    public static void main(String[] args) {

        loadArray();


        double bubbleTotal = 0;
        double selectionTotal = 0;
        double mergeTotal = 0;
        for (int i = 0; i < 5; i++){


            long bubbleStart = System.nanoTime();
            bubbleSort(x);
            long bubbleEnd = System.nanoTime();
            bubbleTotal = bubbleEnd - bubbleStart;

            long selectionStart = System.nanoTime();
            selectionSort(x);
            long selectionEnd = System.nanoTime();
            selectionTotal = selectionEnd - selectionStart;

            long mergeStart = System.nanoTime();
            mergeSort(x, x.size());
            long mergeEnd = System.nanoTime();
            mergeTotal = mergeEnd - mergeStart;

        }
        System.out.println("bubble average: " + (bubbleTotal/5));
        System.out.println("selection average: " + (selectionTotal/5));
        System.out.println("merge average: " + (mergeTotal/5));
    }

    public static void selectionSort(ArrayList<Integer> input){

        ArrayList<Integer> tempArray;
        tempArray = input;

        for (int i = 0; i < tempArray.size(); i++){
            int minIndex = i;

            for(int j = i+1; j< tempArray.size(); j++){
                if (tempArray.get(j) < tempArray.get(minIndex)){
                    minIndex = j;
                }
            }

            int temp = tempArray.get(minIndex);
            tempArray.set(minIndex, tempArray.get(i));
            tempArray.set(i, temp);
        }

        System.out.println(tempArray);
    }

    public static void bubbleSort(ArrayList<Integer> input){
        ArrayList<Integer> tempArray;
        tempArray = input;

        for (int i = 0; i < tempArray.size(); i++){
            for (int j = i+1; j < tempArray.size(); j++){
                if (tempArray.get(i) > tempArray.get(j)){
                    int temp = tempArray.get(i);
                    tempArray.set(i, tempArray.get(j));
                    tempArray.set(j, temp);
                }
            }
        }
        System.out.println(tempArray);

    }
    public static void mergeSort(ArrayList<Integer> input, int n) {
        ArrayList<Integer> tempArray = input;


        if (n >= 2) {
            int mid = n / 2;
            ArrayList<Integer> leftArray = new ArrayList<>(Collections.nCopies(mid, 0));
            ArrayList<Integer> rightArray = new ArrayList<>(Collections.nCopies(n-mid, 0));
            for (int i = 0; i < mid; i++) {
                leftArray.set(i, x.get(i));
            }
            for (int i = mid; i < n; i++) {
                rightArray.set(i - mid, input.get(i));
            }
            mergeSort(leftArray, mid);
            mergeSort(rightArray, n - mid);

            merge(input, leftArray, rightArray, mid, n - mid);
        } else {
            return;
        }
    }

        public static void merge(ArrayList<Integer> input, ArrayList<Integer> leftArray, ArrayList<Integer> rightArray, int l, int r){
            int i = 0 ;
            int j = 0;
            int k = 0;

            while (i < l && j < r){
                if (leftArray.get(i) <= rightArray.get(j)){
                    input.set(k++, leftArray.get(i++));
                }else{
                    input.set(k++, rightArray.get(j++));
                }
            }
            while ( i < l){
                input.set(k++, leftArray.get(i++));
            }
            while (j < r){
                input.set(k++,rightArray.get(j++));
            }
            System.out.println(input);
        }


    }
