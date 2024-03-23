package FirstVariant;

public class Main {
    public static void main(String[] args) {
        TodayProgram todayProgram = new TodayProgram();
        todayProgram.printAllSorted();
        todayProgram.printAllByName("Матч");
        todayProgram.printAllNowByChannel(new BroadcastsTime("15:09"), "#Матч!");

    }
}
