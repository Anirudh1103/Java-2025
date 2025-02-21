public class NumberOfMinutes {
    /*
    The task here is to write an expression that would calculate Number of Minutes in a day
     */
    public static void main(String[] args) {
        int hours = 24, min = 60;
        /*
        In one day there are 24 hours and each hour has 60  min by multiplying it we can get the totalHours
         */
        int totalHours = hours * min;
        System.out.println("The total hours in a day is: " + totalHours);
    }
}
