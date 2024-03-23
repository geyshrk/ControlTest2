package FirstVariant;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;

import static java.nio.file.Files.readAllLines;

public class TodayProgram {
    Map<String, List<TVProgram>> programsByChannel;
    List<TVProgram> allPrograms;
    public TodayProgram(){
        List<String> readedFile;
        try {
            readedFile = Files.readAllLines(new File("schedule.txt").toPath(), Charset.defaultCharset());
            createMapAndList(readedFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void printAllSorted(){
        for (TVProgram program : allPrograms){
            System.out.println(program);
        }
    }
    public void printAllNow(BroadcastsTime time){
        for (String channel : programsByChannel.keySet()){
            System.out.println(findNow(time, programsByChannel.get(channel)));
        }
    }
    public void printAllByName(String name){
        for (TVProgram program : allPrograms){
            if (program.getName().contains(name)) System.out.println(program);
        }
    }
    public void printAllNowByChannel(BroadcastsTime time, String channel){
        System.out.println(findNow(time, programsByChannel.get(channel)));
    }
    public void printAllByPeriod(String channel, BroadcastsTime start, BroadcastsTime end){
        List<TVProgram> programs = programsByChannel.get(channel);
        int countOfPrograms = programs.size();
        int index = -1;
        while (index != countOfPrograms){
            if (programs.get(index).getTime().before(start)) index++;
        }
        while (index != countOfPrograms && programs.get(index).getTime().before(end)){
            System.out.println(programs.get(index++));
        }
        if (index == countOfPrograms){
            System.out.println("Нет программ");
        }
    }
    private void createMapAndList(List<String> readedFile){
        programsByChannel = new HashMap<>();
        allPrograms = new ArrayList<>();
        String currChannel = "";
        for (int i = 0; i < readedFile.size(); ++i){
            if (readedFile.get(i).charAt(0) == '#') {
                currChannel = readedFile.get(i);
                programsByChannel.put(readedFile.get(i), new ArrayList<>());
            }
            else {
                System.out.println(readedFile.get(i));
                TVProgram currProgram = new TVProgram(currChannel, new BroadcastsTime(readedFile.get(i)), readedFile.get(++i));
                programsByChannel.get(currChannel).add(currProgram);
                allPrograms.add(currProgram);
            }
        }
        Comparator<TVProgram> comparator = new Comparator<TVProgram>() {
            @Override
            public int compare(TVProgram o1, TVProgram o2) {
                return o1.getTime().compareTo(o2.getTime());
            }
        };
        allPrograms.sort(comparator);
        for (String channel : programsByChannel.keySet()){
            programsByChannel.get(channel).sort(comparator);
        }

    }
    private TVProgram findNow(BroadcastsTime time, List<TVProgram> programs){
        for (int i = 0; i < programs.size() - 1; i++){
            if (time.between(programs.get(i).getTime(), programs.get(i + 1).getTime())){
                return programs.get(i);
            }
        }
        return programs.get(programs.size() - 1);
    }
}
