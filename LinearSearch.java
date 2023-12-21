public class LinearSearch {
    
    public static void main(String[] args) {
        
        int[] arr = {5, 2, 7, 10, 15, 20};
        int target = 7;
        linear_search(arr, target);
    }
    public static void linear_search(int[] a, int target)
    {
        if(a.length == 0)
        {
            System.out.println("Element Not Present:");
            return ;
        }
        for(int i=0;i<a.length;i++)
        {
            if(a[i] == target)
            {
                System.out.println("Element "+a[i]+" Found at position:"+(i+1));
                return ;
            }
        }
        System.out.println("Element Not Found:");
    }
}
