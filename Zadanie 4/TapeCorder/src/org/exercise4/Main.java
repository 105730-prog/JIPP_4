package org.exercise4;

public class Main {
    public static void main(String[] args)
    {
        TapeRecorder tapeRecorder = new TapeRecorder("Black"); 

        tapeRecorder.setCurrentVolume(20);
        tapeRecorder.setCurrentTrack(45);

        tapeRecorder.volDown(); 
        tapeRecorder.volDown();
        tapeRecorder.volUp();

        tapeRecorder.fastForward();
        tapeRecorder.rewind();
        tapeRecorder.fastForward();

        System.out.println("Volume : " + tapeRecorder.getCurrentVolume());
        System.out.println("Counter : " + tapeRecorder.getCurrentTrack());
        System.out.println();
        System.out.println(tapeRecorder.getColor());
    }
}
