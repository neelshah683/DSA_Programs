import java.util.Arrays;

public class flippingImage {
    
    public static void main(String[] args) {
        
        int[][] image = 
        {
            {1, 1, 0},
            {1, 0, 1},
            {0, 0, 0}
        };
        flipAndInvertImage(image);
    }
        public static void flipAndInvertImage(int[][] image) {
            for(int i=0;i<image.length;i++)
            {
                int end = image[i].length-1;
                for(int j=0;j<image[i].length;j++)
                {
                    if (j <= end - j) {
                        int temp = 1-image[i][j];
                        image[i][j] = 1-image[i][end - j];
                        image[i][end - j] = temp;
                    }
                }
            }
            System.out.println(Arrays.deepToString(image));
        }
    
}
