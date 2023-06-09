package org.exercise4;

import java.util.List;

public class TapeRecorder {
    private static final int Width_in_cm = 50; 
    private static final int Heigth_in_cm = 35;
    private static final int Depth_in_cm = 30;

    private  static final List<String> Buttons = List.of("Play","Stop", "Pause", "Record", "Rewind",
            "FastForward", "VolUp", "VolDown");
    private final String color;

    private int currentVolume;
    private int currentTrack;

    public TapeRecorder(String color){

        this.color = color;
    }
    public void volUp(){

        currentVolume++;
    }
    public void volDown(){

        currentVolume--;
    }
    public void rewind(){

        currentTrack--;
    }
    public void fastForward(){

        currentTrack++;
    }
    public int getCurrentVolume(){

        return currentVolume;
    }

    public int getCurrentTrack(){

        return currentTrack;
    }

    public void setCurrentVolume(int volume){  
        currentVolume = volume;
    }

    public void setCurrentTrack(int track){
        currentTrack = track;
    }

    public String getColor(){
        return color;
    }

}
