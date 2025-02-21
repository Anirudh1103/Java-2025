public class NumberOfSeconds {
    /*
    Task here is to calculate the total number of  seconds in a day
    we need to write the logic in expression form
     */
    public static void main(String[] args) {
        int hour = 24, min = 60, sec = 60;
        /*
        A day has 24 hours and each hour has 60 minutes and each minute has 60 sec
         */
        int totalSeconds = hour * min * 60;
        System.out.println("Total Seconds in a day: " + totalSeconds);
    }
}
