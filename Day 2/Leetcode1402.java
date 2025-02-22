import java.util.ArrayList;
import java.util.Scanner;

public class Leetcode1402 {
    /*
    import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Question4 {
    /*
    Question 4:
Monica has cooked N dishes and collected the data on the level of satisfaction for all the dishes
from a guest. The guest returns an array, where the ith element of the array is the liking level of
the ith dish, also the time taken to cook the ith dish, is i.
Like-to-time coefficient of a dish is calculated by multiplying the time taken to cook food by its
liking level, ie., i*input2[i]. The total like-to-time coefficient is calculated by summing up all
individual coefficients of dishes.
You want the total like-to-time coefficient to be maximum. You can also remove some dishes, in
which case, a new coefficient is calculated using the left dishes.
Find the maximum sum of all possible like to time coefficients.
Input specification:
Input1: N, number of dishes
Input2: Array representing the liking value of each dish
Output Specification:
Return maximum like to time coefficient possible
Example 1:

Input: satisfaction = [-1,-8,0,5,-9]
Output: 14
Explanation: After Removing the second and last dish, the maximum total like-time coefficient will be equal to (-1*1 + 0*2 + 5*3 = 14).
Each dish is prepared in one unit of time.
Example 2:

Input: satisfaction = [4,3,2]
Output: 20
Explanation: Dishes can be prepared in any order, (2*1 + 3*2 + 4*3 = 20)
Example 3:

Input: satisfaction = [-1,-4,-5]
Output: 0
Explanation: People do not like the dishes. No dish is prepared.

This question is similar to Question 4 but with small change that the food can be prepared in any order.
     */
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        int dishes = ip.nextInt();
        int[] Arr = new int[dishes];
        for(int i=0;i<dishes;i++)
            Arr[i] = ip.nextInt();
        System.out.println(maxSatisfaction(Arr));
    }
    public static int maxSatisfaction(int[] satisfaction) {
        int Max = findMax(satisfaction);
        int Result = 0;
        boolean isPositive = isAllPositive(satisfaction);
        boolean isNegative = isAllNegative(satisfaction);
        if(isNegative) return 0;
        if(isPositive)
            return calculateRatio(satisfaction);
        ArrayList<Integer> FilteredList = new ArrayList<>();
        int compValue = Max - (Max * 2);
        for(int i=0; i<satisfaction.length;i++)
        {
            if(satisfaction[i] >= compValue) {
                FilteredList.add(satisfaction[i]);
            }
        }
        int[] arr = new int[FilteredList.size()];
        for(int i =0; i<FilteredList.size();i++)
            arr[i] = FilteredList.get(i);
        Result = calculateRatio(arr);
        return Result;

    }
    public static int findMax(int[] satisfaction)
    {
        int max = satisfaction[0];
        for(int i=0; i<satisfaction.length;i++)
            if(satisfaction[i] > max) max = satisfaction[i];
        return max;
    }
    public static boolean isAllPositive(int[] arr)
    {
        for(int i=0; i< arr.length;i++)
            if(arr[i]<0) return false;
        return true;
    }
    public static boolean isAllNegative(int[] arr)
    {
        for(int i=0; i< arr.length;i++)
            if(arr[i]>0) return false;
        return true;
    }
    public static int calculateRatio(int[] arr)
    {
        int sum = 0;
        /*
        Sorting the array elements in Ascending order such that the highest element
        of the array gets multiplied with highest i value
        */
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {  // Last i elements are already sorted
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for(int i=0; i< arr.length;i++)
            sum += (i + 1) * arr[i];
        return sum;
    }
}
//76 83 55 -36 -8 40 -60 -72 27 -32 37 1 77 24 -46 -26 20 -89 -35 -99 58 -7