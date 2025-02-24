public class CreatingMethod {
    /*
    Method: Method is a name given to block of code which needs to be executed again and again.
    Let's say in a program we want to perform a specific task multiple times we can achieve that using methods
     */
    public static void main(String[] args) {
        printMultiplicationTable(5);
    }
    static void printMultiplicationTable(int n)
    {
        for(int i=1;i<=10;i++)
            System.out.println(n + " * " + i + " = " + (n*i));
    }
}
