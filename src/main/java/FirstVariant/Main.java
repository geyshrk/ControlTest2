package FirstVariant;

public class Main {
    public static void main(String[] args) {
        TodayProgram todayProgram = new TodayProgram();
        todayProgram.printAllSorted();
        todayProgram.printAllByName("Матч");
        System.out.println();
        todayProgram.printAllNowByChannel(new BroadcastsTime("15:09"), "#Матч!");
        System.out.println();
        todayProgram.printAllByPeriod("#Матч!", new BroadcastsTime("10:09"), new BroadcastsTime("20:09"));
    }
}
