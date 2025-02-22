import java.util.Scanner;

public class Question2 {
    /*
    Question no2:
Harold and Dan are friends and study in the same class. One day, they strike a deal about
completing Harold's homework.
The deal is that for every piece of homework belonging to Harold that dan completes, Harold will
give Dan some money. The catch is that every piece of homework has a deadline associated
with it and has to be completed within that deadline only.
It takes 1 unit amount of time to complete homework. You have to help Dan. Find and return the
maximum money he can earn.
Input Specification:
Input1: The number of tasks
Input2: An array representing money associated with each task.
Input3: An array representing the deadline of each task
Output Specification:
Your function must return the maximum amount of money, Dan can earn
Example 1:
Input1: 3
Input2: {20,54,41}
Input3: {3,4,5}
Output: 115

Example 2:
Input1: 3
Input2: {60,40,80}
Input3: {1,2,2}
Output: 140
     */

    /*
    Explanation:
    - In Example 1 all homeworks can be done as all have different deadlines
    - In Example 2 there are 2 tasks that have same deadline therefore only one among them can be completed
     */
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        int tasks = ip.nextInt();
        int[] Money = new int[tasks];
        int[] Deadline = new int[tasks];
        for(int i=0; i<tasks;i++)
            Money[i] = ip.nextInt();
        for(int i=0; i<tasks;i++)
            Deadline[i] = ip.nextInt();
        boolean Duplicate = findDuplicate(Deadline);
        int MaxMoney = 0;
        if(Duplicate)
            RemoveDuplicates(Money, Deadline);
        for(int i=0; i<tasks;i++)
            MaxMoney += Money[i];

        System.out.println(MaxMoney);
    }
    public static boolean findDuplicate(int[] Deadline)
    {
        for(int i=0;i<Deadline.length; i++)
        {
            for(int j=i+1; j< Deadline.length;j++)
                if(Deadline[i] == Deadline[j])
                    return true;
        }
        return false;
    }
    public static void RemoveDuplicates(int[] Money, int[] Deadline)
    {
        for(int i=0;i<Deadline.length; i++)
            for(int j=i+1; j< Deadline.length;j++)
                if(Deadline[i] == Deadline[j])
                {
                    if(Money[i] > Money[j])
                        Money[j] = 0;
                    else Money[i] = 0;
                }
    }
}
