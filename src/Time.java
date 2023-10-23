public class Time {
    public static double timeStarted = System.nanoTime();
    //method returns current time moment
    public static double getTime(){
        return (System.nanoTime()-timeStarted)*1E-9;
    }
}
