import java.util.Scanner;

public class StringyGame {
    /*
    Description
You are playing a game with your friend.

This game consists of a string, consisting only of english letters. During a player's turn, he/she should choose two consecutive equal letters in the string and delete them.

Eg: if the string is equal to "abbcd" than there is only one possible move: delete "bb", the string will then become "acd".

The player not able to make a turn loses.

Your task is to determine whether you will win if both you and your friend play optimally.

The game always starts with your turn first.

Input
The only line contains the string s, consisting of english letters. The string's length will be in range of 1 to 100000 (both inclusive)

Output
Output One word string

"Yes" if you are going to win

"No" if you are not going to win

Sample input
lgsdy
weep
noon
Sample output
No
Yes
No
Explanation
Case 1: You are unable to make a turn, so you lose.

Case 2: You can remove "ee", and remaining string will be "wp", your friend is unable to make a move, so you win.

Case 3: You remove "oo", then friend removes "nn", then the string is empty, thus you cannot make a move, so you lose.
     */
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        String s = ip.next();
        System.out.println(playGame(s));
    }
    static String playGame(String s)
    {
        if(s.length() == 1)return "No";
        boolean flag = isAllUnique(s.toCharArray());
        if(flag)
            return "Yes";
        else
        {
            s = removeUnique(s.toCharArray());
            flag = isAllUnique(s.toCharArray());
            if(flag)
                return "Yes";
        }
        return "No";
    }
    static boolean isAllUnique(char[] str)
    {
        for(int i=0; i< str.length;i++)
            for(int j=i+1;j< str.length;j++)
                if(str[i] == str[j]) return false;
        return true;
    }
    static String removeUnique(char[] str)
    {
        StringBuilder result = new StringBuilder();
        for(char i:str)
            result.append(i);
        for(int i=0; i<result.length();i++)
            if(result.charAt(i) == result.charAt(i+1))
            {
                result.delete(i,i+2);
                break;
            }
        return result.toString();
    }
}
