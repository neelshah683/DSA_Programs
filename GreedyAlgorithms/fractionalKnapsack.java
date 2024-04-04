package GreedyAlgorithms;

import java.util.Arrays;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
public class fractionalKnapsack {
    
    public static void main(String[] args) {
        int n = 3, W = 50;
        Item[] arr = new Item[n];
        arr[0] = new Item(60, 10);
        arr[1] = new Item(100, 20);
        arr[2] = new Item(120, 30);
        System.out.println(fractionalKnapsack(W, arr, n));
    }
    public static double fractionalKnapsack(int W, Item arr[], int n) 
    {
         Arrays.sort(arr,(a,b)->{
            return Double.compare((double)b.value/(double)b.weight,(double)a.value/(double)a.weight);
        });        

        double res = 0.0;
        int currWgt = 0;
        for(int indx = 0; indx < n; indx++){
            if(currWgt + arr[indx].weight <= W){
                currWgt += arr[indx].weight;
                res += arr[indx].value;
            }
            else{
                int remain = W - currWgt;
                res += ((double)arr[indx].value / (double)arr[indx].weight) * (double)remain;
                break;
            }
        }
        return res;
    }
}
