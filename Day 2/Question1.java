import java.util.Scanner;
public class Question1 {
    /*
Question 1: There is an F1 race going on and there is just one pit crew for a team. There are X
racers. There is a position matrix, which contains the current position of each of these X racers
and the endpoint, till which point the fuel will get over. Pit crew can put their pit location to just
one place. What is the maximum number of racers the pit crew team can attend to?
Note:
The cars cannot be refueled in pits once their fuel gets over.
Input Specification:
Input1: X, number of racers.
Input2: Position matrix of X racers.
Output Specification:
Return a maximum number of racers that can be serviced, setting up just one pit crew.
Example1:
Input1: 4
Input2: {{1,3},{2,5},{2,4},{3,5}}
Output: 3

Example2:
Input1: 5
Input2: {{1,7},{2,4},{6,9},{3,8},{5,10}}
Output: 4
 */
    /*
    Explanation:
    X -> Number of racers
    Position -> Integer Matrix consisting of starting and end point there it has to be [X-1][2] matrix
    Array representation
    [
        00, 01
        10, 11
        20, 21
        30, 31
    ]
    We need to determine MAXIMUM CARS that crew can attend at a single point
     */
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        int X = ip.nextInt();
        int[][] Position = new int[X][2];
        int MaxPits = 0,StartingPoint = 0;
        for (int i=0; i<X; i++)
            for(int j=0; j<2;j++) {
                Position[i][j] = ip.nextInt();
                if(Position[i][1] > MaxPits)MaxPits = Position[i][1];
                if(Position[i][0] > StartingPoint) StartingPoint = Position[i][0];
            }
        int MaxCarSevered = 0;
        for(int i=StartingPoint; i<MaxPits; i++)
        {
            int count = 0;
            for(int j=0; j<X;j++)
            {
                if(Position[j][1] > StartingPoint)
                    count++;
            }
            if(count > MaxCarSevered)MaxCarSevered = count;
        }
        System.out.println(MaxCarSevered);
    }
}
