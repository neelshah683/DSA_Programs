package Arrays;
import java.util.*;

public class spiralMatrix_3 {
    public static void main(String[] args) {
        int rows = 5, cols = 6, rStart = 1, cStart = 4;
        System.out.println(Arrays.deepToString(spiralMatrixIII(rows, cols, rStart, cStart)));
    }    
    public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {

        int[][] res = new int[rows * cols][2];
        int[] directions = {0, 1, 0, -1, 0};

        int steps = 0, distance = 0;
        int cntNums = 1;

        res[0] = new int[] {rStart, cStart};

        while(cntNums < rows * cols){
            if(distance == 0 || distance == 2)
                steps++;
            
            for(int indx = 0; indx < steps; indx++){
                rStart += directions[distance];
                cStart += directions[distance + 1];

                if(rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols)
                    res[cntNums++] = new int[] {rStart, cStart};
                
                if(cntNums == rows * cols)
                    return res;
            }
            distance = (distance + 1) % 4;
        }
        return res;
    }
}
