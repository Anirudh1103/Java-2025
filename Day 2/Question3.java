import java.util.Scanner;

public class Question3 {
    /*
    Question 3: There are N bowls arranged on a table in a row. Each bowl contains some marbles
in such a way that the sum of the number of marbles in the first and the last bowl is equal to the
sum of the number of marbles in the second and the second last bowl, and so forth. The bowls
are kept in the increasing order of the number of marbles in it.
After some time,it is found that there are only N-1 bowls. The first and the last bowls are at their
positions, but one of the bowls in between has gone missing.
Find the number of marbles in the missing bowl, given that N%2==0.
Input Specification:
Input1: N-1, number of bowls.
Input2: Array of size N-1, storing a number of marbles in each bowl.
Output Specification:
Your function should return the number of marbles in the missing bowl.
Example 1:
Input1: 5
Input2: {1,3,5,9,11}
Output: 7

Example 2:
Input1: 5
Input2: {2,4,6,10,12}
Output: 8
     */
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        int NoBowls = ip.nextInt();
        int[] Bowls = new int[NoBowls];
        for(int i=0; i<NoBowls;i++)
            Bowls[i] = ip.nextInt();
        int Sum = Bowls[0] + Bowls[NoBowls-1];
        int Result = Sum - Bowls[(NoBowls/2)];
        System.out.println(Result);
    }
}
