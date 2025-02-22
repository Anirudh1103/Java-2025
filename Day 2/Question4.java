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
Example1:
Input1: 3
Input2:{-1,3,4}
Output: 17

Example2:
Input1: 5
Input2:{-1,-9,0,5,-7}
Output: 14

     */
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        int dishes = ip.nextInt();
        int[] Arr = new int[dishes];
        for(int i=0;i<dishes;i++)
            Arr[i] = ip.nextInt();
        System.out.println(maxSatisfaction(Arr));
    }
    //Continue from here
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
            if(satisfaction[i] > compValue) {
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
        for(int i=0; i< arr.length;i++)
            sum += (i+1)*arr[i];
        return sum;
    }
    }
