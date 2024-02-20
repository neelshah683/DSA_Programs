package Stack_Queues;
import java.util.Stack;
public class celebrityProblem {
    
    public static void main(String[] args) {
        int[][] M = {
            {0, 1, 0},
            {0, 0, 0},
            {0, 1, 0}
        };
        int n = 3;
        System.out.println(celebrity1(M, n));
    }
    //TC: O(N) Optimized Solution
    public static int celebrity1(int M[][], int n)
    {
    	Stack<Integer> st = new Stack<>();
    	
    	for(int index = 0; index < n; index++)
    	    st.push(index);
    	 
    	while(st.size() > 1){
    	    int ind1 = st.pop();
    	    int ind2 = st.pop();
    	    if(chkCeleb(M, ind1, ind2)) st.push(ind2);
    	    else    st.push(ind1);
    	}
    	int celeb = st.pop();
    	return (chkRow(M, celeb, n) && chkCol(M, celeb, n)) ? celeb : -1;
    }
    public static boolean chkCeleb(int[][] arr, int ind1, int ind2){
        return arr[ind1][ind2] == 1 ? true : false;
    }
    //TC: O(N^2)
    public static int celebrity(int M[][], int n)
    {
    	for(int index = 0; index < n; index++){
    	    if(chkRow(M, index, n) && chkCol(M, index, n))
    	        return index;
    	}
    	return -1;
    }
    public static boolean chkRow(int[][] arr, int rowIndex, int size){
        
        for(int index = 0; index < size; index++){
            if(arr[rowIndex][index] == 1)
                return false;
        }
        return true;
    }
    public static boolean chkCol(int[][] arr, int indexCol, int size){
        for(int index = 0; index < size; index++){
            if(index == indexCol) continue;
            if(arr[index][indexCol] == 0)
                return false;
        }
        return true;
    }
}
