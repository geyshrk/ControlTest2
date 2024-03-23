package FirstVariant;

public class TVProgram {
    private String channel;
    private String name;
    private BroadcastsTime time;
    public TVProgram(String channel, String name, BroadcastsTime time){
        this.channel = channel;
        this.name = name;
        this.time = time;
    }
    public String toString(){
        return channel + " " + name + " " + time;
    }
    public BroadcastsTime getTime(){
        return time;
    }
    public String getName(){
        return name;
    }
}
