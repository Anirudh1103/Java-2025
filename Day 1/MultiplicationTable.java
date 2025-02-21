import java.util.Scanner;

public class MultiplicationTable {
    /*The task here is to print the multiplication table of 5 in formatted manner
    The Format is: 5 X 1 = 5
     */
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int num = ip.nextInt();
        for(int i=1; i<=10; i++)
            System.out.println(num + " X " + i + " = "+(num*i));

    }
}
